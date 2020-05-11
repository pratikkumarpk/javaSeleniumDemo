/**
 * @author Pakshi
 *
 */
package com.yorbit.business;

import java.util.Arrays;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.yorbit.page.PermissionPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PermissionController{
	
	/**
	 * Accepts all permission.
	 * @param mobiledriver
	 * @param logger
	 * @throws Exception 
	 */
	public static void acceptPermission(AndroidDriver<?> mobiledriver, ExtentTest logger) throws Exception {
		try {
		PermissionPage pp = new PermissionPage((AndroidDriver<MobileElement>) mobiledriver);
		pp.clickOncontinueButton();
		logger.log(LogStatus.PASS, "Acccepted permission");
		}catch (Exception e) {
			throw new Exception("Error in selecting permission"+Arrays.toString(e.getStackTrace()));
		}
	}
}
