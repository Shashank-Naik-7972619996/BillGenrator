package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import PageObject.landingPage;
import PageObject.loginPage;
import Resources.Base1;

public class BaseTest extends Base1 {
	
	
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(Base1.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver= initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj = new Object[2][2];
		//data1
		obj[0][0]="test";
		obj[0][1]="Testpassword";
		
		//data2
		obj[1][0]="tests";
		obj[1][1]="Testpassword2";
		return obj;
	}
	
	
	
	@Test(dataProvider="getData")
	public void testingLogindetails(String username, String password) throws IOException
	{
		driver.get(prop.getProperty("url"));
		log.info("Landing page loaded");
		landingPage lp = new landingPage(driver);
		
		lp.getlogin().click();
		log.debug("Login page opens");
		loginPage loginp = new loginPage(driver);
		loginp.getEmail().sendKeys(username);
		loginp.getPass().sendKeys(password);
		loginp.getLogin().click();
		System.out.println(loginp.getAlert().getText());
		log.info("data entered");
		Assert.assertTrue(false);
	}
	@AfterTest
	public void closeinstance()
	{
		driver.close();
	}
	
}
