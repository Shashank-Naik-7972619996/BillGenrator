package MobileApp.BillGenratorMobileApp2.PageObject.Android.W2Form;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import MobileApp.BillGenratorMobileApp2.Utils.ReusableMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class W2FormStep2 extends ReusableMethods {
	AndroidDriver driver;

	public W2FormStep2(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}

	@AndroidFindBys({ @AndroidBy(className = "android.view.View") })
	private List<WebElement> Elements;
	@AndroidFindBy(xpath = "//*[@text='Social Security Number']")
	private WebElement Social_Security_Number;
	@AndroidFindBy(xpath = "//*[@text='Identification Number(EIN)']")
	private WebElement Identification_Number;
	@AndroidFindBy(accessibility = "PRIVIOUS")
	private WebElement PRIVIOUS;
	@AndroidFindBy(accessibility = "NEXT")
	private WebElement NEXT;

	public void enterSocial_Security_Number(String Social_Security_Number1) {
		Social_Security_Number.click();
		Social_Security_Number.sendKeys(Social_Security_Number1);
	}

	public void enterIdentification_Number(String Identification_Number1) {
		Identification_Number.click();
		Identification_Number.sendKeys(Identification_Number1);
	}

	public void pressPRIVIOUS() {
		PRIVIOUS.click();
	}

	public String getOMBNo() {
		for (int i = 0; i < Elements.size(); i++) {
			if (Elements.get(i).getAttribute("content-desc").contains("OMB NO")) {
				return Elements.get(i).getText();
			}
		}
		return null;
	}

	public W2FormStep3 pressNEXT() {
		NEXT.click();
		W2FormStep3 W2FormStep3 = new W2FormStep3(driver);
		return W2FormStep3;
	}
}
