package com.iCM.pagehelper;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.iCM.locators.LocatorReader;
import com.iCM.util.DriverHelper;

public class LoginHelper extends DriverHelper 
{
	private LocatorReader loginLocator;	

	
	public LoginHelper(WebDriver driver) {
		super(driver);
		loginLocator = new LocatorReader("Login.xml");
	}
	
	//Verify Page title
	public void verifyTitle(String title)
	{
		waitForWorkAroundTime(5000);
		Assert.assertTrue(getWebDriver().getTitle().toLowerCase().contains(title.toLowerCase()), "Page title is: " + getWebDriver().getTitle() + " but expected is: "+title);
	}

	//Enter username at login page
	public void enterUserID(String text)
	{
		String locator = loginLocator.getLocator("Login.UserName");
		sendKeys(locator, text);		
	}
	
	//Enter password at login page
	public void enterPassword(String text)
	{
		String locator = loginLocator.getLocator("Login.Password");
		sendKeys(locator, text);		
	}
	
	//Click on Login 
	public void clickLogin()
	{
		String locator = loginLocator.getLocator("Login.LoginBtn");
		clickOn(locator);
	}
	
}
