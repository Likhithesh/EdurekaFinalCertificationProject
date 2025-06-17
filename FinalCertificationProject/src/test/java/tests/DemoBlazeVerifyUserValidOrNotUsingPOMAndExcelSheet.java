package tests;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DemoBlazeHomePage;
import pages.DemoBlazeIndexPage;
import utilities.AutomationConst;
import utilities.BrowserUtils;
import utilities.ExcelUtility;
import utilities.PropertyFileUtility;

public class DemoBlazeVerifyUserValidOrNotUsingPOMAndExcelSheet implements AutomationConst {

	@Test
	public void demoBlazeLoginTest() throws InterruptedException, IOException {

		String URL = PropertyFileUtility.ReadPropertyFile(StaticPropertyFile, "URL");

		RemoteWebDriver driver = BrowserUtils.getDriver();
		driver.get(URL);

		Object[][] exceldata = ExcelUtility.readFromExcel(DemoBlazeCreds_ExcelPath, "DemoBlazeCreds");

		DemoBlazeIndexPage demoBlazeIndexPage = new DemoBlazeIndexPage(driver);
		DemoBlazeHomePage demoBlazeHomePage = new DemoBlazeHomePage(driver);

		for (int i = 0; i < exceldata.length; i++) {
			String username = exceldata[i][0].toString();
			String password = exceldata[i][1].toString();
			String ValidUser = exceldata[i][2].toString();

			System.out.println(" Round : "+i);
			System.out.println("--------------------------------------------------------");
			System.out.println(username);
			System.out.println(password);
			System.out.println(ValidUser);
			System.out.println("--------------------------------------------------------");
			
			if (ValidUser.equalsIgnoreCase("yes")) {
				demoBlazeIndexPage.login(username, password);
				Thread.sleep(5000);
				String WelComeText = demoBlazeHomePage.getWelcomeText();
				Assert.assertEquals(WelComeText, "Welcome " + username);
				demoBlazeHomePage.clickOnLogout();
			} else {
				demoBlazeIndexPage.login(username, password);
				Thread.sleep(3000);
				String message = demoBlazeIndexPage.getAlertMessage();
				Assert.assertEquals(message, "Wrong password.");
			}
		}

		driver.quit();
	}

}
