package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DtsHomePage {

	WebDriver driver;
	Functions.PropertiesCaller Obj;
	Functions.ExceptionHandlar ObjExcept;
	
	public DtsHomePage(WebDriver driver){
        this.driver = driver;
        Obj = new Functions.PropertiesCaller();
        ObjExcept = new Functions.ExceptionHandlar(driver);
    }
	
	public void PressfaeAtDts_com() {
		driver.findElement(By.id(Obj.Properties("Press_faeAtDts_com"))).click();
	}
	public void PressUserAccount() {
		driver.findElement(By.id(Obj.Properties("Press_UserAccount"))).click();
	}
	
	public void GoToAccPage()  {
		this.PressfaeAtDts_com();
		this.PressUserAccount();
	}
	
	
	//Script2
	public void Press_addProduct() {
		WebDriverWait wait = ObjExcept.WaitExceptionHandling();
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Obj.Properties("AddProduct"))));
			driver.findElement(By.id(Obj.Properties("AddProduct"))).click();
		}catch(TimeoutException e)
		{
			System.out.println("Element not found");
		}
	}
	
	public void PressAddAccount()
	{
		this.Press_addProduct();
	}
	
	public void AppsAndDevices()
	{
		WebDriverWait wait = ObjExcept.WaitExceptionHandling();
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.id(Obj.Properties("Apps&Devices"))));
			driver.findElement(By.id(Obj.Properties("Apps&Devices"))).click();
		}catch(TimeoutException e)
		{
			System.out.println("Element is not clickable");
		}
	}
	public void PressApps_Devices()
	{
		this.AppsAndDevices();
	}
}