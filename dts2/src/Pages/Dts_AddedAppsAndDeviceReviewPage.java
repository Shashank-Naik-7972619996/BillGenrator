package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dts_AddedAppsAndDeviceReviewPage {
	WebDriver driver;
	Functions.ExceptionHandlar ObjExcept; 
	Functions.PropertiesCaller Obj;
	String ID;
	
	public Dts_AddedAppsAndDeviceReviewPage(WebDriver driver)
	{
		this.driver= driver;
		Obj = new Functions.PropertiesCaller();
		ObjExcept = new Functions.ExceptionHandlar(driver);
	}
	
	public String getDtsID()
	{
		WebDriverWait wait = ObjExcept.WaitExceptionHandling();
		
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Obj.Properties("DTSID"))));
			ID= driver.findElement(By.id(Obj.Properties("DTSID"))).getText();
			System.out.println("Product ID is: "+ ID);
			System.out.println(" ");
			return ID;
		}catch(TimeoutException e)
		{
			System.out.println("Dts ID not found");
		}
		return null;
		
	}
	
	/*public void AppsAndDevices()
	{
		WebDriverWait wait = ObjExcept.WaitExceptionHandling();
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Obj.Properties("DtsId"))));
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
	}*/
	
	public void GoToHome()
	{
		WebDriverWait wait = ObjExcept.WaitExceptionHandling();
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Obj.Properties("DtsId"))));
			try {
				wait.until(ExpectedConditions.elementToBeClickable(By.id(Obj.Properties("Apps&Devices"))));
					driver.findElement(By.id(Obj.Properties("HomeButton"))).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}catch(TimeoutException e)
		{
			System.out.println(e.getMessage());
			System.out.println("Element is not present");
		}
	}
	
	public void GoHome()
	{
		this.GoToHome();
	}
	
	
	
	/*public getDtsID(Properties obj)
	{
		this.GetDtSID2(obj);
	}*/
}
