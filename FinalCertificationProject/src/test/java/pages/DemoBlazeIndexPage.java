package pages;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.LoggerUtility;
import utilities.WebActions;

public class DemoBlazeIndexPage {
	// Driver reference variable
	RemoteWebDriver driver;
//	Logger logger;
	Actions action;
	WebDriverWait WDWait;

	public DemoBlazeIndexPage(RemoteWebDriver driver) {
		this.driver = driver;
//		logger = LogManager.getLogger(this.getClass().getName());
//		Configurator.initialize("Log4jConfig","Log4j.properties");
		PageFactory.initElements(driver, this);
		WDWait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// 1. Locators
	By linkLogin = By.id("login2");
	By linkSignup = By.id("signin2");
//	By linkSignup = By.cssSelector("#signin2");
	By inputUserName = By.id("loginusername");
	By inputPassword = By.id("loginpassword");
	By inputUserName_signup = By.id("sign-username");
	By inputPassword_signup = By.id("sign-password");
	By buttonLogin = By.xpath("//button[text()='Log in']");
	By buttonSignup = By.xpath("//button[text()='Sign up']");

	@FindBy(xpath = "//button[text()='Log in']")
	WebElement LoginButton;

	// 2. Functionalities
	public void clickOnLoginLink() {
		// driver.findElement(linkLogin).click();
		WebActions.click(driver, linkLogin);
		WDWait.until(ExpectedConditions.presenceOfElementLocated(inputUserName));
	}
	
	public void clickOnSignupLink() {
		// driver.findElement(linkLogin).click();
		WebActions.click(driver, linkSignup);
		WDWait.until(ExpectedConditions.presenceOfElementLocated(inputUserName));
	}

	public void enterUserName(String userName) {
		// driver.findElement(inputUserName).sendKeys(inputUserName);
		WebActions.setText(driver, inputUserName, userName);
	}

	public void enterPassword(String password) {
		// driver.findElement(inputPassword).sendKeys(password);
		WebActions.setText(driver, inputPassword, password);
	}
	
	public void enterUserName_Signup(String userName) {
		// driver.findElement(inputUserName).sendKeys(inputUserName);
		WebActions.setText(driver, inputUserName_signup, userName);
	}

	public void enterPassword_Signup(String password) {
		// driver.findElement(inputPassword).sendKeys(password);
		WebActions.setText(driver, inputPassword_signup, password);
	}

	public void clickOnLoginButton() throws InterruptedException {
		// driver.findElement(buttonLogin).click();
		WebActions.click(driver, buttonLogin);
//		Thread.sleep(2000);
//		action = new Actions(driver);
//		action.click(LoginButton).build().perform();
	}
	
	public void clickOnSignupButton() {
		// driver.findElement(buttonLogin).click();
		WebActions.click(driver, buttonSignup);
	}

	public void login(String userName, String password) throws InterruptedException {
		Logger logger = LoggerUtility.getLogger("DemoBlazeIndexPage.login()");
		logger.debug("Start of the Login Method of Demo Blaze");
		logger.info("Start of the Login Method of Demo Blaze");
		this.clickOnLoginLink();
		this.enterUserName(userName);
		this.enterPassword(password);
		this.clickOnLoginButton();
		logger.debug("End of the Login Method of Demo Blaze");
		logger.info("End of the Login Method of Demo Blaze");
	}

	public String getAlertMessage() {
		String message = WebActions.getAlertMessage(driver);
		return message;
	}

}
