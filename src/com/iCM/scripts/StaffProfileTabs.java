package com.iCM.scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.iCM.pagehelper.LoginHelper;
import com.iCM.pagehelper.StaffHelper;
import com.iCM.util.DriverTestCase;
import com.iCM.util.ExecutionLog;

public class StaffProfileTabs extends DriverTestCase
{	
	@Test
	public void testStaffProfileTabs() throws Exception
	{			
		//Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		staffHelper = new StaffHelper(getWebDriver());


		ExecutionLog.LogAddClass(this.getClass().getName() + " and Test method " +Thread.currentThread().getStackTrace()[1].getMethodName());
		try{

			//Open application
			ExecutionLog.Log("Open application url");
			getWebDriver().navigate().to(QA_application_url);
			ExecutionLog.Log("Pass");
			
			LoginLive();
			
			loginHelper.verifyTitle("iCM - Punch In");
			
			//Click on 'Username' dropdown
			ExecutionLog.Log("Click on 'Username' dropdown");
			staffHelper.click("UserDropdown");
			ExecutionLog.Log("Pass");
			
			//Click on 'Profile' link
			ExecutionLog.Log("Click on 'Profile' link");
			staffHelper.click("ProfileLink");
			ExecutionLog.Log("Pass");
			
			loginHelper.waitForWorkAroundTime(3000);
			
			//Verify title
			ExecutionLog.Log("Verify title");
			loginHelper.verifyTitle("iCM - View Staff");
			ExecutionLog.Log("Pass");
			
			//Verify Basic information tab available
			ExecutionLog.Log("Verify Basic information tab available");
			staffHelper.verifyTab("BasicInfo", "Basic Information");
			ExecutionLog.Log("Pass");
			
			//Verify Permission tab available
			ExecutionLog.Log("Verify Permission tab available");
			staffHelper.verifyTab("Permissions", "Permissions");
			ExecutionLog.Log("Pass");
			
			//Verify Trainings tab available
			ExecutionLog.Log("Verify Trainings tab available");
			staffHelper.verifyTab("Trainings", "Trainings");
			ExecutionLog.Log("Pass");
			
			//Verify Emergency tab available
			ExecutionLog.Log("Verify Emergency tab available");
			staffHelper.verifyTab("Contacts", "Emergency Contacts");
			ExecutionLog.Log("Pass");
			
			//Verify eSignature tab available
			ExecutionLog.Log("Verify eSignature tab available");
			staffHelper.verifyTab("Esignature", "eSignature");
			ExecutionLog.Log("Pass");
			
			//Verify Document tab not available
			ExecutionLog.Log("Verify Document tab not available");
			staffHelper.verifyTabNot("Documents");
			ExecutionLog.Log("Pass");
			
		}

		catch (Error e) 
		{
			captureScreenshot("testStaffProfileTabs");	
			ExecutionLog.LogErrorMessage(e);			
			throw e;
		} 
		catch(Exception e) 
		{
			captureScreenshot("testStaffProfileTabs");
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
