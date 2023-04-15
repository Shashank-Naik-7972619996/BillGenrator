package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.landingPage;
import Resources.Base1;

public class homePage extends Base1 {
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(Base1.class.getName());
	landingPage lp;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver= initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void testingLandingpage() throws IOException
	{
		lp = new landingPage(driver);
		Assert.assertEquals(lp.getCourseSectionTitle().getText(), "FEATURED COURSES");
		log.info("Text is displayed as expected");
		
	}
	
	@Test
	public void testvideoBanner()
	{
		lp = new landingPage(driver);
		Assert.assertEquals(lp.getvideoBanner().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("Text is displayed as expected");
		
	}
	@AfterTest
	public void  closeinstance()
	{
		driver.close();
	}
}