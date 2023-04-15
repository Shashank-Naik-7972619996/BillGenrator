package MobileApp.BillGenratorMobileApp2.PageObject.Android.W2Form;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import MobileApp.BillGenratorMobileApp2.PageObject.Android.OrderPage;
import MobileApp.BillGenratorMobileApp2.Utils.ReusableMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class W2FormStep6 extends ReusableMethods {
	AndroidDriver driver;

	public W2FormStep6(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}

	@AndroidFindBys({ @AndroidBy(xpath = "//*[@class='android.widget.EditText']") })
	private List<WebElement> TextFields;
	@AndroidFindBy(accessibility = "PRIVIOUS")
	private WebElement PRIVIOUS;
	@AndroidFindBy(accessibility = "PREVIEW")
	private WebElement PREVIEW;

	@AndroidFindBy(accessibility = "CHECKOUT")
	private WebElement CHECKOUT;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='your data save successfully']")
	private WebElement CheckoutSuccessMessage;

	public String getCheckoutSuccessMessage() {
		try {
//			WebElement successmessage = driver
//					.findElement(By.xpath("//android.view.View[@content-desc='your data save successfully']"));
			Expwait.until(ExpectedConditions.visibilityOf(CheckoutSuccessMessage));
			return CheckoutSuccessMessage.getAttribute("content-desc");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "No checkout success message";
		}

	}

	public OrderPage pressCheckoutButton() {
		
		OrderPage OrderPage = new OrderPage(driver);
		CHECKOUT.click();
		return OrderPage;
	}

	public void enterEmpStateID(String EmpStateID) {
		TextFields.get(0).click();
		TextFields.get(0).sendKeys(EmpStateID);
	}

	public void enterStateWagesTips(String StateWagesTips) {
		TextFields.get(1).click();
		TextFields.get(1).sendKeys(StateWagesTips);
	}

	public void enterStateincomeTax(String StateincomeTax) {
		TextFields.get(2).click();
		TextFields.get(2).sendKeys(StateincomeTax);
	}

	public void enterLocalWagesTips(String LocalWagesTips) {
		TextFields.get(3).click();
		TextFields.get(3).sendKeys(LocalWagesTips);
		driver.hideKeyboard();
	}

	public void enterLocalIncomeTax(String LocalIncomeTax) {
		TextFields.get(4).click();
		TextFields.get(3).sendKeys(LocalIncomeTax);
		driver.hideKeyboard();
	}

	public void enterLocalityName(String LocalityName) {
		TextFields.get(5).click();
		TextFields.get(2).sendKeys(LocalityName);
		driver.hideKeyboard();
	}

	public String getValueOfStateWagesTips() {
		String StateWage;
		TextFields.get(1).click();
		StateWage = TextFields.get(1).getText();
		return StateWage;
	}

	public String getValueOfStateincomeTax() {
		String StateIncomeTax;
		TextFields.get(2).click();
		StateIncomeTax = TextFields.get(2).getText();
		return StateIncomeTax;
	}

	public W2PreviewPage pressPREVIEW() {
		driver.hideKeyboard();
		PREVIEW.click();
		W2PreviewPage W2PreviewPage = new W2PreviewPage(driver);
		return W2PreviewPage;
	}
}
