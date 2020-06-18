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

public class PaxInfoPage {
	
	WebDriver driver;
	String se = "";

	public PaxInfoPage(WebDriver driver) {
		this.driver = (WebDriver) driver; 
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	
	@FindBy(css = "input[name = 'passFirst0']")
	public WebElement txtFN;
	
	@FindBy(css = "input[name = 'passLast0']")
	public WebElement txtLN;
	
	@FindBy(css = "input[name = 'creditnumber']")
	public WebElement txtCardNumber;
	
	@FindBy(css = "select[name = 'cc_exp_dt_mn']")
	public WebElement ddExpMnth;
	
	@FindBy(css = "select[name = 'cc_exp_dt_yr']")
	public WebElement ddExpYear;
	
	@FindBy(css = "input[name = 'cc_frst_name']")
	public WebElement ccFN;
	
	@FindBy(css = "input[name = 'cc_last_name']")
	public WebElement ccLN;
	
	@FindBy(css = "input[name = 'buyFlights']")
	public WebElement buyFlight;
	
}
