package base;
import java.io.File;


import java.io.FileReader;
import java.util.Properties;
import org.openqa.selenium.By;

public class BaseTest 
{
	static Properties p;
	public static void loadproperty()
	{
		try 
		{
			File f=new File(System.getProperty("user.dir")+"\\src\\main\\java\\configaration\\OR.properties");
			FileReader fr=new FileReader(f);
			p=new Properties();
			p.load(fr);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 

	}
	public static  By   getlocator(String key)
	{
		loadproperty();
		String elevalue= p.getProperty(key);										
		String loctype=elevalue.split(":")[0];
		String locvalue=elevalue.split(":")[1];

		By loc=null;
		switch(loctype)
		{
		case "id":
			loc=By.id(locvalue);
			break;
		case "name":
			loc=By.name(locvalue);
			break;
		case "tagName":
			loc = By.tagName(locvalue);
			break;
		case "xpath":
			loc = By.xpath(locvalue);
			break;
		}
		return loc;
	}
	public static void loadproperty1()
	{
		try {
			File f=new File(System.getProperty("user.dir")+"\\src\\main\\java\\configaration\\config.properties");
			FileReader fr=new FileReader(f);
			p=new Properties();
			p.load(fr);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
	}
	public static  String   config(String key)
	{
		loadproperty1();
		String elevalue= p.getProperty(key);
		return elevalue;
	}
	public void editOperation() {
		// TODO Auto-generated method stub
		
	}
}
