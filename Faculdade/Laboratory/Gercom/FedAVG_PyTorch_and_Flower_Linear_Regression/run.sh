#!/bin/bash
set -e
cd "$( cd "$( dirname "$0" )" >/dev/null 2>&1 && pwd )"/

echo "Starting server"
python server.py &
sleep 10  # Sleep for 3s to give the server enough time to start

# Com 2 clientes roda tranquilo, com 3 fica no máximo do PC.

for i in $(seq 0 3); do
    echo "Starting client $i"
    python client.py --partition-id "$i" &
    sleep 20
done

# Enable CTRL+C to stop all background processes 
#trap "trap - SIGTERM && kill -- $$" SIGINT SIGTERM
# Wait for all background processes to complete
wait
# cd test/Client_Server && python3 client.py 
# cd test/Client_Server && sh run.sh