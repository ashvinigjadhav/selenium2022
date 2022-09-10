package assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/******************************************************************************************
***********
Question : How to navigate within the browser ?
Answer : Using navigate() methods.

/******************************************************************************************/
public class BrowserNavigationExample {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\selenium\\driver105\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
//Enter the url
driver.get("D://SELENIUM/A1.HTML");
Thread.sleep(3000);
driver.navigate().to("D://SELENIUM/A2.HTML");
Thread.sleep(3000);
driver.navigate().back();
Thread.sleep(3000);
driver.navigate().forward();
driver.navigate().to("D://SELENIUM/A1.HTML");
Thread.sleep(3000);
driver.navigate().refresh();
driver.close();
}
}
