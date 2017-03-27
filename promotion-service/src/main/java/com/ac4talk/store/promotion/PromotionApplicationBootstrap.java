package com.ac4talk.store.promotion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PromotionApplicationBootstrap {

  public static void main(String[] args) {
    SpringApplication.run(PromotionApplicationBootstrap.class, args);
  }
}
