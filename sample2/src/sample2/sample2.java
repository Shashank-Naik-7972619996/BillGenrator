package sample2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class sample2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\ShashankWork\\Marquee Workspace\\Marquee Solutions Work\\Automation\\Webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
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
		
		//String DeviceID = driver.findElement(By.id("dtsId")).getText();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("type")));
		Select type =new Select(driver.findElement(By.id("type")));
		type.selectByVisibleText("Device");
		String Type1 = new Select(driver.findElement(By.id("type"))).getFirstSelectedOption().getText();
		System.out.println(Type1);
	
		
		Select producttype =new Select(driver.findElement(By.id("deviceProductType")));
		producttype.selectByVisibleText("DTS:X Ultra");
		
		//driver.findElement(By.id("companies")).click();
		//driver.findElement(By.id("companies")).sendKeys(Keys.ARROW_DOWN);
		Select company =new Select(driver.findElement(By.id("companies")));
		company.selectByVisibleText("Company Test Aging");
		//String company1 = company.toString();
		String company1 = new Select(driver.findElement(By.id("companies"))).getFirstSelectedOption().getText();
		System.out.println(company1);
		
		//driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='brand']/option[2]")));
		WebElement index = driver.findElement(By.xpath("//select[@id='brand']/option[2]"));
		wait.until(ExpectedConditions.attributeToBeNotEmpty(index, "value"));
		Select brand =new Select(driver.findElement(By.id("brand")));
		brand.selectByIndex(1);
		//String brand1 = brand.toString();
		String brand1 = new Select(driver.findElement(By.id("brand"))).getFirstSelectedOption().getText();
		System.out.println(brand1);
		
		
		
		driver.findElement(By.id("name")).sendKeys("abc2");
		driver.findElement(By.xpath("//form[@id='device-form']/fieldset/div[10]/div/button")).click();
		driver.findElement(By.xpath("//form[@id='device-form']/fieldset/div[10]/div/ul/li[3]/a/label")).click();
		driver.findElement(By.xpath("//form[@id='device-form']/fieldset/div[10]/div/ul/li[4]/a/label")).click();
		
		driver.findElement(By.id("btnSaveRecord")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("dtsId")));
		String ID= driver.findElement(By.id("dtsId")).getText();
		System.out.println("Product ID is: "+ ID);
		System.out.println(" ");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("nav_link_devices_dts")));
		driver.findElement(By.id("nav_link_devices_dts")).click();
		
		wait.until(ExpectedConditions.attributeContains(By.xpath("//select[@id='company-list']/option"), "value", "all"));
		Select company2 = new Select(driver.findElement(By.id("company-list")));
		company2.selectByVisibleText(company1);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='brand-list']/option[2]")));
		WebElement brand3 = driver.findElement(By.xpath("//select[@id='brand-list']/option[2]"));
		wait.until(ExpectedConditions.attributeToBeNotEmpty(brand3, "value"));
		Select brand2 = new Select(driver.findElement(By.id("brand-list")));
		brand2.selectByVisibleText(brand1);
	    
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#product_table > tbody > tr")));
		//driver.findElement(By.id("product_table_next")).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#product_table > tbody > tr")));
		//driver.findElement(By.id("product_table_previous")).click();
		//WebElement tableinfo = driver.findElement(By.id("product_table_info"));
		//"Showing 76 to 97 of 97 entries"
		/*String tableI = tableinfo.getText();
		String val1 = tableI.substring(13, 16);
		String val2 = tableI.substring(19, 22);;
		 
		System.out.println("val1 is: " + val1);
		System.out.println("val2 is: " + val2);
		
		int entries = Integer.parseInt(val2);
		int number_of_pagesint = 0;
		System.out.println(entries);
		
		float number_of_pages = (float)entries/25;
		System.out.println(number_of_pages);
		if((number_of_pages-(int)number_of_pages)!=0)
		{
			number_of_pagesint = (int)number_of_pages;
			number_of_pagesint = number_of_pagesint + 1;
			number_of_pages = number_of_pagesint;
		}
		System.out.println(number_of_pages);*/
		boolean isAdded=false;
	    //int num_of_clicks = Integer.parseInt(driver.findElement(By.xpath(".//*[@id='content']/p[1]/a[3]")).getText());
	    for (byte i = 0; i < 30; i++) 
	    {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#product_table > tbody > tr")));
	    	List<WebElement> records_in_page = driver.findElements(By.cssSelector("#product_table > tbody > tr"));
	        for (byte j = 0; j < records_in_page.size(); j++) 
	        {
	        	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#product_table > tbody > tr")));
	            String Issue_Subject = driver.findElement(By.xpath("//table[@id='product_table']/tbody/tr[" + (j+1) + "]/td[6]")).getText();
	            WebElement row = driver.findElement(By.xpath("//table[@id='product_table']/tbody/tr[" + (j+1) + "]/td[6]"));
	            System.out.println(Issue_Subject);
	            if(row.isDisplayed() && Issue_Subject.contains(ID))
	            {
	            	isAdded=true;
					System.out.println("Product is added in table");
					break;
	            }
	        }
	        WebElement tableinfo = driver.findElement(By.id("product_table_info"));
	        String tableI = tableinfo.getText();
	        String a = tableI.substring(13,16);
	        System.out.println(a);
	        if(!isAdded)
			{
	        	WebElement element = driver.findElement(By.id("product_table_next"));
	        	Actions actions = new Actions(driver);
	        	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("product_table_next")));
	        	actions.moveToElement(element).click().build().perform();
	        	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#product_table > tbody > tr")));
			}
	    }
	    if(!isAdded)
        {
        	System.out.println("Product is not added in table");
        }
	    Thread.sleep(6000);
		driver.quit();
	}
}