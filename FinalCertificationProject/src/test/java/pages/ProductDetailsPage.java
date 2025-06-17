package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class ProductDetailsPage {
	
	RemoteWebDriver driver;
	WebDriverWait WDwait;

	public ProductDetailsPage(RemoteWebDriver driver1) {
		this.driver = driver1;
		PageFactory.initElements(driver, this);
		WDwait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Locators
//	By ProductInCart = By.xpath("//td[text()='Sony vaio i5']");
	
	@FindBy(xpath = "//a[text()='Add to cart']")
	WebElement AddToCartButton;
	
	@FindBy(xpath = "//td[text()='Sony vaio i5']")
	WebElement ProductInCart;
	
	// Functionalities
	public void clickOnAddToCartButton() throws InterruptedException {
		// driver.findElement(logoutLink).click();
//		WebActions.click(driver, logoutLink);
		WDwait.until(ExpectedConditions.visibilityOf(AddToCartButton));
		Thread.sleep(1000);
		AddToCartButton.click();
		Thread.sleep(1000);
		System.out.println("--> Clicked on 'Add To Cart' button.");
	}
	
	public void VerifyProductAddedToCart() throws InterruptedException {
		Thread.sleep(2000);
		WDwait.until(ExpectedConditions.visibilityOf(ProductInCart));
		Assert.assertEquals(ProductInCart.isDisplayed(), true);
		Thread.sleep(1000);
		System.out.println("--> Product added to cart successfully!!");
	}
	

}
