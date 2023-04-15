package Functions;


import org.openqa.selenium.WebDriver;

public class GoToURL {

	WebDriver driver;
	//Functions.ExceptionHandlar ObjExcept;
	
	public GoToURL(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public boolean GetURL() 
	{
		try
		{
			driver.get("https://www.bhaane.com/");
			driver.manage().window().maximize();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
}