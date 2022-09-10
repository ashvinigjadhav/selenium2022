package pages;

import org.openqa.selenium.NoSuchFrameException;

import common.WebDriverFactory;

public class FramePage {
	public void switchToFrame(String ParentFrame, String ChildFrame) {
	    try {
	    	WebDriverFactory.getDriver().switchTo().frame(ParentFrame).switchTo().frame(ChildFrame);
	        System.out.println("Navigated to innerframe with id " + ChildFrame
	                + "which is present on frame with id" + ParentFrame);
	    } catch (NoSuchFrameException e) {
	        System.out.println("Unable to locate frame with id " + ParentFrame
	                + " or " + ChildFrame + e.getStackTrace());
	    } catch (Exception e) {
	        System.out.println("Unable to navigate to innerframe with id "
	                + ChildFrame + "which is present on frame with id"
	                + ParentFrame + e.getStackTrace());
	    }
	}

}
