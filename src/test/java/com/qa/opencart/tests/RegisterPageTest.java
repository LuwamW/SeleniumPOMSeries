package com.qa.opencart.tests;

import java.util.UUID;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ExcelUtil;

public class RegisterPageTest extends BaseTest {
	
	@BeforeClass
	public void regSetup() {
		registerPage = loginPage.navigateToRegisterPage();
	}
	
	public String getRandomEmailID() {
		return "testautomation" + System.currentTimeMillis()+ "@gmail.com";
		//return "testautomation"+ UUID.randomUUID()+"@gmail.com";// another option
	}
	
//	@DataProvider(name = "regData")
//	public Object[][] getUserRegTestData() {
//		return new Object[][] {
//			
//			{"abhi", "anand", "9876543212", "abhi@123", "yes"},
//			{"amber", "Tom", "9876543212", "amber@123", "no"},
//			{"robinson", "Tom", "9876543212", "robinson@123", "yes"}
//		};
//	}
	
	@DataProvider(name = "regExcelData")
	public Object[][] getRegExcelTestData() {
		Object regData[][] = ExcelUtil.getTestData(AppConstants.REGISTER_SHEET_NAME);
		return regData;
	}
	
	@Test(dataProvider = "regExcelData")
	public void userRegisterTest(String firstName, String lastName, String telephone, String password, String subscribe) {
		String actRegSuccMessg = 
				registerPage.registerUser(firstName, lastName , getRandomEmailID(), telephone, password, subscribe);
		Assert.assertEquals(actRegSuccMessg, AppConstants.USER_REGS_SUCCESS_MESSG);
		
	}
	
	
}
