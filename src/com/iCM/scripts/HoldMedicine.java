package com.iCM.scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.iCM.pagehelper.EChartHelper;
import com.iCM.pagehelper.LoginHelper;
import com.iCM.pagehelper.ResidentHelper;
import com.iCM.util.DriverTestCase;
import com.iCM.util.ExecutionLog;

public class HoldMedicine extends DriverTestCase
{	
	@Test
	public void testHoldMedicine() throws Exception
	{			
		//Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		residentHelper = new ResidentHelper(getWebDriver());
		echartHelper = new EChartHelper(getWebDriver());

		String fname = "Ammu"+getRandomInteger(1, 999);


		ExecutionLog.LogAddClass(this.getClass().getName() + " and Test method " +Thread.currentThread().getStackTrace()[1].getMethodName());
		try{

			//Initialize objects
			loginHelper = new LoginHelper(getWebDriver());
			residentHelper = new ResidentHelper(getWebDriver());

				//Open application
				ExecutionLog.Log("Open application url");
				openUrl(application_url);
				ExecutionLog.Log("Pass");
				
				LoginLive();
			
				//Open the add Resident screen
				ExecutionLog.Log("Open Add resident form via deep link");
				visit("ALM/addResident");
				ExecutionLog.Log("Pass");
				
				//Enter First Name
				ExecutionLog.Log("Enter Resident First Name");
				residentHelper.type(fname, "AddResident.FName");
				ExecutionLog.Log("Pass");
				
				//Enter Middle name
				ExecutionLog.Log("Enter Middle name");
				residentHelper.type("MName", "AddResident.MName");
				ExecutionLog.Log("Pass");
				
				//Enter last name
				ExecutionLog.Log("Enter last name");
				residentHelper.type("LName", "AddResident.LName");
				ExecutionLog.Log("Pass");
				
				//Open 'Calender
				ExecutionLog.Log("Open 'Calender'");
				residentHelper.openCalendar("AddResident.Calender");
				ExecutionLog.Log("Pass");
				
				//wait
				residentHelper.waitForWorkAroundTime(5000);
				//Select Year
				ExecutionLog.Log("Select Year");
				residentHelper.selectYear("AddResident.YearDropdown","1988");
				ExecutionLog.Log("Pass");
				
				//Wait
				residentHelper.waitForWorkAroundTime(3000);
				
				//Select date
				ExecutionLog.Log("Select date");
				residentHelper.selectDate("AddResident.Date");
				ExecutionLog.Log("Pass");
				
				//Select Gender
				ExecutionLog.Log("Select gender");
				residentHelper.selectGender("AddResident.GenderDropdown");
				ExecutionLog.Log("Pass");
				
				//Select Marital Status
				ExecutionLog.Log("Select Marital Status");
				residentHelper.selectStatus("AddResident.Status");
				ExecutionLog.Log("Pass");
				
				//Open 'Calender' for admit date
				ExecutionLog.Log("Open 'Calender' for admit date");
				residentHelper.openCalendar("AddResident.AdmitDate");
				ExecutionLog.Log("Pass");
				
				//Wait
				residentHelper.waitForWorkAroundTime(3000);
				
				//Select Year
				ExecutionLog.Log("Select Year");
				residentHelper.selectYear("AddResident.YearDropdown", "2014");
				ExecutionLog.Log("Pass");
				
				//Select month
				ExecutionLog.Log("Select Month");
				residentHelper.selectMonth("AddResident.MonthDropdown", "Oct");
				ExecutionLog.Log("Pass");
				
				//Select date
				ExecutionLog.Log("Select date");
				residentHelper.selectDate("AddResident.Date");
				ExecutionLog.Log("Pass");
				
				//Select facality
				ExecutionLog.Log("Select Facality");
				residentHelper.selectFacality("AddResident.Facality");
				ExecutionLog.Log("Pass");
				
				//Wait
				residentHelper.waitForWorkAroundTime(3000);
				
				//Select Nurse
				ExecutionLog.Log("Select Nurse");
				residentHelper.selectNurse("AddResident.Nurse");
				ExecutionLog.Log("Pass");
				
				//Enter level of care
				ExecutionLog.Log("Enter level of care");
				residentHelper.type("High", "AddResident.LevelOfCare");
				ExecutionLog.Log("Pass");
				
				//Click on 'Save'
				ExecutionLog.Log("Click on 'Save' button");
				residentHelper.click("AddResident.Save");
				ExecutionLog.Log("Pass");
				
				//Search Added Resident
				ExecutionLog.Log("Search Added resident");
				residentHelper.type(fname,"AddResident.SearchResident");
				ExecutionLog.Log("Pass");
				
				//Verify added resident
				ExecutionLog.Log("Verify added resident");
				residentHelper.verifyResident(fname, "AddResident.ResidentName");
				ExecutionLog.Log("Pass");
				
				//Open the profile of the resident
				ExecutionLog.Log("Open resident Profile");
				residentHelper.click("AddResident.ResidentName");
				ExecutionLog.Log("Pass");
				
				//wait
				residentHelper.waitForWorkAroundTime(3000);
				
				//Get User ID
				String id = echartHelper.getID();
				System.out.println("Id return by method"+id);
				System.out.println("current url"+getWebDriver().getCurrentUrl());
				String finalurl="Medication/List/"+id;
				System.out.println("Print final url"+finalurl);
				
				//Click on 'Medication'.
				ExecutionLog.Log("Click on Medication button");
				echartHelper.click("EChart.Medication");
				visit(finalurl);
				ExecutionLog.Log("Pass");
				
				//Click on 'Add Medication' button
				ExecutionLog.Log("Click on Add Medication button");
				echartHelper.click("AddMedication.AddButton");
				ExecutionLog.Log("Pass");
				
				//Enter medicine name
				ExecutionLog.Log("Enter Medicine Name");
				echartHelper.type("D-Cold Total","AddMedication.MedicineName");
				ExecutionLog.Log("Pass");
				
				//Ender Dosage
				ExecutionLog.Log("Enter Dosage");
				echartHelper.type("Daily","AddMedication.Dosage");
				ExecutionLog.Log("Pass");
				
				//Ender Dosage
				ExecutionLog.Log("Enter instruction");
				echartHelper.type("Avoid cold water","AddMedication.Instuction");
				ExecutionLog.Log("Pass");
				
				//Open 'Calender
				ExecutionLog.Log("Open 'Calender'");
				echartHelper.openCalendar("AddMedication.StartDate");
				ExecutionLog.Log("Pass");
				
				//Wait
				echartHelper.waitForWorkAroundTime(3000);
				
				//Select date
				ExecutionLog.Log("Select date");
				residentHelper.selectDate("AddResident.Date");
				ExecutionLog.Log("Pass");
				
				//Select time 
				ExecutionLog.Log("Select time");
				echartHelper.select("AddMedication.Time","8:30");
				ExecutionLog.Log("Pass");
				
				//Select time 
				ExecutionLog.Log("Select AM/PM");
				echartHelper.select("AddMedication.TimeTyep","AM");
				ExecutionLog.Log("Pass");
				
				//Click on 'Add schedule'
				ExecutionLog.Log("Click on Add Schedule button");
				echartHelper.click("AddMedication.AddSchedule");
				ExecutionLog.Log("Pass");
				
				//Verify Added schedule
				ExecutionLog.Log("Verify Added Schedule");
				echartHelper.verifyItemText("AddMedication.TimeTable_1", "8:30 AM");
				ExecutionLog.Log("Pass");
				
				//Click on 'Save' button
				ExecutionLog.Log("Click on Save button");
				echartHelper.click("AddMedication.SaveMedi");
				ExecutionLog.Log("Pass");

				loginHelper.verifyTitle("View Medication");
				//Wait
				echartHelper.waitForWorkAroundTime(10000);
				
				//Open Medication page via deep link
				ExecutionLog.Log("Open Medication page");
				visit("Medication/List/"+id);
				ExecutionLog.Log("Pass");
				
				//Click on 'Hold' button
				ExecutionLog.Log("Click on View button");
				echartHelper.click("HoldMedicine.Hold");
				ExecutionLog.Log("Pass");
				
				//Open Calender
				ExecutionLog.Log("Open Calender");
				echartHelper.click("HoldMedicine.EndDate");
				ExecutionLog.Log("Pass");
			
				//Wait 
				echartHelper.waitForWorkAroundTime(5000);
				
				//Select Date
				ExecutionLog.Log("Select Date'");
				echartHelper.selectEndDate("AddMedication.Date");
				ExecutionLog.Log("Pass");
				
				//Enter Comment 
				ExecutionLog.Log("Enter Comment");
				echartHelper.type("Feeling Better", "HoldMedicine.HoldComment");
				ExecutionLog.Log("Pass");
				
				//Click on Ok button
				ExecutionLog.Log("Click on Ok button");
				echartHelper.click("HoldMedicine.HoldOk");
				ExecutionLog.Log("Pass");
				
				//Verify Medicine is on Hold
				ExecutionLog.Log("Verify Medicine is on Hold");
				echartHelper.verifyItem("HoldMedicine.OnHold");
				ExecutionLog.Log("Pass");
				
				echartHelper.waitForWorkAroundTime(4000);
				
				//Click on On Hold Dropdown
				ExecutionLog.Log("Click on On Hold Dropdown");
				echartHelper.click("HoldMedicine.OnHold");
				ExecutionLog.Log("Pass");
				
				//Click on restart medicine
				ExecutionLog.Log("Click on restart medicine");
				echartHelper.click("HoldMedicine.RestartMedicine");
				ExecutionLog.Log("Pass");
				
				//Click on Ok button
				ExecutionLog.Log("Click on Ok button");
				echartHelper.click("HoldMedicine.HoldOk");
				ExecutionLog.Log("Pass");
				
				echartHelper.waitForWorkAroundTime(3000);
				
				//Verify Medicine restarted
				ExecutionLog.Log("Verify Medicine restrated");
				echartHelper.verifyItemNot("HoldMedicine.OnHold");
				ExecutionLog.Log("Pass");
				
				visit("Resident/Discharge?ResidentId="+id);
				
				//Click on 'Discharge' button
				ExecutionLog.Log("Open resident profile");
				residentHelper.click("AddResident.DischargeButton");
				ExecutionLog.Log("Pass");		
			
		}

		catch (Error e) 
		{
			captureScreenshot("testHoldMedicine");	
			ExecutionLog.LogErrorMessage(e);			
			throw e;
		} 
		catch(Exception e) 
		{
			captureScreenshot("testHoldMedicine");
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