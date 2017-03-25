package com.ac4talk.core.service.client;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("rest.client")
public class RestClientProperties {

  private Map<String, ClientProperties> config = new LinkedHashMap<>();

  public boolean hasClient(String name) {
    return this.config.containsKey(name);
  }

  public ClientProperties getClient(String name) {
    return Optional.ofNullable(this.config.get(name)).orElseGet(ClientProperties::new);
  }

  public Map<String, ClientProperties> getConfig() {
    return config;
  }

  public void setConfig(Map<String, ClientProperties> config) {
    this.config = config;
  }

  public static class ClientProperties {

    private String name;
    private String url;
    private Integer readTimeout;
    private Integer connectionTimeout;

    @Override
    public String toString() {
      return getClass().getSimpleName() + " [name=" + name + ", url=" + url + ", readTimeout="
          + readTimeout + ", connectionTimeout=" + connectionTimeout + "]";
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getUrl() {
      return url;
    }

    public void setUrl(String url) {
      this.url = url;
    }

    public Integer getReadTimeout() {
      return readTimeout;
    }

    public void setReadTimeout(Integer readTimeout) {
      this.readTimeout = readTimeout;
    }

    public Integer getConnectionTimeout() {
      return connectionTimeout;
    }

    public void setConnectionTimeout(Integer connectionTimeout) {
      this.connectionTimeout = connectionTimeout;
    }
  }
}
