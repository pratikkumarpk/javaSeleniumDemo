/**
 * @author Pakshi
 *
 */
package com.yorbit.page;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RegistrationPage {
	AndroidDriver<MobileElement> driver;

	public RegistrationPage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "io.selendroid.testapp:id/inputUsername")
	MobileElement txtBoxUserName;

	public void typeInUserName(String UserName) {
		txtBoxUserName.clear();
		txtBoxUserName.sendKeys(UserName);
	}

	@AndroidFindBy(id = "io.selendroid.testapp:id/inputEmail")
	MobileElement txtBoxEmail;

	public void typeInEmail(String Email) {
		txtBoxEmail.clear();
		txtBoxEmail.sendKeys(Email);
	}

	@AndroidFindBy(id = "io.selendroid.testapp:id/inputPassword")
	MobileElement txtBoxPwd;

	public void typeInPwd(String pwd) {
		txtBoxPwd.clear();
		txtBoxPwd.sendKeys(pwd);
	}

	@AndroidFindBy(id = "io.selendroid.testapp:id/inputName")
	MobileElement txtBoxName;

	public void typeInName(String name) {
		txtBoxName.clear();
		txtBoxName.sendKeys(name);
	}

	@AndroidFindBy(id = "android:id/text1")
	MobileElement dropDLang;

	public void selectFromLangDD(String lang) {
		dropDLang.click();// click on dropdown
		List<MobileElement> options = driver.findElementsById("android:id/text1");
		for (MobileElement ele : options) {
			if (ele.getText().equalsIgnoreCase(lang)) {
				ele.click();
				break;
			}
		}
	}

	@AndroidFindBy(id = "io.selendroid.testapp:id/input_adds")
	MobileElement chkBoxAdds;

	public void selectAcceptCheckBox() {
		chkBoxAdds.click();
	}

	@AndroidFindBy(id = "io.selendroid.testapp:id/btnRegisterUser")
	MobileElement btnRegister;

	public void clcikButtonregister() {
		btnRegister.click();
	}

}
