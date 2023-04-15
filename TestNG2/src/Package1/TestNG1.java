package Package1;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG1 {
	@Parameters("URL")
	@Test(groups ="SmokeTest")
		public void test1(String url) {
			System.out.println("This is test1 test from TestNG1 class");
			System.out.println(url);
		}
	
		@Test
		public void test2() {
			System.out.println("This is test2 test from TestNG1 class");
			Assert.assertTrue(false);
		}
		
		@Test
		public void apimobilelogin()
		{
			System.out.println("This is apimobilelogin test from TestNG1 class");
			Assert.assertTrue(false);
		}
}