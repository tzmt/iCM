package com.iCM.scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.iCM.pagehelper.EChartHelper;
import com.iCM.pagehelper.LoginHelper;
import com.iCM.util.DriverTestCase;
import com.iCM.util.ExecutionLog;

public class EChart extends DriverTestCase
{	
	@Test
	public void testEChart() throws Exception
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
			
			LoginLive();
			
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
			
			//Verify Medication.
			ExecutionLog.Log("Verify Medication button");
			echartHelper.verifyButton("EChart.Medication");
			ExecutionLog.Log("Pass");
			
			//Verify EMR.
			ExecutionLog.Log("Verify EMR button");
			echartHelper.verifyButton("EChart.EMR");
			ExecutionLog.Log("Pass");
		}

		catch (Error e) {
			captureScreenshot("testEChart");	
			ExecutionLog.LogErrorMessage(e);			
			throw e;
		} 
		catch(Exception e) {
			captureScreenshot("testEChart");
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
