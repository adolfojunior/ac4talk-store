package com.ac4talk.store.product.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.ac4talk.store.product.model.Product;

public interface ProductService {

  Product findById(String id);

  List<Product> findAll(Pageable pageable);
}
