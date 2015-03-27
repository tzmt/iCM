package com.iCM.scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.iCM.pagehelper.LoginHelper;
import com.iCM.pagehelper.StaffHelper;
import com.iCM.util.DriverTestCase;
import com.iCM.util.ExecutionLog;

public class StaffProfile extends DriverTestCase
{	
	@Test
	public void testStaffProfile() throws Exception
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
			
		}

		catch (Error e) 
		{
			captureScreenshot("testStaffProfile");	
			ExecutionLog.LogErrorMessage(e);			
			throw e;
		} 
		catch(Exception e) 
		{
			captureScreenshot("testStaffProfile");
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
