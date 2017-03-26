package com.ac4talk.store.product.api;

import java.util.List;

import javax.validation.constraints.Size;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ac4talk.core.service.resource.PageableParam;

@Path("product")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface ProductResource {

  @GET
  @Path("all")
  Response findAll(@BeanParam PageableParam pageableParam);

  @GET
  @Path("by-ids")
  Response findByIds(@QueryParam("id") @Size(min = 1) List<String> ids);
}
