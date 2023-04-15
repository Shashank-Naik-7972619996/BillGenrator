package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CrickbuzzScoreboard {
	
	public WebDriver driver;
	public CrickbuzzScoreboard(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	private By FirstTeamName = By.xpath("//*[@id='innings_1']/div[1]/div[1]/span[1]");////*[@id="innings_1"]/div/div/span[1]
	private By SecondTeamName = By.xpath("//*[@id='innings_2']/div[1]/div[1]/span[1]");
	private By FirstTeamScore = By.xpath("//*[@id='innings_1']/div[1]/div[1]/span[2]");
	private By SecondTeamScore = By.xpath("//*[@id='innings_2']/div[1]/div[1]/span[2]");
	
	private By BatterTableInning1 = By.xpath("//*[@id='innings_1']/div[1]/div[@class='cb-col cb-col-100 cb-scrd-itms']");
	//*[@id='innings_1']/div[1]/div[@class="cb-col cb-col-100 cb-scrd-itms"]
	private By BowlerTableInning1 = By.xpath("//*[@id='innings_1']/div[4]/div[@class='cb-col cb-col-100 cb-scrd-itms ']");
	//*[@id='innings_1']/div[4]/div[@class="cb-col cb-col-100 cb-scrd-itms "]
	private By BatterTableInning2 = By.xpath("//*[@id='innings_2']/div[1]/div[@class='cb-col cb-col-100 cb-scrd-itms']");
	private By BowlerTableInning2 = By.xpath("//*[@id='innings_2']/div[4]/div[@class='cb-col cb-col-100 cb-scrd-itms ']");
	private By MatchResultText = By.xpath("//div[@class='cb-col cb-scrcrd-status cb-col-100 cb-text-complete ng-scope']");
	
	public WebElement MatchResultText()
	{
		return driver.findElement(MatchResultText); 
	}
	public List<WebElement> BatterTableInning1()
	{
		return driver.findElements(BatterTableInning1); 
	}
	
	public List<WebElement> BowlerTableInning1()
	{
		return driver.findElements(BowlerTableInning1); 
	}
	public List<WebElement> BatterTableInning2()
	{
		return driver.findElements(BatterTableInning2); 
	}
	public List<WebElement> BowlerTableInning2()
	{
		return driver.findElements(BowlerTableInning2); 
	}
	
	
	public WebElement FirstTeamName()
	{
		return driver.findElement(FirstTeamName); 
	}
	
	public WebElement SecondTeamName()
	{
		return driver.findElement(SecondTeamName); 
	}

	public WebElement FirstTeamScore()
	{
		return driver.findElement(FirstTeamScore); 
	}
	public WebElement SecondTeamScore()
	{
		return driver.findElement(SecondTeamScore); 
	}
}
