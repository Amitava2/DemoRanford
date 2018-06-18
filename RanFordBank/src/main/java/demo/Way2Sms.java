/*package demo;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Way2Sms
{
	public static WebDriver driver;
	public static void main(String[] args)
	{
		try
		{
			System.setProperty("webdriver.gecko.driver", "E:\\AmitChakraborty\\SeleniumProject\\com.ran\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get("http://www.way2sms.com/content/index.html?");
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			Thread.sleep(3000);
			Way2Sms.operationWay2sms();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	public static void operationWay2sms()
	{
		driver.findElement(By.xpath("//a[@href='http://bit.ly/way2smss']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("All Windows Handles Id: " +windowHandles);

		Iterator<String> iterator = windowHandles.iterator();
		String parentWindowhandle = iterator.next();
		System.out.println("Parent window Handle Id: " +parentWindowhandle);

		String childWindowhandle = iterator.next();
		System.out.println(" Child Window Handle id: " +childWindowhandle);
		driver.switchTo().window(childWindowhandle);
		String childWindowhandleTitle = driver.getTitle();
		System.out.println("Title ChildWindow " +childWindowhandleTitle);
		driver.close();

		driver.switchTo().window(parentWindowhandle);
		String parentWindowhandletitle = driver.getTitle();
		System.out.println("Title ParentWindow " +parentWindowhandletitle);
		 

		ArrayList<String> list = new ArrayList<>(windowHandles);
		driver.switchTo().window(list.get(1));
		String childWindowhandleTitle = driver.getTitle();
		System.out.println("Title ChildWindow " +childWindowhandleTitle);
		driver.findElement(By.xpath("//a[(text()='About Google')]")).click();
		driver.close();
		String subchildtitle = driver.getTitle();
		System.out.println(" SubChild Title " +subchildtitle);
		driver.switchTo().window(list.get(2));
		driver.close();
		driver.switchTo().window(list.get(0));
		String parentWindowhandletitle = driver.getTitle();
		System.out.println("Title ChildWindow " +parentWindowhandletitle);
		driver.close();

	}

}
*/