package MobileApp.BillGenratorMobileApp2.PageObject.Android.InvoiceForm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import MobileApp.BillGenratorMobileApp2.Utils.ReusableMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class InvoicePreviewPage extends ReusableMethods {
	AndroidDriver driver;

	public InvoicePreviewPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBys({ @AndroidBy(xpath = "//*[@class= 'android.widget.TextView']") })
	private List<WebElement> AllPreviewData;

	@AndroidFindBy(xpath = "(//android.view.View/android.view.View/android.view.View/android.view.View)[1]")
	private WebElement BackButton;
	
	
	@AndroidFindBy(xpath = "(//android.view.View[@resource-id='check-preview']/android.view.View/android.view.View/android.view.View/android.view.View)[1]")
	private WebElement InvoiceTitle;
	
	//android.view.View[@resource-id='check-preview']/android.view.View[3]
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='check-preview']/android.view.View[3]")
	private WebElement FromName;
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='check-preview']/android.view.View[4]")
	private WebElement FromEmail;
	
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='check-preview']/android.view.View[5]")
	private WebElement FromAddCityStateZip;
	
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='check-preview']/android.view.View[6]")
	private WebElement FromPhoneNumber;
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='check-preview']/android.view.View[7]")
	private WebElement FromBusinessNumber;
	
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='check-preview']/android.view.View[9]")
	private WebElement ToName;
	
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='check-preview']/android.view.View[10]")
	private WebElement ToEmail;
	
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='check-preview']/android.view.View[11]")
	private WebElement ToAddressCityStateZip;
	
	
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='check-preview']/android.view.View[12]")
	private WebElement ToPhone;
	@AndroidFindBys({
			@AndroidBy(xpath = "//android.widget.GridView/android.view.View/android.view.View/android.widget.TextView") })
	private List<WebElement> ItemData;
	@AndroidFindBy(xpath = "//android.view.View[@text='Subtotal']/following-sibling::android.view.View")
	private WebElement SubTotalValue;
	@AndroidFindBy(xpath = "//android.view.View[contains(@text,'Tax')]/following-sibling::android.view.View")
	private WebElement TaxValue;
	@AndroidFindBy(xpath = "//android.view.View[contains(@text,'Total')]/following-sibling::android.view.View")
	private WebElement TotalValue;
	@AndroidFindBy(xpath = "//android.view.View[contains(@text,'Balance Due')]/following-sibling::android.view.View")
	private WebElement BalanceValue;
	@AndroidFindBy(xpath = "//android.view.View[contains(@text,'Notes - ')]")
	private WebElement NoteText;
	@AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'logo')]")
	private WebElement Logo;
	@AndroidFindBy(xpath = "//android.view.View[@text='Date:']/following-sibling::android.view.View[1]")
	private WebElement InvoiceDate;
	@AndroidFindBy(xpath = "(//android.view.View[@text='Number:']/following-sibling::android.view.View)[1]")
	private WebElement InvoiceNumber;
	@AndroidFindBys({
		@AndroidBy(xpath = "//android.view.View[@text='Description']/../following-sibling::android.view.View/android.view.View[1]/android.widget.TextView[1]") })
	private List<WebElement> ItemNames;
	@AndroidFindBys({
		@AndroidBy(xpath = "//android.view.View[@text='Description']/../following-sibling::android.view.View/android.view.View[1]/android.widget.TextView[2]") })
	private List<WebElement> ItemDescriptions;
	@AndroidFindBys({
		@AndroidBy(xpath = "//android.view.View[@text='Rate']/../following-sibling::android.view.View/android.view.View[2]") })
	private List<WebElement> ItemRates;
	@AndroidFindBys({
		@AndroidBy(xpath = "//android.view.View[@text='Qty']/../following-sibling::android.view.View/android.view.View[3]") })
	private List<WebElement> ItemsQuantity;
	@AndroidFindBys({
		@AndroidBy(xpath = "//android.view.View[@text='Amount']/../following-sibling::android.view.View/android.view.View[4]") })
	private List<WebElement> ItemsAmount;
	
	
	
	
	
	public boolean VerifyLogoIsPresent()
	{
		return Logo.isDisplayed();
	}

	public String getInvoiceTitle() {
		turnOnwaitForAndroid();
		Expwait.until(ExpectedConditions
				.visibilityOf(InvoiceTitle));
		return InvoiceTitle.getText();
	}

	public String getFromName() {
		return FromName.getText();
	}

	public String getFromEmail() {
		return FromEmail.getText();
	}

	public String getFromAddressCityStateZip() {
		System.out.println(FromAddCityStateZip.getText());
		return FromAddCityStateZip.getText();
	}

	public String getFromPhoneNumber() {
		return FromPhoneNumber.getText();
	}

	public String getFromBusinessNumber() {
		return FromBusinessNumber.getText();
	}

	public String getToName() {
		return ToName.getText();
	}

	public String getToEmail() {
		return ToEmail.getText();
	}

	public String getToAddressCityStateZip() {
		System.out.println(ToAddressCityStateZip.getText());
		return ToAddressCityStateZip.getText();
	}

	public String getToPhone() {
		return ToPhone.getText();
	}

	public String getInvoiceNo() {
		return InvoiceNumber.getText();
	}

	public String getInvoiceDate() {
		System.out.println(InvoiceDate.getText());
		return InvoiceDate.getText();
	}

	public String getItemData(int ItemData1) {
		if (ItemData1 <= ItemData.size()) {
			//for (ItemData1 = 0; ItemData1 < ItemData.size(); ItemData1++) {
				return ItemData.get(ItemData1).getText();
			//}
		}
		return "No Item present in preview page for" + ItemData1 + "position";
	}
	
	public String getSubTotalValue()
	{
		return SubTotalValue.getText().replace("$","").trim();
	}
	public String getTaxValue()
	{
		return TaxValue.getText().replace("$","").trim();
	}
	public String getTotalValue()
	{
		return TotalValue.getText().replace("$","").trim();
	}
	public String getBalanceValue()
	{
		return BalanceValue.getText().replace("$","").trim();
	}
	public String getNoteText()
	{
		//Notes - Testing note for testing purpose only etc
		return NoteText.getText().substring(0, 8);
	}
	public String getShortCutOfState(String stateSelected)
	{
		return getShortState(stateSelected);
	}
	public String getItemName(int ItemNo)
	{
		return ItemNames.get(ItemNo-1).getText();
	}
	public String getItemDescription(int ItemNo)
	{
		return ItemDescriptions.get(ItemNo-1).getText();
	}
	public String getItemRates(int ItemNo)
	{
		return ItemRates.get(ItemNo-1).getText();
	}
	public String getItemsQuantity(int ItemNo)
	{
		return ItemsQuantity.get(ItemNo-1).getText();
	}
	public String getItemsAmount(int ItemNo)
	{
		return ItemsAmount.get(ItemNo-1).getText();
	}
	
}