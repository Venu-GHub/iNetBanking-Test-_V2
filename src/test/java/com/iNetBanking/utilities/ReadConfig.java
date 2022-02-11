package com.iNetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig()
	{
		File src = new File("./Configurations/config.properties");

		try 
		{
			FileInputStream fis = new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
			
		}
		catch (Exception e)
		{
			System.out.println("Exception is "+e.getMessage());
		}
		
	}
	
	public String getApplicationURL()
	{
		String url = pro.getProperty("baseURL");
		return url;
		
	}
	
	
	public String getUserName()
	{
		String username = pro.getProperty("userName");
		return username;
		
	}
	
	public String getPassword()
	{
		String password = pro.getProperty("password");
		return password;
		
	}
	
	public String getChromePath()
	{
		String chromePath = pro.getProperty("chromepath");
		return chromePath;
		
	}
	
	public String getIEPath()
	{
		String iePath = pro.getProperty("iepath");
		return iePath;
		
	}

	public String getFireFoxPath()
	{
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
		
	}
	
	public String getMSEdgePath()
	{
		String msedgepath = pro.getProperty("msedgepath");
		return msedgepath;
		
	}

}
