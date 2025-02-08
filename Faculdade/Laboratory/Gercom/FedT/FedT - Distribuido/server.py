from concurrent import futures
import time
import datetime

import utils
from fedforest import FedForest

import grpc
import fedT_pb2
import fedT_pb2_grpc

from sklearn.ensemble import RandomForestRegressor
from sklearn.metrics import mean_absolute_error

def importar_parametros_de_teste():
    with open("/home/juliocoliveira/Área de Trabalho/Rede Distribuida/gRPC/FedT - Distribuido/parametros_de_teste.txt", "r") as f:
        file = f.read()
    file = file.split("\n")
    print(f"Strategy: {file[0]}\nRound: {file[1]}")
    return file


parametros = importar_parametros_de_teste()

IP = "10.126.1.109"
#IP = "192.168.1.214"
PORTA = "50051"

##########################################################################
# Parametros: ============================================================
##########################################################################
# O random se sai bem com 270
# O threshold se sai bem a partir de 520
STRATEGY = parametros[0]
THRESHOLD = 0.34
TREES_BY_CLIENT = 300 #Original 260, # 3 Clientes: ; 4 Clientes: 480.
INCREASE_TREES = 10
NUCLEOS_DISPONIVEIS = 4
NUMBER_OF_EXPECTED_CLIENTS = 4

PRINT_SENDED_TREES = 50

##########################################################################
# Server: ================================================================
##########################################################################
def add_end_time(runtime_clients, ID, end_time):
    """
    ### Função:
    Adicionar o tempo em que a execução foi finalizada à lista.
    ### Args:
    - Runtime Clients: Uma lista que contém o ID do cliente e o tempo em que ele iniciou a execução.
    - ID: O ID que deve ser procurado na lista.
    - End Time: O tempo em que a execução foi encerrada.
    ### Returns:
    - Runtime Clients: Lista com o tempo de fim da execução já adicionado.
    """
    idx = 0
    for i, runtime in enumerate(runtime_clients):
        if runtime[0] == ID:
            idx = i

    runtime_clients[idx][1] = [runtime_clients[idx][1], end_time]
    return runtime_clients

def sum_runtime(runtime_list):
    """
    ### Função:
    Somar os tempos de execução.
    ### Args: 
    - Runtime List: Lista com os tempos de execução.
    ### Returns:
    - Sum Runtime: Resultado da soma dos tempos de execução.
    """
    contador = datetime.timedelta()
    for runtime in runtime_list:
        contador += runtime

    return contador

def average_runtime(runtime_clients):
    """
    ### Função:
    Calcular a média do tempo de execução dos clientes.
    ### Args:
    - Runtime Clients: Lista com os IDs e tempo de execuções.
    ### Returns:
    - Runtime Average: Tempo de execução médio
    """
    runtime_list = []
    for runtime in runtime_clients:
        runtime_list.append(runtime[1][1] - runtime[1][0])
    runtime_sum = sum_runtime(runtime_list)
    runtime_average = runtime_sum/NUMBER_OF_EXPECTED_CLIENTS
    return runtime_average


