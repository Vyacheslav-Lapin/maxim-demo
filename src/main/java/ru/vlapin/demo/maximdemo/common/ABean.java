package ru.vlapin.demo.maximdemo.common;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ABean {

  @Qualifier("BBean")
  BBean bBean;

  @PostConstruct
  private void init() {
    System.out.println("BBean = " + bBean);
  }
}

@ToString
@Component//("bBean")
@Scope(SCOPE_PROTOTYPE)
class BBean {

  @PostConstruct
  private void init() {
    System.out.println("Constructor!!!!!!!!!!!!!!!!!!!!!!!!!!");
  }
}

@ToString
@Component
class CBean extends BBean {
}

