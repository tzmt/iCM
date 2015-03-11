package com.iCM.scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.iCM.pagehelper.EChartHelper;
import com.iCM.pagehelper.LoginHelper;
import com.iCM.util.DriverTestCase;
import com.iCM.util.ExecutionLog;

public class EChartAddMedication extends DriverTestCase
{	
	@Test
	public void testEChartAddMedication() throws Exception
	{			
		//Initialize objects
		echartHelper = new EChartHelper(getWebDriver());	
		loginHelper = new LoginHelper(getWebDriver());

		ExecutionLog.LogAddClass(this.getClass().getName() + " and Test method " +Thread.currentThread().getStackTrace()[1].getMethodName());
		try{

			//Open application
			ExecutionLog.Log("Open application url");
			getWebDriver().navigate().to(application_url);
			ExecutionLog.Log("Pass");
			
			//Verify page title
			ExecutionLog.Log("Verify Page title");
			loginHelper.verifyTitle("iCM - Login");
			ExecutionLog.Log("Pass");
			
			//Enter User name
			ExecutionLog.Log("Enter User name at login page.");
			loginHelper.enterUserID(username);
			ExecutionLog.Log("Pass");
			
			//Enter password
			ExecutionLog.Log("Enter password at login page.");
			loginHelper.enterPassword(pswd);
			ExecutionLog.Log("Pass");
			
			//Click on Sign In
			ExecutionLog.Log("Click on Sign In button");
			loginHelper.clickLogin();
			ExecutionLog.Log("Pass");
			
			//Verify User redirect at home page
			ExecutionLog.Log("Verify home page title");
			loginHelper.verifyTitle("iCM - Home");
			ExecutionLog.Log("Pass");
			
			//Open the Resident list screen
			ExecutionLog.Log("Open resident list via deep link");
			visit("Resident/list/");
			ExecutionLog.Log("Pass");
			
			//Open the profile of the resident
			ExecutionLog.Log("Open resident Profile");
			echartHelper.click("EChart.Resident");
			ExecutionLog.Log("Pass");
			
			//Click on 'Medication'.
			ExecutionLog.Log("Click on Medication button");
			echartHelper.click("EChart.Medication");
			ExecutionLog.Log("Pass");
			
			//Click on 'Add Medication' button
			ExecutionLog.Log("Click on Add Medication button");
			echartHelper.click("AddMedication.AddButton");
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
			
			//Select date
			ExecutionLog.Log("Select date");
			echartHelper.selectDate("AddMedication.Date");
			ExecutionLog.Log("Pass");
			
			//Click on 'Cancel' button
			ExecutionLog.Log("Click on Cancel button");
			echartHelper.click("AddMedication.CancelMedi");
			ExecutionLog.Log("Pass");
			
			//Verify 'Medication' title
			ExecutionLog.Log("Verify 'Medication' Page title");
			echartHelper.verifyTitle("Medications");
			ExecutionLog.Log("Pass");
			
			//Click on 'Add Medication' button
			ExecutionLog.Log("Click on Add Medication button");
			echartHelper.click("AddMedication.AddButton");
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
			
			//Select date
			ExecutionLog.Log("Select date");
			echartHelper.selectDate("AddMedication.Date");
			ExecutionLog.Log("Pass");
			
			//Click on 'Add schedule'
			ExecutionLog.Log("Click on Add Schedule button");
			echartHelper.click("AddMedication.AddSchedule");
			ExecutionLog.Log("Pass");
			
			//Click on 'Save' button
			ExecutionLog.Log("Click on Save button");
			echartHelper.click("AddMedication.SaveMedi");
			ExecutionLog.Log("Pass");
			
			//Verify 'View Medication' title
			ExecutionLog.Log("Verify 'View Medication' Page title");
			echartHelper.verifyTitle("View Medication");
			ExecutionLog.Log("Pass");
			
			//Verify medicine name
			ExecutionLog.Log("Verify added medicine");
			echartHelper.verifyMedicine("AddMedication.MediName");
			ExecutionLog.Log("Pass");
		}

		catch (Error e) {
			captureScreenshot("testEChartAddMedication");	
			ExecutionLog.LogErrorMessage(e);			
			throw e;
		} 
		catch(Exception e) {
			captureScreenshot("testEChartAddMedication");
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
