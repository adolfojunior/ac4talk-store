#!/bin/sh
set -e

# Check if consul exist in resolve.conf
if ! grep -q "#consul" "/etc/resolv.conf"; then
  # get consul IP to use as DNS
  consul_ip=$(getent hosts consul | awk '{ print $1 }')
  # add consul as DNS
  echo -e "#consul\nnameserver ${consul_ip}" >> /etc/resolv.conf
fi

exec "$@"
