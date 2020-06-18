package com.yorbit.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.yorbit.business.HomeFunctions;
import com.yorbit.utilities.FileReaderUtil;
import com.yorbit.utilities.Reporter;

public class SignIn extends BaseTest {

	@Test
	public void signIn() throws Exception {
		try {
			logger = extent.startTest("SignIn");
			
			Map<String, String> data = new HashMap<String, String>();
			data = FileReaderUtil.readCSVFile(localDir + "/DataFiles/signIn.csv", 0);
			
			lauchApp();
			
			HomeFunctions.verifyHomePageDisplayed(driver, logger);
			
			HomeFunctions.clickOnMenuOptions(driver, logger, "signon");
			
			HomeFunctions.singIn(driver, logger, data);
			
			closeAppAndEndSession();
		} catch (Exception e) {
			Reporter.logStatus("Fail", "Error occured "+e.toString(), logger);
			Assert.fail();
		}
	}

}
