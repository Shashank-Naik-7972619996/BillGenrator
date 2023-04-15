package MobileApp.BillGenratorMobileApp2.PageObject.Android.UtilityForm;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import MobileApp.BillGenratorMobileApp2.Utils.ReusableMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class UtilityFormStep2 extends ReusableMethods{

AndroidDriver driver;
	
	public UtilityFormStep2(AndroidDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBys({@AndroidBy(className = "android.widget.EditText")})
	private List<WebElement> TextFields;
	@AndroidFindBy(xpath="//android.view.View[4]/android.widget.EditText[1]")
	private WebElement companyname1;
	@AndroidFindBy(accessibility="Your State*")
	private WebElement YourState;
	@AndroidFindBy(accessibility="Delaware")
	private WebElement Delaware;
	@AndroidFindBy(accessibility = "NEXT")
	private WebElement NEXTButton;
	
	
	public void enterCompanyName(String companyname)
	{
		
		companyname1.click();
		driver.hideKeyboard();
		companyname1.sendKeys(companyname);
		//TextFields.get(0).click();
		
		
	}
	public void enterCompanyStreetAddress(String CompanyStreetAddress)
	{
		TextFields.get(1).click();
		TextFields.get(1).sendKeys(CompanyStreetAddress);
	}
	public void enterCompanyCity(String CompanyCity)
	{
		TextFields.get(2).click();
		TextFields.get(2).sendKeys(CompanyCity);
	}
	public void selectState()
	{
		YourState.click();
		Delaware.click();
	}
	public void enterCompanyZip(String CompanyZip)
	{
		Scrolluntil("Company Zip*");
		WebElement Zip = TextFields.get(3);
		Zip.click();
		Zip.sendKeys(CompanyZip);
	}
	public UtiltiyFormStep3 pressNextButton() {
		NEXTButton.click();
		UtiltiyFormStep3 utilityFormsStep3 = new UtiltiyFormStep3(driver);
		return utilityFormsStep3;
	}
}
