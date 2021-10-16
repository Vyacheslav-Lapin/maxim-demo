package ru.vlapin.demo.maximdemo.common.diff;

import java.util.Date;
import lombok.SneakyThrows;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Java10 {

  @SneakyThrows
  @Contract(pure = true)
  public static @NotNull String staticMethod1() {

    var date = new Date() {
      @SneakyThrows
      @Contract(pure = true)
      public @NotNull String staticMethod2() {
        return "";
      }
    };

    date.staticMethod2();

    return "";
  }

  public static void main(String... __) {
    staticMethod1();
  }
}
