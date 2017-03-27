
package com.ac4talk.core.service.message;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"type", "code", "message"})
public class Message {

  private Message.Type type;
  private String code;
  private String message;

  public Message() {}

  Message(final Message template) {
    this.type = template.type;
    this.code = template.code;
    this.message = template.message;
  }

  void setType(final Message.Type type) {
    this.type = type;
  }

  void setCode(final String code) {
    this.code = code;
  }

  void setMessage(final String message) {
    this.message = message;
  }

  public Message.Type getType() {
    return type;
  }

  public String getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  @Override
  public String toString() {
    return "Message {type=" + type + ", code=" + code + ", message=" + message + "}";
  }

  public enum Type {

    INFO("info"), ERROR("error");

    private final static Map<String, Message.Type> CONSTANTS = new HashMap<String, Message.Type>();

    private final String value;

    static {
      for (Message.Type c : values()) {
        CONSTANTS.put(c.value, c);
        CONSTANTS.put(c.name(), c);
      }
    }

    private Type(final String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return this.value;
    }

    @JsonValue
    public String value() {
      return this.value;
    }

    @JsonCreator
    public static Message.Type fromValue(final String value) {
      Message.Type constant = CONSTANTS.get(value);
      if (constant == null) {
        throw new IllegalArgumentException(value);
      } else {
        return constant;
      }
    }
  }
}
