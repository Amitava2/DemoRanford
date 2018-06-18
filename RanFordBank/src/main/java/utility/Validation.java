package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Validation 
{
	public static boolean isTextPresent(WebDriver driver, String exp)
	{
		boolean b= driver.findElement(By.tagName("tbody")).getText().contains(exp);
		return  b;
	}
	public static boolean isAlertPresent(WebDriver driver, String exp)
	{
		return driver.switchTo().alert().getText().contains("exp"); 

	}
}
