package steps;

import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.After;

public class Hooks {
	
	@After
	public void CloseBrowser() {
		Login_SD.driver.quit();
	}

}
