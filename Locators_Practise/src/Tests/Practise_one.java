package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practise_one {

public static void main(String[] args) throws InterruptedException {
// TODO Auto-generated method stub
	System.setProperty("webdriver.chrome.driver", "D:\\ShashankWork\\Marquee Workspace\\Marquee Solutions Work\\Automation\\Webdrivers\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/#/practice-project");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		driver.findElement(By.xpath("//li[@class='current']/following-sibling::li/a[text()='Courses']")).click();
		System.out.println(driver.findElement(By.xpath(".//img[@class='course-box-image']/parent::div")).getAttribute("class"));
		Thread.sleep(6000);
		//driver.quit();
	}
}