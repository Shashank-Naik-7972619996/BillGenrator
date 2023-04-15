package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PopupMessage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//https://www.rahulshettyacademy.com/AutomationPractice
		
		System.setProperty("webdriver.chrome.driver", "D:\\ShashankWork\\Marquee Workspace\\Marquee Solutions Work\\Automation\\Webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice");
		
		driver.findElement(By.id("checkBoxOption2")).click();
		String option = driver.findElement(By.xpath("//div[@id='checkbox-example']//label[2]")).getText();
		System.out.println(option);
		
		Select s1 = new Select(driver.findElement(By.id("dropdown-class-example")));
		s1.selectByVisibleText(option);
		
		driver.findElement(By.id("name")).sendKeys(option);
		driver.findElement(By.id("alertbtn")).click();
		String AlertMsg = driver.switchTo().alert().getText();
		
		System.out.println(AlertMsg);
		if(AlertMsg.contains(option))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		Thread.sleep(6000);
		//driver.quit();
		
	}

}
//AlertMsg = "Hi";