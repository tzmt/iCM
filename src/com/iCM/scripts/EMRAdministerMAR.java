package com.iCM.scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.iCM.pagehelper.EChartHelper;
import com.iCM.pagehelper.EMRHelper;
import com.iCM.pagehelper.LoginHelper;
import com.iCM.util.DriverTestCase;
import com.iCM.util.ExecutionLog;

public class EMRAdministerMAR extends DriverTestCase
{	
	@Test
	public void testEMRAdministerMAR() throws Exception
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
			
			//Click on All Meds Tab
			ExecutionLog.Log("Click on All Meds Tab");
			echartHelper.click("AddMedication.AllTab");
			ExecutionLog.Log("Pass");

			//Wait
			eMRHelper.waitForWorkAroundTime(3000);
			
			
			//Click on MAR button
			ExecutionLog.Log("Click on Click on MAR button");
			eMRHelper.click("Admin.MAR");
			ExecutionLog.Log("Pass");
			
			
			//Verify OverLayPresent
			eMRHelper.verifyMAROverlay("Admin.VerifyMAR");
			
			
			//Click on 'Generate MAR' button
			ExecutionLog.Log("Click on 'Generate MAR' button");
			eMRHelper.click("Admin.VerifyMAR");
			ExecutionLog.Log("Pass");
		
			//Wait
			eMRHelper.waitForWorkAroundTime(6000);
			
		}
		catch (Error e) 
		{
			captureScreenshot("testEMRAdministerMAR");	
			ExecutionLog.LogErrorMessage(e);			
			throw e;
		} 
		catch(Exception e) 
		{
			captureScreenshot("testEMRAdministerMAR");
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
