package com.iCM.pagehelper;

import org.openqa.selenium.WebDriver;

import com.iCM.locators.LocatorReader;
import com.iCM.util.DriverHelper;

public class DeleteHelper extends DriverHelper 
{
	private LocatorReader deleteLocator;	

	
	public DeleteHelper(WebDriver driver) {
		super(driver);
		deleteLocator = new LocatorReader("Delete.xml");
	}


	public void click(String string) 
	{
		String locator = deleteLocator.getLocator(string);
		waitForWorkAroundTime(2000);
		clickOn(locator);
		
	}
	
	
}
