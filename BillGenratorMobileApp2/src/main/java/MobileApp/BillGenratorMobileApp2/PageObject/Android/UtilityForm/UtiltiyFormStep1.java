package MobileApp.BillGenratorMobileApp2.PageObject.Android.UtilityForm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import MobileApp.BillGenratorMobileApp2.Utils.ReusableMethods;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class UtiltiyFormStep1 extends ReusableMethods {

	AndroidDriver driver;

	public UtiltiyFormStep1(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBys({ @AndroidBy(className = "android.widget.EditText") })
	private List<WebElement> TextFields;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Your Name*']")
	private WebElement YourName;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Your Street Address*']")
	private WebElement YourStreetAddress;
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Your City*']")
	private WebElement YourCity;
	
	@AndroidFindBy(accessibility = "Your State*")
	private WebElement YourState;
	
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc='YOUR INFORMATION']/following-sibling::android.widget.ScrollView/android.widget.EditText[contains(@text,'Zip')]")
	private WebElement YourZip;
	
	@AndroidFindBy(accessibility = "California")
	private WebElement California;
	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'ADD UTILITY LOGO')]")
	private WebElement UtilityLogo;
	@AndroidFindBy(accessibility = "Gallery")
	private WebElement Gallery;
	
	@AndroidFindBy(accessibility = "com.google.android.documentsui:id/icon_mime_lg")
	private WebElement Image;
	
	@AndroidFindBy(accessibility = "NEXT")
	private WebElement NEXTButton;
	@AndroidFindBys({ @AndroidBy(className = "//*[@class='android.widget.ScrollView']/*[@checkable='false']") })
	private List<WebElement> AllFields;

	public void ClickUtilityLogo() throws InterruptedException {

		UtilityLogo.click();
		
	}

	public void ClickGallery() throws InterruptedException {

		Gallery.click();
	}

	public void ClickonImage() throws InterruptedException {

		try {
			Image.click();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			e.printStackTrace();
		}
	}

	public void enterYourName(String yourname) {
		YourName.click();
		YourName.sendKeys(yourname);
	}

	public void enterYourStreetAddress(String StreetAddress) {
		YourStreetAddress.click();
		YourStreetAddress.sendKeys(StreetAddress);
	}

	public void EnterCity(String EnterCity) {

		Scrolluntil("Your City*");
		YourCity.click();
		YourCity.sendKeys(EnterCity);
	}

	public void EnterZip(String zip) {

		Scrolluntil("Company Zip*");
		YourZip.click();
		YourZip.sendKeys(zip);
	}

	public void SelectState() {
		YourState.click();
		California.click();
	}

	public UtilityFormStep2 pressNextButton() {
		NEXTButton.click();
		UtilityFormStep2 utilityFormsStep2 = new UtilityFormStep2(driver);
		return utilityFormsStep2;
	}

	public String listOfAllElements() {
		for (int i = 0; i < AllFields.size(); i++) {
			System.out.println("All Content-Desc= "+AllFields.get(i).getAttribute("content-desc"));
			System.out.println("All Text= "+AllFields.get(i).getText());
			return AllFields.get(i).getText();
		}
		return null;
	}

}
