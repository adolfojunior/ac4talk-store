package com.ac4talk.store.cart.repository;

import com.ac4talk.store.cart.api.CartId;
import com.ac4talk.store.product.model.Cart;


public interface CartRepository {

  Cart findById(CartId cartId);

  Cart getOrCreate();

}