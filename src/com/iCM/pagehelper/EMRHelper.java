package com.iCM.pagehelper;

import java.util.Calendar;
import java.util.TimeZone;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Key;
import org.testng.Assert;

import com.iCM.locators.LocatorReader;
import com.iCM.util.DriverHelper;

public class EMRHelper extends DriverHelper
{
	private LocatorReader emrLocator;
	String AMPM="";
	
	public EMRHelper(WebDriver driver)
	{
		super(driver);
		emrLocator = new LocatorReader("EMR.xml");
	}

	public void click(String Field) 
	{
		String locator = emrLocator.getLocator(Field);
		WaitForElementPresent(locator, 20);
		clickOn(locator);
		waitForWorkAroundTime(3000);
	}

	public void verifyNoError(String Field1, String Field2, String Field3) 
	{
		String locator1 = emrLocator.getLocator(Field1);
		String locator2 = emrLocator.getLocator(Field2);
		String locator3 = emrLocator.getLocator(Field3);
		
		Assert.assertTrue(isElementPresent(locator1));
		waitForWorkAroundTime(2000);
		Assert.assertTrue(isElementPresent(locator2));
		waitForWorkAroundTime(2000);
		Assert.assertTrue(isElementPresent(locator3));
		waitForWorkAroundTime(2000);
	}

	public void verifyItemText(String Field, String Text) 
	{
		String locator = emrLocator.getLocator(Field);
		WaitForElementPresent(locator, 20);
		System.out.println(Text+"\t"+getText(locator));
		Assert.assertTrue(getText(locator).contains(Text));
		waitForWorkAroundTime(3000);
	}

	public void verifyItem(String Field) 
	{
		String locator = emrLocator.getLocator(Field);
		WaitForElementPresent(locator, 20);
		Assert.assertTrue(isElementPresent(locator));
	}

	public void mouseHover(String Field)
	{
		String locator = emrLocator.getLocator(Field);
		WaitForElementPresent(locator, 20);
		mouseOver(locator);
		System.out.println(getText(locator));
		waitForWorkAroundTime(2000);
	}

	public void verifyFieldPopulated(String Field)
	{
		String locator = emrLocator.getLocator(Field);
		WaitForElementPresent(locator, 20);
		String value = getAttribute(locator, "value");
		Assert.assertFalse(value.equals(null));
	}

	public void verifyCurrentDateTime(String Field, String Text)
	{
		String value, newMin,newMin1,value1 ="";
		TimeZone tz = TimeZone.getTimeZone("GMT-4:01");
		Calendar c = Calendar.getInstance(tz);
		String locator = emrLocator.getLocator(Field);
		WaitForElementPresent(locator, 20);
		
		if(Text.contains("date"))
		{
			value = c.get(Calendar.MONTH)+1+"/"+c.get(Calendar.DATE)+"/"+c.get(Calendar.YEAR);
			System.out.println("DATE in Field : "+getAttribute(locator, "value"));
			System.out.println("DATE BY CODE : "+value);
			Assert.assertTrue(getAttribute(locator, "value").contains(value));
		}
		if(Text.contains("time"))
		{
			if(c.get(Calendar.AM_PM)==0)
			{
				AMPM=" AM";
			}
			else
			{
				AMPM=" PM";
			}
			if(c.get(Calendar.MINUTE)<10)
			{
				newMin = "0"+c.get(Calendar.MINUTE);
			}
			else
			{
				newMin=String.valueOf(c.get(Calendar.MINUTE));
			}
			if(c.get(Calendar.MINUTE+1)<10)
			{
				newMin1 = "0"+c.get(Calendar.MINUTE+1);
			}
			else
			{
				newMin1=String.valueOf(c.get(Calendar.MINUTE+1));
			}
			value = c.get(Calendar.HOUR)+":"+newMin+AMPM;
			value1 = c.get(Calendar.HOUR)+":"+newMin1+AMPM;
			System.out.println("Time in Field : "+getAttribute(locator, "value"));
			System.out.println("Time BY CODE : "+value);
			Assert.assertTrue(getAttribute(locator, "value").contains(value)||getAttribute(locator, "value").contains(value1));
		}
	}