class FedT(fedT_pb2_grpc.FedTServicer):
    def __init__(self) -> None:
        super().__init__()
        self.model = RandomForestRegressor(n_estimators=TREES_BY_CLIENT)
        data_train, label_train = utils.load_dataset_for_server()
        utils.set_initial_params(self.model, data_train, label_train)

        self.global_trees = self.model.estimators_
        self.strategy = FedForest(self.model)

        self.clientes_conectados = []
        self.clientes_esperados = NUMBER_OF_EXPECTED_CLIENTS
        self.clientes_respondidos = 0
        self.trees_warehouse = []
        self.aggregation_realised = 0

        self.runtime_clients = []
        self.runtime_average = 0

    def aggregate_strategy(self, best_forests: list[RandomForestRegressor], threshold=0.3):
        if STRATEGY == 'random':
            self.model.estimators_ = self.strategy.aggregate_fit_random_trees_strategy(best_forests)
        elif STRATEGY == 'best_trees':
            self.model.estimators_ = self.strategy.aggregate_fit_best_trees_strategy(best_forests)
        elif STRATEGY == 'threshold':
            self.model.estimators_ = self.strategy.aggregate_fit_best_trees_threshold_strategy(best_forests, threshold)
        elif STRATEGY == 'best_forests':
            self.model.estimators_ = self.strategy.aggregate_fit_best_forest_strategy(best_forests)

    def aggregate_trees(self, request_iterator, context):
        """
        ### Função:
        Criar uma nova floresta com as árvores escolhidas, o critério de seleção depende do modod escolhido.
        ### Args:
        - Request: Mensagem do cliente, contém as árvores dele e o ID.
        - Context: Variável padrão da função gerada pelo gRPC.
        ### Returns:
        - Server Message: Contém as árvores selecionadas.
        """

        print("Recebendo as árvores dos clientes")

        client_serialised_trees = []
        for request in request_iterator:
            client_ID = request.client_ID
            client_serialised_trees.append(request.serialised_tree)
                
        client_trees = utils.deserialise_several_trees(client_serialised_trees)
        self.trees_warehouse.append(client_trees)

        print(f"Árvores do Client ID: {client_ID} recebidas")

        while (len(self.clientes_conectados) >= self.clientes_esperados) == False:
            if client_ID not in self.clientes_conectados:
                self.clientes_conectados.append(client_ID)

        print(f"Todos os clientes se conectaram. Client ID: {client_ID}.")

        while True:
            if self.aggregation_realised == 0:
                self.aggregation_realised = 1
                print(f"Iniciando a Agregação. Requisição realizada pelo Client ID: {client_ID}")
                self.aggregate_strategy(self.trees_warehouse)
                print("Agregação Finalizada.")
                self.aggregation_realised = 2
                break
            elif self.aggregation_realised == 1:
                time.sleep(15)
            else:
                break

        serialised_global_trees = utils.serialise_several_trees(self.model.estimators_)
        number_of_trees = len(serialised_global_trees)
        number_of_sended_trees = 0

        server_reply = fedT_pb2.Forest_Server()
        for tree in serialised_global_trees:
            if number_of_sended_trees % PRINT_SENDED_TREES == 0:
                print(f"Client ID: {client_ID}\nÀrvore {number_of_sended_trees} de {number_of_trees} enviada.")
            number_of_sended_trees += 1
            server_reply.serialised_tree = tree
            yield server_reply

    def end_of_transmission(self, request, context):
        """
        ### Função:
        Avisar ao servidor que o processo já foi concluído e resetar o estado do server.
        ### Args:
        - Request: Mensagem de requisição que foi enviada pelo cliente, com o client ID.
        - Context: Variável padrão da função gerada pelo gRPC.
        ### Returns:
        - Server Message: Ok, confirmação de que a mensagem foi recebida.
        """
        end_time = datetime.datetime.now()
        self.runtime_clients = add_end_time(self.runtime_clients, request.client_ID, end_time)
        self.clientes_respondidos += 1

        if self.clientes_respondidos == NUMBER_OF_EXPECTED_CLIENTS:
            print("\n")
            for i in self.runtime_clients:
                print(f"Client ID: {i[0]}, Tempo de Execução: {i[1][1] - i[1][0]}")
            print("\n")
            print(f"Tempo de Execução Médio: {average_runtime(self.runtime_clients)}")
            print("\n")
            self.reset_server()

        answer = fedT_pb2.OK()
        answer.ok = 1
        return answer
    
    def get_server_model(self, request, context):
        """
        ### Função:
        Obter as árvores que compõe o modelo de floresta do servidor.
        ### Args:
        - Request: Mensagem de requisição que foi enviada pelo cliente, com o client ID.
        - Context: Variável padrão da função gerada pelo gRPC.
        ### Returns:
        - Server Message: Árvores serializadas em bytes.
        """
        start_time = datetime.datetime.now()
        self.runtime_clients.append([request.client_ID, start_time])

        print(f"Client ID: {request.client_ID}, requisitando o modelo do servidor.")
        trees = utils.get_model_parameters(self.model)
        serialised_trees = utils.serialise_several_trees(trees)
        server_message = fedT_pb2.Forest_Server()
        for serialise_tree in serialised_trees:
            server_message.serialised_tree = serialise_tree
            yield server_message
    
    def get_server_settings(self, request, context):
        """
        ### Função:
        Obter os parâmetros do ambiente.
        ### Args:
        - Request: Mensagem de requisição que foi enviada pelo cliente, com o client ID.
        - Context: Variável padrão da função gerada pelo gRPC.
        ### Returns:
        - Server Message: Contém o trees by client, váriavel que define o número de árvores por cliente.
        """
        print(f"Client ID: {request.client_ID}, solicitando as configurações.")
        server_reply = fedT_pb2.Server_Settings()
        server_reply.trees_by_client = TREES_BY_CLIENT
        return server_reply
    
    def reset_server(self):
        """
        ### Função:
        Resetar o server, todas as váriaveis retornarão ao seu valor inicial.
        ### Args:
        - None
        ### Returns:
        - None
        """
        self.model = RandomForestRegressor(n_estimators=TREES_BY_CLIENT)
        data_train, label_train = utils.load_dataset_for_server()
        utils.set_initial_params(self.model, data_train, label_train)

        self.global_trees = self.model.estimators_
        self.strategy = FedForest(self.model)

        self.clientes_conectados = []
        self.clientes_esperados = NUMBER_OF_EXPECTED_CLIENTS
        self.clientes_respondidos = 0
        self.trees_warehouse = []
        self.aggregation_realised = 0

        self.runtime_clients = []
        self.runtime_average = 0
    
def rodar_server():
    print("Server On")
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=NUCLEOS_DISPONIVEIS))
    fedT_pb2_grpc.add_FedTServicer_to_server(FedT(), server)
    server.add_insecure_port(f"{IP}:{PORTA}")
    server.start()
    server.wait_for_termination()

if __name__ == "__main__":
    rodar_server()
