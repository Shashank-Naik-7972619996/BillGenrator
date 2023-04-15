package MobileApp.BillGenratorMobileApp2.PageObject.Android.Misc1099;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import MobileApp.BillGenratorMobileApp2.PageObject.Android.CommonFormElements;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.InvoiceForm.InvoiceFormStep3;
import MobileApp.BillGenratorMobileApp2.Utils.ReusableMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MiscFormStep1 extends ReusableMethods {
	AndroidDriver driver;

	public MiscFormStep1(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}

	@AndroidFindBy(xpath = "//*[contains(@content-desc, 'CORRECTED (if checked)')]/../android.view.View[2]")
	private WebElement CORRECTEDCheckBox;
	@AndroidFindBys({ @AndroidBy(xpath = "//*[contains(@content-desc,'2')]") })
	private List<WebElement> listOfYears;
	@AndroidFindBy(xpath = "//*[contains(@content-desc, 'What Year?')]")
	private WebElement WhatYear;
	@AndroidFindBy(accessibility = "NEXT")
	private WebElement NEXT;
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Open navigation menu']/../following-sibling::android.widget.ImageView")
	private WebElement templateOption;
	@AndroidFindBy(xpath = "//android.view.View[@content-desc='SAVE TEMPLATE']")
	private WebElement SaveTemplate;
	@AndroidFindBy(xpath = "//android.view.View[@content-desc='LOAD TEMPLATE']")
	private WebElement LoadTemplate;

	boolean checkboxstatus;

	public void checkCorrected() {
		CORRECTEDCheckBox.click();
		checkboxstatus = true;
	}

	public boolean verifyCorrectedIsChecked() {
		if (checkboxstatus = true) {
			return true;
		}
		return false;
	}

	public void selectWhatYear(String year) {
		WhatYear.click();
		for (int i = 0; i < listOfYears.size(); i++) {
			if (listOfYears.get(i).getAttribute("content-desc").equals(year)) {
				listOfYears.get(i).click();
			}
		}

	}

	public String getWhatYear() {

		String whatyear1 = WhatYear.getAttribute("content-desc"); // input string
		String GetWhatYear = ""; // substring containing last 4 characters

		if (whatyear1.length() > 4) {
			GetWhatYear = whatyear1.substring(whatyear1.length() - 4);
		} else {
			GetWhatYear = whatyear1;
		}
		System.out.println("Year: " + GetWhatYear);
		return GetWhatYear;
	}

	public MiscFormStep2 pressNEXT() {
		NEXT.click();
		MiscFormStep2 MiscFormStep2 = new MiscFormStep2(driver);
		return MiscFormStep2;
	}
	public void pressTemplateOptions() {
		templateOption.click();
	}

	public void pressSaveTemplate() {
		SaveTemplate.click();
	}

	public CommonFormElements pressLoadTemplate() {
		LoadTemplate.click();
		CommonFormElements CommonFormElements = new CommonFormElements(driver);
		return CommonFormElements;
	}

}
