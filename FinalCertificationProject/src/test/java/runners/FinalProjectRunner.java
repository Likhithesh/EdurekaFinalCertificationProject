package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utilities.AutomationConst;

@CucumberOptions(features = { "features/Login.feature", "features/LoginWithScenarioOutline.feature",
		"features/Signup.feature", "features/AddToCart.feature" }, glue = { "steps" }, plugin = { "pretty",
				"html:target/cucumber/cucumber.html"/*
													 * ,
													 * "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
													 */ }/* , tags = ("@AddToCart") */, monochrome = true)
public class FinalProjectRunner extends AbstractTestNGCucumberTests implements AutomationConst {
}
