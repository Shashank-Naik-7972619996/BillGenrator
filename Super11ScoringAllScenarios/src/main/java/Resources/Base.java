package Resources;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\src\\main\\java\\Resources\\data.properties");
		//D:\ShashankWork\Marquee Workspace\Marquee Solutions Work\Automation\WorkspaceForEclipse\E2EProject\src\main\java\Resources
		prop.load(fis);

		//String browserName = System.getProperty("browser");
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if (browserName.contains("chrome")) {

			ChromeOptions options =new ChromeOptions();
			System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
			if(browserName.contains("headless"))
			{
			 options.addArguments("headless");
			}
			
			driver = new ChromeDriver(options);
			
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","D:\\ShashankWork\\Marquee Workspace\\Marquee Solutions Work\\Automation\\Webdrivers\\geckodriver.exe"); // Setting system properties of FirefoxDriver
			driver = new FirefoxDriver();
			
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			// Defining System Property for the IEDriver 
			System.setProperty("webdriver.ie.driver", "D:\\ShashankWork\\Marquee Workspace\\Marquee Solutions Work\\Automation\\Webdrivers\\IEDriverServer.exe"); 

			// Instantiate a IEDriver class. 
			driver=new InternetExplorerDriver();
		}
		long a = Integer.parseInt(prop.getProperty("Timeout"));
		driver.manage().timeouts().implicitlyWait(a, TimeUnit.SECONDS);
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
