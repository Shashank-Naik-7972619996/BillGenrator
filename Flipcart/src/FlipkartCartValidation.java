import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartCartValidation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\ShashankWork\\Marquee Workspace\\Marquee Solutions Work\\Automation\\Webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver, 50);
		driver.get("https://flipkart.com");
		driver.findElement(By.xpath("//form[@autocomplete='on']/div/input")).sendKeys("shashanknaik1990@gmail.com");
		driver.findElement(By.xpath("//form[@autocomplete='on']/div[2]/input")).sendKeys("shaktiman1234");
		driver.findElement(By.xpath("//form[@autocomplete='on']/div[3]/button/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Samsung s6" + Keys.ENTER);
		Thread.sleep(1000);
		String ModelName = driver.findElement(By.xpath("//div[@id='container']/div/div[3]/div[2]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]")).getText();
		driver.findElement(By.xpath("//div[@id='container']/div/div[3]/div[2]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]")).click();
		System.out.println(ModelName);
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTab.get(1));
		
		driver.findElement(By.xpath("//ul[@class='row']/li/button")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='container']/div/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div[1]/div[1]/a")));

		String addedcart = driver.findElement(By.xpath("//div[@id='container']/div/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div[1]/div[1]/a")).getText();
		System.out.println(addedcart);
		
		if(ModelName.equals(addedcart))
		{
			System.out.println("Product added is correct Test case Pass");
		}
		else
		{
			System.out.println("Wrong product added Test case Fail");
		}
		
		Thread.sleep(6000);
		driver.quit();
	}

}
