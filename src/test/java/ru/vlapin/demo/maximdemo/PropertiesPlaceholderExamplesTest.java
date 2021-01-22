package ru.vlapin.demo.maximdemo;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.val;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.vlapin.demo.maximdemo.model.AnnotationBasedSetterPropertiesPlaceholderExample;
import ru.vlapin.demo.maximdemo.model.JavaConfigBasedSetterPropertiesPlaceholderExample;
import ru.vlapin.demo.maximdemo.service.AnnotationBasedImmutablePropertiesPlaceholderExample;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class PropertiesPlaceholderExamplesTest {

  AnnotationBasedSetterPropertiesPlaceholderExample absppe;
  JavaConfigBasedSetterPropertiesPlaceholderExample jcbsppe;
  AnnotationBasedImmutablePropertiesPlaceholderExample abippe;

  @Test
  @SneakyThrows
  @DisplayName("Annotation based properties placeholder works correctly")
  void annotationBasedPropertiesPlaceholderWorksCorrectlyTest() {

    val hostHasDefaultValue = new Condition<AnnotationBasedSetterPropertiesPlaceholderExample>(
        absppe -> absppe.getHost().equals("localhost"),
        "host has default value");

    val portHasValueFromApplicationYaml = new Condition<AnnotationBasedSetterPropertiesPlaceholderExample>(
        absppe -> absppe.getPort() == 8090,
        "port has value from application.yaml");

    assertThat(absppe)
        .isNotNull()
        .satisfies(hostHasDefaultValue)
        .satisfies(portHasValueFromApplicationYaml);
  }

  @Test
  @SneakyThrows
  @DisplayName("Java config based properties placeholder works correctly")
  void javaConfigBasedPropertiesPlaceholderWorksCorrectlyTest() {

    val hostHasValueFromApplicationYaml = new Condition<JavaConfigBasedSetterPropertiesPlaceholderExample>(
        jcbsppe -> jcbsppe.getHost().equals("my.site.com"),
        "host has value from application.yaml");

    val portHasDefaultValue = new Condition<JavaConfigBasedSetterPropertiesPlaceholderExample>(
        jcbsppe -> jcbsppe.getPort() == 8080,
        "port has default value");

    assertThat(jcbsppe)
        .isNotNull()
        .satisfies(hostHasValueFromApplicationYaml)
        .satisfies(portHasDefaultValue);
  }

  @Test
  @SneakyThrows
  @DisplayName("Annotation based immutable properties placeholder works correctly")
  void annotationBasedImmutablePropertiesPlaceholderWorksCorrectlyTest() {

    val authMethodHasValueFromApplicationYaml = new Condition<AnnotationBasedImmutablePropertiesPlaceholderExample>(
        abippe -> abippe.getAuthMethod().equals("basic"),
        "Auth method has value from application.yaml");

    val passwordHasValueFromApplicationYaml = new Condition<AnnotationBasedImmutablePropertiesPlaceholderExample>(
        abippe -> abippe.getPassword().equals("qwerty"),
        "Password has value from application.yaml");

    val userNameHasValueFromApplicationYaml = new Condition<AnnotationBasedImmutablePropertiesPlaceholderExample>(
        abippe -> abippe.getUsername().equals("user"),
        "User name has value from application.yaml");

    assertThat(abippe)
        .isNotNull()
        .satisfies(authMethodHasValueFromApplicationYaml)
        .satisfies(passwordHasValueFromApplicationYaml)
        .satisfies(userNameHasValueFromApplicationYaml);
  }
}
