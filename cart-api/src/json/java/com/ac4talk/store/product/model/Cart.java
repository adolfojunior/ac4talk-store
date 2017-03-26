
package com.ac4talk.store.product.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
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
    "items"
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
    private List<AddItem> items = new ArrayList<AddItem>();
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 5878301886861363738L;

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
    public List<AddItem> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<AddItem> items) {
        this.items = items;
    }

    public Cart withItems(List<AddItem> items) {
        this.items = items;
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
