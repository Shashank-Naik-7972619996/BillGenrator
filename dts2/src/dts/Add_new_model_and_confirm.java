package dts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Add_new_model_and_confirm {

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
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("catalog-add-accessory")));
		driver.findElement(By.id("catalog-add-accessory")).click();
		
		WebElement ID = driver.findElement(By.xpath("//form[@id='add-accessory-form']/fieldset/div[4]/span[2]/span"));
		wait.until(ExpectedConditions.attributeToBeNotEmpty(ID, "key"));
		String UUID = driver.findElement(By.id("dts-tracking-id")).getText();
		System.out.println(UUID);
		
		driver.findElement(By.id("salesforce-id")).sendKeys("abc123");
		Select company = new Select(driver.findElement(By.id("companyList")));
		company.selectByVisibleText("EI");
		Select Brand = new Select(driver.findElement(By.id("brand-select")));
		Brand.selectByVisibleText("EI");
		
		driver.findElement(By.id("display-name")).sendKeys("Sample Model");
		
		Select ModelType = new Select(driver.findElement(By.id("modelType")));
		ModelType.selectByVisibleText("Ear-buds");
		
		driver.findElement(By.id("checkboxWired")).click();
		driver.findElement(By.id("checkboxBluetooth")).click();
		driver.findElement(By.id("checkboxUSB")).click();
		
		//if(ExpectedConditions.(By.id("new-accessory-action"),"style", "90px"))
		
		//Actions action = new Actions(driver); 
		//action.keyDown(Keys.HOME).perform();
		//driver.findElement(By.id("checkboxUSB")).sendKeys(Keys.CONTROL, Keys.HOME);
		wait.until(ExpectedConditions.attributeContains(By.id("new-accessory-action"),"style", "90px"));
		driver.findElement(By.id("save-accessory")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='global-alert']/span/strong")));
		
		String msg = driver.findElement(By.xpath("//div[@id='global-alert']/span")).getText();
		System.out.println(msg);
		
		WebElement a = driver.findElement(By.xpath("//form[@id='show-accessory-form']/fieldset/div[4]/span[2]"));
		wait.until(ExpectedConditions.textToBePresentInElement(a, UUID));
		String UUIDadded = driver.findElement(By.id("dts-tracking-id")).getText();
		
		System.out.println(UUIDadded);
		
		driver.findElement(By.id("nav_link_accessories_dts")).click();
		
		Select accessoryFilterSelect = new Select(driver.findElement(By.id("accessoryFilterSelect")));
		
		accessoryFilterSelect.selectByVisibleText("Recently Added");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#BrandAccessoriesTable > tbody > tr.odd > td.left.break-word-all")));
		
		
		WebElement basetable = driver.findElement(By.id("BrandAccessoriesTable"));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#BrandAccessoriesTable > tbody > tr > td.left.break-word-all")));
		
		
		int rowcount = basetable.findElements(By.cssSelector("#BrandAccessoriesTable > tbody > tr")).size();
		System.out.println(rowcount);
		
		WebElement status = driver.findElement(By.id("product_table_info"));
		String info = status.getText();
		//Showing 1 to 11 of 11 entries
		
		String val1 = info.substring(13, 15);
		String val2 = info.substring(19, 22);
		int val1Int = Integer.parseInt(val1);
		int val2Int = Integer.parseInt(val2);
		System.out.println(val1Int);
		System.out.println(val2Int);
		
		String rowtext;
		boolean isAdded=false;
		for (int a1 = 1; a1 < 10; a1++) 
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#BrandAccessoriesTable > tbody > tr")));
		for(int i=0;i<rowcount;i++)
		{
			WebElement tablerow = basetable.findElements(By.cssSelector("#BrandAccessoriesTable > tbody > tr")).get(i);
		    rowtext = tablerow.getText();
				if(rowtext.contains(UUID))
				{
					isAdded=true;
					break;
				}
				
		}
		if(!isAdded)
		{
			WebElement element = driver.findElement(By.id("BrandAccessoriesTable_next"));
        	Actions actions = new Actions(driver);
        	wait.until(ExpectedConditions.elementToBeClickable(By.id("BrandAccessoriesTable_next")));
        	actions.moveToElement(element).click().build().perform();
		}
		}
	
		if(isAdded)
		{
			System.out.println("Product added in table");
		}
		else
		{
			System.out.println("Product not added in table");
		}
	    
		//while(isAdded=true);}
		//driver.quit();
}	
}