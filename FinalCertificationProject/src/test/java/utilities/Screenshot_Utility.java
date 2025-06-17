package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import com.cucumber.listener.Reporter;

//import com.cucumber.listener.Reporter;


public class Screenshot_Utility {
//	static org.apache.logging.log4j.Logger logger;

	public static void CaptureScreenshot (WebDriver driver, String imagename) {
		try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
			String date = sdf.format(new Date());
			
			String destination = ".src/test/resources/screenshots/"+imagename+"_"+date+".png";
			FileUtils.copyFile(source, new File(destination));
			
//			logger.info("  --> Screenshot taken.");
			
		}catch(Exception e) {
//			logger.info("FAIL : Not able to take the screenshot .. Exception occurred! : "+e.getMessage());
			Assert.fail();
		}
	}
	
	public static void CaptureScreenshot_ExtentReport(WebDriver driver, String Filepath, String Imagename) {
		try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
			String date = sdf.format(new Date());
			
			String destination = "./screenshots/"+date+"_"+Imagename+".png";
			FileUtils.copyFile(source, new File(destination));
			
//			Reporter.addStepLog(" --> Screenshot taken.");
//			Reporter.addScreenCaptureFromPath(System.getProperty("user.dir")+destination);
			
		}catch(Exception e) {
//			logger.info("FAIL : Not able to take the screenshot .. Exception occurred! : "+e.getMessage());
			Assert.fail();
		}
	}
}
