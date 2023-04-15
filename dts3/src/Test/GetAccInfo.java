package Test;
import java.lang.reflect.Method;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetAccInfo {

	Pages.DtsHomePage ObjDtsHomePage;
	Pages.DtsLoginPage ObjDtsLoginPage;
	Pages.Dts_AccPage ObjDtsAcc;
	Functions.DriverCall drivercall;
	Functions.LogOutFunction ObjLogout;
	Functions.GoToURL GoURL;
	Boolean Istrue=null;
	WebDriver driver;
	
	@BeforeTest
	public void RequiredStepsBeforeTest() {
		drivercall = new Functions.DriverCall();
        drivercall.setDriver();
        
		GoURL = new Functions.GoToURL(driver);
        GoURL.GetURL();
	
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
		Assert.assertTrue("Acc information not found", AccInfo);
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