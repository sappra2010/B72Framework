package generic;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.openqa.selenium.By;

public class Util {
	public static String getProperty(String path,String key)
	{
		String value="";
		try 
		{
			Properties p=new Properties();
			p.load( new FileInputStream(path));
			value=p.getProperty(key);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return value;
	}
	public static String getTimeStamp()
	{
		 LocalDateTime currentDateTime = LocalDateTime.now();
	     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
	     String formattedDateTime = currentDateTime.format(formatter);
	     return formattedDateTime;
	}
	
	public static String getLocatorDetails(By by)
	{
		String msg="";
		try 
		{
			String FQCN = by.getClass().getCanonicalName();
			String locator=FQCN.split("By")[2];
			Field[] allF = by.getClass().getDeclaredFields();
			allF[0].setAccessible(true);
			String locatorValue = allF[0].get(by).toString();
			msg=locator+" as "+locatorValue;
		}
		catch (Exception e)
		{
		
		}
		return msg;
	}
}
