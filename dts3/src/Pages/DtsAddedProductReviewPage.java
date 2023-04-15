package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DtsAddedProductReviewPage {

	WebDriver driver;
	Functions.ExceptionHandlar ObjExcept;
	Functions.PropertiesCaller Obj;
	
	public DtsAddedProductReviewPage(WebDriver driver)
	{
		this.driver=driver;
		Obj = new Functions.PropertiesCaller();
		ObjExcept = new Functions.ExceptionHandlar(driver);
	}
	
	public String getAddedUUID(String UUID)
	{
		WebDriverWait wait = ObjExcept.WaitExceptionHandling();
		//ObjStsAdding = new Pages.Dts_Adding_New_model(driver);
		//String UUID = ObjStsAdding.getUUID(obj);
		try
		{
			WebElement a = driver.findElement(By.id(Obj.Properties("ID")));
			wait.until(ExpectedConditions.textToBePresentInElement(a, UUID));
			String UUIDadded = a.getText();
			System.out.println("Device UUID is: "+ UUIDadded +"\n ");
			return UUIDadded;
		}catch(TimeoutException e)
		{
			System.out.println("Required page(Element) not found or No internet access");
			
		}
		return null;
	}
		public void GoToProductTable()
		{
			driver.findElement(By.id(Obj.Properties("GoToProductTable"))).click();
		}
		
		public void ClickProductTable()
		{
			this.GoToProductTable();
		}
}