package com.ac4talk.store.promotion.service;

import com.ac4talk.core.service.exception.ServiceException;
import com.ac4talk.core.service.message.MessageBuilder;

public class InvalidPromotionException extends ServiceException {

  private static final long serialVersionUID = 1L;

  public InvalidPromotionException(final String message) {
    super(MessageBuilder.error().message(message).build());
  }
}
