package MobileApp.BillGenratorMobileApp2.PageObject.Android.Misc1099;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import MobileApp.BillGenratorMobileApp2.PageObject.Android.CommonFormElements;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.OrderPage;
import MobileApp.BillGenratorMobileApp2.Utils.ReusableMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MiscFormStep6 extends ReusableMethods {
	AndroidDriver driver;

	public MiscFormStep6(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='your data save successfully']")
	private WebElement SuccessMsgOnSavingTemplate;

	@AndroidFindBy(xpath = "//*[contains(@content-desc,'State*')]")
	private WebElement State;
	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'CHECKOUT')]")
	private WebElement pressCheckout;
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'State income -2')]")
	private WebElement StateIncome2;
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'State income')]")
	private WebElement StateIncome;
	@AndroidFindBys({ @AndroidBy(xpath = "//*[contains(@class,'android.widget.EditText')]") })
	private List<WebElement> TextFields;
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'State/Payer’s state no.')][2]")
	private WebElement StatePayersStateNo2;
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Section 409A deferrals')]")
	private WebElement Section409A;
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'State tax withheld-2')]")
	private WebElement StateTaxWithheld2;
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'State/Payer’s state no.')][1]")
	private WebElement StatePayersStateNo;
	@AndroidFindBy(accessibility = "PREVIEW")
	private WebElement pressPREVIEW;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Open navigation menu']/../following-sibling::android.widget.ImageView")
	private WebElement templateOption;
	@AndroidFindBy(xpath = "//android.view.View[@content-desc='SAVE TEMPLATE']")
	private WebElement SaveTemplate;
	@AndroidFindBy(xpath = "//android.view.View[@content-desc='LOAD TEMPLATE']")
	private WebElement LoadTemplate;

	public void enterSection409ADeferrals(String Section409ADeferrals) throws Exception {

		TextFields.get(0).click();
		TextFields.get(0).sendKeys(Section409ADeferrals);
	}

	public String getSection409ADeferrals() throws Exception {

		return TextFields.get(0).getText().replace(", Section 409A deferrals", "");
	}

	public void enterExcessGoldenParachutePayments(String ExcessGoldenParachutePayments) {
		TextFields.get(1).click();
		TextFields.get(1).sendKeys(ExcessGoldenParachutePayments);
	}

	public String getExcessGoldenParachutePayments() throws Exception {

		return TextFields.get(1).getText().replace(", Excess golden parachute payments", "");
	}

	public void enterNonqualifiedDeferredCompensation(String NonqualifiedDeferredCompensation) {
		TextFields.get(2).click();
		TextFields.get(2).sendKeys(NonqualifiedDeferredCompensation);
	}

	public String getNonqualifiedDeferredCompensation() throws Exception {

		return TextFields.get(2).getText().replace(", Nonqualified deferred compensation", "");
	}

	public void enterStateTaxWithheld(String StateTaxWithheld) {
		TextFields.get(3).click();
		TextFields.get(3).sendKeys(StateTaxWithheld);
	}

	public String getStateTaxWithheld() throws Exception {

		return TextFields.get(3).getText().replace(", State tax withheld", "");
	}

	public void enterStateTaxWithHeld2(String StateTaxWithHeld2) {
		StateTaxWithheld2.click();
		StateTaxWithheld2.sendKeys(StateTaxWithHeld2);
	}

	public String getStateTaxWithHeld2() throws Exception {

		return StateTaxWithheld2.getText().replace(", State tax withheld-2", "");
	}

	public void enterStatePayerStateNo(String StatePayerStateNo) {
		StatePayersStateNo.click();
		StatePayersStateNo.sendKeys(StatePayerStateNo);
	}

	public String getStatePayerStateNo() throws Exception {

		return StatePayersStateNo.getText().replace(", State/Payer’s state no.", "");
	}

	public void enterStatePayerStateNo2(String enterStatePayerStateNo2) {
		StatePayersStateNo2.click();
		StatePayersStateNo2.sendKeys(enterStatePayerStateNo2);
	}

	public String getStatePayerStateNo2() throws Exception {

		return StatePayersStateNo2.getText().replace(", State/Payer’s state no. -2", "");
	}

	public void enterStateIncome(String enterStateIncome) throws Exception {

		StateIncome.click();
		StateIncome.sendKeys(enterStateIncome);
	}

	public String getStateIncome() throws Exception {
		scrollDownTillWebElement(StateIncome2);
		return StateIncome.getText().replace(", State income", "");
	}

	public void enterStateIncome2(String enterStateIncome2) {
		StateIncome2.click();
		// TextFields.get(6).click();
		StateIncome2.sendKeys(enterStateIncome2);
	}

	public String getStateIncome2() throws Exception {

		return StateIncome2.getText().replace(", State income -2", "");
	}

	public OrderPage pressCheckout() {
		pressCheckout.click();
		OrderPage OrderPage = new OrderPage(driver);
		return OrderPage;
	}

	public Misc1099Preview pressPreview() {
		pressPREVIEW.click();
		Misc1099Preview Misc1099Preview = new Misc1099Preview(driver);
		return Misc1099Preview;
	}

	public void pressTemplateOptions() {
		templateOption.click();
	}

	public void pressSaveTemplate() {
		SaveTemplate.click();
	}

	public CommonFormElements pressLoadTemplate() {
		LoadTemplate.click();
		CommonFormElements CommonFormElements = new CommonFormElements(driver);
		return CommonFormElements;
	}

	public String getSuccessMsgOnSavingTemplate() {
		int attempts = 0;
		while (attempts < 2) {

			try {
				turnOnwaitForAndroid();
				Expwait.until(ExpectedConditions.visibilityOf(SuccessMsgOnSavingTemplate));
				// By.xpath("//android.view.View[@content-desc='your data save
				// successfully']")));
				System.out.println("The success message: " + SuccessMsgOnSavingTemplate.getText());
				return SuccessMsgOnSavingTemplate.getText();
			} catch (StaleElementReferenceException e) {
				e.printStackTrace();
			}

			catch (NoSuchElementException e) {
				e.printStackTrace();
				return "Success message does not appear.";
			} catch (TimeoutException e) {
				e.printStackTrace();
				return "TimeoutException";
			}
			attempts++;
		}
		return "Code does not cought the success message";

	}
}
