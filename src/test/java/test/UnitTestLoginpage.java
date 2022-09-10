package test;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import common.WebDriverFactory;

public class UnitTestLoginpage {
	 static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
							//System.setProperty("webdriver.chrome.driver", "C:\\selenium\\driver105\\chromedriver.exe");
				 	DesiredCapabilities cap=new DesiredCapabilities();
				 	cap.setBrowserName("chrome");
				 	cap.setVersion("105");
				 	cap.setPlatform(Platform.WIN10);
				 	Thread.sleep(300);
				
					try {
						driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/"),cap);
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				
		
		//System.setProperty("webdriver.chrome.driver", "C:\\selenium\\driver104\\chromedriver.exe");
		//C:\\selenium\\driver104\\chromedriver.exe

		//ChromeDriver driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		Thread.sleep(3000);
	
		List<WebElement> link =driver.findElements(By.tagName("a"));
		for(WebElement a:link)
		{
			System.out.println("links"+a.getAttribute("href"));
			a.click();
			System.out.println(driver.getTitle());
       
		}
		String currentwindow=driver.getWindowHandle();
		
		Set<String> allOpenWindowByDriver=driver.getWindowHandles();
		for(String s:allOpenWindowByDriver)
		{
			if(!currentwindow.contains(s))
			{
			System.out.println(driver.getWindowHandles());
			driver.switchTo().window(s);
			System.out.println(driver.getTitle());
			driver.close();
			}
			
       
		}
		driver.switchTo().window(currentwindow);
		System.out.println("i am on main"+driver.getTitle());
		//driver.navigate().
       driver.quit();

	}

}
