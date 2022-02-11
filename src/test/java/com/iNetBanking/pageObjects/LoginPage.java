package com.iNetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//eBanking login page http://demo.guru99.com/v4/index.php	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//Identifying and creating the elements
	@FindBy (name ="uid")
	WebElement txtUserName;
	
	@FindBy (name = "password")
	WebElement txtPwd;
	
	@FindBy (name ="btnLogin")
	WebElement btnLogin;
	
	@FindBy (xpath ="/html/body/div[3]/div/ul/li[10]/a")
	WebElement lnkLogOut;
	
	
	//Creating the Actions on elements
	
	public void setUsername(String uName)
	{
		txtUserName.sendKeys(uName);		
	}
	
	public void setPwd(String pwd)
	{
		txtPwd.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	public void clickLogOut()
	{
		lnkLogOut.click();
	}
}
