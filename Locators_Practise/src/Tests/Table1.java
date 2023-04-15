package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class Table1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\ShashankWork\\Marquee Workspace\\Marquee Solutions Work\\Automation\\Webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		int raw = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr")).size();
		int cal = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr/th")).size();
		String seconddata = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr")).get(2).getText();
		System.out.println("Number of raws: " +raw);
		System.out.println("Number of columns: "+cal);
		System.out.println(seconddata);
	}

}
