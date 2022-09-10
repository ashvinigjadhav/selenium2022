package test;





import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import common.InvokedMethodListenerImpl;
import pages.LoginPage;
@Listeners(value=InvokedMethodListenerImpl.class)
public class LeaveTest {

	@Test(enabled = true, groups = {"Regression" })
	public void assignLeave() throws InterruptedException {
		
		LoginPage lp = new LoginPage();
		
		lp.login("Admin", "admin123")
			.navigateToLeavePage()
				.assignLeave("Prajakta Dhumal","CAN - Personal");
				
		
				
	}
}
