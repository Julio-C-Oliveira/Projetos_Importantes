import sys

trees_by_client = 10
threshold = 0.3 # Original 0.55
strategy = 'random' #'best_trees'
output_file = f'data/simulation/{strategy}_strategy_sim.csv'

MAX_TREES_NUM = 260 # 260 original
TREES_ITER = 10

#####################################################################################################################
# Parametros: =======================================================================================================
#####################################################################################################################

EPOCHS = 5
ROUNDS = 60
DATASET = 0
NUMBER_OF_CLIENTS = 4

from server import GlobalServer
from client import HouseClient
import utils
from concurrent.futures import ThreadPoolExecutor

def evaluate_client(client, server_model):
    return client.evaluate(server_model)

executor = ThreadPoolExecutor(max_workers=4)

with open("registro.txt", "a") as f:
    f.write(f"Inicio da Execução\n\n")

for round in range(ROUNDS):

    with open("registro_para_teste.txt", "a") as f:
        f.write(f"\nRound: {round}\n")

    # Fase 1: Iniciar o modelo global
    server = GlobalServer(trees_by_client)

    # Fase 2: Inicializar os clientes
    client1 = HouseClient(trees_by_client, NUMBER_OF_CLIENTS)
    client2 = HouseClient(trees_by_client, NUMBER_OF_CLIENTS)
    client3 = HouseClient(trees_by_client, NUMBER_OF_CLIENTS)
    client4 = HouseClient(trees_by_client, NUMBER_OF_CLIENTS)

    for epoch in range(EPOCHS):
        # Fase 3: Receber os parâmetros do servidor e avaliar
        print("\n")
        print(f'Round: {round+1}')

        future1 = executor.submit(evaluate_client, client1, server.model)
        future2 = executor.submit(evaluate_client, client2, server.model)
        future3 = executor.submit(evaluate_client, client3, server.model)
        future4 = executor.submit(evaluate_client, client4, server.model)

        results1 = future1.result()
        results2 = future2.result()
        results3 = future3.result()
        results4 = future4.result()

        (absolute_error1, squared_error1, (pearson_corr1, p_value1), best_trees1) = results1
        (absolute_error2, squared_error2, (pearson_corr2, p_value2), best_trees2) = results2
        (absolute_error3, squared_error3, (pearson_corr3, p_value3), best_trees3) = results3
        (absolute_error4, squared_error4, (pearson_corr4, p_value4), best_trees4) = results4

        # (absolute_error1, squared_error1, (pearson_corr1, p_value1), best_trees1) = client1.evaluate(server.model)
        # (absolute_error2, squared_error2, (pearson_corr2, p_value2), best_trees2) = client2.evaluate(server.model)
        # (absolute_error3, squared_error3, (pearson_corr3, p_value3), best_trees3) = client3.evaluate(server.model)
        # (absolute_error4, squared_error4, (pearson_corr4, p_value4), best_trees4) = client4.evaluate(server.model)

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

        with open("registro.txt", "a") as f:
            f.write(f"\n")
            f.write(f"Round: {round}\n")
            f.write(f"Client_id {client1.id} - erro quadrático médio: {squared_error1} - correlação de pearson: {pearson_corr1}\n")
            f.write(f"Client_id {client2.id} - erro quadrático médio: {squared_error2} - correlação de pearson: {pearson_corr2}\n")
            f.write(f"Client_id {client3.id} - erro quadrático médio: {squared_error3} - correlação de pearson: {pearson_corr3}\n")
            f.write(f"Client_id {client4.id} - erro quadrático médio: {squared_error4} - correlação de pearson: {pearson_corr4}\n")
            f.write(f"\n")

        with open("registro_para_teste.txt", "a") as f:
            f.write(f"Epoch: {epoch}\n")
            f.write(f"MSE: {MSE_Clients}\n")
            f.write(f"Pearson: {pearsonS}")
            f.write(f"\n")

        # Fase 4: Agregar treinamento
        server.aggregate_fit([client1.trees, client2.trees, client3.trees, client4.trees], strategy, threshold)


    trees_by_client += TREES_ITER
    print('o tamanho do modelo é : ', sys.getsizeof(server.model))

with open("registro.txt", "a") as f:
    f.write(f"\n\nFim da Execução")

with open("registro_para_teste.txt", "a") as f:
    f.write(f"#########################")
    f.write(f"\n")

executor.shutdown()
