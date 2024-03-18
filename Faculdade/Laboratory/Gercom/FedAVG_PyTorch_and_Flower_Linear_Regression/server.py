from typing import List, Tuple

import flwr as fl
from flwr.common import Metrics

def weighted_average(metrics: List[Tuple[int, Metrics]]) -> Metrics:
   MSEs = [num_examples * m["mse"] for num_examples, m in metrics]
   examples = [num_examples for num_examples, _ in metrics]
   print("\n","#########","\n", sum(MSEs) / sum(examples), "\n", "#########","\n")
   return {"mse": sum(MSEs) / sum(examples)}


strategy = fl.server.strategy.FedAvg(evaluate_metrics_aggregation_fn=weighted_average)

fl.server.start_server(
    server_address="0.0.0.0:8080",
    config=fl.server.ServerConfig(num_rounds=5),
    strategy=strategy,
)