import sys

trees_by_client = 10
threshold = 0.39 # Original 0.55
strategy = 'threshold' #'best_trees'
output_file = f'data/simulation/{strategy}_strategy_sim.csv'

MAX_TREES_NUM = 260 # 260 original
TREES_ITER = 10

#####################################################################################################################
# Parametros: =======================================================================================================
#####################################################################################################################

EPOCHS = 3
ROUNDS = 60
DATASET = 0
NUMBER_OF_CLIENTS = 4

from server import GlobalServer
from client import HouseClient
import utils
from concurrent.futures import ThreadPoolExecutor

def create_client(trees_by_client, NUMBER_OF_CLIENTS):
    return HouseClient(trees_by_client, NUMBER_OF_CLIENTS)

def evaluate_client(client, server_model):
    return client.evaluate(server_model)

executor = ThreadPoolExecutor(max_workers=4)

for round in range(ROUNDS):
    with open("registro_para_teste.txt", "a") as f:
        f.write(f"\nRound: {round} | Strategy: {strategy}\n")

    # Fase 1: Iniciar o modelo global
    server = GlobalServer(trees_by_client)

    # Fase 2: Inicializar os clientes
    print(f"\n######################\nInicialização da Criação dos Clientes\n######################\n")

    future_client_1 = executor.submit(create_client, trees_by_client, NUMBER_OF_CLIENTS)
    future_client_2 = executor.submit(create_client, trees_by_client, NUMBER_OF_CLIENTS)
    future_client_3 = executor.submit(create_client, trees_by_client, NUMBER_OF_CLIENTS)
    future_client_4 = executor.submit(create_client, trees_by_client, NUMBER_OF_CLIENTS)

    client1 = future_client_1.result()
    client2 = future_client_2.result()
    client3 = future_client_3.result()
    client4 = future_client_4.result()

    print(f"\n######################\nClientes Criados\n######################\n")

    for epoch in range(EPOCHS):
        # Fase 3: Receber os parâmetros do servidor e avaliar
        print("\n")
        print(f'Round: {round+1}')

        future_evaluate_1 = executor.submit(evaluate_client, client1, server.model)
        future_evaluate_2 = executor.submit(evaluate_client, client2, server.model)
        future_evaluate_3 = executor.submit(evaluate_client, client3, server.model)
        future_evaluate_4 = executor.submit(evaluate_client, client4, server.model)

        results1 = future_evaluate_1.result()
        results2 = future_evaluate_2.result()
        results3 = future_evaluate_3.result()
        results4 = future_evaluate_4.result()

        (absolute_error1, squared_error1, (pearson_corr1, p_value1), best_trees1) = results1
        (absolute_error2, squared_error2, (pearson_corr2, p_value2), best_trees2) = results2
        (absolute_error3, squared_error3, (pearson_corr3, p_value3), best_trees3) = results3
        (absolute_error4, squared_error4, (pearson_corr4, p_value4), best_trees4) = results4

        print(f'NUM_TREES: {trees_by_client}')
        print(f'Client_id {client1.id} - erro quadrático médio: {squared_error1} - correlação de pearson: {pearson_corr1}')
        print(f'Client_id {client2.id} - erro quadrático médio: {squared_error2} - correlação de pearson: {pearson_corr2}')
        print(f'Client_id {client3.id} - erro quadrático médio: {squared_error3} - correlação de pearson: {pearson_corr3}')
        print(f'Client_id {client4.id} - erro quadrático médio: {squared_error4} - correlação de pearson: {pearson_corr4}')

        MSE_Clients = squared_error1 + squared_error2 + squared_error3 + squared_error4
        MSE_Clients = MSE_Clients/NUMBER_OF_CLIENTS
        pearsonS = pearson_corr1 + pearson_corr2 + pearson_corr3 + pearson_corr4
        pearsonS = pearsonS/NUMBER_OF_CLIENTS
        print(f"\nClients MSE: {MSE_Clients}\nClients Pearson: {pearsonS}\n")

        with open("registro_para_teste.txt", "a") as f:
            f.write(f"Epoch: {epoch}\n")
            f.write(f"MSE: {MSE_Clients}\n")
            f.write(f"Pearson: {pearsonS}")
            f.write(f"\n")

        # Fase 4: Agregar treinamento
        server.aggregate_fit([client1.trees, client2.trees, client3.trees, client4.trees], strategy, executor, threshold)

    trees_by_client += TREES_ITER
    print(trees_by_client)
    print('o tamanho do modelo é : ', sys.getsizeof(server.model))

with open("registro_para_teste.txt", "a") as f:
    f.write(f"#########################")
    f.write(f"\n")

executor.shutdown()
