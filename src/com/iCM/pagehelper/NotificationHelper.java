package com.iCM.pagehelper;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.iCM.locators.LocatorReader;
import com.iCM.util.DriverHelper;

public class NotificationHelper extends DriverHelper 
{
	private LocatorReader locatorReader;	
	int count = 0;
	String NotificationName = "";
	
	public NotificationHelper(WebDriver driver) 
	{
		super(driver);
		locatorReader = new LocatorReader("Notification.xml");
	}

	public void click(String Button) 
	{
		String locator = locatorReader.getLocator(Button);
		WaitForElementPresent(locator, 20);
		clickOn(locator);
	}
	
	public void type(String Field, String Text)
	{
		String locator = locatorReader.getLocator(Field);
		WaitForElementPresent(locator, 20);
		sendKeys(locator, Text);
	}

	public void verifyNotification(String List) 
	{
		String locator = locatorReader.getLocator(List);
		count = getXpathCount(locator);
		for(int i=1;i<count;i++)
		{
			Assert.assertTrue(isElementPresent(locator+"["+i+"]"));
			waitForWorkAroundTime(500);
		}
	}

	public void verifyCheckBox(String Check) 
	{
		String locator = locatorReader.getLocator(Check);
		for(int i = 0 ;i<count;i++)
		{
			Assert.assertTrue(isElementPresent(locator+i+"']"));
			waitForWorkAroundTime(500);
		}
	}

	public void verifyFieldsText(String Field1, String Field2)
	{
		String locator1 = locatorReader.getLocator(Field1);
		String locator2 = locatorReader.getLocator(Field2);
		System.out.println(getText(locator1)+"\t"+getText(locator2));
		String loc = getText(locator2).replaceAll("View Log","").replaceAll("  ", "");
		System.out.println(loc+"\t"+getText(locator1).contains(loc));
		//Assert.assertTrue(getText(locator1).contains(loc));
		
		NotificationName = getText(locator1);
	}

	public void verifyItemTextNot(String Field) 
	{
		String locator = locatorReader.getLocator(Field);
		WaitForElementPresent(locator, 20);
		waitForWorkAroundTime(3000);
		System.out.println(NotificationName+"\t"+getText(locator));
		Assert.assertFalse(getText(locator).contains(NotificationName));
	}

	public void clickMulple(String Checkbox) 
	{
		String locator = locatorReader.getLocator(Checkbox);
		for(int i=1;i<5;i++)
		{
			String locator1 = locator+i+"']";
			clickOn(locator1);
			waitForWorkAroundTime(200);
		}
	}	
	
	public void ItemNotAvailable(String Field)
	{
		String locator = locatorReader.getLocator(Field);
		Assert.assertFalse(isElementPresent(locator));
	}
}
