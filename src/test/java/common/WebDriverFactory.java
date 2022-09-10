package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
	protected static ThreadLocal <WebDriver> threadLoaclStorage= new ThreadLocal<>();//Across thread common //declaration
	
	public static void  setDriver(WebDriver  localDriver)
	{
		//if(driver!=null)
		threadLoaclStorage.set(localDriver);
		
				
	}
	 public static WebDriver getDriver()
	{
	
		return  threadLoaclStorage.get();
	}

}
