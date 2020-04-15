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

public class HomePageTest extends BaseClass{
	
	LoginPage loginPage;
	HomePage homePage;
	Logger logger = Logger.getLogger(HomePageTest.class);
	
	//Constructor to call BaseClass constructor 
	HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test()
	public void verifyUserNameLable()
	{		
		Assert.assertTrue(homePage.userid(), "User ID isn't displayed");
	}
	
    @Test (priority=2)
    public void verifyClickContactsLink()
    {
    	BasicConfigurator.configure();
    	logger.info("Clicking on contacts link now");
    	homePage.clickContactLink();
	}
	
	@Test (priority=3)
	public void verifyContacts()
	{
		homePage.clickContactLink();
		Assert.assertTrue(homePage.contactsDisplay(), "Contacts is displayed on Contacts page");
	}
		
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
	
}
