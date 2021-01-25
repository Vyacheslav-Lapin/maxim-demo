package ru.vlapin.demo.maximdemo.common.ioc;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class Bcd {

  Abc abc;

  public Bcd(Abc abc) {
    this.abc = abc;
  }
}

class Abc {

}

class Cde {

  Abc abc;

  public Cde(Abc abc) {
    this.abc = abc;
  }
}

class SpringContext {
  static Map<String, Object> map = new HashMap<>();

  static <T> T getBean(String id) {
    //noinspection unchecked
    return (T) map.get(id);
  }

  public static void init(Class<?>... classes) {
    for (Class<?> aClass : classes) {
      final Constructor<?>[] constructors = aClass.getConstructors();
      Constructor<?> constructor = constructors[0];
//      constructor.getParameters()
//      constructor.newInstance()
    }
  }
}

class Main {
  public static void main(String[] args) {
    SpringContext.init();
    SpringContext.getBean("bcd");
  }
}
