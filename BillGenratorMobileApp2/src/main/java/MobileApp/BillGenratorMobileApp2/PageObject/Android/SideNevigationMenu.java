package MobileApp.BillGenratorMobileApp2.PageObject.Android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import MobileApp.BillGenratorMobileApp2.PageObject.Android.InvoiceForm.InvoiceFormStep1;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.Misc1099.MiscFormStep1;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.UtilityForm.UtiltiyFormStep1;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.W2Form.W2FormStep1;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class SideNevigationMenu {

	
AndroidDriver driver;


@AndroidFindBy(xpath="//*[@content-desc='W-2 Form']")
private WebElement W2Form;
@AndroidFindBy(xpath="//android.widget.ImageView[@content-desc='Invoice Information']")
private WebElement InvoiceForm;
@AndroidFindBy(xpath="//android.widget.ImageView[@content-desc='MISC 1099']")
private WebElement MISC1099;


	public SideNevigationMenu(AndroidDriver driver2)
	{
		this.driver=driver2;
		PageFactory.initElements(new AppiumFieldDecorator(driver2), this);
	}
	
	public UtiltiyFormStep1 ClickUtilityBill()throws InterruptedException
	{
		TouchAction touch = new TouchAction(driver);
		touch.tap(PointOption.point(135, 692)).perform();
		UtiltiyFormStep1 UtiltiyFormStep1 = new UtiltiyFormStep1(driver);
		return UtiltiyFormStep1;
	}
	public W2FormStep1 ClickW2Form()throws InterruptedException
	{
		W2Form.click();
		W2FormStep1 W2FormStep1 = new W2FormStep1(driver);
		return W2FormStep1;
	}
	
	public InvoiceFormStep1 ClickInvoiceForm()throws InterruptedException
	{
		InvoiceForm.click();
		InvoiceFormStep1 InvoiceFormStep1 = new InvoiceFormStep1(driver);
		return InvoiceFormStep1;
	}
	public MiscFormStep1 ClickMisc1099()throws InterruptedException
	{
		MISC1099.click();
		MiscFormStep1 MiscFormStep1 = new MiscFormStep1(driver);
		return MiscFormStep1;
	}
	
}
