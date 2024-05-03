from concurrent import futures
import time

import grpc
import teste02_pb2
import teste02_pb2_grpc

class RiasService(teste02_pb2_grpc.RiasServicer):
    def receive_tree(self, request, context):
        print(f"Árvore Recebida: {request.client_ID}")
        server_reply = teste02_pb2.Tree()
        server_reply.client_ID = 0
        server_reply.serialised_tree = request.serialised_tree

        for i in range(3):
            print(f"Enviando Árvore: {i+1}")
            yield server_reply
            time.sleep(1)
    
def serve():
    print("Server On")
    NUCLEOS_DISPONIVEIS = 4
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=NUCLEOS_DISPONIVEIS))
    teste02_pb2_grpc.add_RiasServicer_to_server(RiasService(), server)
    server.add_insecure_port("localhost:50051")
    server.start()
    server.wait_for_termination()

if __name__ == "__main__":
    serve()