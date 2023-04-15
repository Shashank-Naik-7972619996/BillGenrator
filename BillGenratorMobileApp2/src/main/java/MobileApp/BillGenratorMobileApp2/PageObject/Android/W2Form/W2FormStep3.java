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

public class W2FormStep3 extends ReusableMethods {
	AndroidDriver driver;

	public W2FormStep3(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}
	@AndroidFindBys({ @AndroidBy(xpath = "//*[@class='android.widget.EditText']")})
	private List<WebElement> TextFields;
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'State')]//following-sibling::android.widget.EditText[1]")
	private WebElement CompanyZip;
	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'D- Control Number')]//following-sibling::android.widget.EditText")
	private WebElement ControlNumber;
	@AndroidFindBy(accessibility = "State*")
	private WebElement State;
	@AndroidFindBy(accessibility = "NEXT")
	private WebElement NEXT;
	@AndroidFindBy(accessibility = "PRIVIOUS")
	private WebElement PRIVIOUS;
	
	public void enterCompanyName(String companyname)
	{
		try {
			TextFields.get(0).click();
			TextFields.get(0).sendKeys(companyname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void enterCompanyAdd(String CompanyAdd)
	{
		try {
			TextFields.get(1).click();
			TextFields.get(1).sendKeys(CompanyAdd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void enterCompanyCity(String CompanyCity)
	{
		try {
			TextFields.get(2).click();
			TextFields.get(2).sendKeys(CompanyCity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void enterCompanyZip(String Zip)
	{
		try {
			CompanyZip.click();
			CompanyZip.sendKeys(Zip);
			driver.hideKeyboard();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void enterControlNumber(String Control_Number)
	{
		try {
			ControlNumber.click();
			Thread.sleep(3000l);
			ControlNumber.sendKeys(Control_Number);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectState(String state) throws Exception
	{
		State.click();
		scrollDownTillElement("//android.view.View[@content-desc=\""+state+"\"]");
		//Scrolluntil(state).click();
	}
	public W2FormStep4 pressNEXT() {
		NEXT.click();
		W2FormStep4 W2FormStep4 = new W2FormStep4(driver);
		return W2FormStep4;
	}
	public void pressPRIVIOUS() {
		PRIVIOUS.click();
	}
}
