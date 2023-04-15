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

public class W2FormStep5 extends ReusableMethods {
	AndroidDriver driver;

	public W2FormStep5(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}

	@AndroidFindBys({ @AndroidBy(className = "android.widget.EditText") })
	private List<WebElement> TextFields;

	@AndroidFindBy(xpath = "//*[contains(@text, 'Wages,tips')]")
	private WebElement WagesTipsOtherCompensation;
	@AndroidFindBy(xpath = "//*[contains(@text, 'Federal Income tax')]")
	private WebElement FederalIncomeTax;
	@AndroidFindBy(xpath = "//*[contains(@text, 'Social Security Wages')]")
	private WebElement SocialSecurityWages;
	@AndroidFindBy(xpath = "//*[contains(@text, 'Social Security tax withheld')]")
	private WebElement SocialSecurityTaxWithheld;
	@AndroidFindBy(xpath = "//*[contains(@text, 'Medicare Wages and tips')]")
	private WebElement MedicareWagesAndTips;
	@AndroidFindBy(xpath = "//*[contains(@text, 'Medicare tax withheld')]")
	private WebElement MedicareTaxWithheld;
	@AndroidFindBy(xpath = "//*[contains(@text, 'Social Security tips')]")
	private WebElement SocialSecurityTips;
	@AndroidFindBy(xpath = "//*[contains(@text, 'Allocated tips')]")
	private WebElement AllocatedTips;
	@AndroidFindBy(xpath = "//*[contains(@text, 'Dependent care benefits')]")
	private WebElement DependentCareBenefits;
	@AndroidFindBy(xpath = "//*[contains(@text, 'Nonqualified Plans')]")
	private WebElement NonqualifiedPlans;
	@AndroidFindBy(xpath = "//*[contains(@text, '12a')]")
	private WebElement a12a;
	@AndroidFindBy(xpath = "//*[contains(@text, '12b')]")
	private WebElement b12b;
	@AndroidFindBy(xpath = "//*[contains(@text, '12c')]")
	private WebElement c12c;
	@AndroidFindBy(xpath = "//*[contains(@text, '12d')]")
	private WebElement d12d;
	@AndroidFindBy(xpath = "//*[contains(@text, '14 Others')]")
	private WebElement a14Others;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Statutory employee']/following-sibling::android.view.View[3]")
	private WebElement StatutoryEmployeeCheckBox;
	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Retirement plan']/following-sibling::android.view.View[3]")
	private WebElement RetirementPlanCheckBox;
	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Third-party sick pay']/following-sibling::android.view.View[3]")
	private WebElement ThirdPartySickPayCheckBox;
	@AndroidFindBy(accessibility = "NEXT")
	private WebElement NEXT;
	@AndroidFindBy(accessibility = "PRIVIOUS")
	private WebElement PRIVIOUS;

//	public String findFieldRequiredAndEnterValue(String field, String value) throws Exception
//	{
//		String value1 = null;
//		driver.hideKeyboard();
//		driver.pressKey(null);
//		scrollUpTillElement("//android.widget.EditText[@text='"+field+"']");
//
//		for(int i=0;i<TextFields.size();i++)
//		{
//			
//			if(TextFields.get(i).getAttribute("text").contains(field))
//			{
//				TextFields.get(i).click();
//				
//				TextFields.get(i).sendKeys(value);
//				value1 =TextFields.get(i).getText();
//			}
//		}
//		return value1;
//	}

	public void enterWagesTipsOtherCompensation(String WagesTipsOtherCompensation1) throws Exception {
		String elementtext = "Wages,tips, other compensation";
		scrollUpTillElement("//android.widget.EditText[contains(@text,'"+elementtext+"')]");
		WagesTipsOtherCompensation.click();
		WagesTipsOtherCompensation.sendKeys(WagesTipsOtherCompensation1);
	}

	public void enterFederalIncomeTax(String FederalIncomeTax1) throws Exception {
		String elementtext = "Wages,tips, other compensation";
		scrollUpTillElement("//android.widget.EditText[contains(@text,'"+ elementtext +"')]");
		FederalIncomeTax.click();
		FederalIncomeTax.sendKeys(FederalIncomeTax1);
	}

	public void enterSocialSecurityWages(String SocialSecurityWages1) {
		SocialSecurityWages.click();
		SocialSecurityWages.sendKeys(SocialSecurityWages1);
	}

	public void enterSocialSecurityTaxWithheld(String SocialSecurityTaxWithheld1) {
		SocialSecurityTaxWithheld.click();
		SocialSecurityTaxWithheld.sendKeys(SocialSecurityTaxWithheld1);
	}

	public void enterMedicareWagesAndTips(String MedicareWagesAndTips1) {
		MedicareWagesAndTips.click();
		MedicareWagesAndTips.sendKeys(MedicareWagesAndTips1);
	}

	public void enterMedicareTaxWithheld(String MedicareTaxWithheld1) {
		MedicareTaxWithheld.click();
		MedicareTaxWithheld.sendKeys(MedicareTaxWithheld1);
	}

	public void enterSocialSecurityTips(String SocialSecurityTips1) {
		SocialSecurityTips.click();
		SocialSecurityTips.sendKeys(SocialSecurityTips1);
	}

	public void enterAllocatedTips(String AllocatedTips1) {
		AllocatedTips.click();
		AllocatedTips.sendKeys(AllocatedTips1);
	}

	public void enterDependentCareBenefits(String DependentCareBenefits1) {
		DependentCareBenefits.click();
		DependentCareBenefits.sendKeys(DependentCareBenefits1);
	}

	public void enterNonqualifiedPlans(String NonqualifiedPlans1) {
		NonqualifiedPlans.click();
		NonqualifiedPlans.sendKeys(NonqualifiedPlans1);
	}

	public void enter12a(String a12a1) {
		a12a.click();
		a12a.sendKeys(a12a1);
	}

	public void enter12b(String b12b1) {
		b12b.click();
		b12b.sendKeys(b12b1);
	}

	public void enter12c(String c12c1) {
		c12c.click();
		c12c.sendKeys(c12c1);
	}

	public void enter12d(String d12d1) {
		d12d.click();
		d12d.sendKeys(d12d1);
		driver.hideKeyboard();
	}

	public void enter14Others(String a14Others1) {
		a14Others.click();
		a14Others.sendKeys(a14Others1);
	}

	public void tickCheckBoxStatutoryEmployee() {
		// Scrolluntil("14 Others");
		StatutoryEmployeeCheckBox.click();
	}

	public void tickCheckBoxRetirementPlan() {
		// Scrolluntil("14 Others");
		RetirementPlanCheckBox.click();
	}

	public void tickCheckBoxThirdPartySickPay() {
		// Scrolluntil("14 Others");
		ThirdPartySickPayCheckBox.click();
	}

	public W2FormStep6 pressNEXT() {
		NEXT.click();
		W2FormStep6 W2FormStep6 = new W2FormStep6(driver);
		return W2FormStep6;

	}

	public void pressPRIVIOUS() {
		PRIVIOUS.click();
	}
}
