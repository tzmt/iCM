package com.iCM.pagehelper;

import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.iCM.locators.LocatorReader;
import com.iCM.util.DriverHelper;

public class TaskHelper extends DriverHelper 
{
	private LocatorReader taskLocator;	

	
	public TaskHelper(WebDriver driver)
	{
		super(driver);
		taskLocator = new LocatorReader("Task.xml");
	}
	
	public void click(String Button)
	{
		String locator = taskLocator.getLocator(Button);
	 	WaitForElementPresent(locator, 20);
	 	clickOn(locator);
	}
	
	public void verifyItem(String Field) 
	{
		String locator = taskLocator.getLocator(Field);
		WaitForElementPresent(locator, 20);
		Assert.assertTrue(isElementPresent(locator));
	}

	public void mouseHover(String Field)
	{
		String locator = taskLocator.getLocator(Field);
		WaitForElementPresent(locator, 20);
		mouseOver(locator);
		System.out.println(getText(locator));
		waitForWorkAroundTime(2000);
	}

	public void verifyFieldPopulated(String Field)
	{
		String locator = taskLocator.getLocator(Field);
		WaitForElementPresent(locator, 20);
		String value = getAttribute(locator, "value");
		Assert.assertFalse(value.equals(null));
	}

	public void type(String Field, String Text)
	{
		String locator = taskLocator.getLocator(Field);
		WaitForElementPresent(locator, 20);
		sendKeys(locator, Text);
	}

	public void select(String Field, String Value)
	{
		String obj = taskLocator.getLocator(Field);
		selectDropDown(obj, Value);
		waitForWorkAroundTime(500);
	}

	public void verifyFieldText(String Field, String Text)
	{
		String locator = taskLocator.getLocator(Field);
		WaitForElementPresent(locator, 20);
		Assert.assertTrue(getText(locator).equalsIgnoreCase(Text));	
	}
	
	public void verifyFieldNot(String Field) 
	{
		String locator = taskLocator.getLocator(Field);
		WaitForElementPresent(locator, 20);
		Assert.assertFalse(isElementPresent(locator));
		waitForWorkAroundTime(3000);
	}
	
	public void openCalendar(String calender) 
	{
		String obj = taskLocator.getLocator(calender);
		clickOn(obj);
		waitForWorkAroundTime(1000);
	}

	public void selectYear(String YearDrp, String value)
	{
		String obj = taskLocator.getLocator(YearDrp);
		waitForWorkAroundTime(5000);
		selectDropDown(obj, value);
		waitForWorkAroundTime(500);
	}
	
	public void selectDate(String Date) 
	{
		String obj = taskLocator.getLocator(Date);
		Calendar cal = Calendar.getInstance(); 
		int date = cal.get(Calendar.DAY_OF_MONTH);
		String newValue = obj+date;
		System.out.println(newValue);
		clickOn(newValue);
		waitForWorkAroundTime(500);
		
	}
}
