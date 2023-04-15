package Functions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExceptionHandlar {

	WebDriver driver;
	WebDriverWait wait;
	public ExceptionHandlar(WebDriver driver){
        this.driver = driver;
        
	}

	public WebDriverWait WaitExceptionHandling()
	{
		wait=new WebDriverWait(driver, 10);
		return wait;
	}
	
	
	
}