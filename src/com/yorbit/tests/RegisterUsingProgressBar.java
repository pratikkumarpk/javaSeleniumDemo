package com.yorbit.tests;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.yorbit.business.PermissionController;
import com.yorbit.business.UserRegistration;
import com.yorbit.page.HomePage;
import com.yorbit.utilities.Common;
import com.yorbit.utilities.FileReaderUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class RegisterUsingProgressBar extends BaseTest {

	@Test
	public void registerUsingProgressBar() throws Exception {
		try {
			logger = extent.startTest("Register using ProgressBar");
			
			int defaul = 0;
			Map<String,String> data = new HashMap<String,String>();
			lauchApp();
			HomePage hp = new HomePage((AndroidDriver<MobileElement>) mobiledriver);
			data = FileReaderUtil.readCSVFile(localDir+"/DataFiles/NewUserRegistration.csv", defaul);
			PermissionController.acceptPermission(mobiledriver,logger);
			Common.acceptAlert(mobiledriver);
			
			hp.clickBtnProgressBar();
			logger.log(LogStatus.PASS, "Clicked on progress bar button");
			WebDriverWait wait = new WebDriverWait(mobiledriver, 30);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("android:id/progress")));
			
			
			UserRegistration.fillRegistration(mobiledriver,data,logger);
			UserRegistration.verifyRegistration(mobiledriver, data, "name");
			UserRegistration.verifyRegistration(mobiledriver, data, "email");
			UserRegistration.verifyRegistration(mobiledriver, data, "lang");
			UserRegistration.verifyRegistration(mobiledriver, data, "pwd");
			UserRegistration.verifyRegistration(mobiledriver, data, "username");
			closeAppAndEndSession();
		}catch (Exception e) {
			e.printStackTrace();
			closeAppAndEndSession();
			Assert.fail();
		}
	}

}
