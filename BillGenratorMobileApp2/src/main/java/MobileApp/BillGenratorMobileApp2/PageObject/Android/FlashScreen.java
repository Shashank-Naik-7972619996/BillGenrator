package MobileApp.BillGenratorMobileApp2.PageObject.Android;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.remote.http.HttpMethod;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import MobileApp.BillGenratorMobileApp2.Utils.ReusableMethods;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FlashScreen extends ReusableMethods {
	
	AndroidDriver driver;
	
	public FlashScreen(AndroidDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
	@AndroidFindBy(accessibility="GET STARTED")
	private WebElement get_started;
	
	
	public Dashboard pressGetStarted()
	{
		
		try {
			get_started.click();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		//LongPress(get_started);
		
//		//driver.findElement(AppiumBy.accessibilityId("longpress"))
//		RemoteWebElement longPress = (RemoteWebElement) get_started;
//
//		driver.addCommand(HttpMethod.POST, String.format("/session/%s/plugin/actions/longPress", driver.getSessionId()), "longPress");
//
//		driver.execute("longPress", Map.of("elementId", longPress.getId(), "pressure", 0.5, "duration", 800));
//		
//		
//		
		Dashboard dashboard= new Dashboard(driver);
		
		return dashboard;
	}
	
}
