package Functions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverCall {
	WebDriver driver;
	
public WebDriver setDriver() {
	System.setProperty("webdriver.chrome.driver", "D:\\ShashankWork\\Marquee Workspace\\Marquee Solutions Work\\Automation\\Webdrivers\\chromedriver.exe");
    driver = new ChromeDriver();
	return driver;
}
}