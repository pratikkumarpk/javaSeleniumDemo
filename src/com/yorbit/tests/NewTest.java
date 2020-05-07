package com.yorbit.tests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.yorbit.business.PermissionController;
import com.yorbit.page.PermissionPage;
import com.yorbit.utilities.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class NewTest extends BaseTest{
  @Test
  public void f() throws IOException {
	  beforeTest( );
	  //PermissionPage pp = PageFactory.initElements(mobiledriver,PermissionPage.class);
	  PermissionPage pp = new PermissionPage((AndroidDriver<MobileElement>) mobiledriver);
	  pp.clickOncontinueButton();
	 
		/*
		 * PermissionController con = new PermissionController();
		 * con.acceptPermission();
		 */
  }
}
