package com.iCM.scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.iCM.pagehelper.LoginHelper;
import com.iCM.pagehelper.TaskHelper;
import com.iCM.util.DriverTestCase;
import com.iCM.util.ExecutionLog;

public class AddTask extends DriverTestCase
{	
	@Test
	public void testAddTask() throws Exception
	{			
		//Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		taskHelper = new TaskHelper(getWebDriver());


		ExecutionLog.LogAddClass(this.getClass().getName() + " and Test method " +Thread.currentThread().getStackTrace()[1].getMethodName());
		try{

			//Open application
			ExecutionLog.Log("Open application url");
			getWebDriver().navigate().to(QA_application_url);
			ExecutionLog.Log("Pass");
			
			LoginLive();
			
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
			taskHelper.click("StaffField");
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
			
			//Delete the task
			ExecutionLog.Log("Delete the task");
			taskHelper.click("TaskDelete");
			ExecutionLog.Log("Pass");
		}

		catch (Error e) 
		{
			captureScreenshot("testAddTask");	
			ExecutionLog.LogErrorMessage(e);			
			throw e;
		} 
		catch(Exception e) 
		{
			captureScreenshot("testAddTask");
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
