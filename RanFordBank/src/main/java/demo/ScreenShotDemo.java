package demo;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScreenShotDemo 
{
	public static 	WebDriver  driver;
	public static void main(String[] args) 
	{
		try
		{
			System.setProperty("webdriver.gecko.driver", "E:\\AmitChakraborty\\SeleniumProject\\RanFord\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get("http://183.82.100.55/ranford1/home.aspx");
			ScreenShotDemo.takeScreeenShotDemo("LoginPage");
			Thread.sleep(3000);
			driver.close();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	public static void takeScreeenShotDemo(String fileName)
	{
		try 
	{
		//1. Taake screenshot store a file
		File file= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		//2. Now copy the Screen shot into Desire Location using copyFile Method
			FileUtils.copyFile(file, new File("E:\\AmitChakraborty\\SeleniumProject\\RanFord\\ScreenShot\\" +fileName+ ".png"));
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}	
} 
