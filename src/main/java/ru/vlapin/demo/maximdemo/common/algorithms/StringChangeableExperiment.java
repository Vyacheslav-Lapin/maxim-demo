package ru.vlapin.demo.maximdemo.common.algorithms;

import java.util.Arrays;
import lombok.SneakyThrows;
import lombok.val;

public class StringChangeableExperiment {

  @SneakyThrows
  public static void main(String[] args) {
    String s = "abcdef";

    val value= s.getClass().getDeclaredField("value");
    value.setAccessible(true);
    final byte[] bytes = (byte[]) value.get(s);
    System.out.println("value.get(s) = " + Arrays.toString(bytes));
    System.out.println("bytes.length = " + bytes.length);

    System.out.println("s1 = " + new String(bytes));

    value.set(s, new byte[]{98, 99, 100, 101, 102, 103});
    final byte[] bytes2 = (byte[]) value.get(s);
    System.out.println("value.get(s) = " + Arrays.toString(bytes2));
    System.out.println("bytes.length = " + bytes2.length);

    System.out.println("s1 = " + new String(bytes2));

    String s2 = "abcdef";
    System.out.println("s2 = " + s2);
    System.out.println("s = " + s);
  }
}
