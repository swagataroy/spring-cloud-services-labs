package io.pivotal.fortune;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FortuneServiceTest {

  private FortuneService fortuneService;

  @Before
  public void setup() {
    fortuneService = new FortuneService();
  }

  @Test
  public void shouldReturnAFortune() {
    assertNotNull(fortuneService.getFortune());
  }

  @Test
  public void shouldReturnSomeDistinctFortunes() {
    Set<String> fortunes = new HashSet<>();
    for (int i=0; i<1000; i++) {
      fortunes.add(fortuneService.getFortune());
    }
    assertEquals(4, fortunes.size());
  }
}
