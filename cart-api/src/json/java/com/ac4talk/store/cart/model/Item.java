
package com.ac4talk.store.cart.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "position",
    "productId",
    "qtd",
    "price"
})
public class Item implements Serializable
{

    @JsonProperty("position")
    private Long position;
    @JsonProperty("productId")
    private String productId;
    @JsonProperty("qtd")
    private Long qtd;
    @JsonProperty("price")
    private Double price;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -5950592302640849522L;

    @JsonProperty("position")
    public Long getPosition() {
        return position;
    }

    @JsonProperty("position")
    public void setPosition(Long position) {
        this.position = position;
    }

    public Item withPosition(Long position) {
        this.position = position;
        return this;
    }

    @JsonProperty("productId")
    public String getProductId() {
        return productId;
    }

    @JsonProperty("productId")
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Item withProductId(String productId) {
        this.productId = productId;
        return this;
    }

    @JsonProperty("qtd")
    public Long getQtd() {
        return qtd;
    }

    @JsonProperty("qtd")
    public void setQtd(Long qtd) {
        this.qtd = qtd;
    }

    public Item withQtd(Long qtd) {
        this.qtd = qtd;
        return this;
    }

    @JsonProperty("price")
    public Double getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Double price) {
        this.price = price;
    }

    public Item withPrice(Double price) {
        this.price = price;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Item withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(position).append(productId).append(qtd).append(price).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Item) == false) {
            return false;
        }
        Item rhs = ((Item) other);
        return new EqualsBuilder().append(position, rhs.position).append(productId, rhs.productId).append(qtd, rhs.qtd).append(price, rhs.price).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
