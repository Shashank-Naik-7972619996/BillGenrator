package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	
	public WebDriver driver;
	public loginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	private By username = By.id("email");
	private By password = By.id("password");
	
	private By loginButton = By.id("btnSignIn");
	
	public WebElement UserName()
	{
		return driver.findElement(username); 
	}
	public WebElement Password()
	{
		return driver.findElement(password); 
	}
	public WebElement SignInButton()
	{
		return driver.findElement(loginButton); 
	}

}
