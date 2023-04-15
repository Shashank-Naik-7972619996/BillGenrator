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

public class MiscFormStep4 extends ReusableMethods {
	AndroidDriver driver;

	public MiscFormStep4(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}
	@AndroidFindBy(xpath = "//*[contains(@content-desc,'State')]")
	private WebElement State;
	
	@AndroidFindBys({ @AndroidBy(xpath = "//*[contains(@class,'android.widget.EditText')]") })
	private List<WebElement> TextFields;
	
	
	
	@AndroidFindBy(accessibility = "NEXT")
	private WebElement NEXT;
	@AndroidFindBys({ @AndroidBy(xpath = "//android.view.View[@content-desc='Alabama']/../android.view.View") })
	private List<WebElement> TOPSTATELIST;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Your Name')]")
	private WebElement RecName;
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Address')]")
	private WebElement RecAdd;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'City')]")
	private WebElement RecCity;
	
	
	
	
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Zip Code*')]")
	private WebElement ZipCode;
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Account number')]")
	private WebElement accountno;
	
	public void enterRecipientsName(String recName)
	{
		RecName.click();
		RecName.sendKeys(recName);
	}
	public String getRecipientsName()
	{
		return RecName.getText().replace(", Your Name*", "");
	}

	public void enterRecAddress(String recadd)
	{
		RecAdd.click();
		RecAdd.sendKeys(recadd);
	}
	public String getRecipientsAddress()
	{
		return RecAdd.getText().replace(", Address*", "");
	}
	
	public void enterRecCity(String recCity)
	{
		TextFields.get(2).click();
		TextFields.get(2).sendKeys(recCity);
	}
	public String getRecipientsCity()
	{
		return TextFields.get(2).getText().replace(", City*", "");
	}
	
	public void enterRecZipCode(String recZipCode)
	{
		ZipCode.click();
		ZipCode.sendKeys(recZipCode);
	}
	public String getRecZipCode()
	{
		return ZipCode.getText().replace(", Zip Code*", "");
	}
	
	public void selectState(String StateToSelect) throws Exception
	{
		State.click();
		boolean found = false;
		for (int i = 0; i < TOPSTATELIST.size(); i++) {

			if (TOPSTATELIST.get(i).getAttribute("content-desc").equals(StateToSelect)) {
				TOPSTATELIST.get(i).click();
				found = true;
				break;
			}
		}
		if (found == false) {
			scrollDownTillElement("//android.view.View[@content-desc=\""+StateToSelect+"\"]");
		}
		//return State.getText();
	}
	public String getRecState()
	{
		System.out.println("Recipents state: "+State.getAttribute("content-desc").replace("Your State*", "").trim());
		return State.getAttribute("content-desc").replace("Your State*", "").trim();
	}
	public MiscFormStep5 pressNEXT() throws Exception {
		NEXT.click();
		scrollUpTillWebElement(accountno);
		MiscFormStep5 MiscFormStep5 = new MiscFormStep5(driver);
		return MiscFormStep5;
	}
}
