package com.iCM.scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.iCM.pagehelper.EChartHelper;
import com.iCM.pagehelper.LoginHelper;
import com.iCM.util.DriverTestCase;
import com.iCM.util.ExecutionLog;

public class DCMedication extends DriverTestCase
{	
	@Test
	public void testDCMedication() throws Exception
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
			
			//Verify 'EChart' title
			ExecutionLog.Log("Verify 'EChart' Page title");
			echartHelper.verifyTitle("eChart");
			ExecutionLog.Log("Pass");
			
			//Click on 'Medication.
			ExecutionLog.Log("Click on Medication button");
			echartHelper.click("EChart.Medication");
			ExecutionLog.Log("Pass");
			
			//Verify 'Medication' title
			ExecutionLog.Log("Verify 'Medication' Page title");
			echartHelper.verifyTitle("Medications");
			ExecutionLog.Log("Pass");
			
			//Get Medicine Name
			ExecutionLog.Log("Get Medicine Name");
			String MediName = echartHelper.getName("AddMedication.MedicalName");
			ExecutionLog.Log("Pass");
			
			//Click on 'DC' button
			ExecutionLog.Log("Click on DC button");
			echartHelper.click("AddMedication.DC");
			ExecutionLog.Log("Pass");
			
			//Enter Comment
			ExecutionLog.Log("Enter Comment");
			echartHelper.type("Discontinued", "AddMedication.Comment");
			ExecutionLog.Log("Pass");
			
			//Click on 'Ok' button
			ExecutionLog.Log("Click on 'Ok' Button");
			echartHelper.click("AddMedication.OkButton");
			ExecutionLog.Log("Pass");
			
			//Click on Discontinued button
			ExecutionLog.Log("Click on 'Discontinued' Button");
			echartHelper.click("AddMedication.DisTab");
			ExecutionLog.Log("Pass");
			
			//Verify Deleted medicin
			ExecutionLog.Log("Verify deleted medicin");
			echartHelper.deleteMedi("AddMedication.MedicalName",MediName);
			ExecutionLog.Log("Pass");
		}

		catch (Error e) {
			captureScreenshot("testDCMedication");	
			ExecutionLog.LogErrorMessage(e);			
			throw e;
		} 
		catch(Exception e) {
			captureScreenshot("testDCMedication");
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
