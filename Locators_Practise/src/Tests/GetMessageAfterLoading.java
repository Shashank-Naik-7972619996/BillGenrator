package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GetMessageAfterLoading {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//www.itgeared.com/demo/1506-ajax-loading.html
		System.setProperty("webdriver.chrome.driver", "D:\\ShashankWork\\Marquee Workspace\\Marquee Solutions Work\\Automation\\Webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");
		driver.findElement(By.linkText("Click to load get data via Ajax!")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#results")));
		System.out.println(driver.findElement(By.cssSelector("#results")).getText());
		//Thread.sleep(6000); driver.quit();
	}
}