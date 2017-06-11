package io.pivotal.fortune;

import io.pivotal.FortuneServiceApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = FortuneServiceApplication.class)
public class FortuneControllerTest {

  @Autowired
  private FortuneController fortuneController;

  private MockMvc mockMvc;

  private final String fortune = "que le grand cric me croque";

  @MockBean
  FortuneService fortuneService;

  @Before
  public void setup() {
    when(fortuneService.getFortune()).thenReturn(fortune);
    this.mockMvc = MockMvcBuilders.standaloneSetup(fortuneController).build();
  }

  @Test
  public void getFortune() throws Exception {
    this.mockMvc.perform(get("/").accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"))
        .andExpect(content().string(fortune));
  }

}
