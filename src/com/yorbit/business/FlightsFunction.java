/**
 * @author Pakshi
 *
 */
package com.yorbit.business;

import java.util.Arrays;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.ExtentTest;
import com.yorbit.page.FlightFinderPage;
import com.yorbit.page.SelectFlight;
import com.yorbit.utilities.Common;
import com.yorbit.utilities.Reporter;
import com.yorbit.utilities.Utilities;

public class FlightsFunction {

	/**
	 * Verifies if flight finder page is displayed.
	 * 
	 * @param driver
	 * @param logger
	 * @throws Exception
	 */
	public static void verifyFLightFinderDisplayed(WebDriver driver, ExtentTest logger) throws Exception {
		try {
			Common.waitF(driver, 3L)
					.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[name='findflight']")));
			Reporter.logScreenshots(driver, "FlightFinderPage", "pass", logger);
		} catch (Exception e) {
			Reporter.logStatus("fail", Arrays.toString(e.getStackTrace()), logger);
			throw new Exception("Flight finder page not displayed " + e.getMessage());
		}

	}

	/**
	 * Finds Flight based on the data provided.
	 * 
	 * @param driver
	 * @param data
	 *            is a Map consists of key and value
	 * @param logger
	 * @throws Exception
	 */
	public static void findFlight(WebDriver driver, Map<String, String> data, ExtentTest logger) throws Exception {
		try {
			String tripType = data.get("triptype");
			String passengers = data.get("pax");
			String fromPort = data.get("origin");
			String toPort = data.get("destination");
			data.containsKey("daysahead");
			data.get("daysahead");
			data.containsKey("servClass");
			data.get("servClass");

			FlightFinderPage fp = new FlightFinderPage(driver);
			Utilities.clickOnElement(logger, (tripType.equalsIgnoreCase("rt")) ? fp.radioRoundTrip : fp.radioOneWay);
			Utilities.selectFromDropDownByValue(logger, fp.passCountDD, passengers);
			Utilities.selectFromDropDownByValue(logger, fp.toPortDD, toPort);
			Utilities.selectFromDropDownByValue(logger, fp.fromPortDD, fromPort);

			Utilities.clickOnElement(logger, fp.btnFindFLight);

		} catch (Exception e) {
			Reporter.logStatus("fail", Arrays.toString(e.getStackTrace()), logger);
			throw new Exception("Exception occured in finding flight " + e.getMessage());
		}

	}

	/**
	 * Selects default flight.
	 * 
	 * @param driver
	 * @param logger
	 * @throws Exception
	 */
	public static void selectFlight(WebDriver driver, ExtentTest logger) throws Exception {
		try {
			SelectFlight sp = new SelectFlight(driver);
			Utilities.clickOnElement(logger, sp.btnContinue);
		} catch (Exception e) {
			Reporter.logStatus("fail", Arrays.toString(e.getStackTrace()), logger);
			throw new Exception("Exception occured in selecting flight " + e.getMessage());
		}
	}

	/**
	 * Clicks on header Items
	 * 
	 * @param driver
	 * @param logger
	 * @param item
	 * @throws Exception
	 */
	public static void clickOnHeaderItems(WebDriver driver, ExtentTest logger, String item) throws Exception {
		try {
			FlightFinderPage ffp = new FlightFinderPage(driver);

			switch (item) {
			case "profile":
				Utilities.clickOnElement(logger, ffp.linkEditProfile);
				break;
			case "itinerary":
				Utilities.clickOnElement(logger, ffp.linkItinerary);
				break;

			default:
				throw new Exception("item does not match");
			}
		} catch (Exception e) {
			Reporter.logStatus("fail", Arrays.toString(e.getStackTrace()), logger);
			throw new Exception("Exception occured in selecting flight " + e.getMessage());
		}
	}

}
