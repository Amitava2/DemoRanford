package demo;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SerachBranchId 
{
	public static boolean status = false;
	static WebDriver driver;
	public static void operation() 
	{
		WebElement table = driver.findElement(By.id("DG_bankdetails"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		String[] pageLinks = rows.get(rows.size() - 1).getText().split(" ");
		try {
			for (int i = 1; i < pageLinks.length; i++) 
			{
				if (pageLinks[i].contains("...") && status == true) 
				{
					driver.findElement(By.xpath("//a[text()='...'][2]")).click();
				} else {
					table.findElement(By.linkText(pageLinks[i])).click();
				}
				if (pageLinks[i].contains("...")) 
				{
					status = true;
					operation();
				}

				table = driver.findElement(By.id("DG_bankdetails"));
				rows = table.findElements(By.tagName("tr"));
				for (WebElement r : rows) {
					List<WebElement> colums = r.findElements(By.tagName("td"));
					for (WebElement c : colums)
					{
						String cellvalue = c.getText();
						if (cellvalue.contains("27")) 
						{
							table.findElement(By.xpath("//*[@id='DG_bankdetails']/tbody/tr[3]/td[7]/a/img")).click();
							table.findElement(By.id("btnupdate")).click();
						}
					}
				}
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		try 
		{
			System.setProperty("webdriver.gecko.driver", ".\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get("http://183.82.100.55/ranford1/home.aspx");
			driver.findElement(By.id("txtuId")).sendKeys("Admin");
			driver.findElement(By.name("txtPword")).sendKeys("Admin");
			driver.findElement(By.id("login")).click();
			driver.findElement(By.xpath("//a[@href='admin_banker_master.aspx']")).click();
			SerachBranchId.operation();

			driver.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
