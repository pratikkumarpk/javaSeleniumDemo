package com.yorbit.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import com.yorbit.page.PermissionPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DemoTestCases extends BaseTest {
	
	@Test
	public void passTest(){
		logger = extent.startTest("passTest");
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed is passTest");
	}
	
	@Test
	public void launchAppAndAcceptPermission() throws Exception {
			logger = extent.startTest("launchAppAndAcceptPermission");
			lauchApp();
			PermissionPage pp = new PermissionPage((AndroidDriver<MobileElement>) mobiledriver);
			pp.clickOncontinueButton();
	}
	
	
	
	
}
