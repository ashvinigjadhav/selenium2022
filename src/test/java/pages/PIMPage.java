package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.WebDriverFactory;

public class PIMPage {
	
	
	
	//from org.openqa.selenium.support.FindBy
		@FindBy(xpath="//input[@id='firstName']")
		private WebElement firstName;
		@FindBy(xpath="//input[@id='middleName']")
		private WebElement middleName;
		@FindBy(xpath="//input[@id='lastName']")
		private WebElement lastName;
		@FindBy(xpath="//input[@id='photofile']")
		private WebElement photofile;
		@FindBy(xpath="//input[@id='btnSave']")
		private WebElement btnSave;
		
	public	PIMPage ()
		{
			PageFactory.initElements(WebDriverFactory.getDriver(), this);
		}
		
	public  PIMPage addEmployee(String fName,String mName,String lName,String path )
	{
		firstName.sendKeys(fName);
		middleName.sendKeys(mName);
		lastName.sendKeys(lName);
		photofile.sendKeys(path);
		btnSave.click();
		PIMPage pp=new PIMPage();
		return pp;
	}
			
			


}
