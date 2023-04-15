package Functions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExceptionHandlar {

	WebDriver driver;
	public ExceptionHandlar(WebDriver driver){
        this.driver = driver;
	}
	
	public WebDriverWait WaitExceptionHandling()
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		return wait;
	}
}