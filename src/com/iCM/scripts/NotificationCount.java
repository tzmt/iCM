package com.iCM.scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.iCM.pagehelper.LoginHelper;
import com.iCM.pagehelper.NotificationHelper;
import com.iCM.util.DriverTestCase;
import com.iCM.util.ExecutionLog;

public class NotificationCount extends DriverTestCase
{	
	@Test
	public void testNotificationCount() throws Exception
	{			
		//Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		notificationHelper = new NotificationHelper(getWebDriver());


		ExecutionLog.LogAddClass(this.getClass().getName() + " and Test method " +Thread.currentThread().getStackTrace()[1].getMethodName());
		try{

			//Open application
			ExecutionLog.Log("Open application url");
			getWebDriver().navigate().to(QA_application_url);
			ExecutionLog.Log("Pass");
			
			LoginLive();
			
			//Click on 'Notification'
			ExecutionLog.Log("Click on 'Notification'");
			notificationHelper.click("NotificationIcon");
			ExecutionLog.Log("Pass");
			
			//Click on 'View All Notification' link
			ExecutionLog.Log("Click on 'View All Notification' link");
			notificationHelper.click("ViewAll");
			ExecutionLog.Log("Pass");
			
			//Verify title
			ExecutionLog.Log("Verify title");
			loginHelper.verifyTitle("Alerts");
			ExecutionLog.Log("Pass");
			
			//Verify Notification available
			ExecutionLog.Log("Verify Notification available");
			notificationHelper.verifyNotification("AlertList");
			ExecutionLog.Log("Pass");
			
			//Verify Checkbox available for every notification
			ExecutionLog.Log("Verify Checkbox available for every notification");
			notificationHelper.verifyCheckBox("AlertCheckBox");
			ExecutionLog.Log("Pass");
			
		}

		catch (Error e) 
		{
			captureScreenshot("testNotificationCount");	
			ExecutionLog.LogErrorMessage(e);			
			throw e;
		} 
		catch(Exception e) 
		{
			captureScreenshot("testNotificationCount");
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
