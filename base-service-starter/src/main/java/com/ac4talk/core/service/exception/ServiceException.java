package com.ac4talk.core.service.exception;

public class ServiceException extends Exception {

  private static final long serialVersionUID = 1L;
  
  public ServiceException(String message, Throwable cause) {
    super(message, cause);
  }

  public ServiceException(String message) {
    super(message);
  }
}
