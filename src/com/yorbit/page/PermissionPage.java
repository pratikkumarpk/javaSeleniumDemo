/**
 * @author Pakshi
 *
 */
package com.yorbit.page;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PermissionPage {
	
	AndroidDriver<MobileElement> driver;

	public PermissionPage(AndroidDriver<MobileElement> driver) {
		this.driver = driver; 
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.android.permissioncontroller:id/continue_button")
	MobileElement continueButton;
	
	public void clickOncontinueButton() { 
		continueButton.click(); 
    }

}
