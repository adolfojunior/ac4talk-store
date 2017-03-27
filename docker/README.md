### Running Consul

- First create a network
```shell
docker network create consul-net
```

```shell
docker run -it --rm \
  --net consul-net \
  --name consul \
  -h consul \
  -p 8400:8400 \
  -p 8500:8500 \
  -p 8600:53/udp \
  progrium/consul -server -bootstrap -ui-dir /ui
```

- Access the Consul UI (http://consul.lvh.me:8500/ui/#/dc1/services)

### Running HAProxy

```shell
docker run -d \
  --net consul-net \
  --restart always \
  --name haproxy \
  -h haproxy \
  -e HAPROXY_DOMAIN=lvh.me \
  -e CONSUL_CONNECT=consul:8500 \
  -p 80:80 \
  asteris/haproxy-consul
```

- Check if consul is updating the config

```
docker exec -it haproxy sh
```

```
docker exec -it haproxy cat /haproxy/haproxy.cfg
```

### Running each application

```shell
docker run -it --rm \
  --net consul-net \
  --name promotion-service2 \
  -v $(pwd)/promotion-service/build/libs:/usr/src/app \
  -w /usr/src/app \
  -e SPRING_CLOUD_CONSUL_HOST=consul \
  -e SERVER_PORT=8080 \
  -p 8080 \
  openjdk:8-alpine java -jar promotion-service-0.0.1-SNAPSHOT.jar 
```
