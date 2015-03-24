package com.iCM.scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.iCM.pagehelper.EChartHelper;
import com.iCM.pagehelper.LoginHelper;
import com.iCM.pagehelper.PRNHelper;
import com.iCM.pagehelper.ResidentHelper;
import com.iCM.util.DriverTestCase;
import com.iCM.util.ExecutionLog;

public class PRNCheckBoxAvail extends DriverTestCase
{	
	@Test
	public void testPRNCheckBoxAvail() throws Exception
	{			
		//Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		residentHelper = new ResidentHelper(getWebDriver());
		echartHelper = new EChartHelper(getWebDriver());
		prnHelper = new PRNHelper(getWebDriver());
	
		ExecutionLog.LogAddClass(this.getClass().getName() + " and Test method " +Thread.currentThread().getStackTrace()[1].getMethodName());
		try{


				//Open application
				ExecutionLog.Log("Open application url");
				openUrl(application_url);
				ExecutionLog.Log("Pass");
				
				LoginLive();
				
				//Go to Resident list
				ExecutionLog.Log("Go to Resident list");
				visit("Resident/List");
				ExecutionLog.Log("Pass");
				
				//Search Added Resident
				ExecutionLog.Log("Search Added resident");
				residentHelper.type("Demo QA Test","AddResident.SearchResident");
				ExecutionLog.Log("Pass");
				
				//Verify searched resident
				ExecutionLog.Log("Verify searched resident");
				residentHelper.verifyResident("Demo QA Test", "AddResident.ResidentName");
				ExecutionLog.Log("Pass");
				
				//Open the profile of the resident
				ExecutionLog.Log("Open resident Profile");
				residentHelper.click("AddResident.ResidentName");
				ExecutionLog.Log("Pass");
				
				//wait
				residentHelper.waitForWorkAroundTime(3000);
				
				//Get User ID
				String id = echartHelper.getID();
				System.out.println("Id return by method"+id);
				System.out.println("current url"+getWebDriver().getCurrentUrl());
				String finalurl="Medication/List/"+id;
				System.out.println("Print final url"+finalurl);
				
				//Click on 'Medication'.
				ExecutionLog.Log("Click on Medication button");
				echartHelper.click("EChart.Medication");
				visit(finalurl);
				ExecutionLog.Log("Pass");
				
				//Click on 'Add Medication' button
				ExecutionLog.Log("Click on Add Medication button");
				echartHelper.click("AddMedication.AddButton");
				ExecutionLog.Log("Pass");
				
				//Verify PRN Checkbox available
				ExecutionLog.Log("Verify PRN Checkbox available");
				prnHelper.verifyItem("PRNCheck");
				ExecutionLog.Log("Pass");
				
				//Enter medicine name
				ExecutionLog.Log("Enter Medicine Name");
				echartHelper.type("D-Cold Total","AddMedication.MedicineName");
				ExecutionLog.Log("Pass");
				
				//Ender Dosage
				ExecutionLog.Log("Enter Dosage");
				echartHelper.type("Daily","AddMedication.Dosage");
				ExecutionLog.Log("Pass");
				
				//Ender Dosage
				ExecutionLog.Log("Enter instruction");
				echartHelper.type("Avoid cold water","AddMedication.Instuction");
				ExecutionLog.Log("Pass");
				
				//Open 'Calender
				ExecutionLog.Log("Open 'Calender'");
				echartHelper.openCalendar("AddMedication.StartDate");
				ExecutionLog.Log("Pass");
				
				//Wait
				echartHelper.waitForWorkAroundTime(3000);
				
				//Select date
				ExecutionLog.Log("Select date");
				residentHelper.selectDate("AddResident.Date");
				ExecutionLog.Log("Pass");
				
				//Select time 
				ExecutionLog.Log("Select time");
				echartHelper.select("AddMedication.Time","8:30");
				ExecutionLog.Log("Pass");
				
				//Select time 
				ExecutionLog.Log("Select AM/PM");
				echartHelper.select("AddMedication.TimeTyep","AM");
				ExecutionLog.Log("Pass");
				
				//Click on 'Add schedule'
				ExecutionLog.Log("Click on Add Schedule button");
				echartHelper.click("AddMedication.AddSchedule");
				ExecutionLog.Log("Pass");
				
				//Select time 
				ExecutionLog.Log("Select time");
				echartHelper.select("AddMedication.Time","2:30");
				ExecutionLog.Log("Pass");
				
				//Select time 
				ExecutionLog.Log("Select AM/PM");
				echartHelper.select("AddMedication.TimeTyep","PM");
				ExecutionLog.Log("Pass");
				
				//Click on 'Add schedule'
				ExecutionLog.Log("Click on Add Schedule button");
				echartHelper.click("AddMedication.AddSchedule");
				ExecutionLog.Log("Pass");
				
				//Select time 
				ExecutionLog.Log("Select time");
				echartHelper.select("AddMedication.Time","8:30");
				ExecutionLog.Log("Pass");
				
				//Select time 
				ExecutionLog.Log("Select AM/PM");
				echartHelper.select("AddMedication.TimeTyep","PM");
				ExecutionLog.Log("Pass");
				
				//Click on 'Add schedule'
				ExecutionLog.Log("Click on Add Schedule button");
				echartHelper.click("AddMedication.AddSchedule");
				ExecutionLog.Log("Pass");
				
				//Click on 'Save' button
				ExecutionLog.Log("Click on Save button");
				echartHelper.click("AddMedication.SaveMedi");
				ExecutionLog.Log("Pass");
				
				//Verify PRN displayed at 'View' medication screen.
				//prnHelper.verifyItem("PRNView");

				//Wait
				prnHelper.waitForWorkAroundTime(3000);
		}

		catch (Error e)
		{
			captureScreenshot("testPRNCheckBoxAvail");	
			ExecutionLog.LogErrorMessage(e);			
			throw e;
		} 
		catch(Exception e) 
		{
			captureScreenshot("testPRNCheckBoxAvail");
			ExecutionLog.LogExceptionMessage(e);			
			throw e;
		}		
	}

	@AfterMethod
	public void endMethods() throws Exception
	{		
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}
