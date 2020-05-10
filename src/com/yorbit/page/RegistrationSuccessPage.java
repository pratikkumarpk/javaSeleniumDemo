package com.yorbit.page;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RegistrationSuccessPage {
	
	AndroidDriver<MobileElement> driver;

	public RegistrationSuccessPage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "io.selendroid.testapp:id/label_name_data")
	MobileElement lblName;

	public String getlblName() {
		return lblName.getText().toLowerCase();
	}
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/label_username_data")
	MobileElement lblUserName;

	public String getlbluserName() {
		return lblUserName.getText().toLowerCase();
	}
	@AndroidFindBy(id = "io.selendroid.testapp:id/label_password_data")
	MobileElement lblPwd;

	public String getlblPwd() {
		return lblPwd.getText().toLowerCase();
	}
	@AndroidFindBy(id = "io.selendroid.testapp:id/label_email_data")
	MobileElement lblemail;

	public String getlblEmail() {
		return lblemail.getText().toLowerCase();
	}
	@AndroidFindBy(id = "io.selendroid.testapp:id/label_preferedProgrammingLanguage_data")
	MobileElement lblLang;

	public String getlblLang() {
		return lblLang.getText().toLowerCase();
	}

}
