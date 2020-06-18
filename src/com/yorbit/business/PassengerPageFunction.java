/**
 * @author Pakshi
 *
 */
package com.yorbit.business;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.github.javafaker.Faker;
import com.relevantcodes.extentreports.ExtentTest;
import com.yorbit.page.PaxInfoPage;
import com.yorbit.utilities.Common;
import com.yorbit.utilities.Reporter;
import com.yorbit.utilities.Utilities;

public class PassengerPageFunction {

	public static Faker faker = new Faker();

	/**
	 * Verify Pax page displayed.
	 * 
	 * @param driver
	 * @param logger
	 * @throws Exception
	 */
	public static void verifyPaxPageDisplayed(WebDriver driver, ExtentTest logger) throws Exception {
		try {
			PaxInfoPage pip = new PaxInfoPage(driver);
			Common.waitF(driver, 10L).until(ExpectedConditions.visibilityOf(pip.txtFN));
			Reporter.logScreenshots(driver, "PaxPage", "pass", logger);
		} catch (Exception e) {
			Reporter.logStatus("fail", Arrays.toString(e.getStackTrace()), logger);
			throw new Exception("Pax page did not displayed" + e.toString());

		}

	}

	/**
	 * Fills in Passenger details with random data.
	 * 
	 * @param driver
	 * @param logger
	 * @throws Exception
	 */
	public static void fillPaxDetails(WebDriver driver, ExtentTest logger) throws Exception {
		try {
			PaxInfoPage pip = new PaxInfoPage(driver);

			Utilities.inputText(logger, pip.txtFN, faker.name().firstName());
			Utilities.inputText(logger, pip.txtLN, faker.name().lastName());
			Utilities.inputText(logger, pip.txtCardNumber, String.valueOf(faker.number().randomNumber(16, true)));
			Utilities.inputText(logger, pip.ccFN, faker.name().firstName());
			Utilities.inputText(logger, pip.ccLN, faker.name().lastName());

			Reporter.logScreenshots(driver, "Filled required details", "pass", logger);
		} catch (Exception e) {
			Reporter.logStatus("fail", Arrays.toString(e.getStackTrace()), logger);
			throw new Exception("Exception occured in buying flight " + e.getMessage());
		}
	}

	/**
	 * Clicks on Buy Tickets.
	 * 
	 * @param driver
	 * @param logger
	 * @throws Exception
	 */
	public static void secureTickets(WebDriver driver, ExtentTest logger) throws Exception {
		try {
			PaxInfoPage pip = new PaxInfoPage(driver);
			Utilities.clickOnElement(logger, pip.buyFlight);
			Common.waitF(driver, 20L).until(ExpectedConditions.titleContains("Flight Confirmation"));
		} catch (Exception e) {
			Reporter.logStatus("fail", Arrays.toString(e.getStackTrace()), logger);
			throw new Exception("Error in buying flight" + e.toString());
		}
	}
}
