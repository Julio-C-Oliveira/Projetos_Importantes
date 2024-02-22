# Implemente 3 métodos de refinamento para encontrar raízes reais de funções reais.
# Teste esses algoritmos em 5 funções que misturam: Polinômios de graus > 5, Logaritmos, Exponenciais, Senos e cossenos, Divisões e raízes
# Escolha os parâmetros iniciais. Use o algoritmo de testagem do sinal de 𝑓(𝑥) para encontrar o intervalo 𝐼. Mostre as tabelas testadas.
# Monte uma tabela semelhante a dos exemplos anteriores.

from funcoes import *
import math

teste = [lambda x: x**3 - 9*x + 3, lambda x: x**3 - 2*x - 5, lambda x: x**7 + 5*x**6 - 2*x**5 - 7*x**4 + 3*x**3 + 9*x**2 - 4*x - 5, lambda x: math.exp(-x) - x, lambda x: math.cos(x) - math.sin(x), lambda x: x**2 - 2*x - math.sqrt(2), lambda x: x**0.5 - 5*math.e**-x, lambda x: x*(math.log10(x)) - 1 , lambda x: x**2 + 16*x + 39]

saidasCorretas = [(-3.1545230086952065, 0.33760895596583773, 2.816914052729369), (1.4304450889911053), (2.5061841455887692), (-13.0, -3.0)]

print("Aula 06 - Q01:")

funcao = teste[8]

intervalo = input("\nInsira um intervalo, separe os dois números por uma virgula, caso não queira escolher pressione enter: ").split(",")

if intervalo[0] == "" or intervalo[1] == "" or intervalo[0].isdigit() == False or intervalo[1].isdigit() == False:
  pontoA = -100
  pontoB = 100
else:
  pontoA = int(intervalo[0])
  pontoB = int(intervalo[1])

if funcao == teste[7]:
  pontoA = 1
  pontoB = 100

print(pontoA, pontoB)
tabela = buscarRaiz(pontoA, pontoB, funcao)

raizExiste = exibirAlterações(pontoA, pontoB, tabela)

if(raizExiste == True):
  aproximar = input("\nDeseja realizar uma aproximação do valor da raiz, insira [s] ou [n]: ").upper() # adicionar um valor padrão de S
  
  if (aproximar == "S") or (aproximar == ""):

    modoDeAproximacao = input("\nEscolha seu modo de refinamento/aproximação.\n[1] - Bissecção\n[2] - Posição Falsa\n[3] - Secante\nInsira sua resposta: ") # Adicionar um valor padrão de Bissecção [1]

    if(modoDeAproximacao == "1"):
      pontoChave = analisarTabela(pontoA, pontoB, tabela)
      precisao = precisaoDeMaquina(1, 2)
      raiz = []
      for i in pontoChave:
        raiz.append(bisseccao(i[0], i[1], funcao, precisao))
      for i in range(len(raiz)):
        print(f"\nRaiz {i+1}: {raiz[i]}")

    elif(modoDeAproximacao == "2"):
      pontoChave = analisarTabela(pontoA, pontoB, tabela)
      precisao = precisaoDeMaquina(1, 2)
      raiz = []
      for i in pontoChave:
        raiz.append(posicaoFalsa(i[0], i[1], funcao, precisao))
      for i in range(len(raiz)):
        print(f"\nRaiz {i+1}: {raiz[i]}")

    elif(modoDeAproximacao == "3"):
      pontoChave = analisarTabela(pontoA, pontoB, tabela)
      precisao = precisaoDeMaquina(1, 2)
      raiz = []
      for i in pontoChave:
        raiz.append(secante(i[0], i[1], funcao, precisao))
      for i in range(len(raiz)):
        print(f"\nRaiz {i+1}: {raiz[i]}")

    else:
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