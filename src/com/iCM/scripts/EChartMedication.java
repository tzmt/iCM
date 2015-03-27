package com.iCM.scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.iCM.pagehelper.EChartHelper;
import com.iCM.pagehelper.LoginHelper;
import com.iCM.util.DriverTestCase;
import com.iCM.util.ExecutionLog;

public class EChartMedication extends DriverTestCase
{	
	@Test
	public void testEChartMedication() throws Exception
	{			
		//Initialize objects
		echartHelper = new EChartHelper(getWebDriver());	
		loginHelper = new LoginHelper(getWebDriver());

		ExecutionLog.LogAddClass(this.getClass().getName() + " and Test method " +Thread.currentThread().getStackTrace()[1].getMethodName());
		try{

			//Open application
			ExecutionLog.Log("Open application url");
			getWebDriver().navigate().to(QA_application_url);
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
			
			//Click on 'Medication.
			ExecutionLog.Log("Click on Medication button");
			echartHelper.click("EChart.Medication");
			ExecutionLog.Log("Pass");
			
			//Verify 'Medication' title
			ExecutionLog.Log("Verify 'Medication' Page title");
			echartHelper.verifyTitle("Medications");
			ExecutionLog.Log("Pass");
		}

		catch (Error e) {
			captureScreenshot("testEChartMedication");	
			ExecutionLog.LogErrorMessage(e);			
			throw e;
		} 
		catch(Exception e) {
			captureScreenshot("testEChartMedication");
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
