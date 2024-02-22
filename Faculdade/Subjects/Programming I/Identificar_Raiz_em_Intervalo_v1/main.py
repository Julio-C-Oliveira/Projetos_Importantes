from funcoes import *

teste = ["x**3 - 9*x + 3", "x**0.5 - 5*euler**-x", "x*(math.log10(x)) - 1", "x**2 + 16*x + 39"]
saidasCorretas = [(-3.1545230086952065, 0.33760895596583773, 2.816914052729369), (1.4304450889911053), (2.5061841455887692), (-13.0, -3.0)]

print("Aula 04 - Q01:")

funcaoInserida = input("\nInsira a função usando a váriavel x: ")

intervalo = input("\nInsira um intervalo, separe os dois números por uma virgula, caso não queira escolher pressione enter: ").split(",")

if ("math.log10(x)" in funcaoInserida) or ("log(x)" in funcaoInserida) or ("logx" in funcaoInserida):
  pontoA = 1
  pontoB = 100
  print("Teste")
elif intervalo[0] == "" or intervalo[1] == "" or intervalo[0].isdigit() == False or intervalo[1].isdigit() == False:
  pontoA = -100
  pontoB = 100
else:
  pontoA = int(intervalo[0])
  pontoB = int(intervalo[1])

funcao = computarFuncao(funcaoInserida)

tabela = buscarRaiz(pontoA, pontoB, funcao)

raizExiste = exibirAlterações(pontoA, pontoB, tabela)

if(raizExiste == True):
  print("\nAula 04 - Q02:")
  aproximar = input("\nDeseja realizar uma aproximação do valor da raiz, insira [s] ou [n]: ").upper()
  
  if (aproximar == "S"):
    
    pontoChave = analisarTabela(pontoA, pontoB, tabela)
    
    precisao = precisaoDeMaquina(1, 2)
    
    raiz = []
    
    for i in pontoChave:
      raiz.append(bisseccao(i[0], i[1], funcao, precisao))
    
    for i in range(len(raiz)):
      print(f"\nRaiz {i+1}: {raiz[i]}")
  
  else:
    print("\nAdios")

else:
  print("\nA segunda parte do cálculo só pode ser realizada caso o intervalo contenha uma raiz.")