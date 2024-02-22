import math

RESTRICTION = ["if", "elif", "else", "while", "for", "not", ":", ";", "?", "#", "'", '"']
BASEDASFORMULAS = ["x", "+", "-", "/", "*", "**"]

def buscarPosicaoNoIndice(lista, elemento):
  posicoes = []
  for i in range(len(lista)):
    if (lista[i] == elemento):
      posicoes.append(i)
  return posicoes

def verificarFormula(funcaoInserida):
  # Como eu verifico os dados???
  # Como eu deixo esse eval seguro?
  # Não é a melhor das saídas mas quebra um galho.
  credito = 0
  
  for tipo in RESTRICTION:
    if (tipo in funcaoInserida):
      print("condição")
      return False

  posicoes = buscarPosicaoNoIndice(funcaoInserida, ".")

  for i in posicoes:
    if "." == funcaoInserida[i] and (funcaoInserida[i-1]).isdigit() == False or (funcaoInserida[i+1]).isdigit() == False:
      if "math.log10(x)" not in funcaoInserida:
        return False
    
  for base in BASEDASFORMULAS:
    if (base in funcaoInserida):
      credito += 1

  if (credito == 0):
    return False

  return True

def computarFuncao(funcaoInserida):
  if ("euler" in funcaoInserida) or ("e" in funcaoInserida):
    funcaoInserida = funcaoInserida.replace("euler", f"{math.e}")
    funcaoInserida = funcaoInserida.replace("e", f"{math.e}")

  if ("log(x)" in funcaoInserida):
    funcaoInserida = funcaoInserida.replace("log(x)", "math.log10(x)")
  elif ("logx" in funcaoInserida):
    funcaoInserida = funcaoInserida.replace("logx", "math.log10(x)")

  if ("pi" in funcaoInserida):
    funcaoInserida = funcaoInserida.replace("pi", f"{math.pi}")
  
  if (verificarFormula(funcaoInserida) == True):
    funcaoComputada = lambda x: eval(funcaoInserida)
  else:
    funcaoComputada = lambda x: print(f"\nErro na função computarFuncao({x})")
  return funcaoComputada


# Cálculos:

def buscarRaiz(pontoA, pontoB, funcao):
  tabelaResultados = []
  x = pontoA
  while (x <= pontoB):
    resultado = funcao(x)
    if (type(resultado) == int) or (type(resultado) == float):
      if (resultado > 0):
        tabelaResultados.append((x, "+"))
      elif (resultado > 0):
        tabelaResultados.append((x, "0"))
      else:
        tabelaResultados.append((x,"-"))

    elif (type(resultado) == complex):
      if (resultado.real >= 0):
        tabelaResultados.append((x, "+"))
      else:
        tabelaResultados.append((x, "-"))

    elif (type(resultado) == str):
        tabelaResultados.append((x, "undefined"))

    else:
      tabelaResultados.append((x, "undefined"))
      
    x += 1
  return tabelaResultados

def analisarTabela(pontoA, pontoB, tabela):
  alteracao = []
  for i in range(pontoB-pontoA):
    if (tabela[i][1] != tabela[i-1][1]) and (i > 0):
      alteracao.append((tabela[i-1][0], tabela[i][0]))
  return alteracao

def exibirAlterações(pontoA, pontoB, tabela):
  if(len(analisarTabela(pontoA, pontoB, tabela)) > 0):
    for i in analisarTabela(pontoA, pontoB, tabela):
      print(f"\nHá uma raiz neste ponto: {i}")
    return True
  else:
    print("\nNão há raiz neste intervalo.")
    return False

def precisaoDeMaquina(a, s):
  while (s > 1):
    a = a/2
    s = 1 + a
  precisao = 2*a
  return precisao

def bisseccao(a, b, funcao, precisao):
  contagemDeCalculos = 0
  paradaDeErro = 0
  iDeErro = 0
  raiz = (a+b)/2
  print(f"\nNúmeros de calculos: {contagemDeCalculos}\nPi: {raiz}\nAi = {a}, Bi = {b}")
  while(funcao(raiz) > precisao if funcao(raiz) > 0 else funcao(raiz)*-1 > precisao):
    raiz = (a+b)/2
    print(f"funcao(a) = {funcao(a)}, funcao(raiz) = {funcao(raiz)}")
    if(funcao(a)*funcao(raiz) <= 0):
        b = raiz
    else:
        a = raiz
    if(paradaDeErro != raiz):
        paradaDeErro = raiz
        iDeErro += 1

    if(iDeErro == contagemDeCalculos-50):
      break
    contagemDeCalculos += 1
    print(f"\nNúmeros de calculos: {contagemDeCalculos}\nPi: {raiz}\nAi = {a}, Bi = {b}")
  return raiz