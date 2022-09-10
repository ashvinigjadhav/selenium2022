package pages;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.WebDriverFactory;

public class BaseSeleniumPage {
	protected WebDriverWait wait;
	BaseSeleniumPage(){
		PageFactory.initElements(WebDriverFactory.getDriver(), this);
		  wait=new WebDriverWait(WebDriverFactory.getDriver(),Duration.ofSeconds(30));
	}

}
