package com.ac4talk.core.service.model;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class ModelConverterAutoConfiguration {

  @Bean
  @ConditionalOnClass(ObjectMapper.class)
  public ModelConverter modelConverter(ObjectMapper objectMapper) {
    return new ObjectMapperModelConverter(objectMapper);
  }
}
