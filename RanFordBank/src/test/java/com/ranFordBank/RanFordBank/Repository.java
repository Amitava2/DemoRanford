package com.ranFordBank.RanFordBank;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import base.BaseTest;
import excel.ExcelDataDriven;
import utility.Libary;
import utility.Validation;

public class Repository extends BaseTest 
{
	WebDriver driver;
	public void openApplication(String browser) 
	{
		try 
		{
			if(browser.equals("firefox"))
			{
				driver = new FirefoxDriver();
			}
			
			//System.setProperty("webdriver.gecko.driver", ".\\Driver\\geckodriver.exe");

			driver.manage().deleteAllCookies();
			driver.get("http://183.82.100.55/ranford1/home.aspx");
			driver.manage().window().maximize();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		if (Validation.isTextPresent(driver, "Welcome to Personalized Banking")) 
		{
			Reporter.log("launch test pass");
		}
		else 
		{
			Reporter.log("launch test fail");
			Libary.screenshort("launch_fail");
		}

	}

	public void login() 
	{
		
			try 
			{
				HomePage.UserName_text(driver).sendKeys(config("username"));
				HomePage.PassWord_text(driver).sendKeys(config("password"));
				HomePage.Login_Btn(driver).click();

				if (Validation.isTextPresent(driver, "Welcome to Admin")) 
				{
					Reporter.log("login test pass");
				} 
				else
				{
					Reporter.log("login failed");
					Libary.attachment("launch");
				}
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}

		


	}

	public String[][] excelcontent(String filename,String sheetname)
	{
		ExcelDataDriven.excelconnection(filename, sheetname);
		int rc=ExcelDataDriven.rcount();
		int cc=ExcelDataDriven.ccount();
		String[][] data=new String[rc-1][cc];
		for(int r=1;r<rc;r++)
		{
			for(int c=0;c<cc;c++)
			{
				data[r-1][c]=ExcelDataDriven.readdata(c, r);
			}
		}
		return data;


	}

	public void createBranch(String bname, String address,String zipcode,String country,String state, String city ) throws InterruptedException 
	{
		try 
		{
			CreateBranch.branches(driver).click();
			Thread.sleep(3000);
			CreateBranch.new_Branches(driver).click();
			CreateBranch.branch_Name(driver).sendKeys(bname);
			CreateBranch.address1(driver).sendKeys(address);
			/*CreateBranch.address2(driver).sendKeys("address2");
			CreateBranch.address3(driver).sendKeys("address3");*/
			//CreateBranch.area(driver).sendKeys("area");
			CreateBranch.zipCode(driver).sendKeys(zipcode);
			Generic.dropDown(driver, getlocator("Country"), country);
			Thread.sleep(3000);
			Generic.dropDown(driver, getlocator("State"), state);
			Thread.sleep(3000);
			Generic.dropDown(driver, getlocator("City"), city);
			Thread.sleep(3000);
			CreateBranch.submit(driver).click();
			/*if (Validation.isAlertPresent(driver, "created Sucessfully"))
			{
				Reporter.log("Test test pass");
			} 
			else
			{
				Reporter.log("Test  is fail");
				Libary.screenshort("Branch_Creation");
			}

			Generic.alrtPopup(driver).accept();*/
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}

	/*public void update_Branch() throws InterruptedException 
	{
		try 
		{
			WebTable.operation(driver, getlocator("FullTablebranch"), "edit", "27");
			Thread.sleep(3000);
			driver.findElement(By.id("btnupdate")).click();
			Thread.sleep(3000);
			Generic.alrtPopup(driver);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}*/
	public void new_Role(String roleName, String roleDesc,String roleType) throws InterruptedException
	{
		try 
		{
			CreationNewRole.roles(driver).click();
			CreationNewRole.new_Roles(driver).click();
			Thread.sleep(3000);
			CreationNewRole.new_Role(driver).sendKeys(roleName);
			CreationNewRole.role_Desc(driver).sendKeys(roleDesc);
			Generic.dropDown(driver, getlocator("RoleType"),roleType );
			CreationNewRole.submit(driver).click();
			Thread.sleep(3000);
			Generic.alrtPopup(driver).accept();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	/*public void update_Role() throws InterruptedException 
	{
		try 
		{
			WebTable.operation(driver, getlocator("FullRoletable"), "edit", "44");
			Thread.sleep(3000);
			driver.findElement(By.id("btnupdate")).click();
			Thread.sleep(3000);
			Generic.alrtPopup(driver);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}*/
	/*public void new_Employee() throws InterruptedException {
		try 
		{
			CreationEmployee.employee_cre(driver).click();
			CreationEmployee.newEmployee_crea(driver).click();
			Thread.sleep(3000);
			CreationEmployee.employer_Name(driver).sendKeys("Aditia Ddebnth");
			CreationEmployee.login_Password(driver).sendKeys("Aditia Ddebnth");
			Generic.dropDown(driver, getlocator("EmpRole"), "SpeciaalistOfficerXIII");
			Thread.sleep(3000);
			Generic.dropDown(driver, getlocator("EmpBranch"), "BurdWanSEast");
			CreationEmployee.emp_submit(driver).click();
			Thread.sleep(3000);
			Generic.alrtPopup(driver).accept();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
	/*public void update_Employee() throws InterruptedException 
	{
		try 
		{
			WebTable.operation(driver, getlocator("FullEmployeetable"), "edit", "2060");
			Thread.sleep(3000);
			driver.findElement(By.id("btnupdate")).click();
			Thread.sleep(3000);
			Generic.alrtPopup(driver);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}*/
	public void emp_Logout() throws InterruptedException 
	{
		Thread.sleep(3000);
		LogoutEmp.logout(driver).click();

	}


}