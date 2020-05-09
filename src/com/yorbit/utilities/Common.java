package com.yorbit.utilities;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Common {
	
	public static void dismissAlert(AndroidDriver<?> mobiledriver) {
		WebDriverWait wait = new WebDriverWait(mobiledriver, 5);
		wait.until(ExpectedConditions.alertIsPresent());
		mobiledriver.switchTo().alert().accept();
	}

}
