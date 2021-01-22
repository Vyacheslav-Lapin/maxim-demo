package ru.vlapin.demo.maximdemo.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import lombok.val;

// Найти повторяющиеся символы и их кол-во в строке
public class Class1 {

  private static Map<Character, List<Integer>> getRetries(String s) {
    val result = new TreeMap<Character, List<Integer>>();
    char[] charArray = s.toCharArray();
    for (int i = 0; i < charArray.length; i++) {
      char c = charArray[i];
      if (result.containsKey(c))
        result.get(c).add(i);
      else {
        val integers = new ArrayList<Integer>();
        integers.add(i);
        result.put(c, integers);
      }
    }
    Map<Character, List<Integer>> map = new HashMap<>();
    for (Map.Entry<Character, List<Integer>> entry : result.entrySet()) {
      if (entry.getValue().size() > 1) {
        if (map.put(entry.getKey(), entry.getValue()) != null)
          throw new IllegalStateException("Duplicate key");
      }
    }
    return map;
  }

  public static void main(String... args) {
    System.out.println("getRetries(\"Hello world!!!\") = " + getRetries("Hello world!!!"));
  }
}
