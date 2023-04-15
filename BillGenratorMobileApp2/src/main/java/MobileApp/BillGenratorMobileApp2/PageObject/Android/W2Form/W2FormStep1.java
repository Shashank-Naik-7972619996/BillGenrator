package MobileApp.BillGenratorMobileApp2.PageObject.Android.W2Form;

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

public class W2FormStep1 extends ReusableMethods {
	AndroidDriver driver;

	public W2FormStep1(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}

	@AndroidFindBys({ @AndroidBy(className = "android.widget.ImageView") })
	private List<WebElement> SelectFields;

	@AndroidFindBys({ @AndroidBy(className = "android.view.View") })
	private List<WebElement> SelectOptions;

	@AndroidFindBy(accessibility = "Auto Calculator on")
	private WebElement AutoCalculator;
	@AndroidFindBy(accessibility = "on")
	private WebElement AutoCalculatorOn;
	@AndroidFindBy(accessibility = "off")
	private WebElement AutoCalculatorOff;
	@AndroidFindBy(accessibility = "single")
	private WebElement Marital_StatusSingle;
	@AndroidFindBy(accessibility = "married")
	private WebElement Marital_StatusMarried;
	@AndroidFindBy(xpath = "//*[@text='How Much Did You Make before Taxes Last Year?']")
	private WebElement How_Much_Did_You_Make_before_Taxes_Last_Year;
	@AndroidFindBy(accessibility = "NEXT")
	private WebElement NEXT;

	public WebElement selectfield(String SelectorName) {
		for (int i = 0; i < SelectFields.size(); i++) {
			if (SelectFields.get(i).getAttribute("content-desc").contains(SelectorName)) {
				return SelectFields.get(i);
			}
		}
		return null;
	}

//	public WebElement selectFromBigList(String Requiredvalue) {
////		WebElement RequiredElement= driver.findElement(By.xpath("//android.view.View[@content-desc=\""+Requiredvalue+"\"]"));
////		scrollToElement(driver, RequiredElement);
////		Scrolluntil(Requiredvalue);
////		for (int i = 0; i < SelectOptions.size(); i++) {
////			// System.out.println("Year = "+
////			// SelectOptions.get(i).getAttribute("content-desc"));
////			if (SelectOptions.get(i).getAttribute("content-desc").equals(Requiredvalue)) {
////				return SelectOptions.get(i);
////			}
////		}
////		return null;
//	}

	public WebElement selectExemptionList(String exemp) {
		for (int i = 0; i < SelectOptions.size(); i++) {
			if (SelectOptions.get(i).getAttribute("content-desc").equals(exemp)) {
				return SelectOptions.get(i);
			}
		}
		return null;
	}

	public void selectAutoCalculatorON() {
		selectfield("Auto Calculator").click();
		AutoCalculatorOn.click();
	}

	public void selectAutoCalculatorOff() {
		selectfield("Auto Calculator").click();
		AutoCalculatorOff.click();
	}

	public void selectWhatYear(String selectYear) throws Exception {
		selectfield("What Year?").click();
		scrollDownTillElement("//android.view.View[@content-desc=\""+selectYear+"\"]");
	}

	public void selectMarital_StatusSingle() {
		selectfield("Marital Status").click();
		Marital_StatusSingle.click();
	}

	public void selectMarital_StatusMarried() {
		selectfield("Marital Status").click();
		Marital_StatusMarried.click();
	}

	public void selectExemption(String exemption) {
		selectfield("Exemptions?").click();
		selectExemptionList(exemption).click();
	}

	public void selectState(String state) throws Exception {
		selectfield("Your state*").click();
		
		scrollDownTillElement("//android.view.View[@content-desc=\""+state+"\"]");
		
		// Scrolluntil(state).click();
	}

	public void enterHow_Much_Did_You_Make_before_Taxes_Last_Year(String value) {
		How_Much_Did_You_Make_before_Taxes_Last_Year.click();
		How_Much_Did_You_Make_before_Taxes_Last_Year.sendKeys(value);
	}

	public W2FormStep2 pressNEXT() {
		NEXT.click();
		W2FormStep2 W2FormStep2 = new W2FormStep2(driver);
		return W2FormStep2;
	}

}
