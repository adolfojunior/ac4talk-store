package com.ac4talk.core.service.message;

public class MessageBuilder {

  public static MessageBuilder error() {
    return new MessageBuilder().type(Message.Type.ERROR);
  }

  public static MessageBuilder info() {
    return new MessageBuilder().type(Message.Type.INFO);
  }

  private Message template = new Message();

  private MessageBuilder() {}

  public MessageBuilder type(final Message.Type type) {
    template.setType(type);
    return this;
  }

  public MessageBuilder code(final String code) {
    template.setCode(code);
    return this;
  }

  public MessageBuilder message(final String message) {
    template.setMessage(message);
    return this;
  }

  public Message build() {
    return new Message(this.template);
  }
}
