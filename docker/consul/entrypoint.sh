#!/bin/sh
set -e

CONSUL_OPTIONS=""

# only if the command starts with consul
if [ "$1" = "agent" ]; then
  shift

  RECURSOR_DNS=$(grep -m 1 nameserver /etc/resolv.conf | awk '{ print $2 }')

  # if available
  if [[ ! -z $RECURSOR_DNS ]]; then
    echo "using ${RECURSOR_DNS} as recursor"
    set -- consul agent -recursor="${RECURSOR_DNS}" "$@"
  else
    echo "recursor DNS not available!"
    exit 1
  fi
fi

# execute command
exec "$@"
