package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	
	
	public WebDriver driver;
	public loginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	private By email = By.cssSelector("[type='email']");
	private By pass = By.cssSelector("[type='password']");
	private By loginButton = By.cssSelector("[type='submit']");
	private By Alert = By.cssSelector("[role='alert']");

	public WebElement getEmail()
	{
		return driver.findElement(email); 
	}
	public WebElement getPass()
	{
		return driver.findElement(pass); 
	}
	public WebElement getLogin()
	{
		return driver.findElement(loginButton); 
	}
	public WebElement getAlert()
	{
		return driver.findElement(Alert); 
	}
}
