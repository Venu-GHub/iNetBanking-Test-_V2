
package com.iNetBanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;
import com.iNetBanking.pageObjects.AddCustomerPage;
import com.iNetBanking.pageObjects.LoginPage;

public class TC_AddNewCustomer_003 extends BaseClass 
{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(userName);
		lp.setPwd(password);
		lp.clickLogin();
		Thread.sleep(5000);
		driver.manage().window().maximize();
		logger.info("User Logged In");			
		
		
		AddCustomerPage acp = new AddCustomerPage(driver);				
	
		logger.info("Driver created");
		
		acp.clickAddNewCustomerLink();
		logger.info("Clicked on Add New Customer link");
		
		acp.typeCustName("TestUser1");
		acp.typeGender("male");
		acp.typeDOB("10","22", "1986");
		Thread.sleep(3000);
		
		acp.typeAddress("1542 Sunbow Falls Ln");
		acp.typeCityName("Raleigh");
		acp.typeStateName("NC");
		acp.typePINCode(27609);
		
		//Phone Number sent as string
		String TelPh = "98565"+randomNumber();
		acp.typeTeleNo(TelPh);
		
		//Unique email ID to be sent each time		
		String emailID = randomString()+ "@gmail.com";
		acp.typeEmailID(emailID);
		//acp.clickSubmit();
		
		Thread.sleep(3000);				
		logger.info("Validation started");
		
		//boolean res = driver.getPageSource().contains("Customer Registered Successfully");
		
		//if (res==true)
		//{
			//captureScreen(driver, "AddNewCustomer");
			//Assert.assertTrue(true);
			//logger.info("Test Passed");
		//}
		
		//else
		//{
			//captureScreen (driver, "AddNewCustomer");
			//Assert.assertTrue(false);
			//logger.info("Test Failed");
		//}
		
	}
	
}
