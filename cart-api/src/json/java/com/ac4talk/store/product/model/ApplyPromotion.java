
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
    private final static long serialVersionUID = 8317527523091422890L;

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

}
