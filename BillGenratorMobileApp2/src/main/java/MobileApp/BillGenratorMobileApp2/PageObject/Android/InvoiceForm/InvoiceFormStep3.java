package MobileApp.BillGenratorMobileApp2.PageObject.Android.InvoiceForm;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import MobileApp.BillGenratorMobileApp2.Utils.ReusableMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class InvoiceFormStep3 extends ReusableMethods {
	AndroidDriver driver;

	public InvoiceFormStep3(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}
	
	@AndroidFindBys({ @AndroidBy(xpath = "//*[contains(@class,'android.widget.EditText')]") })
	private List<WebElement> TextFields;
	
	
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Number')]")
	private WebElement InvoiceNumber;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Date')]")
	private WebElement InvoiceDate;
	
	
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Due')]")
	private WebElement InvoiceDueDate;
	
	@AndroidFindBy(xpath = "//*[contains(@content-desc,'Terms')]")
	private WebElement Terms;
	@AndroidFindBy(accessibility = "Switch to input")
	private WebElement switchtoInput;
	@AndroidFindBy(className = "android.widget.EditText")
	private WebElement datefield;
	@AndroidFindBy(accessibility = "OK")
	private WebElement OK;
	@AndroidFindBy(xpath = "//*[contains(@text,'Discount Rate')]")
	private WebElement DiscountRate;
	@AndroidFindBy(accessibility = "NEXT")
	private WebElement NEXT;
	
	
	
	public void enterEnvoiceNumber(String envno)
	{
		InvoiceNumber.click();
		InvoiceNumber.clear();
		//sendKeysWithCharKeyboard(envno);
		InvoiceNumber.sendKeys(envno);
	}
	
	public void selectDate(String date)
	{
		InvoiceDate.click();
		switchtoInput.click();
		datefield.clear();
		//sendKeysWithNumKeyboard(date);
		datefield.sendKeys(date);
		OK.click();
	}
	public String getDate()
	{
		String datetext = InvoiceDate.getText().replace(", Date","");
		System.out.println("Date mentioned: "+datetext);
		return datetext;
	}
	
	public void selectTerms(String termtoselect)
	{
		Terms.click();
		Scrolluntil(termtoselect).click();
	}
	
	public void selectDueDate(String DueDate)
	{
		InvoiceDueDate.click();
		switchtoInput.click();
		datefield.clear();
		//sendKeysWithNumKeyboard(DueDate);
		datefield.sendKeys(DueDate);
		OK.click();
	}
	public InvoiceFormStep4 pressNEXT() {
		NEXT.click();
		InvoiceFormStep4 InvoiceFormStep4 = new InvoiceFormStep4(driver);
		return InvoiceFormStep4;
	}
	public String verifyTodaysDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM d, yyyy");
		LocalDateTime now = LocalDateTime.now();
		System.out.println("Today date is: " + dtf.format(now));
		return dtf.format(now);
	}
}
