package com.iCM.pagehelper;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.iCM.locators.LocatorReader;
import com.iCM.util.DriverHelper;

public class StaffHelper extends DriverHelper 
{
	private LocatorReader locatorReader;	

	
	public StaffHelper(WebDriver driver) 
	{
		super(driver);
		locatorReader = new LocatorReader("Staff.xml");
	}

	public void click(String string) 
	{
		String locator = locatorReader.getLocator(string);
		waitForWorkAroundTime(2000);
		clickOn(locator);
	}

	public void verifyTab(String Tab, String Value)
	{
		String locator = locatorReader.getLocator(Tab);
		WaitForElementPresent(locator, 20);
		Assert.assertTrue(getText(locator).contains(Value));
	}

	public void verifyTabNot(String text)
	{
		boolean result = driver.findElement(ByLocator("//body")).getText().contains(text);
		Assert.assertFalse(result);
	}
	
	public void verifyItemText(String Field, String Text)
	{
		String locator = locatorReader.getLocator(Field);
		WaitForElementPresent(locator, 20);
		Assert.assertTrue(getText(locator).contains(Text));
	}
	
	public void type(String Field, String Text)
	{
		String locator = locatorReader.getLocator(Field);
		WaitForElementPresent(locator, 20);
		sendKeys(locator, Text);
	}
	
}
