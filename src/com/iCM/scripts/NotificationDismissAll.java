package com.iCM.scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.iCM.pagehelper.LoginHelper;
import com.iCM.pagehelper.NotificationHelper;
import com.iCM.util.DriverTestCase;
import com.iCM.util.ExecutionLog;

public class NotificationDismissAll extends DriverTestCase
{	
	@Test
	public void testNotificationDismissAll() throws Exception
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
			
			//Click on Dismiss All button
			ExecutionLog.Log("Click on Notification");
			notificationHelper.click("DismissAll");
			ExecutionLog.Log("Pass");
			
			//Click on 'Ok' button
			ExecutionLog.Log("Click on 'Ok' button");
			notificationHelper.click("OkB");
			ExecutionLog.Log("Pass");
			
			//Verify no notification avalable
			ExecutionLog.Log("Verify User is able to dismiss the notification");
			notificationHelper.ItemNotAvailable("Notification1");
			ExecutionLog.Log("Pass");
		}

		catch (Error e) 
		{
			captureScreenshot("testNotificationDismissAll");	
			ExecutionLog.LogErrorMessage(e);			
			throw e;
		} 
		catch(Exception e) 
		{
			captureScreenshot("testNotificationDismissAll");
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
