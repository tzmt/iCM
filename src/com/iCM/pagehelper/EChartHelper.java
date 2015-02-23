package com.iCM.pagehelper;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;





import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.iCM.locators.LocatorReader;
import com.iCM.util.DriverHelper;

public class EChartHelper extends DriverHelper 
{
	private LocatorReader echartLocator;	

	
	public EChartHelper(WebDriver driver) 
	{
		super(driver);
		echartLocator = new LocatorReader("EChart.xml");
	}
	
	public void type(String value, String locatorNode)
	{
		String locator = echartLocator.getLocator(locatorNode);
		waitForWorkAroundTime(3000);
		sendKeys(locator, value);
	}
	
	//Click
	public void click(String locator)
	{
		String obj = echartLocator.getLocator(locator);
		waitForWorkAroundTime(3000);
		clickOn(obj);
	}
	
	//Verify title
	public void verifyTitle(String title)
	{
		waitForWorkAroundTime(5000);
		Assert.assertTrue(getWebDriver().getTitle().toLowerCase().contains(title.toLowerCase()), "Page title is: " + getWebDriver().getTitle() + " but expected is: "+title);
	}

	public void verifyButton(String string) 
	{
		waitForWorkAroundTime(5000);
		String locator = echartLocator.getLocator(string);
		Assert.assertTrue(isElementPresent(locator));
	}
	
	public void openCalendar(String calender) 
	{
		waitForWorkAroundTime(3000);
		String obj = echartLocator.getLocator(calender);
		clickOn(obj);
		waitForWorkAroundTime(500);
	}
	
	public void selectDate(String Date) 
	{
		waitForWorkAroundTime(3000);
		String obj = echartLocator.getLocator(Date);
		Calendar cal = Calendar.getInstance();
				
		int date = cal.get(Calendar.DAY_OF_MONTH);
		String newValue = obj+date;
		clickOn(newValue);
		waitForWorkAroundTime(500);
	}

	public void verifyMedicine(String medical) 
	{
		String obj = echartLocator.getLocator(medical);
		Assert.assertTrue(getText(obj).contains("D-Cold Total"));
	}

	public String getName(String string) 
	{
		String obj = echartLocator.getLocator(string);
		return getText(obj);
	}

	public void deleteMedi(String string, String mediName)
	{
		String obj = echartLocator.getLocator(string);
		Assert.assertFalse(getText(obj).contains(string));
	}
	
	public void performAction(String locator)
	{
		System.out.println("Old Window Title: "+getWebDriver().getTitle());
		//String parentHandle = driver.getWindowHandle();
		String obj = echartLocator.getLocator(locator);
		clickOn(obj);
		for (String winHandle : driver.getWindowHandles())
		 {
		    driver.switchTo().window(winHandle);
		 }
		waitForWorkAroundTime(3000);
		System.out.println("New Window Title: "+getWebDriver().getTitle());
		
	}
	
	public void verifyResi(String medical,String name) 
	{
		String obj = echartLocator.getLocator(medical);
		Assert.assertTrue(getText(obj).contains(name));
	}
	
	public void selectMonth(String month, String value) 
	{
		String obj = echartLocator.getLocator(month);
		selectDropDown(obj, value);
		waitForWorkAroundTime(500);
		
	}
	
	public void select(String Drp, String value)
	{
		String obj = echartLocator.getLocator(Drp);
		WaitForElementPresent(obj, 30);
		selectDropDown(obj, value);
		waitForWorkAroundTime(500);
	}

	public void verifyItem(String item)
	{
		String locator = echartLocator.getLocator(item);
		WaitForElementPresent(locator, 20);
		Assert.assertTrue(isElementPresent(locator));
	}
	
	public String getID()
	{
		waitForWorkAroundTime(3000);
		String St1 = getWebDriver().getCurrentUrl();
		int last = St1.lastIndexOf('/');
		String id = St1.substring(last+1, St1.length());
		System.out.println(id);
		return id;
	}

	public void verifyItemText(String locator, String text) 
	{
		String locato1 = echartLocator.getLocator(locator);
		String value = getText(locato1);
		Assert.assertTrue(value.contains(text));
	}
	
