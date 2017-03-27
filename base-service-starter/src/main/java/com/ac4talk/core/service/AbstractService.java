package com.ac4talk.core.service;

import java.util.function.Function;

import com.ac4talk.core.service.model.ModelConverter;

public abstract class AbstractService {

  private ModelConverter modelConverter;

  protected AbstractService(ModelConverter modelConverter) {
    this.modelConverter = modelConverter;
  }

  protected <T> Function<Object, T> mapper(Class<T> valueType) {
    return modelConverter.mapper(valueType);
  }
}
