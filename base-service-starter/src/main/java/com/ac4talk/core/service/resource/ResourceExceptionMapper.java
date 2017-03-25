package com.ac4talk.core.service.resource;

import java.util.Collections;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ac4talk.core.service.model.ErrorMessages;

@Provider
public class ResourceExceptionMapper implements ExceptionMapper<Exception> {

  private static final Logger LOGGER = LoggerFactory.getLogger(ResourceExceptionMapper.class);

  @Override
  public Response toResponse(Exception exception) {
    final ErrorMessages createErrorMessages = createErrorMessages(exception);
    LOGGER.error("Application Error", exception);
    return Response.serverError().entity(createErrorMessages).build();
  }

  protected ErrorMessages createErrorMessages(Exception exception) {
    return new ErrorMessages().withMessages(Collections.singletonList(exception.getMessage()));
  }
}
