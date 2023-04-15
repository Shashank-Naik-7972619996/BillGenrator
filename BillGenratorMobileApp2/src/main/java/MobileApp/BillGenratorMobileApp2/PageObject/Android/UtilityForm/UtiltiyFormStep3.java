package MobileApp.BillGenratorMobileApp2.PageObject.Android.UtilityForm;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import MobileApp.BillGenratorMobileApp2.Utils.ReusableMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class UtiltiyFormStep3 extends ReusableMethods {

AndroidDriver driver;
	
	public UtiltiyFormStep3(AndroidDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBys({@AndroidBy(className = "android.widget.EditText")})
	private List<WebElement> TextFields;
	
	@AndroidFindBy(xpath="//android.widget.EditText[contains(@text,'statement Date')]")
	private WebElement SatementDate;
	@AndroidFindBy(xpath="//android.widget.EditText[contains(@text,'Enter Date')]")
	private WebElement EnterDate;
	
	@AndroidFindBy(xpath="//android.widget.EditText[contains(@text,'Payment Due Amount')]")
	private WebElement PaymentDueAmount1;
	@AndroidFindBy(xpath="//android.widget.EditText[contains(@text,'Previous Statement Amount')]")
	private WebElement PreviousStatementAmount1;
	
	
	@AndroidFindBy(accessibility="Switch to input")
	private WebElement SwitchInput;
	@AndroidFindBy(accessibility="OK")
	private WebElement PressOk;
	@AndroidFindBy(accessibility = "NEXT")
	private WebElement NEXTButton;
	
	public void enterStatementDate(String StateMentDate)
	{
		SatementDate.click();
		SwitchInput.click();
		EnterDate.clear();
		EnterDate.sendKeys(StateMentDate);
		PressOk.click();
	}
	public void enterPaymentDueAmount(String PaymentDueAmount)
	{
		PaymentDueAmount1.click();
		PaymentDueAmount1.sendKeys(PaymentDueAmount);
	}
	public void enterPreviousStatementAmount(String PreviousStatementAmount)
	{
		PreviousStatementAmount1.click();
		PreviousStatementAmount1.sendKeys(PreviousStatementAmount);
	}
	public UtiltiyFormStep4 pressNextButton() {
		// TODO Auto-generated method stub
		NEXTButton.click();
		UtiltiyFormStep4 utilityFormsStep4 = new UtiltiyFormStep4(driver);
		return utilityFormsStep4;
	}
	
}
