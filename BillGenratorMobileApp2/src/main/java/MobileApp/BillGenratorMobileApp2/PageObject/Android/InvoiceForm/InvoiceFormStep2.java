package MobileApp.BillGenratorMobileApp2.PageObject.Android.InvoiceForm;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import MobileApp.BillGenratorMobileApp2.Utils.ReusableMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class InvoiceFormStep2 extends ReusableMethods {
	AndroidDriver driver;

	public InvoiceFormStep2(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}

	@AndroidFindBys({ @AndroidBy(xpath = "//*[contains(@class,'android.widget.EditText')]") })
	private List<WebElement> TextFields;

	@AndroidFindBys({ @AndroidBy(xpath = "//android.view.View[@content-desc='Alabama']/../android.view.View") })
	private List<WebElement> TOPSTATELIST;
	@AndroidBy(accessibility = "Your State*")
	private WebElement ToYourState;
//	@AndroidBy(xpath = "//*[contains(@text,'Phone')]")
//	private WebElement ToPhone;
	@AndroidFindBy(accessibility = "NEXT")
	private WebElement NEXT;
	@AndroidFindBy(xpath = "//*[contains(@text,'Name')]")
	private WebElement TONAME;
	@AndroidFindBy(xpath = "//*[contains(@text,'Email')]")
	private WebElement TOEMAIL;
	@AndroidFindBy(xpath = "//*[contains(@text,'Address 1')]")
	private WebElement TOADD1;
	@AndroidFindBy(xpath = "//*[contains(@text,'Address 2')]")
	private WebElement TOADD2;
	@AndroidFindBy(xpath = "//*[contains(@text,'City')]")
	private WebElement TOCITY;
	@AndroidFindBy(xpath = "//*[contains(@content-desc,'State')]")
	private WebElement TOSTATE;
	@AndroidFindBy(xpath = "//*[contains(@text,'Zip')]")
	private WebElement TOZIP;
	@AndroidFindBy(xpath = "//*[contains(@text,'Phone')]")
	private WebElement TOPHONE;

	public void enterToName(String toname) throws Exception {

		scrollUpTillElement("//android.widget.EditText[contains(@text,'Name')]");
		TONAME.click();
		//sendKeysWithCharKeyboard(toname);
		TONAME.sendKeys(toname);
//		TextFields.get(0).click();
//		TextFields.get(0).sendKeys(toname);
	}

	public void enterToEmail(String email) {
		TOEMAIL.click();
		//sendKeysWithCharKeyboard(email);
		TOEMAIL.sendKeys(email);
//		TextFields.get(1).click();
//		TextFields.get(1).sendKeys(email);
	}

	public void enterToAdd1(String add1) {
		TOADD1.click();
		//sendKeysWithCharKeyboard(add1);
		TOADD1.sendKeys(add1);
	}

	public void enterToAdd2(String add2) {
		TOADD2.click();
		//sendKeysWithCharKeyboard(add2);
		TOADD2.sendKeys(add2);
	}

	public void enterToCity(String city) {
		TOCITY.click();
		//sendKeysWithCharKeyboard(city);
		TOCITY.sendKeys(city);
	}

	public void selectState(String State) throws Exception {
		TOSTATE.click();

		boolean found = false;
		for (int i = 0; i < TOPSTATELIST.size(); i++) {

			if (TOPSTATELIST.get(i).getAttribute("content-desc").equals(State)) {
				TOPSTATELIST.get(i).click();
				found = true;
				break;
			}
		}
		if (found == false) {
			scrollDownTillElement("//android.view.View[@content-desc=\""+State+"\"]");
		}
	}

	public void enterToZip(String zip) {
		TOZIP.click();
		//sendKeysWithNumKeyboard(zip);
		TOZIP.sendKeys(zip);
		driver.hideKeyboard();
	}

	public void enterToPhone(String Phone) {
		//Scrolluntil("Phone").click();
		TOPHONE.click();
		//sendKeysWithNumKeyboard(Phone);
		TOPHONE.sendKeys(Phone);
	}

	public InvoiceFormStep3 pressNEXT() {
		NEXT.click();
		InvoiceFormStep3 InvoiceFormStep3 = new InvoiceFormStep3(driver);
		return InvoiceFormStep3;
	}
}
