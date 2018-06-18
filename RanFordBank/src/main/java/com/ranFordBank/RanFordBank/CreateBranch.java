package com.ranFordBank.RanFordBank;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import base.BaseTest;

public class CreateBranch extends BaseTest
{
	public static WebElement branches(WebDriver driver )
	{
		return driver.findElement(getlocator("Branches"));
	}
	public static WebElement new_Branches(WebDriver driver)
	{
		return driver.findElement(getlocator("NewBranches"));
	}
	public static WebElement branch_Name(WebDriver driver)
	{
		return driver.findElement(getlocator("BranchName"));
	}
	public static WebElement address1(WebDriver driver)
	{
		return driver.findElement(getlocator("Address1"));
	}
	/*public static WebElement address2(WebDriver driver)
	{
		return driver.findElement(getlocator("Address2"));
	}
	public static WebElement address3(WebDriver driver)
	{
		return driver.findElement(getlocator("Address3"));
	}*/
	public static WebElement area(WebDriver driver)
	{
		return driver.findElement(getlocator("Area"));
	}
	public static WebElement zipCode(WebDriver driver)
	{
		return driver.findElement(getlocator("ZipCode"));
	}
	public static WebElement submit(WebDriver driver)
	{
		return driver.findElement(getlocator("CreateBranchSubmit"));
	}

}
