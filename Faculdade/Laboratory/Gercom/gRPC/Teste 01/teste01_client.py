import teste01_pb2_grpc
import teste01_pb2
import time
import grpc

def get_client_stream_requests():
    while True:
        name = input("Please enter a name (or nothing to stop chatting): ")

        if name == "":
            break

        sox_request = teste01_pb2.SoxRequest(greeting = "Omaiwa mou shindeiru", name = name)
        yield sox_request
        time.sleep(1)

def run():
    with grpc.insecure_channel("localhost:50051") as channel:
        stub = teste01_pb2_grpc.GiornoGiovannaStub(channel)
        print("1. Yume - Unary")
        print("2. Combo - Server Side Streaming")
        print("3. King Crimson - Client Side Streaming")
        print("4. GER - Both Streaming")
        rpc_call = input("Escolhe uma opção ai: ")

        match rpc_call:
            case "1":
                nome = "Dio Brando"
                sox_request = teste01_pb2.SoxRequest(name=nome, greeting="Kono Giorno Giovanna Niwa Yume ga Aru")
                sox_reply = stub.SayYume(sox_request)
                print("Mensagem Enviada: ")
                print(sox_reply)

            case "2":
                nome = "Shrek"
                sox_request = teste01_pb2.SoxRequest(name=nome, greeting="Muda Muda Muda Muda Mudaaaaaaaaaaaaaa")
                sox_replyies = stub.Combo(sox_request)

                for sox_reply in sox_replyies:
                    print(sox_reply)

            case "3":
                # teste = [teste01_pb2.SoxRequest(greeting = "Hello", name = "High School"), teste01_pb2.SoxRequest(greeting = "Hello", name = "DxD")]
                sox_delayed_reply = stub.KingCrimson(get_client_stream_requests())
                print(sox_delayed_reply)

            case "4":
                responses = stub.GoldenExperienceRequiem(get_client_stream_requests())

                for response in responses:
                    print(response)
            case _:
                print("Fora de Alcance")

if __name__ == "__main__":
    run()