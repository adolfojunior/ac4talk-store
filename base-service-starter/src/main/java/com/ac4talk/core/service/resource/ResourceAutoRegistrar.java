package com.ac4talk.core.service.resource;

import java.util.Collection;

import javax.ws.rs.Path;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jersey.ResourceConfigCustomizer;
import org.springframework.context.ApplicationContext;

import com.ac4talk.core.service.client.RestClient;

public class ResourceAutoRegistrar implements ResourceConfigCustomizer {

  private static final Logger LOGGER = LoggerFactory.getLogger(ResourceAutoConfiguration.class);

  private ApplicationContext applicationContext;

  public ResourceAutoRegistrar(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }

  @Override
  public void customize(ResourceConfig config) {
    register(config, getResourceBeans());
    register(config, getProviderBeans());
  }

  private void register(final ResourceConfig config, final Collection<Object> beans) {
    for (Object bean : beans) {
      if (isValid(bean)) {
        LOGGER.info("JAX-RS auto registered {}", bean.getClass().getName());
        config.register(bean);
      }
    }
  }

  protected boolean isValid(Object bean) {
    // RestClient also implements JAX-RS resource interfaces
    return !(bean instanceof RestClient);
  }

  protected Collection<Object> getResourceBeans() {
    return applicationContext.getBeansWithAnnotation(Path.class).values();
  }

  protected Collection<Object> getProviderBeans() {
    return applicationContext.getBeansWithAnnotation(Provider.class).values();
  }
}
