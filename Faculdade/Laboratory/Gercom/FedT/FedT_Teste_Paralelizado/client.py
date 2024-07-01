import numpy as np
from sklearn.ensemble import RandomForestRegressor

# Métricas de erro
from sklearn.metrics import mean_absolute_error
from sklearn.metrics import mean_squared_error
from scipy.stats import pearsonr

import uuid

import utils

class HouseClient():

    def __init__(self, trees_by_client: int, partition_number: int) -> None:
        self.id = uuid.uuid4().int
        # Load house data
        (X_train, y_train), (self.X_test, self.y_test) = utils.load_house()

        rows = X_train.shape[0]
        train_size = int(rows/partition_number)
        print(f"Amostras: {rows}")
        print(f"Train size: {train_size}")

        # Split train set into 4 partitions and randomly use one for training.
        partition_id = np.random.choice(partition_number)
        (self.X_train, self.y_train) = utils.partition(X_train, y_train, partition_number)[partition_id]

        # Initialize local model and set initial_parameters
        self.local_model = RandomForestRegressor(n_estimators=trees_by_client)
        utils.set_initial_params(self.local_model, self.X_train, self.y_train) 
        self.trees = self.local_model.estimators_

    def get_global_parameters(self, global_model: RandomForestRegressor):
            return utils.get_model_parameters(global_model)

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

        return absolute_error, squared_error, (pearson_corr, p_value), self.trees

    
        
        