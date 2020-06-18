/**
 * @author Pakshi
 *
 */
package com.yorbit.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common {
	
	/**
	 * Accepts alert.
	 * @param mobiledriver
	 * @throws Exception
	 */
	public static void acceptAlert(WebDriver driver) throws Exception {
		try {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		}catch (Exception e) {
			throw new Exception("Error in accepting alert"+Arrays.toString(e.getStackTrace()));
		}
	}
	
	/**
	 * Returns path of screenshot saved in FailedTestsScreenshots folder.
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws Exception
	 */
	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
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
	
	/**
	 * Returns WebDriverWait instance with required waittime.
	 * @param driver
	 * @param waitTime
	 * @return
	 */
	public static WebDriverWait waitF(WebDriver driver,long waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		return wait;
	}

}
