package ru.vlapin.demo.maximdemo;

import static com.jayway.jsonpath.JsonPath.parse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.hateoas.MediaTypes.HAL_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(authorities = "ADMIN")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class CatTest {

  MockMvc mockMvc;

  @Test
  @SneakyThrows
  @DisplayName("Cats is accessible via REST")
  void catsIsAccessibleViaRESTTest() {
    mockMvc.perform(get("/cats"))
      .andExpect(status().isOk())
      .andExpect(content().contentType(HAL_JSON_VALUE))
      .andExpect(mvcResult -> assertEquals(3,
          parse(mvcResult.getResponse().getContentAsString())
              .<Integer>read("$.page.totalElements").intValue()));
  }
}
