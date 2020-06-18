package com.yorbit.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {
	WebDriver driver;
	String se = "";

	public LoginPage(WebDriver driver) {
		this.driver = (WebDriver) driver; 
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	}
	
	@FindBy(css = "input[name='userName']")
	public WebElement txtBoxUserName;
	
	@FindBy(css = "input[name='password']")
	public WebElement txtBoxPassword;
	
	@FindBy(css = "input[name='login']")
	public WebElement btnLogin;
	

}
