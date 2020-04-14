package com.crm.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.Base.BaseClass;

public class LoginPage extends BaseClass {
	
	@FindBy (xpath="//span[text()='Log In']")
	WebElement login;
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement loginbtn;
	
	String actualLoginTitle;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String Title()
	{
		driver.getTitle();
		return actualLoginTitle;
	}
	
	public HomePage login(String un, String pwd)
	{
		login.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		return new HomePage();
    }
	
}