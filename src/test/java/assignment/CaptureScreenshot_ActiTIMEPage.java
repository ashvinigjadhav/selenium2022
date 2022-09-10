package assignment;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.Duration;
//import java.util.logging.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IInvokedMethodListener;
import org.testng.annotations.Test;

import common.WebDriverFactory;


public class CaptureScreenshot_ActiTIMEPage  {
	
@Test
	public  void CaptureScreenshot() throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\driver105\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
//Creating an object of Date class
		Date d = new Date(0);
//Printing the actual date
		String date1 = d.toString();
		System.out.println(date1);
//replacing the colon present in the date timestamp format to "_" using replaceAll()
//method of String class
		String date2 = date1.replaceAll(":", "_");
		System.out.println(date2);
//Enter the url

		
		driver.get("https://www.orangehrm.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Thread.sleep(100);
		WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, Duration.ofSeconds(3));
		//wait .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),' Login ')]")));
		  
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Username : Admin')]")));

		//Typecasting the driver object to TakesScreenshot interface type.
		TakesScreenshot ts = (TakesScreenshot) driver;
//getting the source file using getScreenshotAs() method and storing in a file
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		/*
		 * Created a folder called "screenshot" in the project directory Created another
		 * file by concatenating the date value which has "_" in it (Underscore is the
		 * accepted character while creating a file in the project )
		 */
		File destFile = new File("D:\\SELENIUM\\screenshot\\" + date2 + "__actiTIMELoginPage.png");
		/*
		 * copyFile() method is a static method present in FileUtils class of JAVA
		 * storing the screenshot in the destination location
		 */
		FileHandler.copy(srcFile, destFile); 
		
//closing the browser
		driver.close();
	}
}