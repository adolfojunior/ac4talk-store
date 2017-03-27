
### Build

First read it all: [Spring Boot Docs](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)

```
./gradlew clean build

java -jar product-service/build/libs/product-service-0.0.1-SNAPSHOT.jar > product.log 2>&1 & \
java -jar promotion-service/build/libs/promotion-service-0.0.1-SNAPSHOT.jar > promotion.log 2>&1 & \
java -jar cart-service/build/libs/cart-service-0.0.1-SNAPSHOT.jar > cart.log 2>&1 &
```

```
kill $(ps aux | grep 'java -jar .*service' | awk '{print $2}')
```

```
curl -X GET "http://localhost:8082/api/promotion/PROM20"

curl -X GET "http://localhost:8081/api/product/all"
curl -X GET "http://localhost:8081/api/product/p1"
curl -X GET "http://localhost:8081/api/product/p1"
```
