package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

public class Test99GuruLogin {

    String driverPath = "D:\\ShashankWork\\Marquee Workspace\\Marquee Solutions Work\\Automation\\Webdrivers\\chromedriver.exe";
    
    WebDriver driver;

    Pages.Guru99Login objLogin;

    Pages.Guru99HomePage objHomePage;

    @BeforeTest

    public void setup(){

	System.setProperty("webdriver.gecko.driver", driverPath);
        
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://demo.guru99.com/V4/");

    }
    @Test(priority=0)

    public void test_Home_Page_Appear_Correct() throws InterruptedException{


    objLogin = new Pages.Guru99Login(driver);

  

    String loginPageTitle = objLogin.getLoginTitle();

    Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

   

    objLogin.loginToGuru99("mngr238586", "buzYguv");

    

    objHomePage = new Pages.Guru99HomePage(driver);

  

    Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mngr238586"));

    Thread.sleep(6000);
	driver.quit();}
}