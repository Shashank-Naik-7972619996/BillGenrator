package WebApp.BillGenratorWebApp.Paystub;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import MobileApp.BillGenratorMobileApp2.Utils.ReusableMethods;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class paystubTemplate6 extends ReusableMethods {

	public WebDriver browserdriver;

	public paystubTemplate6(WebDriver browserdriver) {
		super(browserdriver);
		this.browserdriver = browserdriver;
		PageFactory.initElements(browserdriver, this);
		//PageFactory.initElements(new AppiumFieldDecorator(browserdriver), this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "show_loader")
	WebElement show_loader;
	@FindBy(xpath = "//div[contains(@class,'template_6')] //span[@class='total1']")
	WebElement Template6RegularTotal;
	@FindBy(xpath = "//div[contains(@class,'template_6')] //span[@class='total2']")
	WebElement Template6OverTimeTotal;
	@FindBy(xpath = "//div[contains(@class,'template_6')] //span[@class='total3']")
	WebElement Template6HolidayTotal;
	@FindBy(xpath = "//div[contains(@class,'template_6')] //span[@class='total4']")
	WebElement Template6VacationTotal;
	@FindBy(xpath = "//div[contains(@class,'template_6')] //span[@class='total5']")
	WebElement Template6BonusTotal;
	@FindBy(xpath = "//div[contains(@class,'template_6')] //span[@class='total6']")
	WebElement Template6FloatTotal;
	@FindBy(xpath = "//div[contains(@class,'template_6')] //span[@class='total7']")
	WebElement Template6TipsTotal;

	@FindBy(xpath = "//div[contains(@class,'template_6')] //span[@class='ytd1']")
	WebElement Template6RegularYtdTotal;
	@FindBy(xpath = "//div[contains(@class,'template_6')] //span[@class='ytd2']")
	WebElement Template6OverTimeYtdTotal;
	@FindBy(xpath = "//div[contains(@class,'template_6')] //span[@class='ytd3']")
	WebElement Template6HolidayYtdTotal;
	@FindBy(xpath = "//div[contains(@class,'template_6')] //span[@class='ytd4']")
	WebElement Template6VacationYtdTotal;
	@FindBy(xpath = "//div[contains(@class,'template_6')] //span[@class='ytd5']")
	WebElement Template6BonusYtdTotal;
	@FindBy(xpath = "//div[contains(@class,'template_6')] //span[@class='ytd6']")
	WebElement Template6FloatYtdTotal;
	@FindBy(xpath = "//div[contains(@class,'template_6')] //span[@class='ytd7']")
	WebElement Template6TipsYtdTotal;

	@FindBy(xpath = "//div[contains(@class,'template_6')] //span[@class='fica_medicare_total']")
	WebElement FicaMedicareTemplate6;
	@FindBy(xpath = "//div[contains(@class,'template_6')] //span[@class='fica_social_security_total']")
	WebElement fica_social_security_totalTemplate6;
	@FindBy(xpath = "//div[contains(@class,'template_6')] //span[@class='federal_tax_total']")
	WebElement template6federal_tax_total;
	@FindBy(xpath = "//div[contains(@class,'template_6')] //span[@class='state_tax_total']")
	WebElement template6state_tax_total;
	@FindBy(xpath = "//div[contains(@class,'template_6')] //span[@class='sdi_total']")
	WebElement template6sdi_total;
	@FindBy(xpath = "//div[contains(@class,'template_6')] //span[@class='sui_total']")
	WebElement template6sui_total;
	@FindBy(xpath = "//div[contains(@class,'template_6')] //span[@class='wc_total']")
	WebElement template6wc_total;
	@FindBy(xpath = "//div[contains(@class,'template_6')] //span[@class='fli_total']")
	WebElement template6fli_total;
	@FindBy(xpath = "//div[contains(@class,'template_6')] //span[@class='wf_total']")
	WebElement template6wf_total;

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

	public String getTemplate6RegularTotal() throws InterruptedException {
		waitTillLoaderEnds();
		return Template6RegularTotal.getText();
	}

	public String getTemplate6OverTimeTotal() throws InterruptedException {
		waitTillLoaderEnds();
		// TODO Auto-generated method stub
		return Template6OverTimeTotal.getText();
	}

	public String getTemplate6HolidayTotal() throws InterruptedException {
		waitTillLoaderEnds();
		// TODO Auto-generated method stub
		return Template6HolidayTotal.getText();
	}

	public String getTemplate6VacationTotal() throws InterruptedException {
		waitTillLoaderEnds();
		// TODO Auto-generated method stub
		return Template6VacationTotal.getText();
	}

	public String getTemplate6BonusTotal() throws InterruptedException {
		waitTillLoaderEnds();
		// TODO Auto-generated method stub
		return Template6BonusTotal.getText();
	}

	public String getTemplate6FloatTotal() throws InterruptedException {
		waitTillLoaderEnds();
		// TODO Auto-generated method stub
		return Template6FloatTotal.getText();
	}

	public String getTemplate6TipsTotal() throws InterruptedException {
		waitTillLoaderEnds();
		// TODO Auto-generated method stub
		return Template6TipsTotal.getText();
	}

	public String getTemplate6RegularYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template6RegularYtdTotal.getText();
	}

	public String getTemplate6OverTimeYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template6OverTimeYtdTotal.getText();
	}

	public String getTemplate6HolidayYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template6HolidayYtdTotal.getText();
	}

	public String getTemplate6VacationYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template6VacationYtdTotal.getText();
	}

	public String getTemplate6BonusYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template6BonusYtdTotal.getText();
	}

	public String getTemplate6FloatYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template6FloatYtdTotal.getText();
	}

	public String getTemplate6TipsYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template6TipsYtdTotal.getText();
	}

	public String getFICAMedicareTemplate6() throws InterruptedException {

		waitTillLoaderEnds();
		return FicaMedicareTemplate6.getText();

	}

	public String getFicasocialSecurityTotalTemplate6() throws InterruptedException {
		waitTillLoaderEnds();
		return fica_social_security_totalTemplate6.getText();
	}

	public String getFederalTaxTotalTemplate6() throws InterruptedException {
		waitTillLoaderEnds();
		return template6federal_tax_total.getText();
	}

	public String getStateTaxTotalTemplate6() throws InterruptedException {
		waitTillLoaderEnds();
		return template6state_tax_total.getText();
	}

	public String getSDITaxTotalTemplate6() throws InterruptedException {
		waitTillLoaderEnds();
		return template6sdi_total.getText();
	}

	public String getSUITaxTotalTemplate6() throws InterruptedException {
		waitTillLoaderEnds();
		return template6sui_total.getText();
	}

	public String getWCTaxTotalTemplate6() throws InterruptedException {
		waitTillLoaderEnds();
		return template6wc_total.getText();
	}

	public String getFLITaxTotalTemplate6() throws InterruptedException {
		waitTillLoaderEnds();
		return template6fli_total.getText();
	}

	public String getTemplate6WorkForceDevTaxTotal() throws InterruptedException {
		waitTillLoaderEnds();
		return template6wf_total.getText();
	}
}
