package com.iCM.scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.iCM.pagehelper.LoginHelper;
import com.iCM.pagehelper.ResidentHelper;
import com.iCM.util.DriverTestCase;
import com.iCM.util.ExecutionLog;

public class AddResident extends DriverTestCase
{	
	@Test
	public void testAddResident() throws Exception
	{			
		//Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		residentHelper = new ResidentHelper(getWebDriver());
		
	    String fname = "Aman"+getRandomInteger(1, 99);


		ExecutionLog.LogAddClass(this.getClass().getName() + " and Test method " +Thread.currentThread().getStackTrace()[1].getMethodName());
		try{

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
			
			//Select Year
			ExecutionLog.Log("Select Year");
			residentHelper.selectYear("AddResident.YearDropdown","1988");
			ExecutionLog.Log("Pass");
			
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
			
			ExecutionLog.Log("Deleting resident");
			
			//Open resident profile
			ExecutionLog.Log("Open resident profile");
			residentHelper.click("AddResident.ResidentName");
			ExecutionLog.Log("Pass");
			
			//Click on 'Discharge'
			ExecutionLog.Log("Open resident profile");
			residentHelper.click("AddResident.Discharge");
			ExecutionLog.Log("Pass");
			
			//Select 'Other' radio button
			ExecutionLog.Log("Open resident profile");
			residentHelper.click("AddResident.SelectOther");
			ExecutionLog.Log("Pass");
			
			//Enter note
			ExecutionLog.Log("Open resident profile");
			residentHelper.type("Feeling Better", "AddResident.Note");
			ExecutionLog.Log("Pass");
			
			//Click on 'Discharge' button
			ExecutionLog.Log("Open resident profile");
			residentHelper.click("AddResident.DischargeButton");
			ExecutionLog.Log("Pass");
			
			//Search deleted Resident
			ExecutionLog.Log("Search deleted resident");
			residentHelper.type(fname,"AddResident.SearchResident");
			ExecutionLog.Log("Pass");
			
			//Verify deleted resident not available
			ExecutionLog.Log("Verify added resident");
			residentHelper.verifyResidentNot("AddResident.ResidentName");
			ExecutionLog.Log("Pass");
			
		}

		catch (Error e) {
			captureScreenshot("testAddResident");	
			ExecutionLog.LogErrorMessage(e);			
			throw e;
		} 
		catch(Exception e) {
			captureScreenshot("testAddResident");
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
