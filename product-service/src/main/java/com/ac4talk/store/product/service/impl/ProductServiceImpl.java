package com.ac4talk.store.product.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ac4talk.core.service.AbstractService;
import com.ac4talk.core.service.model.ModelConverter;
import com.ac4talk.core.service.model.ModelNotFoundException;
import com.ac4talk.store.product.entity.ProductEntity;
import com.ac4talk.store.product.model.Product;
import com.ac4talk.store.product.repository.ProductRepository;
import com.ac4talk.store.product.service.ProductService;

@Service
@Transactional(readOnly = true)
public class ProductServiceImpl extends AbstractService implements ProductService {

  private ProductRepository productRepository;

  public ProductServiceImpl(final ModelConverter modelConverter,
      final ProductRepository productRepository) {
    super(modelConverter);
    this.productRepository = productRepository;
  }

  @Override
  public List<Product> findAll(final Pageable pageable) {
    final Stream<ProductEntity> result = productRepository.findAll(pageable);
    return result.map(mapper(Product.class)).collect(Collectors.toList());
  }

  @Override
  public Product findById(final String id) throws ModelNotFoundException {
    final Optional<ProductEntity> result = productRepository.findById(id);
    return result.map(mapper(Product.class)).orElseThrow(() -> new ModelNotFoundException(id));
  }
}
