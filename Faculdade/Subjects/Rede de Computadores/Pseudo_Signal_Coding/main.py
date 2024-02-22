import Codificar

# ENTRADA
NUMSEQUENCIAS = 2
sequencias = ["1110000000010100", "0100001011101001"]
respostaIni = input("Deseja inserir uma sequência, insira [s] para sim, caso não clique em outra tecla: ")
if respostaIni == "s":
  sequencias = [input("Insira a sequência: ")]

# CALCULO
resultados = []
for sequencia in sequencias: # Codifica todas as sequências e registra.

  Codifica = Codificar.Codificar(sequencia)
  resultados.append(Codifica.cod4B3T())
  resultados.append(Codifica.codAMI())
  del Codifica

respostaSeq = input("Digite [s] para exibir a sequência, pressione qualquer tecla para pular essa etapa: ")
if respostaSeq == "s":
  seq = 1
  c = 0
  for i in range(len(resultados)): # Exibe as sequências codificadas.
    c += 1
    print(f"Sequência {seq} - cod {c}: {resultados[i]}")
    if i-1 % NUMSEQUENCIAS == 0:
      seq += 1
    if c == NUMSEQUENCIAS:
      c = 0

while True:
  respostaGra = int(input(f"Insira o número do resultado que deseja exibir, escolha um número entre 1 e {len(resultados)}: "))
  respostaGra -= 1
  if respostaGra <= len(resultados) and  respostaGra >= 0:
    Codificar.gerarGrafico(resultados[respostaGra]) # Exibe o gráfico das sequências em forma de escada.
    # Após abrir a janela do gráfico ajuste para: bottom = 0.4 e top = 0.55
    continuar = input("Digite [s] para exibir outro gráfico, pressione qualquer tecla para encerrar: ")
    if continuar != "s":
      break
  else:
    print("O valor inserido é inválido.")
    break

print("Bye Bye")