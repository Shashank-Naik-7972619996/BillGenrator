package ForPractice.MavenPractice;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppiumTest {
	
	@Test
	public void Appium1()
	{
		System.out.println("This is from Appium1 method");
	}
	
	@Test
	public void Appium2()
	{
		System.out.println("This is from Appium2 method");
		Assert.assertFalse(false);
	}
}
