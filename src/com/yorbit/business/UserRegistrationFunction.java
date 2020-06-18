/**
 * @author Pakshi
 *
 */
package com.yorbit.business;

import java.util.Arrays;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.github.javafaker.Faker;
import com.relevantcodes.extentreports.ExtentTest;
import com.yorbit.page.NewUserRegistrationPage;
import com.yorbit.utilities.Common;
import com.yorbit.utilities.Reporter;
import com.yorbit.utilities.TestConstants;
import com.yorbit.utilities.Utilities;

public class UserRegistrationFunction {

	public static Faker faker = new Faker();
	/**
	 * Verify User Registration page displayed.
	 * @param driver
	 * @param logger
	 * @throws Exception
	 */
	public static void verifyUserRegistrationPageDisplayed(WebDriver driver,ExtentTest logger) throws Exception {
		try {
		NewUserRegistrationPage nur = new NewUserRegistrationPage(driver);
		Common.waitF(driver, 30L).until(ExpectedConditions.visibilityOf(nur.btnRegister));
		Reporter.logScreenshots(driver, "RegistrationPage", "pass", logger);
		}catch (Exception e) {
			Reporter.logStatus("fail", Arrays.toString(e.getStackTrace()), logger);
			throw new Exception("User Registration page did not displayed "+e.toString());
			
		}
		
	}
	/**
	 * Fills in contact information.
	 * @param driver
	 * @param logger
	 * @param data is a Map.
	 * @throws Exception
	 */
	public static void fillContactInformation(WebDriver driver,ExtentTest logger,Map<String,String> data) throws Exception {
		try {
		NewUserRegistrationPage nur = new NewUserRegistrationPage(driver);
		
		String firstName = (data.containsKey("fn"))?data.get("fn"):faker.name().firstName();
		String lastName = (data.containsKey("ln"))?data.get("ln"):faker.name().lastName();
		String phone = (data.containsKey("phone"))?data.get("phone"):faker.phoneNumber().phoneNumber();
		String email = (data.containsKey("email"))?data.get("email"):faker.name().username()+"@test.com";
		
		Utilities.inputText(logger, nur.txtBoxFirstName,firstName);
		Utilities.inputText(logger, nur.txtBoxLastName,lastName);
		Utilities.inputText(logger, nur.txtBoxPhone,phone);
		Utilities.inputText(logger, nur.txtBoxEmail,email);
		
		Reporter.logStatus("pass" ,"Filled contact Information", logger);
		
		}catch (Exception e) {
			Reporter.logStatus("fail", Arrays.toString(e.getStackTrace()), logger);
			throw new Exception("Exception occured in buying flight "+e.getMessage());
		}
	}
	/**
	 * fills in mailing address.
	 * @param driver
	 * @param logger
	 * @param data is a Map.
	 * @throws Exception
	 */
	public static void fillMailingAddress(WebDriver driver,ExtentTest logger,Map<String,String> data) throws Exception {
		try {
		NewUserRegistrationPage nur = new NewUserRegistrationPage(driver);
		
		String address = (data.containsKey("address"))?data.get("address"):faker.address().fullAddress();
		String city = (data.containsKey("city"))?data.get("city"):faker.address().cityName();
		String state = (data.containsKey("province"))?data.get("province"):faker.address().state();
		String postalCode = (data.containsKey("postal"))?data.get("postal"):faker.address().zipCode();
		
		Utilities.inputText(logger, nur.txtBoxAddress1,address);
		Utilities.inputText(logger, nur.txtBoxCity,city);
		Utilities.inputText(logger, nur.txtBoxState,state);
		Utilities.inputText(logger, nur.txtBoxPostalCode,postalCode);
		
		Reporter.logStatus("pass" ,"Filled mailing Information", logger);
		}catch (Exception e) {
			Reporter.logStatus("fail", Arrays.toString(e.getStackTrace()), logger);
			throw new Exception("Exception occured in buying flight "+e.getMessage());
		}
	}
	/**
	 * Fills in User Information.
	 * @param driver
	 * @param logger
	 * @param data is a Map.
	 * @throws Exception
	 */
	public static void fillUserInformation(WebDriver driver,ExtentTest logger,Map<String,String> data) throws Exception {
		try {
		NewUserRegistrationPage nur = new NewUserRegistrationPage(driver);
		
		String userName = (data.containsKey("username"))?data.get("username"):faker.name().username();
		String pwd = (data.containsKey("pwd"))?data.get("pwd"):"password";
		
		Utilities.inputText(logger, nur.txtBoxUserName,userName);
		Utilities.inputText(logger, nur.txtBoxPwd,pwd);
		Utilities.inputText(logger, nur.txtBoxCnfrmPwd,pwd);
		
		Reporter.logStatus("pass" ,"Filled User Information", logger);
		
		TestConstants.newUserDetails.put("username", userName);
		TestConstants.newUserDetails.put("password", pwd);
		}catch (Exception e) {
			Reporter.logStatus("fail", Arrays.toString(e.getStackTrace()), logger);
			throw new Exception("Exception occured in Filled User Information "+e.getMessage());
		}
	}
	/**
	 * Clicks on register Button.
	 * @param driver
	 * @param logger
	 * @throws Exception
	 */
	public static void register(WebDriver driver, ExtentTest logger) throws Exception {
		try {
			NewUserRegistrationPage nur = new NewUserRegistrationPage(driver);
		Utilities.clickOnElement(logger, nur.btnRegister);
		Common.waitF(driver, 20L).until(ExpectedConditions.visibilityOf(nur.registrationSuccessSigninLink));
		}catch (Exception e) {
			Reporter.logStatus("fail", Arrays.toString(e.getStackTrace()), logger);
			throw new Exception("Error in buying flight "+e.toString());
		}
	}
	/**
	 * Clicks on Sign In link on Registration Success page.
	 * @param driver
	 * @param logger
	 * @throws Exception
	 */
	public static void clickOnSignInLinkOnRegistrationSuccessPage(WebDriver driver, ExtentTest logger) throws Exception {
		try {
		NewUserRegistrationPage nur = new NewUserRegistrationPage(driver);
		Utilities.clickOnElement(logger, nur.registrationSuccessSigninLink);
		}catch (Exception e) {
			Reporter.logStatus("fail", Arrays.toString(e.getStackTrace()), logger);
			throw new Exception("Error in clicking on signin link on confirmation page "+e.toString());
		}
	}
	/**
	 * Clicks on Edit Submit Page
	 * @param driver
	 * @param logger
	 * @throws Exception
	 */
	public static void clickOnEditSubmit(WebDriver driver, ExtentTest logger) throws Exception {
		try {
		NewUserRegistrationPage nur = new NewUserRegistrationPage(driver);
		Utilities.clickOnElement(logger, nur.submitEditProfile);
		}catch (Exception e) {
			Reporter.logStatus("fail", Arrays.toString(e.getStackTrace()), logger);
			throw new Exception("Error in clicking on submitEditProfile button "+e.toString());
		}
	}
}
