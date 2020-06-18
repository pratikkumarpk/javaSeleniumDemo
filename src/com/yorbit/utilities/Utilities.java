package com.yorbit.utilities;import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Utilities {
	/**
	 * Clicks on element
	 * @param logger
	 * @param ele
	 */
	public static void clickOnElement(ExtentTest logger,WebElement ele) {
		ele.click();
		logger.log(LogStatus.INFO, "Clicked on the "+ele.toString());
		
	}
	/**
	 * Send keys in element.
	 * @param logger
	 * @param ele
	 * @param value
	 * @throws Exception
	 */
	public static void inputText(ExtentTest logger,WebElement ele,String value) throws Exception {
		if(value!=null) {
			ele.sendKeys(value);
			}else {
				throw new Exception("Value is null");
			}
		
		logger.log(LogStatus.INFO, "Eneterd  "+value +"  in the element :"+ele);
	}
	/**
	 * Select value from Drop Down.
	 * @param logger
	 * @param ele
	 * @param value
	 */
	public static void selectFromDropDownByValue(ExtentTest logger,WebElement ele,String value) {
		Select dd = new Select(ele);
		dd.selectByValue(value);
		logger.log(LogStatus.INFO, "Selected  "+value+ "  from the dropdown");
	}

}
