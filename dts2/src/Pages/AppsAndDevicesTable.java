package Pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppsAndDevicesTable {
	
	Pages.Dts_AppsAndDevicesForm ObjAppsAndDevicesForm;
	Pages.Dts_AddedAppsAndDeviceReviewPage ObjAddedAppsAndDeviceReviewPage;
	
	WebDriver driver;
	Functions.ExceptionHandlar ObjExcept;
	Functions.PropertiesCaller Obj;
		
	public AppsAndDevicesTable(WebDriver driver){
        this.driver = driver;
        Obj = new Functions.PropertiesCaller();
        ObjExcept = new Functions.ExceptionHandlar(driver);
		
    }
	
	public void clickAddProduct()
	{
		WebDriverWait wait = ObjExcept.WaitExceptionHandling();
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Obj.Properties("PageNevigation"))));
			driver.findElement(By.id(Obj.Properties("AddAppOrDevice"))).click();
		}catch(TimeoutException e)
		{
			System.out.println("Element is not found");
		}
	}
	public void PressAddProduct()
	{
		this.clickAddProduct();
	}
	
	public void FiltureCompanyAndBrand(String brand1, String company1)
	{
		WebDriverWait wait = ObjExcept.WaitExceptionHandling();
		try
		{
			wait.until(ExpectedConditions.attributeContains(By.xpath(Obj.Properties("CompanyListFilture")), "value", "all"));
			Select company2 = new Select(driver.findElement(By.id(Obj.Properties("Company-list"))));
			company2.selectByVisibleText(company1);
		
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Obj.Properties("BrandListFilture"))));
				WebElement brand3 = driver.findElement(By.xpath(Obj.Properties("BrandListFilture")));
				try {
					wait.until(ExpectedConditions.attributeToBeNotEmpty(brand3, "value"));
					Select brand2 = new Select(driver.findElement(By.id(Obj.Properties("BrandList"))));
					brand2.selectByVisibleText(brand1);
				} catch (Exception e) {
					System.out.println("Sorry there are no list of brands");
					//System.out.println(e.getMessage());
				}
			} catch (Exception e) {
				
				System.out.println("There is no such element");
				//System.out.println(e.getMessage());
			}
			
			
		}catch(TimeoutException e)
		{
			System.out.println("Data not found for filturation");
			//System.out.println(e.getMessage());
		}
		

	}
	
	public boolean VerifyRecord(String ID)
	{
		WebDriverWait wait = ObjExcept.WaitExceptionHandling();
		try
	 {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Obj.Properties("AppsAndDevicesTableRaw"))));
		WebElement basetable = driver.findElement(By.xpath(Obj.Properties("AppsAndDevicesTable")));
		int records_in_page;
		boolean isAdded=false;
		String rowtext;
	    
		List<WebElement> tablerow = basetable.findElements(By.xpath(Obj.Properties("AppsAndDevicesTableRaw")));
	    for (int i = 0; i < 30; i++) 
	    {
	    	records_in_page = basetable.findElements(By.xpath(Obj.Properties("AppsAndDevicesTableRaw"))).size();
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Obj.Properties("AppsAndDevicesTableRaw"))));
	    	
	    	
	    	
	    	for (int j = 0; j < records_in_page; j++) 
	    	{
	    		Wait<WebDriver> stubbornWait = new FluentWait<WebDriver>(driver)
		        	    .ignoring(NoSuchElementException.class)
		        	    .ignoring(StaleElementReferenceException.class);
	    		
	    		
	    		rowtext = tablerow.get(j).getText();
	    		
	    		if(rowtext.contains(ID))//"2faed953-26bf-410f-9d4d-e9bc3ddda435"
	            {
	            	isAdded=true;
	            	return isAdded;
	            }
	        }
	        if(!isAdded)
			{
	        	WebElement element = driver.findElement(By.id("product_table_next"));
	        	if(element.isDisplayed()) {
					Actions actions = new Actions(driver);
					try {
					wait.until(ExpectedConditions.elementToBeClickable(element));
					actions.moveToElement(element).click().build().perform();
					if(!isAdded)
					{
						System.out.println("Product is not added in table");
						isAdded = false;
						return isAdded;
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
	        }
	    }
	    }

	 }catch(TimeoutException e)
	 {
		 System.out.println("Table row not found");
	 }
	return false;
	}
}