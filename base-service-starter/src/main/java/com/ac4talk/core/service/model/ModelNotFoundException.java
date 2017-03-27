package com.ac4talk.core.service.model;

import com.ac4talk.core.service.exception.ServiceException;
import com.ac4talk.core.service.message.MessageBuilder;

public class ModelNotFoundException extends ServiceException {

  private static final long serialVersionUID = 1L;

  public ModelNotFoundException(final String message) {
    super(MessageBuilder.error().message(message).build());
  }
}

