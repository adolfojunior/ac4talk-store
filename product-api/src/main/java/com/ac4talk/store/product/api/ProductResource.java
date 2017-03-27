package com.ac4talk.store.product.api;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ac4talk.core.service.resource.PageableParam;
import com.ac4talk.core.service.resource.ResponseContent;
import com.ac4talk.store.product.model.Product;

@Path("product")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface ProductResource {

  @GET
  @Path("all")
  ResponseContent<List<Product>> findAll(@BeanParam PageableParam pageableParam);

  @GET
  @Path("{id}")
  ResponseContent<Product> findById(@PathParam("id") String id);
}
