package ru.vlapin.demo.maximdemo.common;

import java.util.Collection;
import java.util.stream.Collectors;

public interface JavaCode {
  static String toJSON(Collection<Integer> collection) {
    return "[%s]".formatted(
        collection.stream()
            .mapToInt(Integer::intValue)
            .mapToObj(Integer::toString)
            .collect(Collectors.joining(", "))
    );
  }
}
