package com.yorbit.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class NewUserRegistrationPage {
	WebDriver driver;
	String se = "";

	public NewUserRegistrationPage(WebDriver driver) {
		this.driver = (WebDriver) driver; 
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	
	@FindBy(css = "input[name='firstName']")
	public WebElement txtBoxFirstName;
	
	@FindBy(css = "input[name='lastName']")
	public WebElement txtBoxLastName;
	
	@FindBy(css = "input[name='phone']")
	public WebElement txtBoxPhone;
	
	@FindBy(css = "input[name='userName'],input[name='email']")
	public WebElement txtBoxEmail;
	
	@FindBy(css = "input[name='address1']")
	public WebElement txtBoxAddress1;
	
	@FindBy(css = "input[name='address2']")
	public WebElement txtBoxAddress2;
	
	@FindBy(css = "input[name='city']")
	public WebElement txtBoxCity;
	
	@FindBy(css = "input[name='state']")
	public WebElement txtBoxState;
	

	@FindBy(css = "input[name='postalCode']")
	public WebElement txtBoxPostalCode;
	
	@FindBy(css = "input[name='country']")
	public WebElement ddCountry;
	
	@FindBy(css = "input[name='userName']")
	public WebElement txtBoxUserName;
	
	@FindBy(css = "input[name='password']")
	public WebElement txtBoxPwd;
	
	@FindBy(css = "input[name='confirmPassword']")
	public WebElement txtBoxCnfrmPwd;
	
	@FindBy(css = "input[name='register']")
	public WebElement btnRegister;
	
	@FindBy(css = "a[href='mercurywelcome.php']")
	public WebElement registrationSuccessSigninLink;
	
	@FindBy(css = "[src='images/profile_submit.gif']")
	public WebElement submitEditProfile;
	
	
}
