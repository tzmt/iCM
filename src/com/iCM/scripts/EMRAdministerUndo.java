package com.iCM.scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.iCM.pagehelper.EChartHelper;
import com.iCM.pagehelper.EMRHelper;
import com.iCM.pagehelper.LoginHelper;
import com.iCM.util.DriverTestCase;
import com.iCM.util.ExecutionLog;

public class EMRAdministerUndo extends DriverTestCase
{	
	@Test
	public void testEMRAdministerUndo() throws Exception
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
			
			LoginLive();
			
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
			captureScreenshot("testEMRAdministerUndo");	
			ExecutionLog.LogErrorMessage(e);			
			throw e;
		} 
		catch(Exception e) 
		{
			captureScreenshot("testEMRAdministerUndo");
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
