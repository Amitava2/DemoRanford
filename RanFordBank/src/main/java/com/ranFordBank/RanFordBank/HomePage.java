package com.ranFordBank.RanFordBank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BaseTest;

public class HomePage extends BaseTest
{
	public static WebElement UserName_text(WebDriver driver)
	{
		return driver.findElement(getlocator("username"));
	}
	public static  WebElement PassWord_text(WebDriver driver)
	{
		return driver.findElement(getlocator("password"));
	}
	public static WebElement Login_Btn(WebDriver driver)
	{
		return driver.findElement(getlocator("Login"));
	}
	
}
