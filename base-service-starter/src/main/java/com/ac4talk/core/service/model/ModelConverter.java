package com.ac4talk.core.service.model;

import java.util.function.Function;

public interface ModelConverter {

  <M, T> T convert(M model, Class<T> valueType);

  default <M, T> Function<M, T> mapper(final Class<T> valueType) {
    return (model) -> {
      return convert(model, valueType);
    };
  }
}
