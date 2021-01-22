package ru.vlapin.demo.maximdemo.common;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.vlapin.demo.maximdemo.common.JavaCode.toJSON;

import java.util.List;
import org.junit.jupiter.api.Test;

class JavaCodeTest {

  @Test
  void toJSONTest() {
    assertThat(toJSON(List.of(1, 2, 3, 4, 5)))
        .isNotNull()
        .isEqualTo("[1, 2, 3, 4, 5]");
  }
}
