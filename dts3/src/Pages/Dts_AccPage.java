package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
			WebElement Accinfo = driver.findElement(By.xpath(Obj.Properties("AccInfo")));
			wait.until(ExpectedConditions.visibilityOf(Accinfo));
		       if(Accinfo.isDisplayed())
		       {
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
		       }
		       
			}catch(Exception e)
			 {
			System.out.println("Account information not found or No internet access");
			return false;
			 }
		return false;
		}
}