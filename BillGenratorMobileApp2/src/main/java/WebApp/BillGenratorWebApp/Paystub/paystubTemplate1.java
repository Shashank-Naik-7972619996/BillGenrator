package WebApp.BillGenratorWebApp.Paystub;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;

import MobileApp.BillGenratorMobileApp2.Utils.ReusableMethods;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class paystubTemplate1 extends ReusableMethods {

	public WebDriver browserdriver;

	public paystubTemplate1(WebDriver browserdriver) {
		super(browserdriver);
		this.browserdriver = browserdriver;
		PageFactory.initElements(browserdriver, this);
		//PageFactory.initElements(new AppiumFieldDecorator(browserdriver), this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "show_loader")
	WebElement show_loader;
	// Template 1 Preview data
	@FindBy(xpath = "//div[@class='w-50 text-uppercase']")
	WebElement Template1CompanyDetails1;
	@FindBy(xpath = "//div[@class='col-7']//div[@class='d-flex mt-3']")
	WebElement Template1SocSecurityMaratialStatusExemptions;
	@FindBy(xpath = "//table[@class='mt-3']")
	WebElement Template1AllPeriodsAllDate;
	@FindBy(xpath = "//div[@class='d-flex mt-3']//div[@class='text-uppercase']")
	WebElement Template1EmployeeDetails;

	@FindBy(xpath = "(//div[contains(@class,'template_1')] //span[@class='total1'])[2]")
	WebElement Template1SalaryTotal;
	@FindBy(xpath = "//div[contains(@class,'template_1')] //span[@class='total1']")
	WebElement Template1RegularTotal;
	@FindBy(xpath = "//div[contains(@class,'template_1')] //span[@class='total2']")
	WebElement Template1OverTimeTotal;
	@FindBy(xpath = "//div[contains(@class,'template_1')] //span[@class='total3']")
	WebElement Template1HolidayTotal;
	@FindBy(xpath = "//div[contains(@class,'template_1')] //span[@class='total4']")
	WebElement Template1VacationTotal;
	@FindBy(xpath = "//div[contains(@class,'template_1')] //span[@class='total5']")
	WebElement Template1BonusTotal;
	@FindBy(xpath = "//div[contains(@class,'template_1')] //span[@class='total6']")
	WebElement Template1FloatTotal;
	@FindBy(xpath = "//div[contains(@class,'template_1')] //span[@class='total7']")
	WebElement Template1TipsTotal;

	@FindBy(xpath = "//div[contains(@class,'template_1')] //span[@class='ytd1']")
	WebElement Template1RegularYtdTotal;
	@FindBy(xpath = "//div[contains(@class,'template_1')] //span[@class='ytd2']")
	WebElement Template1OverTimeYtdTotal;
	@FindBy(xpath = "//div[contains(@class,'template_1')] //span[@class='ytd3']")
	WebElement Template1HolidayYtdTotal;
	@FindBy(xpath = "//div[contains(@class,'template_1')] //span[@class='ytd4']")
	WebElement Template1VacationYtdTotal;
	@FindBy(xpath = "//div[contains(@class,'template_1')] //span[@class='ytd5']")
	WebElement Template1BonusYtdTotal;
	@FindBy(xpath = "//div[contains(@class,'template_1')] //span[@class='ytd6']")
	WebElement Template1FloatYtdTotal;
	@FindBy(xpath = "//div[contains(@class,'template_1')] //span[@class='ytd7']")
	WebElement Template1TipsYtdTotal;

	@FindBy(xpath = "//div[contains(@class,'template_1')]  //span[@class='tcurrent']")
	WebElement Template1GrossPayTotal;
	@FindBy(xpath = "//div[contains(@class,'template_1')]  //span[@class='tytd']")
	WebElement Template1GrossPayYTDTotal;

	@FindBy(xpath = "//table[@class='table table-borderless ms-3']")
	WebElement Template1GrossPayAndAllDeductions;
	@FindBy(xpath = "//div[contains(@class,'template_1')] //span[@class='fica_medicare_total']")
	WebElement Template1FICAMedicareTotal;
	@FindBy(xpath = "//div[contains(@class,'template_1')] //span[@class='fica_social_security_total']")
	WebElement Template1FICASocialSecurityTotal;
	@FindBy(xpath = "//div[contains(@class,'template_1')] //span[@class='federal_tax_total']")
	WebElement Template1FederalTaxTotal;
	@FindBy(xpath = "//div[contains(@class,'template_1')] //span[@class='state_tax_total']")
	WebElement Template1StateTaxTotal;
	@FindBy(xpath = "//div[contains(@class,'template_1')] //span[@class='sdi_total']")
	WebElement Template1SDITaxTotal;
	@FindBy(xpath = "//div[contains(@class,'template_1')] //span[@class='sui_total']")
	WebElement Template1SUITaxTotal;
	@FindBy(xpath = "//div[contains(@class,'template_1')] //span[@class='wc_total']")
	WebElement Template1WCTaxTotal;
	@FindBy(xpath = "//div[contains(@class,'template_1')] //span[@class='wf_total']")
	WebElement Template1WorkForceDevTaxTotal;
	@FindBy(xpath = "//div[contains(@class,'template_1')] //span[@class='fli_total']")
	WebElement Template1FLITaxTotal;

	@FindBy(xpath = "//table[@class='table table-borderless']")
	WebElement Template1OtherBenifitsInformations;
	@FindBy(xpath = "//div[@class='d-flex']//div[@class='text-uppercase']")
	WebElement Template1CompanyDetails2;
	@FindBy(xpath = "(//div[@class='d-flex']/parent::div)[2]")
	WebElement Template1BottomPayDateSocialSecurityNo;
	@FindBy(css = "td[class='p-0; text-uppercase'] span[class='employee_name']")
	WebElement Template1BottomEmployeeNameWithDirectDepositYes;
	@FindBy(css = "td[class='pt-1 text-uppercase'] span[class='employee_name']")
	WebElement Template1BottomEmployeeNameWithDirectDepositNo;
	@FindBy(xpath = "//th[contains(text(),'Account Number')]/../../following-sibling::tbody/tr/td[2]")
	WebElement Template1BottomAccountNumberWithDirectDepositYes;
	@FindBy(css = "td[class='p-0'] span[class='net_pay']")
	WebElement Template1BottomTotalAmountWithDirectDepositYes;
	@FindBy(css = "(//span[@class='net_pay'])[3]")
	WebElement Template1BottomTotalAmountWithDirectDepositNo;
	@FindBy(xpath = "//td[normalize-space()='This amount']/following-sibling::td[1]")
	WebElement Template1BottomTotalAmountWithDirectDepositNoInWords;

	public void waitTillLoaderEnds() throws InterruptedException {
		try {
			if (show_loader.getAttribute("style").contains("opacity")) {
				turnOnWaitOnBrowser();
				Expwait.until(ExpectedConditions.attributeToBe(show_loader, "style", "display: none;"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Thread.sleep(3000l);
	}

	public String getCompanydetailsAtTopLeft() {
		return Template1CompanyDetails1.getText();
	}

	public String getMaratialStatus() {
		return Template1SocSecurityMaratialStatusExemptions.getText();
	}

	public String getPayPeriodDates() {
		return Template1AllPeriodsAllDate.getText();
	}

	public String getEmpDetails() {
		return Template1EmployeeDetails.getText();
	}

//Tax details
	public String getFICAMedicareTemplate1() throws InterruptedException {
		waitTillLoaderEnds();
		return Template1FICAMedicareTotal.getText();
	}

	public String getFicasocialSecurityTotalTemplate1() throws InterruptedException {
		waitTillLoaderEnds();
		return Template1FICASocialSecurityTotal.getText();
	}

	public String getFederalTaxTotalTemplate1() throws InterruptedException {
		waitTillLoaderEnds();
		return Template1FederalTaxTotal.getText();
	}

	public String getStateTaxTotalTemplate1() throws InterruptedException {
		waitTillLoaderEnds();
		return Template1StateTaxTotal.getText();
	}

	public String getSDITaxTotalTemplate1() throws InterruptedException {
		waitTillLoaderEnds();
		return Template1SDITaxTotal.getText();
	}

	public String getSUITaxTotalTemplate1() throws InterruptedException {
		waitTillLoaderEnds();
		return Template1SUITaxTotal.getText();
	}

	public String getWCTaxTotalTemplate1() throws InterruptedException {
		waitTillLoaderEnds();
		return Template1WCTaxTotal.getText();
	}

	public String getFLITaxTotalTemplate1() throws InterruptedException {
		waitTillLoaderEnds();
		return Template1FLITaxTotal.getText();
	}

	public String getTemplate1WorkForceDevTaxTotal() throws InterruptedException {
		waitTillLoaderEnds();
		return Template1WorkForceDevTaxTotal.getText();
	}

	public String getTemplate1RegularTotal() throws InterruptedException {
		waitTillLoaderEnds();
		return Template1RegularTotal.getText();
	}

	public String getTemplate1SalaryTotal() throws InterruptedException {
		waitTillLoaderEnds();
		return Template1SalaryTotal.getText();
	}

	public String getTemplate1OverTimeTotal() throws InterruptedException {
		waitTillLoaderEnds();
		// TODO Auto-generated method stub
		return Template1OverTimeTotal.getText();
	}

	public String getTemplate1HolidayTotal() throws InterruptedException {
		waitTillLoaderEnds();
		// TODO Auto-generated method stub
		return Template1HolidayTotal.getText();
	}

	public String getTemplate1VacationTotal() throws InterruptedException {
		waitTillLoaderEnds();
		// TODO Auto-generated method stub
		return Template1VacationTotal.getText();
	}

	public String getTemplate1BonusTotal() throws InterruptedException {
		waitTillLoaderEnds();
		// TODO Auto-generated method stub
		return Template1BonusTotal.getText();
	}

	public String getTemplate1FloatTotal() throws InterruptedException {
		waitTillLoaderEnds();
		// TODO Auto-generated method stub
		return Template1FloatTotal.getText();
	}

	public String getTemplate1TipsTotal() throws InterruptedException {
		waitTillLoaderEnds();
		// TODO Auto-generated method stub
		return Template1TipsTotal.getText();
	}

	public String getTemplate1RegularYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template1RegularYtdTotal.getText();
	}

	public String getTemplate1OverTimeYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template1OverTimeYtdTotal.getText();
	}

	public String getTemplate1HolidayYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template1HolidayYtdTotal.getText();
	}

	public String getTemplate1VacationYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template1VacationYtdTotal.getText();
	}

	public String getTemplate1BonusYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template1BonusYtdTotal.getText();
	}

	public String getTemplate1FloatYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template1FloatYtdTotal.getText();
	}

	public String getTemplate1TipsYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template1TipsYtdTotal.getText();
	}

}
