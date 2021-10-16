package ru.vlapin.demo.maximdemo.common.autowiring;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Getter
@Component
@RequiredArgsConstructor
public class B {
  A a1;
}
