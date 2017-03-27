package com.ac4talk.core.service.resource;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

@Provider
@Component
public class CorsResponseFilter implements ContainerResponseFilter {

  private static final String ALLOW_ORIGIN = "Access-Control-Allow-Origin";
  private static final String ALLOW_METHODS = "Access-Control-Allow-Methods";
  private static final String ALLOW_HEADERS = "Access-Control-Allow-Headers";

  private static final String ALLOWED_HEADERS = "X-Requested-With, Content-Type";
  private static final String ALLOWED_METHODS = "GET,POST,PUT,DELETE,HEAD,OPTIONS,TRACE,PATH";

  public void filter(ContainerRequestContext requestContext,
      ContainerResponseContext responseContext) throws IOException {

    final MultivaluedMap<String, Object> headers = responseContext.getHeaders();

    headers.add(ALLOW_ORIGIN, "*");
    headers.add(ALLOW_METHODS, ALLOWED_METHODS);
    headers.add(ALLOW_HEADERS, ALLOWED_HEADERS);
  }
}
