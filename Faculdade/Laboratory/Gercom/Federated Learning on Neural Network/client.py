from collections import OrderedDict
from typing import List, Tuple

import argparse
import matplotlib.pyplot as plt
import numpy as np
import torch
import torch.nn as nn
import torch.nn.functional as F
import torchvision.transforms as transforms
from datasets.utils.logging import disable_progress_bar
from torch.utils.data import DataLoader
import seaborn as sns
import torch.optim as optim
import pandas as pd
from sklearn.model_selection import train_test_split

import flwr as fl
from flwr.common import Metrics
from flwr_datasets import FederatedDataset
from scipy.stats import pearsonr

#####################################################################################################################
# Parametros: =======================================================================================================
#####################################################################################################################

# ROUNDS está definido no server.py
EPOCHS = 200 
DATASET = 0
NUMBER_OF_CLIENTS = 4
LEARNING_RATE = 0.3
print_epoch = 50

#####################################################################################################################
# Etapa 01: Preparação ==============================================================================================
#####################################################################################################################

DEVICE = torch.device("cuda:0" if torch.cuda.is_available() else "cpu")
NUM_CLIENTS = 5

def load_dataset(num_clientes): 
    energy_data_complete = pd.read_csv("/home/juliocoliveira/Área de Trabalho/Random Forest Federated/ambiente_virtual/neural_network/test/energydata_complete.csv")

    data = {}
    data["Appliances"] = energy_data_complete["Appliances"]


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

    for column in columns_for_training:
        data[column] = energy_data_complete[column]

    data = pd.DataFrame(data)

    if num_clientes != None:
       rows = data.shape[0]
       train_size = int(rows/num_clientes)
       print(f"Amostras: {rows}")
       print(f"Train size: {train_size}")

       idxs = np.random.choice(rows, train_size, replace=False)

       x = data.iloc[idxs , 1:]
       y = data.iloc[idxs , 0]

    else:
        x = data.iloc[: , 1:]
        y = data.iloc[: , 0]

    X_train, X_test, y_train, y_test = train_test_split(x, y, test_size = 0.2, random_state = 42)

    X_train = torch.tensor(X_train.values, dtype=torch.float32)
    X_test = torch.tensor(X_test.values, dtype=torch.float32)
    y_train = torch.tensor(y_train.values, dtype=torch.float32).unsqueeze(1)
    y_test = torch.tensor(y_test.values, dtype=torch.float32).unsqueeze(1)

    return X_train, X_test, y_train, y_test



#####################################################################################################################
# Etapa 02: Modelo de Regressão Pytorch =============================================================================
#####################################################################################################################

class linearRegression(nn.Module):
  def __init__(self, input_dim):
    super(linearRegression,self).__init__() 
    self.layers = nn.Sequential(
      nn.Linear(input_dim, 300),         # hidden layer 1 - 45
      nn.Dropout(p = 0.2),
      nn.ReLU(),
      nn.Linear(300, 210),                # hidden layer 2 - 30
      nn.ReLU(),
      nn.Linear(210, 180),                 # hidden layer 2 - 20
      nn.ReLU(),
      nn.Linear(180, 100),                 # hidden layer 3 - 10
      nn.ReLU(), 
      nn.Linear(100, 1)                   # output layer - 1
    )   

  def forward(self, x):
    return self.layers(x)

def train(model, num_epochs, print_epoch, X_train, y_train, loss_function, optimizer):
    torch.manual_seed(42)

    for epoch in range(num_epochs):
       train_predicts = model(X_train)
       train_loss = loss_function(train_predicts, y_train) # O squeeze serve para redimensionar a lista para apenas uma dimensão
       optimizer.zero_grad()
       train_loss.backward()
       optimizer.step()

       if epoch+1 % print_epoch == 0:
          print(f"[Epoch: {epoch}]: Train loss value = {train_loss}")

def test(model, X_test, y_test, loss_function):
    with torch.no_grad():
       model.eval()
       test_predicts = model(X_test)
       test_loss = loss_function(test_predicts, y_test)
       mean_squared_error = torch.mean((test_predicts - y_test)**2)
       print(f"Y_test: {y_test.shape}\nTest_Predicts: {test_predicts.shape}")
       pearsonr_value = pearsonr(y_test.flatten(), test_predicts.flatten()) 
       pearsonr_value = pearsonr_value.statistic
       print(f"Test loss value: {test_loss.item():.2f} | MSE: {mean_squared_error.item():.2f} | Pearsonr: {pearsonr_value:.2f}\n\n")
    
    return test_loss, mean_squared_error, pearsonr_value



#####################################################################################################################
# Etapa 03: Federalizando com o Flower ==============================================================================
#####################################################################################################################

"""parser = argparse.ArgumentParser(description="Flower")
parser.add_argument(
    "--partition-id",
    choices=[0, 1, 2, 3, 4],
    required=True,
    type=int,
    help="Partition of the dataset divided into 3 iid partitions created artificially.",
)
partition_id = parser.parse_args().partition_id

#partition_id = np.random.randint(0, 5)

print(partition_id)"""

model = linearRegression(input_dim = 22).to(DEVICE)
X_train, X_test, y_train, y_test = load_dataset(num_clientes=None)
loss_function = nn.MSELoss()
optimizer = optim.Adadelta(params=model.parameters(),lr=LEARNING_RATE)

for round in range(30):
   print(f"\nRound: {round+1}\n")
   train(model, num_epochs=100, print_epoch=20, X_train=X_train, y_train=y_train, loss_function=loss_function, optimizer=optimizer)
   loss = test(model, X_test, y_test, loss_function)

class FlowerClient(fl.client.NumPyClient):
   def get_parameters(self, config):
      return [val.cpu().numpy() for _, val in model.state_dict().items()]
   
   def set_parameters(self, parameters):
      params_dict = zip(model.state_dict().keys(), parameters)
      state_dict = OrderedDict({k: torch.Tensor(v) for k, v in params_dict})
      model.load_state_dict(state_dict, strict=True)
   
   def fit(self, parameters, config):
      self.set_parameters(parameters)
      train(model, num_epochs=EPOCHS, print_epoch=print_epoch, X_train=X_train, y_train=y_train, loss_function=loss_function, optimizer=optimizer)
      return self.get_parameters(config={}), len(X_train), {}
   
   def evaluate(self, parameters, config):
      self.set_parameters(parameters)
      loss, mse, pearsonr_value = test(model, X_test=X_test, y_test=y_test, loss_function=loss_function)
      return (float(loss), int(len(X_test)), {"mse": float(mse), "pearson": float(pearsonr_value)})
   

fl.client.start_client(
   server_address = "127.0.0.1:8080",
   client = FlowerClient().to_client(),
)