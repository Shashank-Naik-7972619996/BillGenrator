package resources;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.IOException;

public class Base {
	
	public WebDriver driver;
	public Properties prop;

	public WebDriver InitialiseDriver() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\src\\main\\java\\resources\\Data.properties");
		prop.load(fis);
		String Browser = prop.getProperty("browser");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		if(Browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addExtensions(new File("D:\\ShashankWork\\Marquee Workspace\\Marquee Solutions Work\\Automation\\Webdrivers\\SelectorsHub - XPath Plugin 4.3.2.0.crx"));
			options.setAcceptInsecureCerts(true);
	        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(capabilities);
			
			/*ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("D:\\ShashankWork\\Marquee Workspace\\Marquee Solutions Work\\Automation\\Webdrivers\\SelectorsHub - XPath Plugin 4.3.2.0.crx"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        ChromeDriver driver = new ChromeDriver(capabilities);*/
			
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		else if(Browser.equalsIgnoreCase("internet explorer") || Browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", ".\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if(Browser.equalsIgnoreCase("microsoft edge") || Browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", ".\\msedgedriver.exe");
			capabilities.setAcceptInsecureCerts(true);//setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver = new EdgeDriver(capabilities);
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	public String getscreenshot(String methodname, WebDriver driver) throws IOException
	{
		TakesScreenshot scr= (TakesScreenshot) driver;
		File screenshotFile= scr.getScreenshotAs(OutputType.FILE); 
		//String path = System.getProperty("user.dir")+"\\report\\index.html";
		String destinationFile= System.getProperty("user.dir")+"\\report\\"+methodname+".png";
		FileUtils.moveFile(screenshotFile, new File(destinationFile));
		return destinationFile;
	}
	
}

