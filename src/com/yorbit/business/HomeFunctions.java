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
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.yorbit.page.HomePage;
import com.yorbit.page.NewUserRegistrationPage;
import com.yorbit.page.LoginPage;
import com.yorbit.utilities.Common;
import com.yorbit.utilities.Reporter;
import com.yorbit.utilities.Utilities;

public class HomeFunctions {
	/**
	 * Verifies if Home Page is displayed.
	 * 
	 * @param driver
	 * @param logger
	 * @throws Exception
	 */
	public static void verifyHomePageDisplayed(WebDriver driver, ExtentTest logger) throws Exception {
		try {
			HomePage hp = new HomePage(driver);
			Assert.assertTrue(hp.homeLabel.isDisplayed(), "Home Page is displayed.");
			Reporter.logScreenshots(driver, "HomePage", "pass", logger);
		} catch (Exception e) {
			Reporter.logStatus("fail", Arrays.toString(e.getStackTrace()), logger);
			throw new Exception("Home Page not displayed " + e.toString());
		}
	}

	/**
	 * Clicks on menu options.
	 * 
	 * @param driver
	 * @param logger
	 * @param option
	 * @throws Exception
	 */
	public static void clickOnMenuOptions(WebDriver driver, ExtentTest logger, String option) throws Exception {
		try {
			HomePage hp = new HomePage(driver);
			NewUserRegistrationPage sp = new NewUserRegistrationPage(driver);
			switch (option.toLowerCase()) {
			case "home":
				Utilities.clickOnElement(logger, hp.homeLink);
				Assert.assertTrue(hp.homeLabel.isDisplayed());
				break;
			case "signon":
				Utilities.clickOnElement(logger, hp.signOnLink);
				Assert.assertTrue(sp.txtBoxUserName.isDisplayed());
				break;

			case "register":
				Utilities.clickOnElement(logger, hp.registerLink);
				Assert.assertTrue(sp.txtBoxUserName.isDisplayed());
				break;

			default:
				throw new Exception("Option not available in list");
			}
			Reporter.logStatus("info", "clicked on menu options", logger);
		} catch (Exception e) {
			Reporter.logStatus("fail", Arrays.toString(e.getStackTrace()), logger);
			throw new Exception("Unable to click on Menu options" + e.toString());
		}
	}

	/**
	 * Sign In with username and password.
	 * 
	 * @param driver
	 * @param logger
	 * @param data
	 * @throws Exception
	 */
	public static void singIn(WebDriver driver, ExtentTest logger, Map<String, String> data) throws Exception {
		try {
			LoginPage sp = new LoginPage(driver);
			Utilities.inputText(logger, sp.txtBoxUserName, data.get("username"));
			Utilities.inputText(logger, sp.txtBoxPassword, data.get("password"));
			Utilities.clickOnElement(logger, sp.btnLogin);
			Common.waitF(driver, 30L)
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='SIGN-OFF']")));
			Reporter.logStatus("pass", "logged in success", logger);
		} catch (Exception e) {
			Reporter.logStatus("fail", Arrays.toString(e.getStackTrace()), logger);
			throw new Exception("Error in siginig in " + e.getMessage());
		}

	}

}
