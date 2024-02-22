import math

# Aula 02 - Exemplo 01:

pis = [float(f"{math.pi:.2f}"), float(f"{math.pi:.4f}"), math.pi]
raio = 100

for pi in pis:
  areaDaCircunferencia = pi*raio**2
  print(f"Área da Circunferência: {areaDaCircunferencia}")

# Aula 02 - Exemplo 02: (Somatório);

xi = [0.5, 0.11] #0.5 não apresenta erro, 0.11 tem um erro de arredondamento, o 0.11 tem representação infinita em binário.
repeticoes = 30000
somatorios = []

for x in xi:
  somatorio = 0
  for i in range(repeticoes):
    somatorio += x
  somatorios.append(somatorio)

print(f"Somatorio com 0.5 = {somatorios[0]}\nSomatorio com 0.11 = {somatorios[1]}")

# Converção de base: (Converter o número 22 = 10110 para binário e o 10101 = 21 para decimal);


# Os erros podem ser: inerentes, truncamento ou arredondamento, overflow, underflow.
# Os erros podem ser medidos por: erro absoluto, relativo e percentual.

def medirErroAbsoluto(original, aproximacao):
  erro = original - aproximacao
  return erro if erro >= 0 else erro*-1

def medirErroRelativo(original, aproximacao):
  erro = (original - aproximacao) / original
  return erro if erro >= 0 else erro*-1

def medirErroPercentual(original, aproximacao):
  erro = medirErroRelativo() / 100
  return erro if erro >= 0 else erro*-1

# Aula 02 - Exercicio 02:

# Erro de Overflow:
def fatorial(x):
  resultado = x
  x -= 1
  while x > 0:
    resultado *= x
    x -= 1
  return resultado

def exponencialDeTaylor(termoInicial, termoFinal, x):
  somatorio = 0
  if termoInicial > 0:
    for i in range(termoFinal - termoInicial + 1):
      somatorio += (x**(i+termoInicial)) / fatorial(i+termoInicial)
    return somatorio
  else:
    for i in range(termoFinal - termoInicial):
      somatorio += (x**(i+1)) / fatorial(i+1)
    return somatorio + 1

# print(f"Erro de Overflow: {exponencialDeTaylor(1 , 2000, 0.1)}")

# Erro de Arredondamento:
erroDeArredondamento = 0
numeroInfinitoBinario = 0.11

for i in range(30000):
  erroDeArredondamento += numeroInfinitoBinario

print(f"Número certo: {30000*0.11}\nNúmero com erro de Arredondamento: {erroDeArredondamento}")
  
# Aula 02 - Exercicio 03: Um número pode ter representação finita em uma base e infinita em outra

# Aula 03 - Exercicio 01:

def somatorioComXConstante(termoInicial, termoFinal, x):
  somatorio = 0
  for i in range(termoFinal - termoInicial + 1):
    somatorio += x
  return somatorio

somatorioZeroUm = somatorioComXConstante(1, 100000, 0.1)
somatorioCentoEmVinteCinco = somatorioComXConstante(1, 80000, 0.125)
print(f"X igual a 0.1: {somatorioZeroUm}\nErro absoluto: {medirErroAbsoluto(100000*0.1 ,somatorioZeroUm)}\nErro relativo: {medirErroRelativo(100000*0.1 ,somatorioZeroUm)}")
print(f"X igual a 0.125: {somatorioCentoEmVinteCinco}\nErro absoluto: {medirErroAbsoluto(80000*0.125 ,somatorioCentoEmVinteCinco)}\nErro relativo: {medirErroRelativo(80000*0.125 ,somatorioCentoEmVinteCinco)}")

# Aula 03 - Exercicio 02:
def precisaoDeMaquina(a, s):
  while (s > 1):
    a = a/2
    s = 1 + a
  precisao = 2*a
  return precisao

print(f"Precisão: {precisaoDeMaquina(1, 2)}")

# a) - não é possivel aumentar os caracteres exibidos
# b) - por que o próximo valor já não é diferenciado do 0 pela máquina
# c) - o valor se altera, números diferentes levam a divisões diferentens alterando assim o resultado, 1/2 é diferente de 3/2.

# Aula 03 - Exercicio 03:
def decompor(x, k):
  resultado = 1
  for i in range(k):
    resultado *= x/(i+1)
  return resultado
  
def exponencialDeTaylorV2 (termoInicial, termoFinal, x):
  somatorio = 0
  for i in range(termoFinal - termoInicial):
    somatorio += decompor(x, i+1)
  return somatorio + 1

  
# É EULER, O E DA FÓRMULA É DE EULER
# O segredo para evitar o overflow é a decomposição do fatorial.
# Os resultados saem levemente diferentes entre a versão com decomposição e a versão sem.
# A versão com decomposição é muito mais rápida,pórem um pouco menos precisa aparentemente.

print(f"Exponencial de Taylor: {exponencialDeTaylor(0 , 5000, 5)}")
print(f"Exponencial de Taylor V2: {exponencialDeTaylorV2(0 , 5000, 5)}")