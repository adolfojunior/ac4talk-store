
package com.ac4talk.store.promotion.model;

import java.io.Serializable;
import java.util.Date;
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
    "code",
    "discountPercentage",
    "discountValue",
    "minimunValue",
    "maximunDiscount",
    "startingDate",
    "expirationDate"
})
public class Promotion implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("code")
    @NotNull
    private String code;
    @JsonProperty("discountPercentage")
    private Double discountPercentage;
    @JsonProperty("discountValue")
    private Double discountValue;
    @JsonProperty("minimunValue")
    private Double minimunValue;
    @JsonProperty("maximunDiscount")
    private Double maximunDiscount;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("startingDate")
    @NotNull
    private Date startingDate;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("expirationDate")
    @NotNull
    private Date expirationDate;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -5690172190995570453L;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    public Promotion withCode(String code) {
        this.code = code;
        return this;
    }

    @JsonProperty("discountPercentage")
    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    @JsonProperty("discountPercentage")
    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Promotion withDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
        return this;
    }

    @JsonProperty("discountValue")
    public Double getDiscountValue() {
        return discountValue;
    }

    @JsonProperty("discountValue")
    public void setDiscountValue(Double discountValue) {
        this.discountValue = discountValue;
    }

    public Promotion withDiscountValue(Double discountValue) {
        this.discountValue = discountValue;
        return this;
    }

    @JsonProperty("minimunValue")
    public Double getMinimunValue() {
        return minimunValue;
    }

    @JsonProperty("minimunValue")
    public void setMinimunValue(Double minimunValue) {
        this.minimunValue = minimunValue;
    }

    public Promotion withMinimunValue(Double minimunValue) {
        this.minimunValue = minimunValue;
        return this;
    }

    @JsonProperty("maximunDiscount")
    public Double getMaximunDiscount() {
        return maximunDiscount;
    }

    @JsonProperty("maximunDiscount")
    public void setMaximunDiscount(Double maximunDiscount) {
        this.maximunDiscount = maximunDiscount;
    }

    public Promotion withMaximunDiscount(Double maximunDiscount) {
        this.maximunDiscount = maximunDiscount;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("startingDate")
    public Date getStartingDate() {
        return startingDate;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("startingDate")
    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Promotion withStartingDate(Date startingDate) {
        this.startingDate = startingDate;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("expirationDate")
    public Date getExpirationDate() {
        return expirationDate;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("expirationDate")
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Promotion withExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
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

    public Promotion withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
