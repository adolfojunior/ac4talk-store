FROM openjdk:8-alpine

COPY ./docker-config/service-entrypoint.sh /entrypoint.sh

RUN chmod +x /entrypoint.sh

VOLUME /app
WORKDIR /app

ENV SPRING_CLOUD_CONSUL_HOST=consul
ENV SPRING_PROFILES_ACTIVE=dev,consul
ENV SERVER_PORT=8080

EXPOSE 8080

ENTRYPOINT ["/entrypoint.sh"]
