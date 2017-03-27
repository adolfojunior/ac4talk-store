package com.ac4talk.store.cart.resource.impl;

import org.springframework.stereotype.Controller;

import com.ac4talk.core.service.resource.AbstractResource;
import com.ac4talk.core.service.resource.ResponseContent;
import com.ac4talk.core.service.resource.ResponseContentBuilder;
import com.ac4talk.store.cart.api.CartId;
import com.ac4talk.store.cart.api.CartResource;
import com.ac4talk.store.cart.service.CartService;
import com.ac4talk.store.product.model.AddItems;
import com.ac4talk.store.product.model.ApplyPromotion;
import com.ac4talk.store.product.model.Cart;

@Controller
public class CartResourceImpl extends AbstractResource implements CartResource {

  private CartService cartService;

  public CartResourceImpl(final CartService cartService) {
    this.cartService = cartService;
  }

  @Override
  public ResponseContent<Cart> getCart() {
    return ResponseContentBuilder.<Cart>ok().content(cartService.getOrCreate()).build();
  }

  @Override
  public ResponseContent<Cart> addItems(final CartId cartId, final AddItems addItems) {
    return ResponseContentBuilder.<Cart>ok().content(cartService.addItems(cartId, addItems))
        .build();
  }

  @Override
  public ResponseContent<Cart> applyPromotion(final CartId cartId,
      final ApplyPromotion applyPromotion) {
    return ResponseContentBuilder.<Cart>ok()
        .content(cartService.applyPromotion(cartId, applyPromotion)).build();
  }
}
