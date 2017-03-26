package com.ac4talk.store.cart.service;

import com.ac4talk.store.cart.api.CartId;
import com.ac4talk.store.product.model.AddItems;
import com.ac4talk.store.product.model.ApplyPromotion;
import com.ac4talk.store.product.model.Cart;

public interface CartService {

  Cart addItems(CartId cartId, AddItems addItems);

  Cart applyPromotion(CartId cartId, ApplyPromotion addItems);
}
