package com.ac4talk.store.product.resource;


import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.ac4talk.store.product.api.ProductResource;
import com.ac4talk.store.product.model.Product;

@Controller
public class ProductResourceImpl implements ProductResource {

  @Override
  public String get() {
    return getClass().toString();
  }

  @Override
  public List<Product> listAll() {
    return Collections.singletonList(new Product());
  }
}
