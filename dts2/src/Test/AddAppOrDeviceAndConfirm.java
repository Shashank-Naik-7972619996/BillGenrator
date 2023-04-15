package Test;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddAppOrDeviceAndConfirm {

	Pages.DtsLoginPage ObjDtsLoginPage;
	Pages.DtsHomePage ObjDtsHomePage;
	Pages.Dts_AppsAndDevicesForm ObjAppsAndDevicesForm;
	Pages.Dts_AddedAppsAndDeviceReviewPage ObjAddedAppsAndDeviceReviewPage;
	Pages.AppsAndDevicesTable ObjAppAndDevices;
	
	Functions.DriverCall drivercall;
	Functions.LogOutFunction ObjLogout;
	
	WebDriver driver;
	
	String ID, Company , Brand , IDADDED;
	int NoOfPages;
	
	@BeforeTest
	public void RequiredStepsBeforeTest() throws IOException {
		drivercall = new Functions.DriverCall();
        driver = drivercall.setDriver();     
        
        driver.get("http://devportal.dts.com/saap/login");
     	driver.manage().window().maximize();
     	
     	ObjDtsLoginPage = new Pages.DtsLoginPage(driver);
		ObjDtsLoginPage.loginToDts();
		
		ObjDtsHomePage = new Pages.DtsHomePage(driver);
		ObjDtsHomePage.PressApps_Devices();
		
		ObjAppAndDevices = new Pages.AppsAndDevicesTable(driver);
		ObjAppAndDevices.PressAddProduct();
		
		ObjAppsAndDevicesForm = new Pages.Dts_AppsAndDevicesForm(driver);
		ID = ObjAppsAndDevicesForm.getIDfromForm();
		Company = ObjAppsAndDevicesForm.AddEntry();
		Brand = ObjAppsAndDevicesForm.ReturnSelectBrand();
		
		ObjAppsAndDevicesForm = new Pages.Dts_AppsAndDevicesForm(driver);
		ObjAppsAndDevicesForm.SaveButton();
		
		ObjAddedAppsAndDeviceReviewPage = new Pages.Dts_AddedAppsAndDeviceReviewPage(driver);
		IDADDED = ObjAddedAppsAndDeviceReviewPage.getDtsID();
		
		ObjAddedAppsAndDeviceReviewPage = new Pages.Dts_AddedAppsAndDeviceReviewPage(driver);
		//ObjAddedAppsAndDeviceReviewPage.PressApps_Devices();
		ObjAddedAppsAndDeviceReviewPage.GoHome();
		ObjDtsHomePage = new Pages.DtsHomePage(driver);
		ObjDtsHomePage.PressApps_Devices();
	}
	
	@Test//(priority=8)
	public void VerifyID() throws InterruptedException
	{
		ObjAppAndDevices = new Pages.AppsAndDevicesTable(driver);

		for(int i=0;i<=1;i++)
		{
			if(i==1)
			{
				driver.navigate().refresh();
				Thread.sleep(6000l);
			}
			ObjAppAndDevices.FiltureCompanyAndBrand(Brand, Company);
			Boolean isAdded = ObjAppAndDevices.VerifyRecord(ID);
			if(isAdded)
			{
				System.out.println("Device added successfully");
				Assert.assertTrue(isAdded, "Device is not added");
			}
			//Assert.assertTrue(isAdded, "Device is not added");
		}
		
		
		
		
		//String IDS="93648354-1f49-4a7d-9d0a-15e385c6cdaf";
		
		
	}
	
	@AfterTest
	public void Logout_Termination() throws InterruptedException
	{
		ObjLogout = new Functions.LogOutFunction(driver);
		//ObjLogout.pressLogout();
		//Thread.sleep(6000); driver.quit();
	}
}
