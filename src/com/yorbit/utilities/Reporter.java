package com.yorbit.utilities;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reporter {
	/**
	 * Logs message with status 
	 * @param stat
	 * @param details
	 * @param logger
	 * @throws Exception
	 */
	public static void logStatus(String stat, String details, ExtentTest logger) throws Exception {
		switch (stat.toLowerCase()) {
		case "pass":
			logger.log(LogStatus.PASS, details);
			break;
		case "fail":
			logger.log(LogStatus.FAIL, details);
			break;
		case "info":
			logger.log(LogStatus.INFO, details);
			break;
		default:
			throw new Exception("Pass stat correctly :pass/fail/info");
		}

	}
	/**
	 * Logs screenshot in the report.
	 * @param driver
	 * @param name
	 * @param stat
	 * @param logger
	 * @throws Exception
	 */
	public static void logScreenshots(WebDriver driver, String name, String stat, ExtentTest logger) throws Exception {
		String screenshotPath = Common.getScreenshot(driver, name);
		switch (stat.toLowerCase()) {
		case "pass":
			logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
			break;
		case "fail":
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
			break;
		case "info":
			logger.log(LogStatus.INFO, logger.addScreenCapture(screenshotPath));
			break;
		default :
			throw new Exception("Pass stat correctly :pass/fail/info");

		}
	}

}
