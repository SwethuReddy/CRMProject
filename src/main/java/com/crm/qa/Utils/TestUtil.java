package com.crm.qa.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestUtil {
	
	public static long PAGE_LOAD_TIMEOUT =10;;
	public static long IMPLICIT_WAIT = 10;
	
	
	public void switcheToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void selectDropDown(WebElement element, String text)
	{
		Select select = new Select(element);
		select.selectByVisibleText(text);
		
	}

}
