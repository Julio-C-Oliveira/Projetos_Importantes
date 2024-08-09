from typing import List, Tuple

import flwr as fl
from flwr.common import Metrics

def weighted_average(metrics: List[Tuple[int, Metrics]]) -> Metrics:
   MSEs = [num_examples * m["mse"] for num_examples, m in metrics]
   pearsonS = [num_examples * m["pearson"] for num_examples, m in metrics]
   examples = [num_examples for num_examples, _ in metrics]
   # print("\n","#########","\n", sum(MSEs) / sum(examples), "\n", "#########","\n") ERRO
   print(f"\n#########\nAVG MSE: {sum(MSEs) / sum(examples)}\nAVG Pearsonr: {sum(pearsonS) / sum(examples)}\n#########\n")

   MSE_Clients = sum(MSEs) / sum(examples)
   pearsonS_Clients = sum(pearsonS) / sum(examples)
   with open("registro_para_teste.txt", "a") as f: 
    f.write(f"MSE: {MSE_Clients}\n")
    f.write(f"Pearson: {pearsonS_Clients}\n")
    f.write(f"\n")
   return {"mse": MSE_Clients, "pearson": pearsonS_Clients}

ROUNDS = 60

strategy = fl.server.strategy.FedAvg(evaluate_metrics_aggregation_fn=weighted_average)

fl.server.start_server(
    server_address="0.0.0.0:8080",
    config=fl.server.ServerConfig(num_rounds=ROUNDS),
    strategy=strategy,
)