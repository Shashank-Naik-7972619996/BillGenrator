package MobileApp.BillGenratorMobileApp2.PageObject.Android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ThankYouPage {
	AndroidDriver driver;

	public ThankYouPage(AndroidDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(new AppiumFieldDecorator(driver2), this);
	}

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Thank you']")
	private WebElement ThankYouText;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Download']")
	private WebElement DownloadButton;

	public String getThankYouPage() {
		if (ThankYouText.getAttribute("content-desc").equals("Thank you")) {
			return ThankYouText.getAttribute("content-desc");
		}
		return null;
	}
	public void pressDownloadButton()
	{
		DownloadButton.click();
	}

}
