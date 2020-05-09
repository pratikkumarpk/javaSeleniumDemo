package com.yorbit.business;

import com.yorbit.page.PermissionPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PermissionController{
	
	public static void acceptPermission(AndroidDriver<?> mobiledriver) {
		PermissionPage pp = new PermissionPage((AndroidDriver<MobileElement>) mobiledriver);
		pp.clickOncontinueButton();
	}
}
