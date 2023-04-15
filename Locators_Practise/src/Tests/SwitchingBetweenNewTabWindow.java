package Tests;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchingBetweenNewTabWindow {

	
	// Switching between tabs.
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//https://the-internet.herokuapp.com/windows
		System.setProperty("webdriver.chrome.driver", "D:\\ShashankWork\\Marquee Workspace\\Marquee Solutions Work\\Automation\\Webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		
		driver.findElement(By.xpath("//a[text()='Click Here']")).click(); //Press "Click Here"
		Set<String> ids = driver.getWindowHandles();   
		Iterator<String> it = ids.iterator();
		String parentid = it.next();
		String childid = it.next();
		 
		driver.switchTo().window(childid);    // Moving to Child Window.
		System.out.println(driver.findElement(By.cssSelector("div.example h3")).getText());
		driver.switchTo().window(parentid);   // Moving to Parent Window.
		System.out.println(driver.findElement(By.cssSelector("div.example h3")).getText());
		//Thread.sleep(6000); driver.quit();
	}

}
