package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Functions.PropertiesCaller;

public class ProductTable {

	WebDriver driver;
	Functions.ExceptionHandlar ObjExcept;
	Functions.PropertiesCaller Obj;
	
	public ProductTable(WebDriver driver)
	{
		this.driver=driver;
		Obj = new PropertiesCaller();
		ObjExcept = new Functions.ExceptionHandlar(driver);
	}
		
	public void AccessoryFilterSelect()
	{
		Select FilterSelect = new Select(driver.findElement(By.id(Obj.Properties("AccessoryFilterSelect"))));
	    FilterSelect.selectByVisibleText("Recently Added");
	}
	
	public boolean PTable(String UUID)
	{
		WebDriverWait wait = ObjExcept.WaitExceptionHandling();
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Obj.Properties("TableRaw"))));
			WebElement basetable = driver.findElement(By.id(Obj.Properties("TableID")));
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Obj.Properties("TableRaw"))));
			int rowcount = basetable.findElements(By.cssSelector(Obj.Properties("TableRaw"))).size();
			
			
			String rowtext;
			boolean isAdded = false;
			for (int a1 = 1; a1 < 10; a1++) 
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Obj.Properties("TableRaw"))));
			for(int i=0;i<rowcount;i++)
			{
				WebElement tablerow = basetable.findElements(By.cssSelector(Obj.Properties("TableRaw"))).get(i);
			    rowtext = tablerow.getText();
				
					if(rowtext.contains(UUID))
					{
						isAdded=true;
						return isAdded;
					}
			}
			if(!isAdded)
			{
				WebElement element = driver.findElement(By.id(Obj.Properties("GoNextPage")));
				if(element.isDisplayed()) {
					Actions actions = new Actions(driver);
					try {
						wait.until(ExpectedConditions.elementToBeClickable(By.id(Obj.Properties("GoNextPage"))));
						actions.moveToElement(element).click().build().perform();
						if(!isAdded)
						{
							System.out.println("Product is not added in table");
							isAdded = false;
							return isAdded;
						}
					} catch (Exception e) {
						System.out.println("Element is not clickable");
					}
				}
			}
			}

		}catch(TimeoutException e)
		{
			System.out.println("Table not Found");
		}
		return false;
		
}
}
