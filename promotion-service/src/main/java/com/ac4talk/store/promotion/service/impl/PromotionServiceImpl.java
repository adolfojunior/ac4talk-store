package com.ac4talk.store.promotion.service.impl;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.ac4talk.store.promotion.model.Promotion;
import com.ac4talk.store.promotion.service.InvalidPromotionException;
import com.ac4talk.store.promotion.service.PromotionService;

@Service
public class PromotionServiceImpl implements PromotionService {

  private Pattern PROMO_CODE = Pattern.compile("PROMO(\\d{1,2})", Pattern.CASE_INSENSITIVE);

  @Override
  public Promotion findByCode(final String code) throws InvalidPromotionException {
    final Matcher matcher = PROMO_CODE.matcher(code);
    if (matcher.matches()) {
      final Double discountPercentage = Double.valueOf(matcher.group(1));
      return new Promotion()
          .withDiscountPercentage(discountPercentage)
          .withExpirationDate(new Date());
    } else {
      throw new InvalidPromotionException(code);
    }
  }
}
