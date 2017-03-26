package com.ac4talk.store.product.resource;


import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.BeanParam;
import javax.ws.rs.core.Response;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import com.ac4talk.core.service.model.ModelConverter;
import com.ac4talk.core.service.resource.AbstractResource;
import com.ac4talk.core.service.resource.PageableParam;
import com.ac4talk.store.product.api.ProductResource;
import com.ac4talk.store.product.entity.ProductEntity;
import com.ac4talk.store.product.model.Product;
import com.ac4talk.store.product.service.ProductService;

@Controller
public class ProductResourceImpl extends AbstractResource implements ProductResource {

  private ProductService productService;

  public ProductResourceImpl(final ModelConverter modelConverter,
      final ProductService productService) {
    super(modelConverter);
    this.productService = productService;
  }

  @Override
  public Response findAll(final @BeanParam PageableParam pageableParam) {
    final Pageable pageable = pageable(pageableParam);
    return collectionResponse(mapProduct(productService.findAll(pageable)));
  }

  @Override
  public Response findByIds(final List<String> ids) {
    return collectionResponse(mapProduct(productService.findByIds(ids)));
  }

  protected List<Product> mapProduct(List<ProductEntity> list) {
    return list.stream().map(mapper(Product.class)).collect(Collectors.toList());
  }
}
