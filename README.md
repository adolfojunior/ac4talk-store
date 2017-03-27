
### Build

First read it all: [Spring Boot Docs](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)

### Starting all the services

```
./gradlew clean build

java -jar product-service/build/libs/product-service-0.0.1-SNAPSHOT.jar > product.log 2>&1 & \
java -jar promotion-service/build/libs/promotion-service-0.0.1-SNAPSHOT.jar > promotion.log 2>&1 & \
java -jar cart-service/build/libs/cart-service-0.0.1-SNAPSHOT.jar > cart.log 2>&1 &
```
- killing all

```
kill $(ps aux | grep '[j]ava -jar .*service' | awk '{print $2}')
```

### Testing services

```
curl -X GET "http://promotion.lvh.me:8082/api/promotion/PROM20"

curl -X GET "http://product.lvh.me:8081/api/product/all"
curl -X GET "http://product.lvh.me:8081/api/product/p1"

curl -X GET "http://cart.lvh.me:8080/api/cart"

curl -X POST "http://cart.lvh.me:8080/api/cart/{id}/{version}/apply-promotion" -d '{ "promotionCode": "PROM20" }'

curl -X POST "http://cart.lvh.me:8080/api/cart/{id}/{version}/apply-items" -d '{ "items": [{ "productId": "p1", "qtd": 1 }] }'

```
