package WebApp.BillGenratorWebApp.Paystub;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import MobileApp.BillGenratorMobileApp2.Utils.ReusableMethods;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class paystubTemplate5 extends ReusableMethods {

	public WebDriver browserdriver;

	public paystubTemplate5(WebDriver browserdriver) {
		super(browserdriver);
		this.browserdriver = browserdriver;
		PageFactory.initElements(browserdriver, this);
		//PageFactory.initElements(new AppiumFieldDecorator(browserdriver), this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "show_loader")
	WebElement show_loader;
	@FindBy(xpath = "//div[contains(@class,'template_5')] //span[@class='total1']")
	WebElement Template5RegularTotal;
	@FindBy(xpath = "//div[contains(@class,'template_5')] //span[@class='total2']")
	WebElement Template5OverTimeTotal;
	@FindBy(xpath = "//div[contains(@class,'template_5')] //span[@class='total3']")
	WebElement Template5HolidayTotal;
	@FindBy(xpath = "//div[contains(@class,'template_5')] //span[@class='total4']")
	WebElement Template5VacationTotal;
	@FindBy(xpath = "//div[contains(@class,'template_5')] //span[@class='total5']")
	WebElement Template5BonusTotal;
	@FindBy(xpath = "//div[contains(@class,'template_5')] //span[@class='total6']")
	WebElement Template5FloatTotal;
	@FindBy(xpath = "//div[contains(@class,'template_5')] //span[@class='total7']")
	WebElement Template5TipsTotal;

	@FindBy(xpath = "//div[contains(@class,'template_5')] //span[@class='ytd1']")
	WebElement Template5RegularYtdTotal;
	@FindBy(xpath = "//div[contains(@class,'template_5')] //span[@class='ytd2']")
	WebElement Template5OverTimeYtdTotal;
	@FindBy(xpath = "//div[contains(@class,'template_5')] //span[@class='ytd3']")
	WebElement Template5HolidayYtdTotal;
	@FindBy(xpath = "//div[contains(@class,'template_5')] //span[@class='ytd4']")
	WebElement Template5VacationYtdTotal;
	@FindBy(xpath = "//div[contains(@class,'template_5')] //span[@class='ytd5']")
	WebElement Template5BonusYtdTotal;
	@FindBy(xpath = "//div[contains(@class,'template_5')] //span[@class='ytd6']")
	WebElement Template5FloatYtdTotal;
	@FindBy(xpath = "//div[contains(@class,'template_5')] //span[@class='ytd7']")
	WebElement Template5TipsYtdTotal;

	@FindBy(xpath = "//div[contains(@class,'template_5')] //span[@class='fica_medicare_total']")
	WebElement FicaMedicareTemplate5;
	@FindBy(xpath = "//div[contains(@class,'template_5')] //span[@class='fica_social_security_total']")
	WebElement fica_social_security_totalTemplate5;
	@FindBy(xpath = "//div[contains(@class,'template_5')] //span[@class='federal_tax_total']")
	WebElement Template5federal_tax_total;
	@FindBy(xpath = "//div[contains(@class,'template_5')] //span[@class='state_tax_total']")
	WebElement Template5state_tax_total;
	@FindBy(xpath = "//div[contains(@class,'template_5')] //span[@class='sdi_total']")
	WebElement Template5sdi_total;
	@FindBy(xpath = "//div[contains(@class,'template_5')] //span[@class='sui_total']")
	WebElement Template5sui_total;
	@FindBy(xpath = "//div[contains(@class,'template_5')] //span[@class='wc_total']")
	WebElement Template5wc_total;
	@FindBy(xpath = "//div[contains(@class,'template_5')] //span[@class='fli_total']")
	WebElement Template5fli_total;
	@FindBy(xpath = "//div[contains(@class,'template_5')] //span[@class='wf_total']")
	WebElement Template5wf_total;

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

	public String getTemplate5RegularTotal() throws InterruptedException {
		waitTillLoaderEnds();
		return Template5RegularTotal.getText();
	}

	public String getTemplate5OverTimeTotal() throws InterruptedException {
		waitTillLoaderEnds();
		// TODO Auto-generated method stub
		return Template5OverTimeTotal.getText();
	}

	public String getTemplate5HolidayTotal() throws InterruptedException {
		waitTillLoaderEnds();
		// TODO Auto-generated method stub
		return Template5HolidayTotal.getText();
	}

	public String getTemplate5VacationTotal() throws InterruptedException {
		waitTillLoaderEnds();
		// TODO Auto-generated method stub
		return Template5VacationTotal.getText();
	}

	public String getTemplate5BonusTotal() throws InterruptedException {
		waitTillLoaderEnds();
		// TODO Auto-generated method stub
		return Template5BonusTotal.getText();
	}

	public String getTemplate5FloatTotal() throws InterruptedException {
		waitTillLoaderEnds();
		// TODO Auto-generated method stub
		return Template5FloatTotal.getText();
	}

	public String getTemplate5TipsTotal() throws InterruptedException {
		waitTillLoaderEnds();
		// TODO Auto-generated method stub
		return Template5TipsTotal.getText();
	}

	public String getTemplate5RegularYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template5RegularYtdTotal.getText();
	}

	public String getTemplate5OverTimeYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template5OverTimeYtdTotal.getText();
	}

	public String getTemplate5HolidayYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template5HolidayYtdTotal.getText();
	}

	public String getTemplate5VacationYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template5VacationYtdTotal.getText();
	}

	public String getTemplate5BonusYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template5BonusYtdTotal.getText();
	}

	public String getTemplate5FloatYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template5FloatYtdTotal.getText();
	}

	public String getTemplate5TipsYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template5TipsYtdTotal.getText();
	}

	public String getFICAMedicareTemplate5() throws InterruptedException {
		waitTillLoaderEnds();
		return FicaMedicareTemplate5.getText();
	}

	public String getFicasocialSecurityTotalTemplate5() throws InterruptedException {
		waitTillLoaderEnds();
		return fica_social_security_totalTemplate5.getText();
	}

	public String getFederalTaxTotalTemplate5() throws InterruptedException {
		waitTillLoaderEnds();
		return Template5federal_tax_total.getText();
	}

	public String getStateTaxTotalTemplate5() throws InterruptedException {
		waitTillLoaderEnds();
		return Template5state_tax_total.getText();
	}

	public String getSDITaxTotalTemplate5() throws InterruptedException {
		waitTillLoaderEnds();
		return Template5sdi_total.getText();
	}

	public String getSUITaxTotalTemplate5() throws InterruptedException {
		waitTillLoaderEnds();
		return Template5sui_total.getText();
	}

	public String getWCTaxTotalTemplate5() throws InterruptedException {
		waitTillLoaderEnds();
		return Template5wc_total.getText();
	}

	public String getFLITaxTotalTemplate5() throws InterruptedException {
		waitTillLoaderEnds();
		return Template5fli_total.getText();
	}

	public String getTemplate5WorkForceDevTaxTotal() throws InterruptedException {
		waitTillLoaderEnds();
		return Template5wf_total.getText();
	}

	

}
