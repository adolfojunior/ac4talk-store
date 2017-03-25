

docker run -d \
  --cap-add NET_ADMIN \
  --restart=always \
  --link consul:consul \
  --name haproxy \
  -h haproxy \
  -p 80:80 \
  -p 443:443 \
  subitolabs/haproxy-consul-template --consul consul:8500

docker run -d \
  --name consul \
  -p 8400:8400 \
  -p 8500:8500 \
  -p 8600:53/udp \
  -h consul \
  progrium/consul -server -bootstrap -ui-dir /ui






docker run --restart=always -d -p 8500:8500 --name consul -e "SERVICE_IGNORE=true" progrium/consul -server -bootstrap-expect 1

docker run --restart=always --name registrator --link "consul:consul"  -v /var/run/docker.sock:/tmp/docker.sock -d -e "SERVICE_IGNORE=true"  gliderlabs/registrator -internal  consul://consul:8500

docker run --cap-add NET_ADMIN --restart=always --name haproxy --link consul:consul -v $(pwd)/haproxy.ctmpl:/etc/haproxy/haproxy.ctmpl:ro -p 80:80 subitolabs/haproxy-consul-template --consul consul:8500

