package com.ac4talk.core.service.resource;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jersey.JerseyAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(ResourceConfig.class)
@AutoConfigureBefore(JerseyAutoConfiguration.class)
public class ResourceAutoConfiguration {

  @Bean
  @ConditionalOnMissingBean(ResourceConfig.class)
  public ResourceConfig resourceConfig() {
    return new ResourceConfig();
  }

  @Bean
  @ConditionalOnMissingBean(ResourceAutoRegistrar.class)
  public ResourceAutoRegistrar resourceAutoConfig(ApplicationContext applicationContext) {
    return new ResourceAutoRegistrar(applicationContext);
  }
}
