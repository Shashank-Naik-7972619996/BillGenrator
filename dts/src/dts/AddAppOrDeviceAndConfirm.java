package dts;

import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddAppOrDeviceAndConfirm {

	//static TimeUnit SECONDS;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\ShashankWork\\Marquee Workspace\\Marquee Solutions Work\\Automation\\Webdrivers\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("D:\\ShashankWork\\Marquee Workspace\\Marquee Solutions Work\\Automation\\Webdrivers\\SelectorsHub 3.0.9.0.crx"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        ChromeDriver driver = new ChromeDriver(capabilities);
		
		

        	
        
        
		driver.get("http://devportal.dts.com/saap/login");
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver, 100);
		driver.findElement(By.id("username")).sendKeys("fae@dts.com");
		driver.findElement(By.id("password")).sendKeys("fa3!");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("nav_link_devices_dts")));
		driver.findElement(By.id("nav_link_devices_dts")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("product_table_paginate")));
		driver.findElement(By.id("create-device")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("type")));
		Select type =new Select(driver.findElement(By.id("type")));
		type.selectByVisibleText("Device");
		String Type1 = new Select(driver.findElement(By.id("type"))).getFirstSelectedOption().getText();
		System.out.println(Type1);
	
		
		Select producttype =new Select(driver.findElement(By.id("deviceProductType")));
		producttype.selectByVisibleText("DTS:X Ultra");
		
		Select company =new Select(driver.findElement(By.id("companies")));
		company.selectByVisibleText("Aermoer");
		
		String company1 = new Select(driver.findElement(By.id("companies"))).getFirstSelectedOption().getText();
		System.out.println(company1);
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='brand']/option[2]")));
		WebElement index = driver.findElement(By.xpath("//select[@id='brand']/option[2]"));
		wait.until(ExpectedConditions.attributeToBeNotEmpty(index, "value"));
		Select brand =new Select(driver.findElement(By.id("brand")));
		brand.selectByIndex(2);
		
		String brand1 = new Select(driver.findElement(By.id("brand"))).getFirstSelectedOption().getText();
		System.out.println(brand1);
		
		
		
		driver.findElement(By.id("name")).sendKeys("abc2");
		driver.findElement(By.xpath("//form[@id='device-form']/fieldset/div[10]/div/button")).click();
		driver.findElement(By.xpath("//form[@id='device-form']/fieldset/div[10]/div/ul/li[3]/a/label")).click();
		driver.findElement(By.xpath("//form[@id='device-form']/fieldset/div[10]/div/ul/li[4]/a/label")).click();
		
		wait.until(ExpectedConditions.attributeContains(By.id("add-device-action"),"style", "184px"));
		driver.findElement(By.id("btnSaveRecord")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("dtsId")));
		String ID= driver.findElement(By.id("dtsId")).getText();
		System.out.println("Product ID is: "+ ID);
		System.out.println(" ");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("nav_link_devices_dts")));
		driver.findElement(By.id("nav_link_devices_dts")).click();
		
		//Below for loop is for testing the product gets added after refreshing the page.
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='wrapper']/div/div[2]/div[2]/div/table/tbody/tr")));
		WebElement basetable = driver.findElement(By.xpath("//*[@id='product_table']/tbody"));
		List<WebElement> tablerow = basetable.findElements(By.xpath("//div[@class='wrapper']/div/div[2]/div[2]/div/table/tbody/tr"));
		for(int i=0;i<=1;i++)
		{
			Wait<WebDriver> stubbornWait = new FluentWait<WebDriver>(driver)
	        	    .ignoring(NoSuchElementException.class)
	        	    .ignoring(StaleElementReferenceException.class);
			if(i==1) {
				//Thread.sleep(3000);
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
				wait.until(ExpectedConditions.visibilityOfAllElements(tablerow));
		    	driver.navigate().refresh();
		    	}
			
			wait.until(ExpectedConditions.visibilityOfAllElements(tablerow));
			WebElement brand3 = driver.findElement(By.xpath("//select[@id='brand-list']/option[2]"));
			wait.until(ExpectedConditions.attributeContains(By.xpath("//select[@id='company-list']/option"), "value", "all"));
			Select company2 = new Select(driver.findElement(By.id("company-list")));
			company2.selectByVisibleText(company1);
		
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='brand-list']/option[2]")));
			wait.until(ExpectedConditions.attributeToBeNotEmpty(brand3, "value"));
			Select brand2 = new Select(driver.findElement(By.id("brand-list")));
			brand2.selectByVisibleText(brand1);
			wait.until(ExpectedConditions.visibilityOfAllElements(tablerow));
			}
		
	    
		wait.until(ExpectedConditions.visibilityOfAllElements(tablerow));
	    
		//WebElement basetable = driver.findElement(By.xpath("//*[@id='product_table']/tbody"));
		//int records_in_page = basetable.findElements(By.xpath("//div[@class='wrapper']/div/div[2]/div[2]/div/table/tbody/tr")).size();
		boolean isAdded=false;
		String rowtext;
	
	    //int num_of_clicks = Integer.parseInt(driver.findElement(By.xpath(".//*[@id='content']/p[1]/a[3]")).getText());
	    for (int i = 1; i < 100; i++) 
	    {
	    	Wait<WebDriver> stubbornWait = new FluentWait<WebDriver>(driver)
	        	    .ignoring(NoSuchElementException.class)
	        	    .ignoring(StaleElementReferenceException.class);
	    	wait.until(ExpectedConditions.visibilityOfAllElements(tablerow));
	    	int records_in_page = tablerow.size();
	        for (int j = 0; j < records_in_page; j++) 
	        {
	        	rowtext = tablerow.get(j).getText();
	            if(rowtext.contains(ID))
	            {
	            	//System.out.println("Product is added in table");
	            	isAdded=true;
					break;
	            }
	        }
	        if(!isAdded && records_in_page==25)
			{
	        	WebElement element = driver.findElement(By.id("product_table_next"));
	        	Actions actions = new Actions(driver);
	        	actions.moveToElement(element).click().build().perform();
	        }
	    }
	    
	    if(isAdded)
		{
			System.out.println("Product added in table");
		}
		else
		{
			System.out.println("Product not added or showing in table");
		}
	    //Thread.sleep(6000); driver.quit();
	}
}