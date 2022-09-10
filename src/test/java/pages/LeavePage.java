package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import common.WebDriverFactory;

public class LeavePage {
	
	
	
	@FindBy(xpath="//input[@id='assignleave_txtEmployee_empName']")
	WebElement empName;
	@FindBy(id="assignleave_leaveBalance")
	WebElement leaveBalance;
	
	@FindBy(xpath="//select[@id='assignleave_txtLeaveType']")
	WebElement options1;
	
	public LeavePage()
	{
		PageFactory.initElements(WebDriverFactory.getDriver(),this);//this insrtuction @FindBy Anonntaion run and return webElement from org.openqa.selenium.support.FindBy
	}
	
	public LeavePage assignLeave(String eName,String leaveType) throws InterruptedException
	{
		empName.sendKeys(eName);
		Thread.sleep(500);
		Select role=new Select(options1);
		role.selectByVisibleText(leaveType);
		/*
		List<WebElement> options=WebDriverFactory.getDriver().findElements(By.xpath("//select[@id='assignleave_txtLeaveType']/option"));
		Thread.sleep(500);
		System.out.println(options.size());
		for(WebElement option:options)
		{
			//<option value="9">CAN - Personal</option>
			//System.out.println("option.getText()");
			if(option.getText().contains(leaveType))
			{
				//<div id="assignleave_leaveBalance" class="">0.00<a href="#balance_details" data-toggle="modal" id="leaveBalance_details_link">view details</a></div>
				System.out.println(WebDriverFactory.getDriver().findElement(By.id("assignleave_leaveBalance")).getText()+option.getText());
			}
		}
	   */
		
		return this;
	}
	

	
	
	


}
