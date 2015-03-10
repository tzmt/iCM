package com.iCM.scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.iCM.pagehelper.EChartHelper;
import com.iCM.pagehelper.EMRHelper;
import com.iCM.pagehelper.LoginHelper;
import com.iCM.util.DriverTestCase;
import com.iCM.util.ExecutionLog;

public class EMROmissionUndo extends DriverTestCase
{	
	@Test
	public void testEMROmissionUndo() throws Exception
	{			
		//Initialize objects
		eMRHelper = new EMRHelper(getWebDriver());		
		loginHelper = new LoginHelper(getWebDriver());
		echartHelper = new EChartHelper(getWebDriver());

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
			
			//Click on 'EMR'
			ExecutionLog.Log("Click on 'EMR'");
			eMRHelper.click("Admin.EMRLeft");
			ExecutionLog.Log("Pass");

			//Verify EMR Title
			ExecutionLog.Log("Verify EMR title");
			loginHelper.verifyTitle("Administer Medication");
			ExecutionLog.Log("Pass");
			
			//Click on 'All Tab"
			ExecutionLog.Log("Click on 'EMR'");
			eMRHelper.click("Admin.AllTab");
			ExecutionLog.Log("Pass");
			
			
			//Click on Admin Button dropdown
			ExecutionLog.Log("Click on Admin Button dropdown");
			eMRHelper.click("Admin.AdminDropdown");
			ExecutionLog.Log("Pass");
			
			//Click on Resident Refused
			ExecutionLog.Log("Click on ReResident Refused");
			eMRHelper.clickOnFirst("Admin.AdminDropdown", "EMROmission", "Admin.AdminReading","Admin.EMRRefused");
			ExecutionLog.Log("Pass");
			
			eMRHelper.waitForWorkAroundTime(5000);

			//Enter Result
			ExecutionLog.Log("Enter Result");
			eMRHelper.type("Admin.ResultRefused","Feeling Better");
			ExecutionLog.Log("Pass");
			
			//Click on Save button
			ExecutionLog.Log("Click on Save button");
			eMRHelper.click("Admin.SaveRefused");
			ExecutionLog.Log("Pass");
			
			//Click on Ok button
			ExecutionLog.Log("Click on Save button");
			eMRHelper.click("Admin.OkRefused");
			ExecutionLog.Log("Pass");
			
			//Verify Omitted displayed
			ExecutionLog.Log("Verify Omitted displayed");
			eMRHelper.verifyItemText("Admin.Omitted","Omitted");
			ExecutionLog.Log("Pass");
			
			//Wait
			eMRHelper.waitForWorkAroundTime(3000);
			
			//Click on Undo button
			ExecutionLog.Log("Click on Undo button");
			eMRHelper.click("Admin.AdminisUndo");
			ExecutionLog.Log("Pass");
			
			//Wait
			eMRHelper.waitForWorkAroundTime(3000);
			
			//Verify User is able to undo the Administered
			ExecutionLog.Log("Verify User is able to undo the Administered");
			eMRHelper.verifyFieldNot("Admin.AdminisUndo");
			ExecutionLog.Log("Pass");
		}
		catch (Error e) 
		{
			captureScreenshot("testEMROmissionUndo");	
			ExecutionLog.LogErrorMessage(e);			
			throw e;
		} 
		catch(Exception e) 
		{
			captureScreenshot("testEMROmissionUndo");
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