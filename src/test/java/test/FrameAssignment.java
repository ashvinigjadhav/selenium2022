package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import common.InvokedMethodListenerImpl;
import common.WebDriverFactory;
import pages.FramePage;
import pages.LoginPage;


//frame-top

public class FrameAssignment {
	/*
	@FindBy(name="frame-top")
	WebElement frametop;
	//frame-bottom
	@FindBy(name="frame-bottom")
	WebElement framebottom;
	@FindBy(name="frameset-middle")
	WebElement framesetmiddle;
	//frame-left,frame-middle,frame-right
	public FrameAssignment()
	{
		PageFactory.initElements(WebDriverFactory.getDriver(),this);//this insrtuction @FindBy Anonntaion run and return webElement from org.openqa.selenium.support.FindBy
	}
	//*/
	
	@Test
	public void framelabeldisplay() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\driver104\\chromedriver.exe");

		

		WebDriverFactory.setDriver(new ChromeDriver());
		WebDriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverFactory.getDriver().get("https://the-internet.herokuapp.com/nested_frames");
		FramePage fp=new FramePage();
		System.out.println((WebDriverFactory.getDriver().switchTo().frame(0)).findElement(By.tagName("body")).getText());
		
		System.out.println((WebDriverFactory.getDriver().switchTo().frame(0)).findElement(By.tagName("body").xpath("body")).getText());
		/*//WebDriverFactory.getDriver().switchTo().frame(0);
		
		//WebElement frameleft=(WebDriverFactory.getDriver().switchTo().frame(0)).findElement(By.xpath("/html/body"));
		
		//System.out.println("frame 1"+frameleft.getText());
		String framname[]= {"frame-left","frame-middle","frame-right"};
		int size = WebDriverFactory.getDriver().findElements(By.name("frameset-middle")).size();
		System.out.println(WebDriverFactory.getDriver().findElements(By.name("frameset-middle")).get(0));
		//frameset-middle
		WebDriverFactory.getDriver().findElements(By.name("frameset-top")).size();
		/*System.out.println(size);
		 for(int i=0; i<=size; i++){
			 WebDriverFactory.getDriver().switchTo().frame(framname[0]);
				int total=WebDriverFactory.getDriver().findElements(By.xpath("html/body")).size();
				System.out.println(total);
				WebDriverFactory.getDriver().switchTo().defaultContent();
				}*/
				
	}

}
