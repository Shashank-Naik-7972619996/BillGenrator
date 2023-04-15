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

public class MiscFormStep5 extends ReusableMethods {
	AndroidDriver driver;

	public MiscFormStep5(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}

	@AndroidFindBy(xpath = "//*[contains(@content-desc,'State*')]")
	private WebElement State;
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=' FATCA filling requirement']/following-sibling::android.view.View")
	private WebElement FATCAfillingrequirement;

	@AndroidFindBys({ @AndroidBy(xpath = "//*[contains(@class,'android.widget.EditText')]") })
	private List<WebElement> TextFields;
	@AndroidFindBy(xpath = "//*[contains(@content-desc,'Payer made direct')]/following-sibling::android.view.View")
	private WebElement PayerMadeDirectCheckbox;
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=' FATCA filling requirement']/following-sibling::android.view.View")
	private WebElement FATCAFillingRequirementCheckbox;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Federal Income tax withheld')]")
	private WebElement FederalIncomeTaxWithheld;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Fishing boat proceeds')]")
	private WebElement FishingBoatProceeds;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Other income*')]")
	private WebElement OtherIncome;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Medical and health care payments')]")
	private WebElement MedicalAndHealthCarePayments;
	@AndroidFindBy(xpath = "//*[contains(@content-desc,'Payer made direct')]")
	private WebElement PayerMadeDirectText;
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Subsitute payments in lieu of dividends or interest')]")
	private WebElement SubsitutePaymentsInLieu;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Crop insurance proceeds')]")
	private WebElement CropInsuranceProceeds;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Gross proceeds paid to an attorney')]")
	private WebElement GrossProceedsPaidToAnAttorney;
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Extra')]")
	private WebElement Extra;
	@AndroidFindBy(accessibility = "NEXT")
	private WebElement NEXT;
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Section 409A deferrals')]")
	private WebElement Section409A;

	boolean FATCAFillingRequirement;
	boolean PayerMadeDirectCheckboxStatus;

	public void enterAccountNumber(String accountno) {
		TextFields.get(0).click();
		TextFields.get(0).sendKeys(accountno);
	}

	public String getAccountNumber() {
		return TextFields.get(0).getText().replace(", Account number", "");
	}

	public void markFATCAfillingrequirement() {
		FATCAfillingrequirement.click();
		FATCAFillingRequirement = true;
	}

	public boolean verifyFATCAfillingrequirementStatus() {
		if (FATCAFillingRequirement = true) {
			return FATCAFillingRequirement = true;
		}
		return false;
	}

	public void enterRents(String Rents) {
		TextFields.get(1).click();
		TextFields.get(1).sendKeys(Rents);
	}

	public String getRents() {
		return TextFields.get(1).getText().replace(", Rents", "");
	}

	public void enterRoyalties(String Royalties) {
		TextFields.get(2).click();
		TextFields.get(2).sendKeys(Royalties);
	}

	public String getRoyalties() {
		return TextFields.get(2).getText().replace(", Royalties", "");
	}

	public void enterOtherIncome(String OtherIncome1) {
		OtherIncome.click();
		OtherIncome.sendKeys(OtherIncome1);
	}

	public String getOtherIncome() {
		return OtherIncome.getText().replace(", Other income*", "");
	}

	public void enterFederalIncomeTaxWithheld(String FederalIncomeTaxWithheld1) {
		FederalIncomeTaxWithheld.click();
		FederalIncomeTaxWithheld.sendKeys(FederalIncomeTaxWithheld1);
	}

	public String getFederalIncomeTaxWithheld() {
		return FederalIncomeTaxWithheld.getText().replace(", Federal Income tax withheld", "");
	}

	public void enterFishingBoatProceeds(String FishingBoatProceeds1) {
		FishingBoatProceeds.click();
		FishingBoatProceeds.sendKeys(FishingBoatProceeds1);
	}

	public String getFishingBoatProceeds() {
		return FishingBoatProceeds.getText().replace(", Fishing boat proceeds", "");
	}

	public void enterMedicalAndHealthCarePayments(String MedicalAndHealth) {
		Scrolluntil("Medical and health care payments").click();
		Scrolluntil("Medical and health care payments").sendKeys(MedicalAndHealth);
	}

	public String getMedicalAndHealthCarePayments() throws Exception {
		scrollDownTillWebElement(Extra);
		return MedicalAndHealthCarePayments.getText().replace(", Medical and health care payments", "");
	}

	public void markPayerMadeDirectCheckbox() throws Exception {
		driver.hideKeyboard();
		scrollDownTillWebElement(Extra);
		// Scrolluntil(PayerMadeDirectText.getText());
		PayerMadeDirectCheckbox.click();
		PayerMadeDirectCheckboxStatus = true;
	}

	public boolean getPayerMadeDirectCheckboxStatus() throws Exception {

		// Boolean.getBoolean(PayerMadeDirectCheckboxStatus);
		if (PayerMadeDirectCheckboxStatus = true) {
			return true;
		}
		return false;
	}

	public void enterSubsitutePayments(String SubsitutePayments) {
		Scrolluntil("Subsitute payments in lieu of dividends or interest").click();
		Scrolluntil("Subsitute payments in lieu of dividends or interest").sendKeys(SubsitutePayments);
	}

	public String getSubsitutePayments() throws Exception {

		return SubsitutePaymentsInLieu.getText().replace(", Subsitute payments in lieu of dividends or interest", "");
	}

	public void enterCropInsuranceProceeds(String CropInsuranceProceeds) {
		Scrolluntil("Crop insurance proceeds").click();
		Scrolluntil("Crop insurance proceeds").sendKeys(CropInsuranceProceeds);
	}

	public String getCropInsuranceProceeds() throws Exception {

		return CropInsuranceProceeds.getText().replace(", Crop insurance proceeds", "");
	}

	public void enterGrossProceedsPaidToAnAttorney(String GrossProceedsPaidToAnAttorney) {
		Scrolluntil("Gross proceeds paid to an attorney").click();
		Scrolluntil("Gross proceeds paid to an attorney").sendKeys(GrossProceedsPaidToAnAttorney);
	}
	public String getGrossProceedsPaidToAnAttorney() throws Exception {

		return GrossProceedsPaidToAnAttorney.getText().replace(", Gross proceeds paid to an attorney", "");
	}

	public void enterExtra(String Extra) {
		Scrolluntil("Extra").click();
		Scrolluntil("Extra").sendKeys(Extra);
	}
	public String getExtra() throws Exception {

		return Extra.getText().replace(", Extra", "");
	}

	public MiscFormStep6 pressNEXT() throws Exception {
		NEXT.click();
		scrollUpTillWebElement(Section409A);
		MiscFormStep6 MiscFormStep6 = new MiscFormStep6(driver);
		return MiscFormStep6;
	}

	public void markFATCAFillingRequirementCheckbox() {
		FATCAFillingRequirementCheckbox.click();
	}

}