	public void verifyBlackBlocks(String day1, String day2)
	{
		boolean flag = false;
		Calendar cal = Calendar.getInstance();
		int date = cal.get(Calendar.DAY_OF_MONTH);
		String locator = "//*[@id='administeredlogtbl']/thead/tr[2]/td";
		int count = getXpathCount(locator);
		for(int i=date;i<=count;i++)
		{
			String locator1 = "//*[@id='administeredlogtbl']/thead/tr[2]/td["+ i+"]/small";
			String text = getText(locator1);
			if(text.equalsIgnoreCase(day1)||text.equalsIgnoreCase(day2))
			{
				int k=i+2;
				String locator3="//*[@id='administeredlogtbl']/tbody/tr[1]/td["+k+"]";
				String atr=getAttribute(locator3, "style");
				Assert.assertTrue(atr.contains(("background-color: rgb(23, 21, 21);")));
				flag=true;
			}
		}
		Assert.assertTrue(flag);
	}
	
	public void verifyBlackOutFromStart(int st)
	{
		waitForWorkAroundTime(3000);
		Calendar cal = Calendar.getInstance();
		int date = cal.get(Calendar.DAY_OF_MONTH);
		boolean flag = false;
		for(int i=1;i<date;i++)
		{
				int j=i+2;
				String locator3="//*[@id='administeredlogtbl']/tbody/tr["+st+"]/td["+j+"]";
				String atr=getAttribute(locator3, "style");
				Assert.assertTrue(atr.contains("background-color: rgb(23, 21, 21);"));
				flag=true;
		}
		Assert.assertTrue(flag);
	}

	public void removeschedule() 
	{
		String locator = "//table[@id='TimeTable']/tbody/tr[1]//a[contains(text(), 'Remove')]";
		String locator1 =  echartLocator.getLocator("AddMedication.okb");
		while(isElementPresent(locator))
		{
				clickOn(locator);
				clickOn(locator1);
		}
	}

	public String getUSTime()
	{
		  String NewMin = null;
		  Calendar calendar = Calendar.getInstance();
		  calendar.add(Calendar.HOUR_OF_DAY, -10);
		  Date date1 = calendar.getTime();
		  int hrs= Integer.parseInt(date1.toString().substring(11, 13));
		  int Min = Integer.parseInt(date1.toString().substring(14, 16));
		  if(Min<30)
		  {
			  NewMin = "30"; 
		  }
		  else
		  {
			  Min = 0;
			  hrs = hrs+1;
			  NewMin = "00";
		  }
		  if(Min==0)
		  {
			  
		  }
		  String NewD = String.valueOf(hrs)+":"+NewMin;
		  System.out.println(NewD);
		  return NewD;
	  }

	public String getUSAMPM()
	{
		Calendar calendar = Calendar.getInstance();
		  calendar.add(Calendar.HOUR_OF_DAY, -10);
		  Date date1 = calendar.getTime();
		  DateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd a");
		  System.out.println( dateFormat.format (date1));
		  String AMPM = dateFormat.format (date1).toString();
		  System.out.println(AMPM.subSequence(11,13));
		  if(AMPM == "PM")
		  {
			  return "PM";
		  }
		  else
		  {
			  return "AM";
		  }
	}
	
	public void selectDay(String Value) 
	{
		String locator = echartLocator.getLocator(Value);
		clickOn(locator);
	}

	public void clickOnAdmin() 
	{
		waitForWorkAroundTime(3000);
		click("AddMedication.MorningTab");
		boolean result =isElementPresent("Admin.AdminButton"); 
		if(result==true)
		{
			click("Admin.AdminButton");
		}
		else
		{
			click("AddMedication.NoonTab");
			result =isElementPresent("Admin.AdminButton");
			if(result == true)
			{
				click("Admin.AdminButton");
			}
			else
			{
				click("AddMedication.EvnTab");
				result =isElementPresent("Admin.AdminButton");
				if(result == true)
				{
					click("Admin.AdminButton");
				}
			}
		}
		
	}
}