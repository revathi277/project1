package com.inetBanking.testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.loginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{
	@Test
	public void addNewCutomer() throws InterruptedException
	{
		driver.get(baseURL);
		
		loginPage lp=new loginPage(driver);
		
		lp.setUserName(username);
		logger.info("username provided");
		lp.setPassword(password);
		logger.info("password provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		
		logger.info("providing customer details......");
		
		addcust.custName("revathi");
		addcust.custGender("Female");
		addcust.custdob("12", "18", "1994");
		addcust.custaddress("India");
		addcust.custcity("city");
		addcust.custstate("telangana");
		addcust.custpinno("500079");
		addcust.custtelephoneno("9553022535");
			
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		
		addcust.custpassword("abcdegg");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		logger.info("validation started.....");
		
		boolean res=driver.getPageSource().contains("Customer Registerd Successfully!!!");
		
		if(res==true)
		{
			AssertJUnit.assertTrue(true);
			logger.info("Testcase passed");
		}
		else
		{
			//captureScreen(driver,"addNewCustomer");
			AssertJUnit.assertTrue(false);
			logger.info("Testcase is Failed");
		}
	}
	
		
		
}
	
	

	
