package com.ac4talk.core.service.client;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(RestClientProperties.class)
public class RestClientAutoConfiguration {

  @Bean
  @ConditionalOnMissingBean(RestClientFactory.class)
  public RestClientFactory restClientFactory(final RestClientProperties restClientProperties) {
    return new RestClientFactory(restClientProperties);
  }
}
