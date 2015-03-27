package com.iCM.scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.iCM.pagehelper.LoginHelper;
import com.iCM.pagehelper.StaffHelper;
import com.iCM.util.DriverTestCase;
import com.iCM.util.ExecutionLog;

public class StaffEditProfilePassword extends DriverTestCase
{	
	@Test
	public void testStaffEditProfilePassword() throws Exception
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
			
			//Click on Basic information tab
			ExecutionLog.Log("Click on Basic information tab");
			staffHelper.click("BasicInfo");
			ExecutionLog.Log("Pass");
			
			//Verify Edit Profile button not available 
			ExecutionLog.Log("Verify Edit Profile button not available ");
			staffHelper.verifyTabNot("Edit Profile");
			ExecutionLog.Log("Pass");
			
			//Verify Change Password button is available
			ExecutionLog.Log("Verify Change Password button is available");
			staffHelper.verifyTab("ChangePassword", "Change Password");
			ExecutionLog.Log("Pass");
			
			//Click on Change Password button
			ExecutionLog.Log("Click on Change Password button");
			staffHelper.click("ChangePassword");
			ExecutionLog.Log("Pass");
			
			//Verify an Overlay displayed
			ExecutionLog.Log("Verify an Overlay displayed");
			staffHelper.verifyItemText("Overlay","Change Password");
			ExecutionLog.Log("Pass");
			
			//Enter Password
			ExecutionLog.Log("Enter (1qaz!QAZ) Password ");
			staffHelper.type("Password","1qaz!QAZ");
			
			//Enter Confirm Password
			ExecutionLog.Log("Enter Confirm (1qaz!QAZ) Password ");
			staffHelper.type("ConfirmPassword","1qaz!QAZ");
			
			//Click on Save Button
			ExecutionLog.Log("Click on Save Button");
			staffHelper.click("Save");
			
			//User is able to change the password
			staffHelper.verifyItemText("VerifyChange", "Password changed successfully.");
			
			//Reset to default password
			staffHelper.click("BasicInfo");
			staffHelper.click("ChangePassword");
			staffHelper.waitForWorkAroundTime(2000);
			staffHelper.type("Password","7Stars%");
			staffHelper.type("ConfirmPassword","7Stars%");
			staffHelper.click("Save");
			
		}

		catch (Error e) 
		{
			captureScreenshot("testStaffEditProfilePassword");	
			ExecutionLog.LogErrorMessage(e);			
			throw e;
		} 
		catch(Exception e) 
		{
			captureScreenshot("testStaffEditProfilePassword");
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
