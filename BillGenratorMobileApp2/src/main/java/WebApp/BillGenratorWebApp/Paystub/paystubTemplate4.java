package WebApp.BillGenratorWebApp.Paystub;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import MobileApp.BillGenratorMobileApp2.Utils.ReusableMethods;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class paystubTemplate4 extends ReusableMethods {

	public WebDriver browserdriver;

	public paystubTemplate4(WebDriver browserdriver) {
		super(browserdriver);
		this.browserdriver = browserdriver;
		PageFactory.initElements(browserdriver, this);
		//PageFactory.initElements(new AppiumFieldDecorator(browserdriver), this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "show_loader")
	WebElement show_loader;
	@FindBy(xpath = "//div[contains(@class,'template_4')] //span[@class='total1']")
	WebElement Template4RegularTotal;
	@FindBy(xpath = "//div[contains(@class,'template_4')] //span[@class='total2']")
	WebElement Template4OverTimeTotal;
	@FindBy(xpath = "//div[contains(@class,'template_4')] //span[@class='total3']")
	WebElement Template4HolidayTotal;
	@FindBy(xpath = "//div[contains(@class,'template_4')] //span[@class='total4']")
	WebElement Template4VacationTotal;
	@FindBy(xpath = "//div[contains(@class,'template_4')] //span[@class='total5']")
	WebElement Template4BonusTotal;
	@FindBy(xpath = "//div[contains(@class,'template_4')] //span[@class='total6']")
	WebElement Template4FloatTotal;
	@FindBy(xpath = "//div[contains(@class,'template_4')] //span[@class='total7']")
	WebElement Template4TipsTotal;

	@FindBy(xpath = "//div[contains(@class,'template_4')] //span[@class='ytd1']")
	WebElement Template4RegularYtdTotal;
	@FindBy(xpath = "//div[contains(@class,'template_4')] //span[@class='ytd2']")
	WebElement Template4OverTimeYtdTotal;
	@FindBy(xpath = "//div[contains(@class,'template_4')] //span[@class='ytd3']")
	WebElement Template4HolidayYtdTotal;
	@FindBy(xpath = "//div[contains(@class,'template_4')] //span[@class='ytd4']")
	WebElement Template4VacationYtdTotal;
	@FindBy(xpath = "//div[contains(@class,'template_4')] //span[@class='ytd5']")
	WebElement Template4BonusYtdTotal;
	@FindBy(xpath = "//div[contains(@class,'template_4')] //span[@class='ytd6']")
	WebElement Template4FloatYtdTotal;
	@FindBy(xpath = "//div[contains(@class,'template_4')] //span[@class='ytd7']")
	WebElement Template4TipsYtdTotal;

	@FindBy(xpath = "//div[contains(@class,'template_4')] //span[@class='fica_medicare_total']")
	WebElement FicaMedicareTemplate4;
	@FindBy(xpath = "//div[contains(@class,'template_4')] //span[@class='fica_social_security_total']")
	WebElement fica_social_security_totalTemplate4;
	@FindBy(xpath = "//div[contains(@class,'template_4')] //span[@class='federal_tax_total']")
	WebElement Template4federal_tax_total;
	@FindBy(xpath = "//div[contains(@class,'template_4')] //span[@class='state_tax_total']")
	WebElement Template4state_tax_total;
	@FindBy(xpath = "//div[contains(@class,'template_4')] //span[@class='sdi_total']")
	WebElement Template4sdi_total;
	@FindBy(xpath = "//div[contains(@class,'template_4')] //span[@class='sui_total']")
	WebElement Template4sui_total;
	@FindBy(xpath = "//div[contains(@class,'template_4')] //span[@class='wc_total']")
	WebElement Template4wc_total;
	@FindBy(xpath = "//div[contains(@class,'template_4')] //span[@class='fli_total']")
	WebElement Template4fli_total;
	@FindBy(xpath = "//div[contains(@class,'template_4')] //span[@class='wf_total']")
	WebElement Template4wf_total;

	public void waitTillLoaderEnds() throws InterruptedException {
		try {
			if (show_loader.getAttribute("style").contains("opacity")) {
				turnOnWaitOnBrowser();
				Expwait.until(ExpectedConditions.attributeToBe(show_loader, "style", "display: none;"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//waitTillLoaderEnds();
		}
		// Thread.sleep(3000l);
	}

	public String getTemplate4RegularTotal() throws InterruptedException {
		waitTillLoaderEnds();
		return Template4RegularTotal.getText();
	}

	public String getTemplate4OverTimeTotal() throws InterruptedException {
		waitTillLoaderEnds();
		// TODO Auto-generated method stub
		return Template4OverTimeTotal.getText();
	}

	public String getTemplate4HolidayTotal() throws InterruptedException {
		waitTillLoaderEnds();
		// TODO Auto-generated method stub
		return Template4HolidayTotal.getText();
	}

	public String getTemplate4VacationTotal() throws InterruptedException {
		waitTillLoaderEnds();
		// TODO Auto-generated method stub
		return Template4VacationTotal.getText();
	}

	public String getTemplate4BonusTotal() throws InterruptedException {
		waitTillLoaderEnds();
		// TODO Auto-generated method stub
		return Template4BonusTotal.getText();
	}

	public String getTemplate4FloatTotal() throws InterruptedException {
		waitTillLoaderEnds();
		// TODO Auto-generated method stub
		return Template4FloatTotal.getText();
	}

	public String getTemplate4TipsTotal() throws InterruptedException {
		waitTillLoaderEnds();
		// TODO Auto-generated method stub
		return Template4TipsTotal.getText();
	}

	public String getTemplate4RegularYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template4RegularYtdTotal.getText();
	}

	public String getTemplate4OverTimeYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template4OverTimeYtdTotal.getText();
	}

	public String getTemplate4HolidayYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template4HolidayYtdTotal.getText();
	}

	public String getTemplate4VacationYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template4VacationYtdTotal.getText();
	}

	public String getTemplate4BonusYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template4BonusYtdTotal.getText();
	}

	public String getTemplate4FloatYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template4FloatYtdTotal.getText();
	}

	public String getTemplate4TipsYTDTotal() throws InterruptedException {
		// TODO Auto-generated method stub
		waitTillLoaderEnds();
		return Template4TipsYtdTotal.getText();
	}

	public String getFICAMedicareTemplate4() throws InterruptedException {
		waitTillLoaderEnds();
		return FicaMedicareTemplate4.getText();
	}

	public String getFicasocialSecurityTotalTemplate4() throws InterruptedException {
		waitTillLoaderEnds();
		return fica_social_security_totalTemplate4.getText();
	}

	public String getFederalTaxTotalTemplate4() throws InterruptedException {
		waitTillLoaderEnds();
		return Template4federal_tax_total.getText();
	}

	public String getStateTaxTotalTemplate4() throws InterruptedException {
		waitTillLoaderEnds();
		return Template4state_tax_total.getText();
	}

	public String getSDITaxTotalTemplate4() throws InterruptedException {
		waitTillLoaderEnds();
		return Template4sdi_total.getText();
	}

	public String getSUITaxTotalTemplate4() throws InterruptedException {
		waitTillLoaderEnds();
		return Template4sui_total.getText();
	}

	public String getWCTaxTotalTemplate4() throws InterruptedException {
		waitTillLoaderEnds();
		return Template4wc_total.getText();
	}

	public String getFLITaxTotalTemplate4() throws InterruptedException {
		waitTillLoaderEnds();
		return Template4fli_total.getText();
	}

	public String getTemplate4WorkForceDevTaxTotal() throws InterruptedException {
		waitTillLoaderEnds();
		return Template4wf_total.getText();
	}
}
