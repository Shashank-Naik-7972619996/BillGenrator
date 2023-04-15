package MobileApp.BillGenratorMobileApp2.PageObject.Android.UtilityForm;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import MobileApp.BillGenratorMobileApp2.PageObject.Android.OrderPage;
import MobileApp.BillGenratorMobileApp2.Utils.ReusableMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class UtiltiyFormStep4 extends ReusableMethods {

	AndroidDriver driver;
	UtiltiyFormStep4 formstep4;

	public UtiltiyFormStep4(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBys({ @AndroidBy(className = "android.widget.EditText") })
	private List<WebElement> TextFields;
	@AndroidFindBy(xpath = "//android.view.View/android.view.View[4]/android.view.View[1]")
	private WebElement CustomerServiceNo;
	@AndroidFindBy(accessibility = "PREVIEW")
	private WebElement PreviewButton;
	@AndroidFindBy(xpath = "//android.view.View[@content-desc='CHECKOUT']")
	private WebElement Checkout;

	public void enterWebsiteURL(String WebSiteURL) {
		TextFields.get(0).click();
		TextFields.get(0).sendKeys(WebSiteURL);
	}

	public String getCustomerServiceNo() {
		String CustomerServiceNo1 = CustomerServiceNo.getText();
		return CustomerServiceNo1;
	}

	public UtilityPreviewPage pressPreviewButton() {

		driver.hideKeyboard();
		PreviewButton.click();
		UtilityPreviewPage utilitypreview = new UtilityPreviewPage(driver);
		return utilitypreview;
	}

	public OrderPage pressCheckoutButton() {
		Checkout.click();
		OrderPage OrderPage=new OrderPage(driver);
		// TODO Auto-generated method stub
		return OrderPage;
	}

}
