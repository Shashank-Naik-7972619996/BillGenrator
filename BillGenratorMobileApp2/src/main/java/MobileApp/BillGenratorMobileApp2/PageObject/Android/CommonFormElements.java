package MobileApp.BillGenratorMobileApp2.PageObject.Android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import MobileApp.BillGenratorMobileApp2.Utils.ReusableMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CommonFormElements extends ReusableMethods
{

AndroidDriver driver;
	
	public CommonFormElements(AndroidDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility="NEXT")
	private WebElement NEXTButton;
	@AndroidFindBy(accessibility = "PRIVIOUS")
	private WebElement PreviousButton;
	
	@AndroidFindBy(xpath = "//*[contains(@content-desc,'Open navigation menu')]/../following-sibling::android.widget.ImageView")
	private WebElement TemplateOptions;
	@AndroidFindBy(accessibility = "PREVIEW")
	private WebElement PREVIEW;
	@AndroidFindBy(xpath="(//android.view.View/android.view.View/android.view.View/android.view.View)[1]")
	private WebElement BackButton;
	@AndroidFindBy(accessibility = "CHECKOUT")
	private WebElement CHECKOUTButton;
	@AndroidFindBy(xpath="//android.widget.ImageView[contains(@content-desc,'Bill Number')]")
	private WebElement selectBillNumber;
	
	@AndroidFindBy(xpath="//android.view.View[contains(@content-desc,'Please Select Progress Number')]/following-sibling::android.view.View[1]")
	private WebElement selectLetestBillNumber;
	@AndroidFindBy(accessibility="LOAD DATA")
	private WebElement LOADDATAButton;
	
	
	public void pressNextButton()
	{
		NEXTButton.click();
	}
	public void pressPreviousButton() {
		PreviousButton.click();
	}
	public void pressPreviewButton()
	{
		PREVIEW.click();
	}
	public void pressTemplateOption()
	{
		TemplateOptions.click();
	}
	
	public void pressBackButtonOnPreviewPage()
	{
		BackButton.click();
	}
	public OrderPage pressCheckoutButton()
	{
		OrderPage OrderPage = new OrderPage(driver);
		
		CHECKOUTButton.click();
		return OrderPage;
		
	}
	public void selectLetestBillNumber()
	{
		selectBillNumber.click();
		selectLetestBillNumber.click();
		LOADDATAButton.click();
	}
}
