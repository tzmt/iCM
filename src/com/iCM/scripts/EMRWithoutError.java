package com.iCM.scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.iCM.pagehelper.EMRHelper;
import com.iCM.pagehelper.LoginHelper;
import com.iCM.util.DriverTestCase;
import com.iCM.util.ExecutionLog;

public class EMRWithoutError extends DriverTestCase
{	
	@Test
	public void testEMRWithoutError() throws Exception
	{			
		//Initialize objects
		eMRHelper = new EMRHelper(getWebDriver());		
		loginHelper = new LoginHelper(getWebDriver());

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
			
			//Verify No 500 error page displayed
			ExecutionLog.Log("Verify No 500 error page displayed");
			eMRHelper.verifyNoError("Admin.AllTab","Admin.EMRDate","Admin.CurrentDate");
			ExecutionLog.Log("Pass");
		}
		catch (Error e) 
		{
			captureScreenshot("testEMRWithoutError");	
			ExecutionLog.LogErrorMessage(e);			
			throw e;
		} 
		catch(Exception e) 
		{
			captureScreenshot("testEMRWithoutError");
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
