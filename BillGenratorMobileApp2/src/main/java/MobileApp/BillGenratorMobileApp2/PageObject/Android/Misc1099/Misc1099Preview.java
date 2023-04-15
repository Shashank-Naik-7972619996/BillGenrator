package MobileApp.BillGenratorMobileApp2.PageObject.Android.Misc1099;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import MobileApp.BillGenratorMobileApp2.Utils.ReusableMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Misc1099Preview extends ReusableMethods {
	AndroidDriver driver;

	public Misc1099Preview(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}

	@AndroidFindBys({ @AndroidBy(xpath = "//*[@class= 'android.widget.TextView']") })
	private List<WebElement> AllPreviewData1;
	@AndroidFindBys({ @AndroidBy(xpath = "//*[contains(@class,'android.view.View')]") })
	private List<WebElement> AllPreviewData2;
	@AndroidFindBy(xpath = "//android.view.View[contains(@text,'CORRECTED')]/android.widget.Image")
	private WebElement CorrectedCheckbox;
	@AndroidFindBy(xpath = "//*[@text='FATCA filling requirement checked']/android.widget.Image")
	private WebElement FATCAFillingCheckbox;
	@AndroidFindBy(xpath = "//*[contains(@text,'Payer made direct sales')]/android.widget.Image")
	private WebElement PayerMadeCheckbox;

	
	@AndroidFindBy(xpath = "//android.widget.Image[@text='draft-watermark']")
	private WebElement PreviewOnlyWaterMark;
	
	@AndroidFindBys({
			@AndroidBy(xpath = "//android.view.View[contains(@text,'PAYER')]/following-sibling::android.widget.TextView") })
	private List<WebElement> PayersCompanyInformation;

	@AndroidFindBys({
			@AndroidBy(xpath = "//android.view.View[contains(@text,'RECIPIENT')]/following-sibling::android.widget.TextView") })
	private List<WebElement> RECIPIENTsInformation;
	@AndroidFindBy(xpath = "//android.view.View[contains(@text,'Account number')]/../following-sibling::android.view.View/android.view.View")
	private WebElement AccountNumber;
	@AndroidFindBy(xpath = "//android.view.View[contains(@text,'FATCA filling requirement')]/android.widget.Image")
	private WebElement FATCAFillingRequirement;
	@AndroidFindBy(xpath = "//android.view.View[contains(@text,'Rents')]/../following-sibling::android.view.View/android.view.View[2]")
	private WebElement Rents;

	@AndroidFindBy(xpath = "//android.view.View[contains(@text,'Royalties')]/../following-sibling::android.view.View/android.view.View[2]")
	private WebElement Royalties;

	@AndroidFindBy(xpath = "//android.view.View[contains(@text,'Other income')]/../following-sibling::android.view.View/android.view.View[2]")
	private WebElement OtherIncome;

	@AndroidFindBy(xpath = "(//android.view.View[contains(@text,'Fishing boat proceeds')]/../following-sibling::android.view.View/android.view.View[2])[1]")
	private WebElement FishingBoatProceeds;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Payer made')]/following-sibling::android.widget.Image")
	private WebElement PayerMade;

	@AndroidFindBy(xpath = "//android.view.View[contains(@text,'Crop insurance proceeds')]/../following-sibling::android.view.View/android.view.View[2]")
	private WebElement CropInsuranceProceeds;

	@AndroidFindBy(xpath = "//android.view.View[contains(@text,'11')]/../following-sibling::android.view.View/android.view.View[2]")
	private WebElement text11;
	@AndroidFindBy(xpath = "//android.view.View[contains(@text,'Excess golden')]/../following-sibling::android.view.View/android.view.View[2]")
	private WebElement ExcessGolden;

	@AndroidFindBys({
			@AndroidBy(xpath = "//android.view.View[contains(@text,'State tax withheld')]/../following-sibling::android.view.View/android.view.View[2]") })
	private List<WebElement> StateTaxWithheld;

	@AndroidFindBys({
			@AndroidBy(xpath = "//android.view.View[contains(@text,'state no.')]/../following-sibling::android.view.View/android.view.View[2]") })
	private List<WebElement> StateNo;
	@AndroidFindBys({
			@AndroidBy(xpath = "//android.view.View[contains(@text,'State income')]/../following-sibling::android.view.View/android.view.View[2]") })
	private List<WebElement> StateIncome;

	// Year selected
	@AndroidFindBy(xpath = "(//android.view.View[contains(@text,'OMB No')]/following-sibling::android.widget.TextView)[1]")
	private WebElement YearOfMisc;

	@AndroidFindBy(xpath = "//android.view.View[contains(@text,'Federal Income tax withheld')]/../following-sibling::android.view.View/android.view.View[2]")
	private WebElement FederalIncomeTaxWithheld;

	@AndroidFindBy(xpath = "//android.view.View[contains(@text,'Medical and health care payments')]/../following-sibling::android.view.View/android.view.View[2]")
	private WebElement MedicalAndHealthCarePayments;

	@AndroidFindBy(xpath = "//android.view.View[contains(@text,'Subsitute payments')]/../following-sibling::android.view.View/android.view.View[2]")
	private WebElement SubsitutePayments;

	@AndroidFindBy(xpath = "//android.view.View[contains(@text,'Gross proceeds')]/../following-sibling::android.view.View/android.view.View[2]")
	private WebElement GrossProceeds;

	@AndroidFindBy(xpath = "//android.view.View[contains(@text,'Section 409A deferrals')]/../following-sibling::android.view.View/android.view.View[2]")
	private WebElement Section409ADeferrals;

	@AndroidFindBy(xpath = "//android.view.View[contains(@text,'Nonqualified deferred compensation')]/../following-sibling::android.view.View/android.view.View[2]")
	private WebElement NonqualifiedDeferredCompensation;
	
	@AndroidFindBy(xpath = "//android.widget.Image[@text='draft-watermark']/../../../../../android.view.View[1]")
	private WebElement PreviewBackArrow;
	

	public String getAllData() {
		String alldata;
		for (int i = 0; i < AllPreviewData1.size(); i++) {
			alldata = AllPreviewData1.get(i).getAttribute("text");
			return alldata;
		}
		return null;
	}

	public String getAllData2() {
		String alldata;
		for (int i = 0; i < AllPreviewData2.size(); i++) {
			alldata = AllPreviewData2.get(i).getAttribute("text");
			return alldata;
		}
		return null;
	}

	public Boolean getStatusOfCorrectedCheckbox() {

		turnOnwaitForAndroid();
		Expwait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//android.widget.Image[@text='draft-watermark']")));
		if (CorrectedCheckbox.getText().equals("checked")) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean getStatusOfFATCAFillingCheckbox() {

		if (FATCAFillingCheckbox.getText().equals("checked")) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean getStatusOfPayerMadeCheckbox() {

		if (PayerMadeCheckbox.getText().equals("checked")) {
			return true;
		} else {
			return false;
		}
	}

	public String getPayersCompanyName() {
		return PayersCompanyInformation.get(0).getText();
	}

	public String getPayersCompanyAddress() {
		return PayersCompanyInformation.get(1).getText();
	}

	public String getPayersCompanyCity() {
		return PayersCompanyInformation.get(2).getText().split(",")[0].trim();
	}

	public String getPayersCompanyShortState() {
		String shortstate = PayersCompanyInformation.get(2).getText().split(",")[1].trim().split(" ")[0].trim();
		System.out.println("Company ShortState: " + shortstate);
		return shortstate;
	}

	public String getPayersCompanyZip() {
		String CompanyZip = PayersCompanyInformation.get(2).getText().split(",")[1].trim().split(" ")[1].trim();
		System.out.println("CompanyZip: " + CompanyZip);
		return CompanyZip;
	}

	public String getPayersTin() {
		return PayersCompanyInformation.get(3).getText();
	}

	public String getRecipientsName() {
		return RECIPIENTsInformation.get(1).getText();
	}

	public String getRecipientsAddress() {
		return RECIPIENTsInformation.get(2).getText();
	}

	public String getRecipientsCity() {
		return RECIPIENTsInformation.get(3).getText().split(",")[0].trim();
	}

	public String getRecipientsShortState() {
		String shortstate = RECIPIENTsInformation.get(3).getText().split(",")[1].trim().split(" ")[0].trim();
		System.out.println("Rec State: " + shortstate);
		return shortstate;
	}

	public String getRecipientsZip() {
		String RecZip = RECIPIENTsInformation.get(3).getText().split(",")[1].trim().split(" ")[1].trim();
		System.out.println("Rec Zip: " + RecZip);
		return RecZip;
	}

	public String getRecipientsTin() {
		return RECIPIENTsInformation.get(0).getText();
	}

	public String getShortCutOfState(String stateSelected) {
		return getShortState(stateSelected);
	}

	public String getAccountNo() {
		return AccountNumber.getText().replaceAll("[^\\x00-\\x7F]","");
	}

	public boolean getFATCAFillingRequirementStatus() {
		if (FATCAFillingRequirement.getText().equals("checked")) {
			return true;
		}
		return false;
	}

	public String getRents() {
		String rentinstring = Rents.getText().replaceAll("[^\\x00-\\x7F]",""); //replace("Â ", "").trim();

		return rentinstring;
	}

	public String getRoyalties() {
		return Royalties.getText().replaceAll("[^\\x00-\\x7F]","");
	}
	public String getOtherIncome() {
		return OtherIncome.getText().replaceAll("[^\\x00-\\x7F]","");
	}
	public String getFishingBoatProceeds() {
		return FishingBoatProceeds.getText().replaceAll("[^\\x00-\\x7F]","");
	}

	
	public boolean verifyPayerMadeStatus()
	{
		if(PayerMade.getText().equals("checked"))
		{
			return true;
		}
		return false;
	}
	public String getCropInsuranceProceeds() {
		return CropInsuranceProceeds.getText().replaceAll("[^\\x00-\\x7F]","");
	}
	public String getValueOf11() {
		return text11.getText().replaceAll("[^\\x00-\\x7F]","");
	}
	public String getValueOfExcessGolden() {
		return ExcessGolden.getText().replaceAll("[^\\x00-\\x7F]","");
	}
	public String getValueOfStateTaxWithheld1() {
		return StateTaxWithheld.get(0).getText().replaceAll("[^\\x00-\\x7F]","");
	}
	public String getValueOfStateTaxWithheld2() {
		return StateTaxWithheld.get(1).getText().replaceAll("[^\\x00-\\x7F]","");
	}
	public String getValueOfStateNo1() {
		return StateNo.get(0).getText().replaceAll("[^\\x00-\\x7F]","");
	}
	public String getValueOfStateNo2() {
		return StateNo.get(1).getText().replaceAll("[^\\x00-\\x7F]","");
	}
	
	public String getValueOfStateIncome1() {
		return StateIncome.get(0).getText().replaceAll("[^\\x00-\\x7F]","");
	}
	public String getValueOfStateIncome2() {
		return StateIncome.get(1).getText().replaceAll("[^\\x00-\\x7F]","");
	}
	
	public String getYearOfMiscSelected()
	{
		return YearOfMisc.getText().replaceAll("[^\\x00-\\x7F]","");
	}
	public String getFederalIncomeTaxWithheld()
	{
		return FederalIncomeTaxWithheld.getText().replaceAll("[^\\x00-\\x7F]","");
	}
	
	public String getMedicalAndHealthCarePayments()
	{
		return MedicalAndHealthCarePayments.getText().replaceAll("[^\\x00-\\x7F]","");
	}
	public String getSubsitutePayments()
	{
		return SubsitutePayments.getText().replaceAll("[^\\x00-\\x7F]","");
	}
	public String getGrossProceeds()
	{
		return GrossProceeds.getText().replaceAll("[^\\x00-\\x7F]","");
	}
	public String getSection409ADeferrals()
	{
		return Section409ADeferrals.getText().replaceAll("[^\\x00-\\x7F]","");
	}
	public String getNonqualifiedDeferredCompensation()
	{
		return NonqualifiedDeferredCompensation.getText().replaceAll("[^\\x00-\\x7F]","");
	}
	
	public MiscFormStep6 pressBackOnPreviewPage()
	{
		PreviewBackArrow.click();
		MiscFormStep6 MiscFormStep6 = new MiscFormStep6(driver);
		return MiscFormStep6;
	}
}
