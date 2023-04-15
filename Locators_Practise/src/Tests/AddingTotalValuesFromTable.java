package Tests;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//evaluate the total value from the "Web Table Example" Table
public class AddingTotalValuesFromTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\ShashankWork\\Marquee Workspace\\Marquee Solutions Work\\Automation\\Webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> val = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr/td[3]"));
		int sum = 0;
		for(int i=0; i<val.size();i++)
		{
			int val1 = Integer.parseInt(val.get(i).getText());
			System.out.println(val1);
			sum = sum + val1;
		}
		System.out.println("Total= "+ sum);
	}
}