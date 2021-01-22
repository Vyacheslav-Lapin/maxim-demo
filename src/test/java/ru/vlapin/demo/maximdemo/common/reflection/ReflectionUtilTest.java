package ru.vlapin.demo.maximdemo.common.reflection;

import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ReflectionUtilTest {

  @Test
  @SneakyThrows
  void getClasses() {
    Assertions.assertThat(ReflectionUtil.getClasses("ru.vlapin.demo.maximdemo.common.reflection"))
        .isNotNull()
        .hasSize(2)
        .containsExactlyInAnyOrder(
            ReflectionUtilTest.class,
            ReflectionUtil.class
        );
  }
}
