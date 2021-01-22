package ru.vlapin.demo.maximdemo.common;

public class FpExample1 {

  private static String m(int x, double d) {
    //...
    return Double.valueOf(x + d).toString();
  }

  public static void main(String[] args) {
//    String m = m(5, 88.0);
    System.out.println("m = " + 93.0);
  }
}
