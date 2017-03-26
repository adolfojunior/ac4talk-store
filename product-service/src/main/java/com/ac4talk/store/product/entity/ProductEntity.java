package com.ac4talk.store.product.entity;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PRODUCTS")
public class ProductEntity {

  @Id
  private String id;

  @NotNull
  private String name;

  @NotNull
  private String description;

  @NotNull
  private Double price;

  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(name = "PRODUCT_TAGS", joinColumns = @JoinColumn(name = "PRODUCT_ID"))
  @Column(name = "TAG")
  private Set<String> tags;

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ProductEntity withDescription(String description) {
    this.description = description;
    return this;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ProductEntity withId(String id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProductEntity withName(String name) {
    this.name = name;
    return this;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public ProductEntity withPrice(Double price) {
    this.price = price;
    return this;
  }

  public Set<String> getTags() {
    return tags;
  }

  public void setTags(Set<String> tags) {
    this.tags = tags;
  }

  public ProductEntity withTags(Set<String> tags) {
    this.tags = tags;
    return this;
  }
}
