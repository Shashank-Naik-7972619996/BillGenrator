package Functions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverCall {
	WebDriver driver;
	Boolean IsAvailable;
	
public WebDriver setDriver() {
	try
	{
		System.setProperty("webdriver.chrome.driver", "D:\\ShashankWork\\Marquee Workspace\\Marquee Solutions Work\\Automation\\Webdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		IsAvailable=true;
		return driver;
		
	}catch(Exception e)
	{
		System.out.println("No Such driver is present");
		IsAvailable=false;
	}
	return driver;
}

public boolean DriverIsAvailable() {
	if(IsAvailable=true)
	{
		return true;
	}
	return false;
	
}
}