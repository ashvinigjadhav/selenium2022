package test;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import common.BaseSeleniumTest;
import common.InvokedMethodListenerImpl;
import pages.LoginPage;

@Listeners(value=InvokedMethodListenerImpl.class)
public class AddUserTest extends BaseSeleniumTest {

	@Test
	public void addUserTypeAsEssEnabled() throws InterruptedException {
		
		LoginPage lp = new LoginPage();
		
		lp.login("Admin", "admin123")
			.navigateToAddUserpage()
				.addUser("ESS","Enabled","Prajakta Dhumal","prajkta11111","xyz@1234ABC_@","xyz@1234ABC_@")
				.verifyUseraddedSucessfuly("prajkta5611111");
				
				
	}
	/*
	@Test
	public void addUserTypeAsAdminDisable() throws InterruptedException {
		
		LoginPage lp = new LoginPage();
		
		lp.login("admin", "admin123")
				.navigateToAddUserpage()
					.addUser("Admin","Disabled","paul kole","Arvind5622222","xyz@1234ABC_@","xyz@1234ABC_@")
							.verifyUseraddedSucessfuly("Arvind5622222");
				
	}
	
	@Test
	public void addUserTypeAsAdminEnabled() throws InterruptedException {
		
		LoginPage lp = new LoginPage();
		
		lp.login("admin", "admin123")
		    .navigateToAddUserpage()
				.addUser("Admin","Enabled","paul kole","Arvind5622221","xyz@1234ABC_@","xyz@1234ABC_@")
				.verifyUseraddedSucessfuly("Arvind5622221");
				
	}
	
	@Test
	public void addUserTypeAsESSDesabled() throws InterruptedException {
		
		LoginPage lp = new LoginPage();
		
		lp.login("admin", "admin123")
			.navigateToAddUserpage()
				.addUser("ESS","Disabled","paul kole","Arvind561","xyz@1234ABC_@","xyz@1234ABC_@")
					.verifyUseraddedSucessfuly("Arvind5611111");
				
	}
	
*/
}
