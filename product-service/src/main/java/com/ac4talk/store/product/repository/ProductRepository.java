package com.ac4talk.store.product.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.ac4talk.store.product.entity.ProductEntity;

public interface ProductRepository extends Repository<ProductEntity, String> {

  @Query("from ProductEntity")
  List<ProductEntity> findAll(Pageable pageable);

  @Query("from ProductEntity where id in :ids")
  List<ProductEntity> findByIds(@Param("ids") List<String> ids);
}