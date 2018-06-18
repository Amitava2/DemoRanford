package com.ranFordBank.RanFordBank;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import excel.ExcelDataDriven;

public class TestExecution extends Repository
{
	@Parameters("browser")
	@BeforeTest
	public void varify_launch(String browser)
	{
		openApplication(browser);
	}
	
	@Test(priority=1)
	public void verify_Login() throws InterruptedException
	{
		login();
	}
	/*@Test(priority=3,dataProvider="branches")

	public void verify_NewBranch(String bname,String address,String zipcode,
			String country,String state, String city) throws InterruptedException 
	{

		createBranch(bname,address,zipcode, country, state, city);
	}

	@DataProvider(name="branches")
	public String[][] varify_excelcontent(){
		return excelcontent("excel.xls", "Sheet1");
	}*/
	
	@Test(priority=2)
	public void varify_excelcontent(String browser) throws InterruptedException
	{
		try
		{
			ExcelDataDriven.excelconnection("excel.xls", "Sheet1");

			ExcelDataDriven.outputexcelconnection("excel.xls", "output.xls", "Sheet1");

			int c=ExcelDataDriven.ccount();
			for(int r=1;r<ExcelDataDriven.rcount();r++)
			{
				createBranch(ExcelDataDriven.readdata(0, r), ExcelDataDriven.readdata(1, r), ExcelDataDriven.readdata(2, r), ExcelDataDriven.readdata(3, r), ExcelDataDriven.readdata(4, r), ExcelDataDriven.readdata(5, r));
				String text=Generic.alrtPopup(driver).getText();
				Generic.alrtPopup(driver).accept();

				if(text.contains("created Sucessfully"))
				{
					ExcelDataDriven.writedata(c++, r, "Test Passed");
					c--;
				}
				else if(text.contains("Already Exits"))
				{
					ExcelDataDriven.writedata(c++, r, "Test Failed");
					c--;
				}
				else
				{
					ExcelDataDriven.writedata(c++, r, "alert is not present");
					c--;
				}
			}
			ExcelDataDriven.saveworkbook();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	/*@Test(priority=2)
	public void verify_NewBranch() throws InterruptedException
	{
		createBranch();
	}

	@Test(priority=3)
	public void varift_update_Branch() throws InterruptedException
	{
		update_Branch();
	}
	 */
	@Parameters("browser")
	@Test(priority=3 )
	public void varify_NewRole(String browser) throws InterruptedException
	{
		try
		{
			ExcelDataDriven.excelconnection("excel.xls", "Sheet2");

			ExcelDataDriven.outputexcelconnection("excel.xls", "output.xls", "Sheet2");

			int c=ExcelDataDriven.ccount();
			for(int r=1;r<ExcelDataDriven.rcount();r++)
			{
				new_Role(ExcelDataDriven.readdata(0, r), ExcelDataDriven.readdata(1, r), ExcelDataDriven.readdata(2, r));
				String text=Generic.alrtPopup(driver).getText();
				Generic.alrtPopup(driver).accept();

				if(text.contains("created successufully"))
				{
					ExcelDataDriven.writedata(c++, r, "Test Passed");
					c--;
				}
				else if(text.contains("Already Exits"))
				{
					ExcelDataDriven.writedata(c++, r, "Test Failed");
					c--;
				}
				else
				{
					ExcelDataDriven.writedata(c++, r, "alert is not present");
					c--;
				}
			}
			ExcelDataDriven.saveworkbook();
		} 

		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}
	/*@Test(priority=5)
	public void varify_Update_Role() throws InterruptedException
	{
		update_Role();
	}
	@Test(priority=6)
	public void varify_Employee() throws Exception 
	{
		new_Employee();
	}


	@Test(priority=8)
	public void varify_Update_Employee() throws InterruptedException
	{
		update_Employee();
	}*/
	/*@Test(priority=7) 
	public void logout_Emp() throws InterruptedException
	{
		emp_Logout();
	}
	 */
	@Parameters("browser")
	@AfterTest
	public void closeApplication()
	{
		try 
		{
			Thread.sleep(3000);
			driver.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}



