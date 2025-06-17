package steps;

import java.time.Duration;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import pages.DemoBlazeHomePage;
import pages.DemoBlazeIndexPage;
import pages.ProductDetailsPage;

public class AddToCart_SD {

	static RemoteWebDriver driver;
	DemoBlazeIndexPage demoBlazeIndexPage;
	DemoBlazeHomePage demoBlazeHomePage;
	WebDriverWait WDWait;
	ProductDetailsPage productDetailsPage;

	public AddToCart_SD() {
		AddToCart_SD.driver = Login_SD.driver;
		WDWait = new WebDriverWait(driver, Duration.ofSeconds(7));
	}

	@Then("User clicks on Laptops link")
	public void user_clicks_on_laptops_link() {
		demoBlazeHomePage = new DemoBlazeHomePage(driver);
		demoBlazeHomePage.clickOnLaptopsLink();
	}

	@Then("clicks on Sonyvaioi5 laptop")
	public void clicks_on_sonyvaioi5_laptop() throws InterruptedException {
		demoBlazeHomePage = new DemoBlazeHomePage(driver);
		demoBlazeHomePage.clickOnLaptop1();
	}

	@Then("finally clicks on Add to cart button")
	public void finally_clicks_on_add_to_cart_button() throws InterruptedException {
		productDetailsPage = new ProductDetailsPage(driver);
		productDetailsPage.clickOnAddToCartButton();
	}

	@Then("user clicks on Cart link")
	public void user_clicks_on_cart_link() throws InterruptedException {
		demoBlazeHomePage = new DemoBlazeHomePage(driver);
		demoBlazeHomePage.clickOnCartLink();
	}

	@Then("Verify if the product added to cart successfully")
	public void verify_if_the_product_added_to_cart_successfully() throws InterruptedException {
		productDetailsPage = new ProductDetailsPage(driver);
		productDetailsPage.VerifyProductAddedToCart();
	}

}
