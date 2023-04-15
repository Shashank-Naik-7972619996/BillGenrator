package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dts_AccPage {

	WebDriver driver;
	Functions.ExceptionHandlar ObjExcept;
	Functions.PropertiesCaller Obj;
	
	public Dts_AccPage(WebDriver driver){
        this.driver = driver;
        Obj = new Functions.PropertiesCaller();
        ObjExcept = new Functions.ExceptionHandlar(driver);
    }
	public Boolean DtsAccInfo() {
		
		WebDriverWait wait = ObjExcept.WaitExceptionHandling();
				
		try {
		       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Obj.Properties("AccInfo"))));
		       System.out.println(driver.findElement(By.xpath(Obj.Properties("AccInfo"))).getText() 
	      +"\n"+ driver.findElement(By.xpath(Obj.Properties("FullName"))).getText() 
		  +"\n"+ driver.findElement(By.xpath(Obj.Properties("PartnerName"))).getText()
  + "\nTitle: "+ driver.findElement(By.xpath(Obj.Properties("Title"))).getText()
   +"\nEmail: "+ driver.findElement(By.xpath(Obj.Properties("Email"))).getText()
  +"\nPhone: ("+ driver.findElement(By.xpath(Obj.Properties("Phone1"))).getText()+") "
			   + driver.findElement(By.xpath(Obj.Properties("Phone2"))).getText()+"\nStatus: "
			   + driver.findElement(By.xpath(Obj.Properties("Status"))).getText()
		  +"\n"+ driver.findElement(By.xpath(Obj.Properties("Previlage"))).getText()+"\n "); 
		       return true;
		       
	}catch(TimeoutException e)
		{
			System.out.println("Information not found");
			return false;
		}
		}
}