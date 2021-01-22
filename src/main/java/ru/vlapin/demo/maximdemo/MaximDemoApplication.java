package ru.vlapin.demo.maximdemo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MaximDemoApplication {

  public static void main(String[] args) {
    BeanFactory context = SpringApplication.run(MaximDemoApplication.class, args);
//    context.
  }

  @Bean
  int x() {
    return 56;
  }
}
