package MobileApp.BillGenratorMobileApp2.PageObject.Android;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import MobileApp.BillGenratorMobileApp2.Utils.ReusableMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Dashboard extends ReusableMethods {
	
	
AndroidDriver driver;
	
	public Dashboard(AndroidDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(accessibility="Login")
	private WebElement Login;
	@AndroidFindBy(accessibility="Open navigation menu")
	private WebElement Open_navigation_menu;
	//driver.findElement(AppiumBy.accessibilityId("GET STARTED")).click();
	@AndroidFindBy(accessibility="A Team Of Experts")
	private WebElement A_Team_Of_Experts;
	
	
	
	public WebElement returnwebelement()
	{
		return Open_navigation_menu;
	}
	public SideNevigationMenu pressRigtSideNevigationMenu()
	{
		Open_navigation_menu.click();
		SideNevigationMenu SideNevigationMenu = new SideNevigationMenu(driver);
		return SideNevigationMenu;
	}
	public LoginScreen pressLogin()
	{
		LoginScreen LoginScreen = new LoginScreen(driver);
		try {
			Login.click();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		return LoginScreen;
	}
	public void drag_A_Team_Of_Experts()
	{
		drag(A_Team_Of_Experts, 898,1478);
		swipeDownNotification();
	}
}
