package com.ranFordBank.RanFordBank;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Generic 
{
	WebDriver driver;
	public static void dropDown(WebDriver driver, By prop,String exp)
	{
		Select s= new Select(driver.findElement(prop));
		List<WebElement> options = s.getOptions();
		for (WebElement op : options) 
		{
			String actualText = op.getText();
			if(actualText.contains(exp))
			{
				s.selectByVisibleText(exp);
				break;
			}
		}

	}
	/*public static Select dropDown2(WebDriver driver, By prop)
	{
		Select s= new Select(driver.findElement(prop));
		
		return s;
	}*/
	public static Alert alrtPopup(WebDriver driver)
	{
		Alert a = driver.switchTo().alert();
		return a;
		
	}
	
}
