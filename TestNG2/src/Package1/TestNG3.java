package Package1;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG3 {
	
	@BeforeSuite
	public void beforesuite()
	{
		System.out.println("I will execute before suite");
	}
	@AfterSuite
	public void aftersuite()
	{
		System.out.println("I will execute after suite");
	}
	@BeforeClass
	public void afterclass()
	{
		System.out.println("I will execute Before class TestNG3");
	}
	@BeforeTest
	public void beforetest()
	{
		System.out.println("I will execute before all test of testNG3 class");
	}
	@AfterTest
	public void aftertest()
	{
		System.out.println("I will execute after all test of testNG3 class");
	}
	@BeforeMethod
	public void beforemethod()
	{
		System.out.println("I will execute before every method of class TestNG3");
	}
	@AfterMethod
	public void aftermethod()
	{
		System.out.println("I will execute after every method of class TestNG3");
	}
	@Test
	public void Demo()
	{
		System.out.println("This is Demo test of class TestNG3");
	}
	
	@Test
	public void Demo2()
	{
		System.out.println("This is Demo2 test of class TestNG3");
		Assert.assertTrue(false);
	}
	
	@Test(groups ="SmokeTest")
	public void Demo3()
	{
		System.out.println("This is Demo3 test of class TestNG3");
	}
	
	@Parameters("URL")
	@Test()
	public void Demo4(String url)
	{
		System.out.println("This is Demo4 test of class TestNG3");
		System.out.println(url);
	}




}
