package com.ranFordBank.RanFordBank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BaseTest;

public class LogoutEmp extends BaseTest
{
	public static WebElement logout(WebDriver driver)
	{
		return driver.findElement(getlocator("LogoutEmployee"));
	}
}
