package WebApp.BillGenratorWebApp.Paystub;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import MobileApp.BillGenratorMobileApp2.Utils.ReusableMethods;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class paystubTemplate3 extends ReusableMethods {

	public WebDriver browserdriver;

	public paystubTemplate3(WebDriver browserdriver) {
		super(browserdriver);
		this.browserdriver = browserdriver;
		PageFactory.initElements(browserdriver, this);
		//PageFactory.initElements(new AppiumFieldDecorator(browserdriver), this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "show_loader")
	WebElement show_loader;
	@FindBy(xpath = "")
	WebElement ficaMedicare;
	@FindBy(xpath = "//div[contains(@class,'template_3')] //span[@class='total1']")
	WebElement Template3RegularTotal;
	@FindBy(xpath = "//div[contains(@class,'template_3')] //span[@class='total2']")
	WebElement Template3OverTimeTotal;
	@FindBy(xpath = "//div[contains(@class,'template_3')] //span[@class='total3']")
	WebElement Template3HolidayTotal;
	@FindBy(xpath = "//div[contains(@class,'template_3')] //span[@class='total4']")
	WebElement Template3VacationTotal;
	@FindBy(xpath = "//div[contains(@class,'template_3')] //span[@class='total5']")
	WebElement Template3BonusTotal;
	@FindBy(xpath = "//div[contains(@class,'template_3')] //span[@class='total6']")
	WebElement Template3FloatTotal;
	@FindBy(xpath = "//div[contains(@class,'template_3')] //span[@class='total7']")
	WebElement Template3TipsTotal;

	@FindBy(xpath = "//div[contains(@class,'template_3')] //span[@class='ytd1']")
	WebElement Template3RegularYtdTotal;
	@FindBy(xpath = "//div[contains(@class,'template_3')] //span[@class='ytd2']")
	WebElement Template3OverTimeYtdTotal;
	@FindBy(xpath = "//div[contains(@class,'template_3')] //span[@class='ytd3']")
	WebElement Template3HolidayYtdTotal;
	@FindBy(xpath = "//div[contains(@class,'template_3')] //span[@class='ytd4']")
	WebElement Template3VacationYtdTotal;
	@FindBy(xpath = "//div[contains(@class,'template_3')] //span[@class='ytd5']")
	WebElement Template3BonusYtdTotal;
	@FindBy(xpath = "//div[contains(@class,'template_3')] //span[@class='ytd6']")
	WebElement Template3FloatYtdTotal;
	@FindBy(xpath = "//div[contains(@class,'template_3')] //span[@class='ytd7']")
	WebElement Template3TipsYtdTotal;

	@FindBy(xpath = "//div[contains(@class,'template_3')] //span[@class='fica_medicare_total']")
	WebElement Template3fica_medicare_total;
	@FindBy(xpath = "//div[contains(@class,'template_3')] //span[@class='fica_social_security_total']")
	WebElement Template3fica_social_security_total;
	@FindBy(xpath = "//div[contains(@class,'template_3')] //span[@class='federal_tax_total']")
	WebElement Template3federal_tax_total;
	@FindBy(xpath = "//div[contains(@class,'template_3')] //span[@class='state_tax_total']")
	WebElement Template3state_tax_total;
	@FindBy(xpath = "//div[contains(@class,'template_3')] //span[@class='sdi_total']")
	WebElement Template3sdi_total;
	@FindBy(xpath = "//div[contains(@class,'template_3')] //span[@class='sui_total']")
	WebElement Template3sui_total;
	@FindBy(xpath = "//div[contains(@class,'template_3')] //span[@class='wc_total']")
	WebElement Template3wc_total;
	@FindBy(xpath = "//div[contains(@class,'template_3')] //span[@class='fli_total']")
	WebElement Template3fli_total;
	@FindBy(xpath = "//div[contains(@class,'template_3')] //span[@class='wf_total']")
	WebElement Template3wf_total;

	public String getFICAMedicareTemplate3() {

		// TODO Auto-generated method stub
		return Template3fica_medicare_total.getText();
	}

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

	public String getTemplate3RegularTotal() throws InterruptedException {
		waitTillLoaderEnds();
		return Template3RegularTotal.getText();
	}

	public String getTemplate3OverTimeTotal() throws InterruptedException {
		waitTillLoaderEnds();
		// TODO Auto-generated method stub
		return Template3OverTimeTotal.getText();
	}

	public String getTemplate3HolidayTotal() throws InterruptedException {
		waitTillLoaderEnds();
		// TODO Auto-generated method stub
		return Template3HolidayTotal.getText();
	}

	public String getTemplate3VacationTotal() throws InterruptedException {
		waitTillLoaderEnds();
		// TODO Auto-generated method stub
		return Template3VacationTotal.getText();
	}

	public String getTemplate3BonusTotal() throws InterruptedException {
		waitTillLoaderEnds();
		// TODO Auto-generated method stub
		return Template3BonusTotal.getText();
	}

	public String getTemplate3FloatTotal() throws InterruptedException {
		waitTillLoaderEnds();
		// TODO Auto-generated method stub
		return Template3FloatTotal.getText();
	}

	public String getTemplate3TipsTotal() throws InterruptedException {
		waitTillLoaderEnds();
		// TODO Auto-generated method stub
		return Template3TipsTotal.getText();
	}

	public String getTemplate3RegularYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template3RegularYtdTotal.getText();
	}

	public String getTemplate3OverTimeYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template3OverTimeYtdTotal.getText();
	}

	public String getTemplate3HolidayYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template3HolidayYtdTotal.getText();
	}

	public String getTemplate3VacationYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template3VacationYtdTotal.getText();
	}

	public String getTemplate3BonusYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template3BonusYtdTotal.getText();
	}

	public String getTemplate3FloatYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template3FloatYtdTotal.getText();
	}

	public String getTemplate3TipsYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template3TipsYtdTotal.getText();
	}

	public String getFederalTaxTotalTemplate3() throws InterruptedException {
		waitTillLoaderEnds();
		return Template3federal_tax_total.getText();
	}

	public String getFicasocialSecurityTotalTemplate3() throws InterruptedException {
		waitTillLoaderEnds();
		return Template3fica_social_security_total.getText();
	}

	public String getStateTaxTotalTemplate3() throws InterruptedException {
		waitTillLoaderEnds();
		return Template3state_tax_total.getText();
	}

	public String getSDITaxTotalTemplate3() throws InterruptedException {
		waitTillLoaderEnds();
		return Template3sdi_total.getText();
	}

	public String getSUITaxTotalTemplate3() throws InterruptedException {
		waitTillLoaderEnds();
		return Template3sui_total.getText();
	}

	public String getWCTaxTotalTemplate3() throws InterruptedException {
		waitTillLoaderEnds();
		return Template3wc_total.getText();
	}

	public String getFLITaxTotalTemplate3() throws InterruptedException {
		waitTillLoaderEnds();
		return Template3fli_total.getText();
	}

	public String getTemplate3WorkForceDevTaxTotal() throws InterruptedException {
		waitTillLoaderEnds();
		return Template3wf_total.getText();
	}

	
}
