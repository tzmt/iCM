package com.iCM.scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.iCM.pagehelper.EChartHelper;
import com.iCM.pagehelper.LoginHelper;
import com.iCM.pagehelper.ResidentHelper;
import com.iCM.util.DriverTestCase;
import com.iCM.util.ExecutionLog;

public class FieldsAvailableAddEditMedication extends DriverTestCase
{	
	@Test
	public void testFieldsAvailableAddEditMedication() throws Exception
	{			
		//Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		residentHelper = new ResidentHelper(getWebDriver());
		echartHelper = new EChartHelper(getWebDriver());
	
		ExecutionLog.LogAddClass(this.getClass().getName() + " and Test method " +Thread.currentThread().getStackTrace()[1].getMethodName());
		try{

			//Initialize objects
			loginHelper = new LoginHelper(getWebDriver());
			residentHelper = new ResidentHelper(getWebDriver());

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
				
				//Verify Quantity field at Add Medication screen
				ExecutionLog.Log("Verify Quantity Field at add medication screen");
				echartHelper.verifyItem("AddMedication.Quantity");
				ExecutionLog.Log("Pass");
				
				//Verify add phycisian field at Add Medication screen
				ExecutionLog.Log("Verify add phycisian field at Add Medication screen");
				echartHelper.verifyItem("AddMedication.Physician");
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
				
				String Time = echartHelper.getUSTime();
				
				//Select time 
				ExecutionLog.Log("Select time");
				echartHelper.select("AddMedication.Time",Time);
				ExecutionLog.Log("Pass");
				
				String AMPM = echartHelper.getUSAMPM();
				
				//Select time 
				ExecutionLog.Log("Select AM/PM");
				echartHelper.select("AddMedication.TimeTyep",AMPM);
				ExecutionLog.Log("Pass");
				
				//Click on 'Add schedule'
				ExecutionLog.Log("Click on Add Schedule button");
				echartHelper.click("AddMedication.AddSchedule");
				ExecutionLog.Log("Pass");
				
				//Verify Added schedule
				ExecutionLog.Log("Verify Added Schedule");
				echartHelper.verifyItemText("AddMedication.TimeTable_1", Time +" "+AMPM);
				ExecutionLog.Log("Pass");
				
				//Click on 'Save' button
				ExecutionLog.Log("Click on Save button");
				echartHelper.click("AddMedication.SaveMedi");
				ExecutionLog.Log("Pass");
				
				//wait
				echartHelper.waitForWorkAroundTime(3000);
				
				//Click on 'Edit' button
				ExecutionLog.Log("Click on Edit button");
				echartHelper.click("AddMedication.EditMed");
				ExecutionLog.Log("Pass");
				
				//Verify Quantity field at Edit Medication screen
				ExecutionLog.Log("Verify Quantity Field at add medication screen");
				echartHelper.verifyItem("AddMedication.Quantity");
				ExecutionLog.Log("Pass");
				
				//Verify add phycisian field at Edit Medication screen
				ExecutionLog.Log("Verify add phycisian field at Add Medication screen");
				echartHelper.verifyItem("AddMedication.Physician");
				ExecutionLog.Log("Pass");	
			
		}

		catch (Error e) 
		{
			captureScreenshot("testFieldsAvailableAddEditMedication");	
			ExecutionLog.LogErrorMessage(e);			
			throw e;
		} 
		catch(Exception e) 
		{
			captureScreenshot("testFieldsAvailableAddEditMedication");
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
