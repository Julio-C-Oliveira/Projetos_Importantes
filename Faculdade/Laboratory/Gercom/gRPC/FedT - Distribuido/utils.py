import numpy as np
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestRegressor

import pickle
import tempfile

import fedT_pb2

PERCENTUAL = 0.65

def set_initial_params(model: RandomForestRegressor, X_train, y_train):
    """
    ### Função:
    Setar os parâmetros iniciais do modelo, treinando a floresta com apenas 3 amostras.
    ### Args:
    - Model: O modelo de floresta.
    - Data: As features para treinar o modelo.
    - Label: Os targets para treinar o modelo.
    ### Returns:
    - None.
    """
    model.fit(X_train, y_train)

def set_model_params(
    model: RandomForestRegressor, params: list
) -> RandomForestRegressor:
    """
    ### Função:
    Setar os parâmetros do modelo.
    ### Args:
    - Modelo: Modelo de floresta.
    - Parâmetros: As árvores que serão utilizadas como estimators.
    ### Returns:
    - Modelo: Modelo de floresta, com os novos estimators.
    """
    model.estimators_ = params
    return model

def get_model_parameters(model: RandomForestRegressor):
    """
    ### Função:
    Obter as árvores do modelo.
    ### Args:
    - Modelo: Modelo de floresta.
    ### Returns:
    - Parâmetros: As árvores que estão sendo utilizadas como estimators no modelo.
    """
    params = model.estimators_
    return params

def load_dataset():
    """
    ### Função:
    Carregar o dataset completo.
    ### Args:
    - None.
    ### Returns:
    - Data Train: As features para treinar o modelo.
    - Label Train: Os targets para treinar o modelo.
    - Data Test: As features para testar o modelo.
    - Label Test: Os targets para testar o modelo
    """
    path = "data/energydata_complete.csv"

    energy_data_complete = pd.read_csv(path)
    columns_for_training = []
    temperature_columns = [f"T{i}" for i in range(1, 10)]
    humidity_columns = [f"RH_{i}" for i in range(1, 10)]

    for temperature in temperature_columns:
        columns_for_training.append(temperature)
        
    for humidity in humidity_columns:
        columns_for_training.append(humidity)
        
    columns_for_training.append("T_out")
    columns_for_training.append("RH_out")
    columns_for_training.append("Press_mm_hg")
    columns_for_training.append("Visibility")

    data = energy_data_complete[columns_for_training]
    label = energy_data_complete["Appliances"]

    data_train, data_test, label_train, label_test = train_test_split(data, label, test_size=0.2, random_state=42)
    
    return (data_train, label_train), (data_test, label_test)

def load_dataset_for_server() -> list:
    """
    ### Função:
    Carregar o dataset com apenas 3 amostras, 
    servirá para inicializar o server e garantir que os parâmetros entre server e cliente serão compativeis.
    ### Args:
    - None.
    ### Returns:
    - Data Train: As features.
    - Label Train: Os targets. 
    """
    (data_train, label_train), (_, _)  = load_dataset()
    return data_train[0:2], label_train[0:2]

def load_server_side_validation_data():
    """
    ### Função:
    Carregar o dataset com apenas 1000 amostras, 
    servirá para carregar os dados de validação para testar a performance do modelo.
    ### Args:
    - None.
    ### Returns:
    - Data Valid: As features para validação.
    - Label Valid: Os targets para validação. 
    """
    (_, _), (data_valid, label_valid)  = load_dataset()
    return data_valid[-1000:], label_valid[-1000:]

def shuffle(data: np.ndarray, label: np.ndarray):
    """
    ### Função:
    Embaralhar os dados alterando a ordem das linhas.
    ### Args:
    - Data: As features.
    - Label: Os targets.
    ### Returns:
    - Data: As features embaralhadas.
    - Label: Os targets embaralhados.
    """
    rng = np.random.default_rng()
    idx = rng.permutation(int(len(data)*PERCENTUAL))
    return data[idx], label[idx]


def partition(data: np.ndarray, label: np.ndarray, num_partitions: int):
    """
    ### Função:
    Dividir o dataset de acordo com o número de clientes.
    ### Args:
    - Data: As features.
    - Label: Os targets.
    - Numéro de Clientes.
    ### Returns:
    - [Data, Label]: Uma partição do dataset original.
    """
    return list(
        zip(np.array_split(data, num_partitions), np.array_split(label, num_partitions))
    )

def serialise_tree(tree_model) -> bytes:
    """
    ### Função:
    Converter o modelo de árvore de objeto para bytes.
    ### Args:
    - Tree Model: Modelo de árvore.
    ### Returns:
    - Serialised Tree Model: Modelo de árvore convertido em bytes.
    """
    return pickle.dumps(tree_model)

def deserialise_tree(serialised_tree_model):
    """
    ### Função:
    Converter um modelo de árvore em bytes para um modelo em formato de objeto.
    ### Args:
    - Serialised Tree Model: Modelo de árvore em bytes.
    ### Returns:
    - Deserialised Tree Model: Modelo de árvore em formato de objeto.
    """
    with tempfile.TemporaryFile(mode='w+b') as temp_file:
        temp_file.write(serialised_tree_model)
        temp_file.seek(0)
        tree_deserialised_model = pickle.load(temp_file)
    return tree_deserialised_model

def serialise_several_trees(tree_models):
    """
    ### Função:
    Converter vários modelos de árvore de objeto para bytes.
    ### Args:
    - Tree Models: Lista com vários modelos de árvore.
    ### Returns:
    - Serialised Tree Models: Lista de modelos de árvore convertido em bytes.
    """
    serialised_trees = []
    for tree in tree_models:
        serialised_trees.append(serialise_tree(tree))
    return serialised_trees

def deserialise_several_trees(serialised_tree_models):
    """
    ### Função:
    Converter vários modelos de árvore em bytes para modelos em formato de objeto.
    ### Args:
    - Serialised Tree Models: Lista com vários modelos de árvore em bytes.
    ### Returns:
    - Deserialised Tree Model: Lista com vários modelos de árvore em formato de objeto.
    """
    deserialised_trees = []
    for serialised_tree in serialised_tree_models:
        with tempfile.TemporaryFile(mode='w+b') as temp_file:
            temp_file.write(serialised_tree)
            temp_file.seek(0)
            deserialised_trees.append(pickle.load(temp_file))
    return deserialised_trees