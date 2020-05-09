package com.yorbit.tests;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.util.Calendar;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.yorbit.utilities.FileReaderUtil;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest {
	public static AndroidDriver<?> mobiledriver;
	static FileReaderUtil reader = new FileReaderUtil();
	public static String localDir = System.getProperty("user.dir");
	public static ExtentReports extent;
	public static ExtentTest logger;

	/**
	 * Launches app based on the desired capability in desiredCapibilty.properties file.
	 * @throws Exception
	 */
	public void lauchApp() throws Exception {
		try {
			String desiredCaps = localDir + "//utilityfiles//desiredCapibility.properties";
			DesiredCapabilities capabilities = new DesiredCapabilities();
			switch (reader.readPropertiesFile(desiredCaps, "deviceType").toLowerCase()) {
			case "real": {
				capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION,
						reader.readPropertiesFile(desiredCaps, "APPIUM_VERSION"));
				capabilities.setCapability("platformName", reader.readPropertiesFile(desiredCaps, "platformName"));
				capabilities.setCapability("deviceName", reader.readPropertiesFile(desiredCaps, "deviceName"));
				capabilities.setCapability("noReset", false);
				break;
			}
			case "emulator":
				capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION,
						reader.readPropertiesFile(desiredCaps, "APPIUM_VERSION"));
				capabilities.setCapability("platformName", reader.readPropertiesFile(desiredCaps, "platformName"));
				capabilities.setCapability("deviceName", "Android Emulator");
				capabilities.setCapability("noReset", false);
				
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: ");
			}
			capabilities.setCapability("newCommandTimeout", 2000);
			capabilities.setCapability("app", localDir + reader.readPropertiesFile(desiredCaps, "app"));
			capabilities.setCapability("appPackage", reader.readPropertiesFile(desiredCaps, "appPackage"));
			capabilities.setCapability("appActivity", reader.readPropertiesFile(desiredCaps, "appActivity"));
			mobiledriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			mobiledriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			logger.log(LogStatus.PASS, "Driver Created", "launchApp");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Exception occured in launching app " + e);
			throw new Exception("Exception occured in launching app " + e);
		}
	}

	/**
	 * Starts reports.
	 * @throws Exception
	 */
	@BeforeTest
	public void startReport() throws Exception {
		try {
			Calendar cal = Calendar.getInstance();
			extent = new ExtentReports(System.getProperty("user.dir") + "/ExtentReport/AppiumDemoProjectReport__"
					+ cal.getTime().toString().replace(" ", "").replace(":", "_") + ".html", true);
			extent.addSystemInfo("Environment", "Environment Name");
			extent.addSystemInfo("Host Name", "Appium 201").addSystemInfo("Environment", "Automation Testing")
					.addSystemInfo("User Name", "Pratik Kumar");
			extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
		} catch (Exception e) {
			throw new Exception("Starting report failed " + e);
		}
	}
	
	/**
	 * Logs status of test after execution.
	 * @param result
	 */
	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		}
		extent.endTest(logger);
	}
	
	/**
	 * resets logger instance.
	 * @throws Exception
	 */
	@AfterTest
	public void endReport() throws Exception {
		try {
			extent.flush();
			extent.close();
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failed to close Report" + e);
			throw new Exception("Failed to close Report" + e);
		}
	}
	/**
	 * Closes app instance and driver.
	 * @throws Exception
	 */
	public void closeAppAndEndSession() throws Exception {
		try {
			mobiledriver.closeApp();
			mobiledriver.quit();
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failed to close the App" + e);
			throw new Exception("Failed to close the App " + e);
		}
	}
}
