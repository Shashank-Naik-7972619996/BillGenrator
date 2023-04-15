package ForPractice.MavenPractice;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

public class seleniumTest {
	
	@Test
	public void selenium1()
	{
		System.out.println("This is from selenium1 method");
	}
	
	@Test
	public void selenium2()
	{
		System.out.println("This is from selenium2 method");
		Assert.assertTrue(false);
	}

}
