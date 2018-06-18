package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SearchRolId 
{
	public static WebDriver  driver;
	public static boolean status=false;

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver", ".\\Driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://183.82.100.55/ranford1/home.aspx");
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		driver.findElement(By.name("txtPword")).sendKeys("Admin");
		driver.findElement(By.id("login")).click();
		driver.findElement(By.xpath("//a[@href='Admin_Roles_details.aspx']")).click();
		SearchRolId.search_Roleid();
		driver.close();
	}
	public  static void search_Roleid()
	{
		WebElement table = driver.findElement(By.id("DGRoles"));
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
					search_Roleid();
				}

				table = driver.findElement(By.id("DGRoles"));
				rows = table.findElements(By.tagName("tr"));
				for (WebElement r : rows) {
					List<WebElement> colums = r.findElements(By.tagName("td"));
					for (WebElement c : colums)
					{
						String cellvalue = c.getText();
						if (cellvalue.contains("10")) 
						{
							table.findElement(By.xpath("//*[@id='DGRoles']/tbody/tr[5]/td[4]/a/img")).click();
						}
					}
				}
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		/*int rowSize = rows.size();
  			System.out.println("Total Number of Row:" +rowSize);
  			for (WebElement rowElement : rows) 
  				{
					String text = rowElement.getText();
					System.out.println(text);
				}
		 */
	}
}
