FROM alpine

ENV CONSUL_TEMPLATE_VERSION=0.18.1
ENV CONSUL_TEMPLATE_URL_DOWNLOAD=https://github.com/hashicorp/consul-template/releases/download/v${CONSUL_TEMPLATE_VERSION}/consul-template_${CONSUL_TEMPLATE_VERSION}_linux_amd64.tar.gz
# Update wget to get support for SSL
RUN apk --update add haproxy wget

# Download consul-template
RUN wget --no-check-certificate ${CONSUL_TEMPLATE_URL_DOWNLOAD} -O /tmp/consul_template.tar.gz; \
    gunzip /tmp/consul_template.tar.gz; \
    cd /tmp; \
    tar xf /tmp/consul_template.tar; \
    cd /tmp/consul-template*; \
    mv consul-template /usr/bin && rm -rf /tmp/*;

COPY files/haproxy.json /tmp/haproxy.json
COPY files/haproxy.ctmpl /tmp/haproxy.ctmpl

CMD ["consul-template", "-config=/tmp/haproxy.json"]
