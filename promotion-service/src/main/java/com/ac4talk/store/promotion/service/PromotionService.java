package com.ac4talk.store.promotion.service;

import com.ac4talk.store.promotion.model.Promotion;

public interface PromotionService {

  Promotion findByCode(String code) throws InvalidPromotionException;
}