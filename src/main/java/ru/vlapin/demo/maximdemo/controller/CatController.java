package ru.vlapin.demo.maximdemo.controller;

import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vlapin.demo.maximdemo.model.Cat;
import ru.vlapin.demo.maximdemo.service.AnnotationBasedImmutablePropertiesPlaceholderExample;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class CatController {

  AnnotationBasedImmutablePropertiesPlaceholderExample placeholderExample;

  @PostConstruct
  private void init() {
    System.out.println(
        placeholderExample.getAuthMethod());
  }

  @EventListener
  public void afterContextInitialization(ContextRefreshedEvent __) {

  }


  @NotNull
  @SneakyThrows
  @Contract(pure = true)
  @GetMapping("cats/{id}")
  public Cat byId(@PathVariable @NotNull Long id) {
    return Cat.builder().build();
  }
}
