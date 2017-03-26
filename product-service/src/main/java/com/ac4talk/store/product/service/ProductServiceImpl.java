package com.ac4talk.store.product.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ac4talk.store.product.entity.ProductEntity;
import com.ac4talk.store.product.repository.ProductRepository;

@Service
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

  private ProductRepository productRepository;

  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public List<ProductEntity> findAll(final Pageable pageable) {
    return productRepository.findAll(pageable);
  }

  @Override
  public List<ProductEntity> findByIds(final List<String> ids) {
    return productRepository.findByIds(ids);
  }
}
