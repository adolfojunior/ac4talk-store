package com.ac4talk.core.service.resource;

import javax.validation.constraints.Max;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

public class PageableParam {

  @QueryParam("page")
  @DefaultValue("0")
  private int page;

  @QueryParam("size")
  @DefaultValue("10")
  @Max(100)
  private int size;

  public int getPage() {
    return page;
  }

  public void setPage(final int page) {
    this.page = page;
  }

  public int getSize() {
    return size;
  }

  public void setSize(final int size) {
    this.size = size;
  }
}
