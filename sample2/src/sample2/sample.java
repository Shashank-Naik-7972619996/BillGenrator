package sample2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class sample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\ShashankWork\\Marquee Workspace\\Marquee Solutions Work\\Automation\\Webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://devportal.dts.com/saap/login");
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver, 100);
		driver.findElement(By.id("username")).sendKeys("fae@dts.com");
		driver.findElement(By.id("password")).sendKeys("fa3!");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//li[@id='nav_link_home_dts']/a")).click();
		Thread.sleep(6000);
		driver.quit();
	}

}