/**
 * @author Pakshi
 *
 */
package com.yorbit.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
			throw new Exception("Error in accepting alert"+Arrays.toString(e.getStackTrace()));
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
			throw new Exception("Error in Switching context"+Arrays.toString(e.getStackTrace()));
		}


	}

	public static String getScreenshot(AndroidDriver<?> driver, String screenshotName) throws Exception {
		try {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
		}catch (Exception e) {
			throw new Exception("Error in taking screenshots"+Arrays.toString(e.getStackTrace()));
		}
	}

}
