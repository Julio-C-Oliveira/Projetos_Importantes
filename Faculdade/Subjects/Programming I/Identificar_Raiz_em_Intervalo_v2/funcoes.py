import math, random

# Parte antiga

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
  while(funcao(raiz) > precisao if funcao(raiz) > 0 else funcao(raiz)*-1 > precisao):
    raiz = (a+b)/2
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
  return raiz

# Parte nova

# Não entendi direito a posição falsa

def posicaoFalsa(a, b, funcao, precisao):
  if((b - a) < precisao):
    x = (a+b)/2 if ((a+b)/2) >= 0 else ((a+b)/2)*-1
    if(funcao(a) < precisao):
      x = a 
      return x
    elif(funcao(b) < precisao):
      x = b 
      return x
    return x

  contagemDeCalculos = 1
  m = funcao(a)

  while(True):
    x = (a*funcao(b) - b*funcao(a))/(funcao(b) - funcao(a))
  
    if(funcao(x) < precisao):
      break
    if(m*funcao(x) > 0):
      a = x
    else:
      b = x

    if(b - a < precisao):
      x = (a+b)/2 if ((a+b)/2) >= 0 else ((a+b)/2)*-1

  contagemDeCalculos += 1
  return x
        

def mpf():
  pass

def newton():
  pass

def secante(a, b, funcao, precisao):
  modulo = lambda x: x if x >= 0 else x*-1
  if(modulo(funcao(a)) < precisao):
    x = a
    return x
  if(modulo(funcao(b)) < precisao) or (modulo(b - a) < precisao):
    x = b
    return x

  contagemDeCalculos = 1

  while(True):
    c = b - funcao(b)/(funcao(b) - funcao(a))*(b - a)

    if(modulo(funcao(c)) < precisao) or (modulo(c - b) < precisao):
      x = c
      break

    a = b
    b = c

    contagemDeCalculos += 1

  return x
      
