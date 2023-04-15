package Test;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetAccInfo {

	Pages.DtsHomePage ObjDtsHomePage;
	Pages.DtsLoginPage ObjDtsLoginPage;
	Pages.Dts_AccPage ObjDtsAcc;
	Functions.DriverCall drivercall;
	Functions.LogOutFunction ObjLogout;
	WebDriver driver;
	
	@BeforeTest
	public void RequiredStepsBeforeTest() {
		drivercall = new Functions.DriverCall();
        driver = drivercall.setDriver();
        
        driver.get("http://devportal.dts.com/saap/login");
     	driver.manage().window().maximize();
     	
     	ObjDtsLoginPage = new Pages.DtsLoginPage(driver);
		ObjDtsLoginPage.loginToDts();
		
		ObjDtsHomePage = new Pages.DtsHomePage(driver);
		ObjDtsHomePage.GoToAccPage();
	}

	@Test
	public void GetAllAccInfo()
	{
		ObjDtsAcc = new Pages.Dts_AccPage(driver);
		Boolean AccInfo = ObjDtsAcc.DtsAccInfo();
		Assert.assertTrue("Account information not found", AccInfo);
	}
	
	@AfterTest
	public void termination() throws InterruptedException
	{
		ObjLogout = new Functions.LogOutFunction(driver);
		ObjLogout.pressLogout();
		Thread.sleep(6000);
		driver.quit();
	}
}