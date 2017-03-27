package com.ac4talk.store.cart.repository.impl;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Repository;

import com.ac4talk.core.service.model.ModelNotFoundException;
import com.ac4talk.store.cart.api.CartId;
import com.ac4talk.store.cart.repository.CartRepository;
import com.ac4talk.store.product.model.Cart;

@Repository
public class CartRepositoryImpl implements CartRepository {

  private ConcurrentMap<CartId, Cart> cache = new ConcurrentHashMap<>();

  @Override
  public Cart findById(final CartId cartId) {
    return Optional.ofNullable(this.cache.get(cartId))
        .orElseThrow(() -> new ModelNotFoundException("Cart not found"));
  }

  @Override
  public Cart getOrCreate() {
    final CartId cartId = createCartId();
    return this.cache.computeIfAbsent(cartId,
        key -> new Cart().withId(key.getId()).withVersion(key.getVersion()));
  }

  protected CartId createCartId() {
    final String id = UUID.randomUUID().toString();
    return new CartId().withId(id).withVersion(id);
  }
}
