package com.ranFordBank.RanFordBank;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BaseTest;

public class CreationNewRole extends BaseTest
{
	public static WebElement roles(WebDriver driver)
	{
		return driver.findElement(getlocator("RolesCrea"));
	}
	public static WebElement new_Roles(WebDriver driver)
	{
		return driver.findElement(getlocator("NewRolesCrea"));
	}
	public static WebElement new_Role(WebDriver driver)
	{
		return driver.findElement(getlocator("RoleName"));
	}
	public static WebElement role_Desc(WebDriver driver)
	{
		return driver.findElement(getlocator("RoleDesc"));
	}
	public static WebElement submit(WebDriver driver)
	{
		return driver.findElement(getlocator("CreationRoleSubmit"));
	}
}

