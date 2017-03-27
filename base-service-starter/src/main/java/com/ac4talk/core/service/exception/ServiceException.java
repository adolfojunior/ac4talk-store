package com.ac4talk.core.service.exception;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.ac4talk.core.service.message.Message;

public class ServiceException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private List<Message> messages;

  public ServiceException(Message message) {
    this(message, null);
  }

  public ServiceException(final List<Message> messages) {
    this(messages, null);
  }

  public ServiceException(final Message message, final Throwable cause) {
    this(Optional.ofNullable(message).map(Collections::singletonList).orElse(null), cause);
  }

  public ServiceException(final List<Message> messages, final Throwable cause) {
    super(cause);
    this.messages = Optional.ofNullable(messages).orElseGet(Collections::emptyList);
  }

  public List<Message> getMessages() {
    return messages;
  }
}
