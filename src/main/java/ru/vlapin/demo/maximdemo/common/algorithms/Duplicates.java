package ru.vlapin.demo.maximdemo.common.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import lombok.val;

public class Duplicates {

  static String[] list = {"A", "B", "B", "C", "D", "D", "D", "E", "F", "F"};

  public static void main(String[] args) {
    val strings = new HashSet<String>();
    val duplicates = new HashMap<String, Integer>();
    for (String s : list)
      if (!strings.add(s))
        if (duplicates.containsKey(s))
          duplicates.put(s, duplicates.get(s) + 1);
        else
          duplicates.put(s, 1);

    //    System.out.println("duplicates count = " + count);
    System.out.println("duplicates count = " + duplicates.values().stream()
                                                   .mapToInt(value -> value)
                                                   .sum());
    System.out.println("duplicates = " + duplicates);
  }
}
