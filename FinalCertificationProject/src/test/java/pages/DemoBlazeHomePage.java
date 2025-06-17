package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WebActions;

public class DemoBlazeHomePage {
	// Driver reference variable
	RemoteWebDriver driver;
	WebDriverWait WDwait;

	public DemoBlazeHomePage(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WDwait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Locators
	By linkWelcome = By.id("nameofuser");
	By linkLogin=By.id("login2");
	By logoutLink = By.id("logout2");
	By linkLaptops = By.xpath("//a[text()='Laptops']");
	By Sonyvaioi5 = By.xpath("//a[text()='Sony vaio i5']");
	
	By CartLink=By.id("cartur");
	
	@FindBy(id = "logout2")
	WebElement Logoutlink;
	
	@FindBy(xpath = "//a[contains(text(),'Sony vaio i5')]")
	WebElement Sonyvaioi5_Link;

	// Functionalities
	public String getWelcomeText() {
		WDwait.until(ExpectedConditions.presenceOfElementLocated(linkWelcome));
		String value = WebActions.getText(driver, linkWelcome);
		return value;
	}

	public void clickOnLogout() {
		// driver.findElement(logoutLink).click();
//		WebActions.click(driver, logoutLink);
		Logoutlink.click();
		WDwait.until(ExpectedConditions.presenceOfElementLocated(linkLogin));
	}

	public void clickOnLaptopsLink() {
		WebActions.click(driver, linkLaptops);
		System.out.println("--> Clicked on 'Laptops' link.");
	}

	public void clickOnLaptop1() throws InterruptedException {
		WDwait.until(ExpectedConditions.presenceOfElementLocated(Sonyvaioi5));
		WebActions.click(driver, Sonyvaioi5);
		Thread.sleep(2000);
		System.out.println("--> Clicked on 'Sony vaio i5'.");
	}
	
	public void clickOnCartLink() throws InterruptedException {
		WDwait.until(ExpectedConditions.presenceOfElementLocated(CartLink));
		WebActions.click(driver, CartLink);
		Thread.sleep(2000);
		System.out.println("--> Clicked on 'Cart' link.");
	}

}
