package ru.vlapin.demo.maximdemo.common;

import io.vavr.CheckedFunction1;
import io.vavr.CheckedFunction2;
import io.vavr.Function1;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import lombok.val;
import org.jetbrains.annotations.NotNull;

@UtilityClass
public class ReflectionUtil {

  public final Function<String, Class<?>> CLASS_FOR_NAME = CheckedFunction1.<String, Class<?>>of(Class::forName).unchecked();

  /**
   * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
   *
   * @param packageName The base package
   * @return The classes
   */
  @SneakyThrows
  public Stream<Class<?>> getClasses(String packageName) {

//    CheckedFunction2.of(ClassLoader::getResources)
//        .unchecked()

    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    assert classLoader != null;
    String path = packageName.replace('.', '/');
    val resources = classLoader.getResources(path);
    val dirs = new ArrayList<File>();
    while (resources.hasMoreElements()) {
      URL resource = resources.nextElement();
      dirs.add(new File(resource.getFile()));
    }
    val classes = new ArrayList<Class<?>>();
    for (File directory : dirs) {
      classes.addAll(findClasses(directory, packageName).collect(Collectors.toSet()));
    }
    return classes.stream();
  }

  /**
   * Recursive method used to find all classes in a given directory and subdirs.
   *
   * @param directory   The base directory
   * @param packageName The package name for classes found inside the base directory
   * @return The classes
   */
  private Stream<Class<?>> findClasses(File directory, String packageName) {
    return Stream.of(directory)
               .filter(File::exists)
               .map(File::listFiles)
               .flatMap(Arrays::stream)
               .flatMap(file -> file.isDirectory()
                                    ? findClasses(file, "%s.%s".formatted(packageName, file.getName()))
                                    : findClass(packageName, file));
  }

  @NotNull
  private Stream<Class<?>> findClass(String packageName, File file) {
    return Stream.of(file.getName())
               .filter(fileName -> fileName.endsWith(".class"))
               .map(fileName -> fileName.substring(0, fileName.length() - 6))
               .map(fileName -> CLASS_FOR_NAME.apply("%s.%s".formatted(packageName, fileName)));
  }
}
