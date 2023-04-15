package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Functions.ExcelData;
import Functions.PropertiesCaller;

public class DtsLoginPage {

		
		WebDriver driver;
		Functions.ExcelData Excel;
		Functions.PropertiesCaller Obj;
		
		public DtsLoginPage(WebDriver driver){
	        this.driver = driver;
	        Excel = new ExcelData();     
	        Obj = new PropertiesCaller();
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

	        public void loginToDts() {

	            this.setUserName();
	            this.setPassword();
	            this.clickLogin();        
	        }
		
		
}