	public void Dclick(String Field)
	{
		//String locator = emrLocator.getLocator(Field);
		//JavascriptExecutor js = (JavascriptExecutor) driver;  
		//js.executeScript("window.document.getElementsByClassName('administerlate').click()");
		System.out.println("Total elements:"+getWebDriver().findElements(ByLocator("link=Administer Late")).size());
		getWebDriver().findElements(ByLocator("link=Administer Late")).get(1).click();
	//	mouseDoubleClick("link=Administer Late");
	}

	public void type(String Field, String Text)
	{
		String locator = emrLocator.getLocator(Field);
		WaitForElementPresent(locator, 20);
		sendKeys(locator, Text);
	}

	public void select(String Field, String Value)
	{
		String obj = emrLocator.getLocator(Field);
		selectDropDown(obj, Value);
		waitForWorkAroundTime(500);
	}

	public void clickAt(String Field, String Value)
	{
		String locator = emrLocator.getLocator(Field);
		Value = locator + Value;
		clickOn(Value);
	}

	public void verifyDateTime(String Field, String Text)
	{
		String value,newMin,value1,newMin1 ="";
		TimeZone tz = TimeZone.getTimeZone("GMT-5:00");
		Calendar c = Calendar.getInstance(tz);
		String locator = emrLocator.getLocator(Field);
		WaitForElementPresent(locator, 20);
		
		if(Text.contains("date"))
		{
			value = c.get(Calendar.MONTH)+1+"/"+c.get(Calendar.DATE)+"/"+c.get(Calendar.YEAR);
			System.out.println("DATE in Field : "+getText(locator));
			System.out.println("DATE BY CODE : "+value);
			Assert.assertTrue(getText(locator).contains(value));
		}
		if(Text.contains("time"))
		{
			if(c.get(Calendar.AM_PM)==0)
			{
				AMPM=" AM";
			}
			else
			{
				AMPM=" PM";
			}
			if(c.get(Calendar.MINUTE)<10)
			{
				newMin = "0"+c.get(Calendar.MINUTE);
			}
			else
			{
				newMin = String.valueOf(c.get(Calendar.MINUTE));
			}
			if(c.get(Calendar.MINUTE)+1<10)
			{
				newMin1 = "0"+c.get(Calendar.MINUTE)+1;
			}
			else
			{
				newMin1 = String.valueOf(c.get(Calendar.MINUTE)+1);
			}
			value = c.get(Calendar.HOUR)+":"+newMin+AMPM;
			value1 = c.get(Calendar.HOUR)+":"+newMin1+AMPM;
			System.out.println("Time in Field : "+getText(locator));
			System.out.println("Time BY CODE : "+value);
			System.out.println("Time BY CODE1 : "+value1);
			Assert.assertTrue(getText(locator).contains(value)||getText(locator).contains(value1));
		}	
	}

	public void verifyFieldText(String Field, String Text)
	{
		String locator = emrLocator.getLocator(Field);
		WaitForElementPresent(locator, 20);
		Assert.assertTrue(getText(locator).equalsIgnoreCase(Text));
		
	}

	public void verifyOverlay() 
	{
		String locator1 = emrLocator.getLocator("Heading");
		String locator2 = emrLocator.getLocator("RecordType");
		String locator3 = emrLocator.getLocator("BloodSuger");
		Assert.assertTrue(getText(locator1).contains("Administer Medication with reading"));
		Assert.assertTrue(isElementPresent(locator2));
		Assert.assertTrue(isElementPresent(locator3));
	}

	public void verifyFieldNot(String Field) 
	{
		String locator = emrLocator.getLocator(Field);
		WaitForElementPresent(locator, 20);
		Assert.assertFalse(isElementPresent(locator));
	}

