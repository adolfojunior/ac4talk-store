package com.ac4talk.store.cart.service.impl;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.ac4talk.store.cart.api.CartId;
import com.ac4talk.store.cart.model.Item;
import com.ac4talk.store.cart.service.CartService;
import com.ac4talk.store.product.client.ProductClient;
import com.ac4talk.store.product.model.AddItems;
import com.ac4talk.store.product.model.ApplyPromotion;
import com.ac4talk.store.product.model.Cart;
import com.ac4talk.store.product.model.Product;
import com.ac4talk.store.promotion.client.PromotionClient;

@Service
public class CartServiceImpl implements CartService {

  private ProductClient productClient;

  private PromotionClient promotionClient;

  private ConcurrentMap<CartId, Cart> localCarts;

  public CartServiceImpl(ProductClient productClient, PromotionClient promotionClient) {
    this.productClient = productClient;
    this.promotionClient = promotionClient;
    this.localCarts = new ConcurrentHashMap<>();
  }

  @Override
  public Cart getOrCreate() {
    final CartId cartId =
        new CartId().withId(UUID.randomUUID().toString()).withVersion(UUID.randomUUID().toString());
    return findCart(cartId);
  }

  @Override
  public Cart addItems(final CartId cartId, final AddItems addItems) {

    final Cart cart = findCart(cartId);

    final Stream<Item> items = addItems.getItems().stream().map(addItem -> {
      final Product product = productClient.findById(addItem.getProductId()).getContent();
      return new Item().withProductId(product.getId()).withPrice(product.getPrice())
          .withQtd(addItem.getQtd());
    });

    return cart.withItems(items.collect(Collectors.toList()));
  }

  @Override
  public Cart applyPromotion(final CartId cartId, final ApplyPromotion applyPromotion) {

    final Cart cart = findCart(cartId);

    promotionClient.findByCode(applyPromotion.getPromotionCode()).getOptionalContent()
        .ifPresent(promotion -> {
          cart.withPromotions(Collections.singletonList(promotion.getCode()));
        });

    return cart;
  }

  protected Cart findCart(final CartId cartId) {
    return this.localCarts.computeIfAbsent(cartId, key -> {
      return new Cart().withId(key.getId()).withVersion(key.getVersion());
    });
  }
}
