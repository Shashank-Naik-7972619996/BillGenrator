package MobileApp.BillGenratorMobileApp2.PageObject.Android.InvoiceForm;

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

public class InvoiceFormStep5 extends ReusableMethods {
	AndroidDriver driver;

	public InvoiceFormStep5(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}

	@AndroidFindBys({ @AndroidBy(xpath = "//android.view.View[contains(@content-desc, 'TAX')]") })
	private List<WebElement> ItemsWithAllDetals;
	@AndroidFindBys({
			@AndroidBy(xpath = "//android.view.View[contains(@content-desc, 'AMOUNT')]/android.widget.EditText[contains(@text,'Item Description*')]") })
	private List<WebElement> ItemsDescription;
	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'AMOUNT')]/android.widget.EditText[contains(@text,'Item Description*')]")
	private WebElement ItemsDescription1;

	@AndroidFindBys({
			@AndroidBy(xpath = "//android.view.View[contains(@content-desc, 'AMOUNT')]/android.widget.EditText[contains(@text,'Additional details')]") })
	private List<WebElement> AdditionalDetails;
	@AndroidFindBys({
			@AndroidBy(xpath = "//android.view.View[contains(@content-desc, 'AMOUNT')]/android.widget.EditText[contains(@text,'Rate*')]") })
	private List<WebElement> ItemRates;
	@AndroidFindBys({
			@AndroidBy(xpath = "//android.view.View[contains(@content-desc, 'AMOUNT')]/android.widget.EditText[contains(@text,'QTY*')]") })
	private List<WebElement> ItemQty;
	@AndroidFindBys({
			@AndroidBy(xpath = "//android.view.View[contains(@content-desc, 'AMOUNT')]/android.widget.EditText[contains(@text,'ITEM TAX')]") })
	private List<WebElement> ItemTax;
	@AndroidFindBys({ @AndroidBy(xpath = "//*[contains(@text, 'QTY*')]/following-sibling::android.view.View") })
	private List<WebElement> taxCheckbox;
	@AndroidFindBy(accessibility = "NEXT")
	private WebElement NEXT;
	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'AMOUNT')]")
	private WebElement SingleItemAmount;
	@AndroidFindBy(xpath = "//*[contains(@text, 'Item Description*')]/../../../following-sibling::android.view.View")
	private WebElement pressPlusButton;
	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'AMOUNT')]/following-sibling::android.widget.ImageView")
	private WebElement pressRemoveItem;

	@AndroidFindBys({ @AndroidBy(xpath = "//android.view.View[contains(@content-desc,'TAX')]/../android.view.View") })
	private List<WebElement> ItemData;

	static int noOfCall = 0;

	public void enterItemDesc(int itemno, String itemname) throws Exception {
		++noOfCall;
		if (itemno != 1) {
			// Scrolluntil(ItemsDescription.get(itemno).getText());
			scrollDownTillWebElement(pressPlusButton);
		}
		itemno = 0;
		ItemsDescription.get(itemno).click();
		//sendKeysWithCharKeyboard(itemname);
		ItemsDescription.get(itemno).sendKeys(itemname);
		driver.hideKeyboard();

	}

	public int getItemCountAdded() {
		System.out.println("No of Items added: " + noOfCall);
		return noOfCall;
	}

	public void enterAdditionalDetails(int itemno, String additionalDetails) throws Exception {
		if (itemno != 1) {
			scrollDownTillWebElement(pressPlusButton);
			// Scrolluntil(AdditionalDetails.get(itemno).getText());
		}
		itemno = 0;
		AdditionalDetails.get(itemno).click();
		//sendKeysWithCharKeyboard(additionalDetails);
		AdditionalDetails.get(itemno).sendKeys(additionalDetails);
		driver.hideKeyboard();
	}

	public Double enterItemRates(int itemno, String rate) throws Exception {
		if (itemno != 1) {
			// Scrolluntil(ItemRates.get(itemno).getText());
			scrollDownTillWebElement(pressPlusButton);
			// scrollDownTillWebElement(ItemRates.get(itemno));
			// scrollDownTillElement()
		}
		itemno = 0;
		ItemRates.get(itemno).click();
		//sendKeysWithNumKeyboard(rate);
		ItemRates.get(itemno).sendKeys(rate);
		driver.hideKeyboard();
		Double rate1 = Double.parseDouble(rate);
		return rate1;
	}

	public Double enterItemquantity(int itemno, String qty) throws Exception {
		if (itemno != 1) {
			scrollDownTillWebElement(pressPlusButton);
			// Scrolluntil(ItemQty.get(itemno).getText());
		}
		itemno = 0;
		ItemQty.get(itemno).click();
		//sendKeysWithNumKeyboard(qty);
		ItemQty.get(itemno).sendKeys(qty);
		driver.hideKeyboard();
		Double qty1 = Double.parseDouble(qty);
		return qty1;
	}

	public void enterItemtax(int itemno, String Itemtax) throws Exception {
		driver.hideKeyboard();
		if (itemno != 1) {
			scrollDownTillWebElement(pressPlusButton);
			// Scrolluntil(ItemTax.get(itemno).getText());
		}
		itemno = 0;
		ItemTax.get(itemno).click();
		//sendKeysWithNumKeyboard(Itemtax);
		ItemTax.get(itemno).sendKeys(Itemtax);
		driver.hideKeyboard();
	}

	public void checkTaxCheckBox(int itemno) throws Exception {
		driver.hideKeyboard();
		if (itemno != 1) {
			scrollDownTillWebElement(pressPlusButton);
			// Scrolluntil(taxCheckbox.get(itemno).getText());
		}
		itemno = 0;
		taxCheckbox.get(itemno).click();
	}

	public void pressPlusButton() throws Exception {
		driver.hideKeyboard();
		WebElement pressPlusButton1 = scrollDownTillWebElement(pressPlusButton);
		pressPlusButton1.click();
	}

	public InvoiceFormStep6 pressNEXT() {
		driver.hideKeyboard();
		NEXT.click();
		InvoiceFormStep6 InvoiceFormStep6 = new InvoiceFormStep6(driver);
		return InvoiceFormStep6;
	}

	public Double getSingleItemAmount() {
		String amount = SingleItemAmount.getAttribute("content-desc").replace("TAX", "").replace("AMOUNT", "").trim();
		System.out.println("Total Amount for single item: " + amount);
		Double amountInDouble = Double.parseDouble(amount);
		return amountInDouble;
	}

	public void pressRemoveItem(String ItemDescription) throws Exception {
		String ItemDesc = "//android.widget.EditText[contains(@text,'" + ItemDescription
				+ "')]/following-sibling::android.widget.EditText[contains(@text,'Additional details')]";

		scrollDownTillElementWithoutClick(ItemDesc);
		driver.findElement(By.xpath("" + ItemDesc + "/../../android.widget.ImageView")).click();

	}
//	public WebElement getElementContainingText(String ItemDescription)
//	{
//		WebElement ele=driver.findElement(By.xpath("//android.widget.EditText[contains(@text,'"+ItemDescription+"')]"));
//		//android.view.View[contains(@content-desc, 'AMOUNT')]
//		return ele;
//	}
//	public Double calculateTotalAmountForOneItem(Double rate, Double qty)
//	{
//		Double totalamount = rate * qty;
//		return totalamount;
//	}
//	public Double calculateTotalAmountForAllItems()
//	{
//		Double TotalAmountForAllItem = 
//		return null;
//	}
}
