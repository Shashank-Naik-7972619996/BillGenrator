package MobileApp.BillGenratorMobileApp2.PageObject.Android.W2Form;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import MobileApp.BillGenratorMobileApp2.Utils.ReusableMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class W2FormStep4 extends ReusableMethods {
	AndroidDriver driver;

	public W2FormStep4(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}
	@AndroidFindBy(accessibility = "NEXT")
	private WebElement NEXT;
	@AndroidFindBy(accessibility = "PRIVIOUS")
	private WebElement PRIVIOUS;
	@AndroidFindBys({@AndroidBy(className = "android.widget.EditText")})
	private List<WebElement> TextFields;
	
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'State')]//following-sibling::android.widget.EditText")
	private WebElement Zip;
	@AndroidFindBy(accessibility = "State*")
	private WebElement State;
	
	public void enterEmpName(String EmpName)
	{
		TextFields.get(0).click();
		TextFields.get(0).sendKeys(EmpName);
	}
	public void enterEmpAdd(String EmpAdd)
	{
		TextFields.get(1).click();
		TextFields.get(1).sendKeys(EmpAdd);
	}
	public void enterEmpCity(String EmpCity)
	{
		TextFields.get(2).click();
		TextFields.get(2).sendKeys(EmpCity);
	}
	public void enterEmpZip(String EmpZip)
	{
		Zip.click();
		Zip.sendKeys(EmpZip);
	}
	public void selectState(String state) throws Exception
	{
		State.click();
		scrollDownTillElement("//android.view.View[@content-desc=\""+state+"\"]");
	}
	public W2FormStep5 pressNEXT() {
		NEXT.click();
		W2FormStep5 W2FormStep5 = new W2FormStep5(driver);
		
		return W2FormStep5;
	}
	public void pressPRIVIOUS() {
		PRIVIOUS.click();
	}
	
	
}
