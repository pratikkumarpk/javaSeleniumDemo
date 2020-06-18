package com.yorbit.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.yorbit.business.FlightsFunction;
import com.yorbit.business.HomeFunctions;
import com.yorbit.business.PassengerPageFunction;
import com.yorbit.utilities.FileReaderUtil;
import com.yorbit.utilities.Reporter;

public class BookAFlight extends BaseTest {

	@Test
	public void bookAFlight() throws Exception {
		try {
			logger = extent.startTest("book A flight");

			Map<String, String> data = new HashMap<String, String>();
			data = FileReaderUtil.readCSVFile(localDir + "/DataFiles/bookAFlight.csv", 0);

			lauchApp();

			HomeFunctions.verifyHomePageDisplayed(driver, logger);

			HomeFunctions.clickOnMenuOptions(driver, logger, "signon");

			HomeFunctions.singIn(driver, logger, data);

			FlightsFunction.verifyFLightFinderDisplayed(driver, logger);

			FlightsFunction.findFlight(driver, data, logger);

			FlightsFunction.selectFlight(driver, logger);

			PassengerPageFunction.fillPaxDetails(driver, logger);

			PassengerPageFunction.secureTickets(driver, logger);

			closeAppAndEndSession();
		} catch (Exception e) {
			Reporter.logStatus("Fail", "Error occured "+e.toString(), logger);
			Assert.fail();
		}
	}

}
