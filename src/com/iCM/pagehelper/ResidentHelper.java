package com.iCM.pagehelper;

import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.iCM.locators.LocatorReader;
import com.iCM.util.DriverHelper;

public class ResidentHelper extends DriverHelper 
{
	private LocatorReader residentLocator;	

	
	public ResidentHelper(WebDriver driver) 
	{
		super(driver);
		residentLocator = new LocatorReader("Resident.xml");
	}
	
	//Type text
	public void type(String value, String locatorNode)
	{
		String locator = residentLocator.getLocator(locatorNode);
		WaitForElementPresent(locator, 20);
		sendKeys(locator, value);
	}
	
	//Click
	public void click(String locator)
	{
		String obj = residentLocator.getLocator(locator);
		WaitForElementPresent(locator, 20);
		clickOn(obj);
	}

	public void openCalendar(String calender) 
	{
		String obj = residentLocator.getLocator(calender);
		clickOn(obj);
		waitForWorkAroundTime(1000);
	}

	public void selectYear(String YearDrp, String value)
	{
		String obj = residentLocator.getLocator(YearDrp);
		waitForWorkAroundTime(5000);
		selectDropDown(obj, value);
		waitForWorkAroundTime(500);
	}
	
	public void selectDate(String Date) 
	{
		String obj = residentLocator.getLocator(Date);
		Calendar cal = Calendar.getInstance(); 
		int date = cal.get(Calendar.DAY_OF_MONTH);
		String newValue = obj+date;
		System.out.println(newValue);
		clickOn(newValue);
		waitForWorkAroundTime(500);
		
	}

	public void selectGender(String gender) 
	{
		String obj = residentLocator.getLocator(gender);
		clickOn(obj);
		waitForWorkAroundTime(500);
		obj = residentLocator.getLocator("AddResident.SelectMale");
		clickOn(obj);
	}
	
	public void selectStatus(String status)
	{
		String obj = residentLocator.getLocator(status);
		clickOn(obj);
		waitForWorkAroundTime(500);
		obj = residentLocator.getLocator("AddResident.Signle");
		clickOn(obj);
	}

	public void selectMonth(String month, String value) 
	{
		String obj = residentLocator.getLocator(month);
		selectDropDown(obj, value);
		waitForWorkAroundTime(500);
	}

	public void selectFacality(String facality)
	{
		String obj = residentLocator.getLocator(facality);
		clickOn(obj);
		waitForWorkAroundTime(500);
		obj = residentLocator.getLocator("AddResident.Facality_Value");
		clickOn(obj);
	}

	public void selectNurse(String Nurse)
	{
		String obj = residentLocator.getLocator(Nurse);
		clickOn(obj);
		waitForWorkAroundTime(500);
		obj = residentLocator.getLocator("AddResident.Nurse_Value");
		clickOn(obj);
	}

	public void verifyResident(String Name,String ResidentName) 
	{
		waitForWorkAroundTime(3000);
		String obj = residentLocator.getLocator(ResidentName);
		String value = getText(obj);
		Assert.assertTrue(value.contains(Name));
	}

	public void verifyResidentNot(String ResidentName)
	{
		waitForWorkAroundTime(3000);
		String obj = residentLocator.getLocator(ResidentName);
		Assert.assertFalse(isElementPresent(obj));
		
	}

	public boolean verify(String ResidentName) 
	{
		waitForWorkAroundTime(3000);
		String obj = residentLocator.getLocator(ResidentName);
		String value = getText(obj);
		Assert.assertTrue(value.contains("lname"));
		return true;
	}

	public boolean verifyResidentNotReturn(String ResidentName)
	{
		waitForWorkAroundTime(3000);
		String obj = residentLocator.getLocator(ResidentName);
		Assert.assertFalse(isElementPresent(obj));
		return true;
		
	}
}
