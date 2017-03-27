package com.ac4talk.core.service.resource;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ac4talk.core.service.message.MessageBuilder;

@Provider
public class ResourceExceptionMapper implements ExceptionMapper<Exception> {

  private static final Logger LOGGER = LoggerFactory.getLogger(ResourceExceptionMapper.class);

  @Override
  public Response toResponse(Exception exception) {
    LOGGER.error("Resource failure", exception);
    if (exception instanceof WebApplicationException) {
      return convert((WebApplicationException) exception);
    }
    return toResponse(Status.INTERNAL_SERVER_ERROR, exception);
  }

  protected Response convert(WebApplicationException exception) {
    return ((WebApplicationException) exception).getResponse();
  }

  protected Response toResponse(final Status status, final Exception exception) {
    final ResponseContent<?> content = toContent(status, exception);
    return Response.status(content.getStatus()).entity(content).build();
  }

  protected ResponseContent<?> toContent(final Status status, final Exception exception) {
    return ResponseContentBuilder.to(status)
        .addMessage(MessageBuilder.error().message(exception.getMessage()).build()).build();
  }
}
