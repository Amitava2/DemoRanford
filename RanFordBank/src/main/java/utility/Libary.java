package utility;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class Libary 
{
	public static void screenshort(String name)
	{
		try 
		{
			Robot r =new Robot();
			//Taking Screenshots of alert Pop Up and the Failed script and Storing it.
			//Into the Temporary Palce
			//Called bufferedImage(bi)
			BufferedImage bi=r.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			//Moving the screenShots from source to destination of png format.
			ImageIO.write(bi, "png", new File("E:\\AmitChakraborty\\SeleniumProject\\RanFordBank\\ScreenShots\\"+name+".png"));
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public static void attachment(String name)
	{
		screenshort(name);
		EmailAttachment email= new EmailAttachment();
		email.setPath("E:\\AmitChakraborty\\SeleniumProject\\RanFordBank\\ScreenShots\\"+name+".png");
		email.setDescription(EmailAttachment.ATTACHMENT);
		email.setDescription("failed ScreenShot of Branch Creation");
		email.setName("screenshort");
		MultiPartEmail memail= new MultiPartEmail();
		try 
		{
			memail.setAuthenticator(new DefaultAuthenticator("amitava18testing@gmail.com", "amitavashine1818"));
			memail.setHostName("smtp.gmail.com");
			memail.setSmtpPort(465);
			memail.setSSLOnConnect(true);
			memail.setFrom("amitava18testing@gmail.com");
			memail.setSubject("Failutre ScreenShot");
			memail.setMsg("Kindly check this Information");
			memail.addTo("amitava2testing@gmail.com");
			memail.attach(email);
			memail.send();
		} 
		catch (EmailException e) 
		{
			e.printStackTrace();
		}

	}
}