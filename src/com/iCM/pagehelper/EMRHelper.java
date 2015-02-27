package com.iCM.pagehelper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.iCM.locators.LocatorReader;
import com.iCM.util.DriverHelper;

public class EMRHelper extends DriverHelper 
{
	private LocatorReader emrLocator;	
	int j;
	
	public EMRHelper(WebDriver driver)
	{
		super(driver);
		emrLocator = new LocatorReader("EMRTab.xml");
	}
	
	//Verify Page title
	public void verifyTitle(String title)
	{
		waitForWorkAroundTime(5000);
		Assert.assertTrue(getWebDriver().getTitle().toLowerCase().contains(title.toLowerCase()), "Page title is: " + getWebDriver().getTitle() + " but expected is: "+title);
	}

	public void click(String Field) 
	{
		String locator = emrLocator.getLocator(Field);
		waitForWorkAroundTime(2000);
		WaitForElementPresent(locator, 20);
		getWebDriver().findElement(ByLocator(locator)).click();
	}

	public void verifyNoError() 
	{
		String Field1 = emrLocator.getLocator("EMR.DateCalender");
		String Field2 = emrLocator.getLocator("EMR.AllTab");
		String Field3 = emrLocator.getLocator("EMR.ResiName");
		Assert.assertTrue(isElementPresent(Field1));
		waitForWorkAroundTime(2000);
		Assert.assertTrue(isElementPresent(Field2));
		waitForWorkAroundTime(2000);
		Assert.assertTrue(isElementPresent(Field3));
		waitForWorkAroundTime(2000);
	}

	public void clickAdmin() 
	{
		int LocatorCount = getXpathCount("//td[@class='All']/div");
		System.out.println(LocatorCount);
		for(j = 1 ;j<LocatorCount;j++)
		{
			String newLocator = "//td[@class='All']/div["+j+"]/div/div[2]/div/button[2]";
			if(isElementPresent(newLocator))
			{
				clickOn(newLocator);
				break;
			}
		}
		waitForWorkAroundTime(2000);
	}

	public void mouseHover(String Field) 
	{
		String locator = emrLocator.getLocator(Field);
		WaitForElementPresent(locator, 20);
		mouseOver(locator);
	}

	public void verifyFieldPopulated(String Field)
	{
		String locator = "//*[@id='OResults']";//emrLocator.getLocator(Field);
		System.out.println(getAttribute(locator, "value"));
		Assert.assertFalse(getAttribute(locator, "value").contains(""));
	}

	public void clickPop(String Field) 
	{
		String locator = emrLocator.getLocator(Field);
		waitForWorkAroundTime(1000);
		WaitForElementPresent(locator, 20);
		mouseOver(locator);
		
		System.out.println(getWebDriver().findElement(ByLocator(locator)).getSize());
		System.out.println(getWebDriver().findElement(ByLocator(locator)).isDisplayed());
		System.out.println(getWebDriver().findElement(ByLocator(locator)).getLocation());
		System.out.println(getWebDriver().findElement(ByLocator(locator)).getSize());
		waitForWorkAroundTime(1000);
		System.out.println(getText(locator));
		clickOn(locator);
		waitForWorkAroundTime(3000);
		
	}

	public void clickAdminister() 
	{
		int LocatorCount = getXpathCount("//td[@class='All']/div");
		System.out.println(LocatorCount);
		for(j = 1 ;j<LocatorCount;j++)
		{
			String newLocator = "//td[@class='All']/div["+j+"]/div/div[2]/div/button[1]";
			if(isElementPresent(newLocator))
			{
				clickOn(newLocator);
				break;
			}
		}
		waitForWorkAroundTime(2000);
	}

	public void verifyFieldText(String Field,String Text) 
	{
		
		String locator = emrLocator.getLocator(Field);
		Assert.assertTrue(getText(locator).contains(Text));
		waitForWorkAroundTime(2000);
	}

	public void verifyFieldNot(String Field) 
	{
		String locator = emrLocator.getLocator(Field);
		WaitForElementPresent(locator, 20);
		Assert.assertFalse(isElementPresent(locator));
	}
}
