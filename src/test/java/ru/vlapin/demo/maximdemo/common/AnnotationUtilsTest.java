package ru.vlapin.demo.maximdemo.common;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.annotation.Retention;
import java.sql.SQLException;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//import static ru.vlapin.demo.maximdemo.common.AnnotationUtils.getDeepAnnotation;

class AnnotationUtilsTest {

  @Retention(RUNTIME)
  @interface MyDeepAnnotation {
    String value();
  }

  @MyDeepAnnotation("Lorem ipsum dolor sit amet")
  @interface MyAnnotation {
  }

  @MyAnnotation
  class A {
  }

  @Test
  void getDeepAnnotationTest() {
//    assertThat(getDeepAnnotation(A.class, MyDeepAnnotation.class))
//        .isNotNull()
//        .containsInstanceOf(MyDeepAnnotation.class)
//        .get()
//        .extracting(MyDeepAnnotation::value)
//        .isEqualTo("Lorem ipsum dolor sit amet");
  }

  @Test
  @SneakyThrows
  @DisplayName("Checked exceptions works correctly")
  void checkedExceptionsWorksCorrectlyTest() {
    assertThrows(SQLException.class, () -> doThrow(new SQLException()));
  }

  void doThrow(Exception e) {
    throwChecked(e);
  }

  @SuppressWarnings("unchecked")
  private static <E extends Exception> void throwChecked(Exception e) throws E {
    throw (E) e;
  }
}
