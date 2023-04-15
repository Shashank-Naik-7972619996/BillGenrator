package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Functions.ExcelData;
import Functions.PropertiesCaller;

public class DtsLoginPage {

		
		WebDriver driver;
		Functions.ExcelData Excel;
		Functions.PropertiesCaller Obj;
		Functions.LogOutFunction ObjLogout;
		Functions.ExceptionHandlar ObjExcept;
		
		public DtsLoginPage(WebDriver driver){
	        this.driver = driver;
	        Excel = new ExcelData();     
	        Obj = new PropertiesCaller();
	        ObjExcept = new Functions.ExceptionHandlar(driver);	
		}
		
	    public void setUserName()
	    {
	        driver.findElement(By.id(Obj.Properties("Type_username"))).sendKeys(Excel.getData(0, 2, 1));
	    	
	    }

	    public void setPassword() {

	    		driver.findElement(By.id(Obj.Properties("Type_password"))).sendKeys(Excel.getData(0, 3, 1));

	        }

	        public void clickLogin() {

	        	driver.findElement(By.xpath(Obj.Properties("Press_loginbutton"))).click();
	        }

	        public boolean loginToDts() {

	        	WebDriverWait wait = ObjExcept.WaitExceptionHandling();
	        	try
	        	{
	        		this.setUserName();
        			this.setPassword();
        			this.clickLogin();
        			
        			WebElement Press_faeAtDts_com = driver.findElement(By.id(Obj.Properties("Press_faeAtDts_com")));
        			wait.until(ExpectedConditions.visibilityOf(Press_faeAtDts_com));
	        		if(Press_faeAtDts_com.isDisplayed())
	        		{
	        			return true;
	        		}
	        	}
		    	catch(NoSuchElementException e)
		    	{
		    		System.out.println("Required page is not opened or There is no internet access");
		    		return false;
		    	}
				return false;
	        }
}
