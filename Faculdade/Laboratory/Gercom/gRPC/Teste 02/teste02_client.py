import time

import grpc
import teste02_pb2
import teste02_pb2_grpc

from sklearn.datasets import load_iris
from sklearn.model_selection import cross_val_score
from sklearn.tree import DecisionTreeClassifier

import pickle
import tempfile

def run():
    with grpc.insecure_channel("localhost:50051") as channel:
        stub = teste02_pb2_grpc.RiasStub(channel)

        tree_model = DecisionTreeClassifier(random_state=769)
        iris_data = load_iris()
        tree_model.fit(iris_data.data, iris_data.target)

        serialised_tree_model = pickle.dumps(tree_model)

        message = teste02_pb2.Tree(client_ID=1, serialised_tree=serialised_tree_model)
        server_replies = stub.receive_tree(message)

        serialised_models = []

        for server_reply in server_replies:
            print(f"ID: {server_reply.client_ID}")
            serialised_models.append(server_reply.serialised_tree)

        with tempfile.TemporaryFile(mode='w+b') as temp_file:
            temp_file.write(serialised_models[0])
            temp_file.seek(0)
            tree_model_server = pickle.load(temp_file)

        scores = cross_val_score(tree_model_server, iris_data.data, iris_data.target, cv=10, scoring='accuracy') 
        print(f"\nPrecisão Média: {scores.mean()*100:.2f}%")

        for i, score in enumerate(scores):
            print(f"{i}. Precisão: {score*100:.2f}%")



if __name__ == "__main__":
    run()