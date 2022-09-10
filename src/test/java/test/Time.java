
package test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import common.InvokedMethodListenerImpl;

@Listeners(value=InvokedMethodListenerImpl.class)
@Test(enabled = true, groups = {"Regression" })
public class Time {
	void timeSheet()
	{
		
		
	}

}
