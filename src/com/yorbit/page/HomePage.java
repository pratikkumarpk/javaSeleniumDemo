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

public class HomePage {
	
	WebDriver driver;
	String se = "";

	public HomePage(WebDriver driver) {
		this.driver = (WebDriver) driver; 
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	
	@FindBy(css = ".mouseOut")
	public WebElement homeLabel;
	
	@FindBy(xpath = "//a[text()='Home']")
	public WebElement homeLink;
	
	@FindBy(xpath = "//a[text()='SIGN-ON']")
	public WebElement signOnLink;
	
	@FindBy(xpath = "//a[text()='REGISTER']")
	public WebElement registerLink;
	
	@FindBy(xpath = "//a[text()='Flights']")
	public WebElement flightsLink;
	
	@FindBy(xpath = "//a[text()='Hotels']")
	public WebElement hotelsLink;
	
	@FindBy(xpath = "//a[text()='Car Rentals']")
	public WebElement carRentalLink;
	
	@FindBy(xpath = "//a[text()='Cruises']")
	public WebElement cruisesLink;
	
	
	
}
