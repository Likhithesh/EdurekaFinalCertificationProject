package utilities;

public interface AutomationConst {
	
	String DemoBlazeCreds_ExcelPath=System.getProperty("user.dir")+"/testData/DemoBlazeCreds.xlsx";
	String RunTimePropertyFile=System.getProperty("user.dir")+"/testData/RunTimeData.properties";
	String StaticPropertyFile=System.getProperty("user.dir")+"/testData/StaticData.properties";
	
	String SCREENSHOT_PATH = "./src/test/resources/screenshots/";
	String ExtentReportXMLConfig = System.getProperty("user.dir")+"/Extent_Config.xml";

}
