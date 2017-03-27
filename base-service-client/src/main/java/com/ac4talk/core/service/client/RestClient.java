package com.ac4talk.core.service.client;

import java.util.function.Supplier;

public final class RestClient<T> implements Supplier<T> {

  public static <C> RestClient<C> of(C client) {
    return new RestClient<C>(client);
  }

  private T client;

  private RestClient(T client) {
    this.client = client;
  }

  @Override
  public T get() {
    return client;
  }
}
