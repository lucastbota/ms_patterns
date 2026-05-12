#!/bin/sh
set -e

echo "Aguardando Kafka Connect..."

until curl -s http://connect:8083/connectors > /dev/null; do
  sleep 5
done

echo "Kafka Connect disponível."

echo "Verificando se connector existe..."

if curl -sf http://connect:8083/connectors/outbox-connector > /dev/null; then
  echo "Connector já existe. Ignorando criação."
else
  echo "Criando connector outbox-connector..."
  curl -X POST \
       -H "Content-Type: application/json" \
       --data @/connector.json \
       http://connect:8083/connectors
fi
