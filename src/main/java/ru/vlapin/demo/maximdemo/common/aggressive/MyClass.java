package ru.vlapin.demo.maximdemo.common.aggressive;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class MyClass {

  public static void main(String... __) {
    CoolResult coolResult = new CoolClass().coolMethod(new MyCoolClassParams("Lorem ipsum dolor sit amet"));
    System.out.println("coolResult.getX() = " + coolResult.getX());
  }
}

@Getter
@RequiredArgsConstructor
class MyCoolClassParams implements CoolParams {

  String s;
}
