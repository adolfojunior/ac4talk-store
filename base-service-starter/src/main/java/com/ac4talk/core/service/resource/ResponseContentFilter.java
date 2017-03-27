package com.ac4talk.core.service.resource;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Response.StatusType;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

@Provider
@Component
public class ResponseContentFilter implements ContainerResponseFilter {

  @Override
  public void filter(ContainerRequestContext requestContext,
      ContainerResponseContext responseContext) throws IOException {

    final Object entity = responseContext.getEntity();

    if (entity instanceof ResponseContent) {
      updateResponse(responseContext, (ResponseContent<?>) entity);
    }
  }

  protected void updateResponse(ContainerResponseContext responseContext,
      final ResponseContent<?> responseData) {
    final StatusType statusInfo = responseContext.getStatusInfo();
    if (responseData.getStatus().getStatusCode() != statusInfo.getStatusCode()) {
      responseContext.setStatusInfo(responseData.getStatus());
    }
  }
}