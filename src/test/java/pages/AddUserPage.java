package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import common.WebDriverFactory;

public class AddUserPage {

	
	@FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']")
	WebElement admin;
	
	
	@FindBy(xpath = "//button[@class='oxd-main-menu-item active']")
	WebElement addBtn;
	

	@FindBy(xpath = "//div[@class='oxd-select-text oxd-select-text--active'and @autocomplete='off']")
	WebElement userType;
	
	@FindBy(xpath = "//div[@class='oxd-select-text-input']") 
	WebElement userStatus;
	
	@FindBy(xpath = "//input[@placeholder='Type for hints...']") 
	WebElement empName;
	
	
	@FindBy(xpath = "//input[@class='oxd-input oxd-input--active oxd-input--error'and @autocomplete='off']")
	WebElement userName;
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement password;
	//
	@FindBy(xpath = "//input[@class='oxd-input oxd-input--active']")
	WebElement confirmPassword;
	//type="submit"
	@FindBy(xpath = "//input[@type='submit']")
	WebElement btnSave;
	
	@FindBy(xpath ="//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	WebElement searchUser;
	
	@FindBy(xpath = "//input[@class='oxd-input oxd-input--active']")
	WebElement searchUserName;
	

	public AddUserPage() {
		PageFactory.initElements(WebDriverFactory.getDriver(), this);// this insrtuction @FindBy Anonntaion run and
																		// return webElement from
																		// org.openqa.selenium.support.FindBy
	}

	public AddUserPage addUser(String roleType, String userStatusType, String ename, String uname, String pwd, String cpwd) throws InterruptedException {
		
		
		admin.click();
		
		addBtn.click();
		
		Select role = new Select(userType);
		role.selectByVisibleText(roleType);

		Select role1 = new Select(userStatus);
		role1.selectByVisibleText(userStatusType);
		//role1.selectByValue(userStatusType);
		//WebElement s1=role1.getFirstSelectedOption();
		//System.out.println(s1);
		
		empName.sendKeys(ename);
		userName.sendKeys(uname);
		password.sendKeys(pwd);
		confirmPassword.sendKeys(cpwd);
		Thread.sleep(100);
		btnSave.click();
		Thread.sleep(100);
		//AddUserPage ap=new AddUserPage();
		return this;

	}
	
public AddUserPage verifyUseraddedSucessfuly(String uname) throws InterruptedException {
		Thread.sleep(5000);
		 searchUserName.sendKeys(uname);
		   Thread.sleep(1000);
		searchUser.click();
		   Thread.sleep(1000);
	  
	   
		WebElement tableUser=WebDriverFactory.getDriver().findElement(By.xpath("//div[@class='oxd-table']"));
		
		//class="oxd-table"role="table"
		
		//class="oxd-table-cell oxd-padding-cell"
		List<WebElement> tableUsercol=tableUser.findElements(By.xpath("//div[@class='oxd-table-cell oxd-padding-cell']"));
		
		List<WebElement> tableUserrow=null;
		Thread.sleep(1000);
			boolean userstatus=false;	
		for(WebElement col:tableUsercol)
		{
			//tableSkillrow=(List<WebElement>) col.findElements(By.tagName("tr"));
			if(userstatus=col.getText().equals(uname))
				break;
			
		}
		
		Assert.assertEquals(userstatus, true);
		
		
		return this;
	}
	

}
