################################################################
# Client Side: =================================================
################################################################

import socket as sck

SERVER_ADDRESS = "10.126.1.109"
FAMILY = sck.AF_INET # AF_INET é IPV4.
TYPE = sck.SOCK_DGRAM # SOCK_STREAM é TCP, SOCK_DGRAM é UDP.
DEDICATED_CHANNEL = 8000 # Canal que vai ser escutado
BUFFER = 2048 # Tamanho da mensagem que vai ser recebida

client = sck.socket(FAMILY, TYPE)

while True:
  msg = input("Digite algo: ")
  client.sendto(msg.encode(), (SERVER_ADDRESS, DEDICATED_CHANNEL))
  print(f"MENSAGEM ENVIADA: {msg}")
  msg_bytes, address_ip_server = client.recvfrom(BUFFER)
  print(f"MENSAGEM RECEBIDA: {msg_bytes.decode()}")