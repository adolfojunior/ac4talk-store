package com.ac4talk.store.product.resource.impl;


import java.util.List;

import javax.ws.rs.BeanParam;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import com.ac4talk.core.service.resource.AbstractResource;
import com.ac4talk.core.service.resource.PageableParam;
import com.ac4talk.core.service.resource.ResponseContent;
import com.ac4talk.core.service.resource.ResponseContentBuilder;
import com.ac4talk.store.product.api.ProductResource;
import com.ac4talk.store.product.model.Product;
import com.ac4talk.store.product.service.ProductService;

@Controller
public class ProductResourceImpl extends AbstractResource implements ProductResource {

  private ProductService productService;

  public ProductResourceImpl(final ProductService productService) {
    this.productService = productService;
  }

  @Override
  public ResponseContent<List<Product>> findAll(final @BeanParam PageableParam pageableParam) {
    final Pageable pageable = pageable(pageableParam);
    final List<Product> result = productService.findAll(pageable);
    return responseContentBuilder(result).build();
  }

  @Override
  public ResponseContent<Product> findById(final String id) {
    final Product result = productService.findById(id);
    return ResponseContentBuilder.<Product>ok(result).build();
  }
}
