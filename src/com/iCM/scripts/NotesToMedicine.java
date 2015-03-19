package com.iCM.scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.iCM.pagehelper.EChartHelper;
import com.iCM.pagehelper.LoginHelper;
import com.iCM.pagehelper.ResidentHelper;
import com.iCM.util.DriverTestCase;
import com.iCM.util.ExecutionLog;

public class NotesToMedicine extends DriverTestCase
{	
	@Test
	public void testNotesToMedicine() throws Exception
	{			
		//Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		residentHelper = new ResidentHelper(getWebDriver());
		echartHelper = new EChartHelper(getWebDriver());

		String fname = "Ammu"+getRandomInteger(1, 999);


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
				
				//Open the add Resident screen
				ExecutionLog.Log("Open Add resident form via deep link");
				visit("ALM/addResident");
				ExecutionLog.Log("Pass");
				
				//Enter First Name
				ExecutionLog.Log("Enter Resident First Name");
				residentHelper.type(fname, "AddResident.FName");
				ExecutionLog.Log("Pass");
				
				//Enter Middle name
				ExecutionLog.Log("Enter Middle name");
				residentHelper.type("MName", "AddResident.MName");
				ExecutionLog.Log("Pass");
				
				//Enter last name
				ExecutionLog.Log("Enter last name");
				residentHelper.type("LName", "AddResident.LName");
				ExecutionLog.Log("Pass");
				
				//Open 'Calender
				ExecutionLog.Log("Open 'Calender'");
				residentHelper.openCalendar("AddResident.Calender");
				ExecutionLog.Log("Pass");
				
				//wait
				residentHelper.waitForWorkAroundTime(5000);
				//Select Year
				ExecutionLog.Log("Select Year");
				residentHelper.selectYear("AddResident.YearDropdown","1988");
				ExecutionLog.Log("Pass");
				
				//Wait
				residentHelper.waitForWorkAroundTime(3000);
				
				//Select date
				ExecutionLog.Log("Select date");
				residentHelper.selectDate("AddResident.Date");
				ExecutionLog.Log("Pass");
				
				//Select Gender
				ExecutionLog.Log("Select gender");
				residentHelper.selectGender("AddResident.GenderDropdown");
				ExecutionLog.Log("Pass");
				
				//Select Marital Status
				ExecutionLog.Log("Select Marital Status");
				residentHelper.selectStatus("AddResident.Status");
				ExecutionLog.Log("Pass");
				
				//Open 'Calender' for admit date
				ExecutionLog.Log("Open 'Calender' for admit date");
				residentHelper.openCalendar("AddResident.AdmitDate");
				ExecutionLog.Log("Pass");
				
				//Wait
				residentHelper.waitForWorkAroundTime(3000);
				
				//Select Year
				ExecutionLog.Log("Select Year");
				residentHelper.selectYear("AddResident.YearDropdown", "2014");
				ExecutionLog.Log("Pass");
				
				//Select month
				ExecutionLog.Log("Select Month");
				residentHelper.selectMonth("AddResident.MonthDropdown", "Oct");
				ExecutionLog.Log("Pass");
				
				//Select date
				ExecutionLog.Log("Select date");
				residentHelper.selectDate("AddResident.Date");
				ExecutionLog.Log("Pass");
				
				//Select facality
				ExecutionLog.Log("Select Facality");
				residentHelper.selectFacality("AddResident.Facality");
				ExecutionLog.Log("Pass");
				
				//Wait
				residentHelper.waitForWorkAroundTime(3000);
				
				//Select Nurse
				ExecutionLog.Log("Select Nurse");
				residentHelper.selectNurse("AddResident.Nurse");
				ExecutionLog.Log("Pass");
				
				//Enter level of care
				ExecutionLog.Log("Enter level of care");
				residentHelper.type("High", "AddResident.LevelOfCare");
				ExecutionLog.Log("Pass");
				
				//Click on 'Save'
				ExecutionLog.Log("Click on 'Save' button");
				residentHelper.click("AddResident.Save");
				ExecutionLog.Log("Pass");
				
				//Search Added Resident
				ExecutionLog.Log("Search Added resident");
				residentHelper.type(fname,"AddResident.SearchResident");
				ExecutionLog.Log("Pass");
				
				//Verify added resident
				ExecutionLog.Log("Verify added resident");
				residentHelper.verifyResident(fname, "AddResident.ResidentName");
				ExecutionLog.Log("Pass");
				
				//Open the profile of the resident
				ExecutionLog.Log("Open resident Profile");
				residentHelper.click("AddResident.ResidentName");
				ExecutionLog.Log("Pass");

				//wait
				residentHelper.waitForWorkAroundTime(4000);
				
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
				
				//Click on 'Notes' 
				ExecutionLog.Log("Click on Notes button");
				echartHelper.click("Notes.NotesButton");
				ExecutionLog.Log("Pass");
				
				//Click on 'Add Notes' 
				ExecutionLog.Log("Click on Add Notes button");
				echartHelper.click("Notes.AddNote");
				ExecutionLog.Log("Pass");
				
				//Enter Note
				ExecutionLog.Log("Enter Note");
				echartHelper.type("Note Added...","Notes.EnterNote");
				ExecutionLog.Log("Pass");
				
				//Click on 'Save' button 
				ExecutionLog.Log("Click on Button button");
				echartHelper.click("Notes.NoteSave");
				ExecutionLog.Log("Pass");
				
				//Verify Added note
				ExecutionLog.Log("Verify Added Note");
				echartHelper.verifyItemText("Notes.VerifyNote", "Note Added...");
				ExecutionLog.Log("Pass");
				
				visit("Resident/Discharge?ResidentId="+id);
				
				//Click on 'Discharge' button
				ExecutionLog.Log("Open resident profile");
				residentHelper.click("AddResident.DischargeButton");
				ExecutionLog.Log("Pass");		
			
		}

		catch (Error e) 
		{
			captureScreenshot("testNotesToMedicine");	
			ExecutionLog.LogErrorMessage(e);			
			throw e;
		} 
		catch(Exception e) 
		{
			captureScreenshot("testNotesToMedicine");
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