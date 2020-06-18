/**
 * @author Pakshi
 *
 */
package com.yorbit.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SelectFlight {
	
	WebDriver driver;
	String se = "";

	public SelectFlight(WebDriver driver) {
		this.driver = (WebDriver) driver; 
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	
	@FindBy(css = "input[name = 'reserveFlights']")
	public WebElement btnContinue;
	
	
}
