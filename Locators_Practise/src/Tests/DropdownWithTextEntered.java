package Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownWithTextEntered {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\ShashankWork\\Marquee Workspace\\Marquee Solutions Work\\Automation\\Webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("autocomplete")).sendKeys("Ind");
		Thread.sleep(2000l);
		
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] div"));

		for(int i=0; i<options.size();i++)
		{
			String opt= options.get(i).getText();
			if(opt.equalsIgnoreCase("India"))
			{
				options.get(i).click();
				break;
			}
		}
		//Thread.sleep(2000l);
		//String str= driver.findElement(By.id("autocomplete")).getText();
		System.out.println(driver.findElement(By.id("autocomplete")).getText());
	}
}