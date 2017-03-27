package com.ac4talk.core.service.model;

import java.util.function.Function;

public interface ModelConverter {

  <T, V> V convert(T model, Class<V> valueType);

  default <T, V> Function<T, V> mapper(final Class<V> valueType) {
    return (model) -> {
      return convert(model, valueType);
    };
  }
}
