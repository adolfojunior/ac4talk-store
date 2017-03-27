package com.ac4talk.core.service.resource;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.Status.Family;

import com.ac4talk.core.service.message.Message;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"status", "statusCode", "family", "messages", "content"})
public class ResponseContent<T> {

  private Status status;
  private Map<Message.Type, List<Message>> messages = new LinkedHashMap<>();
  private T content;

  public ResponseContent() {}

  ResponseContent(final ResponseContent<T> response) {
    this.status = response.status;
    this.content = response.content;
    this.messages.putAll(response.messages);
  }

  void setStatus(final Status status) {
    this.status = status;
  }

  void addMessage(final Message message) {
    messages.computeIfAbsent(message.getType(), type -> new LinkedList<Message>()).add(message);
  }

  void setContent(final T content) {
    this.content = content;
  }

  public Status getStatus() {
    return status;
  }

  public Family getFamily() {
    return getStatus().getFamily();
  }

  public int getStatusCode() {
    return getStatus().getStatusCode();
  }

  public Map<Message.Type, List<Message>> getMessages() {
    return Collections.unmodifiableMap(messages);
  }

  public T getContent() {
    return this.content;
  }

  public boolean hasMessages(final Message.Type type) {
    return !getMessages(type).isEmpty();
  }

  @JsonIgnore
  public List<Message> getMessages(final Message.Type type) {
    return Optional.ofNullable(getMessages().get(type)).orElseGet(Collections::emptyList);
  }

  @JsonIgnore
  public Optional<T> getOptionalContent() {
    return Optional.ofNullable(getContent());
  }
}
