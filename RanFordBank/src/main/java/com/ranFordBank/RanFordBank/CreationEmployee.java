package com.ranFordBank.RanFordBank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BaseTest;

public class CreationEmployee extends BaseTest 
{
	public static WebElement employee_cre(WebDriver driver)
	{
		return driver.findElement(getlocator("Employeeo"));
	}
	public static WebElement newEmployee_crea(WebDriver driver)
	{
		return driver.findElement(getlocator("NewEmployees"));
	}
	public static WebElement employer_Name(WebDriver driver)
	{
		return driver.findElement(getlocator("EmployerName"));
	}
	public static WebElement login_Password(WebDriver driver)
	{
		return driver.findElement(getlocator("LoginPassword"));
	}
	public static WebElement emp_submit(WebDriver driver)
	{
		return driver.findElement(getlocator("EmployeeCrationSubmit"));
	}
}
