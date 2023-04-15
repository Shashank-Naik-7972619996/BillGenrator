package MobileApp.BillGenratorMobileApp2.PageObject.Android.W2Form;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import MobileApp.BillGenratorMobileApp2.Utils.ReusableMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class W2PreviewPage extends ReusableMethods {
	AndroidDriver driver;

	public W2PreviewPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}

	// @AndroidFindBy(xpath = "//android.view.View[contains(@text='Social Security
	// Number')]/../following-sibling::android.view.View/android.view.View")
	@AndroidFindBy(xpath = "//android.widget.Image[@text='draft-watermark']/../following-sibling::android.view.View/android.view.View/android.view.View/android.widget.GridView/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View")
	private WebElement EmpSocialSecurityNumber;
	@AndroidFindBy(xpath = "//*[contains(@text,'OMB No.')]")
	private WebElement OMBNo;
	// android.widget.TextView[contains(@text,"Employer's Identification
	// Number")]/following-sibling::android.view.View/android.view.View/android.view.View
	@AndroidFindBy(xpath = "//*[contains(@text,'Identification Number')]/following-sibling::android.view.View/android.view.View/android.view.View")
	private WebElement EmpIdentificationNumber;
	@AndroidFindBys({
			@AndroidBy(xpath = "//*[contains(@text,'Name')]/following-sibling::android.view.View/android.view.View/android.view.View") })
	private List<WebElement> EmployersDetails;
	@AndroidFindBys({
			@AndroidBy(xpath = "//*[contains(@text,'Employee')]/following-sibling::android.view.View/android.view.View/android.view.View") })
	private List<WebElement> EmployeesDetails;
	@AndroidFindBy(xpath = "//*[contains(@text,'Control Number')]/following-sibling::android.view.View/android.view.View/android.view.View")
	private WebElement ControlNumber;
	// android.widget.Image[@text="draft-watermark"]/../following-sibling::android.view.View/android.view.View[2]/android.view.View/android.widget.GridView/android.view.View/android.view.View[2]/android.widget.GridView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View
	@AndroidFindBys({
			@AndroidBy(xpath = "//android.widget.Image[@text='draft-watermark']/../following-sibling::android.view.View/android.view.View[2]/android.view.View/android.widget.GridView/android.view.View/android.view.View[2]/android.widget.GridView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View") })
	private List<WebElement> Overlappedrightfields;

	@AndroidFindBys({
			@AndroidBy(xpath = "//android.widget.Image[@text='draft-watermark']/../following-sibling::android.view.View/android.view.View[2]/android.view.View/android.widget.GridView/android.view.View/android.view.View[2]/android.widget.GridView/android.view.View[7]/android.view.View/android.view.View/android.view.View/android.view.View") })
	private List<WebElement> OverlappedCheckboxes;

	@AndroidFindBy(xpath = "//*[contains(@text,'compensation')]/following-sibling::android.view.View/android.view.View/android.view.View")
	private WebElement WagesTipsOther;
	@AndroidFindBy(xpath = "//*[contains(@text,'Federal')]/following-sibling::android.view.View/android.view.View/android.view.View")
	private WebElement FederalIncomeTaxWithheld;
	@AndroidFindBy(xpath = "//*[contains(@text,'Social Security Wages')]/following-sibling::android.view.View/android.view.View/android.view.View")
	private WebElement SocialSecurityWages;
	@AndroidFindBy(xpath = "//*[contains(@text,'Social Security tax withheld')]/following-sibling::android.view.View/android.view.View/android.view.View")
	private WebElement SocialSecurityTaxWithheld;
	@AndroidFindBy(xpath = "//*[contains(@text,'Medicare Wages and tips')]/following-sibling::android.view.View/android.view.View/android.view.View")
	private WebElement MedicareWagesAndTips;
	@AndroidFindBy(xpath = "//*[contains(@text,'Medicare tax withheld')]/following-sibling::android.view.View/android.view.View/android.view.View")
	private WebElement MedicareTaxWithheld;
	@AndroidFindBy(xpath = "//*[contains(@text,'Social Security tips')]/following-sibling::android.view.View/android.view.View/android.view.View")
	private WebElement SocialSecurityTips;
	@AndroidFindBy(xpath = "//*[contains(@text,'Allocated tips')]/following-sibling::android.view.View/android.view.View/android.view.View")
	private WebElement AllocatedTips;
	@AndroidFindBy(xpath = "//*[contains(@text,'Dependent care benefits')]/following-sibling::android.view.View/android.view.View/android.view.View")
	private WebElement DependentCareBenefits;
	@AndroidFindBy(xpath = "//*[contains(@text,'Nonqualified Plans')]/following-sibling::android.view.View/android.view.View/android.view.View")
	private WebElement NonqualifiedPlans;
	@AndroidFindBy(xpath = "//*[contains(@text,'12a')]/following-sibling::android.view.View/android.view.View/android.view.View")
	private WebElement a12a;
	@AndroidFindBy(xpath = "//*[contains(@text,'12b')]/following-sibling::android.view.View/android.view.View/android.view.View")
	private WebElement b12b;
	@AndroidFindBy(xpath = "//*[contains(@text,'12c')]/following-sibling::android.view.View/android.view.View/android.view.View")
	private WebElement c12c;
	@AndroidFindBy(xpath = "//*[contains(@text,'12d')]/following-sibling::android.view.View/android.view.View/android.view.View")
	private WebElement d12d;
	@AndroidFindBy(xpath = "//*[@text='Statutory employee']/../following-sibling::android.view.View/android.view.View/android.widget.Image")
	private WebElement StatutoryEmployee;
	@AndroidFindBy(xpath = "//*[@text='Retirement plan']/../following-sibling::android.view.View/android.view.View/android.widget.Image")
	private WebElement RetirementPlan;
	@AndroidFindBy(xpath = "//*[@text='Third-party sick pay']/../following-sibling::android.view.View/android.view.View/android.widget.Image")
	private WebElement ThirdPartySickPay;
	@AndroidFindBy(xpath = "//*[contains(@text,'Others')]/following-sibling::android.view.View/android.view.View/android.view.View")
	private WebElement Others;
	@AndroidFindBy(xpath = "//*[@text='State']/following-sibling::android.view.View/android.view.View/android.view.View")
	private WebElement State;
	@AndroidFindBy(xpath = "//*[contains(@text,'State ID number')]/following-sibling::android.view.View/android.view.View/android.view.View")
	private WebElement EmployerStateIDNumber;
	@AndroidFindBy(xpath = "//*[@text='State,Wages,tips etc']/following-sibling::android.view.View/android.view.View/android.view.View")
	private WebElement StateWagesTipsEtc;
	@AndroidFindBy(xpath = "//*[@text='State income tax']/following-sibling::android.view.View/android.view.View/android.view.View")
	private WebElement StateIncomeTax;
	@AndroidFindBy(xpath = "//*[@text='Local wages,tips etc']/following-sibling::android.view.View/android.view.View/android.view.View")
	private WebElement LocalWagesTipsEtc;
	@AndroidFindBy(xpath = "//*[@text='Local income tax']/following-sibling::android.view.View/android.view.View/android.view.View")
	private WebElement LocalIncomeTax;
	@AndroidFindBy(xpath = "//*[@text='Locality name']/following-sibling::android.view.View/android.view.View/android.view.View")
	private WebElement LocalityName;
	@AndroidFindBy(xpath = "(//*[contains(@text,'Copy D -- For Employer')]/android.view.View/android.view.View/android.view.View[2]/android.view.View)[2]")
	private WebElement YearAtBottom;
	
	@AndroidFindBy(xpath = "(//*[@class=\"android.view.View\"])[4]")
	private WebElement PressOnScreenBackButton;
	
	

	public void pressBackButtonOnScreen()
	{
		PressOnScreenBackButton.click();
	}
	public String getvalueof(String attribute) {
		if (attribute.contains("Wages,tips, other compensation"))

			return Overlappedrightfields.get(0).getText();

		if (attribute.contains("Social Security Wages"))

			return Overlappedrightfields.get(1).getText();

		if (attribute.contains("Medicare Wages and tips"))

			return Overlappedrightfields.get(2).getText();

		if (attribute.contains("Social Security tips"))

			return Overlappedrightfields.get(3).getText();

		if (attribute.contains("Nonqualified Plans"))

			return Overlappedrightfields.get(4).getText();

		if (attribute.contains("Others"))

			return Overlappedrightfields.get(9).getText();
		return null;
	}

	public String getCheckboxStatusfor(String label) {
		if (label.contains("Statutory employee")) {
			String ischecked = OverlappedCheckboxes.get(1).getText();
			if (ischecked.contains("unchecked")) {
				return "unchecked";
			} else {
				return "checked";
			}
		}
		if (label.contains("Retirement plan")) {
			String ischecked = OverlappedCheckboxes.get(2).getText();
			if (ischecked.contains("unchecked")) {
				return "unchecked";
			} else {
				return "checked";
			}
		}
		if (label.contains("Third-party sick pay")) {
			String ischecked = OverlappedCheckboxes.get(3).getText();
			if (ischecked.contains("unchecked")) {
				return "unchecked";
			} else {
				return "checked";
			}
		}
		return null;

	}

	public String getEmpSocialSecurityNumber() {
		return EmpSocialSecurityNumber.getText();
	}

	public String getOMBNo() {
		return OMBNo.getText();
	}

	public String getEmpIdentificationNumber() {
		return EmpIdentificationNumber.getText();
	}

	public String getEmployerCompanyName() {
		//String CompanyName= driver.findElement(By.xpath("(//*[contains(@text,'Name')]/following-sibling::android.view.View/android.view.View/android.view.View)[1]")).getText();
		return EmployersDetails.get(0).getText();
		//return  CompanyName;
	}

	public String getEmployerCompanyAddress() {
		return EmployersDetails.get(1).getText();
	}

	public String getEmployerCompanyZipAndCityAndState() {
		return EmployersDetails.get(2).getText();
	}

	public String getEmployeeName() {
		return EmployeesDetails.get(0).getText();
	}

	public String getEmployeeAddress() {
		return EmployeesDetails.get(1).getText();
	}

	public String getEmployeeZipAndCityAndState() {
		return EmployeesDetails.get(2).getText();
	}

	public String getControlNumber() {
		return ControlNumber.getText();
	}

	public String getWagesTipsOther() {
		return WagesTipsOther.getText();
	}

	public String getFederalIncomeTaxWithheld() {
		return FederalIncomeTaxWithheld.getText();
	}

	public String getSocialSecurityWages() {
		return SocialSecurityWages.getText();
	}

	public String getSocialSecurityTaxWithheld() {
		return SocialSecurityTaxWithheld.getText();
	}

	public String getMedicareWagesAndTips() {
		return MedicareWagesAndTips.getText();
	}

	public String getMedicareTaxWithheld() {
		return MedicareTaxWithheld.getText();
	}

	public String getSocialSecurityTips() {
		return SocialSecurityTips.getText();
	}

	public String getAllocatedTips() {
		return AllocatedTips.getText();
	}

	public String getDependentCareBenefits() {
		return DependentCareBenefits.getText();
	}

	public String getNonqualifiedPlans() {
		return NonqualifiedPlans.getText();
	}

	public String get12a() {
		return a12a.getText();
	}

	public String get12b() {
		return b12b.getText();
	}

	public String get12c() {
		return c12c.getText();
	}

	public String get12d() {
		return d12d.getText();
	}

	public String getStatutoryEmployeeStatus() {
		return StatutoryEmployee.getText();
	}

	public String getRetirementPlanStatus() {
		return RetirementPlan.getText();
	}

	public String getThirdPartySickPay() {
		return ThirdPartySickPay.getText();
	}

	public String getOthers() {
		return Others.getText();
	}

	public String getState() {
		return State.getText();
	}

	public String getEmployerStateIDNumber() {
		return EmployerStateIDNumber.getText();
	}

	public String getStateWagesTipsEtc() {
		return StateWagesTipsEtc.getText();
	}

	public String getStateIncomeTax() {
		return StateIncomeTax.getText();
	}

	public String getLocalWagesTipsEtc() {
		return LocalWagesTipsEtc.getText();
	}

	public String getLocalIncomeTax() {
		return LocalIncomeTax.getText();
	}

	public String getLocalityName() {
		return LocalityName.getText();
	}

	public String getYearAtbottom() {
		return YearAtBottom.getText();
	}
	
	public String getShortCutOfState(String stateSelected)
	{
		return getShortState(stateSelected);
	}
}
