package LoanQuoTest.LoanQuo;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileExistsException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.portalDashboard;
import pageObjects.portalLoginPage;
import resources.Base;

public class LoginPageTest extends Base {
	portalLoginPage plp;
	WebDriverWait w;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void Initialisation() throws IOException {
		driver = InitialiseDriver();
		driver.get(prop.getProperty("PortalStagingUrl"));
		// driver.get(prop.getProperty("CompanyStagingUrl"));
		plp = new portalLoginPage(driver);
		w = new WebDriverWait(driver, 10);
		log.info("Driver Initialised.");
	}
	
	@DataProvider
	public Object[][] invlaidLogin() {
		Object[][] obj = new Object[7][2];
		obj[0][0] = " ";
		obj[0][1] = " ";
		obj[1][0] = "marqueetest14gmail.com";
		obj[1][1] = "123456";
		obj[2][0] = "marqueetest14";
		obj[2][1] = "123456";
		obj[3][0] = "@marqueetest14";
		obj[3][1] = "@##$@#$";
		obj[4][0] = "@marqueetest14@";
		obj[4][1] = "12345ADF";
		obj[5][0] = "@marqueetest14@gmail.com";
		obj[5][1] = "1236@##";
		obj[6][0] = "marqueetest@gmailcom";
		obj[6][1] = "admin$%%";
		return obj;
	}

	@Test(priority = 3, dataProvider = "invlaidLogin")
	public void Verify_Login_With_All_Invalid_Inputs_Along_With_Validation_messages(String username, String pass) {
		SoftAssert softAssertion = new SoftAssert();

		plp.Username().clear();
		plp.Password().clear();
		plp.Username().sendKeys(username);
		plp.Password().sendKeys(pass);
		plp.ClickSubmitButton();
		softAssertion.assertEquals(plp.emailError().getText(), "please enter valid email.");
		if (pass.length() < 6) {
			softAssertion.assertEquals(plp.passwordError().getText(), "Atleast 6 characters.");
		}
		softAssertion.assertAll();
		log.info("Validation for invalid details verified.");
	}

	@Test(priority = 2)
	public void Verify_validations_on_Login_When_No_Values_Entered() {
		try {
			SoftAssert softAssertion2 = new SoftAssert();
			plp.Username().clear();
			plp.Password().clear();
			// softAssertion2.assertEquals(plp.AgreementCheck().isSelected(),false);
			if (plp.AgreementCheck().isSelected()) {
				plp.AgreementCheck().click();
			}
			plp.ClickSubmitButton();
			softAssertion2.assertEquals(plp.emailError().getText(), "Please enter email.");
			softAssertion2.assertEquals(plp.passwordError().getText(), "Please enter password.");
			softAssertion2.assertEquals(plp.agreeCheckError().getText(), "Please check checkbox.");
			softAssertion2.assertAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Same BUG for multiple types of inputs.");
		}
	}

	

	@Test(priority = 6)
	public void Verify_Login_With_Valid_Inputs() throws IOException {
		try {
			plp.Username().clear();
			plp.Password().clear();
			plp.Username().sendKeys("marqueetest14@gmail.com");
			plp.Password().sendKeys("admin2021");
			plp.AgreementCheck().click();
			portalDashboard pd=plp.ClickSubmitButton();
			w.until(ExpectedConditions.visibilityOf(pd.DashboardLabel()));
			Boolean isdisplay = pd.DashboardLabel().isDisplayed();
			Assert.assertTrue(isdisplay);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 4)
	public void Check_Password_AstrickByDefault() throws InterruptedException {
		String pass = "admin2020";
		plp.Password().sendKeys(pass);
		/*
		 * Thread.sleep(2000l); String pass1= plp.Password()
		 * //System.out.println(pass1); Thread.sleep(2000l); Assert.assertEquals(pass1,
		 * "•••••••••");
		 */
		// WebElement input = driver.findElement(By.id("..."));
		boolean isEncrypted = plp.Password().getAttribute("type").equals("password");
		Assert.assertEquals(isEncrypted, true);

	}

	@Test(priority = 5, dependsOnMethods = "Check_Password_AstrickByDefault")
	public void Verify_Eye_Toggle_ButtonFunctionality() throws InterruptedException {
		plp.PasswordEye().click();
		// Thread.sleep(6000l);
		boolean isEncrypted = plp.Password().getAttribute("type").equals("password");
		Assert.assertEquals(isEncrypted, false);
		plp.PasswordEye().click();
		boolean isNotEncrypted3 = plp.Password().getAttribute("type").equals("password");
		Assert.assertEquals(isNotEncrypted3, true);
	}

	@Test(priority = 1)
	public void Verify_Company_Name_and_Year_Of_The_Login_Page() {
		SoftAssert softAssertion2 = new SoftAssert();
		try {
			Date date = new Date();
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			int year = calendar.get(Calendar.YEAR);
			String yearintext = Integer.toString(year);
			boolean trueCurrentYear = plp.CompanyNameWithYearAtLoginPage().getText().contains(yearintext);
			System.out.println("Current Year is: " + yearintext);
			softAssertion2.assertTrue(trueCurrentYear, "year is not correct");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("The bottom line not found on login page.");
		}
		String CurrentLoginCompany = driver.getCurrentUrl().split("\\.")[0].split("//")[1];
		System.out.println(CurrentLoginCompany);
		if (CurrentLoginCompany.equalsIgnoreCase("portal")) {
			Boolean companyname1 = plp.LoginCompanyName1().getText().contains("LoanQuo");
			Boolean companyname2 = plp.LoginCompanyName2().getText().contains("LoanQuo");
			Boolean companyname3 = plp.CompanyNameOnCheckLabel().getText().contains("LoanQuo");
			System.out.println("There is LoanQuo in all places.");
			softAssertion2.assertTrue(companyname1, "Company Name is not correct mentioned above logo");
			softAssertion2.assertTrue(companyname2, "Company Name is not correct mentioned below 'Welcome Back !'");
			softAssertion2.assertTrue(companyname3, "Company Name is not correct mentioned in checkboxLabel");
		} else {
			Boolean companyname1 = plp.LoginCompanyName1().getText().contains(CurrentLoginCompany);
			Boolean companyname2 = plp.LoginCompanyName2().getText().contains(CurrentLoginCompany);
			Boolean companyname3 = plp.CompanyNameOnCheckLabel().getText().contains(CurrentLoginCompany);
			softAssertion2.assertTrue(companyname1, "Company Name is not correct mentioned above logo");
			softAssertion2.assertTrue(companyname2, "Company Name is not correct mentioned below 'Welcome Back !'");
			softAssertion2.assertTrue(companyname3, "Company Name is not correct mentioned in checkboxLabel");
		}
		softAssertion2.assertAll();
	}

	@AfterTest
	public void closedriver() {
		driver.quit();
	}
}
