/**
 * @author Pakshi
 *
 */
package com.yorbit.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.yorbit.business.PermissionController;
import com.yorbit.page.HomePage;
import com.yorbit.utilities.Common;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AppCrash extends BaseTest {

	@Test
	public void appCrashTest() throws Exception {
		try {
			logger = extent.startTest("Crash App Success");
			lauchApp();
			HomePage hp = new HomePage((AndroidDriver<MobileElement>) mobiledriver);
			PermissionController.acceptPermission(mobiledriver, logger);
			Common.acceptAlert(mobiledriver);
			logger.log(LogStatus.INFO, "Clicking on App crash");
			hp.clickBtnCrash();
		} catch (Exception e) {
			closeAppAndEndSession();
			Assert.fail();
		} finally {
			Assert.assertTrue(true);
		}
	}

}
