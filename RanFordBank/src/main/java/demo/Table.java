package demo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Table 
{
	public static WebDriver driver;
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.geck.driver", ".//driver//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://183.82.100.55/ranford1/home.aspx");
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		driver.findElement(By.name("txtPword")).sendKeys("Admin");
		driver.findElement(By.id("login")).click();
		driver.findElement(By.xpath("//a[@href='admin_banker_master.aspx']")).click();		
		Table.tableupdate();
		
		driver.close();
	}
	public static void tableupdate()
	{
		//*[@id="DG_bankdetails"]/tbody/tr[2]/td[1]
		//*[@id="DG_bankdetails"]/tbody/tr[3]/td[1]
		//*[@id="DG_bankdetails"]/tbody/tr[4]/td[1]
		//*[@id="DG_bankdetails"]/tbody/tr[5]/td[1]
		//*[@id="DG_bankdetails"]/tbody/tr[6]/td[1]
		
		try {
			String  before_xpath="//*[@id='DG_bankdetails']/tbody/tr[";
			String afte_xpath="]/td[1]";
			for(int i=2;i<=6;i++)
			{
				String branchId = driver.findElement(By.xpath(before_xpath + i + afte_xpath)).getText();
				System.out.println("BranchID are " + branchId);
				if(branchId.contains("5"))
				{
					driver.findElement(By.xpath("//*[@id='DG_bankdetails']/tbody/tr[4]/td[7]/a/img")).click();
				}
			}
			driver.findElement(By.id("btnupdate")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
 