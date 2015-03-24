package com.iCM.scripts;


import java.util.Date;



public class AAA
{

	public static void main(String as[])
	{
		int dat = getRandNumber();
		
		System.out.println(dat);
	}
	public static int getRandNumber()
	{
		Date d = new Date();
		int Rand = Integer.parseInt(d.toString().replaceAll(" ", "").replaceAll(":","").substring(6, 14));
		return Rand;
	}
}