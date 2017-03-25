package com.ac4talk.store.promotion.resource;


import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Controller;

import com.ac4talk.store.promotion.api.PromotionResource;
import com.ac4talk.store.promotion.model.Promotion;
import com.ac4talk.store.promotion.service.InvalidPromotionException;
import com.ac4talk.store.promotion.service.PromotionService;

@Controller
public class PromotionResourceImpl implements PromotionResource {

  private PromotionService promotionService;

  public PromotionResourceImpl(final PromotionService promotionService) {
    this.promotionService = promotionService;
  }

  @Override
  public Promotion findByCode(String code) {
    try {
      return promotionService.findByCode(code);
    } catch (InvalidPromotionException e) {
      throw new WebApplicationException(code, e, Status.NOT_FOUND);
    }
  }
}
