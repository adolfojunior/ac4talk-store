# Spring Boot Microservices Sample

Sample Store application composed by 3 microservices.
- Consul as Service Discovery and Configuration Storage.
- HAProxy that use Consul Template to update the instances.

### Build

You will need [Docker](https://www.docker.com)

To build the project you need JDK 8 (or run it using docker)

```shell
docker run -it --rm -v $(pwd):/app -w /app openjdk:8 ./gradlew --version
```

```

### Starting all the services

```
./gradlew clean cleanEclipse eclipse

./gradlew build

./gradlew :promotion-service:bootRun
```

## Running it with Consul and HAProxy

### Running Consul

- Startup Consul

```shell
docker-compose up -d consul
# Follow logs
docker-compose logs -f consul
```

Access the Consul UI (http://consul.lvh.me:8500/ui/#/dc1/services)

- Startup HAProxy

```shell
docker-compose up -d haproxy
# Follow logs
docker-compose logs -f haproxy
```

- Check if consul is updating the config

```
docker exec -it ac4talkstore_haproxy_1 cat /haproxy/haproxy.cfg
```

- Startup Services

```
docker-compose up -d promotion product cart
docker-compose logs -f ${SERVICE}
```

### Testing services

```
curl -X GET "http://promotion-service.lvh.me/api/promotion/PROM20"

curl -X GET "http://product-service.lvh.me/api/product/all"
curl -X GET "http://product-service.lvh.me/api/product/p1"

curl -X GET "http://cart-service.lvh.me/api/cart"

curl -X POST "http://cart-service.lvh.me/api/cart/{id}/{version}/apply-promotion" -d '{ "promotionCode": "PROM20" }'

curl -X POST "http://cart-service.lvh.me/api/cart/{id}/{version}/apply-items" -d '{ "items": [{ "productId": "p1", "qtd": 1 }] }'
```

### References:
- [Spring Boot](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- [Spring Cloud Consul](https://cloud.spring.io/spring-cloud-consul/)
- [Consul](https://github.com/hashicorp/consul)
- [Consul Template](https://github.com/hashicorp/consul-template)
- [HAProxy](https://cbonte.github.io/haproxy-dconv/)
- [Docker Compose](https://docs.docker.com/compose/)

