package com.ac4talk.store.cart.service;

import java.util.List;

import com.ac4talk.store.cart.model.Item;
import com.ac4talk.store.product.model.AddItem;
import com.ac4talk.store.product.model.ApplyPromotion;
import com.ac4talk.store.promotion.model.Promotion;

public interface ProductService {

  List<Item> applyItems(List<AddItem> addItems);

  Promotion applyPromotion(ApplyPromotion applyPromotion);
}
