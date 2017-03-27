package com.ac4talk.core.service.resource;

import javax.ws.rs.core.Response.Status;

import com.ac4talk.core.service.message.Message;

public class ResponseContentBuilder<T> {

  public static <D> ResponseContentBuilder<D> to(final Status status) {
    return new ResponseContentBuilder<D>().status(status);
  }

  public static <D> ResponseContentBuilder<D> ok() {
    return to(Status.OK);
  }

  public static <D> ResponseContentBuilder<D> noContent() {
    return to(Status.NO_CONTENT);
  }

  public static <D> ResponseContentBuilder<D> notFound() {
    return to(Status.NOT_FOUND);
  }

  public static <D> ResponseContentBuilder<D> created() {
    return to(Status.CREATED);
  }

  public static <D> ResponseContentBuilder<D> gone() {
    return to(Status.GONE);
  }

  public static <D> ResponseContentBuilder<D> serverError() {
    return to(Status.INTERNAL_SERVER_ERROR);
  }

  public static <D> ResponseContentBuilder<D> notImplemented() {
    return to(Status.NOT_IMPLEMENTED);
  }

  public static <D> ResponseContentBuilder<D> bagGateway() {
    return to(Status.BAD_GATEWAY);
  }

  public static <D> ResponseContentBuilder<D> bagRequest() {
    return to(Status.BAD_REQUEST);
  }

  private ResponseContent<T> template = new ResponseContent<T>();

  private ResponseContentBuilder() {}

  public ResponseContentBuilder<T> status(final Status status) {
    template.setStatus(status);
    return this;
  }

  public ResponseContentBuilder<T> content(final T content) {
    template.setContent(content);
    return this;
  }

  public ResponseContentBuilder<T> addMessage(final Message message) {
    template.addMessage(message);
    return this;
  }

  public ResponseContent<T> build() {
    return new ResponseContent<T>(this.template);
  }
}
