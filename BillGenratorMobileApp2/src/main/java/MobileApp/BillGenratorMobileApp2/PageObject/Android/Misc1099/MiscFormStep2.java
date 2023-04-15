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

public class MiscFormStep2 extends ReusableMethods {
	AndroidDriver driver;

	public MiscFormStep2(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}
	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'State*')]")
	private WebElement State;
	
	@AndroidFindBys({ @AndroidBy(xpath = "//*[contains(@class,'android.widget.EditText')]") })
	private List<WebElement> TextFields;
	@AndroidFindBy(accessibility = "NEXT")
	private WebElement NEXT;
	@AndroidFindBys({ @AndroidBy(xpath = "//android.view.View[@content-desc='Alabama']/../android.view.View") })
	private List<WebElement> TOPSTATELIST;
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Zip Code*')]")
	private WebElement ZipCode;
	
	
	public void enterPayerCompanyName(String companyname)
	{
		TextFields.get(0).click();
		TextFields.get(0).sendKeys(companyname);
	}
	public String getPayerCompanyName()
	{
		//System.out.println("Company name: "+TextFields.get(0).getText().split(",")[0].trim());
		return TextFields.get(0).getText().split(",")[0].trim();
	}
	public String enterPayerAddress(String PayerAddress)
	{
		TextFields.get(1).click();
		TextFields.get(1).sendKeys(PayerAddress);
		return PayerAddress;
	}
	public String getPayerAddress()
	{
		System.out.println("Address got: "+TextFields.get(1).getText().replace(", Address*", ""));
		return TextFields.get(1).getText().replace(", Address*", "");
	}
	public String enterPayerCity(String PayerCity)
	{
		TextFields.get(2).click();
		TextFields.get(2).sendKeys(PayerCity);
		return PayerCity;
	}
	public String getPayerCity()
	{
		//System.out.println("Address got: "+TextFields.get(1).getText().replace(", Address*", ""));
		return TextFields.get(2).getText().replace(", city*", "");
	}
	public String enterPayerZipCode(String PayerZipCode)
	{
		ZipCode.click();
		ZipCode.sendKeys(PayerZipCode);
		return PayerZipCode;
	}
	public String getPayerZipCode()
	{
		//System.out.println("Address got: "+TextFields.get(1).getText().replace(", Address*", ""));
		return ZipCode.getText().replace(", Zip Code*", "");
	}
	public String selectState(String state) throws Exception
	{
		State.click();
		boolean found = false;
		for (int i = 0; i < TOPSTATELIST.size(); i++) {

			if (TOPSTATELIST.get(i).getAttribute("content-desc").equals(state)) {
				TOPSTATELIST.get(i).click();
				found = true;
				break;
			}
		}
		if (found == false) {
			scrollDownTillElement("//android.view.View[@content-desc=\""+state+"\"]");
		}
		return state;
	}
	public String getPayerState()
	{
		System.out.println("company state: "+State.getAttribute("content-desc").replace("State*", "").trim());
		return State.getAttribute("content-desc").replace("State*", "").trim();
	}
	
	public MiscFormStep3 pressNEXT() {
		NEXT.click();
		MiscFormStep3 MiscFormStep3 = new MiscFormStep3(driver);
		return MiscFormStep3;
	}
}
