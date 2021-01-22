package ru.vlapin.demo.maximdemo.common;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

class ReflectionUtilTest {

  @Test
  @SneakyThrows
  void getClasses() {
    assertThat(ReflectionUtil.getClasses("ru.vlapin.demo.maximdemo.common").filter(Objects::nonNull))
        .isNotNull()
        .hasSize(8)
        .containsExactlyInAnyOrder(
            AnnotationUtilsTest.A.class,
            AnnotationUtilsTest.MyDeepAnnotation.class,
            AnnotationUtilsTest.MyAnnotation.class,
            AnnotationUtilsTest.class,
            ReflectionUtilTest.class,
            ButtonExample.class,
            AnnotationUtils.class,
            ReflectionUtil.class
        );
  }
}
