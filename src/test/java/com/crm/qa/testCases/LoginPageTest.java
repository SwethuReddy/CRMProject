package com.crm.qa.testCases;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.Base.BaseClass;
import com.crm.qa.Pages.HomePage;
import com.crm.qa.Pages.LoginPage;

public class LoginPageTest extends BaseClass
   {	
	
	LoginPage loginPage;
	HomePage homePage;
	Logger logger = Logger.getLogger(LoginPageTest.class);
	
	String expectedLoginTitle = "Cogmento CRM";
	
	//Constructor to call BaseClass Constructor
	public LoginPageTest(){
		super();
	}	
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		BasicConfigurator.configure();
		logger.info("Initialization is almost done");
		loginPage = new LoginPage();				
	}

	@Test()
	public void verifyLoginTest()
	{
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	    String actualLoginTitle = driver.getTitle();
		Assert.assertEquals(expectedLoginTitle, actualLoginTitle);
	}
		
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
	
}
