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

public class FlightFinderPage {
	
	WebDriver driver;
	String se = "";

	public FlightFinderPage(WebDriver driver) {
		this.driver = (WebDriver) driver; 
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	
	@FindBy(css = "input[name = 'tripType'][value='oneway']")
	public WebElement radioOneWay;
	
	@FindBy(css = "input[name = 'tripType'][value='roundtrip']")
	public WebElement radioRoundTrip;
	
	@FindBy(css = "[name='passCount']")
	public WebElement passCountDD;
	
	@FindBy(css = "[name='fromPort']")
	public WebElement fromPortDD;
	
	@FindBy(css = "[name='toPort']")
	public WebElement toPortDD;
	
	@FindBy(css = "[name='fromMonth']")
	public WebElement fromMonthDD;
	
	@FindBy(css = "[name='fromDay']")
	public WebElement fromDayDD;
	
	@FindBy(css = "[name='toMonth']")
	public WebElement toMonthDD;
	
	@FindBy(css = "[name='toDay']")
	public WebElement toDayDD;
	
	@FindBy(css = "[name='servClass'][value='Coach']")
	public WebElement radioEconomy;
	
	@FindBy(css = "[name='servClass'][value='Business']")
	public WebElement radioBusiness;
	
	@FindBy(css = "[name='servClass'][value='First']")
	public WebElement radioFirst;
	
	@FindBy(css = "[name='findFlights']")
	public WebElement btnFindFLight;
	
	@FindBy(xpath = "//a[text()='PROFILE']")
	public WebElement linkEditProfile;
	
	@FindBy(xpath = "//a[text()='ITINERARY']")
	public WebElement linkItinerary;
			
	
	
	
}
