package steps;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DemoBlazeHomePage;
import pages.DemoBlazeIndexPage;
import utilities.AutomationConst;
import utilities.BrowserUtils;
import utilities.PropertyFileUtility;
import utilities.Screenshot_Utility;
import utilities.WebActions;

public class Login_SD implements AutomationConst {

	public static RemoteWebDriver driver;
	DemoBlazeIndexPage demoBlazeIndexPage;
	DemoBlazeHomePage demoBlazeHomePage;
	WebDriverWait WDWait;

	@Given("user opens the browser")
	public void user_opens_the_browser() {
		driver = BrowserUtils.getDriver();
	}

	@When("user navigate to Demoblaze Login page")
	public void user_navigate_to_demoblaze_login_page() throws IOException {

		String URL = PropertyFileUtility.ReadPropertyFile(StaticPropertyFile, "URL");
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@And("User clicks on Login link")
	public void User_clicks_on_Login_link() throws InterruptedException {
		demoBlazeIndexPage = new DemoBlazeIndexPage(driver);
		demoBlazeIndexPage.clickOnLoginLink();
		Thread.sleep(1000);
	}

	@And("Enter username as {string} and password as {string}")
	public void enter_username_as_and_password_as(String userName, String password) throws InterruptedException {
		demoBlazeIndexPage = new DemoBlazeIndexPage(driver);
		demoBlazeIndexPage.enterUserName(userName);
		demoBlazeIndexPage.enterPassword(password);
		PropertyFileUtility.WritePropertyFile(RunTimePropertyFile, "username", userName);
		Thread.sleep(1000);
//		Screenshot_Utility.CaptureScreenshot_ExtentReport(driver, SCREENSHOT_PATH, "DemoBlaze_LoginPage");
		WebActions.takeScreenshot(driver, "DemoBlaze_LoginPage");
	}

	@And("user clicks on Login button")
	public void user_clicks_on_login_button() throws InterruptedException {
		demoBlazeIndexPage = new DemoBlazeIndexPage(driver);
		demoBlazeIndexPage.clickOnLoginButton();
	}

	@Then("the home page should be displayed with welcome page")
	public void the_home_page_should_be_displayed_with_welcome_page() throws InterruptedException {
		demoBlazeHomePage = new DemoBlazeHomePage(driver);
		Thread.sleep(2000);
		String WelComeText = demoBlazeHomePage.getWelcomeText();
//		Screenshot_Utility.CaptureScreenshot_ExtentReport(driver, SCREENSHOT_PATH, "DemoBlaze_WelcomeText");
		WebActions.takeScreenshot(driver, "DemoBlaze_WelcomeText");
		Thread.sleep(3000);
		Assert.assertEquals(WelComeText,
				"Welcome " + PropertyFileUtility.ReadPropertyFile(RunTimePropertyFile, "username"));
	}

	@And("user clicks on Logout button")
	public void clik_On_Logout() throws InterruptedException {
		demoBlazeHomePage = new DemoBlazeHomePage(driver);
		demoBlazeHomePage.clickOnLogout();
		Thread.sleep(2000);
	}

	/*
	 * @Then("closes the browser") public void closes_the_browser() throws
	 * InterruptedException { driver.quit(); Thread.sleep(2000); }
	 */
	@Then("popup should be displayed with a message {string}")
	public void popup_should_be_displayed_with_a_message(String AlertMsg) throws InterruptedException {
		Thread.sleep(2000);
		demoBlazeIndexPage = new DemoBlazeIndexPage(driver);
		String message = demoBlazeIndexPage.getAlertMessage();
		Assert.assertEquals(message, AlertMsg);
	}

}
