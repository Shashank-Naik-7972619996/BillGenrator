package WebApp.BillGenratorWebApp.Paystub;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import MobileApp.BillGenratorMobileApp2.Utils.ReusableMethods;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class paystubTemplate2 extends ReusableMethods{

	public WebDriver browserdriver;

	public paystubTemplate2(WebDriver browserdriver) {
		super(browserdriver);
		this.browserdriver = browserdriver;
		PageFactory.initElements(browserdriver, this);
		//PageFactory.initElements(new AppiumFieldDecorator(browserdriver), this);
		// TODO Auto-generated constructor stub
	}
	@FindBy(id = "show_loader")
	WebElement show_loader;
	//company address on template 2
	@FindBy(xpath="//div[@class='col-9']//div[@class='w-50 text-uppercase']")
	WebElement companytopAddress;
	
	@FindBy(xpath = "//div[contains(@class,'template_2')] //span[@class='total1']")
	WebElement Template2RegularTotal;
	@FindBy(xpath = "//div[contains(@class,'template_2')] //span[@class='total2']")
	WebElement Template2OverTimeTotal;
	@FindBy(xpath = "//div[contains(@class,'template_2')] //span[@class='total3']")
	WebElement Template2HolidayTotal;
	@FindBy(xpath = "//div[contains(@class,'template_2')] //span[@class='total4']")
	WebElement Template2VacationTotal;
	@FindBy(xpath = "//div[contains(@class,'template_2')] //span[@class='total5']")
	WebElement Template2BonusTotal;
	@FindBy(xpath = "//div[contains(@class,'template_2')] //span[@class='total6']")
	WebElement Template2FloatTotal;
	@FindBy(xpath = "//div[contains(@class,'template_2')] //span[@class='total7']")
	WebElement Template2TipsTotal;
	
	@FindBy(xpath = "//div[contains(@class,'template_2')] //span[@class='ytd1']")
	WebElement Template2RegularYtdTotal;
	@FindBy(xpath = "//div[contains(@class,'template_2')] //span[@class='ytd2']")
	WebElement Template2OverTimeYtdTotal;
	@FindBy(xpath = "//div[contains(@class,'template_2')] //span[@class='ytd3']")
	WebElement Template2HolidayYtdTotal;
	@FindBy(xpath = "//div[contains(@class,'template_2')] //span[@class='ytd4']")
	WebElement Template2VacationYtdTotal;
	@FindBy(xpath = "//div[contains(@class,'template_2')] //span[@class='ytd5']")
	WebElement Template2BonusYtdTotal;
	@FindBy(xpath = "//div[contains(@class,'template_2')] //span[@class='ytd6']")
	WebElement Template2FloatYtdTotal;
	@FindBy(xpath = "//div[contains(@class,'template_2')] //span[@class='ytd7']")
	WebElement Template2TipsYtdTotal;
	
	@FindBy(xpath="//div[contains(@class,'template_2')] //span[@class='fica_medicare_total']")
	WebElement Template2fica_medicare_total;
	@FindBy(xpath="//div[contains(@class,'template_2')] //span[@class='fica_social_security_total']")
	WebElement Template2fica_social_security_total;
	@FindBy(xpath="//div[contains(@class,'template_2')] //span[@class='federal_tax_total']")
	WebElement Template2federal_tax_total;
	@FindBy(xpath="//div[contains(@class,'template_2')] //span[@class='state_tax_total']")
	WebElement Template2state_tax_total;
	@FindBy(xpath="//div[contains(@class,'template_2')] //span[@class='sdi_total']")
	WebElement Template2sdi_total;
	@FindBy(xpath="//div[contains(@class,'template_2')] //span[@class='sui_total']")
	WebElement Template2sui_total;
	@FindBy(xpath="//div[contains(@class,'template_2')] //span[@class='wc_total']")
	WebElement Template2wc_total;
	@FindBy(xpath="//div[contains(@class,'template_2')] //span[@class='fli_total']")
	WebElement Template2fli_total;
	@FindBy(xpath="//div[contains(@class,'template_2')] //span[@class='wf_total']")
	WebElement Template2wf_total;
	
	
	
	public void waitTillLoaderEnds() throws InterruptedException {
		try {
			if (show_loader.getAttribute("style").contains("opacity")) {
				turnOnWaitOnBrowser();
				Expwait.until(ExpectedConditions.attributeToBe(show_loader, "style", "display: none;"));
			}
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Thread.sleep(3000l);
	}
	public String getTopCompanyNameTemplate2()
	{
		return companytopAddress.getText();
	}
	
	public String getFICAMedicareTemplate2()
	{
		return Template2fica_medicare_total.getText();
	}
	
	public String getTemplate2RegularTotal() throws InterruptedException {
		waitTillLoaderEnds();
		return Template2RegularTotal.getText();
	}

	public String getTemplate2OverTimeTotal() throws InterruptedException {
		waitTillLoaderEnds();
		// TODO Auto-generated method stub
		return Template2OverTimeTotal.getText();
	}

	public String getTemplate2HolidayTotal() throws InterruptedException {
		waitTillLoaderEnds();
		// TODO Auto-generated method stub
		return Template2HolidayTotal.getText();
	}

	public String getTemplate2VacationTotal() throws InterruptedException {
		waitTillLoaderEnds();
		// TODO Auto-generated method stub
		return Template2VacationTotal.getText();
	}

	public String getTemplate2BonusTotal() throws InterruptedException {
		waitTillLoaderEnds();
		// TODO Auto-generated method stub
		return Template2BonusTotal.getText();
	}

	public String getTemplate2FloatTotal() throws InterruptedException {
		waitTillLoaderEnds();
		// TODO Auto-generated method stub
		return Template2FloatTotal.getText();
	}

	public String getTemplate2TipsTotal() throws InterruptedException {
		waitTillLoaderEnds();
		// TODO Auto-generated method stub
		return Template2TipsTotal.getText();
	}

	public String getTemplate2RegularYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template2RegularYtdTotal.getText();
	}

	public String getTemplate2OverTimeYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template2OverTimeYtdTotal.getText();
	}

	public String getTemplate2HolidayYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template2HolidayYtdTotal.getText();
	}

	public String getTemplate2VacationYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template2VacationYtdTotal.getText();
	}

	public String getTemplate2BonusYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template2BonusYtdTotal.getText();
	}

	public String getTemplate2FloatYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template2FloatYtdTotal.getText();
	}

	public String getTemplate2TipsYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template2TipsYtdTotal.getText();
	}
	public String getFederalTaxTotalTemplate2() throws InterruptedException {
		waitTillLoaderEnds();
		return Template2federal_tax_total.getText();
	}
	public String getFicasocialSecurityTotalTemplate2() throws InterruptedException {
		waitTillLoaderEnds();
		return Template2fica_social_security_total.getText();
	}
	public String getStateTaxTotalTemplate2() throws InterruptedException {
		waitTillLoaderEnds();
		return Template2state_tax_total.getText();
	}
	public String getSDITaxTotalTemplate2() throws InterruptedException {
		waitTillLoaderEnds();
		return Template2sdi_total.getText();
	}
	public String getSUITaxTotalTemplate2() throws InterruptedException {
		waitTillLoaderEnds();
		return Template2sui_total.getText();
	}
	public String getWCTaxTotalTemplate2() throws InterruptedException {
		waitTillLoaderEnds();
		return Template2wc_total.getText();
	}
	public String getFLITaxTotalTemplate2() throws InterruptedException {
		waitTillLoaderEnds();
		return Template2fli_total.getText();
	}
	public String getTemplate2WorkForceDevTaxTotal() throws InterruptedException {
		waitTillLoaderEnds();
		return Template2wf_total.getText();
	}
}
