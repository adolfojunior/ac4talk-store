package com.ac4talk.store.product.client;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ac4talk.core.service.client.RestClientFactory;

@Configuration
public class ProductClientConfiguration {

  @Bean
  @ConditionalOnMissingBean
  public ProductClient productClient(RestClientFactory clientFactory) {
    return clientFactory.create(ProductClient.class, "product");
  }
}
