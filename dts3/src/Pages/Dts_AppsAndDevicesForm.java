package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Functions.ExcelData;
import Functions.PropertiesCaller;

public class Dts_AppsAndDevicesForm {

	Functions.ExcelData Excel;
	
	WebDriver driver;
	Functions.ExceptionHandlar ObjExcept;
	Functions.PropertiesCaller Obj;
	
	public Dts_AppsAndDevicesForm(WebDriver driver)
	{
		this.driver=driver;
		Excel = new ExcelData();
		Obj = new PropertiesCaller();
		ObjExcept = new Functions.ExceptionHandlar(driver);
	}
	public void Save()
	{
		driver.findElement(By.id(Obj.Properties("SaveAppsAndDevices"))).click();
	}
	
	public void SaveButton()
	{
		this.Save();
	}
	
	public void AddData() throws InterruptedException
	{
		this.AddEntry();
	}
	
	
	public String getIDfromForm() {
		WebDriverWait wait = ObjExcept.WaitExceptionHandling();
		try
		{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Obj.Properties("Type"))));
		
		String ID = driver.findElement(By.id(Obj.Properties("DTSID"))).getText();
		return ID;
		}catch(Exception e)
		{
			System.out.println("Required page(Element) not found Or There is no internet access");
		}
		return null;
	
	}
	
	public String AddEntry()
	{
		WebDriverWait wait = ObjExcept.WaitExceptionHandling();
		try
		{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Obj.Properties("Type"))));
		
		driver.findElement(By.id(Obj.Properties("SalesforceId"))).sendKeys(Excel.getData(2, 3, 1));
		
		Select type =new Select(driver.findElement(By.id(Obj.Properties("Type"))));
		type.selectByVisibleText(Excel.getData(2, 4, 1));
		String Type1 = type.getFirstSelectedOption().getText();
		System.out.println(Type1);
	
		Select producttype =new Select(driver.findElement(By.id(Obj.Properties("ProductType"))));
		producttype.selectByVisibleText(Excel.getData(2, 5, 1));
		
		Select company =new Select(driver.findElement(By.xpath(Obj.Properties("CompaniesList"))));
		company.selectByVisibleText(Excel.getData(2, 6, 1));
		
		String company1 = company.getFirstSelectedOption().getText();
		System.out.println(company1);
		
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Obj.Properties("Option2inBrand"))));
			WebElement index = driver.findElement(By.xpath(Obj.Properties("Option2inBrand")));
			try {
				wait.until(ExpectedConditions.attributeToBeNotEmpty(index, "value"));
				Select brand =new Select(driver.findElement(By.id(Obj.Properties("Brand"))));
				brand.selectByIndex(2);
				
				String brand1 =brand.getFirstSelectedOption().getText();
				System.out.println(brand1);
				
				driver.findElement(By.id(Obj.Properties("Name"))).sendKeys(Excel.getData(2, 7, 1));
				driver.findElement(By.xpath(Obj.Properties("OsButton"))).click();
				driver.findElement(By.xpath(Obj.Properties("Android_P_And_Newer"))).click();
				driver.findElement(By.xpath(Obj.Properties("IOS"))).click();
				
				return company1;
			} catch (Exception e) {
				
				System.out.println("There is no attributes in value");
			}
		} catch (Exception e) {
			
			System.out.println("There is no option in Brands");
		}
		
		}catch(TimeoutException e)
		{
			System.out.println("Required page(Element) not found Or There is no internet access");
		}
		return null;
	}
	
	public String ReturnSelectBrand()
	{
		String brand1 = new Select(driver.findElement(By.id(Obj.Properties("Brand")))).getFirstSelectedOption().getText();
		//System.out.println(brand1);
		return brand1;
	}
}