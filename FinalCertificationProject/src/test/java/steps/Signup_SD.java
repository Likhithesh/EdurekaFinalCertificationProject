package steps;


import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.DemoBlazeHomePage;
import pages.DemoBlazeIndexPage;
import utilities.AutomationConst;
import utilities.PropertyFileUtility;

public class Signup_SD implements AutomationConst {
	static RemoteWebDriver driver;
	DemoBlazeIndexPage demoBlazeIndexPage;
	DemoBlazeHomePage demoBlazeHomePage;
	WebDriverWait WDWait;
	
	public Signup_SD(){
		Signup_SD.driver = Login_SD.driver;
	}

	/*
	 * @Given("user opens the browser") public void user_opens_the_browser() {
	 * driver = BrowserUtils.getDriver(); }
	 * 
	 * @When("user navigate to Demoblaze Login page") public void
	 * user_navigate_to_demoblaze_login_page() throws IOException {
	 * 
	 * String URL = PropertyFileUtility.ReadPropertyFile(StaticPropertyFile, "URL");
	 * driver.get(URL);
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); }
	 */

	@And("User clicks on Signup link")
	public void User_clicks_on_Signup_link() throws InterruptedException {
		System.out.println("-- Start of 'User clicks on Signup link' method");
		Thread.sleep(3000);
		demoBlazeIndexPage = new DemoBlazeIndexPage(driver);
		demoBlazeIndexPage.clickOnSignupLink();
		System.out.println("-- End of 'User clicks on Signup link' method");
	}
	
	@When("Enter {string} and {string} to Signup")
	public void enter_and_to_signup(String Username, String Password) throws InterruptedException {
		System.out.println("-- Start of 'Enter username and password for Signup' method");
		demoBlazeIndexPage = new DemoBlazeIndexPage(driver);
		demoBlazeIndexPage.enterUserName_Signup(Username);
		demoBlazeIndexPage.enterPassword_Signup(Password);
		PropertyFileUtility.WritePropertyFile(RunTimePropertyFile, "Signupusername", Username);
		Thread.sleep(1000);
		System.out.println("-- End of 'Enter username and password for Signup' method");
	}

	@And("user clicks on Signup button")
	public void user_clicks_on_Signup_button() {
		demoBlazeIndexPage = new DemoBlazeIndexPage(driver);
		demoBlazeIndexPage.clickOnSignupButton();
	}

	/*
	 * @Then("popup should be displayed with a message {string}") public void
	 * popup_should_be_displayed_with_a_message(String AlertMsg) throws
	 * InterruptedException { Thread.sleep(2000); // String message =
	 * demoBlazeIndexPage.getLoginErrorMessage(); String message =
	 * WebActions.getAlertMessage(driver); Assert.assertEquals(message, AlertMsg); }
	 */
}
