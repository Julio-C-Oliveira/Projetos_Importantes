import numpy as np
from sklearn.ensemble import RandomForestRegressor

# Métricas de erro
from sklearn.metrics import mean_absolute_error
from sklearn.metrics import mean_squared_error
from scipy.stats import pearsonr

import utils

NUMBER_OF_PARTITIONS = 4

class HouseClient():

    def __init__(self, trees_by_client: int, ID) -> None:
        # Load house data
        (X_train, y_train), (self.X_test, self.y_test) = utils.load_dataset()

        # Split train set into 4 partitions and randomly use one for training.
        (self.X_train, self.y_train) = utils.partition(X_train, y_train, NUMBER_OF_PARTITIONS)[ID]
        # (self.X_test, self.y_test) = utils.partition(self.X_test, self.y_train, NUMBER_OF_PARTITIONS)[ID]

        print(f"Client {ID}:\nData: {self.X_train}\nLabel: {self.y_train}")

        # Initialize local model and set initial_parameters
        self.local_model = RandomForestRegressor(n_estimators=trees_by_client)
        utils.set_initial_params(self.local_model, self.X_train, self.y_train) 
        self.trees = self.local_model.estimators_
        self.ID = ID

    def get_global_parameters(self, global_model: RandomForestRegressor):
            return utils.get_model_parameters(global_model)

    # 
    def capture_predictions(self, real_value, prediction_value):
        path = "/home/juliocoliveira/Artigos/Glaucio/porDispositivo"
        #path = "/home/juliocoliveira/Área de Trabalho/Rede Distribuida/gRPC/FedT - Distribuido/client_New_Test"

        num_pred = len(prediction_value)
        csv = f"Real_Value,Predction_Value, {num_pred}\n"

        real_value = np.array(real_value)

        for i in range(num_pred):
            # [real value[i], predction[i]]
            csv += f"[{real_value[i]},{prediction_value[i]}],"
        
        def importar_parametros_de_teste():
            with open("/home/juliocoliveira/Área de Trabalho/Rede Distribuida/gRPC/FedT - Distribuido/parametros_de_teste.txt", "r") as f:
                file = f.read()
            file = file.split("\n")
            print(f"Strategy: {file[0]}\nRound: {file[1]}")
            return file
        
        parametros = importar_parametros_de_teste()

        with open(f"{path}/client_{self.ID}_{parametros[0]}_{parametros[1]}.csv", "w") as f:
            f.write(csv)

    def evaluate(self, global_model: RandomForestRegressor):
        global_model_trees = self.get_global_parameters(global_model)
        
        local_absolute_error = mean_absolute_error(self.y_test, self.local_model.predict(self.X_test))
        global_model_absolute_error = mean_absolute_error(self.y_test, global_model.predict(self.X_test))

        local_squared_error = mean_squared_error(self.y_test, self.local_model.predict(self.X_test))
        global_model_squared_error = mean_squared_error(self.y_test, global_model.predict(self.X_test))

        local_pearson_corr, local_p_value = pearsonr(self.y_test, self.local_model.predict(self.X_test))
        global_model_pearson_corr, global_model_p_value = pearsonr(self.y_test, global_model.predict(self.X_test))

        if local_absolute_error < global_model_absolute_error:
             absolute_error = local_absolute_error
             squared_error = local_squared_error
             pearson_corr, p_value = local_pearson_corr, local_p_value
        else:
             absolute_error = global_model_absolute_error
             squared_error = global_model_squared_error
             pearson_corr, p_value = global_model_pearson_corr, global_model_p_value
             self.trees = global_model_trees
             utils.set_model_params(self.local_model, self.trees)

        self.capture_predictions(self.y_test, self.local_model.predict(self.X_test))

        return absolute_error, squared_error, (pearson_corr, p_value), self.trees