import matplotlib.pyplot as plt

class Codificar:
  '''
  Recebe uma sequência e a codifica de várias formas diferentes.
  -
  Entrada:
  - Sequência(str): Sequência de bits que será convertida.

  Tipos de Codificação:
  - 4BT3: Para usar chame a função cod4B3T().
  - AMI: Para usar chame a função cod4AMI().
  - Manchester Diferencial: Para usar chame a função codManchesterDif().
  '''
  
  def __init__(self, sequencia:str):
    self.sequencia = sequencia

  @staticmethod
  def dividirString(palavra:str, divisor:int):
    '''
    Recebe a sequência de bits em forma de string e divide em sequências menores.
    -
    Entrada:
    - Palavra(str): É a sequência de bits que será dividida, não tem valor padrão.
    - Divisor(int): É o que irá definir o tamanho das sequências menores, não tem valor padrão.

    Saida:
    - List: A sequência de bits dividida de acordo com o valor requisitado.
    '''
    contador = 0
    parte = 0
    palavraDividida = [""]*int(len(palavra)/divisor)
  
    for caracter in palavra:
      palavraDividida[parte] += caracter
      contador += 1
      if contador % divisor == 0:
        parte += 1
  
    return palavraDividida

  @staticmethod
  def substituir4B3T(minisequencia:str):
    '''
    Recebe uma sequência de bits e os converte para uma nova, de acordo com a tabela reduzindo a quantidade de bits.
    -
    Entrada:
    - Minisequencia(str): Sequências de 4 bits, não possui um valor padrão.
    
    Saida:
    - Str: Sequência reduzida com 1 bit a menos.
    '''
    
    minisequencia = minisequencia.replace("0000","0,-1,1")
    minisequencia = minisequencia.replace("0001","-1,1,0")
    minisequencia = minisequencia.replace("0010","-1,0,1")
    minisequencia = minisequencia.replace("0011","1,-1,1")
    minisequencia = minisequencia.replace("0100","0,1,1")
    minisequencia = minisequencia.replace("0101","0,1,0")
    minisequencia = minisequencia.replace("0110","0,0,1")
    minisequencia = minisequencia.replace("0111","-1,1,1")
    minisequencia = minisequencia.replace("1000","0,1,-1")
    minisequencia = minisequencia.replace("1001","1,-1,0")
    minisequencia = minisequencia.replace("1010","1,0,-1")
    minisequencia = minisequencia.replace("1011","1,0,0")
    minisequencia = minisequencia.replace("1100","1,0,1")
    minisequencia = minisequencia.replace("1101","1,1,0")
    minisequencia = minisequencia.replace("1110","1,1,-1")
    minisequencia = minisequencia.replace("1111","1,1,1")

    return [minisequencia]

  @staticmethod
  def tratarLista(lista:list):
    '''
    Recebe uma lista que contém outras listas e junta todos os elementos em uma só.
    -
    Entrada:
    - Lista(list): Uma lista com outras listas dentro, não possui valor padrão.

    Saida:
    - List: Uma lista unica.
    '''
    
    palavra = str(lista)
    palavra = palavra.replace("[", "")
    palavra = palavra.replace("]", "")
    palavra = palavra.replace("'", "")
    palavra = palavra.replace(" ", "")
    
    return palavra.split(",")

  @staticmethod
  def strList_intList(listaStr:list):
    '''
    Recebe uma lista de elementos string e retorna uma lista de elementos inteiros.
    -
    Entrada:
    - ListaStr(list): Uma lista com strings, não possui valor padrão.

    Saida:
    - List: Uma lista com ints.
    '''
    return [int(caracter) for caracter in listaStr]
    
  def cod4B3T(self): # Função que realiza a codificação em 4B3T.
    '''
    Recebe uma sequência de bits com tamanho divisivel para 4, divide em sequências menores de 4 bits, as reduz para 3 bits e retorna a nova sequência.
    -
    Entrada:
    - Sequencia(str): A sequência original de bits.

    Saida:
    - List: Uma lista com a sequência reduzida de bits em forma de inteiros.
    '''

    TAMANHO = 4
    sequenciaDividida = []

    if len(self.sequencia) % TAMANHO == 0:
      minisequencias = self.dividirString(self.sequencia, TAMANHO)
      
      for minisequencia in minisequencias:
        sequenciaDividida.append(self.substituir4B3T(minisequencia))

      sequenciaDividida = self.tratarLista(sequenciaDividida)
      sequenciaDividida = self.strList_intList(sequenciaDividida)
      
      return sequenciaDividida
        
    else:
      print(f"As sequencia não pode ser convertida, pois, o número de bits não é divisivel por {TAMANHO}.")
      return [0, 0]

  def codAMI(self): # Função que realiza a codificação em AMI.
    '''
    Recebe uma sequência de bits e a converte em uma nova sequência, o 0 permanecerá assim e a cada 1 a tensão é alterada.
    -
    Entrada:
    - Sequencia(str): A sequência original de bits.

    Saida:
    - List: Uma lista de niveis de tensão.
    '''
    tensao = True
    sequenciaFinal = []
    sequencia = self.sequencia

    for bit in sequencia:
      bit = int(bit)
      if bit == 0:
        sequenciaFinal.append(0)
      elif bit == 1 and tensao == True:
        sequenciaFinal.append(1)
        tensao = False
      elif bit == 1 and tensao == False:
        sequenciaFinal.append(-1)
        tensao = True

    return sequenciaFinal

  def codManchesterDif(self):
    sequencia  = self.sequencia
    sequenciaFinal = []
    for bit in sequencia:
      bit = int(bit)
      if bit == 0:
        pass
      elif bit == 1:
        pass
      else:
        print("ERRO")
      

def gerarEixoX(sequencia:list):
  '''
  Gera o eixo X que seria o tempo em relação aos bits.
  -
  Entrada:
  - Sequencia(list): 

  Saida:
  - List:
  '''
  eixoX = []
  for i in range(len(sequencia)+1):
    eixoX.append(i)
  return eixoX

def linhaParaEscada(sequencia:list):
  '''
  Transforma o gráfico para uma representação melhor, mais parecido com uma escada.
  -
  Entrada:
  - Sequencia(list): 
  
  Saida:
  - Eixo Y: Gráfico alterado para parecer mais com uma escada.
  - Eixo X: Gráfico alterado para parecer mais com uma escada.
  '''
  registro = 0
  eixoXEscada = []
  listaEscada = []
  listaEscada.append(sequencia[0])
  
  for i in range(len(sequencia)):
    if sequencia[i] != sequencia[i-1] and i > 0:
      listaEscada.append(sequencia[i])
      listaEscada.append(sequencia[i])
      eixoXEscada.append(i)
      eixoXEscada.append(i)
    else:
      listaEscada.append(sequencia[i])
      eixoXEscada.append(i)

    if registro < i:
      registro = i

  eixoXEscada.append(registro+1)

  return listaEscada, eixoXEscada, gerarEixoX(sequencia)
  
    
def gerarGrafico(sequencia:list):
  eixoY, eixoX, eixoXOriginal = linhaParaEscada(sequencia)
  plt.plot(eixoX, eixoY)
  plt.yticks([-1, 0, 1])
  plt.xticks(eixoXOriginal)
  plt.show()