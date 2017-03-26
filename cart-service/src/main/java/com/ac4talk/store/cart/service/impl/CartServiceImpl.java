package com.ac4talk.store.cart.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.core.GenericType;

import org.springframework.stereotype.Service;

import com.ac4talk.store.cart.api.CartId;
import com.ac4talk.store.cart.service.CartService;
import com.ac4talk.store.product.client.ProductClient;
import com.ac4talk.store.product.model.AddItem;
import com.ac4talk.store.product.model.AddItems;
import com.ac4talk.store.product.model.ApplyPromotion;
import com.ac4talk.store.product.model.Cart;
import com.ac4talk.store.product.model.Product;
import com.ac4talk.store.promotion.client.PromotionClient;
import com.ac4talk.store.promotion.model.Promotion;

@Service
public class CartServiceImpl implements CartService {

  private ProductClient productClient;

  private PromotionClient promotionClient;

  public CartServiceImpl(ProductClient productClient, PromotionClient promotionClient) {
    this.productClient = productClient;
    this.promotionClient = promotionClient;
  }

  private Cart getCard(final CartId cartId) {
    return new Cart().withId(cartId.getId()).withVersion(cartId.getVersion());
  }

  @Override
  public Cart addItems(final CartId cartId, final AddItems addItems) {
    final List<String> productIds =
        addItems.getItems().stream().map(AddItem::getProductId).collect(Collectors.toList());

    final List<Product> products =
        productClient.findByIds(productIds).readEntity(new GenericType<List<Product>>() {});

    return getCard(cartId).withItems(products.stream().map(product -> {
      return new AddItem().withProductId(product.getId());
    }).collect(Collectors.toList()));
  }

  @Override
  public Cart applyPromotion(final CartId cartId, final ApplyPromotion applyPromotion) {
    final Promotion promotion = promotionClient.findByCode(applyPromotion.getPromotionCode());
    return getCard(cartId).withPromotions(Collections.singletonList(promotion.getCode()));
  }
}
