package com.ac4talk.store.promotion.resource.impl;


import org.springframework.stereotype.Controller;

import com.ac4talk.core.service.message.MessageBuilder;
import com.ac4talk.core.service.resource.AbstractResource;
import com.ac4talk.core.service.resource.ResponseContent;
import com.ac4talk.core.service.resource.ResponseContentBuilder;
import com.ac4talk.store.promotion.api.PromotionResource;
import com.ac4talk.store.promotion.model.Promotion;
import com.ac4talk.store.promotion.service.InvalidPromotionException;
import com.ac4talk.store.promotion.service.PromotionService;

@Controller
public class PromotionResourceImpl extends AbstractResource implements PromotionResource {

  private PromotionService promotionService;

  public PromotionResourceImpl(final PromotionService promotionService) {
    this.promotionService = promotionService;
  }

  @Override
  public ResponseContent<Promotion> findByCode(final String promotionCode) {
    try {
      return ResponseContentBuilder.<Promotion>ok(promotionService.findByCode(promotionCode))
          .build();
    } catch (InvalidPromotionException e) {
      return ResponseContentBuilder.<Promotion>notFound()
          .addMessage(MessageBuilder.error().message("Invalid promotion: " + promotionCode).build())
          .build();
    }
  }
}
