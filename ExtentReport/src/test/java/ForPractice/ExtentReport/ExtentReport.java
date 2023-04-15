package ForPractice.ExtentReport;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	ExtentReports ER;
	
	
	@BeforeTest
	public void Extentreport()
	{
		String path = System.getProperty("user.dir")+"\\report\\index.html";
		ExtentSparkReporter ESR = new ExtentSparkReporter(path);
		ESR.config().setReportName("Web automation");
		ESR.config().setDocumentTitle("Test detail report");
		ER = new ExtentReports();
		ER.attachReporter(ESR);
		ER.setSystemInfo("Tester", "Shashank Naik");
	}

	@Test
	public void testngtest() {
		
		ExtentTest test=ER.createTest("Test1");
		System.setProperty("webdriver.chrome.driver","D:\\ShashankWork\\Marquee Workspace\\Marquee Solutions Work\\Automation\\Webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		test.fail("Failed just to know");
		ER.flush();
	}
	
	@Test
	public void testsample()
	{
		ER.createTest("Test2");
		System.out.println("Sample test");
		ER.flush();
	}

}