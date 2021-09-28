package ru.vlapin.demo.maximdemo.common.nonagressive;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.ToString;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@ToString
@RequiredArgsConstructor
public class MyCoolClass {

  @StringAnno
  @SneakyThrows
  @Contract(pure = true)
  public final @NotNull String lkjdfglkjhadfgjkh() {
    return "Lorem ipsum dolor sit amet";
  }

  int b;

  public static void main(String... __) {
    MyCoolClass myCoolClass = new CoolClass()
        .coolMethod(new MyCoolClass(5), MyCoolClass.class);
    System.out.println("myCoolClass = " + myCoolClass);
  }
}
