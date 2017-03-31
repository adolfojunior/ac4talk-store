package com.ac4talk.store.product.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.ac4talk.store.product.entity.ProductEntity;

public interface ProductRepository extends Repository<ProductEntity, String> {

  Optional<ProductEntity> findById(String id);

  Page<ProductEntity> findAll(Pageable pageable);
}