package test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import common.InvokedMethodListenerImpl;
import pages.LoginPage;
@Listeners(value=InvokedMethodListenerImpl.class)
public class SkillTest  {
	@Test(enabled = true, groups = {"Regression" })
	public void addSkillTest() throws InterruptedException {
		
		LoginPage lp = new LoginPage();
		
		lp.login("Admin", "admin123")
			.navigateToQualificationsPage().AddSkillSucessfuly("Swift123","programming")
				.verifySkilladdedSucessfuly("Swift123", "programming");
				
	}

}
