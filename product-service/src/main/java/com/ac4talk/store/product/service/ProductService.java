package com.ac4talk.store.product.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.ac4talk.store.product.entity.ProductEntity;

public interface ProductService {

  List<ProductEntity> findAll(Pageable pageable);

  List<ProductEntity> findByIds(List<String> ids);
}
