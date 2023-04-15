package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class portalDashboard {
	
	public WebDriver driver;
	public portalDashboard(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	private By DashboardLabel = By.xpath("//h4[normalize-space()='Dashboard']");
	private By StatusFiltur = By.xpath("//select[@id='statusFilter']");
	
	private By tablerows = By.xpath("//tbody/tr");
	private By nameOfBusinessFromColumn = By.xpath("//a[@class='veiwdetail']");
	
	
	
	private By NevAffliateOption = By.xpath("//a[@href='/admin/affiliate']");
	
	
	public WebElement DashboardLabel()
	{
		return driver.findElement(DashboardLabel); 
	}

	public WebElement SelectStatus()
	{
		return driver.findElement(StatusFiltur); 
	}
	public List<WebElement> GetTableRow()
	{
		return driver.findElements(tablerows); 
	}
	
	public List<WebElement> GetBusinessName()
	{
		return driver.findElements(nameOfBusinessFromColumn); 
	}
	
	public portalBusiness Click_All_Business_Account_Option()
	{
		driver.findElement(NevAffliateOption).click();
		return new portalBusiness(driver);
	}
}
