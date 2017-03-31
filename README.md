# Spring Boot Microservices Sample

Sample Store application composed by 3 microservices.

- **Core Service** `(base-service-[api|client|starter])`  
    Provide auto configuration for Consul, Jersey and JAX-RS Clients. Also have interceptors for exceptions and base classes for Messages and Generic endpoint responses.
- **Promotion Service** `(promotion-[api|client|service])`
- **Product Service** `(product-[api|client|service])`
- **Cart Service** `(cart-[api|client|service])`
- **Consul** as Service Discovery and Configuration Storage.
- **HAProxy** that use Consul Template to update the instances.  

**API** - Project that contains JAX-RS contracts and Models defined using [JSON Schema](http://json-schema.org/)  
**CLIENT** - [Spring Boot](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/) library that auto configure a RestClient instance that use the JAX-RS contract.  
**SERVICE** - [Spring Boot](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/) application that implements the JAX-RS. 

## Build

Get the project:

```shell
git clone https://github.com/adolfojunior/ac4talk-store.git
cd ac4talk-store
```

We will need [Docker](https://www.docker.com) to run Consul/HAProxy and all the services.

To build the project you need **Java 8** (You can use Docker to not mess with your environment)

Example of a build using docker:

```shell
docker run -it --rm -v $(pwd):/app -w /app openjdk:8 ./gradlew --version
```

### Starting all the services

```shell
# configure project to your IDE
./gradlew cleanEclipse eclipse

# build it!
./gradlew clean build

# run each searvice
./gradlew :promotion-service:bootRun
./gradlew :product-service:bootRun
./gradlew :cart-service:bootRun
```

## Running Consul and HAProxy

We are using [docker-compose](docker-compose.yaml) to make our live easier!

### Running [Consul](https://github.com/hashicorp/consul)

Consul provide an easy way to let services register themselves and to discovery other services via a DNS or HTTP interface.

```shell
docker-compose up -d consul
# Follow logs
docker-compose logs -f consul
```

*** Important: get the Consul IP to use as DNS on all the service instances

```
docker network inspect ac4talkstore_consul-net
```

Access the Consul UI (http://consul.lvh.me:8500/ui/#/dc1/services)

### Running [HAProxy](https://cbonte.github.io/haproxy-dconv/)

HAProxy is a very fast and reliable solution for high availability, load balancing, and proxying for TCP and HTTP-based applications.

We will use [Consul Template](https://github.com/hashicorp/consul-template) to update the HAProxy configuration everytime a new service register/deregister itself.

As part of the configuration, each instance registered on Consul will provide Tags that will be used as subdomains.

```shell
docker-compose up -d haproxy
# Follow logs
docker-compose logs -f haproxy
```

### Running Services

```shell
docker-compose up -d promotion product cart
# looking at the logs
docker-compose logs -f ${SERVICE}
# accessing the instance
docker-compose exec ${SERVICE} sh
```

### Testing

- Check if `consul-template` is updating the config

```shell
docker-compose exec haproxy cat /haproxy/haproxy.cfg
```

- Check consul DNS

```
docker-compose run service-test ping consul.service.consul
```

- Check all the RESTful Endpoints

```shell
curl -X GET "http://promotion-service.lvh.me/api/promotion/PROM20"

curl -X GET "http://product-service.lvh.me/api/product/all"
curl -X GET "http://product-service.lvh.me/api/product/p1"

curl -X GET "http://cart-service.lvh.me/api/cart"

curl -X POST "http://cart-service.lvh.me/api/cart/7acc5201-006f-4193-b67e-0dfc0101cbf1/7acc5201-006f-4193-b67e-0dfc0101cbf1/apply-promotion" \
  -H "Content-Type: application/json" \
  -d '{ "promotionCode": "PROM20" }'

curl -X POST "http://cart-service.lvh.me/api/cart/7acc5201-006f-4193-b67e-0dfc0101cbf1/7acc5201-006f-4193-b67e-0dfc0101cbf1/apply-items" \
  -H "Content-Type: application/json" \
  -d '{ "items": [{ "productId": "p1", "qtd": 1 }] }'
```

### References:
- [Spring Cloud Consul](https://cloud.spring.io/spring-cloud-consul/)
- [Docker Compose](https://docs.docker.com/compose/)

Thank's to https://github.com/levicook for the `lvh.me` domain trick :)

