package com.yorbit.utilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {
	public static AndroidDriver<?> mobiledriver;
	@BeforeTest
	public void beforeTest( ) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.15.0");
		//capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4");
		capabilities.setCapability("platformName","Android");
		//capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
		capabilities.setCapability("deviceName", "9a87d300");
		capabilities.setCapability("noReset", false);
		String localDir = System.getProperty("user.dir");
		//localDir + "\\config.properties");
		capabilities.setCapability("app", localDir +"\\app\\selendroid-test-app.apk");
		//capabilities.setCapability("app", "C:\\pratik\\appium 201\\AppiumProject201\\AppiumDemoProject\\app\\selendroid-test-app.apk");
		capabilities.setCapability("appPackage", "io.selendroid.testapp");
		capabilities.setCapability("appActivity", "io.selendroid.testapp.HomeScreenActivity");
		//capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");
		capabilities.setCapability("newCommandTimeout", 2000);
		mobiledriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

}
