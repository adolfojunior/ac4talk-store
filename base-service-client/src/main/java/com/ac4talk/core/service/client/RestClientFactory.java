package com.ac4talk.core.service.client;

import java.net.URISyntaxException;
import java.util.Optional;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.client.proxy.WebResourceFactory;

import com.ac4talk.core.service.client.RestClientProperties.ClientProperties;

public class RestClientFactory {

  private RestClientProperties restClientProperties;

  public RestClientFactory(RestClientProperties restClientProperties) {
    this.restClientProperties = restClientProperties;
  }

  public <T> T create(final Class<T> jaxrsInterface, final String clientName) {
    return create(jaxrsInterface, restClientProperties.getClient(clientName));
  }

  public <T> T create(final Class<T> jaxrsInterface, final ClientProperties clientProperties) {
    try {
      return createClient(jaxrsInterface, createWebTarget(clientProperties));
    } catch (URISyntaxException e) {
      throw new IllegalArgumentException("Invalid client config:" + clientProperties);
    }
  }

  protected <T> T createClient(final Class<T> jaxrsInterface, final WebTarget webTarget) {
    return WebResourceFactory.newResource(jaxrsInterface, webTarget);
  }

  protected WebTarget createWebTarget(final ClientProperties clientProperties)
      throws URISyntaxException {
    final WebTarget target = ClientBuilder.newBuilder().build().target(clientProperties.getUrl());
    Optional.ofNullable(clientProperties.getConnectionTimeout()).ifPresent(timeout -> {
      target.property(org.glassfish.jersey.client.ClientProperties.CONNECT_TIMEOUT, timeout);
    });
    Optional.ofNullable(clientProperties.getReadTimeout()).ifPresent(timeout -> {
      target.property(org.glassfish.jersey.client.ClientProperties.READ_TIMEOUT, timeout);
    });
    return target;
  }
}

