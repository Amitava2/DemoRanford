package com.ranFordBank.RanFordBank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BaseTest;

public class CreationUser extends BaseTest 
{
	public static WebElement users(WebDriver driver)
	{
		return driver.findElement(getlocator("Users"));
	}
	public static WebElement newUser(WebDriver driver)
	{
		return driver.findElement(getlocator("NewUser"));
	}
	public static WebElement customerName(WebDriver driver)
	{
		return driver.findElement(getlocator("CustomerName"));
	}
	public static WebElement userName(WebDriver driver)
	{
		return driver.findElement(getlocator("UserNameUser"));
	}
	public static WebElement loginPassword(WebDriver driver)
	{
		return driver.findElement(getlocator("LoginPassword"));
	}
	public static WebElement transactionPassword(WebDriver driver)
	{
		return driver.findElement(getlocator("TransactionPassword"));
	}
	public static WebElement submit(WebDriver driver)
	{
		return driver.findElement(getlocator("NewUserSubmit"));
	}


}
