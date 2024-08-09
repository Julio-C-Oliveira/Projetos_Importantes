import os, time

ITERATIONS = 10

for i in range(ITERATIONS):
    with open("registro_para_teste.txt", "a") as f:
        f.write("\n")
        f.write("\n")
        f.write("\n")
        f.write(f"#######################")
        f.write(f"\nIteration: {i}\n")
        f.write(f"########################")
        f.write("\n")
        
    os.system("sh run.sh")