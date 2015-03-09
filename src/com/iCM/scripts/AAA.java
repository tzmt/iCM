package com.iCM.scripts;


import java.awt.List;
import java.util.Calendar;
import java.util.Random;

import com.iCM.pagehelper.EChartHelper;
import com.iCM.util.DriverHelper;

import java.util.TimeZone;

import org.openqa.selenium.WebDriver;

public class AAA
{

	public static void main(String as[])
	{
		
		
		 String AMPM,newMin="";
		 
		TimeZone tz = TimeZone.getTimeZone("GMT-4:01");
		Calendar c = Calendar.getInstance(tz);
		System.out.println(c.get(java.util.Calendar.HOUR_OF_DAY)+":"+c.get(java.util.Calendar.MINUTE)+":"+c.get(java.util.Calendar.SECOND)+"="+c.get(Calendar.DATE));
		System.out.println(c.get(Calendar.MONTH)+1+"/"+c.get(Calendar.DATE)+"/"+c.get(Calendar.YEAR));
		String value = "time";  
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
		
			value = c.get(Calendar.HOUR)+":"+newMin+AMPM;
			System.out.println(value);
	}
}