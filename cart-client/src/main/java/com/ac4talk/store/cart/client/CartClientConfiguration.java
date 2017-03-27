package com.ac4talk.store.cart.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ac4talk.core.service.client.RestClient;
import com.ac4talk.core.service.client.RestClientFactory;
import com.ac4talk.store.cart.api.CartResource;

@Configuration
public class CartClientConfiguration {

  @Bean
  public RestClient<CartResource> cartClient(final RestClientFactory clientFactory) {
    return RestClient.of(clientFactory.create(CartResource.class, "cart"));
  }
}
