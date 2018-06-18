/*package demo;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
 import org.openqa.selenium.By;
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.firefox.FirefoxDriver;

 public class ExcelDemo   
 {
	 static WebDriver driver;
	 public static Workbook wb ;
	 public static void sheetvalue() 
	 {
		 try 
		 {
			 wb = WorkbookFactory.create(new FileInputStream(".\\RanFord\\Excel\\Login.xlsx"));
			 String branchName = wb.getSheet("Sheet1").getRow(1).getCell(1).toString();
			 System.out.println("BranchName is: " +branchName);
			 String address = wb.getSheet("Sheet1").getRow(1).getCell(2).toString();
			 System.out.println("Address   " +address);
			 String zipCode = wb.getSheet("Sheet1").getRow(1).getCell(3).toString();
			 System.out.println("ZipCode......." +zipCode);
			 String countrry = wb.getSheet("Sheet1").getRow(1).getCell(4).toString();
			 System.out.println("Country Value " +countrry);
			 String state = wb.getSheet("Sheet1").getRow(1).getCell(5).toString();
			 System.out.println("Country Value " +state);
			 String city = wb.getSheet("Sheet1").getRow(1).getCell(6).toString();
			 System.out.println("Country Value " +city);
		 }
		 catch (Exception e) 
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
			 driver.findElement(By.id("BtnNewBR")).click();
			 ExcelDemo.sheetvalue();
			 driver.close();

		 }
		 catch (Exception e) 
		 {
			 e.printStackTrace();
		 }

	 }
 }*/