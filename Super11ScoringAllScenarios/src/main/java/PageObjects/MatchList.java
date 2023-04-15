package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MatchList {

	
	public WebDriver driver;
	public MatchList(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	private By ListOfMatch = By.xpath("//tr[@id='undefined']/td[3]");
	private By ScoreManagmentButton = By.xpath("//*[@id='undefined']/td[12]/div/button[4]");
	private By NextButton = By.id("matchData_next");
	private By SideNev = By.xpath("//a[@class='nav-link']");
	private By scoremanagmentsidebarButton = By.xpath("//li[@class='nav-item'][1]");
	private By matchbuttonFromSideNev = By.xpath("(//li[@class='nav-item'][5])[1]");
	
	public List<WebElement> ListOfMatch()
	{
		return driver.findElements(ListOfMatch); 
	}
	
	public WebElement ScoreManagmentButton()
	{
		return driver.findElement(ScoreManagmentButton); 
	}
	
	public WebElement NextButton()
	{
		return driver.findElement(NextButton); 
	}
	public WebElement SideNev()
	{
		return driver.findElement(SideNev); 
	}
	public WebElement scoremanagmentsidebarButton()
	{
		return driver.findElement(scoremanagmentsidebarButton); 
	}
	public WebElement matchbuttonFromSideNev()
	{
		return driver.findElement(matchbuttonFromSideNev); 
	}
}
