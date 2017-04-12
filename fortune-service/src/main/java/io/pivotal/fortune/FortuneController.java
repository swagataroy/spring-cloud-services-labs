package io.pivotal.fortune;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FortuneController {

  Logger logger = LoggerFactory.getLogger(FortuneController.class);

  @Autowired
  private FortuneService fortuneService;

  @Value("${delay.ms:0}")
  private int delayMs = 0;

  @RequestMapping("/")
  String getQuote() {
    logger.debug("fetching fortune.");

    artificialDelay();

    return fortuneService.getFortune();
  }

  private void artificialDelay() {
    if (delayMs <= 0) return;

    try {
      Thread.sleep(delayMs);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
