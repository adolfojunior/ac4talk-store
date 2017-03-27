
package com.ac4talk.store.product.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import com.ac4talk.store.cart.model.Item;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "version",
    "promotions",
    "items",
    "totalPrice",
    "countItems"
})
public class Cart implements Serializable
{

    @JsonProperty("id")
    private String id;
    @JsonProperty("version")
    private String version;
    @JsonProperty("promotions")
    @Valid
    private List<String> promotions = new ArrayList<String>();
    @JsonProperty("items")
    @Valid
    private List<Item> items = new ArrayList<Item>();
    @JsonProperty("totalPrice")
    private Double totalPrice;
    @JsonProperty("countItems")
    private Double countItems;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -7566509436676015845L;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public Cart withId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    public Cart withVersion(String version) {
        this.version = version;
        return this;
    }

    @JsonProperty("promotions")
    public List<String> getPromotions() {
        return promotions;
    }

    @JsonProperty("promotions")
    public void setPromotions(List<String> promotions) {
        this.promotions = promotions;
    }

    public Cart withPromotions(List<String> promotions) {
        this.promotions = promotions;
        return this;
    }

    @JsonProperty("items")
    public List<Item> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Cart withItems(List<Item> items) {
        this.items = items;
        return this;
    }

    @JsonProperty("totalPrice")
    public Double getTotalPrice() {
        return totalPrice;
    }

    @JsonProperty("totalPrice")
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Cart withTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    @JsonProperty("countItems")
    public Double getCountItems() {
        return countItems;
    }

    @JsonProperty("countItems")
    public void setCountItems(Double countItems) {
        this.countItems = countItems;
    }

    public Cart withCountItems(Double countItems) {
        this.countItems = countItems;
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

    public Cart withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
