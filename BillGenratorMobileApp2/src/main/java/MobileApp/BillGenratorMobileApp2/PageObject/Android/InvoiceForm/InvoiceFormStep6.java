package MobileApp.BillGenratorMobileApp2.PageObject.Android.InvoiceForm;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import MobileApp.BillGenratorMobileApp2.PageObject.Android.OrderPage;
import MobileApp.BillGenratorMobileApp2.Utils.ReusableMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class InvoiceFormStep6 extends ReusableMethods {
	AndroidDriver driver;

	public InvoiceFormStep6(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}

	@AndroidFindBys({ @AndroidBy(xpath = "//*[@content-desc= 'Subtotal']/../android.view.View") })
	private List<WebElement> AllData;

	@AndroidFindBy(xpath = "//*[contains(@text, 'Notes')]")
	private WebElement EnterNotes;
	@AndroidFindBy(xpath = "//android.view.View[@content-desc='CHECKOUT']")
	private WebElement pressCheckout;
	@AndroidFindBy(accessibility = "PRIVIOUS")
	private WebElement pressPrevious;

	@AndroidFindBy(accessibility = "PREVIEW")
	private WebElement pressPREVIEW;

	public InvoiceFormStep5 pressPrevious() {
		pressPrevious.click();
		InvoiceFormStep5 InvoiceFormStep5 = new InvoiceFormStep5(driver);
		return InvoiceFormStep5;
	}

	public String findvalueof(String findvalueof) {
		String value;
		for (int i = 0; i < AllData.size(); i++) {
			if (AllData.get(i).getAttribute("content-desc").contains(findvalueof)) {
				i = i + 1;
				value = AllData.get(i).getAttribute("content-desc");
				return value;
			}
		}
		return null;
	}

	public Double getSubTotal() {
		String subtotal = AllData.get(1).getAttribute("content-desc").replace("$", "").trim();
		System.out.println(subtotal);
		// need to saperate the $
		Double subtotalvalue = Double.parseDouble(subtotal);
		return subtotalvalue;
	}

	public Double getDiscount() {
		String discountvalueInString = findvalueof("Discount");
		discountvalueInString.replace("$", "");
		discountvalueInString.replace("-", "");
		discountvalueInString.trim();
		// need to saperate the $
		Double discountValue = Double.parseDouble(discountvalueInString);
		return discountValue;
	}

	public Double getTax() {
		String taxValueInString = findvalueof("Tax").replace("$ - ", "").trim();
		// need to saperate the $
		Double discountValue = Double.parseDouble(taxValueInString);
		return discountValue;
	}

	public String getTextOfTax() {
		String taxValueInString = findvalueof("Tax");
		return taxValueInString;
	}

	public Double getTotal() {
		String totalValueInString = findvalueof("Total").replace("$ ", "").trim();

		// need to saperate the $
		Double discountValue = Double.parseDouble(totalValueInString);
		return discountValue;
	}

	public Double getBalanceDue() {
		String BalanceDueValueInString = findvalueof("Balance").replace("$ ", "").trim();

		// need to saperate the $
		Double discountValue = Double.parseDouble(BalanceDueValueInString);
		return discountValue;
	}

	public String enterNote(String notesToEnter) {
		EnterNotes.click();
		//sendKeysWithCharKeyboard(notesToEnter);
		EnterNotes.sendKeys(notesToEnter);
		return notesToEnter;
	}

	public OrderPage pressCheckout() {
		driver.hideKeyboard();
		pressCheckout.click();
		OrderPage OrderPage = new OrderPage(driver);
		return OrderPage;
	}

	public InvoicePreviewPage pressPreviewButton() {
		pressPREVIEW.click();
		InvoicePreviewPage InvoicePreviewPage = new InvoicePreviewPage(driver);
		return InvoicePreviewPage;
	}
}
