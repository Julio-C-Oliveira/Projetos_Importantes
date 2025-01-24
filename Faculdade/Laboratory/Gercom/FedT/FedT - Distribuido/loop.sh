#!/bin/bash

for i in $(seq 0 3); do
    echo "Starting Client $i"
    cd "/home/juliocoliveira/Área de Trabalho/Rede Distribuida/gRPC/FedT - Distribuido" && python3 client.py --client-id "$i" &
    sleep 5
done

wait