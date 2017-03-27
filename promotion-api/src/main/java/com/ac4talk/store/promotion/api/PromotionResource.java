package com.ac4talk.store.promotion.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ac4talk.core.service.resource.ResponseContent;
import com.ac4talk.store.promotion.model.Promotion;

@Path("promotion")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface PromotionResource {

  @GET
  @Path("{promotionCode}")
  ResponseContent<Promotion> findByCode(@PathParam("promotionCode") String promotionCode);
}
