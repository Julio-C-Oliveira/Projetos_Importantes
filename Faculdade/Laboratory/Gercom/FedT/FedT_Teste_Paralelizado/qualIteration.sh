#!/bin/bash

command="cat registro_para_teste.txt | grep 'Iteration'"
tempo=25

while true; do
  echo "Exibindo ás $(date '+%H:%M:%S')"
  env bash -c "$command"
  echo "Próxima exibição em $tempo minutos.\n"
  sleep "${tempo}"m
done
