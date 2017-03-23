package com.ac4talk.store.inventory.resource;


import org.springframework.stereotype.Controller;

import com.ac4talk.store.inventory.api.InventoryResource;

@Controller
public class InventoryResourceImpl implements InventoryResource {

  @Override
  public String get() {
    return getClass().toString();
  }
}
