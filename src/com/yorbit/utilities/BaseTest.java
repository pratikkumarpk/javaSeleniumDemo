package com.yorbit.utilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest {
	public static AndroidDriver<?> mobiledriver;
	static FileReader reader = new FileReader();
	
	public void beforeTest( ) throws IOException {
		String localDir = System.getProperty("user.dir");
		String desiredCaps = localDir+"//utilityfiles//desiredCapibility.properties";
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.15.0");
		capabilities.setCapability("platformName",reader.readPropertiesFile(desiredCaps, "platformName"));
		capabilities.setCapability("deviceName", reader.readPropertiesFile(desiredCaps, "deviceName"));
		capabilities.setCapability("noReset", false);
		capabilities.setCapability("app", localDir +reader.readPropertiesFile(desiredCaps, "app"));
		capabilities.setCapability("appPackage", reader.readPropertiesFile(desiredCaps, "appPackage"));
		capabilities.setCapability("appActivity", reader.readPropertiesFile(desiredCaps, "appActivity"));
		capabilities.setCapability("newCommandTimeout", 2000);
		mobiledriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		Reporter.log("driver created");
	}

}
