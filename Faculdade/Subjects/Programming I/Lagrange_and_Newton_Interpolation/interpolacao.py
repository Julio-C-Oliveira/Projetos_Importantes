import random as r

class Lagrange:
  def __init__(self, valoresDeX:list, valoresDeY:list):
    self.valorDeX = valoresDeX
    self.valorDeY = valoresDeY
    self.x = 0
    
  # pn(x) = somátorio de k = 0 até n de yklk(x)onde:
  # lk(x) = (produtorio de j = 0 sendo j != k, até n, (x-xj)) / (produtorio de j = 0 sendo j != k, até n, (xk-xj))
  
  def calcularPolinomiosLagrange(self, k:int): # Lk(x)
    numerador = 1
    denominador = 1

    for j in range(len(self.valorDeX)):
      if j != k:
        numerador *= (self.x - self.valorDeX[j])
        denominador *= (self.valorDeX[k] - self.valorDeX[j])

    if denominador == 0:
      print(f"O denominador é igual a {denominador}")
      return 1
        
    return numerador / denominador
    
  def calcularPolinomioInterpolador(self, x): # Pn(x)
    self.x = x
    polinomio = 0

    for i in range(len(self.valorDeX)):
      polinomio += self.valorDeY[i] * self.calcularPolinomiosLagrange(i)
      
    return polinomio

class Newton:
  def __init__(self, valoresDeX:list, valoresDeY:list):
    self.valorDeX = valoresDeX
    self.valorDeY = valoresDeY
    self.x = 0
    self.tamanhoDaTabela = 0

  def criarTabela(self):
    tabelaVazia = [[None] * (self.tamanhoDaTabela+1) for _ in range(self.tamanhoDaTabela+1)]

    return tabelaVazia

  def preencherPrimeiraColuna(self, tabelaVazia):
    for i in range(self.tamanhoDaTabela + 1):
      tabelaVazia[i][0] = self.valorDeY[i]

    return tabelaVazia

  def diferencaDividida(self, tabelaInicial):
    for j in range(1, self.tamanhoDaTabela+1):
      for i in range(self.tamanhoDaTabela, j-1, -1):
        if (self.valorDeX[i] - self.valorDeX[i-j]) == 0:
          print(f"O denominador é igual a {(self.valorDeX[i] - self.valorDeX[i-j])}")
          return tabelaInicial
        
        tabelaInicial[i][j] = (tabelaInicial[i][j-1] - tabelaInicial[i-1][j-1]) / (self.valorDeX[i] - self.valorDeX[i-j])
        
    return tabelaInicial
    
  def calcularPolinomiointerpolador(self, x):
    self.tamanhoDaTabela = len(self.valorDeX) - 1

    tabelaVazia = self.criarTabela()

    tabelaInicial = self.preencherPrimeiraColuna(tabelaVazia)

    tabelaPreenchida = self.diferencaDividida(tabelaInicial)

    polinomioInterpolador = tabelaPreenchida[self.tamanhoDaTabela][self.tamanhoDaTabela]

    for i in range(self.tamanhoDaTabela - 1, -1, -1):
      if type(tabelaPreenchida[i][i]) != int and type(tabelaPreenchida[i][i]) != float:
        return None
      
      polinomioInterpolador = polinomioInterpolador * (x - self.valorDeX[i]) + tabelaPreenchida[i][i]
      
    return polinomioInterpolador

def gerarPontosAleatorios(funcao, numeroDePontos:int):
  valoresDeX = []
  valoresDeY = []
  
  for i in range(numeroDePontos):
    x = r.randint(-10, 10)
    valoresDeX.append(x)
    valoresDeY.append(funcao(x))
  return valoresDeX, valoresDeY

def gerarPontosIgualmenteEspacados():
  pass

def gerarPontosYPeloX(funcao, valoresDeX:list):
  valoresDeY = []
  for i in valoresDeX:
    valoresDeY.append(funcao(i))

  return valoresDeY