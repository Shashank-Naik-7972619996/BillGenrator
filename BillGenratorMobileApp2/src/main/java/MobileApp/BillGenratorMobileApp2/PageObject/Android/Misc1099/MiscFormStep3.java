package MobileApp.BillGenratorMobileApp2.PageObject.Android.Misc1099;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import MobileApp.BillGenratorMobileApp2.Utils.ReusableMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MiscFormStep3 extends ReusableMethods {
	AndroidDriver driver;

	public MiscFormStep3(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}
	@AndroidFindBy(xpath = "//*[contains(@content-desc,'OMB No')]/../android.view.View[2]")
	private WebElement OMBNo;
	
	@AndroidFindBys({ @AndroidBy(xpath = "//*[contains(@class,'android.widget.EditText')]") })
	private List<WebElement> TextFields;
	@AndroidFindBy(accessibility = "NEXT")
	private WebElement NEXT;
	
	
	
	public String getOMBNo()
	{
		String OMBNoString = OMBNo.getAttribute("content-desc");
		return OMBNoString;
	}
	
	public void enterPayersTin(String PayersTin)
	{
		TextFields.get(0).click();
		TextFields.get(0).sendKeys(PayersTin);
	}
	public String getPayersTin()
	{
		return TextFields.get(0).getText().replace(", PAYER'S TIN (Company EIN)", "");
	}
	
	public void enterRecipientsTin(String RevipientsTin)
	{
		TextFields.get(1).click();
		TextFields.get(1).sendKeys(RevipientsTin);
	}
	public String getRecipientsTin()
	{
		return TextFields.get(1).getText().replace(", RECIPIENT'S TIN", "");
	}
	public MiscFormStep4 pressNEXT() {
		NEXT.click();
		MiscFormStep4 MiscFormStep4 = new MiscFormStep4(driver);
		return MiscFormStep4;
	}
}
