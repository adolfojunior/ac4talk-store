package com.ac4talk.core.service.resource;

import javax.ws.rs.core.Response.Status;

import com.ac4talk.core.service.message.Message;

public class ResponseContentBuilder<T> {

  public static <C> ResponseContentBuilder<C> to(final Status status) {
    return new ResponseContentBuilder<C>().status(status);
  }

  public static <C> ResponseContentBuilder<C> ok() {
    return to(Status.OK);
  }

  public static <C> ResponseContentBuilder<C> ok(C content) {
    return ResponseContentBuilder.<C>ok().content(content);
  }

  public static <C> ResponseContentBuilder<C> noContent() {
    return to(Status.NO_CONTENT);
  }

  public static <C> ResponseContentBuilder<C> notFound() {
    return to(Status.NOT_FOUND);
  }

  public static <C> ResponseContentBuilder<C> created() {
    return to(Status.CREATED);
  }

  public static <C> ResponseContentBuilder<C> created(C content) {
    return ResponseContentBuilder.<C>created().content(content);
  }

  public static <C> ResponseContentBuilder<C> gone() {
    return to(Status.GONE);
  }

  public static <C> ResponseContentBuilder<C> serverError() {
    return to(Status.INTERNAL_SERVER_ERROR);
  }

  public static <C> ResponseContentBuilder<C> notImplemented() {
    return to(Status.NOT_IMPLEMENTED);
  }

  public static <C> ResponseContentBuilder<C> bagGateway() {
    return to(Status.BAD_GATEWAY);
  }

  public static <C> ResponseContentBuilder<C> bagRequest() {
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
