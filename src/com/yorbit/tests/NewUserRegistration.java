/**
 * @author Pakshi
 *
 */
package com.yorbit.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.yorbit.business.HomeFunctions;
import com.yorbit.business.UserRegistrationFunction;
import com.yorbit.utilities.FileReaderUtil;
import com.yorbit.utilities.Reporter;
import com.yorbit.utilities.TestConstants;

public class NewUserRegistration extends BaseTest {

	@Test
	public void newUserRegistration() throws Exception {
		try {
			logger = extent.startTest("User Registration");

			Map<String, String> data = new HashMap<String, String>();
			data = FileReaderUtil.readCSVFile(localDir + "/DataFiles/NewUserRegistration.csv", 0);

			lauchApp();

			HomeFunctions.verifyHomePageDisplayed(driver, logger);

			HomeFunctions.clickOnMenuOptions(driver, logger, "register");

			UserRegistrationFunction.verifyUserRegistrationPageDisplayed(driver, logger);

			UserRegistrationFunction.fillContactInformation(driver, logger, data);

			UserRegistrationFunction.fillMailingAddress(driver, logger, data);

			UserRegistrationFunction.fillUserInformation(driver, logger, data);

			UserRegistrationFunction.register(driver, logger);

			UserRegistrationFunction.clickOnSignInLinkOnRegistrationSuccessPage(driver, logger);

			HomeFunctions.singIn(driver, logger, TestConstants.newUserDetails);

			closeAppAndEndSession();
		} catch (Exception e) {
			Reporter.logStatus("Fail", "Error occured "+e.toString(), logger);
			Assert.fail();
		}
	}

}
