package ru.vlapin.demo.maximdemo;

import lombok.val;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.vlapin.demo.maximdemo.common.autowiring.B;

@SpringBootApplication
public class MaximDemoApplication {

  public static void main(String[] args) {

    val context = SpringApplication.run(MaximDemoApplication.class, args);

    System.out.println(context.getBean(B.class).getA1().getS());

    //    val beanDefinitionNames = Set.of(context.getBeanDefinitionNames());

//    System.out.println("context.getBeanDefinitionNames() = " + beanDefinitionNames);
//    System.out.println("context.getBeanDefinitionCount() = " + context.getBeanDefinitionCount());
//
//    int count = 0;
//    val names2 = new ArrayList<String>();
//    for (String name : (Iterable<String>) () -> context.getBeanFactory().getBeanNamesIterator()) {
//      System.out.println("name = " + name);
//      count++;
//      if (!beanDefinitionNames.contains(name))
//        names2.add(name);
//    }
//    System.out.println("count = " + count);
//    System.out.println("names without beanDefinition = " + names2);
  }

  @Bean
  int x() {
    return 56;
  }
}
