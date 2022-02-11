package com.iNetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.iNetBanking.pageObjects.LoginPage;

public class TC_Login_001 extends BaseClass
{
	@Test
	public void loginTest() throws IOException
	{
		//driver.get(baseURL);---Commenting to use it from base class instead of test case
		logger.info("Page Launched");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUsername(userName);
		lp.setPwd(password);
		
		lp.clickLogin();
		
		if (driver.getTitle().equals("GTPL Bank Manager HomePage"))
		{
			System.out.println("Login Successful - System Out");
			Assert.assertTrue(true);
			logger.info("Login Passed - Logger");
		}
		else
		{
			captureScreen(driver, "loginTest");
			System.out.println("Login Failure");
			Assert.assertTrue(false);	
			logger.info("login failed");
			
		}
						
	}
	
}
