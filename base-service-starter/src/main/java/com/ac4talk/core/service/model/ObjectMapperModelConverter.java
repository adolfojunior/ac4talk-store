package com.ac4talk.core.service.model;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperModelConverter implements ModelConverter {

  private ObjectMapper objectMapper;

  public ObjectMapperModelConverter(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  @Override
  public <M, V> V convert(final M model, final Class<V> toValue) {
    return objectMapper.convertValue(model, toValue);
  }
}
