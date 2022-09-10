package test;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import common.BaseSeleniumTest;
import common.InvokedMethodListenerImpl;

import pages.LoginPage;
@Listeners(value=InvokedMethodListenerImpl.class)
public class LoginTest  extends BaseSeleniumTest{
	
	
	//dataProvder is one of the way to parameterized test method/externalize Test data
	//Rule 1 your method (test data must have data with annotation @DataProvider
	//Rule 2 must have return 2d array 
	//Rule 3write dataprovider in context with @test (in same class or common class inherite it)
	//Rule 2 must have return 2d array /or iterator object
	
	/*//data provider
	@DataProvider(name="LoginDataProvider")
	public String[][] getLoginData(){
		
    	String loginData[][]={{"Admin","admin123","Welcome Paul"},
    					{"Adm", "admin123","Welcome Adm"},
    					{"ESS", "admin123","Welcome ESS"},
    					{"ESS", "admin123","Welcome ESS"}
    					
    					};
    	return loginData;
    	}
	
	*/
	

	@Test(dataProvider="LoginDataProviderFromxlsFile",priority = 1,enabled = true, groups = {"Regression" })
		public void VerifyAdminLoginSucessfulywithcorrectUserIDPassward(String data[]) throws InterruptedException {

		LoginPage lp = new LoginPage();
		System.out.println(data[0] + " " + data[1]+" "+data[2]);
		lp.login(data[0], data[1])
		    .verifyWelcomeMsg("Paul Collings");
		
	}
	/*
	
	@Test(priority = 1,enabled = false, groups = {"Regression" })
	public void VerifyEssLoginSucessfulywithcorrectUserIDPassward() throws InterruptedException {

		LoginPage lp = new LoginPage();
		lp.login("Admin", "admin123")
		    .verifyWelcomeMsg("Welcome Paul");
		
	}
	
	@Test(priority = 1,enabled = false, groups = {"Regression" })
	public void VerifyAdminminlengthLoginSucessfulywithcorrectUserIDPassward() throws InterruptedException {

		LoginPage lp = new LoginPage();
		lp.login("Admin", "admin123")
		    .verifyWelcomeMsg("Welcome Paul");
		
	}

	@Test(priority = 0, enabled = false, groups = { "Regression" })
	public void VerifyAdminNotAbleTologinWithIncorrectpassward() {

		LoginPage lp = new LoginPage();
		lp.loginInvalid("admin", "aaaaa").verifyErrorMsg("Invalid credentials");

	}

	@Test(priority = 0, enabled = false, groups = { "Regression" })
	public void VerifyAdminNotAbleTologinWithIncorrectUserID() {

		LoginPage lp = new LoginPage();
		lp.loginInvalid("admin123", "admin123").verifyErrorMsg("Invalid credentials");

	}

	@Test(priority = 0, enabled = false, groups = { "Regression" })
	public void VerifyAdminNotAbleTologinWithIncorrectUserIDandPassward() {

		LoginPage lp = new LoginPage();
		lp.loginInvalid("admin123", "aaaaa").verifyErrorMsg("Invalid credentials");
	}

	@Test(priority = 0, enabled = false, groups = { "Regression" })
	public void VerifyAdminNotAbleTologinWithBlanckUserIDandPassward() {

		LoginPage lp = new LoginPage();
		lp.loginblank().verifyErrorMsg("Username cannot be empty");

	}
	
	
	@Test
	public void prinltAlllink() {
		LoginPage lp = new LoginPage();
		lp.linklist();
		
	}
	
	//poo up alert
	
	/*@Test
	public void popupalert()
	{
		LoginPage lp = new LoginPage();
		lp.login("Admin", "admin123");
		WebDriverFactory.getDriver().switchTo().alert().dismiss();
		//WebDriverFactory.getDriver().switchTo().alert().accept();
		WebDriverFactory.getDriver().switchTo().alert().getText();
		
		
	}*/

}
