package com.iCM.scripts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AAA 
{
	public static void main(String as[])
	{
		 Calendar currentMonth = Calendar.getInstance();
	        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM");
	        currentMonth.add(Calendar.MONTH, 1);
	        System.out.println("Curret month of date : "+currentMonth.getTime().toString().substring(4,7));
	        

	}
}
