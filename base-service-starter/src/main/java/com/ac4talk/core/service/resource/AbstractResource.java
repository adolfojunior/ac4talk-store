package com.ac4talk.core.service.resource;

import java.util.Collection;
import java.util.function.Function;

import javax.ws.rs.core.Response;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.ac4talk.core.service.model.ModelConverter;

public abstract class AbstractResource {

  private ModelConverter modelConverter;

  public AbstractResource(final ModelConverter modelConverter) {
    this.modelConverter = modelConverter;
  }

  protected <T> Function<Object, T> mapper(final Class<T> valueType) {
    return modelConverter.mapper(valueType);
  }

  protected Pageable pageable(PageableParam pageableParam) {
    return new PageRequest(pageableParam.getPage(), pageableParam.getSize());
  }

  protected <T> Response collectionResponse(final Collection<T> collection) {
    if (collection.isEmpty()) {
      return Response.noContent().build();
    }
    return Response.ok().entity(collection).build();
  }
}
