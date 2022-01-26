package com.inetBanking.testCases;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.inetBanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	
	public static WebDriver driver;
	
	public static Logger logger;
	
	@BeforeClass
	public void setup() 
	{
		//System.setProperty("webdriver.chrome.driver","/Users/mahi/eclipse-workspace/inetBankingV1/drivers/chromedriver");
		
		//Users/mahi/eclipse-workspace/inetBankingV1/drivers/chromedriver
		//System.setProperty("Webdriver.Chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver");
		//driver=new ChromeDriver();
		driver=new SafariDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		logger=LogManager.getLogger(BaseClass.class.getClass().getName());
		logger.info("logger initiated");
	//	PropertyConfigurator.configure("Log4j.properties");
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	/*private void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot  ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("use.dir")+ "/screenshots" +tname+ ".png");
		FileUtils.copyFile(source, target);
		System.out.println("screenshot is taken");
		
				
	}*/
	
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}

	public static String randomenumber()
	{
		String generatedstring2=RandomStringUtils.randomNumeric(4);
		return(generatedstring2);
	}
	
}
	
	


