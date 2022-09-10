package common;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;


public class InvokedMethodListenerImpl implements IInvokedMethodListener {
		 
		 public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		 
		 System.out.println("Before Invocation of: " + method.getTestMethod().getMethodName() + "of Class:" + testResult.getTestClass());
		// set property
			//System.setProperty("webdriver.chrome.driver", "C:\\selenium\\driver105\\chromedriver.exe");
		 	DesiredCapabilities cap=new DesiredCapabilities();
		 	cap.setBrowserName("chrome");
		 	cap.setVersion("105");
		 	cap.setPlatform(Platform.LINUX);
		 WebDriver dr;
		try {
			dr = new RemoteWebDriver(new URL("http://127.0.0.1:4444/"),cap);
			WebDriverFactory.setDriver(dr);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		 	
			
			WebDriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			WebDriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com");
			

			/*WebDriverFactory.getDriver().get(
				" http://127.0.0.1/orangehrm-3.3.1/symfony/web/index.php/auth/login");*/
			
		 }
		 
		 public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		 
		 //System.out.println("After Invocation of: " + method.getTestMethod().getMethodName() + "of Class:" + testResult.getTestClass());
		 WebDriverFactory.getDriver().quit();
		 }
		}


