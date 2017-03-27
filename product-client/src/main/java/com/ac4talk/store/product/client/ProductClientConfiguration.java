package com.ac4talk.store.product.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ac4talk.core.service.client.RestClient;
import com.ac4talk.core.service.client.RestClientFactory;
import com.ac4talk.store.product.api.ProductResource;

@Configuration
public class ProductClientConfiguration {

  @Bean
  public RestClient<ProductResource> productClient(RestClientFactory clientFactory) {
    final ProductResource resource = clientFactory.create(ProductResource.class, "product");
    return RestClient.of(resource);
  }
}
