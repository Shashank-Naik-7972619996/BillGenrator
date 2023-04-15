package Package1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TestNG2 {

	
	
	@Test
	public void test1() {
		System.out.println("This is test1 test from TestNG2 class");
	}
	@AfterClass
	public void afterclass()
	{
		System.out.println("I will execute after class TestNG2");
	}

	@Test(groups ="SmokeTest")
	public void test2() {
		System.out.println("This is test2 test from TestNG2 class");
	}
}
