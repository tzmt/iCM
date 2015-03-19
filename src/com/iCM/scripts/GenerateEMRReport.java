package com.iCM.scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.iCM.pagehelper.EChartHelper;
import com.iCM.pagehelper.LoginHelper;
import com.iCM.util.DriverTestCase;
import com.iCM.util.ExecutionLog;

public class GenerateEMRReport extends DriverTestCase
{	
	@Test
	public void testGenerateEMRReport() throws Exception
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
			
			//Click on 'Medication'.
			ExecutionLog.Log("Click on Medication button");
			echartHelper.click("EChart.Medication");
			ExecutionLog.Log("Pass");
			
			//Click on 'EMR' Tab
			ExecutionLog.Log("Click on EMR Tab");
			echartHelper.click("AddMedication.EMRTab");
			ExecutionLog.Log("Pass");
			
			//Click on Generate MAR
			ExecutionLog.Log("Click on 'Generate MAR'");
			echartHelper.click("AddMedication.GenMar");
			ExecutionLog.Log("Pass");
			
			//Select Month
			echartHelper.waitForWorkAroundTime(2000);
			ExecutionLog.Log("Select Month");
			echartHelper.selectMonth("AddMedication.MARMonth", "Feb");
			ExecutionLog.Log("Pass");
			
			//Click on Generate Now
			ExecutionLog.Log("Click on 'Generate Now'");
			echartHelper.performAction("AddMedication.PrintMAR");
			ExecutionLog.Log("Pass");
		}

		catch (Error e) 
		{
			captureScreenshot("testGenerateEMRReport");	
			ExecutionLog.LogErrorMessage(e);			
			throw e;
		} 
		catch(Exception e) 
		{
			captureScreenshot("testGenerateEMRReport");
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
