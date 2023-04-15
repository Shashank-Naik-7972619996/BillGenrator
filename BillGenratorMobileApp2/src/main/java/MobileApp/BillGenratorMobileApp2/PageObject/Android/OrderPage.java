package MobileApp.BillGenratorMobileApp2.PageObject.Android;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;

import MobileApp.BillGenratorMobileApp2.Utils.ReusableMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OrderPage extends ReusableMethods {

	AndroidDriver driver;

	public OrderPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//*[contains(@content-desc,'/')]")
	private WebElement OrderDate;
	@AndroidFindBy(xpath = "//*[@class='android.widget.ScrollView']/android.view.View[6]")
	private WebElement BillType;
	@AndroidFindBy(xpath = "//*[@class='android.widget.ScrollView']/android.view.View[10]")
	private WebElement Amount;
	@AndroidFindBy(xpath = "//*[@content-desc='Total Amount:']/following-sibling::android.view.View[1]")
	private WebElement TotalAmount;
	@AndroidFindBy(xpath = "//*[@class='android.widget.EditText']")
	private WebElement CouponCodeTextBox;
	@AndroidFindBy(xpath = "//*[@content-desc='Apply']")
	private WebElement ApplyCouponButton;
	@AndroidFindBy(xpath = "//*[@content-desc='Pay With Crypto']")
	private WebElement PressPayWithCryptoButton;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Complete Checkout']")
	private WebElement PressCompleteCheckout;
	@AndroidFindBy(xpath = "//android.view.View[@content-desc='your data save successfully']")
	private WebElement CheckoutSuccessMessage;

	@AndroidFindBy(xpath = "(//android.view.View[@content-desc='Order Summary'])[2]/following-sibling::android.view.View[2]")
	private WebElement CheckoutTextButton;
	@AndroidFindBy(xpath = "//*[@content-desc='Shipping:']/following-sibling::android.view.View[1]")
	private WebElement ShippingAmount;

	public String getShippingAmount() {
		return ShippingAmount.getAttribute("content-desc");
	}

	public String getDateOfOrderPlaced() {
		turnOnwaitForAndroid();
		Expwait.until(ExpectedConditions.visibilityOf(OrderDate));
		return OrderDate.getAttribute("content-desc");
	}

	public String getBillType() {
		return BillType.getAttribute("content-desc");
	}

	public String getAmountValue() {
		return Amount.getAttribute("content-desc");
	}

	public String getTotalAmount() {
		return TotalAmount.getAttribute("content-desc");
	}

	public String getTextOnCheckoutPayButton() {
		return CheckoutTextButton.getAttribute("content-desc");
	}

	public void enterCoupenCode(String couponcode) {
		CouponCodeTextBox.click();
		CouponCodeTextBox.sendKeys(couponcode);
		driver.hideKeyboard();
	}

	public int pressApplyCouponButton() {
		int nos_calls = 0;
		ScrolltillEndofPage();
		ApplyCouponButton.click();
		return nos_calls;
	}

	public void pressPressPayWithCryptoButton() {
		PressPayWithCryptoButton.click();
	}

	public ThankYouPage pressPressCompleteCheckout() {
		try {

			PressCompleteCheckout.click();
			ThankYouPage thankyoupage = new ThankYouPage(driver);
			return thankyoupage;
		} catch (NoSuchElementException e) {
			throw new SkipException("Skipping this Test because 'complete checkout' button not available. ");
		}
	}

	public ThankYouPage pressPressPayWithCryptoButtonInvoice() {
		PressPayWithCryptoButton.click();
		ThankYouPage thankyoupage = new ThankYouPage(driver);
		return thankyoupage;
	}

	public String gettodaysdate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		System.out.println("Today date is: " + dtf.format(now));
		return dtf.format(now);
	}

	public String getCheckoutSuccessMessage() {

		try {
//			turnOnwaitonthisclass();
			WebElement CheckoutSuccessMessage1 = driver
					.findElement(By.xpath("//android.view.View[@content-desc='your data save successfully']"));
			Expwait.until(ExpectedConditions.visibilityOf(CheckoutSuccessMessage1));
			return CheckoutSuccessMessage1.getAttribute("content-desc");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "No checkout success message";
		}
	}
}
