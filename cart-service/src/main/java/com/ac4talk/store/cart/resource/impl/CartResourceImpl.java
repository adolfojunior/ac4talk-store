package com.ac4talk.store.cart.resource.impl;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;

import com.ac4talk.core.service.model.ModelConverter;
import com.ac4talk.core.service.resource.AbstractResource;
import com.ac4talk.store.cart.api.CartId;
import com.ac4talk.store.cart.api.CartResource;
import com.ac4talk.store.cart.service.CartService;
import com.ac4talk.store.product.model.AddItems;
import com.ac4talk.store.product.model.ApplyPromotion;

@Controller
public class CartResourceImpl extends AbstractResource implements CartResource {

  private CartService cartService;

  public CartResourceImpl(ModelConverter modelConverter, CartService cartService) {
    super(modelConverter);
    this.cartService = cartService;
  }

  @Override
  public Response addItems(final CartId cartId, final AddItems addItems) {
    return Response.ok(cartService.addItems(cartId, addItems)).build();
  }

  @Override
  public Response applyPromotion(final CartId cartId, final ApplyPromotion applyPromotion) {
    return Response.ok(cartService.applyPromotion(cartId, applyPromotion)).build();
  }
}
