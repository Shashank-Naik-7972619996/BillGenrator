package Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Add_New_Model_And_confirm {

	Pages.DtsLoginPage ObjDtsLoginPage;
	Pages.DtsHomePage ObjDtsHomePage;
	Pages.Dts_Adding_New_model ObjDtsAddNewModel;
	Pages.DtsAddedProductReviewPage ObjDtsProductAdded;
	Pages.ProductTable ObjProductTable;
	
	Functions.DriverCall drivercall;
	Functions.LogOutFunction ObjLogout;
	
	WebDriver driver;
	String UUID;
	
	@BeforeTest
	public void RequiredStepsBeforeTest() {
		drivercall = new Functions.DriverCall();
        driver = drivercall.setDriver();
        
        driver.get("http://devportal.dts.com/saap/login");
     	driver.manage().window().maximize();
     	
     	ObjDtsLoginPage = new Pages.DtsLoginPage(driver);
		ObjDtsLoginPage.loginToDts();
		
		ObjDtsHomePage= new Pages.DtsHomePage(driver);
		ObjDtsHomePage.PressAddAccount();
		
		ObjDtsAddNewModel = new Pages.Dts_Adding_New_model(driver);
		UUID = ObjDtsAddNewModel.getUUID();
		ObjDtsAddNewModel.EnterProductDetails();
	
	}
		
	@Test //(priority=3)
	public void SaveProductAndPrintSuccessMessage() {
		ObjDtsAddNewModel = new Pages.Dts_Adding_New_model(driver);
		ObjDtsAddNewModel.ClickOnSave();
		
		Boolean SuccessMessage = ObjDtsAddNewModel.GetSuccessMsg();
		Assert.assertTrue(SuccessMessage, "Success Message does not appears");
	}
	
	@Test //(priority=2)
	public void GoToProductAddedReviewPageAndConfirmUUIDAdded()
	{
		ObjDtsProductAdded = new Pages.DtsAddedProductReviewPage(driver);
		String UUIDAdded = ObjDtsProductAdded.getAddedUUID(UUID);
		Assert.assertEquals(UUIDAdded, UUID, "UUID added is not currect");
	}

	@Test//(priority=1)
	public void VerifyProductAddedInTable() {
		
		ObjDtsProductAdded = new Pages.DtsAddedProductReviewPage(driver);
		ObjDtsProductAdded.ClickProductTable();
		
		//String UUIDS = "a31a8652-3915-447a-8598-d17a08f77e22"; 
		ObjProductTable = new Pages.ProductTable(driver);
		ObjProductTable.AccessoryFilterSelect();
		Boolean isPresent = ObjProductTable.PTable(UUID);
		if(isPresent)
		{
			System.out.println("Product added successfully");
		}
		Assert.assertTrue(isPresent, "Product is not Added in Table");
		//Assert.assertFalse(!isPresent, "Product is Added in Table");
	}

	@AfterTest
	public void Logout_Termination() throws InterruptedException
	{
		ObjLogout = new Functions.LogOutFunction(driver);
		ObjLogout.pressLogout();
		Thread.sleep(6000); driver.quit();
	}
}