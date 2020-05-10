package com.yorbit.business;

import java.util.Map;

import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.yorbit.page.HomePage;
import com.yorbit.page.RegistrationPage;
import com.yorbit.page.RegistrationSuccessPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class UserRegistration {

	/**
	 * Fills registration form.
	 * 
	 * @param mobiledriver
	 * @param data
	 * @param logger
	 * @throws Exception
	 */
	public static void fillRegistration(AndroidDriver<?> mobiledriver, Map<String, String> data, ExtentTest logger)
			throws Exception {
		try {
			RegistrationPage rp = new RegistrationPage((AndroidDriver<MobileElement>) mobiledriver);
			rp.typeInUserName(data.get("username"));
			rp.typeInEmail(data.get("email"));
			rp.typeInPwd(data.get("pwd"));
			rp.typeInName(data.get("name"));
			rp.selectFromLangDD(data.get("lang"));
			mobiledriver.hideKeyboard();
			rp.selectAcceptCheckBox();
			rp.clcikButtonregister();
			logger.log(LogStatus.PASS, "Filled registration form");
		} catch (Exception e) {
			throw new Exception("Error in filling registration form" + e.getStackTrace());
		}

	}

	/**
	 * Clicks on start registration Button.
	 * 
	 * @param mobiledriver
	 * @param logger
	 * @throws Exception
	 */
	public static void clickOnStartRegistration(AndroidDriver<?> mobiledriver, ExtentTest logger) throws Exception {
		try {
			HomePage hp = new HomePage((AndroidDriver<MobileElement>) mobiledriver);
			hp.clickOnNewUserregistrationButton();
			logger.log(LogStatus.PASS, "Clicked on new user registration");
		} catch (Exception e) {
			throw new Exception("Error in clciking new user registration button" + e.getStackTrace());
		}
	}

	/**
	 * Verifies egistration data
	 * 
	 * @param mobiledriver
	 * @param data
	 * @param key
	 * @throws Exception
	 */
	public static void verifyRegistration(AndroidDriver<?> mobiledriver, Map<String, String> data, String key)
			throws Exception {
		Assert.assertEquals(selectMethodForVerification(key, mobiledriver), data.get(key).toLowerCase());

	}

	/**
	 * 
	 * @param key
	 * @param mobiledriver
	 * @return
	 * @throws Exception
	 */
	private static String selectMethodForVerification(String key, AndroidDriver<?> mobiledriver) throws Exception {
		try {
			RegistrationSuccessPage rsp = new RegistrationSuccessPage((AndroidDriver<MobileElement>) mobiledriver);
			switch (key.toLowerCase()) {
			case "email": {
				return rsp.getlblEmail();
			}
			case "name": {
				return rsp.getlblName();
			}
			case "lang": {
				return rsp.getlblLang();
			}
			case "pwd": {
				return rsp.getlblPwd();
			}
			case "username": {
				return rsp.getlbluserName();
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + key);
			}
		} catch (Exception e) {
			throw new Exception("Error in selecting method" + e.getStackTrace());
		}
	}

}
