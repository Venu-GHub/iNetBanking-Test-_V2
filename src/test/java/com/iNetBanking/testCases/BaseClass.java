package com.iNetBanking.testCases;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.iNetBanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	
	
	//hard coded values vs Reading from ReadConfig value
	//public String baseURL ="https://demo.guru99.com/V1/index.php";
	public String baseURL =readconfig.getApplicationURL();
	
	
		//public String userName= "mngr376836";
		public String userName= readconfig.getUserName();
		
		//public String password = "UgumUzA";
		public String password = readconfig.getPassword();
		
		public static WebDriver driver;
		public static Logger logger;
		
		@Parameters ("browser")
		@BeforeClass
		public void setup(String br)
		{
			
			logger = Logger.getLogger("iNetBanking");
			PropertyConfigurator.configure("log4j.properties");
			
			//System.setProperty("webdriver.chrome.driver","F:\\Selenium Practice\\iNetBanking_V1\\Drivers\\chromedriver.exe");
			
			//System.getProperty("user.dir") returns the current project name
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
						
			if (br.equals("chrome"))
					{
				//Using the ReadConfig utility and reading the chrome driver values
				System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());				
				driver = new ChromeDriver();
					}
			
			else if(br.equals("ie"))
					{
				System.setProperty("webdriver.ie.driver", readconfig.getIEPath());				
				driver = new InternetExplorerDriver();
					}
			
			else if (br.equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", readconfig.getFireFoxPath());				
				driver = new FirefoxDriver();
				
			}
			
			else if (br.equals("edge"))
			{
				System.setProperty("webdriver.edge.driver", readconfig.getMSEdgePath());				
				driver = new EdgeDriver();
				
			}
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			//launching the URL from base class
			driver.get(baseURL);			
					
		}

		@AfterClass
		public void tearDown()
		{
			driver.quit();
		}
		
		public void captureScreen(WebDriver driver, String tname) throws IOException
		{
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir") + "/Screenshots/" +tname+ ".png");
			FileUtils.copyFile(source,target);
			System.out.println("Screenshot taken");			
		}
		
		public  String randomString() 
		{
			String randString = RandomStringUtils.randomAlphabetic(8);
			return randString;			
		}
		
		public String randomNumber()
		{
			String randomNum = RandomStringUtils.randomNumeric(10);
			return randomNum;
		}
		
}
