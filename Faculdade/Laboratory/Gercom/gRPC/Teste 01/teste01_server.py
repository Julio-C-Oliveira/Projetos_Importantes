from concurrent import futures

import teste01_pb2_grpc
import teste01_pb2
import time
import grpc

class GiornoService(teste01_pb2_grpc.GiornoGiovannaServicer):
    def SayYume(self, request, context):
        sox_reply = teste01_pb2.SoxReply()
        sox_reply.message = f"{request.name}, {request.greeting}!"
        print(sox_reply)
        return sox_reply
    
    def Combo(self, request, context):
        print(request)

        for i in range(3):
            sox_reply = teste01_pb2.SoxReply()
            sox_reply.message = f"{request.name}, {request.greeting}!"
            yield sox_reply
            time.sleep(1)
    
    def KingCrimson(self, request_iterator, context):
        sox_delayed_reply = teste01_pb2.SoxDelayedReply()
        for request in request_iterator:
            print(request)
            sox_delayed_reply.request.append(request)

        sox_delayed_reply.message = f"Você enviou {len(sox_delayed_reply.request)}"
        return sox_delayed_reply
    
    def GoldenExperienceRequiem(self, request_iterator, context):
        for request in request_iterator:
            print(request)

            sox_reply = teste01_pb2.SoxReply()
            sox_reply.message = f"{request.name}, {request.greeting}"

            yield sox_reply

def serve():
    print("Server On")
    NUCLEOS_DISPONIVEIS = 4
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=NUCLEOS_DISPONIVEIS))
    teste01_pb2_grpc.add_GiornoGiovannaServicer_to_server(GiornoService(), server)
    server.add_insecure_port("localhost:50051")
    server.start()
    server.wait_for_termination()

if __name__ == "__main__":
    serve()