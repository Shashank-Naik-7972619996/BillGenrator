package Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LogOutFunction {

	WebDriver driver;
	Functions.PropertiesCaller Obj;
	
	public LogOutFunction(WebDriver driver)
	{
		this.driver=driver;
		Obj = new Functions.PropertiesCaller();
	}

	public void Logout()
	{
		driver.findElement(By.id(Obj.Properties("Press_faeAtDts_com"))).click();
		driver.findElement(By.id(Obj.Properties("LogOut"))).click();
		driver.quit();
	}
	
	public void pressLogout()
	{
		try
		{
			this.Logout();
		}
		catch(NoSuchElementException e)
		{
			driver.quit();
		}
	}
}