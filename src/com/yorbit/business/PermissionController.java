package com.yorbit.business;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.yorbit.utilities.DriverFactory;

public class PermissionController extends DriverFactory{

	public static void acceptPermission() {
		WebElement continueButton = DriverFactory.mobiledriver.findElement(By.id("continue_button"));
		continueButton.click();
	}
}
