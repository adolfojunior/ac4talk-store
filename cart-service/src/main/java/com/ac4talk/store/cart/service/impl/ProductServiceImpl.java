package com.ac4talk.store.cart.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ac4talk.core.service.client.RestClient;
import com.ac4talk.core.service.model.ModelNotFoundException;
import com.ac4talk.store.cart.model.Item;
import com.ac4talk.store.cart.service.ProductService;
import com.ac4talk.store.product.api.ProductResource;
import com.ac4talk.store.product.model.AddItem;
import com.ac4talk.store.product.model.ApplyPromotion;
import com.ac4talk.store.product.model.Product;
import com.ac4talk.store.promotion.api.PromotionResource;
import com.ac4talk.store.promotion.model.Promotion;

@Service
public class ProductServiceImpl implements ProductService {

  private RestClient<ProductResource> productClient;

  private RestClient<PromotionResource> promotionClient;

  public ProductServiceImpl(final RestClient<ProductResource> productClient,
      final RestClient<PromotionResource> promotionClient) {
    super();
    this.productClient = productClient;
    this.promotionClient = promotionClient;
  }

  @Override
  public List<Item> applyItems(final List<AddItem> addItems) {
    return addItems.stream().map(this::createItem).collect(Collectors.toList());
  }

  @Override
  public Promotion applyPromotion(final ApplyPromotion applyPromotion) {
    return findPromotion(applyPromotion.getPromotionCode())
        .orElseThrow(() -> new ModelNotFoundException("Invalid promotion"));
  }

  protected Item createItem(final AddItem addItem) {
    final Product product = findProduct(addItem.getProductId())
        .orElseThrow(() -> new ModelNotFoundException("Invalid product " + addItem.getProductId()));
    return new Item().withProductId(product.getId()).withPrice(product.getPrice())
        .withQtd(addItem.getQtd());
  }

  protected Optional<Product> findProduct(final String productId) {
    return productClient.get().findById(productId).getOptionalContent();
  }

  protected Optional<Promotion> findPromotion(final String promotionCode) {
    return this.promotionClient.get().findByCode(promotionCode).getOptionalContent();
  }
}
