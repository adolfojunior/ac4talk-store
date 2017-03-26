
package com.ac4talk.store.cart.api;

import javax.ws.rs.PathParam;

public class CartId {

  @PathParam("id")
  private String id;
  @PathParam("version")
  private String version;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public CartId withId(String id) {
    this.id = id;
    return this;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public CartId withVersion(String version) {
    this.version = version;
    return this;
  }
}
