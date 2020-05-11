/**
 * @author Pakshi
 *
 */
package com.yorbit.tests;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.yorbit.business.FillContactUsForm;
import com.yorbit.page.HomePage;
import com.yorbit.utilities.FileReaderUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class WebApptest extends BaseTest {

	String desiredCaps = localDir + "//utilityfiles//desiredCapibility.properties";
	@Test
	public void testWebApp() throws Exception {
		try {
			logger = extent.startTest("Test Web Application");
			
			int defaul = 0;
			Map<String,String> data = new HashMap<String,String>();
			lauchApp();
			
			String url = reader.readPropertiesFile(desiredCaps, "url");
			data = FileReaderUtil.readCSVFile(localDir+"/DataFiles/testWebApp.csv", 0);
			
			mobiledriver.get(url);
			FillContactUsForm.fillInContactInfo(mobiledriver, logger,data);
			FillContactUsForm.submit(mobiledriver, logger);
			FillContactUsForm.verifySuccess(mobiledriver, logger);
			closeAppAndEndSession();
		}catch (Exception e) {
			e.printStackTrace();
			closeAppAndEndSession();
			Assert.fail();
		}
	}

}


