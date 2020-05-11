/**
 * @author Pakshi
 *
 */
package com.yorbit.business;

import java.util.Arrays;
import java.util.Map;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.yorbit.page.WebAppPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class FillContactUsForm {

	/**
	 * Fills contact us form.
	 * 
	 * @param mobiledriver
	 * @param logger
	 * @param data
	 * @throws Exception
	 */
	public static void fillInContactInfo(AndroidDriver<?> mobiledriver, ExtentTest logger, Map<String, String> data)
			throws Exception {
		try {
			WebAppPage wap = new WebAppPage((AndroidDriver<MobileElement>) mobiledriver);
			wap.enterFirstName(data.get("fn"));
			wap.enterlastName(data.get("ln"));
			String email = data.get("email").replace("@", System.currentTimeMillis() + "@");
			wap.enterEmail(email);
			wap.enterComments(data.get("msg"));
			mobiledriver.hideKeyboard();
			logger.log(LogStatus.PASS, "Filled form with data: " + data.toString());
		} catch (Exception e) {
			throw new Exception("Error in filling form" + Arrays.toString(e.getStackTrace()));
		}
	}

	/**
	 * Submits form
	 * 
	 * @param mobiledriver
	 * @param logger
	 * @throws Exception
	 */
	public static void submit(AndroidDriver<?> mobiledriver, ExtentTest logger) throws Exception {
		try {
			WebAppPage wap = new WebAppPage((AndroidDriver<MobileElement>) mobiledriver);
			wap.clickContactUsButton();
			logger.log(LogStatus.PASS, "Submitted Form");
		} catch (Exception e) {
			throw new Exception("Error in submitting form" + Arrays.toString(e.getStackTrace()));
		}
	}

	/**
	 * Verify submission Successful
	 * @param mobiledriver
	 * @param logger
	 * @throws Exception
	 */
	public static void verifySuccess(AndroidDriver<?> mobiledriver, ExtentTest logger) throws Exception {
		try {
			WebAppPage wap = new WebAppPage((AndroidDriver<MobileElement>) mobiledriver);
			WebDriverWait wait = new WebDriverWait(mobiledriver, 20);
			wait.until(ExpectedConditions.visibilityOf(wap.getSuccessLocator()));
			Assert.assertTrue(wap.verifySuccessMsg());
			logger.log(LogStatus.PASS, "SubmissionSuccessFull");
		} catch (Exception e) {
			throw new Exception("Error in submitting form" + Arrays.toString(e.getStackTrace()));
		}
	}

}
