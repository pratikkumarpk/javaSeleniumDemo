package com.yorbit.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import com.yorbit.business.PermissionController;
import com.yorbit.utilities.Common;

public class UserRegistration extends BaseTest {
	
	@Test
	public void passTest(){
		logger = extent.startTest("passTest");
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed is passTest");
	}
	
	@Test
	public void registerNewUserAndVerify() throws Exception {
			logger = extent.startTest("register New User and Verify");
			lauchApp();
			PermissionController.acceptPermission(mobiledriver);
			Common.dismissAlert(mobiledriver);
			//closeAppAndEndSession();
	}
}
