package com.yorbit.utilities;

import java.util.Set;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Common {
	
	/**
	 * Accepts alert.
	 * @param mobiledriver
	 * @throws Exception
	 */
	public static void acceptAlert(AndroidDriver<?> mobiledriver) throws Exception {
		try {
		WebDriverWait wait = new WebDriverWait(mobiledriver, 5);
		wait.until(ExpectedConditions.alertIsPresent());
		mobiledriver.switchTo().alert().accept();
		}catch (Exception e) {
			throw new Exception("Error in accepting alert"+e.getStackTrace());
		}
	}
	
	/**
	 * Switches context.
	 * @param mobiledriver
	 * @throws Exception
	 */
	public static void contextSwitch(AndroidDriver<?> mobiledriver) throws Exception {
		try {
		Set<String> contextNames = mobiledriver.getContextHandles();
		//mobiledriver.context(contextNames.toArray()[1]);
		mobiledriver.context("NATIVE_APP");
		}catch (Exception e) {
			throw new Exception("Error in Switching contextt"+e.getStackTrace());
		}


	}
	

}
