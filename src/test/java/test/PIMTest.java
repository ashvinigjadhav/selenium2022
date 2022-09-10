package test;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import common.InvokedMethodListenerImpl;
import pages.LoginPage;

@Listeners(value=InvokedMethodListenerImpl.class)

public class PIMTest {
	
	@Test(enabled = true, groups = {"Regression" })
	public void addEmployee() {
		
LoginPage lp = new LoginPage();
		
		lp.login("Admin", "admin123")
			.navigateToPIMPage()
			   .addEmployee("Rahul", "Deepak", "jamdade","D:\\SELENIUM\\uploaddata\\pankajphotopng.png");
			
				
		
	}
	
	
		
		
	

}
