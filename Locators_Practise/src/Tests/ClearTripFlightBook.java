package Tests;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class ClearTripFlightBook {

	
	//Book flight with options select , calender date based on state active, dynamic dropdown based on text entered.And verify the error message.
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\ShashankWork\\Marquee Workspace\\Marquee Solutions Work\\Automation\\Webdrivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("D:\\ShashankWork\\Marquee Workspace\\Marquee Solutions Work\\Automation\\Webdrivers\\SelectorsHub 3.0.9.0.crx"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        ChromeDriver driver = new ChromeDriver(capabilities);
		
		driver.get("https://www.cleartrip.com/");
		driver.manage().window().maximize();

		Select Adult = new Select(driver.findElement(By.cssSelector("select.bc-neutral-100.bg-transparent")));
		Adult.selectByIndex(5);

		Select Childrens = new Select(driver.findElement(By.xpath("//div[3]//select[1]")));
		Childrens.selectByVisibleText("3");

		//driver.findElement(By.id("DepartDate")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

		driver.findElement(By.id("MoreOptionsLink")).click();

		WebElement Airline = driver.findElement(By.id("AirlineAutocomplete"));
		Airline.sendKeys("IndiGo"+ Keys.ENTER);
		//Airline.sendKeys(Keys.ARROW_DOWN .ENTER);

		driver.findElement(By.id("SearchBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("#homeErrorMessage")).getText());

		//Thread.sleep(6000); driver.quit();
		
		//The website is changed hence this code will wont work now.
	}
}