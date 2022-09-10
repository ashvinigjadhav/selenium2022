package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import common.BaseSeleniumTest;
import common.WebDriverFactory;

public class LoginPage extends BaseSeleniumPage {
	
	//from org.openqa.selenium.support.FindBy
	//
	@FindBy(xpath="//input[@class='oxd-input oxd-input--active']")
	private WebElement userName;
	
	@FindBy(name="password")
	private WebElement password;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn;
	@FindBy(id="spanMessage")
	private WebElement spanmsg;
	@FindBy(tagName="a")
	private List<WebElement> link;
	
	//write common code it run when obj created 
	public LoginPage()
	{
		PageFactory.initElements(WebDriverFactory.getDriver(),this);//this insrtuction @FindBy Anonntaion run and return webElement from org.openqa.selenium.support.FindBy
	}
	
	public HomePage login(String strUserName,String strPassword) {
		userName.sendKeys(strUserName);
		password.sendKeys(strPassword);
		loginBtn.click();
		HomePage hp=new HomePage();
		return hp;
	}
	public LoginPage loginInvalid(String strUserName,String strPassword) {
		//explicitaly wait
		wait.until(ExpectedConditions.visibilityOf(userName));
		
		userName.sendKeys(strUserName);
		password.sendKeys(strPassword);
		loginBtn.click();
		return this;
	}
	
	public LoginPage loginblank() {
		userName.clear();
		password.clear();
		loginBtn.click();
		return this;
	}
	
	
	public LoginPage verifyErrorMsg(String ExpectedMsg)
	{
		Assert.assertEquals(spanmsg.getText(), ExpectedMsg);
		return this;
	}

	public void linklist() {
		for(WebElement a:link)
		{
		       System.out.println("links"+a.getAttribute("href"));
		}
	}
	
	
}
