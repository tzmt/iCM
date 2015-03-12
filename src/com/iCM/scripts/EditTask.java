package com.iCM.scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.iCM.pagehelper.LoginHelper;
import com.iCM.pagehelper.TaskHelper;
import com.iCM.util.DriverTestCase;
import com.iCM.util.ExecutionLog;

public class EditTask extends DriverTestCase
{	
	@Test
	public void testEditTask() throws Exception
	{			
		//Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		taskHelper = new TaskHelper(getWebDriver());


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
			
			//Click on 'Location' tab
			ExecutionLog.Log("Click on 'Location' tab");
			taskHelper.click("LocationTab");
			ExecutionLog.Log("Pass");
			
			//Verify User redirect at location page
			ExecutionLog.Log("Verify location page title");
			loginHelper.verifyTitle("iCM - Locations");
			ExecutionLog.Log("Pass");
			
			//Click on 'Staff Task' tab
			ExecutionLog.Log("Click on 'Staff Task' tab");
			taskHelper.click("StaffTaskTab");
			ExecutionLog.Log("Pass");
			
			//Verify User redirect at Staff task page
			ExecutionLog.Log("Verify Staff task page title");
			loginHelper.verifyTitle("iCM - Task List");
			ExecutionLog.Log("Pass");
			
			//Click on Add Task Button
			ExecutionLog.Log("Click on Add Task Button");
			taskHelper.click("AddTaskButton");
			ExecutionLog.Log("Pass");
			
			//Verify User redirect at Add task page
			ExecutionLog.Log("Verify Add task page title");
			loginHelper.verifyTitle("iCM - Add Task");
			ExecutionLog.Log("Pass");
			
			//Enter Title
			ExecutionLog.Log("Enter Title");
			taskHelper.type("TaskTitle", "Demo Title");
			ExecutionLog.Log("Pass");
			
			//Enter Description
			ExecutionLog.Log("Enter Description");
			taskHelper.type("TaskDescription", "Demo Description");
			ExecutionLog.Log("Pass");
			
			//Search Staff
			ExecutionLog.Log("Search Staff");
			taskHelper.type("StaffField", "Jo");
			ExecutionLog.Log("Pass");
			
			//Select Staff
			ExecutionLog.Log("Select Staff");
			taskHelper.click("SelectStaff");
			ExecutionLog.Log("Pass");
			
			//Open Due Date Calender
			ExecutionLog.Log("Open Due Date Calender");
			taskHelper.openCalendar("DueDateCalender");
			ExecutionLog.Log("Pass");
			
			//Select Year
			ExecutionLog.Log("Select Year");
			taskHelper.selectYear("DueYear", "2020");
			ExecutionLog.Log("Pass");
			
			//Select Date
			ExecutionLog.Log("Select Date");
			taskHelper.selectDate("DueDate");
			ExecutionLog.Log("Pass");
			
			//Open Status Dropdown
			ExecutionLog.Log("Open Status Dropdown");
			taskHelper.click("StatusDropdown");
			ExecutionLog.Log("Pass");
			
			//Select Status
			ExecutionLog.Log("Select Status");
			taskHelper.click("StatusDrpNew");
			ExecutionLog.Log("Pass");
			
			//Click on 'Save' button
			ExecutionLog.Log("Click on 'Save' button");
			taskHelper.click("TaskSave");
			ExecutionLog.Log("Pass");
			
			//Search Created Task
			ExecutionLog.Log("Search Created Task");
			taskHelper.type("TaskSearch", "Demo Title");
			ExecutionLog.Log("Pass");
			
			//Verify Created Task
			ExecutionLog.Log("Verify Created Task");
			taskHelper.verifyFieldText("VerifyTask", "Demo Title");
			ExecutionLog.Log("Pass");
			
			//Click on View Button
			ExecutionLog.Log("Click on View Button");
			taskHelper.click("TaskView");
			ExecutionLog.Log("Pass");
			
			//Verify Task
			ExecutionLog.Log("Verify Task");
			taskHelper.verifyFieldText("TaskVerify", "Demo Title");
			ExecutionLog.Log("Pass");
			
			//Click on Edit Button
			ExecutionLog.Log("Click on Edit Button");
			taskHelper.click("TaskEdit");
			ExecutionLog.Log("Pass");
			
			//Verify User redirect at Add task page
			ExecutionLog.Log("Verify Add task page title");
			loginHelper.verifyTitle("iCM - Edit Staff Task");
			ExecutionLog.Log("Pass");
			
			//Enter  Updated Title
			ExecutionLog.Log("Enter UpdatedTitle");
			taskHelper.type("TaskTitle", "Demo Title Updated");
			ExecutionLog.Log("Pass");
			
			//Click on 'Save' button
			ExecutionLog.Log("Click on 'Save' button");
			taskHelper.click("TaskSave");
			ExecutionLog.Log("Pass");
			
			//Search Updated Task
			ExecutionLog.Log("Search Updated Task");
			taskHelper.type("TaskSearch", "Demo Title Updated");
			ExecutionLog.Log("Pass");
			
			//Verify Updated Task
			ExecutionLog.Log("Verify Updated Task");
			taskHelper.verifyFieldText("VerifyTask", "Demo Title Updated");
			ExecutionLog.Log("Pass");
			
			//Delete the task
			ExecutionLog.Log("Delete the task");
			taskHelper.click("TaskDelete");
			ExecutionLog.Log("Pass");
		}

		catch (Error e) 
		{
			captureScreenshot("testEditTask");	
			ExecutionLog.LogErrorMessage(e);			
			throw e;
		} 
		catch(Exception e) 
		{
			captureScreenshot("testEditTask");
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
