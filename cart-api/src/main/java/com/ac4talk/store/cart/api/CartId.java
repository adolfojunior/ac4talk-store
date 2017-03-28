
package com.ac4talk.store.cart.api;

import javax.ws.rs.PathParam;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

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

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(id).append(version).toHashCode();
  }

  @Override
  public boolean equals(final Object other) {
    if (other == this) {
      return true;
    } else if (other instanceof CartId) {
      CartId obj = ((CartId) other);
      return new EqualsBuilder().append(id, obj.id).append(version, obj.version).isEquals();
    }
    return false;
  }
}
