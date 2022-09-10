package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import common.BaseSeleniumTest;
import common.WebDriverFactory;

public class HomePage extends BaseSeleniumPage{

	//Paul Collings
	@FindBy(xpath = "//p[text()='Paul Collings']")
	WebElement welcomemsg;
	
	@FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']")
	WebElement adminTab;
	
	//
	@FindBy(xpath = "//span[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement addUser;
	
	@FindBy(id = "menu_admin_UserManagement")
	WebElement UserManagement;
	

	@FindBy(id = "menu_admin_Qualifications")
	WebElement menuQualifications;

	@FindBy(id = "menu_admin_viewSkills")
	WebElement skillSubmenu;

	@FindBy(xpath = "//a[@id='menu_admin_viewSystemUsers']")
	WebElement userSubMenu;
	
	//leave 
	@FindBy(xpath="//a[@id='menu_leave_viewLeaveModule']")
	WebElement menuLeave;
	@FindBy(xpath="//a[@id='menu_leave_assignLeave']")
	WebElement assignLeave;
	
	//pim page
	@FindBy(xpath="//a[@id='menu_pim_viewPimModule']")
	WebElement PimModule;
	@FindBy(xpath="//a[@id='menu_pim_addEmployee']")
	WebElement addEmployee;
	
			
/*
	public HomePage() {
		PageFactory.initElements(WebDriverFactory.getDriver(), this);// this insrtuction @FindBy Anonntaion run and
																		// return webElement from
																		// org.openqa.selenium.support.FindBy
	}
	*/

	public HomePage verifyWelcomeMsg(String ExpectedMsg) {
		Assert.assertEquals(welcomemsg.getText(), ExpectedMsg);
		HomePage hp = new HomePage();
		return hp;
	}

	public void verifyuseradeedsucessfully(String string) {
		// TODO Auto-generated method stub

	}

	public AddUserPage navigateToAddUserpage() {
		// TODO Auto-generated method stub
		
		adminTab.click();
							

		AddUserPage ap = new AddUserPage();
		return ap;

	}
	
	public PIMPage navigateToPIMPage() {
		// TODO Auto-generated method stub
		// avoid to use action -->userSubMenu
		Actions actions = new Actions(WebDriverFactory.getDriver());
		actions.moveToElement(PimModule)
					.moveToElement(addEmployee)							
					    .click()
							.build().perform();

		PIMPage pp = new PIMPage();
		return pp;

	}

	public QualificationsPage navigateToQualificationsPage() {
		// TODO Auto-generated method stub
		Actions actions = new Actions(WebDriverFactory.getDriver());
			actions.moveToElement(adminTab)
						.moveToElement(UserManagement)
								.moveToElement(menuQualifications)
									.moveToElement(skillSubmenu)
										.click()
											.build().perform();
		
		QualificationsPage qp = new QualificationsPage();
		return qp;
	}
	
	
	public LeavePage navigateToLeavePage() {
		// TODO Auto-generated method stub
		Actions actions = new Actions(WebDriverFactory.getDriver());
			actions.moveToElement(menuLeave)
						.moveToElement(assignLeave)
							.click()
								.build().perform();
		
			LeavePage lp = new LeavePage();
		return lp;
	}

}
