package com.ac4talk.store.cart.api;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ac4talk.core.service.resource.ResponseContent;
import com.ac4talk.store.product.model.AddItems;
import com.ac4talk.store.product.model.ApplyPromotion;
import com.ac4talk.store.product.model.Cart;

@Path("cart")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface CartResource {

  @GET
  ResponseContent<Cart> getCart();

  @POST
  @Path("{id}/{version}/add-items")
  ResponseContent<Cart> addItems(@BeanParam CartId cartId, AddItems addItems);

  @POST
  @Path("{id}/{version}/apply-promotion")
  ResponseContent<Cart> applyPromotion(@BeanParam CartId cartId, ApplyPromotion applyPromotion);
}
