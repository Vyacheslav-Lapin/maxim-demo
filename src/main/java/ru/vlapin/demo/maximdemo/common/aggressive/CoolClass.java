package ru.vlapin.demo.maximdemo.common.aggressive;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class CoolClass {

  @Contract(pure = true)
  public final @NotNull CoolResult coolMethod(@NotNull CoolParams coolParams) {
    return coolParams.getS()::length;
  }
}

interface CoolResult {
  int getX();
}

interface CoolParams {
  String getS();
}
