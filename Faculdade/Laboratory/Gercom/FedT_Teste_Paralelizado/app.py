import sys

from server import GlobalServer
from client import HouseClient
import utils
import asyncio

async def evaluate_client(client, server_model):
    return client.evaluate(server_model)

async def main():
    trees_by_client = 10
    threshold = 0.3
    strategy = 'threshold' # 'best_forests' 'best_trees' 'random'
    output_file = f'data/simulation/{strategy}_strategy_sim.csv'

    MAX_TREES_NUM = 260 # 260 original
    TREES_ITER = 10

    EPOCHS = 5
    ROUNDS = 60
    DATASET = 0
    NUMBER_OF_CLIENTS = 4
    
    for round in range(ROUNDS):
    	with open("registro_para_teste.txt", "a") as f:
        f.write(f"\nRound: {round} | Strategy: {strategy}\n")
        
        # Fase 1: Iniciar o modelo global
        server = GlobalServer(trees_by_client)

        # Fase 2: Inicializar os clientes
        clients = [HouseClient(trees_by_client, NUMBER_OF_CLIENTS) for _ in range(NUMBER_OF_CLIENTS)]

        for epoch in range(EPOCHS):
            # Fase 3: Receber os parâmetros do servidor e avaliar
            print("\n")
            print(f'Round: {round+1}')

            tasks = [evaluate_client(client, server.model) for client in clients]

            results = await asyncio.gather(*tasks)

            MSE_Clients = sum(result[1] for result in results) / NUMBER_OF_CLIENTS
            pearsonS = sum(result[2][0] for result in results) / NUMBER_OF_CLIENTS
            print(f"\nClientes MSE: {MSE_Clients}\nClientes Pearson: {pearsonS}\n")
            
            with open("registro_para_teste.txt", "a") as f:
                f.write(f"Epoch: {epoch}\n")
                f.write(f"MSE: {MSE_Clients}\n")
                f.write(f"Pearson: {pearsonS}")
                f.write(f"\n")

            # Fase 4: Agregar treinamento
            server.aggregate_fit([client.trees for client in clients], strategy, threshold)



        trees_by_client += TREES_ITER
        print('o tamanho do modelo é : ', sys.getsizeof(server.model))
        
        with open("registro_para_teste.txt", "a") as f:
            f.write(f"#########################")
            f.write(f"\n")

if __name__ == '__main__':
    asyncio.run(main())
