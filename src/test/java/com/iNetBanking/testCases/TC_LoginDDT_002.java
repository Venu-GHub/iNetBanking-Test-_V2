package com.iNetBanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.iNetBanking.pageObjects.LoginPage;
import com.iNetBanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass 
{
	@Test (dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(user);
		logger.info("Username provided");
		
		lp.setPwd(pwd);
		logger.info("Password provided");
		
		lp.clickLogin();
		Thread.sleep(3000);
		
		
		if (isAlertPresent() == true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
							
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("login passed");
			lp.clickLogOut();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close the logout of alert
			driver.switchTo().defaultContent();//go to the login page again
						
		}
		
	}

	public boolean isAlertPresent()
	{
			try 
		{
			driver.switchTo().alert();
			return true;
			
		}
		catch (NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	@DataProvider (name = "LoginData")
	String[][] getData() throws IOException 
	{
		String path = System.getProperty("user.dir")+"/src/test/java/com/iNetBanking/testData/LoginTestData.xlsx";
		
		int rowNum = XLUtils.getRowCount(path, "Sheet1");
		int colNum = XLUtils.getCellCount(path,  "Sheet1", 1);
		
		String logindata[][] = new String[rowNum][colNum];
		
		for (int i=1;i<=rowNum;i++)
		{
			for (int j=0; j<colNum;j++)
			{
				logindata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i,j);
			}
		}
		return logindata;
		
	}
	
}

