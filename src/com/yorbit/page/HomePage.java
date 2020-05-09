package com.yorbit.page;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {
	
	AndroidDriver<MobileElement> driver;

	public HomePage(AndroidDriver<MobileElement> driver) {
		this.driver = driver; 
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/startUserRegistration")
	MobileElement btnRegisterNewUser;
	
	public void clickOnNewUserregistrationButton() { 
		btnRegisterNewUser.click(); 
    }


}
