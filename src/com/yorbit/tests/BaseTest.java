package com.yorbit.tests;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.util.Calendar;
import java.util.Map;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.yorbit.utilities.FileReader;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest {
	public static AndroidDriver<?> mobiledriver;
	static FileReader reader = new FileReader();
	public static String localDir = System.getProperty("user.dir");

	public static ExtentReports extent;
	public static ExtentTest logger;

	public void lauchApp() throws Exception {
		try {
			String desiredCaps = localDir + "//utilityfiles//desiredCapibility.properties";
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.15.0");
			capabilities.setCapability("platformName", reader.readPropertiesFile(desiredCaps, "platformName"));
			capabilities.setCapability("deviceName", reader.readPropertiesFile(desiredCaps, "deviceName"));
			capabilities.setCapability("noReset", false);
			capabilities.setCapability("app", localDir + reader.readPropertiesFile(desiredCaps, "app"));
			capabilities.setCapability("appPackage", reader.readPropertiesFile(desiredCaps, "appPackage"));
			capabilities.setCapability("appActivity", reader.readPropertiesFile(desiredCaps, "appActivity"));
			capabilities.setCapability("newCommandTimeout", 2000);
			mobiledriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			logger.log(LogStatus.PASS, "Driver Created", "launchApp");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Exception occured in launching app " + e);
			throw new Exception("Exception occured in launching app " + e);
		}
	}

	@BeforeTest
	public void startReport() {
		Calendar cal = Calendar.getInstance();
		System.out.println("I am in before Test");
		extent = new ExtentReports(System.getProperty("user.dir") + "/ExtentReport/AppiumDemoProjectReport__"
				+ cal.getTime().toString().replace(" ", "").replace(":", "_") + ".html", true);
		extent.addSystemInfo("Environment", "Environment Name");
		extent.addSystemInfo("Host Name", "Appium 201").addSystemInfo("Environment", "Automation Testing")
				.addSystemInfo("User Name", "Pratik Kumar");
		extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
	}

	@AfterMethod
	public void getResult(ITestResult result) { 
		System.out.println("I am in after Method");
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		}
		extent.endTest(logger);
	}

	@AfterTest
	public void endReport() {
		System.out.println("I am in after Test");
		extent.flush();
		extent.close();
	}
}
