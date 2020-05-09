package com.yorbit.business;

import java.util.Map;

import com.yorbit.page.HomePage;
import com.yorbit.page.RegistrationPage;

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
		rp.selectAcceptCheckBox();
		rp.clcikButtonregister();
		
	}
	
	public static void verifyRegistration(AndroidDriver<?> mobiledriver, Map<String, String> data) {
		
	}
	

}
