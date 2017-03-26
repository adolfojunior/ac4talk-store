
### Build

First read it all: [Spring Boot Docs](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)

```
./gradlew clean build

java -jar product-service/build/libs/product-service-0.0.1-SNAPSHOT.jar --server.port=8081 > product.log 2>&1 &
java -jar promotion-service/build/libs/promotion-service-0.0.1-SNAPSHOT.jar --server.port=8082 > promotion.log 2>&1 
java -jar cart-service/build/libs/cart-service-0.0.1-SNAPSHOT.jar --server.port=8080 > cart.log 2>&1 

```
