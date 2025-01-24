from collections import defaultdict

lista = [[0,10,2,3,5,67],[0,10,2,3,5,67],[0,10,2,3,5,67]]
def printar(matriz):
    for lista in matriz:
        for n in lista:
            yield n

for n in printar(lista):
    print(n)

def atributos_padrao():
    return {"predict": [], "real": []}

AVGs = defaultdict(atributos_padrao)

AVGs["Random"]
AVGs["Best Trees"]
AVGs["Threshold"]
AVGs["Best Forests"]

print(AVGs)

print(211/250)