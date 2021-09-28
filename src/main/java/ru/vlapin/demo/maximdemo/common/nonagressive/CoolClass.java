package ru.vlapin.demo.maximdemo.common.nonagressive;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Arrays;
import lombok.SneakyThrows;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class CoolClass {

  @SneakyThrows
  @Contract(pure = true)
  public final @NotNull <T> T coolMethod(@NotNull Object o, Class<T> tClass) {

    int length = getString(o, Arrays.stream(o.getClass().getDeclaredMethods())
        .filter(method -> method.isAnnotationPresent(StringAnno.class))
        .findFirst()
        .get())
        .length();

    return tClass.getConstructor(int.class)
        .newInstance(length);
  }

  @SneakyThrows
  private String getString(@NotNull Object o, Method method) {
    return (String) method.invoke(o);
  }
}

@Target({METHOD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@interface StringAnno {
}
