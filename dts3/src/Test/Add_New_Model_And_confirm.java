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
	Functions.GoToURL GoURL;
	
	WebDriver driver;
	String UUID;
	
	@BeforeTest
	public void RequiredStepsBeforeTest() {
		drivercall = new Functions.DriverCall();
        driver = drivercall.setDriver();
        
        GoURL = new Functions.GoToURL(driver);
        GoURL.GetURL();
     	
     	ObjDtsHomePage= new Pages.DtsHomePage(driver);
		ObjDtsHomePage.Press_addProduct();
		
		ObjDtsAddNewModel = new Pages.Dts_Adding_New_model(driver);
		UUID = ObjDtsAddNewModel.getUUID();
		ObjDtsAddNewModel.EnterProductDetails();
	
	}
		
	@Test (priority=0)
	public void VerifyModal() {
		ObjDtsAddNewModel = new Pages.Dts_Adding_New_model(driver);
		ObjDtsAddNewModel.ClickOnSave();
		
		Boolean SuccessMessage = ObjDtsAddNewModel.GetSuccessMsg();
		Assert.assertTrue(SuccessMessage);
	}
	
	@Test (priority=1)
	public void GoToProductAddedReviewPageAndConfirmUUIDAdded()
	{
		ObjDtsProductAdded = new Pages.DtsAddedProductReviewPage(driver);
		String UUIDAdded = ObjDtsProductAdded.getAddedUUID(UUID);
		Assert.assertEquals(UUIDAdded, UUID, "UUID added is not currect");
	}

	@Test(priority=2)
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
		Thread.sleep(6000);
		driver.quit();
	}
}