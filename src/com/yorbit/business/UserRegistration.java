package com.yorbit.business;

import java.util.Map;

import org.testng.Assert;

import com.yorbit.page.HomePage;
import com.yorbit.page.RegistrationPage;
import com.yorbit.page.RegistrationSuccessPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class UserRegistration {
	
	public static void startRegistration(AndroidDriver<?> mobiledriver, Map<String, String> data) {
		HomePage hp = new HomePage((AndroidDriver<MobileElement>) mobiledriver);
		hp.clickOnNewUserregistrationButton();
		
		RegistrationPage rp = new RegistrationPage((AndroidDriver<MobileElement>) mobiledriver);
		rp.typeInUserName(data.get("username"));
		rp.typeInEmail(data.get("email"));
		rp.typeInPwd(data.get("pwd"));
		rp.typeInName(data.get("name"));
		rp.selectFromLangDD(data.get("lang"));
		mobiledriver.hideKeyboard();
		rp.selectAcceptCheckBox();
		rp.clcikButtonregister();
		
	}
	
	public static void verifyRegistration(AndroidDriver<?> mobiledriver, Map<String, String> data,String key) {
		Assert.assertEquals(selectMethodForVerification(key, mobiledriver), data.get(key).toLowerCase());
	}
	
	private static String selectMethodForVerification(String key,AndroidDriver<?> mobiledriver) {
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
	}
	

}
