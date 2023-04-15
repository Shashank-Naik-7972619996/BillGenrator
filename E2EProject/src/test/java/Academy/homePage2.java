package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.landingPage;
import Resources.Base1;

public class homePage2 extends Base1 {
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(Base1.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver= initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void testingNevigationBar() throws IOException
	{
		landingPage lp = new landingPage(driver);
		
		Assert.assertTrue(lp.getnevigationMenuBar().isDisplayed());
		log.info("Nevigation bar is displayed as expected");
		//Assert.assertTrue(false);
	}

	@AfterTest
	public void  closeinstance()
	{
		driver.close();
	}
	@AfterSuite
	public void close_All_Browser_Instances()
	{
		driver.quit();
	}
}
