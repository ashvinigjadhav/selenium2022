package assignment;


/*
 * java -Dwebdriver.chrome.driver="c:\\selenium\\chromedriver.exe" -jar selenium-server-4.3.0.jar node --detect-drivers false --driver-configuration hub="http://172.20.10.13:4444/grid/register"display-name="chrome" max-sessions=5 stereotype='{"browserName": "chrome", "browserVersion": "105"}'

java -jar selenium-server-4.3.0.jar node --detect-drivers false --driver-configuration display-name="chrome" max-sessions=5 stereotype='{"browserName": "chrome nighty", "browserVersion": "105"}'


java -Dwebdriver.chrome.driver=c:\\selenium\\chromedriver.exe -jar selenium-server-4.3.0.jar node --detect-drivers false --driver-configuration hub="http://172.20.10.13:4443/grid/register" display-name="Chrome Nightly" max-sessions=5 

java -jar selenium-server-4.4.0.jar standalone
 * 
 * 
 */
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumGrid4Demo {
	static WebDriver driver;
	
	@Test
	public void printAllLink() throws InterruptedException {
	// System.setProperty("webdriver.chrome.driver", "C:\\selenium\\driver105\\chromedriver.exe");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setBrowserName("chrome");
			//cap.setVersion("105");
			//cap.setPlatform(Platform.WIN10);
			
			System.out.println("1");
			try {
				driver = new RemoteWebDriver(new URL("http://192.168.1.100:4444/wd/hub"),cap);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("2");
			driver.get("http://127.0.0.1/orangehrm-3.3.1/symfony/web/index.php/auth/login");
			Thread.sleep(3000);
			System.out.println("3");
			List<WebElement> link = driver.findElements(By.tagName("a"));
			for (WebElement a : link) {
				System.out.println("links" + a.getAttribute("href"));
				a.click();
				System.out.println(driver.getTitle());

			}
			driver.quit();

		}

	public static void main(String[] args) throws InterruptedException {
		// System.setProperty("webdriver.chrome.driver", "C:\\selenium\\driver105\\chromedriver.exe");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setVersion("105");
		cap.setPlatform(Platform.WIN10);
		
		System.out.println("1");
		try {
			driver = new RemoteWebDriver(new URL("http://192.168.1.100:4444/wd/hub"),cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("2");
		driver.get("http://127.0.0.1/orangehrm-3.3.1/symfony/web/index.php/auth/login");
		Thread.sleep(3000);
		System.out.println("3");
		List<WebElement> link = driver.findElements(By.tagName("a"));
		for (WebElement a : link) {
			System.out.println("links" + a.getAttribute("href"));
			a.click();
			System.out.println(driver.getTitle());

		}
		driver.quit();

	}
}
