package table;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import base.BaseTest;

public class WebTable extends BaseTest 
{
	static boolean status = false;

	public static void operation(WebDriver driver, By p, String action, String id)

	{
		try 
		{
			boolean flag = false;

			WebElement table = driver.findElement(p);
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			String[] pageLinks = rows.get(rows.size() - 1).getText().split(" ");

			for (int i = 1; i < pageLinks.length; i++) 
			{
				try {
					if (pageLinks[i].contains("...") && status == true) 
					{
						driver.findElement(getlocator("NextPage")).click();
					}

					else
					{
						table.findElement(By.linkText(pageLinks[i])).click();
					}
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
				if (pageLinks[i].contains("...")) 
				{
					status = true;
					operation(driver, p, action, id);
				}

				table = driver.findElement(p);
				rows = table.findElements(By.tagName("tr"));
				for (WebElement r : rows) 
				{
					List<WebElement> colums = r.findElements(By.tagName("td"));
					for (WebElement c : colums) 
					{
						if (c.getText().matches(id))
						{
							if (action.equalsIgnoreCase("edit")) 
							{
								colums.get(colums.size() - 2).findElement(By.tagName("a")).click();
								Thread.sleep(3000);
							} 
							else if (action.equalsIgnoreCase("delete")) 
							{
								colums.get(colums.size() - 1).findElement(By.tagName("a")).click();
								Thread.sleep(3000);
							} else 
							{
								Reporter.log("Operation is Failed");
							}
							flag = true;
							break;
						}
					}
					if (flag == true) 
					{
						break;
					}
				}
				if (flag == true) 
				{
					break;
				}
			}
		}

		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}
