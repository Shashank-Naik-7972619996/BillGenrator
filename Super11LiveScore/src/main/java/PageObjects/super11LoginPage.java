package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class super11LoginPage {
	
	
	public WebDriver driver;
	public super11LoginPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	private By Username = By.xpath("//input[@id='email']");
	private By Password = By.xpath("//input[@id='password']");
	private By Sign_In = By.xpath("//button[@id='btnSignIn']");
	
	public WebElement Username()
	{
		return driver.findElement(Username); 
	}

	public WebElement Password()
	{
		return driver.findElement(Password); 
	}
	public WebElement Sign_In()
	{
		return driver.findElement(Sign_In); 
	}
}
