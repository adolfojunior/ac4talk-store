package com.ac4talk.core.service.resource;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public abstract class AbstractResource {

  protected Pageable pageable(PageableParam pageableParam) {
    return new PageRequest(pageableParam.getPage(), pageableParam.getSize());
  }

  protected <T> ResponseContentBuilder<List<T>> responseContentBuilder(final List<T> list) {
    if (list.isEmpty()) {
      return ResponseContentBuilder.<List<T>>noContent().content(list);
    }
    return ResponseContentBuilder.<List<T>>ok(list);
  }
}
