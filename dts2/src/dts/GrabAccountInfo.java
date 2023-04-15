package dts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GrabAccountInfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\ShashankWork\\Marquee Workspace\\Marquee Solutions Work\\Automation\\Webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://devportal.dts.com/saap/login");
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver, 100);
		
		driver.findElement(By.id("username")).sendKeys("fae@dts.com");
		driver.findElement(By.id("password")).sendKeys("fa3!");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.id("loggedInAs")).click();
		driver.findElement(By.id("userAccount")).click();
		
		//@SuppressWarnings("unused")
		//WebElement Profiledetails;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='fullName']/span")));
		
		String Profile = driver.findElement(By.xpath("//span[@id='fullName']/span")).getText();
		String Profile2 = driver.findElement(By.xpath("//span[@id='partnerName']/span")).getText();
		String Profile3 = driver.findElement(By.xpath("//span[@id='user-title']/span")).getText();
		String Profile4 = driver.findElement(By.xpath("//span[@id='user-email']/a")).getText();
		String Profile5 = driver.findElement(By.xpath("//div[@id='user-panel']/div/table/tbody/tr/td[2]")).getText();
		String Profile6 = driver.findElement(By.xpath("//div[@id='user-panel']/div/table/tbody/tr/td[3]")).getText();
		String Profile7 = driver.findElement(By.id("user-status")).getText();
		String Profile8 = driver.findElement(By.xpath("//div[@id='user-panel']/div/h5")).getText();
		
		System.out.println("Account information");
		System.out.println(Profile);
		System.out.println(Profile2);
		System.out.println("Title: "+ Profile3);
		System.out.println("Email: "+ Profile4);
		System.out.println("Phone: "+ Profile5 + " "+ Profile6);
		System.out.println("Status: "+ Profile7);
		System.out.println(Profile8);
		
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.quit();
	}

}
