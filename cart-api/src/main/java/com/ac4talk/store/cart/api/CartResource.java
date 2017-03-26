package com.ac4talk.store.cart.api;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ac4talk.store.product.model.AddItems;
import com.ac4talk.store.product.model.ApplyPromotion;

@Path("cart")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface CartResource {

  @POST
  @Path("{id}/{version}/add-items")
  Response addItems(@BeanParam CartId cartId, AddItems addItems);

  @POST
  @Path("{id}/{version}/apply-promotion")
  Response applyPromotion(@BeanParam CartId cartId, ApplyPromotion applyPromotion);
}
