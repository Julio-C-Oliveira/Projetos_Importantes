from concurrent import futures
import time

import grpc
import multclient_pb2
import multclient_pb2_grpc

class Tokisaki_Kurumi(multclient_pb2_grpc.Tokisaki_KurumiServicer):
    def __init__(self) -> None:
        super().__init__()
        self.clientes_conectados = 0
        self.clientes_esperados = 4
        self.clientes_respondidos = 0
        self.trees_warehouse = []

    def aggregate_trees(self, request, context):
        print(f"Árvore Recebida, Client ID: {request.client_ID}")
        self.clientes_conectados += 1
        self.trees_warehouse.append(request.serialised_tree)
        server_reply = multclient_pb2.Tree_Server()

        while True:
            if self.clientes_conectados == self.clientes_esperados:
                for i, tree in enumerate(self.trees_warehouse):
                    print(f"Enviando Árvore: {i+1} de {len(self.trees_warehouse)}, para o Client_ID: {request.client_ID}")
                    server_reply.serialised_tree = tree
                    yield server_reply
                    time.sleep(1)
                
                self.clientes_respondidos += 1

                while True:
                    if self.clientes_respondidos == self.clientes_conectados: break
                    else: time.sleep(5)

                print(f"Fim da Execução, {request.client_ID}")
                break
            else:
                time.sleep(5)
            
    
def rodar_server():
    print("Server On")
    NUCLEOS_DISPONIVEIS = 4
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=NUCLEOS_DISPONIVEIS))
    multclient_pb2_grpc.add_Tokisaki_KurumiServicer_to_server(Tokisaki_Kurumi(), server)
    server.add_insecure_port("localhost:50051")
    server.start()
    server.wait_for_termination()

if __name__ == "__main__":
    rodar_server()