
package com.ac4talk.store.product.model;

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
    "productId",
    "qtd"
})
public class AddItem implements Serializable
{

    @JsonProperty("productId")
    private String productId;
    @JsonProperty("qtd")
    private Long qtd;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 6821510046211771451L;

    @JsonProperty("productId")
    public String getProductId() {
        return productId;
    }

    @JsonProperty("productId")
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public AddItem withProductId(String productId) {
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

    public AddItem withQtd(Long qtd) {
        this.qtd = qtd;
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

    public AddItem withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(productId).append(qtd).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AddItem) == false) {
            return false;
        }
        AddItem rhs = ((AddItem) other);
        return new EqualsBuilder().append(productId, rhs.productId).append(qtd, rhs.qtd).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
