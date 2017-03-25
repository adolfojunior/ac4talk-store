package com.ac4talk.store.promotion.service;

public class InvalidPromotionException extends Exception {

  private static final long serialVersionUID = 1L;

  public InvalidPromotionException(String message, Throwable cause) {
    super(message, cause);
  }

  public InvalidPromotionException(String message) {
    super(message);
  }
}
