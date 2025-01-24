import grpc
import fedT_pb2
import fedT_pb2_grpc

import pickle
import tempfile

from sklearn.ensemble import RandomForestRegressor
from client_utils import HouseClient
import utils

IP = "10.126.1.109"
#IP = "192.168.1.214"
PORTA = "50051"

import argparse

parse = argparse.ArgumentParser(description="FedT")
parse.add_argument(
    "--client-id",
    choices=[0,1,2,3],
    required=True,
    type=int,
    help="Client ID"
)

ID = parse.parse_args().client_id

# ID = 0

def send_stream_trees(serialise_trees:bytes, client_ID:int):
    """
    ### Função:
    Enviar as árvores para o servidor de forma isolada por stream,
    enviar todas as árvores só de uma vez ocasiona vários erros devido ao tamanho do modelo.
    ### Args:
    - Serialise Trees: Lista de árvores em formato de bytes.
    - Client ID: O Identificador do cliente.
    ### Returns:
    - Message: Um objeto que contém a árvore e o ID do cliente.
    """
    message = fedT_pb2.Forest_CLient()
    message.client_ID = client_ID
    for tree in serialise_trees:
        message.serialised_tree = tree
        yield message 

def run():
    with grpc.insecure_channel(f"{IP}:{PORTA}") as channel:
        stub = fedT_pb2_grpc.FedTStub(channel)

        request_settings = fedT_pb2.Request_Server()
        request_settings.client_ID = ID
        server_reply_settings = stub.get_server_settings(request_settings)
        trees_by_client = server_reply_settings.trees_by_client

        print(f"\n####################\nTrees by client: {trees_by_client}\n####################\n")

        request_model = fedT_pb2.Request_Server()
        request_model.client_ID = ID
        server_replies = stub.get_server_model(request_model)
        server_trees_serialised = []
        for server_reply in server_replies:
            server_trees_serialised.append(server_reply.serialised_tree)

        server_trees_deserialise = utils.deserialise_several_trees(server_trees_serialised)

        server_model = RandomForestRegressor(warm_start=True)
        data_valid, label_valid = utils.load_dataset_for_server()
        server_model.fit(data_valid, label_valid)
        server_model.estimators_ = server_trees_deserialise

        client = HouseClient(trees_by_client, ID)
        (absolute_error, squared_error, (pearson_corr, p_value), best_trees) = client.evaluate(server_model)

        print("\n####################")
        print(f"Client ID: {ID}\nAbsolute Error: {absolute_error:.3f}\nSquared Error: {squared_error:.3f}\nPearson: {pearson_corr:.3f}")
        print("####################\n")

        serialise_trees = utils.serialise_several_trees(client.trees)

        server_replies = stub.aggregate_trees(send_stream_trees(serialise_trees, ID))
        server_trees_serialised = []
        for reply in server_replies:
            server_trees_serialised.append(reply.serialised_tree)

        request_end = fedT_pb2.Request_Server()
        request_end.client_ID = ID
        server_reply = stub.end_of_transmission(request_end)

        server_trees_deserialised = utils.deserialise_several_trees(server_trees_serialised)
        server_model.estimators_ = server_trees_deserialised
        (absolute_error, squared_error, (pearson_corr, p_value), best_trees) = client.evaluate(server_model)
        print("\n####################")
        print(f"Client ID: {ID}\nAbsolute Error: {absolute_error:.3f}\nSquared Error: {squared_error:.3f}\nPearson: {pearson_corr:.3f}")
        print("####################\n")


if __name__ == "__main__":
    run()