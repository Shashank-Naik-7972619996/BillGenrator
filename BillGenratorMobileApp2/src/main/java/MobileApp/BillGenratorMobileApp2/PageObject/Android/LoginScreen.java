package MobileApp.BillGenratorMobileApp2.PageObject.Android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginScreen {
AndroidDriver driver;
	
	public LoginScreen(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
	@AndroidFindBy(className="android.widget.EditText")
	private WebElement UserName;
	@AndroidFindBys({@AndroidBy(className = "android.widget.EditText")})
	private List<WebElement> Password;
	//=driver.findElements(AppiumBy.className("android.widget.EditText")).get(1);
	//driver.findElement(AppiumBy.accessibilityId("GET STARTED")).click();
	@AndroidFindBy(xpath="//android.view.View[@content-desc='SIGN IN']")
	private WebElement SignInButton;
	@AndroidFindBy(xpath="//android.view.View[@content-desc='Please Sign In To Your Account!']")
	private WebElement SignInText;
	
	
	public void EnterUserEmail(String username)
	{
		UserName.click();
		UserName.clear();
		UserName.sendKeys(username);
	}
	
	public void EnterPassword(String pass)
	{
		Password.get(1).click();
		Password.clear();
		Password.get(1).sendKeys(pass);
	}
	public Dashboard pressSignIn()
	{
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		SignInButton.click();
		Dashboard dashboard= new Dashboard(driver);
		return dashboard;
	}
	public WebElement signinbutton()
	{
		return SignInButton;
	}
	public WebElement SignInText()
	{
		return SignInText;
	}
	
	
}
