package com.yorbit.business;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.yorbit.tests.BaseTest;

import io.appium.java_client.MobileElement;

public class PermissionController{

	static BaseTest df = new BaseTest();
	public static void acceptPermission() {
		MobileElement continueButton = (MobileElement) df.mobiledriver.findElement(By.id("com.android.permissioncontroller:id/continue_button"));
		continueButton.click();
		df.mobiledriver.findElement(By.id("android:id/button1")).click();
	}
}
