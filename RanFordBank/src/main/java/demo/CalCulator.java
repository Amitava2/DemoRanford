package demo;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class CalCulator 
{
	public static void main(String[] args) 
	{
		try 
		{
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_WINDOWS);
			
			r.keyRelease(KeyEvent.VK_WINDOWS);
			r.keyPress(KeyEvent.VK_C);
			r.keyPress(KeyEvent.VK_A);
			r.keyPress(KeyEvent.VK_L);
			r.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
			Runtime.getRuntime().exec("E:\\AmitChakraborty\\SeleniumProject\\RanFord\\AutoIT\\Calculator.exe");	
			Thread.sleep(3000);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} finally {
		}
	}
}
