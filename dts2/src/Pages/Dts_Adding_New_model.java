package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Functions.ExcelData;

public class Dts_Adding_New_model {

	WebDriver driver;
	Functions.ExceptionHandlar ObjExcept;
	Functions.ExcelData Excel;
	Functions.PropertiesCaller Obj;
	
	public Dts_Adding_New_model(WebDriver driver){
        this.driver = driver;
        Excel = new ExcelData();
        Obj = new Functions.PropertiesCaller();
        ObjExcept = new Functions.ExceptionHandlar(driver);
    }
	
	public String getUUID()
	{
		WebDriverWait wait = ObjExcept.WaitExceptionHandling();
		String UUID = null;
		try
		{
			WebElement ID = driver.findElement(By.id(Obj.Properties("ID")));
			wait.until(ExpectedConditions.attributeToBeNotEmpty(ID, "key"));
			UUID = driver.findElement(By.id(Obj.Properties("ID"))).getText();
			System.out.println(UUID);
		}
		catch(TimeoutException e)
		{
			System.out.println("Element not found");
		}
		return UUID;
	}
	
	public void EnterProductDetails()
	{
		driver.findElement(By.id(Obj.Properties("Salesforce_Id"))).sendKeys(Excel.getData(1, 4, 1));
		
		Select company = new Select(driver.findElement(By.id(Obj.Properties("CompanyList"))));
		company.selectByVisibleText(Excel.getData(1, 5, 1));
		
		Select Brand = new Select(driver.findElement(By.id(Obj.Properties("BrandSelect"))));
		Brand.selectByVisibleText(Excel.getData(1, 6, 1));
		
		driver.findElement(By.id(Obj.Properties("ModelName"))).sendKeys(Excel.getData(1, 7, 1));
		
		Select ModelType = new Select(driver.findElement(By.id(Obj.Properties("ModelType"))));
		ModelType.selectByVisibleText(Excel.getData(1, 8, 1));
		
		driver.findElement(By.id(Obj.Properties("checkboxWired"))).click();
		driver.findElement(By.id(Obj.Properties("checkboxBluetooth"))).click();
		driver.findElement(By.id(Obj.Properties("checkboxUSB"))).click();
	}
	public void SaveProduct()
	{
		WebDriverWait wait = ObjExcept.WaitExceptionHandling();
		try
		{
			wait.until(ExpectedConditions.attributeContains(By.id(Obj.Properties("Actions")),"style", "90px"));
		}
			catch(TimeoutException e)
			{}driver.findElement(By.id(Obj.Properties("Save"))).click();
	}
	public boolean GetSuccessMsg()
	{
		WebDriverWait wait = ObjExcept.WaitExceptionHandling();
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Obj.Properties("MsgBox"))));
			String msg = driver.findElement(By.xpath(Obj.Properties("MSGText"))).getText();
			System.out.println(msg);
			return true;
		}
		catch(TimeoutException e)
		{
			System.out.println("Message not found");
			return false;
			//Assert.fail("Element not found hence test case fail");
		}
	}
	public void ClickOnSave()
	{
		this.SaveProduct();
	}
}