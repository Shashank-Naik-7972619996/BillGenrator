package Tests;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ecommerce_Logical {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\ShashankWork\\Marquee Workspace\\Marquee Solutions Work\\Automation\\Webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot", "Pumpkin", "Mushroom" };
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);

		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < products.size(); i++) {

			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();

			List<String> itemsNeededList = Arrays.asList(itemsNeeded);

			if (itemsNeededList.contains(formattedName)) {
				j++;
				// click on Add to cart
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == itemsNeeded.length) {
					break;
				}
			}
		}
	}
}