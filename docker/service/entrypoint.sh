#!/bin/sh
set -e

CONSUL_HOST="consul"
CONSUL_IP=""

# Wait consul for 60 seconds
for i in `seq 1 60`
do
  echo "${i} - trying to connect to '${CONSUL_HOST}'..."
  # sleep for 1 sec to wait for consul
  sleep 1
  # try to resolve consul DNS
  CONSUL_IP=$(getent hosts ${CONSUL_HOST} | awk '{ print $1 }')
  # if available
  if [[ ! -z $CONSUL_IP ]]; then
    echo "${CONSUL_HOST}:${CONSUL_IP} is available!"
    break
  fi
done

# if consul is resolved
if [[ ! -z $CONSUL_IP ]]; then
  echo "registering ${CONSUL_IP} as DNS"
  # Check if consul exist in resolve.conf
  if ! grep -q "#consul" "/etc/resolv.conf"; then
    # add consul as DNS
    echo -e "#consul\nnameserver ${CONSUL_IP}" >> /etc/resolv.conf
  fi
else
  echo "coudn't resolve ${CONSUL_HOST}."
  exit 1
fi

# execute command
exec "$@"
