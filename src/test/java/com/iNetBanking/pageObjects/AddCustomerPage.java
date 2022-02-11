package com.iNetBanking.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage
{
	WebDriver ldriver;
	public AddCustomerPage (WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements (rdriver, this);
	}
	
		
	@CacheLookup
	@FindBy (xpath = "//a[contains(text(),'New Customer')]")
	WebElement lnkNewCust;
	
	@CacheLookup
	@FindBy (name = "name")
	WebElement txtCustName;
	
	@CacheLookup
	@FindBy (how = How.NAME, using = "rad1")
	WebElement rbGender;
	
	@CacheLookup
	@FindBy (how = How.ID, using ="dob")
	WebElement txtDob;
	
	@CacheLookup
	@FindBy (name = "addr")
	WebElement txtAddress;
	
	@CacheLookup
	//WebElement txtCity = ldriver.findElement(By.name("city"));
	@FindBy (name = "city")
	WebElement txtCity;
	
	@CacheLookup
	@FindBy (how = How.NAME, using ="state")
	WebElement txtState;
	
	@CacheLookup
	@FindBy (how = How.NAME, using = "pinno")
	WebElement numPIN;
	
	@CacheLookup
	//WebElement numTelPh = ldriver.findElement(By.xpath());
	@FindBy (xpath = "//input[@name = 'telephoneno']")
	WebElement numTelPh;
	
	@CacheLookup
	@FindBy (how = How.NAME, using = "emailid")
	WebElement txtEmail;
	
	@CacheLookup
	@FindBy (how = How.XPATH, using = "//input[@name = 'sub']")
	WebElement btnSubmit;
	
	@CacheLookup
	@FindBy (how = How.NAME, using = "res")
	WebElement btnReset;	
	
	
	public void clickAddNewCustomerLink()
	{
		lnkNewCust.click();
	}
	
	public void typeCustName(String cName)
	{
		txtCustName.sendKeys(cName);
	}
	
	public void typeGender(String gender)
	{
		rbGender.click();
	}
	
	public void typeDOB(String mm, String dd, String yyyy)
	{
		txtDob.sendKeys(mm);
		txtDob.sendKeys(dd);
		txtDob.sendKeys(yyyy);
	}
	
	public void typeAddress(String address) 
	{
		txtAddress.sendKeys(address);
		
	}
	
	public void typeCityName (String city)
	{
		txtCity.sendKeys(city);
	}
	
	public void typeStateName (String state)
	{
		txtState.sendKeys(state);
	}
	
	public void typePINCode (int pin)
	{
		numPIN.sendKeys(String.valueOf(pin));
	}
	
	public void typeTeleNo (String TelNo)
	{
		numTelPh.sendKeys(TelNo);
	}
	public void typeEmailID (String email)
	{
		txtEmail.sendKeys(email);
	}
	public void  clickSubmit () {
		btnSubmit.click();
	}
	public void clickReset() {
		btnReset.click();
	}
	
}

