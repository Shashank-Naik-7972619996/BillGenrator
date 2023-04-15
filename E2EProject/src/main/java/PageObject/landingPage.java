package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {
	
	
	public WebDriver driver;
	public landingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	private By login = By.cssSelector("a[href*='sign_in']");
	
	private By CourseSectionTitle = By.xpath("//div[@class='text-center']");
	
	private By nevigationMenuBar = By.cssSelector("ul.nav.navbar-nav.navbar-right");
	
	private By videoBanner = By.cssSelector("div[class*=\"video-banner\"] h3");

	public WebElement getlogin()
	{
		return driver.findElement(login); 
	}
	
	public WebElement getCourseSectionTitle()
	{
		return driver.findElement(CourseSectionTitle); 
	}
	public WebElement getnevigationMenuBar()
	{
		return driver.findElement(nevigationMenuBar); 
	}
	public WebElement getvideoBanner()
	{
		return driver.findElement(videoBanner); 
	}
	
	
}
