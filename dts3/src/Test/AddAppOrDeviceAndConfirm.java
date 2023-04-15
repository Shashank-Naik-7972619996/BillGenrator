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
	Functions.GoToURL GoURL;
	
	WebDriver driver;
	
	String ID, Company , Brand , IDADDED;
	int NoOfPages;
	
	@BeforeTest
	public void RequiredStepsBeforeTest() throws IOException {
		drivercall = new Functions.DriverCall();
        driver = drivercall.setDriver();     
        
        GoURL = new Functions.GoToURL(driver);
        GoURL.GetURL();
     	
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
	public void VerifyID()
	{
		ObjAppAndDevices = new Pages.AppsAndDevicesTable(driver);
		ObjAppAndDevices.FiltureCompanyAndBrand(Brand, Company);
		//String IDS="93f4857b-d84b-4996-bbfa-ff5e0efd945e";
		Boolean isAdded = ObjAppAndDevices.VerifyRecord(ID);
		if(isAdded)
		{
			System.out.println("Device added successfully");
		}
		Assert.assertTrue(isAdded, "Device is not added");
	}

	@AfterTest
	public void Logout_Termination() throws InterruptedException
	{
		ObjLogout = new Functions.LogOutFunction(driver);
		ObjLogout.pressLogout();
		Thread.sleep(6000);
		driver.quit();
	}
}
