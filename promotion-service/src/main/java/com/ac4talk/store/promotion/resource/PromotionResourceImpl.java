package com.ac4talk.store.promotion.resource;


import org.springframework.stereotype.Controller;

import com.ac4talk.store.promotion.api.PromotionResource;

@Controller
public class PromotionResourceImpl implements PromotionResource {

  @Override
  public String get() {
    return getClass().toString();
  }
}
