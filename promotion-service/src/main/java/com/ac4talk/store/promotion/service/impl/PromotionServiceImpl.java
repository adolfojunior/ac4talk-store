package com.ac4talk.store.promotion.service.impl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.ac4talk.store.promotion.model.Promotion;
import com.ac4talk.store.promotion.service.InvalidPromotionException;
import com.ac4talk.store.promotion.service.PromotionService;

@Service
public class PromotionServiceImpl implements PromotionService {

  private static final Pattern PROMO_CODE =
      Pattern.compile("PROM(\\d{1,2})", Pattern.CASE_INSENSITIVE);

  @Override
  public Promotion findByCode(final String promotionCode) throws InvalidPromotionException {
    final Matcher matcher = PROMO_CODE.matcher(promotionCode);
    if (matcher.matches()) {
      final String code = matcher.group(0).toUpperCase();
      final Double discountPercentage = Double.valueOf(matcher.group(1));
      return new Promotion().withCode(code).withDiscountPercentage(discountPercentage)
          .withExpirationDate(expirationDate(3, ChronoUnit.DAYS)).withMaximunDiscount(100.0)
          .withMinimunValue(10.0);
    } else {
      throw new InvalidPromotionException("Invalid promotion code: " + promotionCode);
    }
  }

  private Date expirationDate(final int value, final ChronoUnit unit) {
    return Date.from(Instant.now().plus(value, unit));
  }
}
