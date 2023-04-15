package MobileApp.BillGenratorMobileApp2.PageObject.Android.InvoiceForm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import MobileApp.BillGenratorMobileApp2.PageObject.Android.W2Form.W2FormStep2;
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

public class InvoiceFormStep1 extends ReusableMethods {
	AndroidDriver driver;

	public InvoiceFormStep1(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}

	@AndroidFindBys({ @AndroidBy(className = "android.widget.EditText") })
	private List<WebElement> TextFields;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc = 'FROM']/following-sibling::android.widget.ScrollView/android.widget.EditText[1]")
	private WebElement InvoiceTitle;
	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'LOGO')]")
	private WebElement LogoButton;
	@AndroidFindBy(accessibility = "Gallery")
	private WebElement Gallery;
	@AndroidFindBy(xpath = "//*[contains(@text,'Address 2')]")
	private WebElement FromAddress2;
	@AndroidFindBy(xpath = "//*[contains(@text,'City*')]")
	private WebElement FromCity;
	@AndroidFindBy(xpath = "//*[contains(@content-desc,'State')]")
	private WebElement FromState;
	@AndroidFindBy(xpath = "//*[contains(@text,'Zip')]")
	private WebElement FromZip;
	@AndroidFindBy(xpath = "//*[contains(@text,'Phone')]")
	private WebElement FromPhone;
	@AndroidFindBy(xpath = "//*[contains(@text,'Business Number*')]")
	private WebElement FromBusinessNumber;
	@AndroidFindBy(accessibility = "NEXT")
	private WebElement NEXT;
	@AndroidFindBy(xpath = "//*[@text='Name*']")
	private WebElement FROMNAME;
	@AndroidFindBy(xpath = "//*[@text='Email*']")
	private WebElement FROMEMAIL;
	@AndroidFindBy(xpath = "//*[@text='Address 1*']")
	private WebElement FROMADDRESS1;
	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Upload Image Successful']")
	private WebElement FROMUPLOADIMAGESUCCESSFUL;
	@AndroidFindBys({ @AndroidBy(xpath = "//android.view.View[@content-desc='Alabama']/../android.view.View") })
	private List<WebElement> TOPSTATELIST;

	public String enterEnvoiceTitle(String EnvoiceTitle) throws InterruptedException {
		InvoiceTitle.click();
		InvoiceTitle.clear();
		InvoiceTitle.clear();
		//sendKeysWithCharKeyboard(EnvoiceTitle);
		InvoiceTitle.sendKeys(EnvoiceTitle);
		driver.hideKeyboard();
		return EnvoiceTitle;
	}

	public String uploadLogo() throws InterruptedException {
		LogoButton.click();
		// TextFields.get(0).sendKeys();
		Gallery.click();
		// String msg;
		TouchAction touch = new TouchAction(driver);
		Thread.sleep(3000l);
		driver.hideKeyboard();
		touch.tap(PointOption.point(238, 873)).perform();
		// driver.hideKeyboard();
		System.out.println("Debug point");
		try {
			turnOnwaitForAndroid();
			Expwait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//android.view.View[@content-desc='Upload Image Successful']")));
			System.out.println(FROMUPLOADIMAGESUCCESSFUL.getText());
			driver.hideKeyboard();
			System.out.println("Debug point in try");
			return FROMUPLOADIMAGESUCCESSFUL.getText();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.hideKeyboard();
			System.out.println("Debug point in catch");
			return "Success message does not appears";
		}

	}

	public String enterFromName(String FromName) throws InterruptedException {
		turnOnwaitForAndroid();

		driver.hideKeyboard();
		// TextFields.get(1).click();
		FROMNAME.click();
		// TextFields.get(1).sendKeys(FromName);
		//sendKeysWithCharKeyboard(FromName);
		FROMNAME.sendKeys(FromName);
		return FromName;
	}

	public String verifyLogoSuccessMessage() {
		return FROMUPLOADIMAGESUCCESSFUL.getAttribute("content-desc");
	}

	public String enterFromEmail(String FromEmail) throws InterruptedException {
//		TextFields.get(2).click();
//		TextFields.get(2).sendKeys(FromEmail);
		FROMEMAIL.click();
		//sendKeysWithCharKeyboard(FromEmail);
		FROMEMAIL.sendKeys(FromEmail);
		return FromEmail;
	}

	public String enterFromAdd1(String FromAdd1) {
//		TextFields.get(3).click();
//		TextFields.get(3).sendKeys(FromAdd1);
		
		FROMADDRESS1.click();
		//sendKeysWithCharKeyboard(FromAdd1);
		FROMADDRESS1.sendKeys(FromAdd1);
		return FromAdd1;
	}

	public String enterFromAdd2(String FromAdd2) {
		// Scrolluntil("Address 2");
		
		FromAddress2.click();
		//sendKeysWithCharKeyboard(FromAdd2);
		FromAddress2.sendKeys(FromAdd2);
		return FromAdd2;
	}

	public String enterFromCity(String FromCity1) {
		// Scrolluntil("City*");
		
		FromCity.click();
		//sendKeysWithCharKeyboard(FromCity1);
		FromCity.sendKeys(FromCity1);
		return FromCity1;
	}

	public String selectFromState(String Fromstate) throws Exception {
		// Scrolluntil("Business Number");
		FromState.click();
		boolean found = false;
		for (int i = 0; i < TOPSTATELIST.size(); i++) {

			if (TOPSTATELIST.get(i).getAttribute("content-desc").equals(Fromstate)) {
				TOPSTATELIST.get(i).click();
				found = true;
				break;
			}
		}
		if (found == false) {
			scrollDownTillElement("//android.view.View[@content-desc=\"" + Fromstate + "\"]");
		}
		return Fromstate;
	}

	public String enterFromZip(String FromZip1) {
		// Scrolluntil("Zip*");
		
		FromZip.click();
		//sendKeysWithNumKeyboard(FromZip1);
		
		FromZip.sendKeys(FromZip1);
		return FromZip1;
	}

	public String enterPhonNumber(String FromPhonNumber) {
		// Scrolluntil("Zip*");
		
		FromPhone.click();
		//sendKeysWithNumKeyboard(FromPhonNumber);
		FromPhone.sendKeys(FromPhonNumber);
		return FromPhonNumber;
	}

	public String enterBusinessNumber(String FromBusinessNumber1) {
		// Scrolluntil("Business Number*");
		
		FromBusinessNumber.click();
		//sendKeysWithNumKeyboard(FromBusinessNumber1);
		FromBusinessNumber.sendKeys(FromBusinessNumber1);
		return FromBusinessNumber1;
	}

	public InvoiceFormStep2 pressNEXT() {
		NEXT.click();
		InvoiceFormStep2 InvoiceFormStep2 = new InvoiceFormStep2(driver);
		return InvoiceFormStep2;
	}
}
