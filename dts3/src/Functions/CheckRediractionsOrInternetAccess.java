package Functions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckRediractionsOrInternetAccess 
{
	WebDriver driver;
	Functions.ExceptionHandlar ObjExcept;
	
	public CheckRediractionsOrInternetAccess(WebDriver driver)
	{
		this.driver=driver;
		ObjExcept = new Functions.ExceptionHandlar(driver);
	}
	
	public boolean CheckPresenceOfRequiredElement(WebElement element)
	{
		WebDriverWait wait = ObjExcept.WaitExceptionHandling();
		try { 
			wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } 
        catch (Exception e) { 
            System.out.println("Required page(Element) not found Or There is no internet access");
            return false;
        } 
	}
}