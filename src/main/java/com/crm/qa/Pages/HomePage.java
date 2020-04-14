package com.crm.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.Base.BaseClass;

public class HomePage extends BaseClass{
	
  @FindBy (xpath="//span[text()='Swetha Reddy']")
  WebElement userNameLabel;
  
  @FindBy (xpath="//span[text()='Contacts']")
  WebElement contactsLink;
  
  @FindBy (xpath="//div[text()='Contacts']")
  WebElement contactsDisplay;
  
  public HomePage(){
	  PageFactory.initElements(driver, this);
  }
  
  public boolean userid()
  {
	  return userNameLabel.isDisplayed();
  }
  
  public ContactsPage clickContactLink()
  {
	  contactsLink.click();
	  return new ContactsPage();
  }
  
  public boolean contactsDisplay()
  {
	  return contactsDisplay.isDisplayed();
  }
}
