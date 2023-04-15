package MobileApp.BillGenratorMobileApp2.PageObject.Android.InvoiceForm;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import MobileApp.BillGenratorMobileApp2.Utils.ReusableMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class InvoiceFormStep4 extends ReusableMethods {
	AndroidDriver driver;

	public InvoiceFormStep4(AndroidDriver driver) {
	super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}

	@AndroidFindBys({ @AndroidBy(className = "android.widget.ImageView") })
	private List<WebElement> SelectFields;
	
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'Tax Type')]")
	private WebElement TaxType;
	@AndroidFindBy(accessibility = "on total")
	private WebElement OnTotal;
	@AndroidFindBy(xpath = "//android.view.View/android.view.View[@content-desc='deducted']")
	private WebElement deducted;
	@AndroidFindBy(accessibility = "per item")
	private WebElement perItem;
	@AndroidFindBy(accessibility = "none")
	private WebElement none;
	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'Tax Type')]/following-sibling::android.widget.EditText")
	private WebElement taxRate;
	
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'Discount Type')]")
	private WebElement DiscountType;
	
	@AndroidFindBy(accessibility = "percent")
	private WebElement percent;
	@AndroidFindBy(accessibility = "float amount")
	private WebElement floatamount;
	@AndroidFindBy(xpath = "//*[contains(@text,'Discount Rate')]")
	private WebElement DiscountRate;
	@AndroidFindBy(accessibility = "NEXT")
	private WebElement NEXT;

	public String selectTaxType(String taxType) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		TaxType.click();
		if (taxType.contains("on total")) {
			OnTotal.click();
			return taxType;
		} else if (taxType.contains("deducted")) {
			deducted.click();
			return taxType;
		} else if (taxType.contains("per item")) {
			perItem.click();
			return taxType;
		} else if (taxType.contains("none")) {
			none.click();
			return taxType;
		}
		return taxType;
	}

	public Double EnterTaxRate(String TaxRate) {
		taxRate.click();
		//sendKeysWithNumKeyboard(TaxRate);
		taxRate.sendKeys(TaxRate);
		Double taxrateValue = Double.parseDouble(TaxRate);
		return taxrateValue;

	}

	public void selectDiscountType(String discounttype) {
		DiscountType.click();
		if (discounttype.contains("percent")) {
			percent.click();
		} else if (discounttype.contains("float amount")) {
			floatamount.click();
		} else if (discounttype.contains("none")) {
			none.click();
		}
	}

	public Double enterDiscountRate(String discountrate) {
		DiscountRate.click();
		//sendKeysWithNumKeyboard(discountrate);
		DiscountRate.sendKeys(discountrate);
		Double discountrateValue = Double.parseDouble(discountrate);
		return discountrateValue;
	}

	public InvoiceFormStep5 pressNEXT() {
		NEXT.click();
		InvoiceFormStep5 InvoiceFormStep5 = new InvoiceFormStep5(driver);
		return InvoiceFormStep5;
	}
}
