package com.ac4talk.store.cart.resource;

import org.springframework.stereotype.Controller;

import com.ac4talk.store.cart.api.CartResource;

@Controller
public class CartResourceImpl implements CartResource {

  @Override
  public String get() {
    return getClass().toString();
  }
}
