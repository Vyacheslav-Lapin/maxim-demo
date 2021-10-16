package ru.vlapin.demo.maximdemo.common.autowiring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfExperiment {
  @Bean
  A a1() {
    return new A("a1");
  }

  @Bean
  A a2() {
    return new A("a2");
  }
}
