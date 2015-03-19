package com.iCM.scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.iCM.pagehelper.DeleteHelper;
import com.iCM.pagehelper.LoginHelper;
import com.iCM.pagehelper.ResidentHelper;
import com.iCM.util.DriverTestCase;
import com.iCM.util.ExecutionLog;

public class DeleteResident extends DriverTestCase
{	
	@Test
	public void testAddResident() throws Exception
	{			
		//Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		residentHelper = new ResidentHelper(getWebDriver());
		DeleteHelper deleteHelper = new DeleteHelper(getWebDriver());
		
		boolean b = false;
		
	    String fname = "Aman"+getRandomInteger(1, 99);


		ExecutionLog.LogAddClass(this.getClass().getName() + " and Test method " +Thread.currentThread().getStackTrace()[1].getMethodName());
		try{

			//Open application
			ExecutionLog.Log("Open application url");
			openUrl(application_url);
			ExecutionLog.Log("Pass");
			
			LoginLive();

			do
			{
			
				getWebDriver().navigate().to("http://65.98.29.34:8087/Resident/list/");
			
				//Search Added Resident
				ExecutionLog.Log("Search Added resident");
				residentHelper.type("LName","AddResident.SearchResident");
				ExecutionLog.Log("Pass");
			
				residentHelper.waitForWorkAroundTime(3000);
			
				ExecutionLog.Log("Deleting resident");
			
				//Open resident profile
				ExecutionLog.Log("Open resident profile");
				deleteHelper.click("AddResident.ResidentName");
				ExecutionLog.Log("Pass");
				
				//Click on 'Discharge'
				ExecutionLog.Log("Open resident profile");
				deleteHelper.click("AddResident.Discharge");
				ExecutionLog.Log("Pass");
			
				//Click on 'Discharge' button
				ExecutionLog.Log("Open resident profile");
				deleteHelper.click("AddResident.DischargeButton");
				ExecutionLog.Log("Pass");
			
				//Search deleted Resident
				ExecutionLog.Log("Search deleted resident");
				residentHelper.type(fname,"AddResident.SearchResident");
				ExecutionLog.Log("Pass");
			
				b = residentHelper.verifyResidentNotReturn("AddResident.ResidentName");
			}while(b);
		}

		catch (Error e) {
			captureScreenshot("testAddResident");	
			ExecutionLog.LogErrorMessage(e);			
			throw e;
		} 
		catch(Exception e) {
			captureScreenshot("testAddResident");
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
