package com.yorbit.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.yorbit.business.FlightsFunction;
import com.yorbit.business.HomeFunctions;
import com.yorbit.business.UserRegistrationFunction;
import com.yorbit.utilities.FileReaderUtil;
import com.yorbit.utilities.Reporter;

public class EditProfile extends BaseTest {

	@Test
	public void editProfile() throws Exception {
		try {
			logger = extent.startTest("Edit Profile");
			
			Map<String, String> data = new HashMap<String, String>();
			data = FileReaderUtil.readCSVFile(localDir + "/DataFiles/editProfile.csv", 0);
			
			lauchApp();
			
			HomeFunctions.verifyHomePageDisplayed(driver, logger);
			
			HomeFunctions.clickOnMenuOptions(driver, logger, "signon");
			
			HomeFunctions.singIn(driver, logger, data);
			
			FlightsFunction.verifyFLightFinderDisplayed(driver,logger);
			
			FlightsFunction.clickOnHeaderItems(driver, logger, "profile");
			
			UserRegistrationFunction.fillContactInformation(driver, logger, data);
			
			UserRegistrationFunction.clickOnEditSubmit(driver, logger);
			
			HomeFunctions.verifyHomePageDisplayed(driver, logger);
			
			closeAppAndEndSession();
		} catch (Exception e) {
			Reporter.logStatus("Fail", "Error occured "+e.toString(), logger);
			Assert.fail();
		}
	}

}
