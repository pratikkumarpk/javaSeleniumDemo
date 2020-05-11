package com.yorbit.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WebAppPage  {
	
	AndroidDriver<MobileElement> driver;

	public WebAppPage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@FindBy(xpath = "//input[@name='first_name']")
	MobileElement txtBoxFN;

	public void enterFirstName(String userName) {
		txtBoxFN.clear();
		txtBoxFN.sendKeys(userName);
	}
	
	@FindBy(xpath = "//input[@name='last_name']")
	MobileElement txtBoxLN;

	public void enterlastName(String lastName) {
		txtBoxLN.clear();
		txtBoxLN.sendKeys(lastName);
	}
	
	@FindBy(xpath = "//input[@name='email']")
	MobileElement txtEmail;

	public void enterEmail(String email) {
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	@FindBy(xpath = "//*[@name='message']")
	MobileElement txtBoxMsg;

	public void enterComments(String msg) {
		txtBoxMsg.clear();
		txtBoxMsg.sendKeys(msg);
	}

	@FindBy(xpath = "//*[@value='SUBMIT']")
	MobileElement btnContactUs;

	public void clickContactUsButton() {
		btnContactUs.click();
	}
	
	@FindBy(xpath = "//*[@id='contact_reply']")
	MobileElement success;

	public boolean verifySuccessMsg() {
		return success.isDisplayed();
	}
	
	public MobileElement getSuccessLocator() {
		return success;
	}
}
