import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GrabFlipcartProfileDetails {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\ShashankWork\\Marquee Workspace\\Marquee Solutions Work\\Automation\\Webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait wait=new WebDriverWait(driver, 50);
		driver.get("https://flipkart.com");
		driver.findElement(By.xpath("//form[@autocomplete='on']/div/input")).sendKeys("shashanknaik1990@gmail.com");
		driver.findElement(By.xpath("//form[@autocomplete='on']/div[2]/input")).sendKeys("shaktiman1234");
		driver.findElement(By.xpath("//form[@autocomplete='on']/div[3]/button/span")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='container']/div/div[1]/div[1]/div[2]/div[3]/div/div/div/div")));

		driver.findElement(By.xpath("//div[@id='container']/div/div[1]/div[1]/div[2]/div[3]/div/div/div/div")).click();
		driver.findElement(By.xpath("//div[@id='container']/div/div[1]/div[1]/div[2]/div[3]/div/div/div/div")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='container']/div/div[1]/div[1]/div[2]/div[3]/div/div/div[2]/div[2]/div/ul/li")));

		driver.findElement(By.xpath("//div[@id='container']/div/div[1]/div[1]/div[2]/div[3]/div/div/div[2]/div[2]/div/ul/li")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='firstName']")));

		String Firstname = driver.findElement(By.xpath("//input[@name='firstName']")).getAttribute("value");
		String Lastname = driver.findElement(By.xpath("//input[@name='lastName']")).getAttribute("value");
		System.out.println("Profile Name is:" + Firstname + " " + Lastname);
		
		Thread.sleep(6000);
		driver.quit();
	}

}
