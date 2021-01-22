package ru.vlapin.demo.maximdemo.common.reflection;

import static java.util.Spliterator.ORDERED;
import static java.util.Spliterators.spliteratorUnknownSize;
import static java.util.stream.StreamSupport.stream;

import io.vavr.CheckedFunction1;
import io.vavr.CheckedFunction2;
import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.function.Function;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;

public interface ReflectionUtil {

  Function<String, Class<?>> CLASS_FOR_NAME = CheckedFunction1.<String, Class<?>>of(Class::forName).unchecked();

  /**
   * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
   *
   * @param packageName The base package
   * @return The classes
   */
  static Stream<Class<?>> getClasses(String packageName) {
    return CheckedFunction2.of(ClassLoader::getResources)
               .andThen(Enumeration::asIterator)
               .andThen(urlIterator -> spliteratorUnknownSize(urlIterator, ORDERED))
               .andThen(urlSpliterator -> stream(urlSpliterator, false))
               .reversed()
               .apply(packageName.replace('.', '/'))
               .compose(Thread::getContextClassLoader)
               .unchecked()
               .apply(Thread.currentThread())
               .map(URL::getFile)
               .map(File::new)
               .flatMap(directory -> findClasses(directory, packageName));
  }

  /**
   * Recursive method used to find all classes in a given directory and subdirs.
   *
   * @param directory   The base directory
   * @param packageName The package name for classes found inside the base directory
   * @return The classes
   */
  private static Stream<Class<?>> findClasses(File directory, String packageName) {
    return Stream.of(directory)
               .filter(File::exists)
               .map(File::listFiles)
               .flatMap(Arrays::stream)
               .flatMap(file -> file.isDirectory()
                                    ? findClasses(file, "%s.%s".formatted(packageName, file.getName()))
                                    : findClass(packageName, file));
  }

  @NotNull
  private static Stream<Class<?>> findClass(String packageName, File file) {
    return Stream.of(file.getName())
               .filter(fileName -> fileName.endsWith(".class"))
               .map(fileName -> fileName.substring(0, fileName.length() - 6))
               .map(fileName -> CLASS_FOR_NAME.apply("%s.%s".formatted(packageName, fileName)));
  }
}
