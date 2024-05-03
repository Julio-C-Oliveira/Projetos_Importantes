from concurrent import futures
import time

import grpc
import multclient_pb2
import multclient_pb2_grpc

# from sklearn.datasets import load_iris
# from sklearn.datasets import load_wine
# from sklearn.datasets import load_breast_cancer
from sklearn.datasets import load_digits

from sklearn.metrics import accuracy_score
from sklearn.model_selection import train_test_split
from sklearn.model_selection import cross_val_score
from sklearn.tree import DecisionTreeClassifier
from sklearn.ensemble import RandomForestClassifier

import pickle
import tempfile

def run():
    with grpc.insecure_channel("localhost:50051") as channel:
        stub = multclient_pb2_grpc.Tokisaki_KurumiStub(channel)

        tree_model = DecisionTreeClassifier() #DecisionTreeClassifier(random_state=769)

        dataset = load_digits()
        data = dataset.data
        label = dataset.target

        data_train, data_test, label_train, label_test = train_test_split(data, label, test_size=0.3, random_state=769) #train_test_split(data, label, test_size=0.3, random_state=769)
        
        tree_model.fit(data_train, label_train)
        tree_predicts = tree_model.predict(data_test)
        tree_accuracy = accuracy_score(label_test, tree_predicts)
        print(f"Precisão da Árvore: {tree_accuracy:.2f}")

        serialised_tree_model = pickle.dumps(tree_model)

        client_ID = int(input("Insira um número: "))
        message = multclient_pb2.Tree_CLient(client_ID=client_ID, serialised_tree=serialised_tree_model)
        server_replies = stub.aggregate_trees(message)

        print("Árvore Enviada")

        models = []

        for server_reply in server_replies:
            with tempfile.TemporaryFile(mode='w+b') as temp_file:
                temp_file.write(server_reply.serialised_tree)
                temp_file.seek(0)
                models.append(pickle.load(temp_file))

        print(f"Número de Modelos: {len(models)}")
        models = [models[0], models[1]]
        forest_model = RandomForestClassifier(warm_start=True)
        forest_model.n_classes_ = models[0].n_classes_
        forest_model.classes_ = models[0].classes_
        forest_model.n_outputs_ = models[0].n_outputs_
        forest_model.estimators_ = models

        forest_predicts = forest_model.predict(data_test)
        forest_accuracy = accuracy_score(label_test, forest_predicts)
        print(F"Precisão da Florest: {forest_accuracy:.2f}")



if __name__ == "__main__":
    run()