package com.ac4talk.store.cart.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ac4talk.store.cart.api.CartId;
import com.ac4talk.store.cart.model.Item;
import com.ac4talk.store.cart.repository.CartRepository;
import com.ac4talk.store.cart.service.CartService;
import com.ac4talk.store.cart.service.ProductService;
import com.ac4talk.store.product.model.AddItems;
import com.ac4talk.store.product.model.ApplyPromotion;
import com.ac4talk.store.product.model.Cart;
import com.ac4talk.store.promotion.model.Promotion;

@Service
public class CartServiceImpl implements CartService {

  private ProductService productService;

  private CartRepository cartRepository;

  public CartServiceImpl(ProductService productService, CartRepository cartRepository) {
    this.productService = productService;
    this.cartRepository = cartRepository;
  }

  @Override
  public Cart getOrCreate() {
    return cartRepository.getOrCreate();
  }

  @Override
  public Cart addItems(final CartId cartId, final AddItems addItems) {
    final Cart cart = cartRepository.findById(cartId);
    final List<Item> items = productService.applyItems(addItems.getItems());

    return cart.withItems(items);
  }

  @Override
  public Cart applyPromotion(final CartId cartId, final ApplyPromotion applyPromotion) {
    final Cart cart = cartRepository.findById(cartId);
    final Promotion promotion = productService.applyPromotion(applyPromotion);

    return cart.withPromotions(Collections.singletonList(promotion.getCode()));
  }
}
