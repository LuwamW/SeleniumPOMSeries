package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ExcelUtil;

public class LoginPageNegativeTest extends BaseTest{

	
//	@DataProvider
//	public Object[][] incorrectLoginTestData() {
//		
//		return new Object[][] {
//			{"auto1234@gmail.com", "123456"},
//			{"test@@gmail.com", "123456"},
//			{"auto", "test"},
//			{"@#$$ ", " @#$$%"}
//		};
//	}
	
	@DataProvider(name = "incorrectLoginExcelData")
	public Object[][] getRegExcelTestData() {
		Object regData[][] = ExcelUtil.getTestData(AppConstants.LOGIN_SHEET_NAME);
		return regData;
	}
	
	@Test(dataProvider = "incorrectLoginExcelData")
	public void loginWithWrongCredentialsTest(String username, String password) {
		Assert.assertTrue(loginPage.doLoginWithWrongCredentials(username, password));
	}
	

}
