package Tests;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Calender {

	public static void main(String[] args) throws InterruptedException {
// TODO Auto-generated method stub

System.setProperty("webdriver.chrome.driver", "D:\\ShashankWork\\Marquee Workspace\\Marquee Solutions Work\\Automation\\Webdrivers\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("D:\\ShashankWork\\Marquee Workspace\\Marquee Solutions Work\\Automation\\Webdrivers\\SelectorsHub 3.0.9.0.crx"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        ChromeDriver driver = new ChromeDriver(capabilities);
        
		driver.get("https://www.path2usa.com/travel-companions");
//April 23
		driver.findElementByXPath(".//*[@id='travel_date']").click();
		
		WebElement month = driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']"));
		if(!month.getText().contains("November")) {
		while (!month.getText().contains("November")) {
			driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
		}
		}

		month.getRect().getDimension().getWidth();
		List<WebElement> dates = driver.findElements(By.xpath("//td[@class='day']"));
//Grab common attribute//Put into list and iterate
		int count = dates.size();

		for (int i = 0; i < count; i++) {
			String text = dates.get(i).getText();
			if (text.equals("28")) {
				dates.get(i).click();
				break;
			}
		}
		//Thread.sleep(6000); driver.quit();
	}
}