package com.ac4talk.store.promotion.client;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ac4talk.core.service.client.RestClientFactory;

@Configuration
public class PromotionClientConfiguration {

  @Bean
  @ConditionalOnMissingBean
  public PromotionClient promotionClient(RestClientFactory clientFactory) {
    return clientFactory.create(PromotionClient.class, "promotion");
  }
}
