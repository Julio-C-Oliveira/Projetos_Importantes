import os

path = '"/home/juliocoliveira/Área de Trabalho/Random Forest Federated/ambiente_virtual"'
source = '"test/bin/activate"'
app_locate = '"test/Lucas_Federated_Random_Forest"'
app_name = '"rodar_test.py"'

os.system(f'cd {path} && source {source} && cd {app_locate} && python3 {app_name}')

# os.system('cd "/home/juliocoliveira/Área de Trabalho/Random Forest Federated/ambiente_virtual"')
# os.system('source test/bin/activate')
# os.system('cd test/Lucas_Federated_Random_Forest')
# os.system('python3 rodar_test.py')