package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import common.WebDriverFactory;

public class QualificationsPage {
	
	@FindBy(id="btnAdd")
	WebElement btnAdd;
	
	@FindBy(id="skill_name")
	WebElement skillname;
	
	
	@FindBy(id="skill_description")
	WebElement skilldescription;
	//recordsListTable
	
	@FindBy(id="btnSave")
	WebElement save;
	
	
	
	public QualificationsPage()
	{
		PageFactory.initElements(WebDriverFactory.getDriver(),this);//this insrtuction @FindBy Anonntaion run and return webElement from org.openqa.selenium.support.FindBy
	}
	
	public QualificationsPage AddSkillSucessfuly(String skill,String Skilldetails) {
		
		btnAdd.click();
		skillname.sendKeys(skill);
		skilldescription.sendKeys(Skilldetails);
		save.click();
		QualificationsPage qp=new QualificationsPage();
		return qp;
	}
	
public QualificationsPage verifySkilladdedSucessfuly(String skill,String Skilldetails) {
		
		WebElement tableSkill=WebDriverFactory.getDriver().findElement(By.id("recordsListTable"));
				
		List<WebElement> tableSkillcol=tableSkill.findElements(By.tagName("td"));
		
		List<WebElement> tableSkillrow=null;
			boolean Skillstatus=false;	
		for(WebElement col:tableSkillcol)
		{
			//tableSkillrow=(List<WebElement>) col.findElements(By.tagName("tr"));
			if(Skillstatus=col.getText().equals(skill))
				break;
			
		}
		
		Assert.assertEquals(Skillstatus, true);
		
		QualificationsPage qp=new QualificationsPage();
		return qp;
	}
	


}
