/**
 * @author Pakshi
 *
 */
package com.yorbit.tests;

import java.io.File;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.yorbit.utilities.Common;
import com.yorbit.utilities.FileReaderUtil;

import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseTest {
	public static WebDriver driver;
	public static String localDir = System.getProperty("user.dir");
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static AppiumDriverLocalService service = null;

	/**
	 * Launches app based on the desired capability in desiredCapibilty.properties
	 * file.
	 * 
	 * @throws Exception
	 */
	public void lauchApp() throws Exception {
		try {
			String desiredCaps = localDir + "//utilityfiles//desiredCapibility.properties";
			DesiredCapabilities capabilities = new DesiredCapabilities();
			String browser = FileReaderUtil.readPropertiesFile(desiredCaps, "browser").toLowerCase();
			switch (browser) {
			case "chrome": {
				System.setProperty("webdriver.chrome.driver", localDir + "//drivers//chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				options.merge(capabilities);
				driver = new ChromeDriver(options);
				logger.log(LogStatus.PASS, "Driver Created for Chrome", "launchApp");
				break;
			}

			case "firefox": {
				System.setProperty("webdriver.gecko.driver", localDir + "//drivers//geckodriver.exe");
				driver = new FirefoxDriver();
				logger.log(LogStatus.PASS, "Driver Created for Firefox", "launchApp");
				break;
			}
			case "ie":
				System.setProperty("webdriver.ie.driver", localDir + "//drivers//IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: ");
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(FileReaderUtil.readPropertiesFile(desiredCaps, "homePage"));
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Exception occured in launching app " + e);
			throw new Exception("Exception occured in launching app " + e);
		}
	}

	/**
	 * Starts reports.
	 * 
	 * @throws Exception
	 */
	@BeforeTest
	public void startReport() throws Exception {
		try {
			Calendar cal = Calendar.getInstance();
			extent = new ExtentReports(System.getProperty("user.dir") + "/ExtentReport/SelJavaProjectReport__"
					+ cal.getTime().toString().replace(" ", "").replace(":", "_") + ".html", true);
			extent.addSystemInfo("Environment", "Test Environment");
			extent.addSystemInfo("Host Name", System.getProperty("hostname")).addSystemInfo("Environment", "Automation Testing")
					.addSystemInfo("User Name", "Pakshi");
			extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
		} catch (Exception e) {
			throw new Exception("Starting report failed " + e);
		}
	}

	/**
	 * Logs status of test after execution.
	 * 
	 * @param result
	 * @throws Exception
	 */
	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
			String screenshotPath = Common.getScreenshot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		}
		extent.endTest(logger);
	}

	/**
	 * resets logger instance.
	 * 
	 * @throws Exception
	 */
	@AfterTest
	public void endReport() throws Exception {
		try {
			extent.flush();
			extent.close();
			closeAppAndEndSession();
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failed to close Report" + e);
			throw new Exception("Failed to close Report" + e);
		}
	}

	/**
	 * Closes app instance and driver.
	 * 
	 * @throws Exception
	 */
	public void closeAppAndEndSession() throws Exception {
		try {
			driver.quit();
			logger.log(LogStatus.PASS, "Closed app");
		} catch (Exception e) {
			throw new Exception("Failed to close the App " + e);
		}
	}
}
