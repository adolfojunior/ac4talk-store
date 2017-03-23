package com.ac4talk.store.user.resource;

import org.springframework.stereotype.Controller;

import com.ac4talk.store.user.api.UserResource;

@Controller
public class UserResourceImpl implements UserResource {

  @Override
  public String get() {
    return getClass().toString();
  }
}
