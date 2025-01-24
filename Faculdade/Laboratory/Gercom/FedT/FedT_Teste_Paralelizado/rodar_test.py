import os
import time

start_time = time.time()

ITERATIONS = 10

# with open("/home/juliocoliveira/Área de Trabalho/time_comparation_paralelizado.txt", "a") as f:
#     f.write(f"\n")
#     f.write(f"############################")

for i in range(ITERATIONS):
    with open("registro_para_teste.txt", "a") as f:
        f.write("\n")
        f.write("\n")
        f.write("\n")
        f.write(f"#######################")
        f.write(f"\nIteration: {i}\n")
        f.write(f"########################")
        f.write("\n")

    os.system("python3 app.py")

    with open("registro_para_teste.txt", "a") as f:
        f.write("\n")

end_time = time.time()
execution_time = end_time - start_time
print(f"Tempo de Execução Geral: {execution_time/60:.2f} minutos")

# with open("/home/juliocoliveira/Área de Trabalho/time_comparation_paralelizado.txt", "a") as f:
#     f.write(f"\n")
#     f.write(f"Tempo de Execução Geral: {execution_time/60:.2f} minutos")
#     f.write(f"############################")
#     f.write(f"\n")