package io.pivotal.greeting;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "greeting")
public class GreetingProperties {

	private boolean displayFortune;

	private String swagatatesting;

	public boolean isDisplayFortune() {
		return displayFortune;
	}

	public void setDisplayFortune(boolean displayFortune) {
		this.displayFortune = displayFortune;
	}

	public String getSwagatatesting() {
		return swagatatesting;
	}

	public void setSwagatatesting(String swagatatesting) {
		this.swagatatesting = swagatatesting;
	}

}
