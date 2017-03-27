package com.ac4talk.store.promotion.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ac4talk.core.service.client.RestClient;
import com.ac4talk.core.service.client.RestClientFactory;
import com.ac4talk.store.promotion.api.PromotionResource;

@Configuration
public class PromotionClientConfiguration {

  @Bean
  public RestClient<PromotionResource> promotionClient(RestClientFactory clientFactory) {
    final PromotionResource resource = clientFactory.create(PromotionResource.class, "promotion");
    return RestClient.of(resource);
  }
}
