package com.ac4talk.store.cart.client;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ac4talk.core.service.client.RestClientFactory;

@Configuration
public class CartClientConfiguration {

  @Bean
  @ConditionalOnMissingBean
  public CartClient cartClient(RestClientFactory clientFactory) {
    return clientFactory.create(CartClient.class, "cart");
  }
}
