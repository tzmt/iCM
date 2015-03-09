package com.iCM.scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.iCM.pagehelper.EChartHelper;
import com.iCM.pagehelper.EMRHelper;
import com.iCM.pagehelper.LoginHelper;
import com.iCM.util.DriverTestCase;
import com.iCM.util.ExecutionLog;

public class EMRAdministerMonthlyViewGreen extends DriverTestCase
{	
	@Test
	public void testEMRAdministerMonthlyViewGreen() throws Exception
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
			
			//Click on Administer button
			ExecutionLog.Log("Click on Administer button");
			eMRHelper.click("Admin.AdminButton");
			ExecutionLog.Log("Pass");

			//Wait
			eMRHelper.waitForWorkAroundTime(3000);
			
			//Verify OverLayPresent
			eMRHelper.verifyOverlay();
			
			//Enter Blood suger
			ExecutionLog.Log("Enter Blood Suger");
			eMRHelper.type("Admin.BloodSuger","100");
			ExecutionLog.Log("Pass");
			
			//Click on 'Administer now' button
			ExecutionLog.Log("Click on 'Administer now' button");
			eMRHelper.click("AdminNow");
			ExecutionLog.Log("Pass");
			
			//Click on ok button
			ExecutionLog.Log("Click on 'Ok' button");
			eMRHelper.click("AdminOk");
			ExecutionLog.Log("Pass");
			
			eMRHelper.waitForWorkAroundTime(3000);
			
			//Verify User is able to Administered
			ExecutionLog.Log("Verify User is able to Administered");
			eMRHelper.verifyFieldText("Admin.AdminisText","Administered");
			ExecutionLog.Log("Pass");
			
			
			//Verify Colour
			ExecutionLog.Log("Verify user initials in normal color");
			eMRHelper.verifyColor("Admin.AdminButton","Green");
			ExecutionLog.Log("Pass");
			
			//Wait
			eMRHelper.waitForWorkAroundTime(3000);
			
			//Click on Expend button button
			ExecutionLog.Log("Click on Undo button");
			eMRHelper.click("Admin.Expend");
			ExecutionLog.Log("Pass");
			
			//Wait
			eMRHelper.waitForWorkAroundTime(3000);
			
			//User is able to see the monthly view
			ExecutionLog.Log("User is able to see the monthly view");
			eMRHelper.verifyItem("Admin.VerifyAK");
			ExecutionLog.Log("Pass");
			
			//Verify Record Updated
			ExecutionLog.Log("User is able to see the monthly view");
			eMRHelper.verifyRecordUpdate("Admin.VerifyAK");
			ExecutionLog.Log("Pass");
			
			//Click on Undo button
			ExecutionLog.Log("Click on Undo button");
			eMRHelper.click("Admin.AdminisUndo");
			ExecutionLog.Log("Pass");
			
			
		}
		catch (Error e) 
		{
			captureScreenshot("testEMRAdministerMonthlyViewGreen");	
			ExecutionLog.LogErrorMessage(e);			
			throw e;
		} 
		catch(Exception e) 
		{
			captureScreenshot("testEMRAdministerMonthlyViewGreen");
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
