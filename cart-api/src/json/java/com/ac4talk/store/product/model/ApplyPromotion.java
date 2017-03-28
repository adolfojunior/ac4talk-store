
package com.ac4talk.store.product.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
    "promotionCode"
})
public class ApplyPromotion implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @NotNull
    @JsonProperty("promotionCode")
    private String promotionCode;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -9152138907927737264L;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("promotionCode")
    public String getPromotionCode() {
        return promotionCode;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("promotionCode")
    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    public ApplyPromotion withPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
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

    public ApplyPromotion withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(promotionCode).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ApplyPromotion) == false) {
            return false;
        }
        ApplyPromotion rhs = ((ApplyPromotion) other);
        return new EqualsBuilder().append(promotionCode, rhs.promotionCode).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
