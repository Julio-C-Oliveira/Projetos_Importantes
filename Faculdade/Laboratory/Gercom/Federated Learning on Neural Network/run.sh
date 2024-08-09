#!/bin/bash
set -e
cd "$( cd "$( dirname "$0" )" >/dev/null 2>&1 && pwd )"/

echo "Starting server"
python server.py &
sleep 10 

for i in $(seq 0 3); do
    echo "Starting client $i"
    python client.py --partition-id "$i" &
    sleep 20
done

wait