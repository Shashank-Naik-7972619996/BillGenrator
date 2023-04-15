package WebApp.BillGenratorWebApp.Paystub;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.text.DecimalFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleOAuthConstants;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.GmailScopes;
import com.google.api.services.gmail.model.MessagePart;
import com.google.api.services.gmail.model.MessagePartHeader;

import GmailCall.GMail;
import MobileApp.BillGenratorMobileApp2.Utils.ReusableMethods;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PaystubWebFormPage extends ReusableMethods {
	public WebDriver browserdriver;

	public PaystubWebFormPage(WebDriver browserdriver) {
		super(browserdriver);
		this.browserdriver = browserdriver;
		PageFactory.initElements(browserdriver, this);
		// PageFactory.initElements(new AppiumFieldDecorator(browserdriver), this);
		// TODO Auto-generated constructor stub
	}

	// Login
	@FindBy(xpath = "//*[text()='Login']")
	WebElement Login;
	@FindBy(id = "l_email")
	WebElement email;
	@FindBy(id = "l_password")
	WebElement password;
	@FindBy(xpath = "//*[text()='SIGN IN']")
	WebElement loginButton;
	@FindBy(xpath = "//button[@class='btn-close']")
	WebElement CloseLoginWindow;
	@FindBy(id = "authForm")
	WebElement authForm;
	@FindBy(xpath = "(//img[@alt='Profile'])[2]")
	WebElement profile;
	@FindBy(xpath = "(//*[text()='Logout'])[2]")
	WebElement logout;
	@FindBy(id = "guest_progress_number")
	WebElement guest_progress_number;
	@FindBy(xpath = "//*[text()='Forgot Password?']")
	WebElement Forgot_PasswordLink;
	@FindBy(id = "f_email")
	WebElement f_email;
	@FindBy(xpath = "//*[text()='SEND OTP']")
	WebElement SEND_OTPButton;
	@FindBy(id = "r_otp")
	WebElement r_otp;
	@FindBy(id = "r_password")
	WebElement r_password;
	@FindBy(id = "r_confirmPassword")
	WebElement r_confirmPassword;
	@FindBy(xpath = "//*[text()='CHANGE PASSWORD']")
	WebElement ChangePasswordButton;

	// Coupon page
	@FindBy(id = "coupon")
	WebElement coupon;
	@FindBy(id = "procced_now")
	WebElement procced_nowButton;
	@FindBy(id = "apply_coupon")
	WebElement apply_coupon;
	@FindBy(id = "toast-container")
	WebElement toastcontainer;

	// Thank you page
	@FindBy(id = "btn-download")
	WebElement downloadButton;

	// Preview edit
	@FindBy(id = "preview_paystub")
	WebElement Preview_Paystub;
	@FindBy(id = "edit_paystub")
	WebElement edit_paystub;

	// Template Options
	@FindBy(id = "save_draft")
	WebElement save_Template;
	@FindBy(id = "load_template")
	WebElement load_template;
	@FindBy(id = "checkOut")
	WebElement checkOut;
	@FindBy(id = "checkoutAfterLogin")
	WebElement checkoutAfterLogin;
	@FindBy(id = "progress_number_option")
	WebElement progress_number_option;
	@FindBy(id = "btn_load_data_login")
	WebElement btn_load_data_login;
	@FindBy(id = "btn_load_data_without_login")
	WebElement btn_load_data_without_login;
	@FindBy(xpath = "//*[@data-bs-target='#withoutLoginSaveDraft']")
	WebElement SAVE_WITHOUT_LOGIN;
	@FindBy(id = "guest_email")
	WebElement guest_email;
	@FindBy(id = "save_darft_without_login")
	WebElement save_darft_without_login;

	// Start Here
	@FindBy(id = "auto_calc")
	WebElement auto_calc;
	@FindBy(id = "employment_type")
	WebElement employment_type;
	@FindBy(id = "payment_type")
	WebElement payment_type;
	@FindBy(id = "payment_cycle")
	WebElement How_often_are_you_paid;
	@FindBy(id = "previous_ytd")
	WebElement previous_ytdCalculations;
	@FindBy(id = "hired_in")
	WebElement Were_you_hired_in_the_past_52_weeks;
	@FindBy(id = "empYTD")
	WebElement How_many_pay_periods_have_you_worked;
	@FindBy(id = "paystub_need")
	WebElement paystub_need;
	@FindBy(id = "show_loader")
	WebElement show_loader;
	@FindBy(id = "show_modal_loader")
	WebElement show_modal_loader;
	@FindBy(xpath = "//select[@id = 'empYTD']/..")
	WebElement How_many_pay_periods;

	// Enter In previous YTD here
	@FindBy(id = "pre_ytd_1")
	WebElement pre_ytd_1;
	@FindBy(id = "pre_ytd_2")
	WebElement pre_ytd_2;
	@FindBy(id = "pre_ytd_3")
	WebElement pre_ytd_3;
	@FindBy(id = "pre_ytd_4")
	WebElement pre_ytd_4;
	@FindBy(id = "pre_ytd_5")
	WebElement pre_ytd_5;
	@FindBy(id = "pre_ytd_6")
	WebElement pre_ytd_6;
	@FindBy(id = "pre_ytd_7")
	WebElement pre_ytd_7;
	@FindBy(id = "pre_tytd")
	WebElement pre_tytd;

	// Company Information
	@FindBy(id = "employer_name")
	WebElement employer_name;
	@FindBy(id = "employer_number")
	WebElement employer_number;
	@FindBy(id = "employer_address")
	WebElement employer_address;
	@FindBy(id = "employer_address_2")
	WebElement employer_address_2;
	@FindBy(id = "employer_city")
	WebElement employer_city;
	@FindBy(id = "employer_state")
	WebElement employer_state;
	@FindBy(id = "employer_zip_code")
	WebElement employer_zip_code;
	@FindBy(xpath = "//Label[@for='employer_logo_upload']")
	WebElement employer_logo_upload;

	// Employer Information
	@FindBy(id = "employee_name")
	WebElement employee_name;
	@FindBy(id = "employee_social")
	WebElement employee_social;
	@FindBy(id = "employee_id")
	WebElement employee_id;
	@FindBy(id = "employee_telephone_number")
	WebElement employee_telephone_number;
	@FindBy(id = "employee_address")
	WebElement employee_address;
	@FindBy(id = "employee_address_2")
	WebElement employee_address_2;
	@FindBy(id = "employee_city")
	WebElement employee_city;
	@FindBy(id = "employee_state")
	WebElement employee_state;
	@FindBy(id = "employee_zip_code")
	WebElement employee_zip_code;
	@FindBy(id = "employee_marital_status")
	WebElement employee_marital_status;
	@FindBy(id = "exemptions")
	WebElement exemptions;
	@FindBy(id = "is_direct_deposit")
	WebElement is_direct_deposit;
	@FindBy(id = "is_direct_deposit_no")
	WebElement is_direct_deposit_no;
	@FindBy(id = "bank_checking_account")
	WebElement bank_checking_account;

	// EARNINGS STATEMENT
	@FindBys({ @FindBy(xpath = "//span[@class='paystub_count']") })
	List<WebElement> paystubCount;
	@FindBys({ @FindBy(id = "pay_period_start") })
	List<WebElement> pay_period_start;
	@FindBys({ @FindBy(id = "pay_period_end") })
	List<WebElement> pay_period_end;
	@FindBys({ @FindBy(id = "pay_date") })
	List<WebElement> pay_date;
	@FindBy(xpath = "//select[@class='yearselect']")
	WebElement selectYear;
	@FindBy(xpath = "//select[@class='monthselect']")
	WebElement monthselect;
	@FindBys({ @FindBy(xpath = "//td[not(contains(@class,'off ends'))][contains(@data-title,'r')]") })
	List<WebElement> activeDate;
	@FindBys({ @FindBy(xpath = "//button[contains(@class,'applyBtn')][not(contains(@disabled,'disabled'))]") })
	List<WebElement> ApplyButton;

	// Earnings
	List<WebElement> deleteCustomEarnings;
	List<WebElement> deleteCustomDeductions;
	@FindBys({ @FindBy(name = "regular_rate") })
	List<WebElement> regular_rate;
	@FindBys({ @FindBy(name = "regular_hours") })
	List<WebElement> regular_hours;
	@FindBys({ @FindBy(name = "regular_total") })
	List<WebElement> regular_total;
	@FindBys({ @FindBy(name = "ytd1") })
	List<WebElement> regular_ytd1;
	@FindBys({ @FindBy(xpath = "//input[@id='rate1']") })
	List<WebElement> salary_rate;

	@FindBys({ @FindBy(name = "overtime_rate") })
	List<WebElement> overtime_rate;
	@FindBys({ @FindBy(name = "overtime_hours") })
	List<WebElement> overtime_hours;
	@FindBys({ @FindBy(name = "overtime_total") })
	List<WebElement> overtime_total;
	@FindBys({ @FindBy(name = "ytd2") })
	List<WebElement> overtime_ytd2;
	@FindBys({ @FindBy(name = "holiday_rate") })
	List<WebElement> holiday_rate;
	@FindBys({ @FindBy(name = "holiday_hours") })
	List<WebElement> holiday_hours;
	@FindBys({ @FindBy(name = "holiday_total") })
	List<WebElement> holiday_total;
	@FindBys({ @FindBy(name = "ytd3") })
	List<WebElement> holiday_ytd3;
	@FindBys({ @FindBy(name = "vacation_rate") })
	List<WebElement> vacation_rate;
	@FindBys({ @FindBy(name = "vacation_hours") })
	List<WebElement> vacation_hours;
	@FindBys({ @FindBy(name = "vacation_total") })
	List<WebElement> vacation_total;
	@FindBys({ @FindBy(name = "ytd4") })
	List<WebElement> vacation_ytd4;
	@FindBys({ @FindBy(name = "bonus_rate") })
	List<WebElement> bonus_rate;
	@FindBys({ @FindBy(name = "bonus_hours") })
	List<WebElement> bonus_hours;
	@FindBys({ @FindBy(name = "bonus_total") })
	List<WebElement> bonus_total;
	@FindBys({ @FindBy(name = "ytd5") })
	List<WebElement> bonus_ytd5;
	@FindBys({ @FindBy(name = "float_rate") })
	List<WebElement> float_rate;
	@FindBys({ @FindBy(name = "float_hours") })
	List<WebElement> float_hours;
	@FindBys({ @FindBy(name = "float_total") })
	List<WebElement> float_total;
	@FindBys({ @FindBy(name = "ytd6") })
	List<WebElement> float_ytd6;
	@FindBys({ @FindBy(name = "tips_rate") })
	List<WebElement> tips_rate;
	@FindBys({ @FindBy(name = "tips_total") }) // need to change to tips_hours
	List<WebElement> tips_hours;
	@FindBys({ @FindBy(id = "total7") }) // need to change to tips_total with name attribute
	List<WebElement> tips_total;
	@FindBys({ @FindBy(name = "ytd7") })
	List<WebElement> tips_ytd7;
	@FindBys({ @FindBy(xpath = "//input[contains(@id,'custome_earnings_total')]") })
	List<WebElement> custome_earnings_total;
	@FindBys({ @FindBy(xpath = "//input[@name='custome_earnings_ytd_total']") })
	List<WebElement> custome_earnings_ytd_total;

	@FindBy(xpath = "//a[normalize-space()='+ ADD EARNINGS']")
	WebElement AddEarnings;

	@FindBy(xpath = "//a[normalize-space()='+ ADD DEDUCTIONS']")
	WebElement AddDeductions;

	@FindBys({ @FindBy(xpath = "//input[@id='custome_deduction_label_1']") })
	List<WebElement> custome_deduction_label_1;
	@FindBys({ @FindBy(xpath = "//input[@id='custome_deduction_label_2']") })
	List<WebElement> custome_deduction_label_2;
	@FindBys({ @FindBy(xpath = "//input[@id='custome_deduction_label_3']") })
	List<WebElement> custome_deduction_label_3;

	@FindBys({ @FindBy(xpath = "//input[contains(@id,'custome_deduction_total')]") })
	List<WebElement> custome_deduction_total;

	@FindBys({ @FindBy(xpath = "//input[@id='custom_earning_label_1']") })
	List<WebElement> custom_earning_label_1;
	@FindBys({ @FindBy(xpath = "//input[@id='custom_earning_label_2']") })
	List<WebElement> custom_earning_label_2;
	@FindBys({ @FindBy(xpath = "//input[@id='custom_earning_label_3']") })
	List<WebElement> custom_earning_label_3;
	@FindBys({ @FindBy(xpath = "//input[@id='custome_earnings_rate_1']") })
	List<WebElement> custome_earnings_rate_1;
	@FindBys({ @FindBy(xpath = "//input[@id='custome_earnings_rate_2']") })
	List<WebElement> custome_earnings_rate_2;
	@FindBys({ @FindBy(xpath = "//input[@id='custome_earnings_rate_3']") })
	List<WebElement> custome_earnings_rate_3;
//	@FindBy(xpath = "//input[@name='custome_earnings_rate']")
//	WebElement custome_earnings_rate1;
	@FindBys({ @FindBy(xpath = "//input[@id='custome_earnings_hours_1']") })
	List<WebElement> custome_earnings_hours_1;
	@FindBys({ @FindBy(xpath = "//input[@id='custome_earnings_hours_2']") })
	List<WebElement> custome_earnings_hours_2;
	@FindBys({ @FindBy(xpath = "//input[@id='custome_earnings_hours_3']") })
	List<WebElement> custome_earnings_hours_3;

	@FindBys({ @FindBy(name = "//i[@class='fa fa-minus font-icon']") })
	List<WebElement> minusIcon;

	@FindBys({ @FindBy(id = "tcurrent") })
	List<WebElement> grossPayTotal;

	@FindBys({ @FindBy(id = "tytd") })
	List<WebElement> grossPayYTDTotal;

	// REVIEW YOUR FINAL PAYSTUB
	@FindBy(xpath = "//button[@id='1']")
	WebElement Template1;
	@FindBy(xpath = "//button[@id='2']")
	WebElement Template2;
	@FindBy(xpath = "//button[@id='3']")
	WebElement Template3;
	@FindBy(xpath = "//button[@id='4']")
	WebElement Template4;
	@FindBy(xpath = "//button[@id='5']")
	WebElement Template5;
	@FindBy(xpath = "//button[@id='6']")
	WebElement Template6;

	public void waitTillLoaderEnds() throws InterruptedException {
		try {
			if (show_loader.getAttribute("style").contains("opacity")) {
				turnOnWaitOnBrowser();
				Expwait.until(ExpectedConditions.attributeToBe(show_loader, "style", "display: none;"));
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Thread.sleep(3000l);
	}

	public void waitTillModalLoaderEnds() throws InterruptedException {

		turnOnWaitOnBrowser();

		try {
			if (authForm.getAttribute("class").equals("modal fade show")) {
				Expwait.until(ExpectedConditions.attributeToBe(show_modal_loader, "style", "display: none;"));
				Expwait = new WebDriverWait(browserdriver, Duration.ofSeconds(0));
				browserdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
			}
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			Expwait = new WebDriverWait(browserdriver, Duration.ofSeconds(30));
			browserdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Expwait.until(ExpectedConditions.attributeToBe(show_modal_loader, "style", ""));
		}
	}
	// Thread.sleep(3000l);

	public void pressPreview() {
		turnOnWaitOnBrowser();
		browserdriver.manage().window().maximize();
//		Expwait.until(ExpectedConditions
//				.visibilityOf(Preview_Paystub));
		Preview_Paystub.click();
	}

	// Initial selections

	public void enterInPreviousYTDCalculations(String string) throws InterruptedException {
		// TODO Auto-generated method stub
		Select PreviousYTDCalculations = new Select(previous_ytdCalculations);
		PreviousYTDCalculations.selectByVisibleText(string);
		waitTillLoaderEnds();
	}

	public void selectEmployment_Type(String empTypes) {
		Select empType = new Select(employment_type);
		empType.selectByVisibleText(empTypes);
		turnOnWaitOnBrowser();
		Expwait.until(ExpectedConditions.attributeToBe(show_loader, "style", "display: none;"));
	}

	public void selectPaymentType(String string) {
		// TODO Auto-generated method stub
		Select paymentType = new Select(payment_type);
		paymentType.selectByVisibleText(string);
	}

	public void select_how_often_you_paid(String howOftenPaid) throws InterruptedException {
		Select howoften = new Select(How_often_are_you_paid);
		howoften.selectByVisibleText(howOftenPaid);
		// waitTillLoaderEnds();
	}

	public void selectWere_you_hired_in_the_past_52_weeks(String YesNo) throws InterruptedException {

		Select YesNO = new Select(Were_you_hired_in_the_past_52_weeks);
		YesNO.selectByVisibleText(YesNo);
		waitTillLoaderEnds();
	}

	public void How_many_pay_periods_have_you_worked(String string) throws InterruptedException {
		// TODO Auto-generated method stub
		Select HowMany = new Select(How_many_pay_periods_have_you_worked);
		HowMany.selectByVisibleText(string);
		waitTillLoaderEnds();
	}

	public void select_NoOfPaystubsNeeded(int paystubCount) {
//		try {
//			Select paystubneed = new Select(paystub_need);
//			paystubneed.selectByIndex(paystubCount);
//		} catch (NoSuchElementException e) {
		// TODO Auto-generated catch block
		// e.printStackTrace();
		paystubCount = paystubCount - 1;
		paystub_need.click();
		Actions actions = new Actions(browserdriver);
		for (int i = 1; i <= paystubCount; i++) {
			actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		}
		actions.sendKeys(Keys.ENTER).build().perform();
		// }
		turnOnWaitOnBrowser();
		Expwait.until(ExpectedConditions.attributeToBe(show_loader, "style", "display: none;"));

	}

	public int getnumberOfPaystubsShownOnPage() throws InterruptedException {
		waitTillLoaderEnds();
		return paystubCount.size();
	}

	public int NumberOfOptionsInPaystubsNeeded() {
		Select paystubneed = new Select(paystub_need);
		int size = paystubneed.getOptions().size();
		return size;
	}

	// Enter data in Previous YTD calculations
	public void enterRegularYTDInPrevious(String data) throws InterruptedException {
		clearData(pre_ytd_1);
		pre_ytd_1.sendKeys(data);
		Actions actions = new Actions(browserdriver);
		actions.sendKeys(Keys.ENTER).build().perform();
	}

	public void enterOverTimeYTDInPrevious(String data) throws InterruptedException {
		clearData(pre_ytd_2);
		pre_ytd_2.sendKeys(data);
		Actions actions = new Actions(browserdriver);
		actions.sendKeys(Keys.ENTER).build().perform();
	}

	public void enterHolidayYTDInPrevious(String data) throws InterruptedException {
		clearData(pre_ytd_3);
		pre_ytd_3.sendKeys(data);
		Actions actions = new Actions(browserdriver);
		actions.sendKeys(Keys.ENTER).build().perform();
	}

	public void enterVacationYTDInPrevious(String data) throws InterruptedException {
		clearData(pre_ytd_4);
		pre_ytd_4.sendKeys(data);
		Actions actions = new Actions(browserdriver);
		actions.sendKeys(Keys.ENTER).build().perform();
	}

	public void enterBonusYTDInPrevious(String data) throws InterruptedException {
		clearData(pre_ytd_5);
		pre_ytd_5.sendKeys(data);
		Actions actions = new Actions(browserdriver);
		actions.sendKeys(Keys.ENTER).build().perform();
	}

	public void enterFloatYTDInPrevious(String data) throws InterruptedException {
		clearData(pre_ytd_6);
		pre_ytd_6.sendKeys(data);
		Actions actions = new Actions(browserdriver);
		actions.sendKeys(Keys.ENTER).build().perform();

		// Simulate pressing the Enter key
		actions.sendKeys(Keys.ENTER).build().perform();
	}

	public void enterTipsYTDInPrevious(String data) throws InterruptedException {
		clearData(pre_ytd_7);
		pre_ytd_7.sendKeys(data);
		Actions actions = new Actions(browserdriver);

		// Simulate pressing the Enter key
		actions.sendKeys(Keys.ENTER).build().perform();
	}

//Enter employerCompany details
	public void enterEmployer_name(String Employer_name) throws InterruptedException {

		try {
			waitTillLoaderEnds();
			employer_name.sendKeys(Employer_name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			employer_name.sendKeys(Employer_name);
		}
	}

	public void enterEmployerNumber(String EmployerNumber) {
		try {
			employer_number.sendKeys(EmployerNumber);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			employer_number.sendKeys(EmployerNumber);
		}
	}

	public void enterEmployerAddress(String EmployerAddress) {
		try {
			employer_address.sendKeys(EmployerAddress);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			employer_address.sendKeys(EmployerAddress);
		}
	}

	public void enterEmployerAddress2(String EmployerAddress2) {
		try {
			employer_address_2.sendKeys(EmployerAddress2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			employer_address_2.sendKeys(EmployerAddress2);
		}
	}

	public void enterEmployerCity(String EmployerCity) {
		try {
			employer_city.sendKeys(EmployerCity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			employer_city.sendKeys(EmployerCity);
		}
	}

	public void selectEmployerState(String EmployerState) {
		try {
			Select empState = new Select(employer_state);
			empState.selectByVisibleText(EmployerState);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Select empState = new Select(employer_state);
			empState.selectByVisibleText(EmployerState);
		}
	}

	public void enterEmployerZipCode(String EmployerZipCode) {
		try {
			employer_zip_code.sendKeys(EmployerZipCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			employer_zip_code.sendKeys(EmployerZipCode);
		}
	}

	public void enterEmployerLogoUpload() {
		try {
			employer_logo_upload.sendKeys("C:\\Users\\Marquee\\Pictures\\file_example_JPG_2500kB.jpg");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			employer_logo_upload.sendKeys("C:\\Users\\Marquee\\Pictures\\file_example_JPG_2500kB.jpg");
		}
	}

	// Enter employee details
	public void enterEmployee_Name(String Employee_Name) {
		try {
			employee_name.sendKeys(Employee_Name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			employee_name.sendKeys(Employee_Name);
		}
	}

	public void enterEmployee_Social(String Employee_Social) {
		try {
			employee_social.sendKeys(Employee_Social);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			employee_social.sendKeys(Employee_Social);
		}
	}

	public void enterEmployee_Id(String Employee_Id) {
		try {
			employee_id.sendKeys(Employee_Id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			employee_id.sendKeys(Employee_Id);
		}
	}

	public void enterEmployee_Telephone_Number(String Employee_Telephone_Number) {
		try {
			employee_telephone_number.sendKeys(Employee_Telephone_Number);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			employee_telephone_number.sendKeys(Employee_Telephone_Number);
		}
	}

	public void enterEmployee_Address(String Employee_Address) {
		try {
			employee_address.sendKeys(Employee_Address);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			employee_address.sendKeys(Employee_Address);
		}
	}

	public void enterEmployee_Address_2(String Employee_Address_2) {
		try {
			employee_address_2.sendKeys(Employee_Address_2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			employee_address_2.sendKeys(Employee_Address_2);
		}
	}

	public void enterEmployee_City(String Employee_City) {
		try {
			employee_city.sendKeys(Employee_City);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			employee_city.sendKeys(Employee_City);
		}
	}

	public void selectEmployee_State(String Employee_State) {
		try {
			Select employeeState = new Select(employee_state);
			employeeState.selectByVisibleText(Employee_State);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Select employeeState = new Select(employee_state);
			employeeState.selectByVisibleText(Employee_State);
		}
	}

	public void enterEmployee_Zip_Code(String Employee_Zip_Code) {
		try {
			employee_zip_code.sendKeys(Employee_Zip_Code);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			employee_zip_code.sendKeys(Employee_Zip_Code);
		}
	}

	public void selectEmployee_Marital_Status(String Employee_Marital_Status) {
		// employee_marital_status.sendKeys(Employee_Marital_Status);
		try {
			Select empMartialStatus = new Select(employee_marital_status);
			empMartialStatus.selectByVisibleText(Employee_Marital_Status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Select empMartialStatus = new Select(employee_marital_status);
			empMartialStatus.selectByVisibleText(Employee_Marital_Status);
		}
	}

	public void selectExemptions(String Exemptions) {
		// exemptions.sendKeys(Exemptions);
		try {
			Select selectExemptions = new Select(exemptions);
			selectExemptions.selectByVisibleText(Exemptions);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean markIs_direct_deposit() {
		try {
			turnOnWaitOnBrowser();
			Expwait.until(ExpectedConditions.elementToBeClickable(is_direct_deposit));
			is_direct_deposit.click();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		return true;
	}

	public boolean markIs_direct_deposit_no() {
		try {
			turnOnWaitOnBrowser();
			Expwait.until(ExpectedConditions.elementToBeClickable(is_direct_deposit));
			is_direct_deposit_no.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public void enterBank_Checking_Account(String Bank_Checking_Account) {
		try {
			turnOnWaitOnBrowser();
			Expwait.until(ExpectedConditions.visibilityOf(bank_checking_account));
			bank_checking_account.sendKeys(Bank_Checking_Account);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Assert.assertEquals(true, false, "The element is not visible and clicalle hence failed");
		}
	}

	// Enter Earning statement
	public void enterPay_period_start(int paystubNumber, String Year, String Month, String Date)
			throws InterruptedException {
		waitTillLoaderEnds();
		pay_period_start.get(paystubNumber - 1).click();
		Select year = new Select(selectYear);
		year.selectByVisibleText(Year);
		Select month = new Select(monthselect);
		month.selectByVisibleText(Month);
		for (int i = 0; i < activeDate.size(); i++) {
			if (activeDate.get(i).getText().equals(Date)) {
				activeDate.get(i).click();
				break;
			}
		}
		for (int i = 0; i < ApplyButton.size(); i++) {
			if (ApplyButton.get(i).isDisplayed()) {
				ApplyButton.get(i).click();
			}
		}
	}

	public String getPay_period_start(int paystubNumber) {
		return getTextValueOfWebElementID("pay_period_start", paystubNumber);
	}

	public String getpay_period_end(int paystubNumber) {
		return getTextValueOfWebElementID("pay_period_end", paystubNumber);
	}

	public String getPayPeriodpay_date(int paystubNumber) {
		return getTextValueOfWebElementID("pay_date", paystubNumber);
	}

	// Earning data
	// Regular
	public void enterRegularRates(int paystubNumber, String data) throws InterruptedException {
		try {
			paystubNumber = paystubNumber - 1;
			clearDataWithIndex(regular_rate, paystubNumber);
			regular_rate.get(paystubNumber).sendKeys(data);
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
	}

	public paystubTemplate1 enterRegularHours(int paystubNumber, String data) throws InterruptedException {
		int paystubNumber1 = paystubNumber - 1;
		try {
			clearDataWithIndex(regular_hours, paystubNumber1);
			regular_hours.get(paystubNumber1).sendKeys(data);
			// turnOnWaitOnBrowser();
//		Expwait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tips_total']")));
//		browserdriver.findElement(By.xpath("//*[@id='tips_total']")).click();
			regular_hours.get(paystubNumber1).sendKeys(Keys.ENTER);
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		paystubTemplate1 paystubTemplate1 = new paystubTemplate1(browserdriver);
		return paystubTemplate1;
	}

	public String getRegularTotal(int paystubNumber) {
		return regular_total.get(paystubNumber - 1).getText();
	}

	public String getRegularYTDTotal(int paystubNumber) {
		return regular_ytd1.get(paystubNumber - 1).getText();
	}

	// Salary
	public void enterSalaryRate(int paystubNumber, String string) throws InterruptedException {
		// TODO Auto-generated method stub
		paystubNumber = paystubNumber - 1;
		clearDataWithIndex(salary_rate, paystubNumber);
		try {
			salary_rate.get(paystubNumber).sendKeys(string);
			salary_rate.get(paystubNumber).sendKeys(Keys.ENTER);
			waitTillLoaderEnds();
		} catch (StaleElementReferenceException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			clearDataWithIndex(salary_rate, paystubNumber);
			salary_rate.get(paystubNumber).sendKeys(string);
			salary_rate.get(paystubNumber).sendKeys(Keys.ENTER);
			waitTillLoaderEnds();
		}
	}

	// OverTime
	public void enterOverTimeRate(int paystubNumber, String data) throws InterruptedException {
		try {
			int paystubNumber1 = paystubNumber - 1;
			clearDataWithIndex(overtime_rate, paystubNumber1);
			overtime_rate.get(paystubNumber1).sendKeys(data);
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterOverTimeHours(int paystubNumber, String data) throws InterruptedException {
		try {
			int paystubNumber1 = paystubNumber - 1;
			clearDataWithIndex(overtime_hours, paystubNumber1);
			overtime_hours.get(paystubNumber1).sendKeys(data);
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getOverTimeTotal(int paystubNumber) {
		return overtime_total.get(paystubNumber - 1).getText();
	}

	public String getOverTimeYTDTotal(int paystubNumber) {
		return overtime_ytd2.get(paystubNumber - 1).getText();
	}

	// Holiday
	public void enterHolidayRate(int paystubNumber, String data) throws InterruptedException {
		try {
			int paystubNumber1 = paystubNumber - 1;
			clearDataWithIndex(holiday_rate, paystubNumber1);
			holiday_rate.get(paystubNumber1).sendKeys(data);
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterHolidayHours(int paystubNumber, String data) throws InterruptedException {
		try {
			int paystubNumber1 = paystubNumber - 1;
			clearDataWithIndex(holiday_hours, paystubNumber1);
			holiday_hours.get(paystubNumber1).sendKeys(data);
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getHolidayTotal(int paystubNumber) {
		return holiday_total.get(paystubNumber - 1).getText();
	}

	public String getHolidayYTDTotal(int paystubNumber) {
		return holiday_ytd3.get(paystubNumber - 1).getText();
	}

	// Vacation
	public void enterVacationRate(int paystubNumber, String data) throws InterruptedException {
		try {
			int paystubNumber1 = paystubNumber - 1;
			clearDataWithIndex(vacation_rate, paystubNumber1);
			vacation_rate.get(paystubNumber1).sendKeys(data);
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterVacationHours(int paystubNumber, String data) throws InterruptedException {
		try {
			int paystubNumber1 = paystubNumber - 1;
			clearDataWithIndex(vacation_hours, paystubNumber1);
			vacation_hours.get(paystubNumber1).sendKeys(data);
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getVacationTotal(int paystubNumber) {
		return vacation_total.get(paystubNumber - 1).getText();
	}

	public String getVacationYTDTotal(int paystubNumber) {
		return vacation_ytd4.get(paystubNumber - 1).getText();
	}

	// Bonus
	public void enterBonusRate(int paystubNumber, String data) throws InterruptedException {
		try {
			int paystubNumber1 = paystubNumber - 1;
			clearDataWithIndex(bonus_rate, paystubNumber1);
			bonus_rate.get(paystubNumber1).sendKeys(data);
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterBonusHours(int paystubNumber, String data) throws InterruptedException {
		try {
			int paystubNumber1 = paystubNumber - 1;
			clearDataWithIndex(bonus_hours, paystubNumber1);
			bonus_hours.get(paystubNumber1).sendKeys(data);
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getBonusTotal(int paystubNumber) {
		return bonus_total.get(paystubNumber - 1).getText();
	}

	public String getBonusYTDTotal(int paystubNumber) {
		return bonus_ytd5.get(paystubNumber - 1).getText();
	}

	// Float
	public void enterFloatRate(int paystubNumber, String data) throws InterruptedException {
		try {
			int paystubNumber1 = paystubNumber - 1;
			clearDataWithIndex(float_rate, paystubNumber1);
			float_rate.get(paystubNumber1).sendKeys(data);
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterFloatHours(int paystubNumber, String data) throws InterruptedException {
		try {
			int paystubNumber1 = paystubNumber - 1;
			clearDataWithIndex(float_hours, paystubNumber1);
			float_hours.get(paystubNumber1).sendKeys(data);
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getFloatTotal(int paystubNumber) {
		return float_total.get(paystubNumber - 1).getText();
	}

	public String getFloatYTDTotal(int paystubNumber) {
		return float_ytd6.get(paystubNumber - 1).getText();
	}

	// Tips
	public void enterTipsRate(int paystubNumber, String data) throws InterruptedException {
		try {
			int paystubNumber1 = paystubNumber - 1;
			clearDataWithIndex(tips_rate, paystubNumber1);
			tips_rate.get(paystubNumber1).sendKeys(data);
			Actions actions = new Actions(browserdriver);
			actions.sendKeys(Keys.ENTER).build().perform();
			tips_rate.get(paystubNumber1).sendKeys(Keys.ENTER);
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getTipsTotal(int paystubNumber) {
		try {
			return tips_total.get(paystubNumber - 1).getText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return tips_total.get(paystubNumber - 1).getText();
		}
	}

	public String getTipsYTDTotal(int paystubNumber) {
		return tips_ytd7.get(paystubNumber - 1).getText();
	}

	// custome_earnings
	public void pressAddEarnings() throws InterruptedException {
		try {
			turnOnWaitOnBrowser();

			Actions actions = new Actions(browserdriver);

			// Simulate pressing the Enter key
			actions.sendKeys(Keys.ENTER).build().perform();
			waitTillLoaderEnds();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();

		} finally {
			AddEarnings.click();
		}

	}

	public void entercustom_earning_Name(int paystubNumber, int Customno, String name) {

		try {
			if (Customno == 1) {
				custom_earning_label_1.get(paystubNumber - 1).sendKeys(name);
			} else if (Customno == 2) {
				custom_earning_label_2.get(paystubNumber - 1).sendKeys(name);
			} else if (Customno == 3) {
				custom_earning_label_3.get(paystubNumber - 1).sendKeys(name);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterCustom_earningRate(int paystubNumber, int Customno, String data) {
		try {
			int paystubNumber1 = paystubNumber - 1;
			if (Customno == 1) {
				clearDataWithIndex(custome_earnings_rate_1, paystubNumber1);
				custome_earnings_rate_1.get(paystubNumber1).sendKeys(data);
			} else if (Customno == 2) {
				clearDataWithIndex(custome_earnings_rate_2, paystubNumber1);
				custome_earnings_rate_2.get(paystubNumber1).sendKeys(data);
			} else if (Customno == 3) {
				clearDataWithIndex(custome_earnings_rate_3, paystubNumber1);
				custome_earnings_rate_3.get(paystubNumber1).sendKeys(data);
			}
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterCustom_earningHours(int paystubNumber, int Customno, String data) {
		try {
			int paystubNumber1 = paystubNumber - 1;
			if (Customno == 1) {
				clearDataWithIndex(custome_earnings_hours_1, paystubNumber1);
				custome_earnings_hours_1.get(paystubNumber1).sendKeys(data);
			} else if (Customno == 2) {
				clearDataWithIndex(custome_earnings_hours_2, paystubNumber1);
				custome_earnings_hours_2.get(paystubNumber1).sendKeys(data);
			} else if (Customno == 3) {
				clearDataWithIndex(custome_earnings_hours_3, paystubNumber1);
				custome_earnings_hours_3.get(paystubNumber1).sendKeys(data);
			}
			clickonblank();
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getcustome_earnings_total(int paystubNumber) {

		return tips_total.get(paystubNumber - 1).getText();
	}

	public String getCustomeEarningsYTDtotal(int paystubNumber) {
		return tips_ytd7.get(paystubNumber - 1).getText();
	}

	public void pressAddDeductions() {
		turnOnWaitOnBrowser();
		Actions actions = new Actions(browserdriver);

		// Simulate pressing the Enter key
		actions.sendKeys(Keys.ENTER).build().perform();
		if (show_loader.getAttribute("style").contains("opacity")) {
			Expwait.until(ExpectedConditions.attributeToBe(show_loader, "style", "display: none;"));
		}
		AddDeductions.click();
	}

	public void enterCustomDeductionName(int paystubNumber, int customno, String data) {

		if (customno == 1) {
			custome_deduction_label_1.get(paystubNumber - 1).sendKeys(data);
		} else if (customno == 2) {
			custome_deduction_label_2.get(paystubNumber - 1).sendKeys(data);
		} else if (customno == 3) {
			custome_deduction_label_3.get(paystubNumber - 1).sendKeys(data);
		}
	}

	public void enterCistomDeductions(int paystubNumber, String data) {
		int paystubNumber1 = paystubNumber - 1;
		clearDataWithIndex(custome_deduction_total, paystubNumber1);
		custome_deduction_total.get(paystubNumber1).sendKeys(data);
		Actions actions = new Actions(browserdriver);
		// Simulate pressing the Enter key
		actions.sendKeys(Keys.ENTER).build().perform();
		// custome_deduction_total.get(paystubNumber1).click();
		// clickonblank();
		if (show_loader.getAttribute("style").contains("opacity")) {
			Expwait.until(ExpectedConditions.attributeToBe(show_loader, "style", "display: none;"));
		}
	}

	// Template Buttons
	public paystubTemplate1 clickTemplate1() {
		try {
			// waitTillLoaderEnds();
			turnOnWaitOnBrowser();
			Expwait.until(ExpectedConditions.elementToBeClickable(Template1));
			waitTillLoaderEnds();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Template1.click();
			paystubTemplate1 temp1 = new paystubTemplate1(browserdriver);
			return temp1;
		}
	}

	public paystubTemplate2 clickTemplate2() throws InterruptedException {
		try {
			// waitTillLoaderEnds();
			turnOnWaitOnBrowser();
			Expwait.until(ExpectedConditions.elementToBeClickable(Template2));
			waitTillLoaderEnds();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Template2.click();
			paystubTemplate2 temp2 = new paystubTemplate2(browserdriver);
//			turnOnWaitOnBrowser();
//			waitTillLoaderEnds();
			return temp2;
		}
	}

	public paystubTemplate3 clickTemplate3() {
		try {
			// waitTillLoaderEnds();
			turnOnWaitOnBrowser();
			Expwait.until(ExpectedConditions.elementToBeClickable(Template3));
			waitTillLoaderEnds();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Template3.click();
			paystubTemplate3 paystubTemplate3 = new paystubTemplate3(browserdriver);
			return paystubTemplate3;
		}
	}

	public paystubTemplate4 clickTemplate4() {
		try {
			// waitTillLoaderEnds();
			turnOnWaitOnBrowser();
			Expwait.until(ExpectedConditions.elementToBeClickable(Template4));
			waitTillLoaderEnds();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Template4.click();
			paystubTemplate4 paystubTemplate4 = new paystubTemplate4(browserdriver);
			return paystubTemplate4;
		}
	}

	public paystubTemplate5 clickTemplate5() {
		try {
			// waitTillLoaderEnds();
			turnOnWaitOnBrowser();
			Expwait.until(ExpectedConditions.elementToBeClickable(Template5));
			waitTillLoaderEnds();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Template5.click();
			paystubTemplate5 paystubTemplate5 = new paystubTemplate5(browserdriver);
			return paystubTemplate5;
		}
	}

	public paystubTemplate6 clickTemplate6() throws InterruptedException {
		try {
			// waitTillLoaderEnds();
			turnOnWaitOnBrowser();
			Expwait.until(ExpectedConditions.elementToBeClickable(Template6));
			waitTillLoaderEnds();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Template6.click();
			paystubTemplate6 paystubTemplate6 = new paystubTemplate6(browserdriver);
			return paystubTemplate6;
		}
	}

	public Double removeComma(String s) {
		// System.out.println(s);
		String s2 = s.replace(",", "");
		// System.out.println("After removing comma: " + s2);
		Double number = Double.parseDouble(s2);
		return number;
	}

	public String getTotalDeductionsOfPaystub(int paystubnumber) {

		paystubnumber = paystubnumber - 1;
		Double fica_medicare_total = removeComma(getTextValueOfWebElementID("fica_medicare_total", paystubnumber));
		Double fica_social_security_total = removeComma(
				getTextValueOfWebElementID("fica_social_security_total", paystubnumber));
		Double federal_tax_total = removeComma(getTextValueOfWebElementID("federal_tax_total", paystubnumber));
		Double state_tax_total = removeComma(getTextValueOfWebElementID("state_tax_total", paystubnumber));
		Double sdi_total = removeComma(getTextValueOfWebElementID("sdi_total", paystubnumber));
		Double sui_total = removeComma(getTextValueOfWebElementID("sui_total", paystubnumber));
		Double wc_total = removeComma(getTextValueOfWebElementID("wc_total", paystubnumber));
		Double fli_total = removeComma(getTextValueOfWebElementID("fli_total", paystubnumber));
		Double wf_total = removeComma(getTextValueOfWebElementID("wf_total", paystubnumber));

		double totaldeductions;
		totaldeductions = fica_medicare_total + fica_social_security_total + federal_tax_total + state_tax_total
				+ sdi_total + sui_total + wc_total + fli_total + wf_total;
		DecimalFormat df = new DecimalFormat("#,###.00");
		String numString = df.format(totaldeductions);

		return numString;
	}

	public boolean pressRemoveCustomEarning(int num) throws InterruptedException {
		try {
			deleteCustomEarnings = browserdriver
					.findElements(By.xpath("//div[contains(@id,'custom_earning')] //button[@id=" + num + "]"));
			deleteCustomEarnings.get(0).click();
			turnOnWaitOnBrowser();
			Expwait.until(ExpectedConditions.invisibilityOf(deleteCustomEarnings.get(0)));
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean pressRemoveCustomDeductions(int num) {
		try {
			deleteCustomDeductions = browserdriver
					.findElements(By.xpath("//div[contains(@id,'custom_deduction')] //button[@id=" + num + "]"));
			deleteCustomDeductions.get(0).click();
			turnOnWaitOnBrowser();
			Expwait.until(ExpectedConditions.invisibilityOf(deleteCustomDeductions.get(0)));
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void pressCheckoutButton() throws InterruptedException {

		Expwait.until(ExpectedConditions.elementToBeClickable(checkOut));
		Thread.sleep(3000l);
		checkOut.click();
		waitTillLoaderEnds();
//		Thread.sleep(3000l);
//		checkOut.click();
	}

	public void pressLoginAndCheckout() {
		checkoutAfterLogin.click();
	}

	public void enterEmailID(String email1) {
		// TODO Auto-generated method stub
		try {
			clearData(email);
			email.sendKeys(email1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterPassword(String pass) {
		// TODO Auto-generated method stub
		try {
			clearData(password);
			password.sendKeys(pass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void pressSignIn() throws InterruptedException {
		// TODO Auto-generated method stub
		loginButton.click();
		try {
			waitTillLoaderEnds();
			waitTillModalLoaderEnds();

		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterCoupon(String coupon1) {
		// TODO Auto-generated method stub
		coupon.sendKeys(coupon1);
	}

	public void pressProcced_nowButton() throws InterruptedException {
		// TODO Auto-generated method stub

		procced_nowButton.click();
	}

	public void pressDownloadButton() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		downloadButton.click();
		deleteAllPDFFilesFromFolder();

		// Get the default download directory path
		String filename2 = getZipFileName();

		String downloadPath = "C:\\Users\\Marquee\\Downloads\\" + filename2;
		String extractFolderPath = "C:\\Users\\Marquee\\Downloads\\Extracted";

		Thread.sleep(4000l);
		// Extract the contents of the zip file to a folder
		ZipFile zipFile = new ZipFile(downloadPath);
		Enumeration<ZipArchiveEntry> entries = zipFile.getEntries();
		while (entries.hasMoreElements()) {
			ZipArchiveEntry entry = entries.nextElement();
			File entryFile = new File(extractFolderPath, entry.getName());
			if (entry.isDirectory()) {
				entryFile.mkdirs();
			} else {
				entryFile.getParentFile().mkdirs();
				InputStream in = zipFile.getInputStream(entry);
				OutputStream out = new FileOutputStream(entryFile);
				IOUtils.copy(in, out);
				IOUtils.closeQuietly(in);
				IOUtils.closeQuietly(out);
			}
		}
		zipFile.close();
		File zipFile1 = new File("C:\\Users\\Marquee\\Downloads\\" + filename2);
		zipFile1.delete();
	}

	public void deleteAllPDFFilesFromFolder() {
		// Specify the folder path where PDF files are located
		String folderPath = "C:\\Users\\Marquee\\Downloads\\Extracted";

		// Create a File object for the folder
		File folder = new File(folderPath);

		// Get a list of all files in the folder
		File[] files = folder.listFiles();

		// Loop through the files and delete all PDF files
		for (File file : files) {
			if (file.isFile() && file.getName().toLowerCase().endsWith(".pdf")) {
				file.delete();
			}
		}
	}

	public String getZipFileName() {
		JavascriptExecutor js = (JavascriptExecutor) browserdriver;
		String filename = (String) js.executeScript("return $(\"#pdf_path\").val()");
		String filename2 = filename.split("pdf/")[1];
		// System.out.println("File Name:" + filename2);
		return filename2;
	}

	List<String> pdfFileNames;

	public String[] getDownloadedPDFFile() throws IOException, InterruptedException {
		// Delete all files from folder first

		String extractFolderPath = "C:\\Users\\Marquee\\Downloads\\Extracted";
		// Loop through each file in the extracted folder and check if it is a PDF file
		pdfFileNames = new ArrayList<String>();
		File extractFolder = new File(extractFolderPath);
		File[] files = extractFolder.listFiles();
		for (File file : files) {
			if (file.isFile() && file.getName().toLowerCase().endsWith(".pdf")) {
				pdfFileNames.add(file.getName());
			}
		}

		// Print the list of PDF file names
//		for (String pdfFileName : pdfFileNames) {
//			System.out.println(pdfFileName);
//		}
		String[] array = pdfFileNames.toArray(new String[pdfFileNames.size()]);
		return array;
	}

	public String verifyPdfFile(int paystubno) throws IOException, InterruptedException {
		String pdfText = null;
		try {
			getDownloadedPDFFile();
			// Get the downloaded PDF file path
			String downloadedFilePath = "C:\\Users\\Marquee\\Downloads\\Extracted\\" + pdfFileNames.get(paystubno - 1);

			// Read the contents of the PDF file using PDFBox
			PDDocument document = PDDocument.load(new File(downloadedFilePath));

			PDFTextStripper pdfStripper = new PDFTextStripper();
			pdfText = pdfStripper.getText(document);
			document.close();
			return pdfText;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pdfText;
	}

	public int getNumberOfPagesOfPdf(int paystubno) throws IOException {
		String downloadedFilePath = "C:\\Users\\Marquee\\Downloads\\Extracted\\" + pdfFileNames.get(paystubno - 1);

		// Read the contents of the PDF file using PDFBox
		PDDocument document = PDDocument.load(new File(downloadedFilePath));
		int numPages = document.getNumberOfPages();
		document.close();
		return numPages;
	}

	public void pressApplyCoupon() {
		// TODO Auto-generated method stub
		apply_coupon.click();
		Expwait.until(ExpectedConditions.visibilityOf(toastcontainer));
	}

	public void selectAutoCalculator(String string) {
		// TODO Auto-generated method stub
		Select auto = new Select(auto_calc);
		auto.selectByVisibleText(string);
	}

	public boolean Login() throws InterruptedException, TimeoutException {

		try {
			turnOnWaitOnBrowser();
			waitTillLoaderEnds();
//			WebElement authform = browserdriver.findElement(By.xpath("//div[@id='authForm']"));
//			Expwait.until(ExpectedConditions.attributeToBe(authform, "class", "modal fade"));
			Expwait.until(ExpectedConditions.visibilityOf(Login));
			Expwait.until(ExpectedConditions.elementToBeClickable(Login));
			Login.click();
			return false;
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			return true;
		} catch (ElementNotInteractableException e1) {

			return false;
		} catch (TimeoutException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean isUserLoggedIn() throws InterruptedException {
		turnOnWaitOnBrowser();
		waitTillLoaderEnds();
		try {
			// Expwait.until(ExpectedConditions.visibilityOf(Login));
			// WebElement profilename= browserdriver.findElement(By.xpath("//span[@key =
			// 't-henry']"));
			Login.isDisplayed();
			return false;
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			return true;
		}
	}

	// Forgot Password
	public void pressForgot_PasswordLink() {
		try {
			turnOnWaitOnBrowser();
			Expwait.until(ExpectedConditions.visibilityOf(Forgot_PasswordLink));
			Forgot_PasswordLink.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
	}

	public void enterEmailInForgotPass(String email) {
		try {
			turnOnWaitOnBrowser();
			Expwait.until(ExpectedConditions.visibilityOf(f_email));
			f_email.sendKeys(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// enterEmailInForgotPass(email);
			e.printStackTrace();
		}
	}

	public GMail pressSEND_OTPButton() throws InterruptedException {
		try {
			turnOnWaitOnBrowser();
			waitTillLoaderEnds();
			Expwait.until(ExpectedConditions.visibilityOf(SEND_OTPButton));
			Expwait.until(ExpectedConditions.elementToBeClickable(SEND_OTPButton));
			SEND_OTPButton.click();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			// pressSAVE_WITHOUT_LOGIN();
			// e.printStackTrace();
			// SEND_OTPButton.click();
		} catch (ElementNotInteractableException e) {
			// SEND_OTPButton.click();
			// pressSEND_OTPButton();
			// WebElement element = driver.findElement(By.id("yourElementId"));
			JavascriptExecutor executor = (JavascriptExecutor) browserdriver;
			executor.executeScript("arguments[0].click();", SEND_OTPButton);
		}

		GMail Gmail = new GMail(browserdriver);
		return Gmail;
	}

	public void enterValidOTP(String validOTP) {
		try {
			r_otp.sendKeys(validOTP);
		} catch (ElementNotInteractableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			turnOnWaitOnBrowser();
			Expwait.until(ExpectedConditions.elementToBeClickable(r_otp));
			r_otp.sendKeys(validOTP);
		} catch (TimeoutException e) {
			r_otp.sendKeys(validOTP);
		}
	}

	public void enterNewPass(String newpass) {
		r_password.sendKeys(newpass);
	}

	public void enterNewConfirmPass(String newpass) {
		r_confirmPassword.sendKeys(newpass);
	}

	public void pressChangePassButton() {
		ChangePasswordButton.click();
	}

//	public WebElement Email() {
//		// clearData(email);
//		email.clear();
//		return email;
//	}
//
//	public WebElement pass() {
//		// clearData(password);
//		password.clear();
//		return password;
//	}

	public void pressloginButton() throws InterruptedException {
		try {
			turnOnWaitOnBrowser();
			Expwait.until(ExpectedConditions.elementToBeClickable(loginButton));
			loginButton.click();
			waitTillModalLoaderEnds();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeLoginWindow() throws InterruptedException {
		turnOnWaitOnBrowser();
		waitTillLoaderEnds();
		try {
			Expwait.until(ExpectedConditions.elementToBeClickable(CloseLoginWindow));
			CloseLoginWindow.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
	}

	public void saveTemplate() {
		save_Template.click();

	}

	public void pressSAVE_WITHOUT_LOGIN() throws InterruptedException {
		try {
			turnOnWaitOnBrowser();
			Expwait.until(ExpectedConditions.visibilityOf(SAVE_WITHOUT_LOGIN));
			Expwait.until(ExpectedConditions.elementToBeClickable(SAVE_WITHOUT_LOGIN));
			waitTillLoaderEnds();
			SAVE_WITHOUT_LOGIN.click();
			// Expwait.until(ExpectedConditions.elementToBeClickable(SAVE_WITHOUT_LOGIN));

		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			// pressSAVE_WITHOUT_LOGIN();
			// e.printStackTrace();
		} catch (ElementNotInteractableException e) {
			// WebElement element = browserdriver.findElement(By.id("yourElementId"));
			JavascriptExecutor executor = (JavascriptExecutor) browserdriver;
			executor.executeScript("arguments[0].click();", SAVE_WITHOUT_LOGIN);
			// pressSAVE_WITHOUT_LOGIN();
		}
	}

	public void enterguest_email(String email) throws InterruptedException {
//		turnOnWaitOnBrowser();
//		
//		Expwait.until(ExpectedConditions.elementToBeClickable(guest_email));
		try {
			turnOnWaitOnBrowser();
			Expwait.until(ExpectedConditions.visibilityOf(guest_email));
			Expwait.until(ExpectedConditions.elementToBeClickable(guest_email));
			waitTillLoaderEnds();
			guest_email.sendKeys(email);
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			// pressSAVE_WITHOUT_LOGIN();
			// e.printStackTrace();
		} catch (ElementNotInteractableException e) {
			// TODO Auto-generated catch block
			JavascriptExecutor executor = (JavascriptExecutor) browserdriver;
			executor.executeScript("arguments[0].sendKeys('" + email + "')", guest_email);
			// executor.executeScript("arguments[0].click();", SAVE_WITHOUT_LOGIN);
		}
	}

	public GMail pressSave_darft_without_login() throws InterruptedException, ElementNotInteractableException {

		try {
			turnOnWaitOnBrowser();
			Expwait.until(ExpectedConditions.visibilityOf(guest_email));
			Expwait.until(ExpectedConditions.elementToBeClickable(guest_email));
			save_darft_without_login.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GMail Gmail = new GMail(browserdriver);
		return Gmail;
	}

	public void loadTemplate() {
		load_template.click();
	}

	public String selectFirstprogress_number_option() {

		progress_number_option.click();
		progress_number_option.click();
		Select options = null;
		try {
			options = new Select(progress_number_option);

			Actions actions = new Actions(browserdriver); // Create a new Actions object
			actions.sendKeys(Keys.DOWN).build().perform(); // Press the down button
			return options.getFirstSelectedOption().getText();
		} catch (NoSuchElementException e) {
			// Handle the exception
		}
		return options.getFirstSelectedOption().getText();
	}

	public void pressLoadTemplateButton() throws InterruptedException {
		btn_load_data_login.click();
		waitTillLoaderEnds();
	}

	public void pressLoadTemplateButton_without_login() throws InterruptedException {
		btn_load_data_without_login.click();
		waitTillLoaderEnds();
	}

	public String getSelectedOption(String id) {
		try {
			Select options = new Select(browserdriver.findElement(By.id(id)));
			WebElement selectedoption = options.getFirstSelectedOption();
			String selectedoptioninstring = selectedoption.getText();
			return selectedoptioninstring;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return "Element not found";
		}

	}

	public boolean isHow_many_pay_periodsDisplayed() {
		if (How_many_pay_periods.getAttribute("style").equals("display: block;")) {
			return true;
		} else {
			return false;
		}
	}

	public void Logout() {
		// TODO Auto-generated method stub
		profile.click();
		logout.click();
		browserdriver.get("http://staging.onlinebillgenerator.com/paystub");
	}

	public void enterProgressNumber(String progressno) {
		// TODO Auto-generated method stub
		String number = progressno.replace("BG-", "");
		guest_progress_number.sendKeys(number);
//		waitTillLoaderEnds();
//		waitTillModalLoaderEnds();
	}

}
