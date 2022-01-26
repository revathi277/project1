package com.inetBanking.testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.loginPage;

public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void logintext()
	{
		driver.get(baseURL);
		
		logger.info("URL is opened");
		
		loginPage lp=new loginPage(driver);
		lp.setUserName(username);
		logger.info("Enter username");
		
		lp.setPassword(password);
		logger.info("Enter password");
		lp.clickSubmit();
		String title=driver.getTitle();
		System.out.println("title:"+title);
			
		
		if(title.equals("Guru99 Bank Home Page" ))
		{
			AssertJUnit.assertTrue(true);
			logger.info("Login test passed");
			
		}
		else
		{
			AssertJUnit.assertTrue(false); 
			logger.info("Login test failed");
		}
	}

}
