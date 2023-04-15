package Tests;

import java.io.File;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dynamic_Dropdown2 {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"D:\\ShashankWork\\Marquee Workspace\\Marquee Solutions Work\\Automation\\Webdrivers\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("D:\\ShashankWork\\Marquee Workspace\\Marquee Solutions Work\\Automation\\Webdrivers\\SelectorsHub 3.0.9.0.crx"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        ChromeDriver driver = new ChromeDriver(capabilities);
		
		driver.get("http://spicejet.com"); // URL in the browser

//  //a[@value='MAA']  - Xpath for chennai
//  //a[@value='BLR']  - Xpath for banglore
//ctl00_mainContent_ddl_originStation1_CTXT
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_mainContent_ddl_originStation1")));
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1")).click();

		driver.findElement(By.xpath("//a[@value='BLR']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")));

//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))
				.click();

//driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
//selectedtext
		System.out.println(driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"))
				.getAttribute("selectedtext"));
		Thread.sleep(6000);
		driver.quit();

	}

}