	public void clickOnFirst(String Field1,String Field2, String Field3, String Field4) 
	{
		String locator1 = emrLocator.getLocator(Field1);
		getWebDriver().findElement(ByLocator(locator1)).sendKeys(Key.TAB);
		mouseHover(Field2);
		waitForWorkAroundTime(2000);
		String locator2 = emrLocator.getLocator(Field3);
		getWebDriver().findElement(ByLocator(locator2)).sendKeys(Key.TAB);
		String locator3 = emrLocator.getLocator(Field4);
		waitForWorkAroundTime(2000);
		getWebDriver().findElement(ByLocator(locator3)).sendKeys(Key.ENTER);
	}

	public void clickOnSecond(String Field1, String Field2, String Field3,String Field4,String Field5) 
	{
		String locator1 = emrLocator.getLocator(Field1);
		getWebDriver().findElement(ByLocator(locator1)).sendKeys(Key.TAB);
		mouseHover(Field2);
		waitForWorkAroundTime(2000);
		String locator2 = emrLocator.getLocator(Field3);
		getWebDriver().findElement(ByLocator(locator2)).sendKeys(Key.TAB);
		String locator3 = emrLocator.getLocator(Field4);
		getWebDriver().findElement(ByLocator(locator3)).sendKeys(Key.TAB);
		String locator4 = emrLocator.getLocator(Field5);
		getWebDriver().findElement(ByLocator(locator4)).sendKeys(Key.ENTER);	
	}

	public void clickOnThird(String Field1, String Field2, String Field3,
			String Field4, String Field5, String Field6)
	{
		String locator1 = emrLocator.getLocator(Field1);
		getWebDriver().findElement(ByLocator(locator1)).sendKeys(Key.TAB);
		mouseHover(Field2);
		waitForWorkAroundTime(2000);
		String locator2 = emrLocator.getLocator(Field3);
		getWebDriver().findElement(ByLocator(locator2)).sendKeys(Key.TAB);
		String locator3 = emrLocator.getLocator(Field4);
		getWebDriver().findElement(ByLocator(locator3)).sendKeys(Key.TAB);
		String locator4 = emrLocator.getLocator(Field5);
		getWebDriver().findElement(ByLocator(locator4)).sendKeys(Key.TAB);
		String locator5 = emrLocator.getLocator(Field6);
		getWebDriver().findElement(ByLocator(locator5)).sendKeys(Key.ENTER);
	}

	public void verifyRecordUpdate(String Item)
	{
		TimeZone tz = TimeZone.getTimeZone("GMT-5:00");
		Calendar c = Calendar.getInstance(tz);
		String date = String.valueOf(c.get(Calendar.DATE)+2);
		String locator = "//*[@id='administeredlogtbl']/tbody/tr/td["+date+"]";
		Assert.assertTrue(getText(locator).contains("AK"));
		waitForWorkAroundTime(3000);
	}
	
	public void verifyColor(String Field,String colour)
	{
		
		String locator = emrLocator.getLocator(Field);
		String value = getAttribute(locator, "class");
		if(colour =="Green")
		{
			Assert.assertTrue(value.contains("btn-success"));
		}
		if(colour =="Orange")
		{
			Assert.assertTrue(value.contains("btn-warning"));
		}
	}

	public void verifyMAROverlay(String Field) 
	{
		verifyItem(Field);
		waitForWorkAroundTime(3000);
		
	}

	public void verifyNotNegative(String Field, String Value) 
	{
		String locator = emrLocator.getLocator(Field);
		Assert.assertFalse(getText(locator).contains("-"));
		
	}

	public void verifyToForm(String Field) 
	{
		String locator = emrLocator.getLocator(Field);
		Calendar c = Calendar.getInstance();
		int newMon = c.get(Calendar.MONTH)+1;
	 	String TodayDate ="From: "+newMon+"/"+c.get(Calendar.DATE)+"/"+c.get(Calendar.YEAR)+"\nat 12:00 AM";
		String lastDate = "To: 9/03/2015\nat 12:00 AM";
		WaitForElementPresent(locator, 20);
		Assert.assertTrue(getText(locator).contains(TodayDate));
		Assert.assertTrue(getText(locator).contains(lastDate));
	}
}
