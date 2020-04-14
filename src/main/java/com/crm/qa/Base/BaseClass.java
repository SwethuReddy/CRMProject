package com.crm.qa.Base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.Utils.TestUtil;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
		
	//Constructor to initialize the Config.Properties file
	public BaseClass()
	{
		try
		{
	prop = new Properties();
	FileInputStream fi = new FileInputStream("/Users/apple/eclipse/Console/CRM/src/main/java/com/crm/qa/Configs/config.properties");
	prop.load(fi);	
	    }
		catch(Exception e){}
    }
	
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
		 System.setProperty("webdriver.chrome.driver", "/Users/apple/Documents/chromedriver");	
		 driver = new ChromeDriver();
		}
		else if(browserName.equals("Firefox"))
		{
		System.setProperty("webdriver.gecko.driver", "/Users/apple/Documents/chromedriver");	
		driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
}
