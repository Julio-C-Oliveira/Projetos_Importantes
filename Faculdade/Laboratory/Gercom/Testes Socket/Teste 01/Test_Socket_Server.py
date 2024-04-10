################################################################
# Server Side: =================================================
################################################################

import socket as sck

FAMILY = sck.AF_INET # AF_INET é IPV4.
TYPE = sck.SOCK_DGRAM # SOCK_STREAM é TCP, SOCK_DGRAM é UDP.
DEDICATED_CHANNEL = 8000 # Canal que vai ser escutado
HOST = "" # HOST tá em branco, porque nos estamos do lado do servidor, só os clientes precisam adicionar o oendereço do servidor.

server = sck.socket(FAMILY, TYPE)
server.bind((HOST, DEDICATED_CHANNEL))

BUFFER = 2048 # Tamanho da mensagem que vai ser recebida

while True:
  print("AGUARDANDO A MENSAGEM")
  msg_bytes, address_ip_client = server.recvfrom(BUFFER)
  print("MENSAGEM RECEBIDA")
  result_msg = msg_bytes.decode().upper()
  server.sendto(result_msg.encode(), address_ip_client)
  print(f"MENSAGEM ENVIADA: {result_msg}")