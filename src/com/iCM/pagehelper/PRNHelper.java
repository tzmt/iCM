package com.iCM.pagehelper;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.iCM.locators.LocatorReader;
import com.iCM.util.DriverHelper;

public class PRNHelper extends DriverHelper 
{
	private LocatorReader locatorReader;	

	
	public PRNHelper(WebDriver driver) 
	{
		super(driver);
		locatorReader = new LocatorReader("PRNTab.xml");
	}

	public void click(String Button) 
	{
		String locator = locatorReader.getLocator(Button);
		WaitForElementPresent(locator, 20);
		clickOn(locator);
		
	}

	public void verifyItem(String Field) 
	{
		String locator = locatorReader.getLocator(Field);
		WaitForElementPresent(locator, 20);
		Assert.assertTrue(isElementPresent(locator));
	}

	public void verifyItemText(String Field, String Text) 
	{
		String locator = locatorReader.getLocator(Field);
		WaitForElementPresent(locator, 20);
		Assert.assertTrue(getText(locator).contains(Text));
		
	}

	public void verifyPRNMedNon(String Field, String Text) 
	{
		String locator = locatorReader.getLocator(Field);
		int count = getXpathCount(locator);
		System.out.println(count);
		count = count-1;
		String locator1 = locator+"["+count+"]/td/strong";
		WaitForElementPresent(locator1, 20);
		System.out.println(getText(locator1));
		Assert.assertFalse(getText(locator1).contains(Text));
		
	}

	public void verifyPRNMed(String Field, String Text) 
	{
		String locator = locatorReader.getLocator(Field);
		int count = getXpathCount(locator);
		count = count-1;
		String locator1 = locator+"["+count+"]/td[1]/strong";
		WaitForElementPresent(locator1, 20);
		Assert.assertTrue(getText(locator1).contains(Text));
	}

	public void verifyItemNot(String Field) 
	{
		String locator = locatorReader.getLocator(Field);
		Assert.assertTrue(!isElementPresent(locator));
	}

	public void clickOnPRN(String Button) 
	{
		String locator = locatorReader.getLocator(Button);
		int count = getXpathCount(locator);
		count = count-1;
		String locator1 = locator+"["+count+"]/td[2]/div[1]/div/div/div[2]";
		WaitForElementPresent(locator1, 20);
		clickOn(locator1);
		
	}

	public void type(String Field, String Text) 
	{
		String locator = locatorReader.getLocator(Field);
		WaitForElementPresent(locator, 20);
		sendKeys(locator, Text);
		
	}

	public void verifyPRNNew(String Field, int Count)
	{
		String locator = locatorReader.getLocator(Field);
		int count = getXpathCount(locator);
		count = count-1;
		String locator1 = locator+"["+count+"]/td[2]/div["+Count+"]";
		Assert.assertTrue(isElementPresent(locator1));
		
	}
	
	
}
