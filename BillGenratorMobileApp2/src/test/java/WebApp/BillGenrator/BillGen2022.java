package WebApp.BillGenrator;

import java.awt.Toolkit;
import java.io.IOException;
import java.security.GeneralSecurityException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mashape.unirest.http.exceptions.UnirestException;

import GmailCall.GMail;
import WebApp.BillGenratorWebApp.Paystub.PaystubWebFormPage;
import base.BaseClass;

public class BillGen2022 extends BaseClass {
//String browser;
	@BeforeClass
	//@Parameters("browser")
	public void beforeeverymethodinsameclass() throws IOException {
		startWebSession(/*browser*/);
		browserdriver.manage().window().maximize();
	}
	
	
	@AfterTest
	public void afterAllMehtodsOfSameClass() throws IOException {
		//browserdriver.close();
	}

	@Test(priority = 1, description = "1. Enter all the inputs in paystub form and observe the Templates1 shows all the info entered properly. in first paystub")
	public void enterAllInputs() throws InterruptedException {
		// Enter All Inputs
		SoftAssert soft1 = new SoftAssert();
		
		// enter company details
		PaystubWebFormPage.enterEmployer_name(propConnection.getProperty("PaystubEmployerName"));
		PaystubWebFormPage.enterEmployerNumber(propConnection.getProperty("PaystubEmployerTelephoneNumber"));
		PaystubWebFormPage.enterEmployerAddress(propConnection.getProperty("PaystubEmployerStreetAddress1"));
		PaystubWebFormPage.enterEmployerAddress2(propConnection.getProperty("PaystubEmployerStreetAddress2"));
		PaystubWebFormPage.enterEmployerCity(propConnection.getProperty("PaystubCompanyCity"));
		PaystubWebFormPage.selectEmployerState(propConnection.getProperty("PaystubCompanyState"));
		PaystubWebFormPage.enterEmployerZipCode(propConnection.getProperty("PaystubCompanyZipCode"));
		// PaystubWebFormPage.enterEmployerLogoUpload();

		// Enter Employee details
		PaystubWebFormPage.enterEmployee_Name(propConnection.getProperty("PaystubEmployerName"));
		PaystubWebFormPage.enterEmployee_Social(propConnection.getProperty("PaystubEmployeeSocialNumber"));
		PaystubWebFormPage.enterEmployee_Id(propConnection.getProperty("PaystubEmployeeID"));
		PaystubWebFormPage.enterEmployee_Telephone_Number(propConnection.getProperty("PaystubEmployeeTelephoneNumber"));
		PaystubWebFormPage.enterEmployee_Address(propConnection.getProperty("PaystubEmployeeAddress1"));
		PaystubWebFormPage.enterEmployee_Address_2(propConnection.getProperty("PaystubEmployeeAddress2"));
		PaystubWebFormPage.enterEmployee_City(propConnection.getProperty("PaystubEmployeeCity"));
		PaystubWebFormPage.selectEmployee_State(propConnection.getProperty("PaystubEmployeeState"));
		PaystubWebFormPage.enterEmployee_Zip_Code(propConnection.getProperty("PaystubEmployeeZipCode"));
		PaystubWebFormPage.selectEmployee_Marital_Status(propConnection.getProperty("PaystubEmployeeMaritalStatus"));
		PaystubWebFormPage.selectExemptions(propConnection.getProperty("PaystubEmployeeExemptions"));
		PaystubWebFormPage.markIs_direct_deposit();
		PaystubWebFormPage.enterBank_Checking_Account(propConnection.getProperty("Bank_Checking_Account"));

		// PaystubWebFormPage.markIs_direct_deposit_no();
		PaystubWebFormPage.select_NoOfPaystubsNeeded(2);
		PaystubWebFormPage.enterRegularRates(1, "900");
		PaystubWebFormPage.enterRegularHours(1, "9");
		PaystubWebFormPage.enterOverTimeRate(1, "12");
		PaystubWebFormPage.enterOverTimeHours(1, "8");
		PaystubWebFormPage.enterHolidayRate(1, "250");
		PaystubWebFormPage.enterHolidayHours(1, "24");
		PaystubWebFormPage.enterVacationRate(1, "600");
		PaystubWebFormPage.enterVacationHours(1, "24");
		PaystubWebFormPage.enterBonusRate(1, "15000");
		PaystubWebFormPage.enterBonusHours(1, "24");
		PaystubWebFormPage.enterFloatRate(1, "900.33");
		PaystubWebFormPage.enterFloatHours(1, "9");
		PaystubWebFormPage.enterTipsRate(1, "50");
		PaystubWebFormPage.pressAddEarnings();
		PaystubWebFormPage.entercustom_earning_Name(1, 1, "test name");
		PaystubWebFormPage.enterCustom_earningRate(1, 1, "12");
		PaystubWebFormPage.enterCustom_earningHours(1, 1, "24");

		// Enter Custom deductions
		PaystubWebFormPage.pressAddDeductions();
		PaystubWebFormPage.enterCustomDeductionName(1, 1, "Custom deduction");
		PaystubWebFormPage.enterCistomDeductions(1, "200.00");
		WebApp.BillGenratorWebApp.Paystub.paystubTemplate1 paystubTemplate1 = new WebApp.BillGenratorWebApp.Paystub.paystubTemplate1(
				browserdriver);
		soft1.assertEquals(paystubTemplate1.getCompanydetailsAtTopLeft(), "TEST COMPANY NAME\r\n" + "1-234-567-8901\r\n"
				+ "TEST COMPANY STREET ADDRESS1 123456, TESTINNG COMPANY ADDRESS.\r\n"
				+ "TEST COMPANY STREET ADDRESS2 123456, TESTINNG COMPANY ADDRESS.\r\n" + "TEST COMPANYCITY,NM,65432");

		PaystubWebFormPage.enterRegularRates(2, "22");
		PaystubWebFormPage.enterRegularHours(2, "40.00");
		PaystubWebFormPage.enterOverTimeRate(2, "12");
		PaystubWebFormPage.enterOverTimeHours(2, "8");
		PaystubWebFormPage.enterHolidayRate(2, "250");
		PaystubWebFormPage.enterHolidayHours(2, "24");
		PaystubWebFormPage.enterVacationRate(2, "600");
		PaystubWebFormPage.enterVacationHours(2, "24");
		PaystubWebFormPage.enterBonusRate(2, "15000");
		PaystubWebFormPage.enterBonusHours(2, "24");
		PaystubWebFormPage.enterFloatRate(2, "900.33");
		PaystubWebFormPage.enterFloatHours(2, "9");
		PaystubWebFormPage.enterTipsRate(2, "50");
		PaystubWebFormPage.entercustom_earning_Name(2, 1, "test name");
		PaystubWebFormPage.enterCustom_earningRate(2, 1, "22");
		PaystubWebFormPage.enterCustom_earningHours(2, 1, "33");
		PaystubWebFormPage.pressAddDeductions();
		PaystubWebFormPage.enterCustomDeductionName(1, 2, "test deduction");
		PaystubWebFormPage.enterCistomDeductions(1, "222.0");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Feb", "15");
		// System.out.println(browserdriver.findElement(By.xpath("(//div[@class='d-flex']/parent::div)[2]")).getText());
		// browserdriver.switchTo().frame(null);

		// System.out.println(paystubTemplate2.getTopCompanyNameTemplate2());
		soft1.assertAll();
	}

	@Test(priority = 2, description = "2. Verify FICA Medicare With Gross PayYTD Total Less Than 200000")
	public void verifyFICAMedicareWithGrossPayYTDTotalLessThan200000() throws InterruptedException {
		SoftAssert soft2 = new SoftAssert();
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "900");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "9");
		soft2.assertEquals(getTextValueOfWebElementID("fica_medicare_total"), "117.45");
		soft2.assertEquals(paystubTemplate1.getFICAMedicareTemplate1(), "117.45");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		soft2.assertEquals(paystubTemplate2.getFICAMedicareTemplate2(), "117.45",
				"Fica Medicare In template 2 is wrong");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		soft2.assertEquals(paystubTemplate3.getFICAMedicareTemplate3(), "117.45",
				"Fica Medicare In template 3 is wrong");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		soft2.assertEquals(paystubTemplate4.getFICAMedicareTemplate4(), "117.45",
				"Fica Medicare In template 4 is wrong");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		soft2.assertEquals(paystubTemplate5.getFICAMedicareTemplate5(), "117.45",
				"Fica Medicare In template 5 is wrong");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		soft2.assertEquals(paystubTemplate6.getFICAMedicareTemplate6(), "117.45",
				"Fica Medicare In template 6 is wrong");

		soft2.assertAll();
	}

	@Test(priority = 3, description = "3. Verify FICAMedicare With GrossPay YTDTotal Greater Than 200000")
	public void verifyFICAMedicareWithGrossPayYTDTotalGreaterThan200000() throws InterruptedException {
		SoftAssert soft3 = new SoftAssert();
		//browserdriver.navigate().refresh();
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "200000");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "9");
		String FicaMedicare = paystubTemplate1.getFICAMedicareTemplate1();
		soft3.assertEquals(getTextValueOfWebElementID("fica_medicare_total"), "42,150.00");
		soft3.assertEquals(FicaMedicare, "42,150.00");

		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		String FicaMedicare2 = paystubTemplate2.getFICAMedicareTemplate2();
		soft3.assertEquals(FicaMedicare2, "42,150.00");

		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		String FicaMedicare3 = paystubTemplate3.getFICAMedicareTemplate3();
		soft3.assertEquals(FicaMedicare3, "42,150.00");

		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		String FicaMedicare4 = paystubTemplate4.getFICAMedicareTemplate4();
		soft3.assertEquals(FicaMedicare4, "42,150.00");

		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		String FicaMedicare5 = paystubTemplate5.getFICAMedicareTemplate5();
		soft3.assertEquals(FicaMedicare5, "42,150.00");

		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		String FicaMedicare6 = paystubTemplate6.getFICAMedicareTemplate6();
		soft3.assertEquals(FicaMedicare6, "42,150.00");

		soft3.assertAll();
	}

	@Test(priority = 4, description = "4. Verify FICA-Social-Security Calculations when social is less than 9114 for the year 2022")
	public void verifyFICASocialSecurityCalculations() throws InterruptedException {
		SoftAssert soft4 = new SoftAssert();
		//browserdriver.navigate().refresh();
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "30");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40");
		String FICASocialSecurity = paystubTemplate1.getFicasocialSecurityTotalTemplate1();
		soft4.assertEquals(getTextValueOfWebElementID("fica_social_security_total"), "74.40");
		soft4.assertEquals(FICASocialSecurity, "74.40");

		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		String FICASocialSecurity2 = paystubTemplate2.getFicasocialSecurityTotalTemplate2();
		soft4.assertEquals(FICASocialSecurity2, "74.40");

		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		String FICASocialSecurity3 = paystubTemplate3.getFicasocialSecurityTotalTemplate3();
		soft4.assertEquals(FICASocialSecurity3, "74.40");

		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		String FICASocialSecurity4 = paystubTemplate4.getFicasocialSecurityTotalTemplate4();
		soft4.assertEquals(FICASocialSecurity4, "74.40");

		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		String FICASocialSecurity5 = paystubTemplate5.getFicasocialSecurityTotalTemplate5();
		soft4.assertEquals(FICASocialSecurity5, "74.40");

		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		String FICASocialSecurity6 = paystubTemplate6.getFicasocialSecurityTotalTemplate6();
		soft4.assertEquals(FICASocialSecurity6, "74.40");

		soft4.assertAll();
	}

	@Test(priority = 5, description = "5. Verify FICA-Social-Security Calculations when social is greater than 9114 for the year 2022 on all preview page.")
	public void verifyFicaSocialSecurityCalculations() throws InterruptedException {
		SoftAssert soft5 = new SoftAssert();
		//browserdriver.navigate().refresh();
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "147000");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "1");

		soft5.assertEquals(getTextValueOfWebElementID("fica_social_security_total"), "9,114.00");
		soft5.assertEquals(paystubTemplate1.getFicasocialSecurityTotalTemplate1(), "9,114.00");
		PaystubWebFormPage.enterRegularRates(1, "247000");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "1");
		soft5.assertEquals(getTextValueOfWebElementID("fica_social_security_total"), "9,114.00");
		soft5.assertEquals(paystubTemplate1.getFicasocialSecurityTotalTemplate1(), "9,114.00");

		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		String FICASocialSecurity2 = paystubTemplate2.getFicasocialSecurityTotalTemplate2();
		soft5.assertEquals(FICASocialSecurity2, "9,114.00");

		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		String FICASocialSecurity3 = paystubTemplate3.getFicasocialSecurityTotalTemplate3();
		soft5.assertEquals(FICASocialSecurity3, "9,114.00");

		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		String FICASocialSecurity4 = paystubTemplate4.getFicasocialSecurityTotalTemplate4();
		soft5.assertEquals(FICASocialSecurity4, "9,114.00");

		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		String FICASocialSecurity5 = paystubTemplate5.getFicasocialSecurityTotalTemplate5();
		soft5.assertEquals(FICASocialSecurity5, "9,114.00");

		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		String FICASocialSecurity6 = paystubTemplate6.getFicasocialSecurityTotalTemplate6();
		soft5.assertEquals(FICASocialSecurity6, "9,114.00");

		soft5.assertAll();
	}

	@Test(priority = 6, description = "6. Verify federal tax calculations with martial status as 'Single' year=2022")
	public void VerifyFederalTaxCalculationsonTemplate1() throws InterruptedException {
		SoftAssert soft6 = new SoftAssert();
		//browserdriver.navigate().refresh();
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "200.00");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40.00");
		soft6.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "1,157.33");
		soft6.assertEquals(paystubTemplate1.getFederalTaxTotalTemplate1(), "1,157.33");

		// Verify federal tax with lowest value 800 as gross total
		PaystubWebFormPage.enterRegularRates(1, "10.00");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80.00");
		soft6.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "0.00");
		soft6.assertEquals(paystubTemplate1.getFederalTaxTotalTemplate1(), "0.00");

		PaystubWebFormPage.enterRegularRates(1, "80000");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "1");
		soft6.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "26,113.63");
		soft6.assertEquals(paystubTemplate1.getFederalTaxTotalTemplate1(), "26,113.63");

		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		String getFederalTaxTotalTemplate2 = paystubTemplate2.getFederalTaxTotalTemplate2();
		soft6.assertEquals(getFederalTaxTotalTemplate2, "26,113.63");

		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		String getFederalTaxTotalTemplate3 = paystubTemplate3.getFederalTaxTotalTemplate3();
		soft6.assertEquals(getFederalTaxTotalTemplate3, "26,113.63");

		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		String getFederalTaxTotalTemplate4 = paystubTemplate4.getFederalTaxTotalTemplate4();
		soft6.assertEquals(getFederalTaxTotalTemplate4, "26,113.63");

		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		String getFederalTaxTotalTemplate5 = paystubTemplate5.getFederalTaxTotalTemplate5();
		soft6.assertEquals(getFederalTaxTotalTemplate5, "26,113.63");

		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		String getFederalTaxTotalTemplate6 = paystubTemplate6.getFederalTaxTotalTemplate6();
		soft6.assertEquals(getFederalTaxTotalTemplate6, "26,113.63");

		soft6.assertAll();
	}

	@Test(priority = 7, description = "7.	Verify federal tax calculations with martial status as 'Married' in year '2022")
	public void VerifyFederalTaxCalculationsWithMarriedOnTemplate1() throws InterruptedException {
		SoftAssert soft7 = new SoftAssert();
		//browserdriver.navigate().refresh();
		PaystubWebFormPage.selectEmployee_Marital_Status("Married");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");

		PaystubWebFormPage.enterRegularRates(1, "200.00");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40.00");
		soft7.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "666.75");
		soft7.assertEquals(paystubTemplate1.getFederalTaxTotalTemplate1(), "666.75");

		PaystubWebFormPage.enterRegularRates(1, "10.00");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80.00");
		soft7.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "0.00");
		soft7.assertEquals(paystubTemplate1.getFederalTaxTotalTemplate1(), "0.00");

		PaystubWebFormPage.enterRegularRates(1, "80000");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "1");
		soft7.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "23,347.17");
		soft7.assertEquals(paystubTemplate1.getFederalTaxTotalTemplate1(), "23,347.17");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		String getFederalTaxTotalTemplate2 = paystubTemplate2.getFederalTaxTotalTemplate2();
		soft7.assertEquals(getFederalTaxTotalTemplate2, "23,347.17");

		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		String getFederalTaxTotalTemplate3 = paystubTemplate3.getFederalTaxTotalTemplate3();
		soft7.assertEquals(getFederalTaxTotalTemplate3, "23,347.17");

		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		String getFederalTaxTotalTemplate4 = paystubTemplate4.getFederalTaxTotalTemplate4();
		soft7.assertEquals(getFederalTaxTotalTemplate4, "23,347.17");

		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		String getFederalTaxTotalTemplate5 = paystubTemplate5.getFederalTaxTotalTemplate5();
		soft7.assertEquals(getFederalTaxTotalTemplate5, "23,347.17");

		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		String getFederalTaxTotalTemplate6 = paystubTemplate6.getFederalTaxTotalTemplate6();
		soft7.assertEquals(getFederalTaxTotalTemplate6, "23,347.17");

		soft7.assertAll();
	}

	@Test(priority = 8, description = "8. Verify Federal Tax calculations for all exemptions with maratial status as 'Single' and 'Married' and year'2022")
	public void verifyFederalTaxWithAllExemptions() throws InterruptedException {
		SoftAssert soft8 = new SoftAssert();
	//	browserdriver.navigate().refresh();
		PaystubWebFormPage.selectEmployee_Marital_Status("Single");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");

		PaystubWebFormPage.enterRegularRates(1, "200.00");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40.00");
		PaystubWebFormPage.selectExemptions("0");
		String FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "1,157.33");
		soft8.assertEquals(FederalTaxTotal, "1,157.33");

		PaystubWebFormPage.selectExemptions("1");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "1,083.08");
		soft8.assertEquals(FederalTaxTotal, "1,083.08");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		String getFederalTaxTotalTemplate2 = paystubTemplate2.getFederalTaxTotalTemplate2();
		soft8.assertEquals(getFederalTaxTotalTemplate2, "1,083.08");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		String getFederalTaxTotalTemplate3 = paystubTemplate3.getFederalTaxTotalTemplate3();
		soft8.assertEquals(getFederalTaxTotalTemplate3, "1,083.08");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		String getFederalTaxTotalTemplate4 = paystubTemplate4.getFederalTaxTotalTemplate4();
		soft8.assertEquals(getFederalTaxTotalTemplate4, "1,083.08");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		String getFederalTaxTotalTemplate5 = paystubTemplate5.getFederalTaxTotalTemplate5();
		soft8.assertEquals(getFederalTaxTotalTemplate5, "1,083.08");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		String getFederalTaxTotalTemplate6 = paystubTemplate6.getFederalTaxTotalTemplate6();
		soft8.assertEquals(getFederalTaxTotalTemplate6, "1,083.08");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectExemptions("2");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "1,008.83");
		soft8.assertEquals(FederalTaxTotal, "1,008.83");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getFederalTaxTotalTemplate2 = paystubTemplate2.getFederalTaxTotalTemplate2();
		soft8.assertEquals(getFederalTaxTotalTemplate2, "1,008.83");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getFederalTaxTotalTemplate3 = paystubTemplate3.getFederalTaxTotalTemplate3();
		soft8.assertEquals(getFederalTaxTotalTemplate3, "1,008.83");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getFederalTaxTotalTemplate4 = paystubTemplate4.getFederalTaxTotalTemplate4();
		soft8.assertEquals(getFederalTaxTotalTemplate4, "1,008.83");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getFederalTaxTotalTemplate5 = paystubTemplate5.getFederalTaxTotalTemplate5();
		soft8.assertEquals(getFederalTaxTotalTemplate5, "1,008.83");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getFederalTaxTotalTemplate6 = paystubTemplate6.getFederalTaxTotalTemplate6();
		soft8.assertEquals(getFederalTaxTotalTemplate6, "1,008.83");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectExemptions("3");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "934.58");
		soft8.assertEquals(FederalTaxTotal, "934.58");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getFederalTaxTotalTemplate2 = paystubTemplate2.getFederalTaxTotalTemplate2();
		soft8.assertEquals(getFederalTaxTotalTemplate2, "934.58");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getFederalTaxTotalTemplate3 = paystubTemplate3.getFederalTaxTotalTemplate3();
		soft8.assertEquals(getFederalTaxTotalTemplate3, "934.58");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getFederalTaxTotalTemplate4 = paystubTemplate4.getFederalTaxTotalTemplate4();
		soft8.assertEquals(getFederalTaxTotalTemplate4, "934.58");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getFederalTaxTotalTemplate5 = paystubTemplate5.getFederalTaxTotalTemplate5();
		soft8.assertEquals(getFederalTaxTotalTemplate5, "934.58");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getFederalTaxTotalTemplate6 = paystubTemplate6.getFederalTaxTotalTemplate6();
		soft8.assertEquals(getFederalTaxTotalTemplate6, "934.58");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectExemptions("4");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "860.33");
		soft8.assertEquals(FederalTaxTotal, "860.33");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getFederalTaxTotalTemplate2 = paystubTemplate2.getFederalTaxTotalTemplate2();
		soft8.assertEquals(getFederalTaxTotalTemplate2, "860.33");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getFederalTaxTotalTemplate3 = paystubTemplate3.getFederalTaxTotalTemplate3();
		soft8.assertEquals(getFederalTaxTotalTemplate3, "860.33");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getFederalTaxTotalTemplate4 = paystubTemplate4.getFederalTaxTotalTemplate4();
		soft8.assertEquals(getFederalTaxTotalTemplate4, "860.33");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getFederalTaxTotalTemplate5 = paystubTemplate5.getFederalTaxTotalTemplate5();
		soft8.assertEquals(getFederalTaxTotalTemplate5, "860.33");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getFederalTaxTotalTemplate6 = paystubTemplate6.getFederalTaxTotalTemplate6();
		soft8.assertEquals(getFederalTaxTotalTemplate6, "860.33");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectExemptions("5");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "786.08");
		soft8.assertEquals(FederalTaxTotal, "786.08");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getFederalTaxTotalTemplate2 = paystubTemplate2.getFederalTaxTotalTemplate2();
		soft8.assertEquals(getFederalTaxTotalTemplate2, "786.08");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getFederalTaxTotalTemplate3 = paystubTemplate3.getFederalTaxTotalTemplate3();
		soft8.assertEquals(getFederalTaxTotalTemplate3, "786.08");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getFederalTaxTotalTemplate4 = paystubTemplate4.getFederalTaxTotalTemplate4();
		soft8.assertEquals(getFederalTaxTotalTemplate4, "786.08");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getFederalTaxTotalTemplate5 = paystubTemplate5.getFederalTaxTotalTemplate5();
		soft8.assertEquals(getFederalTaxTotalTemplate5, "786.08");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getFederalTaxTotalTemplate6 = paystubTemplate6.getFederalTaxTotalTemplate6();
		soft8.assertEquals(getFederalTaxTotalTemplate6, "786.08");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectExemptions("6");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "711.83");
		soft8.assertEquals(FederalTaxTotal, "711.83");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getFederalTaxTotalTemplate2 = paystubTemplate2.getFederalTaxTotalTemplate2();
		soft8.assertEquals(getFederalTaxTotalTemplate2, "711.83");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getFederalTaxTotalTemplate3 = paystubTemplate3.getFederalTaxTotalTemplate3();
		soft8.assertEquals(getFederalTaxTotalTemplate3, "711.83");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getFederalTaxTotalTemplate4 = paystubTemplate4.getFederalTaxTotalTemplate4();
		soft8.assertEquals(getFederalTaxTotalTemplate4, "711.83");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getFederalTaxTotalTemplate5 = paystubTemplate5.getFederalTaxTotalTemplate5();
		soft8.assertEquals(getFederalTaxTotalTemplate5, "711.83");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getFederalTaxTotalTemplate6 = paystubTemplate6.getFederalTaxTotalTemplate6();
		soft8.assertEquals(getFederalTaxTotalTemplate6, "711.83");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectExemptions("7");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "637.58");
		soft8.assertEquals(FederalTaxTotal, "637.58");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getFederalTaxTotalTemplate2 = paystubTemplate2.getFederalTaxTotalTemplate2();
		soft8.assertEquals(getFederalTaxTotalTemplate2, "637.58");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getFederalTaxTotalTemplate3 = paystubTemplate3.getFederalTaxTotalTemplate3();
		soft8.assertEquals(getFederalTaxTotalTemplate3, "637.58");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getFederalTaxTotalTemplate4 = paystubTemplate4.getFederalTaxTotalTemplate4();
		soft8.assertEquals(getFederalTaxTotalTemplate4, "637.58");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getFederalTaxTotalTemplate5 = paystubTemplate5.getFederalTaxTotalTemplate5();
		soft8.assertEquals(getFederalTaxTotalTemplate5, "637.58");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getFederalTaxTotalTemplate6 = paystubTemplate6.getFederalTaxTotalTemplate6();
		soft8.assertEquals(getFederalTaxTotalTemplate6, "637.58");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectExemptions("8");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "563.33");
		soft8.assertEquals(FederalTaxTotal, "563.33");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getFederalTaxTotalTemplate2 = paystubTemplate2.getFederalTaxTotalTemplate2();
		soft8.assertEquals(getFederalTaxTotalTemplate2, "563.33");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getFederalTaxTotalTemplate3 = paystubTemplate3.getFederalTaxTotalTemplate3();
		soft8.assertEquals(getFederalTaxTotalTemplate3, "563.33");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getFederalTaxTotalTemplate4 = paystubTemplate4.getFederalTaxTotalTemplate4();
		soft8.assertEquals(getFederalTaxTotalTemplate4, "563.33");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getFederalTaxTotalTemplate5 = paystubTemplate5.getFederalTaxTotalTemplate5();
		soft8.assertEquals(getFederalTaxTotalTemplate5, "563.33");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getFederalTaxTotalTemplate6 = paystubTemplate6.getFederalTaxTotalTemplate6();
		soft8.assertEquals(getFederalTaxTotalTemplate6, "563.33");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectExemptions("9");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "489.08");
		soft8.assertEquals(FederalTaxTotal, "489.08");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getFederalTaxTotalTemplate2 = paystubTemplate2.getFederalTaxTotalTemplate2();
		soft8.assertEquals(getFederalTaxTotalTemplate2, "489.08");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getFederalTaxTotalTemplate3 = paystubTemplate3.getFederalTaxTotalTemplate3();
		soft8.assertEquals(getFederalTaxTotalTemplate3, "489.08");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getFederalTaxTotalTemplate4 = paystubTemplate4.getFederalTaxTotalTemplate4();
		soft8.assertEquals(getFederalTaxTotalTemplate4, "489.08");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getFederalTaxTotalTemplate5 = paystubTemplate5.getFederalTaxTotalTemplate5();
		soft8.assertEquals(getFederalTaxTotalTemplate5, "489.08");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getFederalTaxTotalTemplate6 = paystubTemplate6.getFederalTaxTotalTemplate6();
		soft8.assertEquals(getFederalTaxTotalTemplate6, "489.08");

		browserdriver.navigate().refresh();
		PaystubWebFormPage.selectEmployee_Marital_Status("Married");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");

		PaystubWebFormPage.enterRegularRates(1, "200.00");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40.00");
		PaystubWebFormPage.selectExemptions("0");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "666.75");
		soft8.assertEquals(FederalTaxTotal, "666.75");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getFederalTaxTotalTemplate2 = paystubTemplate2.getFederalTaxTotalTemplate2();
		soft8.assertEquals(getFederalTaxTotalTemplate2, "666.75");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getFederalTaxTotalTemplate3 = paystubTemplate3.getFederalTaxTotalTemplate3();
		soft8.assertEquals(getFederalTaxTotalTemplate3, "666.75");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getFederalTaxTotalTemplate4 = paystubTemplate4.getFederalTaxTotalTemplate4();
		soft8.assertEquals(getFederalTaxTotalTemplate4, "666.75");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getFederalTaxTotalTemplate5 = paystubTemplate5.getFederalTaxTotalTemplate5();
		soft8.assertEquals(getFederalTaxTotalTemplate5, "666.75");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getFederalTaxTotalTemplate6 = paystubTemplate6.getFederalTaxTotalTemplate6();
		soft8.assertEquals(getFederalTaxTotalTemplate6, "666.75");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectExemptions("1");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "626.25");
		soft8.assertEquals(FederalTaxTotal, "626.25");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getFederalTaxTotalTemplate2 = paystubTemplate2.getFederalTaxTotalTemplate2();
		soft8.assertEquals(getFederalTaxTotalTemplate2, "626.25");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getFederalTaxTotalTemplate3 = paystubTemplate3.getFederalTaxTotalTemplate3();
		soft8.assertEquals(getFederalTaxTotalTemplate3, "626.25");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getFederalTaxTotalTemplate4 = paystubTemplate4.getFederalTaxTotalTemplate4();
		soft8.assertEquals(getFederalTaxTotalTemplate4, "626.25");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getFederalTaxTotalTemplate5 = paystubTemplate5.getFederalTaxTotalTemplate5();
		soft8.assertEquals(getFederalTaxTotalTemplate5, "626.25");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getFederalTaxTotalTemplate6 = paystubTemplate6.getFederalTaxTotalTemplate6();
		soft8.assertEquals(getFederalTaxTotalTemplate6, "626.25");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectExemptions("2");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "585.75");
		soft8.assertEquals(FederalTaxTotal, "585.75");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getFederalTaxTotalTemplate2 = paystubTemplate2.getFederalTaxTotalTemplate2();
		soft8.assertEquals(getFederalTaxTotalTemplate2, "585.75");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getFederalTaxTotalTemplate3 = paystubTemplate3.getFederalTaxTotalTemplate3();
		soft8.assertEquals(getFederalTaxTotalTemplate3, "585.75");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getFederalTaxTotalTemplate4 = paystubTemplate4.getFederalTaxTotalTemplate4();
		soft8.assertEquals(getFederalTaxTotalTemplate4, "585.75");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getFederalTaxTotalTemplate5 = paystubTemplate5.getFederalTaxTotalTemplate5();
		soft8.assertEquals(getFederalTaxTotalTemplate5, "585.75");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getFederalTaxTotalTemplate6 = paystubTemplate6.getFederalTaxTotalTemplate6();
		soft8.assertEquals(getFederalTaxTotalTemplate6, "585.75");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectExemptions("3");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "545.25");
		soft8.assertEquals(FederalTaxTotal, "545.25");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getFederalTaxTotalTemplate2 = paystubTemplate2.getFederalTaxTotalTemplate2();
		soft8.assertEquals(getFederalTaxTotalTemplate2, "545.25");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getFederalTaxTotalTemplate3 = paystubTemplate3.getFederalTaxTotalTemplate3();
		soft8.assertEquals(getFederalTaxTotalTemplate3, "545.25");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getFederalTaxTotalTemplate4 = paystubTemplate4.getFederalTaxTotalTemplate4();
		soft8.assertEquals(getFederalTaxTotalTemplate4, "545.25");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getFederalTaxTotalTemplate5 = paystubTemplate5.getFederalTaxTotalTemplate5();
		soft8.assertEquals(getFederalTaxTotalTemplate5, "545.25");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getFederalTaxTotalTemplate6 = paystubTemplate6.getFederalTaxTotalTemplate6();
		soft8.assertEquals(getFederalTaxTotalTemplate6, "545.25");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectExemptions("4");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "504.75");
		soft8.assertEquals(FederalTaxTotal, "504.75");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getFederalTaxTotalTemplate2 = paystubTemplate2.getFederalTaxTotalTemplate2();
		soft8.assertEquals(getFederalTaxTotalTemplate2, "504.75");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getFederalTaxTotalTemplate3 = paystubTemplate3.getFederalTaxTotalTemplate3();
		soft8.assertEquals(getFederalTaxTotalTemplate3, "504.75");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getFederalTaxTotalTemplate4 = paystubTemplate4.getFederalTaxTotalTemplate4();
		soft8.assertEquals(getFederalTaxTotalTemplate4, "504.75");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getFederalTaxTotalTemplate5 = paystubTemplate5.getFederalTaxTotalTemplate5();
		soft8.assertEquals(getFederalTaxTotalTemplate5, "504.75");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getFederalTaxTotalTemplate6 = paystubTemplate6.getFederalTaxTotalTemplate6();
		soft8.assertEquals(getFederalTaxTotalTemplate6, "504.75");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectExemptions("5");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "464.25");
		soft8.assertEquals(FederalTaxTotal, "464.25");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getFederalTaxTotalTemplate2 = paystubTemplate2.getFederalTaxTotalTemplate2();
		soft8.assertEquals(getFederalTaxTotalTemplate2, "464.25");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getFederalTaxTotalTemplate3 = paystubTemplate3.getFederalTaxTotalTemplate3();
		soft8.assertEquals(getFederalTaxTotalTemplate3, "464.25");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getFederalTaxTotalTemplate4 = paystubTemplate4.getFederalTaxTotalTemplate4();
		soft8.assertEquals(getFederalTaxTotalTemplate4, "464.25");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getFederalTaxTotalTemplate5 = paystubTemplate5.getFederalTaxTotalTemplate5();
		soft8.assertEquals(getFederalTaxTotalTemplate5, "464.25");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getFederalTaxTotalTemplate6 = paystubTemplate6.getFederalTaxTotalTemplate6();
		soft8.assertEquals(getFederalTaxTotalTemplate6, "464.25");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectExemptions("6");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "423.75");
		soft8.assertEquals(FederalTaxTotal, "423.75");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getFederalTaxTotalTemplate2 = paystubTemplate2.getFederalTaxTotalTemplate2();
		soft8.assertEquals(getFederalTaxTotalTemplate2, "423.75");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getFederalTaxTotalTemplate3 = paystubTemplate3.getFederalTaxTotalTemplate3();
		soft8.assertEquals(getFederalTaxTotalTemplate3, "423.75");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getFederalTaxTotalTemplate4 = paystubTemplate4.getFederalTaxTotalTemplate4();
		soft8.assertEquals(getFederalTaxTotalTemplate4, "423.75");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getFederalTaxTotalTemplate5 = paystubTemplate5.getFederalTaxTotalTemplate5();
		soft8.assertEquals(getFederalTaxTotalTemplate5, "423.75");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getFederalTaxTotalTemplate6 = paystubTemplate6.getFederalTaxTotalTemplate6();
		soft8.assertEquals(getFederalTaxTotalTemplate6, "423.75");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectExemptions("7");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "383.25");
		soft8.assertEquals(FederalTaxTotal, "383.25");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getFederalTaxTotalTemplate2 = paystubTemplate2.getFederalTaxTotalTemplate2();
		soft8.assertEquals(getFederalTaxTotalTemplate2, "383.25");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getFederalTaxTotalTemplate3 = paystubTemplate3.getFederalTaxTotalTemplate3();
		soft8.assertEquals(getFederalTaxTotalTemplate3, "383.25");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getFederalTaxTotalTemplate4 = paystubTemplate4.getFederalTaxTotalTemplate4();
		soft8.assertEquals(getFederalTaxTotalTemplate4, "383.25");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getFederalTaxTotalTemplate5 = paystubTemplate5.getFederalTaxTotalTemplate5();
		soft8.assertEquals(getFederalTaxTotalTemplate5, "383.25");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getFederalTaxTotalTemplate6 = paystubTemplate6.getFederalTaxTotalTemplate6();
		soft8.assertEquals(getFederalTaxTotalTemplate6, "383.25");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectExemptions("8");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "342.75");
		soft8.assertEquals(FederalTaxTotal, "342.75");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getFederalTaxTotalTemplate2 = paystubTemplate2.getFederalTaxTotalTemplate2();
		soft8.assertEquals(getFederalTaxTotalTemplate2, "342.75");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getFederalTaxTotalTemplate3 = paystubTemplate3.getFederalTaxTotalTemplate3();
		soft8.assertEquals(getFederalTaxTotalTemplate3, "342.75");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getFederalTaxTotalTemplate4 = paystubTemplate4.getFederalTaxTotalTemplate4();
		soft8.assertEquals(getFederalTaxTotalTemplate4, "342.75");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getFederalTaxTotalTemplate5 = paystubTemplate5.getFederalTaxTotalTemplate5();
		soft8.assertEquals(getFederalTaxTotalTemplate5, "342.75");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getFederalTaxTotalTemplate6 = paystubTemplate6.getFederalTaxTotalTemplate6();
		soft8.assertEquals(getFederalTaxTotalTemplate6, "342.75");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectExemptions("9");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "302.25");
		soft8.assertEquals(FederalTaxTotal, "302.25");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getFederalTaxTotalTemplate2 = paystubTemplate2.getFederalTaxTotalTemplate2();
		soft8.assertEquals(getFederalTaxTotalTemplate2, "302.25");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getFederalTaxTotalTemplate3 = paystubTemplate3.getFederalTaxTotalTemplate3();
		soft8.assertEquals(getFederalTaxTotalTemplate3, "302.25");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getFederalTaxTotalTemplate4 = paystubTemplate4.getFederalTaxTotalTemplate4();
		soft8.assertEquals(getFederalTaxTotalTemplate4, "302.25");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getFederalTaxTotalTemplate5 = paystubTemplate5.getFederalTaxTotalTemplate5();
		soft8.assertEquals(getFederalTaxTotalTemplate5, "302.25");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getFederalTaxTotalTemplate6 = paystubTemplate6.getFederalTaxTotalTemplate6();
		soft8.assertEquals(getFederalTaxTotalTemplate6, "302.25");

		soft8.assertAll();
	}

	@Test(priority = 9, description = "9. Verify State tax calculations for all states with martial status as 'Married' with ytdtotal as '800' and year is 2022")
	public void VerifyStateTaxCalculationsWithAllStatesOnTemplate1() throws InterruptedException {
		SoftAssert soft9 = new SoftAssert();
	//	browserdriver.navigate().refresh();
//		String state = browserdriver.manage().window().getPosition().getX() == 0 && browserdriver.manage().window().getPosition().getY() == 0 && browserdriver.manage().window().getSize().getWidth()==Toolkit.getDefaultToolkit().getScreenSize().getWidth()&&browserdriver.manage().window().getSize().getHeight() == Toolkit.getDefaultToolkit().getScreenSize().getHeight() ? "maximized" : "normal";if (state.equals("normal")) {browserdriver.manage().window().maximize();}
		PaystubWebFormPage.selectEmployee_Marital_Status("Married");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "10");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80");
		// Alabama
		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Alabama");
		String StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "5.33");
		soft9.assertEquals(StateTaxTotal, "5.33", "Wrong State Tax for state Alabama");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		String getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "5.33");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		String getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "5.33");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		String getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "5.33");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		String getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "5.33");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		String getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "5.33");

		// For Alaska
		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Alaska");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Alaska");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "0.00");
		// Arizona
		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Arizona");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Arizona");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Arkansas");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "10.17");
		soft9.assertEquals(StateTaxTotal, "10.17", "Wrong State Tax for state Arkansas");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "10.17");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "10.17");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "10.17");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "10.17");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "10.17");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("California");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state California");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Colorado");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Colorado");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Connecticut");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "24.00");
		soft9.assertEquals(StateTaxTotal, "24.00", "Wrong State Tax for state Connecticut");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "24.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "24.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "24.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "24.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "24.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Delaware");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "2.02");
		soft9.assertEquals(StateTaxTotal, "2.02", "Wrong State Tax for state Delaware");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "2.02");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "2.02");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "2.02");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "2.02");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "2.02");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("District Of Columbia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state District Of Columbia");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Florida");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Florida");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Georgia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "5.67");
		soft9.assertEquals(StateTaxTotal, "5.67", "Wrong State Tax for state Georgia");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "5.67");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "5.67");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "5.67");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "5.67");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "5.67");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Hawaii");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "6.67");
		soft9.assertEquals(StateTaxTotal, "6.67", "Wrong State Tax for state Hawaii");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "6.67");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "6.67");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "6.67");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "6.67");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "6.67");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Idaho");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Idaho");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Illinois");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "39.60");
		soft9.assertEquals(StateTaxTotal, "39.60", "Wrong State Tax for state Illinois");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "39.60");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "39.60");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "39.60");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "39.60");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "39.60");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Indiana");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "25.84");
		soft9.assertEquals(StateTaxTotal, "25.84", "Wrong State Tax for state Indiana");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "25.84");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "25.84");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "25.84");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "25.84");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "25.84");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Iowa");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "2.70");
		soft9.assertEquals(StateTaxTotal, "2.70", "Wrong State Tax for state Iowa");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "2.70");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "2.70");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "2.70");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "2.70");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "2.70");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Kansas");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "4.13");
		soft9.assertEquals(StateTaxTotal, "4.13", "Wrong State Tax for state Kansas");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "4.13");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "4.13");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "4.13");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "4.13");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "4.13");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Kentucky");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "16.92");
		soft9.assertEquals(StateTaxTotal, "16.92", "Wrong State Tax for state Kentucky");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "16.92");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "16.92");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "16.92");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "16.92");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "16.92");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Louisiana");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "16.00");
		soft9.assertEquals(StateTaxTotal, "16.00", "Wrong State Tax for state Louisiana");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "16.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "16.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "16.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "16.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "16.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Maine");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Maine");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Maryland");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "15.02");
		soft9.assertEquals(StateTaxTotal, "15.02", "Wrong State Tax for state Maryland");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "15.02");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "15.02");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "15.02");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "15.02");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "15.02");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Massachusetts");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "40.00");
		soft9.assertEquals(StateTaxTotal, "40.00", "Wrong State Tax for state Massachusetts");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "40.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "40.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "40.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "40.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "40.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Michigan");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "34.00");
		soft9.assertEquals(StateTaxTotal, "34.00", "Wrong State Tax for state Michigan");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "34.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "34.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "34.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "34.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "34.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Minnesota");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Minnesota");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Mississippi");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "2.50");
		soft9.assertEquals(StateTaxTotal, "2.50", "Wrong State Tax for state Mississippi");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "2.50");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "2.50");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "2.50");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "2.50");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "2.50");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Missouri");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Missouri");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Montana");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Montana");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Nebraska");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Nebraska");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Nevada");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Nevada");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("New Hampshire");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state New Hampshire");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("New Jersey");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "11.20");
		soft9.assertEquals(StateTaxTotal, "11.20", "Wrong State Tax for state New Jersey");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "11.20");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "11.20");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "11.20");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "11.20");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "11.20");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("New Mexico");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state New Mexico");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("New York");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state New York");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("North Carolina");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state North Carolina");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("North Dakota");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state North Dakota");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Ohio");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Ohio");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Oklahoma");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Oklahoma");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Oregon");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "18.84");
		soft9.assertEquals(StateTaxTotal, "18.84", "Wrong State Tax for state Oregon");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "18.84");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "18.84");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "18.84");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "18.84");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "18.84");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Pennsylvania");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "24.56");
		soft9.assertEquals(StateTaxTotal, "24.56", "Wrong State Tax for state Pennsylvania");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "24.56");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "24.56");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "24.56");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "24.56");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "24.56");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Rhode Island");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Rhode Island");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("South Carolina");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state South Carolina");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("South Dakota");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state South Dakota");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Tennessee");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Tennessee");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Texas");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Texas");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Utah");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "39.60");
		soft9.assertEquals(StateTaxTotal, "39.60", "Wrong State Tax for state Utah");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "39.60");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "39.60");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "39.60");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "39.60");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "39.60");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Vermont");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Vermont");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Virginia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "1.00");
		soft9.assertEquals(StateTaxTotal, "1.00", "Wrong State Tax for state Virginia");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "1.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "1.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "1.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "1.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "1.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Washington");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Washington");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("West Virginia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "24.00");
		soft9.assertEquals(StateTaxTotal, "24.00", "Wrong State Tax for state Virginia");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "24.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "24.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "24.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "24.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "24.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Wisconsin");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Wisconsin");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Wyomin"); // correct state is Wyoming need to fix this.
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Wyomin");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft9.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft9.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft9.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft9.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft9.assertEquals(getStateTaxTotalTemplate6, "0.00");
		soft9.assertAll();
	}

	@Test(priority = 10, description = "10. Verify State tax calculations for all states with martial status as 'Single' with ytdtotal as '800' and year is 2022")
	public void VerifyStateTaxCalculationsWithAllStatesWithSingleOnTemplate1() throws InterruptedException {
		SoftAssert soft10 = new SoftAssert();
		//browserdriver.navigate().refresh();
		// String state = browserdriver.manage().window().getPosition().getX() == 0 &&
		// browserdriver.manage().window().getPosition().getY() == 0 &&
		// browserdriver.manage().window().getSize().getWidth()==Toolkit.getDefaultToolkit().getScreenSize().getWidth()&&browserdriver.manage().window().getSize().getHeight()
		// == Toolkit.getDefaultToolkit().getScreenSize().getHeight() ? "maximized" :
		// "normal";if (state.equals("normal"))
		// {browserdriver.manage().window().maximize();}
		
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "10");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80");
		// Alabama
		PaystubWebFormPage.selectEmployee_State("Alabama");
		String StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "26.25");
		soft10.assertEquals(StateTaxTotal, "26.25", "Wrong State Tax for state Alabama");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		String getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "26.25");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		String getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "26.25");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		String getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "26.25");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		String getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "26.25");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		String getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "26.25");

		// For Alaska
		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Alaska");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Alaska");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "0.00");
		// Arizona
		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Arizona");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Arizona");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Arkansas");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "17.50");
		soft10.assertEquals(StateTaxTotal, "17.50", "Wrong State Tax for state Arkansas");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "17.50");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "17.50");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "17.50");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "17.50");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "17.50");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("California");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "4.00");
		soft10.assertEquals(StateTaxTotal, "4.00", "Wrong State Tax for state California");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "4.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "4.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "4.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "4.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "4.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Colorado");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Colorado");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Connecticut");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "24.00");
		soft10.assertEquals(StateTaxTotal, "24.00", "Wrong State Tax for state Connecticut");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "24.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "24.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "24.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "24.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "24.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Delaware");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "9.89");
		soft10.assertEquals(StateTaxTotal, "9.89", "Wrong State Tax for state Delaware");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "9.89");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "9.89");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "9.89");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "9.89");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "9.89");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("District Of Columbia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state District Of Columbia");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Florida");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Florida");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Georgia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "11.04");
		soft10.assertEquals(StateTaxTotal, "11.04", "Wrong State Tax for state Georgia");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "11.04");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "11.04");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "11.04");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "11.04");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "11.04");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Hawaii");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "21.12");
		soft10.assertEquals(StateTaxTotal, "21.12", "Wrong State Tax for state Hawaii");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "21.12");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "21.12");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "21.12");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "21.12");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "21.12");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Idaho");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Idaho");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Illinois");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "39.60");
		soft10.assertEquals(StateTaxTotal, "39.60", "Wrong State Tax for state Illinois");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "39.60");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "39.60");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "39.60");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "39.60");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "39.60");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Indiana");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "25.84");
		soft10.assertEquals(StateTaxTotal, "25.84", "Wrong State Tax for state Indiana");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "25.84");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "25.84");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "25.84");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "25.84");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "25.84");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Iowa");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "9.43");
		soft10.assertEquals(StateTaxTotal, "9.43", "Wrong State Tax for state Iowa");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "9.43");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "9.43");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "9.43");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "9.43");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "9.43");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Kansas");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "15.76");
		soft10.assertEquals(StateTaxTotal, "15.76", "Wrong State Tax for state Kansas");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "15.76");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "15.76");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "15.76");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "15.76");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "15.76");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Kentucky");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "28.46");
		soft10.assertEquals(StateTaxTotal, "28.46", "Wrong State Tax for state Kentucky");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "28.46");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "28.46");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "28.46");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "28.46");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "28.46");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Louisiana");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "14.80");
		soft10.assertEquals(StateTaxTotal, "14.80", "Wrong State Tax for state Louisiana");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "14.80");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "14.80");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "14.80");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "14.80");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "14.80");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Maine");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Maine");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Maryland");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "24.32");
		soft10.assertEquals(StateTaxTotal, "24.32", "Wrong State Tax for state Maryland");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "24.32");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "24.32");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "24.32");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "24.32");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "24.32");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Massachusetts");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "40.00");
		soft10.assertEquals(StateTaxTotal, "40.00", "Wrong State Tax for state Massachusetts");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "40.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "40.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "40.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "40.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "40.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Michigan");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "34.00");
		soft10.assertEquals(StateTaxTotal, "34.00", "Wrong State Tax for state Michigan");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "34.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "34.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "34.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "34.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "34.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Minnesota");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Minnesota");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Mississippi");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "10.17");
		soft10.assertEquals(StateTaxTotal, "10.17", "Wrong State Tax for state Mississippi");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "10.17");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "10.17");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "10.17");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "10.17");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "10.17");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Missouri");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Missouri");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Montana");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "5.37");
		soft10.assertEquals(StateTaxTotal, "5.37", "Wrong State Tax for state Montana");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "5.37");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "5.37");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "5.37");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "5.37");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "5.37");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Nebraska");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "4.61");
		soft10.assertEquals(StateTaxTotal, "4.61", "Wrong State Tax for state Nebraska");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "4.61");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "4.61");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "4.61");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "4.61");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "4.61");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Nevada");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Nevada");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("New Hampshire");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state New Hampshire");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("New Jersey");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "11.20");
		soft10.assertEquals(StateTaxTotal, "11.20", "Wrong State Tax for state New Jersey");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "11.20");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "11.20");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "11.20");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "11.20");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "11.20");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("New Mexico");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state New Mexico");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("New York");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "5.33");
		soft10.assertEquals(StateTaxTotal, "5.33", "Wrong State Tax for state New York");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "5.33");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "5.33");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "5.33");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "5.33");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "5.33");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("North Carolina");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state North Carolina");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("North Dakota");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state North Dakota");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Ohio");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Ohio");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Oklahoma");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "2.24");
		soft10.assertEquals(StateTaxTotal, "2.24", "Wrong State Tax for state Oklahoma");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "2.24");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "2.24");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "2.24");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "2.24");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "2.24");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Oregon");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "34.30");
		soft10.assertEquals(StateTaxTotal, "34.30", "Wrong State Tax for state Oregon");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "34.30");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "34.30");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "34.30");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "34.30");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "34.30");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Pennsylvania");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "24.56");
		soft10.assertEquals(StateTaxTotal, "24.56", "Wrong State Tax for state Pennsylvania");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "24.56");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "24.56");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "24.56");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "24.56");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "24.56");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Rhode Island");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.94");
		soft10.assertEquals(StateTaxTotal, "0.94", "Wrong State Tax for state Rhode Island");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "0.94");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "0.94");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "0.94");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "0.94");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "0.94");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("South Carolina");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state South Carolina");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("South Dakota");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state South Dakota");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Tennessee");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Tennessee");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Texas");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Texas");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Utah");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "39.60");
		soft10.assertEquals(StateTaxTotal, "39.60", "Wrong State Tax for state Utah");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "39.60");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "39.60");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "39.60");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "39.60");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "39.60");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Vermont");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "9.07");
		soft10.assertEquals(StateTaxTotal, "9.07", "Wrong State Tax for state Vermont");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "9.07");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "9.07");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "9.07");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "9.07");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "9.07");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Virginia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "10.42");
		soft10.assertEquals(StateTaxTotal, "10.42", "Wrong State Tax for state Virginia");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "10.42");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "10.42");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "10.42");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "10.42");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "10.42");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Washington");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Washington");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("West Virginia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "24.00");
		soft10.assertEquals(StateTaxTotal, "24.00", "Wrong State Tax for state Virginia");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "24.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "24.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "24.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "24.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "24.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Wisconsin");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Wisconsin");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Wyomin"); // correct state is Wyoming need to fix this.
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Wyomin");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft10.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft10.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft10.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft10.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft10.assertEquals(getStateTaxTotalTemplate6, "0.00");
		soft10.assertAll();
	}

	@Test(priority = 11, description = "11. Verify State tax calculations for all states with martial status as 'Single' with ytdtotal as '8000' and year is 2022")
	public void VerifyStateTaxCalculationsWithAllStatesWithSingle2OnTemplate1() throws InterruptedException {
		SoftAssert soft11 = new SoftAssert();
		//browserdriver.navigate().refresh();
		// String state = browserdriver.manage().window().getPosition().getX() == 0 &&
		// browserdriver.manage().window().getPosition().getY() == 0 &&
		// browserdriver.manage().window().getSize().getWidth()==Toolkit.getDefaultToolkit().getScreenSize().getWidth()&&browserdriver.manage().window().getSize().getHeight()
		// == Toolkit.getDefaultToolkit().getScreenSize().getHeight() ? "maximized" :
		// "normal";if (state.equals("normal"))
		// {browserdriver.manage().window().maximize();}
		// PaystubWebFormPage.selectEmployee_Marital_Status("Married");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "10");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800");
		// Alabama
		PaystubWebFormPage.selectEmployee_State("Alabama");
		String StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "386.25");
		soft11.assertEquals(StateTaxTotal, "386.25", "Wrong State Tax for state Alabama");

		// For Alaska
		PaystubWebFormPage.selectEmployee_State("Alaska");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft11.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Alaska");
		// Arizona
		PaystubWebFormPage.selectEmployee_State("Arizona");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "232.75");//
		soft11.assertEquals(StateTaxTotal, "232.75", "Wrong State Tax for state Arizona");

		PaystubWebFormPage.selectEmployee_State("Arkansas");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "412.13");
		soft11.assertEquals(StateTaxTotal, "412.13", "Wrong State Tax for state Arkansas");

		PaystubWebFormPage.selectEmployee_State("California");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "456.97");
		soft11.assertEquals(StateTaxTotal, "456.97", "Wrong State Tax for state California");

		PaystubWebFormPage.selectEmployee_State("Colorado");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "314.90");
		soft11.assertEquals(StateTaxTotal, "314.90", "Wrong State Tax for state Colorado");

		PaystubWebFormPage.selectEmployee_State("Connecticut");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "402.50");
		soft11.assertEquals(StateTaxTotal, "402.50", "Wrong State Tax for state Connecticut");

		PaystubWebFormPage.selectEmployee_State("Delaware");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "425.42");
		soft11.assertEquals(StateTaxTotal, "425.42", "Wrong State Tax for state Delaware");

		PaystubWebFormPage.selectEmployee_State("District Of Columbia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "454.94");
		soft11.assertEquals(StateTaxTotal, "454.94", "Wrong State Tax for state District Of Columbia");

		PaystubWebFormPage.selectEmployee_State("Florida");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft11.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Florida");

		PaystubWebFormPage.selectEmployee_State("Georgia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "423.58");
		soft11.assertEquals(StateTaxTotal, "423.58", "Wrong State Tax for state Georgia");

		PaystubWebFormPage.selectEmployee_State("Hawaii");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "582.68");
		soft11.assertEquals(StateTaxTotal, "582.68", "Wrong State Tax for state Hawaii");

		PaystubWebFormPage.selectEmployee_State("Idaho");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "396.73");
		soft11.assertEquals(StateTaxTotal, "396.73", "Wrong State Tax for state Idaho");

		PaystubWebFormPage.selectEmployee_State("Illinois");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "396.00");
		soft11.assertEquals(StateTaxTotal, "396.00", "Wrong State Tax for state Illinois");

		PaystubWebFormPage.selectEmployee_State("Indiana");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "258.40");
		soft11.assertEquals(StateTaxTotal, "258.40", "Wrong State Tax for state Indiana");

		PaystubWebFormPage.selectEmployee_State("Iowa");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "492.43");
		soft11.assertEquals(StateTaxTotal, "492.43", "Wrong State Tax for state Iowa");

		PaystubWebFormPage.selectEmployee_State("Kansas");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "401.25");
		soft11.assertEquals(StateTaxTotal, "401.25", "Wrong State Tax for state Kansas");

		PaystubWebFormPage.selectEmployee_State("Kentucky");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "388.46");
		soft11.assertEquals(StateTaxTotal, "388.46", "Wrong State Tax for state Kentucky");

		PaystubWebFormPage.selectEmployee_State("Louisiana");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "291.56");
		soft11.assertEquals(StateTaxTotal, "291.56", "Wrong State Tax for state Louisiana");

		PaystubWebFormPage.selectEmployee_State("Maine");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "458.48");
		soft11.assertEquals(StateTaxTotal, "458.48", "Wrong State Tax for state Maine");

		PaystubWebFormPage.selectEmployee_State("Maryland");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "366.32");
		soft11.assertEquals(StateTaxTotal, "366.32", "Wrong State Tax for state Maryland");

		PaystubWebFormPage.selectEmployee_State("Massachusetts");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "400.00");
		soft11.assertEquals(StateTaxTotal, "400.00", "Wrong State Tax for state Massachusetts");

		PaystubWebFormPage.selectEmployee_State("Michigan");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "340.00");
		soft11.assertEquals(StateTaxTotal, "340.00", "Wrong State Tax for state Michigan");

		PaystubWebFormPage.selectEmployee_State("Minnesota");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "436.97");
		soft11.assertEquals(StateTaxTotal, "436.97", "Wrong State Tax for state Minnesota");

		PaystubWebFormPage.selectEmployee_State("Mississippi");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "367.92");
		soft11.assertEquals(StateTaxTotal, "367.92", "Wrong State Tax for state Mississippi");

		PaystubWebFormPage.selectEmployee_State("Missouri");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "358.00");
		soft11.assertEquals(StateTaxTotal, "358.00", "Wrong State Tax for state Missouri");

		PaystubWebFormPage.selectEmployee_State("Montana");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "474.29");
		soft11.assertEquals(StateTaxTotal, "474.29", "Wrong State Tax for state Montana");

		PaystubWebFormPage.selectEmployee_State("Nebraska");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "425.96");
		soft11.assertEquals(StateTaxTotal, "425.96", "Wrong State Tax for state Nebraska");

		PaystubWebFormPage.selectEmployee_State("Nevada");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft11.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Nevada");

		PaystubWebFormPage.selectEmployee_State("New Hampshire");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft11.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state New Hampshire");

		PaystubWebFormPage.selectEmployee_State("New Jersey");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "332.41");
		soft11.assertEquals(StateTaxTotal, "332.41", "Wrong State Tax for state New Jersey");

		PaystubWebFormPage.selectEmployee_State("New Mexico");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "315.83");
		soft11.assertEquals(StateTaxTotal, "315.83", "Wrong State Tax for state New Mexico");

		PaystubWebFormPage.selectEmployee_State("New York");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "413.65");
		soft11.assertEquals(StateTaxTotal, "413.65", "Wrong State Tax for state New York");

		PaystubWebFormPage.selectEmployee_State("North Carolina");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "346.18");
		soft11.assertEquals(StateTaxTotal, "346.18", "Wrong State Tax for state North Carolina");

		PaystubWebFormPage.selectEmployee_State("North Dakota");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "109.44");
		soft11.assertEquals(StateTaxTotal, "109.44", "Wrong State Tax for state North Dakota");

		PaystubWebFormPage.selectEmployee_State("Ohio");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "186.38");
		soft11.assertEquals(StateTaxTotal, "186.38", "Wrong State Tax for state Ohio");

		PaystubWebFormPage.selectEmployee_State("Oklahoma");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "339.16");
		soft11.assertEquals(StateTaxTotal, "339.16", "Wrong State Tax for state Oklahoma");

		PaystubWebFormPage.selectEmployee_State("Oregon");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "660.94");
		soft11.assertEquals(StateTaxTotal, "660.94", "Wrong State Tax for state Oregon");

		PaystubWebFormPage.selectEmployee_State("Pennsylvania");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "245.60");
		soft11.assertEquals(StateTaxTotal, "245.60", "Wrong State Tax for state Pennsylvania");

		PaystubWebFormPage.selectEmployee_State("Rhode Island");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "286.35");
		soft11.assertEquals(StateTaxTotal, "286.35", "Wrong State Tax for state Rhode Island");

		PaystubWebFormPage.selectEmployee_State("South Carolina");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "439.05");
		soft11.assertEquals(StateTaxTotal, "439.05", "Wrong State Tax for state South Carolina");

		PaystubWebFormPage.selectEmployee_State("South Dakota");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft11.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state South Dakota");

		PaystubWebFormPage.selectEmployee_State("Tennessee");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft11.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Tennessee");

		PaystubWebFormPage.selectEmployee_State("Texas");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft11.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Texas");

		PaystubWebFormPage.selectEmployee_State("Utah");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "396.00");
		soft11.assertEquals(StateTaxTotal, "396.00", "Wrong State Tax for state Utah");

		PaystubWebFormPage.selectEmployee_State("Vermont");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "382.17");
		soft11.assertEquals(StateTaxTotal, "382.17", "Wrong State Tax for state Vermont");

		PaystubWebFormPage.selectEmployee_State("Virginia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "416.98");
		soft11.assertEquals(StateTaxTotal, "416.98", "Wrong State Tax for state Virginia");

		PaystubWebFormPage.selectEmployee_State("Washington");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft11.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Washington");

		PaystubWebFormPage.selectEmployee_State("West Virginia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "426.25");
		soft11.assertEquals(StateTaxTotal, "426.25", "Wrong State Tax for state Virginia");

		PaystubWebFormPage.selectEmployee_State("Wisconsin");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "346.30");
		soft11.assertEquals(StateTaxTotal, "346.30", "Wrong State Tax for state Wisconsin");

		PaystubWebFormPage.selectEmployee_State("Wyomin"); // correct state is Wyoming need to fix this.
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft11.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft11.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Wyomin");
		soft11.assertAll();
	}

	@Test(priority = 12, description = "12. Verify State tax calculations for all states with martial status as 'Married' with ytdtotal as '8000' and year is 2022")
	public void VerifyStateTaxCalculationsWithAllStatesWithMarriedOnTemplate1() throws InterruptedException {
		SoftAssert soft12 = new SoftAssert();
//		browserdriver.navigate().refresh();
//		String state = browserdriver.manage().window().getPosition().getX() == 0
//				&& browserdriver.manage().window().getPosition().getY() == 0
//				&& browserdriver.manage().window().getSize().getWidth() == Toolkit.getDefaultToolkit().getScreenSize()
//						.getWidth()
//				&& browserdriver.manage().window().getSize().getHeight() == Toolkit.getDefaultToolkit().getScreenSize()
//						.getHeight() ? "maximized" : "normal";
//		if (state.equals("normal")) {
//			browserdriver.manage().window().maximize();
//		}
		PaystubWebFormPage.selectEmployee_Marital_Status("Married");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "10");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800");
		// Alabama
		PaystubWebFormPage.selectEmployee_State("Alabama");
		String StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "362.08");
		soft12.assertEquals(StateTaxTotal, "362.08", "Wrong State Tax for state Alabama");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		String getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "362.08");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		String getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "362.08");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		String getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "362.08");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		String getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "362.08");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		String getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "362.08");

		// For Alaska
		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Alaska");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft12.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Alaska");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "0.00");
		// Arizona
		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Arizona");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "160.35");
		soft12.assertEquals(StateTaxTotal, "160.35", "Wrong State Tax for state Arizona");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "160.35");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "160.35");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "160.35");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "160.35");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "160.35");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Arkansas");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "429.74");
		soft12.assertEquals(StateTaxTotal, "429.74", "Wrong State Tax for state Arkansas");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "429.74");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "429.74");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "429.74");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "429.74");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "429.74");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("California");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "235.10");
		soft12.assertEquals(StateTaxTotal, "235.10", "Wrong State Tax for state California");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "235.10");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "235.10");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "235.10");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "235.10");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "235.10");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Colorado");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "265.80");
		soft12.assertEquals(StateTaxTotal, "265.80", "Wrong State Tax for state Colorado");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "265.80");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "265.80");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "265.80");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "265.80");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "265.80");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Connecticut");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "366.67");
		soft12.assertEquals(StateTaxTotal, "366.67", "Wrong State Tax for state Connecticut");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "366.67");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "366.67");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "366.67");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "366.67");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "366.67");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Delaware");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "407.54");
		soft12.assertEquals(StateTaxTotal, "407.54", "Wrong State Tax for state Delaware");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "407.54");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "407.54");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "407.54");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "407.54");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "407.54");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("District Of Columbia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "363.21");
		soft12.assertEquals(StateTaxTotal, "363.21", "Wrong State Tax for state District Of Columbia");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "363.21");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "363.21");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "363.21");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "363.21");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "363.21");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Florida");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft12.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Florida");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Georgia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "411.67");
		soft12.assertEquals(StateTaxTotal, "411.67", "Wrong State Tax for state Georgia");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "411.67");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "411.67");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "411.67");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "411.67");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "411.67");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Hawaii");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "506.63");
		soft12.assertEquals(StateTaxTotal, "506.63", "Wrong State Tax for state Hawaii");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "506.63");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "506.63");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "506.63");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "506.63");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "506.63");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Idaho");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "313.45");
		soft12.assertEquals(StateTaxTotal, "313.45", "Wrong State Tax for state Idaho");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "313.45");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "313.45");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "313.45");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "313.45");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "313.45");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Illinois");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "396.00");
		soft12.assertEquals(StateTaxTotal, "396.00", "Wrong State Tax for state Illinois");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "396.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "396.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "396.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "396.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "396.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Indiana");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "258.40");
		soft12.assertEquals(StateTaxTotal, "258.40", "Wrong State Tax for state Indiana");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "258.40");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "258.40");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "258.40");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "258.40");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "258.40");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Iowa");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "469.40");
		soft12.assertEquals(StateTaxTotal, "469.40", "Wrong State Tax for state Iowa");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "469.40");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "469.40");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "469.40");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "469.40");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "469.40");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Kansas");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "341.75");
		soft12.assertEquals(StateTaxTotal, "341.75", "Wrong State Tax for state Kansas");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "341.75");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "341.75");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "341.75");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "341.75");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "341.75");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Kentucky");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "376.92");
		soft12.assertEquals(StateTaxTotal, "376.92", "Wrong State Tax for state Kentucky");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "376.92");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "376.92");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "376.92");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "376.92");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "376.92");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Louisiana");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "278.33");
		soft12.assertEquals(StateTaxTotal, "278.33", "Wrong State Tax for state Louisiana");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "278.33");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "278.33");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "278.33");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "278.33");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "278.33");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Maine");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "357.90");
		soft12.assertEquals(StateTaxTotal, "357.90", "Wrong State Tax for state Maine");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "357.90");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "357.90");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "357.90");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "357.90");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "357.90");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Maryland");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "357.02");
		soft12.assertEquals(StateTaxTotal, "357.02", "Wrong State Tax for state Maryland");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "357.02");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "357.02");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "357.02");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "357.02");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "357.02");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Massachusetts");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "400.00");
		soft12.assertEquals(StateTaxTotal, "400.00", "Wrong State Tax for state Massachusetts");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "400.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "400.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "400.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "400.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "400.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Michigan");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "340.00");
		soft12.assertEquals(StateTaxTotal, "340.00", "Wrong State Tax for state Michigan");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "340.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "340.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "340.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "340.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "340.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Minnesota");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "348.20");
		soft12.assertEquals(StateTaxTotal, "348.20", "Wrong State Tax for state Minnesota");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "348.20");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "348.20");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "348.20");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "348.20");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "348.20");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Mississippi");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "358.33");
		soft12.assertEquals(StateTaxTotal, "358.33", "Wrong State Tax for state Mississippi");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "358.33");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "358.33");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "358.33");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "358.33");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "358.33");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Missouri");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "299.72");
		soft12.assertEquals(StateTaxTotal, "299.72", "Wrong State Tax for state Missouri");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "299.72");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "299.72");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "299.72");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "299.72");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "299.72");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Montana");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "446.52");
		soft12.assertEquals(StateTaxTotal, "446.52", "Wrong State Tax for state Montana");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "446.52");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "446.52");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "446.52");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "446.52");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "446.52");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Nebraska");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "304.72");
		soft12.assertEquals(StateTaxTotal, "304.72", "Wrong State Tax for state Nebraska");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "304.72");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "304.72");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "304.72");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "304.72");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "304.72");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Nevada");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft12.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Nevada");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("New Hampshire");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft12.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state New Hampshire");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("New Jersey");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "210.75");
		soft12.assertEquals(StateTaxTotal, "210.75", "Wrong State Tax for state New Jersey");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "210.75");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "210.75");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "210.75");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "210.75");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "210.75");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("New Mexico");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "252.24");
		soft12.assertEquals(StateTaxTotal, "252.24", "Wrong State Tax for state New Mexico");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "252.24");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "252.24");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "252.24");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "252.24");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "252.24");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("New York");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "353.91");
		soft12.assertEquals(StateTaxTotal, "353.91", "Wrong State Tax for state New York");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "353.91");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "353.91");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "353.91");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "353.91");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "353.91");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("North Carolina");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "293.16");
		soft12.assertEquals(StateTaxTotal, "293.16", "Wrong State Tax for state North Carolina");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "293.16");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "293.16");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "293.16");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "293.16");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "293.16");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("North Dakota");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "66.14");
		soft12.assertEquals(StateTaxTotal, "66.14", "Wrong State Tax for state North Dakota");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "66.14");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "66.14");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "66.14");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "66.14");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "66.14");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Ohio");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "186.38");
		soft12.assertEquals(StateTaxTotal, "186.38", "Wrong State Tax for state Ohio");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "186.38");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "186.38");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "186.38");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "186.38");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "186.38");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Oklahoma");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "300.15");
		soft12.assertEquals(StateTaxTotal, "300.15", "Wrong State Tax for state Oklahoma");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "300.15");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "300.15");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "300.15");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "300.15");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "300.15");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Oregon");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "621.88");
		soft12.assertEquals(StateTaxTotal, "621.88", "Wrong State Tax for state Oregon");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "621.88");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "621.88");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "621.88");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "621.88");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "621.88");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Pennsylvania");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "245.60");
		soft12.assertEquals(StateTaxTotal, "245.60", "Wrong State Tax for state Pennsylvania");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "245.60");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "245.60");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "245.60");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "245.60");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "245.60");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Rhode Island");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "249.54");
		soft12.assertEquals(StateTaxTotal, "249.54", "Wrong State Tax for state Rhode Island");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "249.54");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "249.54");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "249.54");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "249.54");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "249.54");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("South Carolina");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "363.51");
		soft12.assertEquals(StateTaxTotal, "363.51", "Wrong State Tax for state South Carolina");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "363.51");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "363.51");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "363.51");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "363.51");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "363.51");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("South Dakota");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft12.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state South Dakota");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Tennessee");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft12.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Tennessee");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Texas");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft12.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Texas");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Utah");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "396.00");
		soft12.assertEquals(StateTaxTotal, "396.00", "Wrong State Tax for state Utah");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "396.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "396.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "396.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "396.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "396.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Vermont");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "272.90");
		soft12.assertEquals(StateTaxTotal, "272.90", "Wrong State Tax for state Vermont");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "272.90");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "272.90");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "272.90");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "272.90");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "272.90");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Virginia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "395.42");
		soft12.assertEquals(StateTaxTotal, "395.42", "Wrong State Tax for state Virginia");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "395.42");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "395.42");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "395.42");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "395.42");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "395.42");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Washington");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft12.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Washington");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "0.00");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("West Virginia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "426.25");
		soft12.assertEquals(StateTaxTotal, "426.25", "Wrong State Tax for state Virginia");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "426.25");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "426.25");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "426.25");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "426.25");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "426.25");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Wisconsin");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "293.46");
		soft12.assertEquals(StateTaxTotal, "293.46", "Wrong State Tax for state Wisconsin");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "293.46");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "293.46");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "293.46");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "293.46");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "293.46");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.selectEmployee_State("Wyomin"); // correct state is Wyoming need to fix this.
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft12.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Wyomin");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getStateTaxTotalTemplate2 = paystubTemplate2.getStateTaxTotalTemplate2();
		soft12.assertEquals(getStateTaxTotalTemplate2, "0.00");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getStateTaxTotalTemplate3 = paystubTemplate3.getStateTaxTotalTemplate3();
		soft12.assertEquals(getStateTaxTotalTemplate3, "0.00");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getStateTaxTotalTemplate4 = paystubTemplate4.getStateTaxTotalTemplate4();
		soft12.assertEquals(getStateTaxTotalTemplate4, "0.00");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getStateTaxTotalTemplate5 = paystubTemplate5.getStateTaxTotalTemplate5();
		soft12.assertEquals(getStateTaxTotalTemplate5, "0.00");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getStateTaxTotalTemplate6 = paystubTemplate6.getStateTaxTotalTemplate6();
		soft12.assertEquals(getStateTaxTotalTemplate6, "0.00");
		soft12.assertAll();
	}

	@Test(priority = 13, dataProvider = "sdiStates", description = "13. Verify SDI tax calculations with martial status as 'Single' for the state= 'California' with ytdtotal as '400','800','8000','80000'")
	public void VerifySDITaxCalculationsonTemplate1(String states) throws InterruptedException {
		SoftAssert soft13 = new SoftAssert();
	//	browserdriver.navigate().refresh();
//		String state = browserdriver.manage().window().getPosition().getX() == 0 && browserdriver.manage().window().getPosition().getY() == 0 && browserdriver.manage().window().getSize().getWidth()==Toolkit.getDefaultToolkit().getScreenSize().getWidth()&&browserdriver.manage().window().getSize().getHeight() == Toolkit.getDefaultToolkit().getScreenSize().getHeight() ? "maximized" : "normal";if (state.equals("normal")) {browserdriver.manage().window().maximize();}
		PaystubWebFormPage.selectEmployee_State(states);
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "10");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40"); // YtdTotal = 400
		if (states == "California") {
			soft13.assertEquals(getTextValueOfWebElementID("sdi_total"), "4.80");
			soft13.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "4.80");

			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80"); // YtdTotal = 800
			soft13.assertEquals(getTextValueOfWebElementID("sdi_total"), "9.60");
			soft13.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "9.60");

			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800"); // YtdTotal = 8000
			soft13.assertEquals(getTextValueOfWebElementID("sdi_total"), "96.00");
			soft13.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "96.00");

			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8000"); // YtdTotal = 80000
			soft13.assertEquals(getTextValueOfWebElementID("sdi_total"), "960.00");
			soft13.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "960.00");
			paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
			String getSDITaxTotalTemplate2 = paystubTemplate2.getSDITaxTotalTemplate2();
			soft13.assertEquals(getSDITaxTotalTemplate2, "960.00");
			paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
			String getSDITaxTotalTemplate3 = paystubTemplate3.getSDITaxTotalTemplate3();
			soft13.assertEquals(getSDITaxTotalTemplate3, "960.00");
			paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
			String getSDITaxTotalTemplate4 = paystubTemplate4.getSDITaxTotalTemplate4();
			soft13.assertEquals(getSDITaxTotalTemplate4, "960.00");
			paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
			String getSDITaxTotalTemplate5 = paystubTemplate5.getSDITaxTotalTemplate5();
			soft13.assertEquals(getSDITaxTotalTemplate5, "960.00");
			paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
			String getSDITaxTotalTemplate6 = paystubTemplate6.getSDITaxTotalTemplate6();
			soft13.assertEquals(getSDITaxTotalTemplate6, "960.00");
		} else if (states == "Hawaii") {
			soft13.assertEquals(getTextValueOfWebElementID("sdi_total"), "2.00");
			soft13.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "2.00");

			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80"); // YtdTotal = 800
			soft13.assertEquals(getTextValueOfWebElementID("sdi_total"), "4.00");
			soft13.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "4.00");

			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800"); // YtdTotal = 8000
			soft13.assertEquals(getTextValueOfWebElementID("sdi_total"), "22.04");
			soft13.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "22.04");

			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8000");// YtdTotal = 80000
			soft13.assertEquals(getTextValueOfWebElementID("sdi_total"), "22.04");
			soft13.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "22.04");
			paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
			String getSDITaxTotalTemplate2 = paystubTemplate2.getSDITaxTotalTemplate2();
			soft13.assertEquals(getSDITaxTotalTemplate2, "22.04");
			paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
			String getSDITaxTotalTemplate3 = paystubTemplate3.getSDITaxTotalTemplate3();
			soft13.assertEquals(getSDITaxTotalTemplate3, "22.04");
			paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
			String getSDITaxTotalTemplate4 = paystubTemplate4.getSDITaxTotalTemplate4();
			soft13.assertEquals(getSDITaxTotalTemplate4, "22.04");
			paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
			String getSDITaxTotalTemplate5 = paystubTemplate5.getSDITaxTotalTemplate5();
			soft13.assertEquals(getSDITaxTotalTemplate5, "22.04");
			paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
			String getSDITaxTotalTemplate6 = paystubTemplate6.getSDITaxTotalTemplate6();
			soft13.assertEquals(getSDITaxTotalTemplate6, "960.00");
		} else if (states == "New Jersey") {
			soft13.assertEquals(getTextValueOfWebElementID("sdi_total"), "1.88");
			soft13.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "1.88");

			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80"); // YtdTotal = 800
			soft13.assertEquals(getTextValueOfWebElementID("sdi_total"), "3.76");
			soft13.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "3.76");

			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800"); // YtdTotal = 8000
			soft13.assertEquals(getTextValueOfWebElementID("sdi_total"), "37.60");
			soft13.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "37.60");

			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8000"); // YtdTotal = 80000
			soft13.assertEquals(getTextValueOfWebElementID("sdi_total"), "157.45");
			soft13.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "157.45");
		} else if (states == "New York") {
			soft13.assertEquals(getTextValueOfWebElementID("sdi_total"), "2.00");
			soft13.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "2.00");

			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80"); // YtdTotal = 800
			soft13.assertEquals(getTextValueOfWebElementID("sdi_total"), "2.04");
			soft13.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "2.04");

			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800"); // YtdTotal = 8000
			soft13.assertEquals(getTextValueOfWebElementID("sdi_total"), "2.04");
			soft13.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "2.04");

			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8000"); // YtdTotal = 80000
			soft13.assertEquals(getTextValueOfWebElementID("sdi_total"), "2.04");
			soft13.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "2.04");
		} else if (states == "Rhode Island") {
			soft13.assertEquals(getTextValueOfWebElementID("sdi_total"), "4.80");
			soft13.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "4.80");

			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80"); // YtdTotal = 800
			soft13.assertEquals(getTextValueOfWebElementID("sdi_total"), "9.60");
			soft13.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "9.60");

			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800"); // YtdTotal = 8000
			soft13.assertEquals(getTextValueOfWebElementID("sdi_total"), "96.00");
			soft13.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "96.00");

			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8000"); // YtdTotal = 80000
			soft13.assertEquals(getTextValueOfWebElementID("sdi_total"), "817.20");
			soft13.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "817.20");
		}

		soft13.assertAll("The SDI Values are wrong for the state " + states);
	}

	@DataProvider(name = "sdiStates")
	public Object[] sdiStates() {

		Object[] sdiStates = new Object[5];
		sdiStates[0] = "California";
		sdiStates[1] = "Hawaii";
		sdiStates[2] = "New Jersey";
		sdiStates[3] = "New York";
		sdiStates[4] = "Rhode Island";
		return sdiStates;
	}

	@Test(priority = 14, dataProvider = "suiStates", description = "14. Verify SUI tax calculations with martial status as 'Single' with ytdtotal as '400','800','8000','80000'")
	public void Verify_SUI_Tax_Calculations_on_Template1_with_State(String states) throws InterruptedException {
		SoftAssert soft14 = new SoftAssert();
	//	browserdriver.navigate().refresh();
//		String state = browserdriver.manage().window().getPosition().getX() == 0
//				&& browserdriver.manage().window().getPosition().getY() == 0
//				&& browserdriver.manage().window().getSize().getWidth() == Toolkit.getDefaultToolkit().getScreenSize()
//						.getWidth()
//				&& browserdriver.manage().window().getSize().getHeight() == Toolkit.getDefaultToolkit().getScreenSize()
//						.getHeight() ? "maximized" : "normal";
//		if (state.equals("normal")) {
//			browserdriver.manage().window().maximize();
//		}
		PaystubWebFormPage.selectEmployee_State(states);
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "10");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40"); // YtdTotal = 400
		if (states == "Alaska") {
			soft14.assertEquals(getTextValueOfWebElementID("sui_total"), "2.00");
			soft14.assertEquals(paystubTemplate1.getSUITaxTotalTemplate1(), "2.00");
			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80"); // YtdTotal = 800
			soft14.assertEquals(getTextValueOfWebElementID("sui_total"), "4.00");
			soft14.assertEquals(paystubTemplate1.getSUITaxTotalTemplate1(), "4.00");
			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800"); // YtdTotal = 8000
			soft14.assertEquals(getTextValueOfWebElementID("sui_total"), "40.00");
			soft14.assertEquals(paystubTemplate1.getSUITaxTotalTemplate1(), "40.00");
			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8000"); // YtdTotal = 80000
			soft14.assertEquals(getTextValueOfWebElementID("sui_total"), "199.00");
			soft14.assertEquals(paystubTemplate1.getSUITaxTotalTemplate1(), "199.00");
			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80000"); // YtdTotal = 800000
			soft14.assertEquals(getTextValueOfWebElementID("sui_total"), "199.00");
			soft14.assertEquals(paystubTemplate1.getSUITaxTotalTemplate1(), "199.00");

			paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
			String getSUITaxTotalTemplate2 = paystubTemplate2.getSUITaxTotalTemplate2();
			soft14.assertEquals(getSUITaxTotalTemplate2, "199.00");
			paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
			String getSUITaxTotalTemplate3 = paystubTemplate3.getSUITaxTotalTemplate3();
			soft14.assertEquals(getSUITaxTotalTemplate3, "199.00");
			paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
			String getSUITaxTotalTemplate4 = paystubTemplate4.getSUITaxTotalTemplate4();
			soft14.assertEquals(getSUITaxTotalTemplate4, "199.00");
			paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
			String getSUITaxTotalTemplate5 = paystubTemplate5.getSUITaxTotalTemplate5();
			soft14.assertEquals(getSUITaxTotalTemplate5, "199.00");
			paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
			String getSUITaxTotalTemplate6 = paystubTemplate6.getSUITaxTotalTemplate6();
			soft14.assertEquals(getSUITaxTotalTemplate6, "199.00");

		} else if (states == "New Jersey") {
			soft14.assertEquals(getTextValueOfWebElementID("sui_total"), "1.53");
			soft14.assertEquals(paystubTemplate1.getSUITaxTotalTemplate1(), "1.53");
			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80"); // YtdTotal = 800
			soft14.assertEquals(getTextValueOfWebElementID("sui_total"), "3.06");
			soft14.assertEquals(paystubTemplate1.getSUITaxTotalTemplate1(), "3.06");
			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800"); // YtdTotal = 8000
			soft14.assertEquals(getTextValueOfWebElementID("sui_total"), "30.60");
			soft14.assertEquals(paystubTemplate1.getSUITaxTotalTemplate1(), "30.60");
			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8000"); // YtdTotal = 80000
			soft14.assertEquals(getTextValueOfWebElementID("sui_total"), "128.14");
			soft14.assertEquals(paystubTemplate1.getSUITaxTotalTemplate1(), "128.14");
			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80000"); // YtdTotal = 800000
			soft14.assertEquals(getTextValueOfWebElementID("sui_total"), "128.14");
			soft14.assertEquals(paystubTemplate1.getSUITaxTotalTemplate1(), "128.14");
		} else if (states == "Pennsylvania") {
			soft14.assertEquals(getTextValueOfWebElementID("sui_total"), "0.28");
			soft14.assertEquals(paystubTemplate1.getSUITaxTotalTemplate1(), "0.28");
			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80"); // YtdTotal = 800
			soft14.assertEquals(getTextValueOfWebElementID("sui_total"), "0.56");
			soft14.assertEquals(paystubTemplate1.getSUITaxTotalTemplate1(), "0.56");
			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800"); // YtdTotal = 8000
			soft14.assertEquals(getTextValueOfWebElementID("sui_total"), "5.60");
			soft14.assertEquals(paystubTemplate1.getSUITaxTotalTemplate1(), "5.60");
			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8000"); // YtdTotal = 80000
			soft14.assertEquals(getTextValueOfWebElementID("sui_total"), "56.00");
			soft14.assertEquals(paystubTemplate1.getSUITaxTotalTemplate1(), "56.00");
			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80000"); // YtdTotal = 800000
			soft14.assertEquals(getTextValueOfWebElementID("sui_total"), "560.00");
			soft14.assertEquals(paystubTemplate1.getSUITaxTotalTemplate1(), "560.00");
		}
		soft14.assertAll("The SUI Values are wrong for the state " + states);

	}

	@DataProvider(name = "suiStates")
	public Object[] suiStates() {

		Object[] suiStates = new Object[3];
		suiStates[0] = "Alaska";
		suiStates[1] = "New Jersey";
		suiStates[2] = "Pennsylvania";
		return suiStates;
	}

	@Test(priority = 15, description = "15. Verify WC tax calculations with martial status as 'Single' with ytdtotal as '400','800','8000','80000' with all 'How often you paid'")
	public void Verify_WC_Tax_Calculations_on_Template1_with_State() throws InterruptedException {
		SoftAssert soft15 = new SoftAssert();
//		browserdriver.navigate().refresh();
//		String state = browserdriver.manage().window().getPosition().getX() == 0
//				&& browserdriver.manage().window().getPosition().getY() == 0
//				&& browserdriver.manage().window().getSize().getWidth() == Toolkit.getDefaultToolkit().getScreenSize()
//						.getWidth()
//				&& browserdriver.manage().window().getSize().getHeight() == Toolkit.getDefaultToolkit().getScreenSize()
//						.getHeight() ? "maximized" : "normal";
//		if (state.equals("normal")) {
//			browserdriver.manage().window().maximize();
//		}

		PaystubWebFormPage.selectEmployee_State("Oregon");
		// PaystubWebFormPage.select_how_often_you_paid("Monthly (ex: 1st of month
		// only)");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "10");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40"); // YtdTotal = 400
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "0.57");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.57");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80"); // YtdTotal = 800
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "1.13");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "1.13");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800"); // YtdTotal = 8000
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "11.21");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "11.21");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8000"); // YtdTotal = 80000
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "112.01");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "112.01");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80000"); // YtdTotal = 800000
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "1,120.01");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "1,120.01");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		String getWCTaxTotalTemplate2 = paystubTemplate2.getWCTaxTotalTemplate2();
		soft15.assertEquals(getWCTaxTotalTemplate2, "1,120.01");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		String getWCTaxTotalTemplate3 = paystubTemplate3.getWCTaxTotalTemplate3();
		soft15.assertEquals(getWCTaxTotalTemplate3, "1,120.01");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		String getWCTaxTotalTemplate4 = paystubTemplate4.getWCTaxTotalTemplate4();
		soft15.assertEquals(getWCTaxTotalTemplate4, "1,120.01");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		String getWCTaxTotalTemplate5 = paystubTemplate5.getWCTaxTotalTemplate5();
		soft15.assertEquals(getWCTaxTotalTemplate5, "1,120.01");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		String getWCTaxTotalTemplate6 = paystubTemplate6.getWCTaxTotalTemplate6();
		soft15.assertEquals(getWCTaxTotalTemplate6, "1,120.01");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.select_how_often_you_paid("Daily");
		PaystubWebFormPage.selectEmployee_State("New Mexico");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "10");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40"); // YtdTotal = 400
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "0.02");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.02");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80"); // YtdTotal = 800
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "0.02");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.02");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800"); // YtdTotal = 8000
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "0.02");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.02");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8000"); // YtdTotal = 80000
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "0.02");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.02");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80000"); // YtdTotal = 800000
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "0.02");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.02");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getWCTaxTotalTemplate2 = paystubTemplate2.getWCTaxTotalTemplate2();
		soft15.assertEquals(getWCTaxTotalTemplate2, "0.02");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getWCTaxTotalTemplate3 = paystubTemplate3.getWCTaxTotalTemplate3();
		soft15.assertEquals(getWCTaxTotalTemplate3, "0.02");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getWCTaxTotalTemplate4 = paystubTemplate4.getWCTaxTotalTemplate4();
		soft15.assertEquals(getWCTaxTotalTemplate4, "0.02");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getWCTaxTotalTemplate5 = paystubTemplate5.getWCTaxTotalTemplate5();
		soft15.assertEquals(getWCTaxTotalTemplate5, "0.02");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getWCTaxTotalTemplate6 = paystubTemplate6.getWCTaxTotalTemplate6();
		soft15.assertEquals(getWCTaxTotalTemplate6, "0.02");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.select_how_often_you_paid("Weekly (ex: every Friday)");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "10");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40"); // YtdTotal = 400
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "0.15");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.15");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80"); // YtdTotal = 800
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "0.15");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.15");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800"); // YtdTotal = 8000
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "0.15");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.15");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8000"); // YtdTotal = 80000
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "0.15");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.15");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80000"); // YtdTotal = 800000
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "0.15");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.15");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getWCTaxTotalTemplate2 = paystubTemplate2.getWCTaxTotalTemplate2();
		soft15.assertEquals(getWCTaxTotalTemplate2, "0.15");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getWCTaxTotalTemplate3 = paystubTemplate3.getWCTaxTotalTemplate3();
		soft15.assertEquals(getWCTaxTotalTemplate3, "0.15");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getWCTaxTotalTemplate4 = paystubTemplate4.getWCTaxTotalTemplate4();
		soft15.assertEquals(getWCTaxTotalTemplate4, "0.15");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getWCTaxTotalTemplate5 = paystubTemplate5.getWCTaxTotalTemplate5();
		soft15.assertEquals(getWCTaxTotalTemplate5, "0.15");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getWCTaxTotalTemplate6 = paystubTemplate6.getWCTaxTotalTemplate6();
		soft15.assertEquals(getWCTaxTotalTemplate6, "0.15");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.select_how_often_you_paid("Bi-Weekly (ex: every other Wednesday)");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "10");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40"); // YtdTotal = 400
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "0.31");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.31");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80"); // YtdTotal = 800
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "0.31");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.31");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800"); // YtdTotal = 8000
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "0.31");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.31");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8000"); // YtdTotal = 80000
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "0.31");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.31");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80000"); // YtdTotal = 800000
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "0.31");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.31");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getWCTaxTotalTemplate2 = paystubTemplate2.getWCTaxTotalTemplate2();
		soft15.assertEquals(getWCTaxTotalTemplate2, "0.31");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getWCTaxTotalTemplate3 = paystubTemplate3.getWCTaxTotalTemplate3();
		soft15.assertEquals(getWCTaxTotalTemplate3, "0.31");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getWCTaxTotalTemplate4 = paystubTemplate4.getWCTaxTotalTemplate4();
		soft15.assertEquals(getWCTaxTotalTemplate4, "0.31");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getWCTaxTotalTemplate5 = paystubTemplate5.getWCTaxTotalTemplate5();
		soft15.assertEquals(getWCTaxTotalTemplate5, "0.31");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getWCTaxTotalTemplate6 = paystubTemplate6.getWCTaxTotalTemplate6();
		soft15.assertEquals(getWCTaxTotalTemplate6, "0.31");

//		PaystubWebFormPage.select_how_often_you_paid("Semi-Monthly (ex: 1st and 15th)");
//		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
//		PaystubWebFormPage.enterRegularRates(1, "10");
//		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40"); // YtdTotal = 400
//		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "0.33");
//		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.33");
//		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80"); // YtdTotal = 800
//		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "0.33");
//		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.33");
//		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800"); // YtdTotal = 8000
//		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "0.33");
//		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.33");
//		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8000"); // YtdTotal = 80000
//		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "0.33");
//		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.33");
//		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80000"); // YtdTotal = 800000
//		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "0.33");
//		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.33");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.select_how_often_you_paid("Monthly (ex: 1st of month only)");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "10");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40"); // YtdTotal = 400
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "0.65");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.65");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80"); // YtdTotal = 800
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "0.65");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.65");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800"); // YtdTotal = 8000
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "0.65");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.65");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8000"); // YtdTotal = 80000
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "0.65");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.65");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80000"); // YtdTotal = 800000
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "0.65");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.65");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getWCTaxTotalTemplate2 = paystubTemplate2.getWCTaxTotalTemplate2();
		soft15.assertEquals(getWCTaxTotalTemplate2, "0.65");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getWCTaxTotalTemplate3 = paystubTemplate3.getWCTaxTotalTemplate3();
		soft15.assertEquals(getWCTaxTotalTemplate3, "0.65");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getWCTaxTotalTemplate4 = paystubTemplate4.getWCTaxTotalTemplate4();
		soft15.assertEquals(getWCTaxTotalTemplate4, "0.65");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getWCTaxTotalTemplate5 = paystubTemplate5.getWCTaxTotalTemplate5();
		soft15.assertEquals(getWCTaxTotalTemplate5, "0.65");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getWCTaxTotalTemplate6 = paystubTemplate6.getWCTaxTotalTemplate6();
		soft15.assertEquals(getWCTaxTotalTemplate6, "0.65");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.select_how_often_you_paid("Quarterly");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "10");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40"); // YtdTotal = 400
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "1.95");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "1.95");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80"); // YtdTotal = 800
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "1.95");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "1.95");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800"); // YtdTotal = 8000
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "1.95");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "1.95");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8000"); // YtdTotal = 80000
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "1.95");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "1.95");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80000"); // YtdTotal = 800000
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "1.95");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "1.95");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getWCTaxTotalTemplate2 = paystubTemplate2.getWCTaxTotalTemplate2();
		soft15.assertEquals(getWCTaxTotalTemplate2, "1.95");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getWCTaxTotalTemplate3 = paystubTemplate3.getWCTaxTotalTemplate3();
		soft15.assertEquals(getWCTaxTotalTemplate3, "1.95");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getWCTaxTotalTemplate4 = paystubTemplate4.getWCTaxTotalTemplate4();
		soft15.assertEquals(getWCTaxTotalTemplate4, "1.95");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getWCTaxTotalTemplate5 = paystubTemplate5.getWCTaxTotalTemplate5();
		soft15.assertEquals(getWCTaxTotalTemplate5, "1.95");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getWCTaxTotalTemplate6 = paystubTemplate6.getWCTaxTotalTemplate6();
		soft15.assertEquals(getWCTaxTotalTemplate6, "1.95");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.select_how_often_you_paid("Semi-Annually");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "10");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40"); // YtdTotal = 400
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "3.90");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "3.90");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80"); // YtdTotal = 800
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "3.90");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "3.90");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800"); // YtdTotal = 8000
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "3.90");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "3.90");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8000"); // YtdTotal = 80000
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "3.90");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "3.90");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80000"); // YtdTotal = 800000
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "3.90");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "3.90");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getWCTaxTotalTemplate2 = paystubTemplate2.getWCTaxTotalTemplate2();
		soft15.assertEquals(getWCTaxTotalTemplate2, "3.90");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getWCTaxTotalTemplate3 = paystubTemplate3.getWCTaxTotalTemplate3();
		soft15.assertEquals(getWCTaxTotalTemplate3, "3.90");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getWCTaxTotalTemplate4 = paystubTemplate4.getWCTaxTotalTemplate4();
		soft15.assertEquals(getWCTaxTotalTemplate4, "3.90");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getWCTaxTotalTemplate5 = paystubTemplate5.getWCTaxTotalTemplate5();
		soft15.assertEquals(getWCTaxTotalTemplate5, "3.90");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getWCTaxTotalTemplate6 = paystubTemplate6.getWCTaxTotalTemplate6();
		soft15.assertEquals(getWCTaxTotalTemplate6, "3.90");

		paystubTemplate1 = PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.select_how_often_you_paid("Annually");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "10");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40"); // YtdTotal = 400
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "7.80");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "7.80");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80"); // YtdTotal = 800
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "7.80");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "7.80");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800"); // YtdTotal = 8000
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "7.80");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "7.80");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8000"); // YtdTotal = 80000
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "7.80");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "7.80");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80000"); // YtdTotal = 800000
		soft15.assertEquals(getTextValueOfWebElementID("wc_total"), "7.80");
		soft15.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "7.80");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		getWCTaxTotalTemplate2 = paystubTemplate2.getWCTaxTotalTemplate2();
		soft15.assertEquals(getWCTaxTotalTemplate2, "7.80");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		getWCTaxTotalTemplate3 = paystubTemplate3.getWCTaxTotalTemplate3();
		soft15.assertEquals(getWCTaxTotalTemplate3, "7.80");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		getWCTaxTotalTemplate4 = paystubTemplate4.getWCTaxTotalTemplate4();
		soft15.assertEquals(getWCTaxTotalTemplate4, "7.80");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		getWCTaxTotalTemplate5 = paystubTemplate5.getWCTaxTotalTemplate5();
		soft15.assertEquals(getWCTaxTotalTemplate5, "7.80");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		getWCTaxTotalTemplate6 = paystubTemplate6.getWCTaxTotalTemplate6();
		soft15.assertEquals(getWCTaxTotalTemplate6, "7.80");

		soft15.assertAll("The WC Values are wrong");
	}

	@Test(priority = 16, description = "16. Verify FLI-FLV tax calculations with martial status as 'Single' with ytdtotal as '400','800','8000','80000'")
	public void Verify_FLIFLV_Tax_Calculations_on_Template1_with_State() throws InterruptedException {
		SoftAssert soft16 = new SoftAssert();
		browserdriver.navigate().refresh();

		PaystubWebFormPage.selectEmployee_State("New Jersey");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "10");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40"); // YtdTotal = 400
		soft16.assertEquals(getTextValueOfWebElementID("fli_total"), "1.12");
		soft16.assertEquals(paystubTemplate1.getFLITaxTotalTemplate1(), "1.12");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80"); // YtdTotal = 800
		soft16.assertEquals(getTextValueOfWebElementID("fli_total"), "2.24");
		soft16.assertEquals(paystubTemplate1.getFLITaxTotalTemplate1(), "2.24");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800"); // YtdTotal = 8000
		soft16.assertEquals(getTextValueOfWebElementID("fli_total"), "22.40");
		soft16.assertEquals(paystubTemplate1.getFLITaxTotalTemplate1(), "22.40");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8000"); // YtdTotal = 80000
		soft16.assertEquals(getTextValueOfWebElementID("fli_total"), "98.80");
		soft16.assertEquals(paystubTemplate1.getFLITaxTotalTemplate1(), "98.80");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80000"); // YtdTotal = 800000
		soft16.assertEquals(getTextValueOfWebElementID("fli_total"), "98.80");
		soft16.assertEquals(paystubTemplate1.getFLITaxTotalTemplate1(), "98.80");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		String getFLITaxTotalTemplate2 = paystubTemplate2.getFLITaxTotalTemplate2();
		soft16.assertEquals(getFLITaxTotalTemplate2, "98.80");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		String getFLITaxTotalTemplate3 = paystubTemplate3.getFLITaxTotalTemplate3();
		soft16.assertEquals(getFLITaxTotalTemplate3, "98.80");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		String getFLITaxTotalTemplate4 = paystubTemplate4.getFLITaxTotalTemplate4();
		soft16.assertEquals(getFLITaxTotalTemplate4, "98.80");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		String getFLITaxTotalTemplate5 = paystubTemplate5.getFLITaxTotalTemplate5();
		soft16.assertEquals(getFLITaxTotalTemplate5, "98.80");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		String getFLITaxTotalTemplate6 = paystubTemplate6.getFLITaxTotalTemplate6();
		soft16.assertEquals(getFLITaxTotalTemplate6, "98.80");

		soft16.assertAll();
	}

	@Test(enabled = false)
	public void getexcelData() {
		System.out.println(ExcelData.getData(0, 4, 1).getStringCellValue());
	}

	@Test(priority = 17, description = "17. Verify Workforce Development tax when Gross Pay YTD total is less than 33500")
	public void calculateWorkforceDevelopment() throws InterruptedException {
		SoftAssert soft17 = new SoftAssert();
		browserdriver.navigate().refresh();

		PaystubWebFormPage.selectEmployee_State("New Jersey");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "10");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80");
		soft17.assertEquals(getTextValueOfWebElementID("wf_total"), "0.34");
		soft17.assertEquals(paystubTemplate1.getTemplate1WorkForceDevTaxTotal(), "0.34");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800");
		soft17.assertEquals(getTextValueOfWebElementID("wf_total"), "3.40");
		soft17.assertEquals(paystubTemplate1.getTemplate1WorkForceDevTaxTotal(), "3.40");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		String getTemplate1WorkForceDevTaxTotal2 = paystubTemplate2.getTemplate2WorkForceDevTaxTotal();
		soft17.assertEquals(getTemplate1WorkForceDevTaxTotal2, "3.40");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		String getTemplate1WorkForceDevTaxTotal3 = paystubTemplate3.getTemplate3WorkForceDevTaxTotal();
		soft17.assertEquals(getTemplate1WorkForceDevTaxTotal3, "3.40");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		String getTemplate1WorkForceDevTaxTotal4 = paystubTemplate4.getTemplate4WorkForceDevTaxTotal();
		soft17.assertEquals(getTemplate1WorkForceDevTaxTotal4, "3.40");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		String getTemplate1WorkForceDevTaxTotal5 = paystubTemplate5.getTemplate5WorkForceDevTaxTotal();
		soft17.assertEquals(getTemplate1WorkForceDevTaxTotal5, "3.40");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		String getTemplate1WorkForceDevTaxTotal6 = paystubTemplate6.getTemplate6WorkForceDevTaxTotal();
		soft17.assertEquals(getTemplate1WorkForceDevTaxTotal6, "3.40");

		soft17.assertAll();
	}

	@Test(priority = 18, description = "18. Verify Workforce Development tax when Gross Pay YTD total is equal to 33500")
	public void calculateWorkforceDevelopment2() throws InterruptedException {
		// SoftAssert soft10 = new SoftAssert();
		SoftAssert soft18 = new SoftAssert();
		browserdriver.navigate().refresh();

		PaystubWebFormPage.selectEmployee_State("New Jersey");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "1");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "33500");
		soft18.assertEquals(getTextValueOfWebElementID("wf_total"), "14.24");
		soft18.assertEquals(paystubTemplate1.getTemplate1WorkForceDevTaxTotal(), "14.24");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		String getTemplate1WorkForceDevTaxTotal2 = paystubTemplate2.getTemplate2WorkForceDevTaxTotal();
		soft18.assertEquals(getTemplate1WorkForceDevTaxTotal2, "14.24");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		String getTemplate1WorkForceDevTaxTotal3 = paystubTemplate3.getTemplate3WorkForceDevTaxTotal();
		soft18.assertEquals(getTemplate1WorkForceDevTaxTotal3, "14.24");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		String getTemplate1WorkForceDevTaxTotal4 = paystubTemplate4.getTemplate4WorkForceDevTaxTotal();
		soft18.assertEquals(getTemplate1WorkForceDevTaxTotal4, "14.24");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		String getTemplate1WorkForceDevTaxTotal5 = paystubTemplate5.getTemplate5WorkForceDevTaxTotal();
		soft18.assertEquals(getTemplate1WorkForceDevTaxTotal5, "14.24");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		String getTemplate1WorkForceDevTaxTotal6 = paystubTemplate6.getTemplate6WorkForceDevTaxTotal();
		soft18.assertEquals(getTemplate1WorkForceDevTaxTotal6, "14.24");
		soft18.assertAll();
	}

	@Test(priority = 19, description = "19. Verify Workforce Development tax when Gross Pay YTD total is greater than 33500")
	public void calculateWorkforceDevelopment3() throws InterruptedException {
		SoftAssert soft19 = new SoftAssert();
		browserdriver.navigate().refresh();

		PaystubWebFormPage.selectEmployee_State("New Jersey");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "1");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40000");
		soft19.assertEquals(getTextValueOfWebElementID("wf_total"), "14.24");
		soft19.assertEquals(paystubTemplate1.getTemplate1WorkForceDevTaxTotal(), "14.24");

		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		String getTemplate1WorkForceDevTaxTotal2 = paystubTemplate2.getTemplate2WorkForceDevTaxTotal();
		soft19.assertEquals(getTemplate1WorkForceDevTaxTotal2, "14.24");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		String getTemplate1WorkForceDevTaxTotal3 = paystubTemplate3.getTemplate3WorkForceDevTaxTotal();
		soft19.assertEquals(getTemplate1WorkForceDevTaxTotal3, "14.24");
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		String getTemplate1WorkForceDevTaxTotal4 = paystubTemplate4.getTemplate4WorkForceDevTaxTotal();
		soft19.assertEquals(getTemplate1WorkForceDevTaxTotal4, "14.24");
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		String getTemplate1WorkForceDevTaxTotal5 = paystubTemplate5.getTemplate5WorkForceDevTaxTotal();
		soft19.assertEquals(getTemplate1WorkForceDevTaxTotal5, "14.24");
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		String getTemplate1WorkForceDevTaxTotal6 = paystubTemplate6.getTemplate6WorkForceDevTaxTotal();
		soft19.assertEquals(getTemplate1WorkForceDevTaxTotal6, "14.24");
		soft19.assertAll();
	}

	@Test(priority = 20, description = "20. Verify Total calculations for all type of earnings in all Templates")
	public void calculateTotalEarnings() throws InterruptedException {
		SoftAssert soft20 = new SoftAssert();
		browserdriver.navigate().refresh();
		PaystubWebFormPage.selectEmployee_State("New Jersey");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "2");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "300");
		PaystubWebFormPage.enterOverTimeRate(1, "3");
		PaystubWebFormPage.enterOverTimeHours(1, "300");
		PaystubWebFormPage.enterHolidayRate(1, "4");
		PaystubWebFormPage.enterHolidayHours(1, "300");
		PaystubWebFormPage.enterVacationRate(1, "5");
		PaystubWebFormPage.enterVacationHours(1, "300");
		PaystubWebFormPage.enterBonusRate(1, "6");
		PaystubWebFormPage.enterBonusHours(1, "300");
		PaystubWebFormPage.enterFloatRate(1, "7");
		PaystubWebFormPage.enterFloatHours(1, "300");
		PaystubWebFormPage.enterTipsRate(1, "30");
		// PaystubWebFormPage.enterTipsHours(1, "300");

		soft20.assertEquals(getTextValueOfWebElementID("total1"), "600.00");
		soft20.assertEquals(getTextValueOfWebElementID("ytd1"), "600.00");
		soft20.assertEquals(getTextValueOfWebElementID("total2"), "900.00");
		soft20.assertEquals(getTextValueOfWebElementID("ytd2"), "900.00");
		soft20.assertEquals(getTextValueOfWebElementID("total3"), "1,200.00");
		soft20.assertEquals(getTextValueOfWebElementID("ytd3"), "1,200.00");
		soft20.assertEquals(getTextValueOfWebElementID("total4"), "1,500.00");
		soft20.assertEquals(getTextValueOfWebElementID("ytd4"), "1,500.00");
		soft20.assertEquals(getTextValueOfWebElementID("total5"), "1,800.00");
		soft20.assertEquals(getTextValueOfWebElementID("ytd5"), "1,800.00");
		soft20.assertEquals(getTextValueOfWebElementID("total6"), "2,100.00");
		soft20.assertEquals(getTextValueOfWebElementID("ytd6"), "2,100.00");
		soft20.assertEquals(getTextValueOfWebElementID("total7"), "30.00");
		soft20.assertEquals(getTextValueOfWebElementID("ytd7"), "30.00");

		// Verify Template1 earnings
		soft20.assertEquals(paystubTemplate1.getTemplate1RegularTotal(), "600.00",
				"RegularTotal at template1 is wrong");
		soft20.assertEquals(paystubTemplate1.getTemplate1RegularYTDTotal(), "600.00",
				"RegularYTDTotal at template1 is wrong");
		soft20.assertEquals(paystubTemplate1.getTemplate1OverTimeTotal(), "900.00",
				"OverTimeTotal at template1 is wrong");
		soft20.assertEquals(paystubTemplate1.getTemplate1OverTimeYTDTotal(), "900.00",
				"OverTimeYTDTotal at template1 is wrong");
		soft20.assertEquals(paystubTemplate1.getTemplate1HolidayTotal(), "1,200.00",
				"HolidayTotal at template1 is wrong");
		soft20.assertEquals(paystubTemplate1.getTemplate1HolidayYTDTotal(), "1,200.00",
				"HolidayYTDTotal at template1 is wrong");
		soft20.assertEquals(paystubTemplate1.getTemplate1VacationTotal(), "1,500.00",
				"VacationTotal at template1 is wrong");
		soft20.assertEquals(paystubTemplate1.getTemplate1VacationYTDTotal(), "1,500.00",
				"VacationYTDTotal at template1 is wrong");
		soft20.assertEquals(paystubTemplate1.getTemplate1BonusTotal(), "1,800.00", "BonusTotal at template1 is wrong");
		soft20.assertEquals(paystubTemplate1.getTemplate1BonusYTDTotal(), "1,800.00",
				"BonusYTDTotal at template1 is wrong");
		soft20.assertEquals(paystubTemplate1.getTemplate1FloatTotal(), "2,100.00", "FloatTotal at template1 is wrong");
		soft20.assertEquals(paystubTemplate1.getTemplate1FloatYTDTotal(), "2,100.00",
				"FloatYTDTotal at template1 is wrong");
		soft20.assertEquals(paystubTemplate1.getTemplate1TipsTotal(), "30.00", "TipsTotal at template1 is wrong");
		soft20.assertEquals(paystubTemplate1.getTemplate1TipsYTDTotal(), "30.00", "TipsYTDTotal at template1 is wrong");

		// Verify Template 2 earnings
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		soft20.assertEquals(paystubTemplate2.getTemplate2RegularTotal(), "600.00",
				"RegularTotal at template2 is wrong");
		soft20.assertEquals(paystubTemplate2.getTemplate2RegularYTDTotal(), "600.00",
				"RegularYTDTotal at template2 is wrong");
		soft20.assertEquals(paystubTemplate2.getTemplate2OverTimeTotal(), "900.00",
				"OverTimeTotal at template2 is wrong");
		soft20.assertEquals(paystubTemplate2.getTemplate2OverTimeYTDTotal(), "900.00",
				"OverTimeYTDTotal at template2 is wrong");
		soft20.assertEquals(paystubTemplate2.getTemplate2HolidayTotal(), "1,200.00",
				"HolidayTotal at template2 is wrong");
		soft20.assertEquals(paystubTemplate2.getTemplate2HolidayYTDTotal(), "1,200.00",
				"HolidayYTDTotal at template2 is wrong");
		soft20.assertEquals(paystubTemplate2.getTemplate2VacationTotal(), "1,500.00",
				"VacationTotal at template2 is wrong");
		soft20.assertEquals(paystubTemplate2.getTemplate2VacationYTDTotal(), "1,500.00",
				"VacationYTDTotal at template2 is wrong");
		soft20.assertEquals(paystubTemplate2.getTemplate2BonusTotal(), "1,800.00", "BonusTotal at template2 is wrong");
		soft20.assertEquals(paystubTemplate2.getTemplate2BonusYTDTotal(), "1,800.00",
				"BonusYTDTotal at template2 is wrong");
		soft20.assertEquals(paystubTemplate2.getTemplate2FloatTotal(), "2,100.00", "FloatTotal at template2 is wrong");
		soft20.assertEquals(paystubTemplate2.getTemplate2FloatYTDTotal(), "2,100.00",
				"FloatYTDTotal at template2 is wrong");
		soft20.assertEquals(paystubTemplate2.getTemplate2TipsTotal(), "30.00", "TipsTotal at template2 is wrong");
		soft20.assertEquals(paystubTemplate2.getTemplate2TipsYTDTotal(), "30.00", "TipsYTDTotal at template2 is wrong");

		// Verify Template 3 earnings
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		soft20.assertEquals(paystubTemplate3.getTemplate3RegularTotal(), "600.00",
				"RegularTotal at Template3 is wrong");
//		soft20.assertEquals(paystubTemplate3.getTemplate3RegularYTDTotal(), "600.00",
//				"RegularYTDTotal at Template3 is wrong");
		soft20.assertEquals(paystubTemplate3.getTemplate3OverTimeTotal(), "900.00",
				"OverTimeTotal at Template3 is wrong");
//		soft20.assertEquals(paystubTemplate3.getTemplate3OverTimeYTDTotal(), "900.00",
//				"OverTimeYTDTotal at Template3 is wrong");
		soft20.assertEquals(paystubTemplate3.getTemplate3HolidayTotal(), "1,200.00",
				"HolidayTotal at Template3 is wrong");
//		soft20.assertEquals(paystubTemplate3.getTemplate3HolidayYTDTotal(), "1,200.00",
//				"HolidayYTDTotal at Template3 is wrong");
		soft20.assertEquals(paystubTemplate3.getTemplate3VacationTotal(), "1,500.00",
				"VacationTotal at Template3 is wrong");
//		soft20.assertEquals(paystubTemplate3.getTemplate3VacationYTDTotal(), "1,500.00",
//				"VacationYTDTotal at Template3 is wrong");
		soft20.assertEquals(paystubTemplate3.getTemplate3BonusTotal(), "1,800.00", "BonusTotal at Template3 is wrong");
//		soft20.assertEquals(paystubTemplate3.getTemplate3BonusYTDTotal(), "1,800.00",
//				"BonusYTDTotal at Template3 is wrong");
		soft20.assertEquals(paystubTemplate3.getTemplate3FloatTotal(), "2,100.00", "FloatTotal at Template3 is wrong");
//		soft20.assertEquals(paystubTemplate3.getTemplate3FloatYTDTotal(), "2,100.00",
//				"FloatYTDTotal at Template3 is wrong");
		soft20.assertEquals(paystubTemplate3.getTemplate3TipsTotal(), "30.00", "TipsTotal at Template3 is wrong");
//		soft20.assertEquals(paystubTemplate3.getTemplate3TipsYTDTotal(), "30.00", "TipsYTDTotal at Template3 is wrong");

		// Verify Template 4 earnings
		paystubTemplate4 = PaystubWebFormPage.clickTemplate4();
		soft20.assertEquals(paystubTemplate4.getTemplate4RegularTotal(), "600.00",
				"RegularTotal at Template4 is wrong");
//		soft20.assertEquals(paystubTemplate4.getTemplate4RegularYTDTotal(), "600.00",
//				"RegularYTDTotal at Template4 is wrong");
		soft20.assertEquals(paystubTemplate4.getTemplate4OverTimeTotal(), "900.00",
				"OverTimeTotal at Template4 is wrong");
//		soft20.assertEquals(paystubTemplate4.getTemplate4OverTimeYTDTotal(), "900.00",
//				"OverTimeYTDTotal at Template4 is wrong");
		soft20.assertEquals(paystubTemplate4.getTemplate4HolidayTotal(), "1,200.00",
				"HolidayTotal at Template4 is wrong");
//		soft20.assertEquals(paystubTemplate4.getTemplate4HolidayYTDTotal(), "1,200.00",
//				"HolidayYTDTotal at Template4 is wrong");
		soft20.assertEquals(paystubTemplate4.getTemplate4VacationTotal(), "1,500.00",
				"VacationTotal at Template4 is wrong");
//		soft20.assertEquals(paystubTemplate4.getTemplate4VacationYTDTotal(), "1,500.00",
//				"VacationYTDTotal at Template4 is wrong");
		soft20.assertEquals(paystubTemplate4.getTemplate4BonusTotal(), "1,800.00", "BonusTotal at Template4 is wrong");
//		soft20.assertEquals(paystubTemplate4.getTemplate4BonusYTDTotal(), "1,800.00",
//				"BonusYTDTotal at Template4 is wrong");
		soft20.assertEquals(paystubTemplate4.getTemplate4FloatTotal(), "2,100.00", "FloatTotal at Template4 is wrong");
//		soft20.assertEquals(paystubTemplate4.getTemplate4FloatYTDTotal(), "2,100.00",
//				"FloatYTDTotal at Template4 is wrong");
		soft20.assertEquals(paystubTemplate4.getTemplate4TipsTotal(), "30.00", "TipsTotal at Template4 is wrong");
//		soft20.assertEquals(paystubTemplate4.getTemplate4TipsYTDTotal(), "30.00", "TipsYTDTotal at Template4 is wrong");

		// Verify Template 5 earnings
		paystubTemplate5 = PaystubWebFormPage.clickTemplate5();
		soft20.assertEquals(paystubTemplate5.getTemplate5RegularTotal(), "600.00",
				"RegularTotal at Template5 is wrong");
		soft20.assertEquals(paystubTemplate5.getTemplate5RegularYTDTotal(), "600.00",
				"RegularYTDTotal at Template5 is wrong");
		soft20.assertEquals(paystubTemplate5.getTemplate5OverTimeTotal(), "900.00",
				"OverTimeTotal at Template5 is wrong");
		soft20.assertEquals(paystubTemplate5.getTemplate5OverTimeYTDTotal(), "900.00",
				"OverTimeYTDTotal at Template5 is wrong");
		soft20.assertEquals(paystubTemplate5.getTemplate5HolidayTotal(), "1,200.00",
				"HolidayTotal at Template5 is wrong");
		soft20.assertEquals(paystubTemplate5.getTemplate5HolidayYTDTotal(), "1,200.00",
				"HolidayYTDTotal at Template5 is wrong");
		soft20.assertEquals(paystubTemplate5.getTemplate5VacationTotal(), "1,500.00",
				"VacationTotal at Template5 is wrong");
		soft20.assertEquals(paystubTemplate5.getTemplate5VacationYTDTotal(), "1,500.00",
				"VacationYTDTotal at Template5 is wrong");
		soft20.assertEquals(paystubTemplate5.getTemplate5BonusTotal(), "1,800.00", "BonusTotal at Template5 is wrong");
		soft20.assertEquals(paystubTemplate5.getTemplate5BonusYTDTotal(), "1,800.00",
				"BonusYTDTotal at Template5 is wrong");
		soft20.assertEquals(paystubTemplate5.getTemplate5FloatTotal(), "2,100.00", "FloatTotal at Template5 is wrong");
		soft20.assertEquals(paystubTemplate5.getTemplate5FloatYTDTotal(), "2,100.00",
				"FloatYTDTotal at Template5 is wrong");
		soft20.assertEquals(paystubTemplate5.getTemplate5TipsTotal(), "30.00", "TipsTotal at Template5 is wrong");
		soft20.assertEquals(paystubTemplate5.getTemplate5TipsYTDTotal(), "30.00", "TipsYTDTotal at Template5 is wrong");

		// Verify Template 6 earnings
		paystubTemplate6 = PaystubWebFormPage.clickTemplate6();
		soft20.assertEquals(paystubTemplate6.getTemplate6RegularTotal(), "600.00",
				"RegularTotal at Template6 is wrong");
		soft20.assertEquals(paystubTemplate6.getTemplate6RegularYTDTotal(), "600.00",
				"RegularYTDTotal at Template6 is wrong");
		soft20.assertEquals(paystubTemplate6.getTemplate6OverTimeTotal(), "900.00",
				"OverTimeTotal at Template6 is wrong");
		soft20.assertEquals(paystubTemplate6.getTemplate6OverTimeYTDTotal(), "900.00",
				"OverTimeYTDTotal at Template6 is wrong");
		soft20.assertEquals(paystubTemplate6.getTemplate6HolidayTotal(), "1,200.00",
				"HolidayTotal at Template6 is wrong");
		soft20.assertEquals(paystubTemplate6.getTemplate6HolidayYTDTotal(), "1,200.00",
				"HolidayYTDTotal at Template6 is wrong");
		soft20.assertEquals(paystubTemplate6.getTemplate6VacationTotal(), "1,500.00",
				"VacationTotal at Template6 is wrong");
		soft20.assertEquals(paystubTemplate6.getTemplate6VacationYTDTotal(), "1,500.00",
				"VacationYTDTotal at Template6 is wrong");
		soft20.assertEquals(paystubTemplate6.getTemplate6BonusTotal(), "1,800.00", "BonusTotal at Template6 is wrong");
		soft20.assertEquals(paystubTemplate6.getTemplate6BonusYTDTotal(), "1,800.00",
				"BonusYTDTotal at Template6 is wrong");
		soft20.assertEquals(paystubTemplate6.getTemplate6FloatTotal(), "2,100.00", "FloatTotal at Template6 is wrong");
		soft20.assertEquals(paystubTemplate6.getTemplate6FloatYTDTotal(), "2,100.00",
				"FloatYTDTotal at Template6 is wrong");
		soft20.assertEquals(paystubTemplate6.getTemplate6TipsTotal(), "30.00", "TipsTotal at Template6 is wrong");
		soft20.assertEquals(paystubTemplate6.getTemplate6TipsYTDTotal(), "30.00", "TipsYTDTotal at Template6 is wrong");

		// Verify template1 with 2nd Pay periord of the year
		PaystubWebFormPage.clickTemplate1();
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "15");
		PaystubWebFormPage.enterRegularRates(1, "2");
		PaystubWebFormPage.enterRegularHours(1, "300");

		soft20.assertEquals(getTextValueOfWebElementID("ytd1"), "1,200.00");
		soft20.assertEquals(getTextValueOfWebElementID("ytd2"), "1,800.00");
		soft20.assertEquals(getTextValueOfWebElementID("ytd3"), "2,400.00");
		soft20.assertEquals(getTextValueOfWebElementID("ytd4"), "3,000.00");
		soft20.assertEquals(getTextValueOfWebElementID("ytd5"), "3,600.00");
		soft20.assertEquals(getTextValueOfWebElementID("ytd6"), "4,200.00");
		soft20.assertEquals(getTextValueOfWebElementID("ytd7"), "60.00");

		soft20.assertEquals(paystubTemplate1.getTemplate1RegularTotal(), "600.00",
				"RegularTotal at template1 is wrong");
		soft20.assertEquals(paystubTemplate1.getTemplate1RegularYTDTotal(), "1,200.00",
				"RegularYTDTotal at template1 is wrong");
		soft20.assertEquals(paystubTemplate1.getTemplate1OverTimeTotal(), "900.00",
				"OverTimeTotal at template1 is wrong");
		soft20.assertEquals(paystubTemplate1.getTemplate1OverTimeYTDTotal(), "1,800.00",
				"OverTimeYTDTotal at template1 is wrong");
		soft20.assertEquals(paystubTemplate1.getTemplate1HolidayTotal(), "1,200.00",
				"HolidayTotal at template1 is wrong");
		soft20.assertEquals(paystubTemplate1.getTemplate1HolidayYTDTotal(), "2,400.00",
				"HolidayYTDTotal at template1 is wrong");
		soft20.assertEquals(paystubTemplate1.getTemplate1VacationTotal(), "1,500.00",
				"VacationTotal at template1 is wrong");
		soft20.assertEquals(paystubTemplate1.getTemplate1VacationYTDTotal(), "3,000.00",
				"VacationYTDTotal at template1 is wrong");
		soft20.assertEquals(paystubTemplate1.getTemplate1BonusTotal(), "1,800.00", "BonusTotal at template1 is wrong");
		soft20.assertEquals(paystubTemplate1.getTemplate1BonusYTDTotal(), "3,600.00",
				"BonusYTDTotal at template1 is wrong");
		soft20.assertEquals(paystubTemplate1.getTemplate1FloatTotal(), "2,100.00", "FloatTotal at template1 is wrong");
		soft20.assertEquals(paystubTemplate1.getTemplate1FloatYTDTotal(), "4,200.00",
				"FloatYTDTotal at template1 is wrong");
		soft20.assertEquals(paystubTemplate1.getTemplate1TipsTotal(), "30.00", "TipsTotal at template1 is wrong");
		soft20.assertEquals(paystubTemplate1.getTemplate1TipsYTDTotal(), "60.00", "TipsYTDTotal at template1 is wrong");
		soft20.assertAll();
	}

	@Test(priority = 21, description = "21. Verify Contractor does not have any tax deduction")
	public void verifyContractorTax() throws InterruptedException {
		SoftAssert soft21 = new SoftAssert();
		browserdriver.navigate().refresh();
		PaystubWebFormPage.selectEmployment_Type("Contractor");

		soft21.assertEquals(getTextValueOfWebElementID("fica_medicare_total"), "0.00");
		soft21.assertEquals(getTextValueOfWebElementID("fica_medicare_ytd_total"), "0.00");
		soft21.assertEquals(getTextValueOfWebElementID("fica_social_security_total"), "0.00");
		soft21.assertEquals(getTextValueOfWebElementID("fica_social_security_ytd_total"), "0.00");
		soft21.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "0.00");
		soft21.assertEquals(getTextValueOfWebElementID("federal_tax_ytd_total"), "0.00");
		soft21.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft21.assertEquals(getTextValueOfWebElementID("state_tax_ytd_total"), "0.00");
		soft21.assertEquals(getTextValueOfWebElementID("sdi_total"), "0.00");
		soft21.assertEquals(getTextValueOfWebElementID("sdi_ytd_total"), "0.00");
		soft21.assertEquals(getTextValueOfWebElementID("sui_total"), "0.00");
		soft21.assertEquals(getTextValueOfWebElementID("sui_ytd_total"), "0.00");
		soft21.assertEquals(getTextValueOfWebElementID("wc_total"), "0.00");
		soft21.assertEquals(getTextValueOfWebElementID("wc_ytd_total"), "0.00");
		soft21.assertEquals(getTextValueOfWebElementID("fli_total"), "0.00");
		soft21.assertEquals(getTextValueOfWebElementID("fli_ytd_total"), "0.00");
		soft21.assertEquals(getTextValueOfWebElementID("wf_total"), "0.00");
		soft21.assertEquals(getTextValueOfWebElementID("wf_ytd_total"), "0.00");
		WebApp.BillGenratorWebApp.Paystub.paystubTemplate1 paystubTemplate1 = new WebApp.BillGenratorWebApp.Paystub.paystubTemplate1(
				browserdriver);
		soft21.assertEquals(paystubTemplate1.getFICAMedicareTemplate1(), "0.00");
		soft21.assertEquals(paystubTemplate1.getFicasocialSecurityTotalTemplate1(), "0.00");
		soft21.assertEquals(paystubTemplate1.getFederalTaxTotalTemplate1(), "0.00");
		soft21.assertEquals(paystubTemplate1.getStateTaxTotalTemplate1(), "0.00");
		soft21.assertAll();
	}

	@Test(priority = 22, description = "22. Verify the number of paystubs needed when 'How many pay periods have you worked?' is set from 22 value to 10 when 'Were you hired in the past 52 weeks?' is set to 'Yes'.")
	public void verifyPaystubsValues() throws InterruptedException {
		SoftAssert soft22 = new SoftAssert();
		browserdriver.navigate().refresh();
		PaystubWebFormPage.selectWere_you_hired_in_the_past_52_weeks("Yes");
		PaystubWebFormPage.How_many_pay_periods_have_you_worked("22");
		soft22.assertEquals(PaystubWebFormPage.NumberOfOptionsInPaystubsNeeded(), 22,
				"The number of paystubs values are not same.as 'How many pay periods' selected.");
		PaystubWebFormPage.select_NoOfPaystubsNeeded(20);
		soft22.assertEquals(PaystubWebFormPage.getnumberOfPaystubsShownOnPage(), 20,
				"The Number of paystubs shown on page is wrong");

		PaystubWebFormPage.How_many_pay_periods_have_you_worked("10");
		soft22.assertEquals(PaystubWebFormPage.getnumberOfPaystubsShownOnPage(), 1,
				"The Number of paystubs shown on page is wrong");

		soft22.assertAll();
	}

	@Test(priority = 23, description = "23. Verify the Salary Total value With payment type as 'Salary'. and How often you paied is set to 'Monthly'")
	public void verifySalaryTotalValueMonthly() throws InterruptedException {
		SoftAssert soft23 = new SoftAssert();
		browserdriver.navigate().refresh();
		PaystubWebFormPage.selectPaymentType("Salary");
		PaystubWebFormPage.select_how_often_you_paid("Monthly (ex: 1st of month only)");
		PaystubWebFormPage.enterSalaryRate(1, "200");
		soft23.assertEquals(getTextValueOfWebElementID("total1"), "16.67");
		soft23.assertEquals(paystubTemplate1.getTemplate1SalaryTotal(), "16.67",
				"Salary total calculations are getting wrong.");
		PaystubWebFormPage.enterSalaryRate(1, "25000");
		soft23.assertEquals(getTextValueOfWebElementID("total1"), "2083.33");
		soft23.assertEquals(paystubTemplate1.getTemplate1SalaryTotal(), "2083.33",
				"Salary total calculations are getting wrong.");
		soft23.assertAll();
	}

	@Test(priority = 24, description = "24. Verify the Salary Total value With payment type as 'Salary'. and How often you paied is set to 'Daily'")
	public void verifySalaryTotalValueDaily() throws InterruptedException {
		SoftAssert soft24 = new SoftAssert();
		browserdriver.navigate().refresh();
		PaystubWebFormPage.selectPaymentType("Salary");
		PaystubWebFormPage.select_how_often_you_paid("Daily");
		PaystubWebFormPage.enterSalaryRate(1, "200");
		soft24.assertEquals(getTextValueOfWebElementID("total1"), "200.00");
		soft24.assertEquals(paystubTemplate1.getTemplate1SalaryTotal(), "200.00",
				"Salary total calculations for 'Daily' are getting wrong.");
		PaystubWebFormPage.enterSalaryRate(1, "25000");
		soft24.assertEquals(getTextValueOfWebElementID("total1"), "25000.00");
		soft24.assertEquals(paystubTemplate1.getTemplate1SalaryTotal(), "25000.00",
				"Salary total calculations for 'Daily' are getting wrong.");
		soft24.assertAll();
	}

	@Test(priority = 25, description = "25. Verify the Salary Total value With payment type as 'Salary'. and How often you paied is set to 'Weekly (ex: every Friday)'")
	public void verifySalaryTotalValueWeekly() throws InterruptedException {
		SoftAssert soft25 = new SoftAssert();
		browserdriver.navigate().refresh();
		PaystubWebFormPage.selectPaymentType("Salary");
		PaystubWebFormPage.select_how_often_you_paid("Weekly (ex: every Friday)");
		PaystubWebFormPage.enterSalaryRate(1, "200");
		soft25.assertEquals(getTextValueOfWebElementID("total1"), "3.85");
		soft25.assertEquals(paystubTemplate1.getTemplate1SalaryTotal(), "3.85",
				"Salary total calculations for 'Weekly' are getting wrong.");
		PaystubWebFormPage.enterSalaryRate(1, "25000");
		soft25.assertEquals(getTextValueOfWebElementID("total1"), "480.77");
		soft25.assertEquals(paystubTemplate1.getTemplate1SalaryTotal(), "480.77",
				"Salary total calculations for 'Weekly' are getting wrong.");
		soft25.assertAll();
	}

	@Test(priority = 26, description = "26. Verify the Salary Total value With payment type as 'Salary'. and How often you paied is set to 'Bi-Weekly (ex: every other Wednesday)'")
	public void verifySalaryTotalValueBiWeekly() throws InterruptedException {
		SoftAssert soft26 = new SoftAssert();
		browserdriver.navigate().refresh();
		PaystubWebFormPage.selectPaymentType("Salary");
		PaystubWebFormPage.select_how_often_you_paid("Bi-Weekly (ex: every other Wednesday)");
		PaystubWebFormPage.enterSalaryRate(1, "200");
		soft26.assertEquals(getTextValueOfWebElementID("total1"), "7.69");
		soft26.assertEquals(paystubTemplate1.getTemplate1SalaryTotal(), "7.69",
				"Salary total calculations for 'Bi-Weekly' are getting wrong.");
		PaystubWebFormPage.enterSalaryRate(1, "25000");
		soft26.assertEquals(getTextValueOfWebElementID("total1"), "961.54");
		soft26.assertEquals(paystubTemplate1.getTemplate1SalaryTotal(), "961.54",
				"Salary total calculations for 'Bi-Weekly' are getting wrong.");
		soft26.assertAll();
	}

	@Test(enabled = false, priority = 27, description = "27. Verify the Salary Total value With payment type as 'Salary'. and How often you paied is set to 'Semi-Monthly (ex: 1st and 15th)'")
	public void verifySalaryTotalValueSemiMonthly() throws InterruptedException {
		SoftAssert soft27 = new SoftAssert();
		browserdriver.navigate().refresh();
		PaystubWebFormPage.selectPaymentType("Salary");
		PaystubWebFormPage.select_how_often_you_paid("Semi-Monthly (ex: 1st and 15th)");
		PaystubWebFormPage.enterSalaryRate(1, "200");
		soft27.assertEquals(getTextValueOfWebElementID("total1"), "8.33");
		soft27.assertEquals(paystubTemplate1.getTemplate1SalaryTotal(), "8.33",
				"Salary total calculations for 'Semi-Monthly' are getting wrong.");
		PaystubWebFormPage.enterSalaryRate(1, "25000");
		soft27.assertEquals(getTextValueOfWebElementID("total1"), "1041.67");
		soft27.assertEquals(paystubTemplate1.getTemplate1SalaryTotal(), "1041.67",
				"Salary total calculations for 'Semi-Monthly' are getting wrong.");
		soft27.assertAll();
	}

	@Test(priority = 28, description = "28. Verify the Salary Total value With payment type as 'Salary'. and How often you paied is set to 'Quarterly'")
	public void verifySalaryTotalValueQuarterly() throws InterruptedException {
		SoftAssert soft28 = new SoftAssert();
		browserdriver.navigate().refresh();
		PaystubWebFormPage.selectPaymentType("Salary");
		PaystubWebFormPage.select_how_often_you_paid("Quarterly");
		PaystubWebFormPage.enterSalaryRate(1, "200");
		soft28.assertEquals(getTextValueOfWebElementID("total1"), "50.00");
		soft28.assertEquals(paystubTemplate1.getTemplate1SalaryTotal(), "50.00",
				"Salary total calculations for 'Quarterly' are getting wrong.");//// This calculations I guess is wrong.
		PaystubWebFormPage.enterSalaryRate(1, "25000");
		soft28.assertEquals(getTextValueOfWebElementID("total1"), "6250.00");
		soft28.assertEquals(paystubTemplate1.getTemplate1SalaryTotal(), "6250.00",
				"Salary total calculations for 'Quarterly' are getting wrong.");//// This calculations I guess is wrong.
		soft28.assertAll();
	}

	@Test(priority = 29, description = "29. Verify the Salary Total value With payment type as 'Salary'. and How often you paied is set to 'Semi-Annually'")
	public void verifySalaryTotalValueSemiAnnually() throws InterruptedException {
		SoftAssert soft29 = new SoftAssert();
		browserdriver.navigate().refresh();
		PaystubWebFormPage.selectPaymentType("Salary");
		PaystubWebFormPage.select_how_often_you_paid("Semi-Annually");
		PaystubWebFormPage.enterSalaryRate(1, "200");
		soft29.assertEquals(getTextValueOfWebElementID("total1"), "100.00");
		soft29.assertEquals(paystubTemplate1.getTemplate1SalaryTotal(), "100.00",
				"Salary total calculations for 'Semi-Annually' are getting wrong.");
		PaystubWebFormPage.enterSalaryRate(1, "25000");
		soft29.assertEquals(getTextValueOfWebElementID("total1"), "12500.00");
		soft29.assertEquals(paystubTemplate1.getTemplate1SalaryTotal(), "12500.00",
				"Salary total calculations for 'Semi-Annually' are getting wrong.");
		soft29.assertAll();
	}

	@Test(priority = 30, description = "30. Verify the Salary Total value With payment type as 'Salary'. and How often you paied is set to 'Annually'")
	public void verifySalaryTotalValueAnnually() throws InterruptedException {
		SoftAssert soft30 = new SoftAssert();
		browserdriver.navigate().refresh();
		PaystubWebFormPage.selectPaymentType("Salary");
		PaystubWebFormPage.select_how_often_you_paid("Annually");
		PaystubWebFormPage.enterSalaryRate(1, "200");
		soft30.assertEquals(getTextValueOfWebElementID("total1"), "200.00");
		soft30.assertEquals(paystubTemplate1.getTemplate1SalaryTotal(), "200.00",
				"Salary total calculations for 'Annually' are getting wrong.");
		PaystubWebFormPage.enterSalaryRate(1, "25000");
		soft30.assertEquals(getTextValueOfWebElementID("total1"), "25000.00");
		soft30.assertEquals(paystubTemplate1.getTemplate1SalaryTotal(), "25000.00",
				"Salary total calculations for 'Annually' are getting wrong.");
		soft30.assertAll();
	}

	@Test(priority = 31, description = "31. Verify 'Enter in previous YTD calculations?' gross paytotal value")
	public void verifyGrossPayTotalInPreviousYTDCalculations() throws InterruptedException {
		browserdriver.navigate().refresh();

		PaystubWebFormPage.enterInPreviousYTDCalculations("Yes");
		PaystubWebFormPage.enterRegularYTDInPrevious("3600");
		PaystubWebFormPage.enterOverTimeYTDInPrevious("400");
		PaystubWebFormPage.enterHolidayYTDInPrevious("200");
		PaystubWebFormPage.enterVacationYTDInPrevious("300");
		PaystubWebFormPage.enterBonusYTDInPrevious("500");
		PaystubWebFormPage.enterFloatYTDInPrevious("600");
		PaystubWebFormPage.enterTipsYTDInPrevious("700");
		Assert.assertEquals(getTextValueOfWebElementID("pre_tytd"), "6,300.00");
	}

	@Test(priority = 32, description = "32. Verify Paystub Calculations On entering Previous YTD Calculations", dependsOnMethods = "verifyGrossPayTotalInPreviousYTDCalculations")
	public void verifyPaystubCalculationsOnenteringPreviousYTDCalculations() throws InterruptedException {
		SoftAssert soft32 = new SoftAssert();
		soft32.assertEquals(getTextValueOfWebElementID("ytd1", 1), "4,000.00");
		soft32.assertEquals(getTextValueOfWebElementID("ytd2", 1), "400.00");
		soft32.assertEquals(getTextValueOfWebElementID("ytd3", 1), "200.00");
		soft32.assertEquals(getTextValueOfWebElementID("ytd4", 1), "300.00");
		soft32.assertEquals(getTextValueOfWebElementID("ytd5", 1), "500.00");
		soft32.assertEquals(getTextValueOfWebElementID("ytd6", 1), "600.00");
		soft32.assertEquals(getTextValueOfWebElementID("ytd7", 1), "700.00");

		PaystubWebFormPage.select_NoOfPaystubsNeeded(3);
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Feb", "1");
		// PaystubWebFormPage.enterRegularYTDInPrevious("3700");

		// Verify ytd values of 1st paystub
		soft32.assertEquals(getTextValueOfWebElementID("ytd1", 1), "800.00");
		soft32.assertEquals(getTextValueOfWebElementID("ytd2", 1), "0.00");
		soft32.assertEquals(getTextValueOfWebElementID("ytd3", 1), "0.00");
		soft32.assertEquals(getTextValueOfWebElementID("ytd4", 1), "0.00");
		soft32.assertEquals(getTextValueOfWebElementID("ytd5", 1), "0.00");
		soft32.assertEquals(getTextValueOfWebElementID("ytd6", 1), "0.00");
		soft32.assertEquals(getTextValueOfWebElementID("ytd7", 1), "0.00");

		// Verify ytd values of 2nd paystub
		soft32.assertEquals(getTextValueOfWebElementID("ytd1", 2), "400.00");
		soft32.assertEquals(getTextValueOfWebElementID("ytd2", 2), "0.00");
		soft32.assertEquals(getTextValueOfWebElementID("ytd3", 2), "0.00");
		soft32.assertEquals(getTextValueOfWebElementID("ytd4", 2), "0.00");
		soft32.assertEquals(getTextValueOfWebElementID("ytd5", 2), "0.00");
		soft32.assertEquals(getTextValueOfWebElementID("ytd6", 2), "0.00");
		soft32.assertEquals(getTextValueOfWebElementID("ytd7", 2), "0.00");

		// Verify ytd values of 3rd paystub
		soft32.assertEquals(getTextValueOfWebElementID("ytd1", 3), "4,000.00");
		soft32.assertEquals(getTextValueOfWebElementID("ytd2", 3), "400.00");
		soft32.assertEquals(getTextValueOfWebElementID("ytd3", 3), "200.00");
		soft32.assertEquals(getTextValueOfWebElementID("ytd4", 3), "300.00");
		soft32.assertEquals(getTextValueOfWebElementID("ytd5", 3), "500.00");
		soft32.assertEquals(getTextValueOfWebElementID("ytd6", 3), "600.00");
		soft32.assertEquals(getTextValueOfWebElementID("ytd7", 3), "700.00");
		soft32.assertAll();
	}

	@Test(priority = 33, description = "33. Verify Total calculations of all the deductions with single paystub")
	public void verifyPaystubTotalDeductions() throws InterruptedException {
		SoftAssert soft33 = new SoftAssert();
		

		PaystubWebFormPage.selectEmployee_State("New Jersey");
		PaystubWebFormPage.enterRegularRates(1, "900");
		PaystubWebFormPage.enterRegularHours(1, "9");
		PaystubWebFormPage.enterOverTimeRate(1, "12");
		PaystubWebFormPage.enterOverTimeHours(1, "8");
		PaystubWebFormPage.enterHolidayRate(1, "250");
		PaystubWebFormPage.enterHolidayHours(1, "24");
		PaystubWebFormPage.enterVacationRate(1, "600");
		PaystubWebFormPage.enterVacationHours(1, "24");
		PaystubWebFormPage.enterBonusRate(1, "15000");
		PaystubWebFormPage.enterBonusHours(1, "24");
		PaystubWebFormPage.enterFloatRate(1, "900.33");
		PaystubWebFormPage.enterFloatHours(1, "9");
		PaystubWebFormPage.enterTipsRate(1, "50");
		soft33.assertEquals(getTextValueOfWebElementID("deductions", 1),
				PaystubWebFormPage.getTotalDeductionsOfPaystub(1)); // Verify total deductions
		soft33.assertAll();
	}

	@Test(priority = 34, description = "34. Verify Pay period durations when 'How often are you paid?' is set to 'Monthly' ")
	public void verifyPaystubPayPeriodDurations() throws InterruptedException {
		SoftAssert soft34 = new SoftAssert();
//		browserdriver.navigate().refresh();
//		String state = browserdriver.manage().window().getPosition().getX() == 0
//				&& browserdriver.manage().window().getPosition().getY() == 0
//				&& browserdriver.manage().window().getSize().getWidth() == Toolkit.getDefaultToolkit().getScreenSize()
//						.getWidth()
//				&& browserdriver.manage().window().getSize().getHeight() == Toolkit.getDefaultToolkit().getScreenSize()
//						.getHeight() ? "maximized" : "normal";
//		if (state.equals("normal")) {
//			browserdriver.manage().window().maximize();
//		}
		PaystubWebFormPage.select_NoOfPaystubsNeeded(3);
		PaystubWebFormPage.select_how_often_you_paid("Monthly (ex: 1st of month only)");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Jan", "1");
		soft34.assertEquals(PaystubWebFormPage.getPay_period_start(1), "01/01/2023");
		soft34.assertEquals(PaystubWebFormPage.getpay_period_end(1), "01/31/2023");
		soft34.assertEquals(PaystubWebFormPage.getPayPeriodpay_date(1), "01/31/2023");
		soft34.assertEquals(PaystubWebFormPage.getPay_period_start(2), "12/01/2022");
		soft34.assertEquals(PaystubWebFormPage.getpay_period_end(2), "12/31/2022");
		soft34.assertEquals(PaystubWebFormPage.getPayPeriodpay_date(2), "12/31/2022");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Feb", "1");
		soft34.assertEquals(PaystubWebFormPage.getPay_period_start(1), "02/01/2023");
		soft34.assertEquals(PaystubWebFormPage.getpay_period_end(1), "02/28/2023");
		soft34.assertEquals(PaystubWebFormPage.getPayPeriodpay_date(1), "02/28/2023");
		soft34.assertEquals(PaystubWebFormPage.getPay_period_start(2), "01/01/2023");
		soft34.assertEquals(PaystubWebFormPage.getpay_period_end(2), "01/31/2023");
		soft34.assertEquals(PaystubWebFormPage.getPayPeriodpay_date(2), "01/31/2023");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Apr", "1");
		soft34.assertEquals(PaystubWebFormPage.getPay_period_start(1), "04/01/2023");
		soft34.assertEquals(PaystubWebFormPage.getpay_period_end(1), "04/30/2023");
		soft34.assertEquals(PaystubWebFormPage.getPayPeriodpay_date(1), "04/30/2023");
		soft34.assertEquals(PaystubWebFormPage.getPay_period_start(2), "03/01/2023");
		soft34.assertEquals(PaystubWebFormPage.getpay_period_end(2), "03/31/2023");
		soft34.assertEquals(PaystubWebFormPage.getPayPeriodpay_date(2), "03/31/2023");

		soft34.assertAll();
	}

	@Test(priority = 35, description = "35. Verify Pay period durations when 'How often are you paid?' is set to 'Daily' ")
	public void verifyPayPeriodDurations() throws InterruptedException {
		SoftAssert soft35 = new SoftAssert();
		PaystubWebFormPage.select_how_often_you_paid("Daily");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Jan", "1");
		soft35.assertEquals(PaystubWebFormPage.getPay_period_start(1), "01/01/2023");
		soft35.assertEquals(PaystubWebFormPage.getpay_period_end(1), "01/01/2023");
		soft35.assertEquals(PaystubWebFormPage.getPayPeriodpay_date(1), "01/01/2023");
		soft35.assertEquals(PaystubWebFormPage.getPay_period_start(2), "12/31/2022");
		soft35.assertEquals(PaystubWebFormPage.getpay_period_end(2), "12/31/2022");
		soft35.assertEquals(PaystubWebFormPage.getPayPeriodpay_date(2), "12/31/2022");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Feb", "15");
		soft35.assertEquals(PaystubWebFormPage.getPay_period_start(1), "02/15/2023");
		soft35.assertEquals(PaystubWebFormPage.getpay_period_end(1), "02/15/2023");
		soft35.assertEquals(PaystubWebFormPage.getPayPeriodpay_date(1), "02/15/2023");
		soft35.assertEquals(PaystubWebFormPage.getPay_period_start(2), "02/14/2023");
		soft35.assertEquals(PaystubWebFormPage.getpay_period_end(2), "02/14/2023");
		soft35.assertEquals(PaystubWebFormPage.getPayPeriodpay_date(2), "02/14/2023");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Apr", "30");
		soft35.assertEquals(PaystubWebFormPage.getPay_period_start(1), "04/30/2023");
		soft35.assertEquals(PaystubWebFormPage.getpay_period_end(1), "04/30/2023");
		soft35.assertEquals(PaystubWebFormPage.getPayPeriodpay_date(1), "04/30/2023");

		soft35.assertAll();
	}

	@Test(priority = 36, description = "36. Verify Pay period durations when 'How often are you paid?' is set to 'Weekly' ")
	public void verifyPayPeriodDuration() throws InterruptedException {
		SoftAssert soft36 = new SoftAssert();
		PaystubWebFormPage.select_how_often_you_paid("Weekly (ex: every Friday)");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Jan", "1");
		soft36.assertEquals(PaystubWebFormPage.getPay_period_start(1), "01/01/2023");
		soft36.assertEquals(PaystubWebFormPage.getpay_period_end(1), "01/07/2023");
		soft36.assertEquals(PaystubWebFormPage.getPayPeriodpay_date(1), "01/07/2023");
		soft36.assertEquals(PaystubWebFormPage.getPay_period_start(2), "12/25/2022");
		soft36.assertEquals(PaystubWebFormPage.getpay_period_end(2), "12/31/2022");
		soft36.assertEquals(PaystubWebFormPage.getPayPeriodpay_date(2), "12/31/2022");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Feb", "15");
		soft36.assertEquals(PaystubWebFormPage.getPay_period_start(1), "02/15/2023");
		soft36.assertEquals(PaystubWebFormPage.getpay_period_end(1), "02/21/2023");
		soft36.assertEquals(PaystubWebFormPage.getPayPeriodpay_date(1), "02/21/2023");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Apr", "30");
		soft36.assertEquals(PaystubWebFormPage.getPay_period_start(1), "04/30/2023");
		soft36.assertEquals(PaystubWebFormPage.getpay_period_end(1), "05/06/2023");
		soft36.assertEquals(PaystubWebFormPage.getPayPeriodpay_date(1), "05/06/2023");
		soft36.assertAll();
	}

	@Test(priority = 37, description = "37. Verify Pay period durations when 'How often are you paid?' is set to 'Bi-Weekly' ")
	public void verifyPayPeriodDurationInBiWeekly() throws InterruptedException {
		SoftAssert soft37 = new SoftAssert();
		PaystubWebFormPage.select_how_often_you_paid("Bi-Weekly (ex: every other Wednesday)");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Jan", "1");
		soft37.assertEquals(PaystubWebFormPage.getPay_period_start(1), "01/01/2023");
		soft37.assertEquals(PaystubWebFormPage.getpay_period_end(1), "01/14/2023");
		soft37.assertEquals(PaystubWebFormPage.getPayPeriodpay_date(1), "01/14/2023");
		soft37.assertEquals(PaystubWebFormPage.getPay_period_start(2), "12/18/2022");
		soft37.assertEquals(PaystubWebFormPage.getpay_period_end(2), "12/31/2022");
		soft37.assertEquals(PaystubWebFormPage.getPayPeriodpay_date(2), "12/31/2022");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Feb", "15");
		soft37.assertEquals(PaystubWebFormPage.getPay_period_start(1), "02/15/2023");
		soft37.assertEquals(PaystubWebFormPage.getpay_period_end(1), "02/28/2023");
		soft37.assertEquals(PaystubWebFormPage.getPayPeriodpay_date(1), "02/28/2023");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Apr", "30");
		soft37.assertEquals(PaystubWebFormPage.getPay_period_start(1), "04/30/2023");
		soft37.assertEquals(PaystubWebFormPage.getpay_period_end(1), "05/13/2023");
		soft37.assertEquals(PaystubWebFormPage.getPayPeriodpay_date(1), "05/13/2023");
		soft37.assertAll();
	}

	@Test(enabled = false, priority = 38, description = "38. Verify Pay period durations when 'How often are you paid?' is set to 'Semi-Monthly' ")
	public void verifyPayPeriodDurationInSemiMonthly() throws InterruptedException {
		SoftAssert soft38 = new SoftAssert();
		PaystubWebFormPage.select_how_often_you_paid("Semi-Monthly (ex: 1st and 15th)");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Jan", "1");
		soft38.assertEquals(PaystubWebFormPage.getPay_period_start(1), "01/01/2023");
		soft38.assertEquals(PaystubWebFormPage.getpay_period_end(1), "01/15/2023");
		soft38.assertEquals(PaystubWebFormPage.getPayPeriodpay_date(1), "01/15/2023");
		soft38.assertEquals(PaystubWebFormPage.getPay_period_start(2), "12/17/2022");
		soft38.assertEquals(PaystubWebFormPage.getpay_period_end(2), "12/31/2022");
		soft38.assertEquals(PaystubWebFormPage.getPayPeriodpay_date(2), "12/31/2022");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Feb", "15");
		soft38.assertEquals(PaystubWebFormPage.getPay_period_start(1), "02/15/2023");
		soft38.assertEquals(PaystubWebFormPage.getpay_period_end(1), "03/01/2023");
		soft38.assertEquals(PaystubWebFormPage.getPayPeriodpay_date(1), "03/01/2023");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Apr", "30");
		soft38.assertEquals(PaystubWebFormPage.getPay_period_start(1), "04/30/2023");
		soft38.assertEquals(PaystubWebFormPage.getpay_period_end(1), "05/14/2023");
		soft38.assertEquals(PaystubWebFormPage.getPayPeriodpay_date(1), "05/14/2023");
		soft38.assertAll();
	}

	@Test(priority = 39, description = "39. Verify Pay period durations when 'How often are you paid?' is set to 'Quarterly' ")
	public void verifyPayPeriodDurationInQuarterly() throws InterruptedException {
		SoftAssert soft39 = new SoftAssert();
		PaystubWebFormPage.select_how_often_you_paid("Quarterly");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Jan", "1");
		soft39.assertEquals(PaystubWebFormPage.getPay_period_start(1), "01/01/2023");
		soft39.assertEquals(PaystubWebFormPage.getpay_period_end(1), "03/31/2023");
		soft39.assertEquals(PaystubWebFormPage.getPayPeriodpay_date(1), "03/31/2023");
		soft39.assertEquals(PaystubWebFormPage.getPay_period_start(2), "10/02/2022");
		soft39.assertEquals(PaystubWebFormPage.getpay_period_end(2), "01/01/2023");
		soft39.assertEquals(PaystubWebFormPage.getPayPeriodpay_date(2), "01/01/2023");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Feb", "15");
		soft39.assertEquals(PaystubWebFormPage.getPay_period_start(1), "02/15/2023");
		soft39.assertEquals(PaystubWebFormPage.getpay_period_end(1), "05/14/2023");
		soft39.assertEquals(PaystubWebFormPage.getPayPeriodpay_date(1), "05/14/2023");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Apr", "30");
		soft39.assertEquals(PaystubWebFormPage.getPay_period_start(1), "04/30/2023");
		soft39.assertEquals(PaystubWebFormPage.getpay_period_end(1), "07/29/2023");
		soft39.assertEquals(PaystubWebFormPage.getPayPeriodpay_date(1), "07/29/2023");
		soft39.assertAll();
	}

	@Test(priority = 40, description = "40. Verify Pay period durations when 'How often are you paid?' is set to 'Semi-Annually' ")
	public void verifyPayPeriodDurationInSemiAnnually() throws InterruptedException {
		SoftAssert soft40 = new SoftAssert();
		PaystubWebFormPage.select_how_often_you_paid("Semi-Annually");
		PaystubWebFormPage.select_NoOfPaystubsNeeded(2);
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Jan", "1");
		soft40.assertEquals(PaystubWebFormPage.getPay_period_start(1), "01/01/2023");
		soft40.assertEquals(PaystubWebFormPage.getpay_period_end(1), "06/30/2023");
		soft40.assertEquals(PaystubWebFormPage.getPayPeriodpay_date(1), "06/30/2023");
		soft40.assertEquals(PaystubWebFormPage.getPay_period_start(2), "07/02/2022");
		soft40.assertEquals(PaystubWebFormPage.getpay_period_end(2), "01/01/2023");
		soft40.assertEquals(PaystubWebFormPage.getPayPeriodpay_date(2), "01/01/2023");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Feb", "15");
		soft40.assertEquals(PaystubWebFormPage.getPay_period_start(1), "02/15/2023");
		soft40.assertEquals(PaystubWebFormPage.getpay_period_end(1), "08/14/2023");
		soft40.assertEquals(PaystubWebFormPage.getPayPeriodpay_date(1), "08/14/2023");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Apr", "30");
		soft40.assertEquals(PaystubWebFormPage.getPay_period_start(1), "04/30/2023");
		soft40.assertEquals(PaystubWebFormPage.getpay_period_end(1), "10/29/2023");
		soft40.assertEquals(PaystubWebFormPage.getPayPeriodpay_date(1), "10/29/2023");
		soft40.assertAll();
	}

	@Test(priority = 41, description = "41. Verify Pay period durations when 'How often are you paid?' is set to 'Annually' ")
	public void verifyPayPeriodDurationInAnnually() throws InterruptedException {
		SoftAssert soft40 = new SoftAssert();
		PaystubWebFormPage.select_how_often_you_paid("Annually");
		// PaystubWebFormPage.select_NoOfPaystubsNeeded("2");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Jan", "1");
		soft40.assertEquals(PaystubWebFormPage.getPay_period_start(1), "01/01/2023");
		soft40.assertEquals(PaystubWebFormPage.getpay_period_end(1), "12/31/2023");
		soft40.assertEquals(PaystubWebFormPage.getPayPeriodpay_date(1), "12/31/2023");
		soft40.assertAll();
	}

	@Test(priority = 42, description = "42. Verify the pdf file downloaded with the data added.")
	public void verifyPdfData() throws InterruptedException, IOException {
		SoftAssert soft42 = new SoftAssert();

		// enter company details
		PaystubWebFormPage.enterEmployer_name(propConnection.getProperty("PaystubEmployerName"));
		PaystubWebFormPage.enterEmployerNumber(propConnection.getProperty("PaystubEmployerTelephoneNumber"));
		PaystubWebFormPage.enterEmployerAddress(propConnection.getProperty("PaystubEmployerStreetAddress1"));
		PaystubWebFormPage.enterEmployerAddress2(propConnection.getProperty("PaystubEmployerStreetAddress2"));
		PaystubWebFormPage.enterEmployerCity(propConnection.getProperty("PaystubCompanyCity"));
		PaystubWebFormPage.selectEmployerState(propConnection.getProperty("PaystubCompanyState"));
		PaystubWebFormPage.enterEmployerZipCode(propConnection.getProperty("PaystubCompanyZipCode"));
		// PaystubWebFormPage.enterEmployerLogoUpload();

		// Enter Employee details
		PaystubWebFormPage.enterEmployee_Name(propConnection.getProperty("PaystubEmployerName"));
		PaystubWebFormPage.enterEmployee_Social(propConnection.getProperty("PaystubEmployeeSocialNumber"));
		PaystubWebFormPage.enterEmployee_Id(propConnection.getProperty("PaystubEmployeeID"));
		PaystubWebFormPage.enterEmployee_Telephone_Number(propConnection.getProperty("PaystubEmployeeTelephoneNumber"));
		PaystubWebFormPage.enterEmployee_Address(propConnection.getProperty("PaystubEmployeeAddress1"));
		PaystubWebFormPage.enterEmployee_Address_2(propConnection.getProperty("PaystubEmployeeAddress2"));
		PaystubWebFormPage.enterEmployee_City(propConnection.getProperty("PaystubEmployeeCity"));
		PaystubWebFormPage.selectEmployee_State(propConnection.getProperty("PaystubEmployeeState"));
		PaystubWebFormPage.enterEmployee_Zip_Code(propConnection.getProperty("PaystubEmployeeZipCode"));
		PaystubWebFormPage.selectEmployee_Marital_Status(propConnection.getProperty("PaystubEmployeeMaritalStatus"));
		PaystubWebFormPage.selectExemptions(propConnection.getProperty("PaystubEmployeeExemptions"));
		PaystubWebFormPage.markIs_direct_deposit();
		PaystubWebFormPage.enterBank_Checking_Account(propConnection.getProperty("Bank_Checking_Account"));

		// PaystubWebFormPage.markIs_direct_deposit_no();
		PaystubWebFormPage.select_NoOfPaystubsNeeded(2);
		PaystubWebFormPage.enterRegularRates(1, "900");
		PaystubWebFormPage.enterRegularHours(1, "9");
		PaystubWebFormPage.enterOverTimeRate(1, "12");
		PaystubWebFormPage.enterOverTimeHours(1, "8");
		PaystubWebFormPage.enterHolidayRate(1, "250");
		PaystubWebFormPage.enterHolidayHours(1, "24");
		PaystubWebFormPage.enterVacationRate(1, "600");
		PaystubWebFormPage.enterVacationHours(1, "24");
		PaystubWebFormPage.enterBonusRate(1, "15000");
		PaystubWebFormPage.enterBonusHours(1, "24");
		PaystubWebFormPage.enterFloatRate(1, "900.33");
		PaystubWebFormPage.enterFloatHours(1, "9");
		PaystubWebFormPage.enterTipsRate(1, "50");
		PaystubWebFormPage.pressAddEarnings();
		PaystubWebFormPage.entercustom_earning_Name(1, 1, "test name");
		PaystubWebFormPage.enterCustom_earningRate(1, 1, "12");
		PaystubWebFormPage.enterCustom_earningHours(1, 1, "24");
		// Enter Custom deductions
		PaystubWebFormPage.pressAddDeductions();
		PaystubWebFormPage.enterCustomDeductionName(1, 1, "Custom deduction");
		PaystubWebFormPage.enterCistomDeductions(1, "200.00");

		PaystubWebFormPage.enterRegularRates(2, "22");
		PaystubWebFormPage.enterRegularHours(2, "40.00");
		PaystubWebFormPage.enterOverTimeRate(2, "12");
		PaystubWebFormPage.enterOverTimeHours(2, "8");
		PaystubWebFormPage.enterHolidayRate(2, "250");
		PaystubWebFormPage.enterHolidayHours(2, "24");
		PaystubWebFormPage.enterVacationRate(2, "600");
		PaystubWebFormPage.enterVacationHours(2, "24");
		PaystubWebFormPage.enterBonusRate(2, "15000");
		PaystubWebFormPage.enterBonusHours(2, "24");
		PaystubWebFormPage.enterFloatRate(2, "900.33");
		PaystubWebFormPage.enterFloatHours(2, "9");
		PaystubWebFormPage.enterTipsRate(2, "50");
		PaystubWebFormPage.entercustom_earning_Name(2, 1, "test name");
		PaystubWebFormPage.enterCustom_earningRate(2, 1, "22");
		PaystubWebFormPage.enterCustom_earningHours(2, 1, "33");
		PaystubWebFormPage.pressAddDeductions();
		PaystubWebFormPage.enterCustomDeductionName(1, 2, "test deduction");
		PaystubWebFormPage.enterCistomDeductions(1, "222.0");
		PaystubWebFormPage.pressCheckoutButton();
		PaystubWebFormPage.pressLoginAndCheckout();
		PaystubWebFormPage.enterEmailID(propConnection.getProperty("username"));
		PaystubWebFormPage.enterPassword(propConnection.getProperty("pass"));
		PaystubWebFormPage.pressSignIn();
		PaystubWebFormPage.enterCoupon(propConnection.getProperty("CouponCode"));
		PaystubWebFormPage.pressApplyCoupon();
		PaystubWebFormPage.pressProcced_nowButton();
		PaystubWebFormPage.pressDownloadButton();
		String[] pdflistfile = PaystubWebFormPage.getDownloadedPDFFile();

		String pdfdata1 = PaystubWebFormPage.verifyPdfFile(1);
		String pdfdata2 = PaystubWebFormPage.verifyPdfFile(2);
		System.out.println("PDF1=" + pdflistfile[0]);
		System.out.println(PaystubWebFormPage.verifyPdfFile(1));

		System.out.println("PDF2=" + pdflistfile[1]);
		System.out.println(PaystubWebFormPage.verifyPdfFile(2));

		soft42.assertEquals(PaystubWebFormPage.getNumberOfPagesOfPdf(1), 1, "Number of pages for Paystub 1");
		soft42.assertEquals(PaystubWebFormPage.getNumberOfPagesOfPdf(2), 1, "Number of pages for Paystub 2");

		System.out.println(pdfdata1);
		soft42.assertTrue(pdfdata1.contains(propConnection.getProperty("PaystubEmployerName")),
				"Employer name is not mentioned in pdf");
		soft42.assertTrue(pdfdata1.contains(propConnection.getProperty("PaystubEmployerTelephoneNumber")),
				"EmployerTelephoneNumber is not mentioned in pdf");
		soft42.assertTrue(pdfdata1.contains(propConnection.getProperty("PaystubEmployerStreetAddress1")),
				"PaystubEmployerStreetAddress1 is not mentioned in pdf");
		soft42.assertTrue(pdfdata1.contains(propConnection.getProperty("PaystubEmployerStreetAddress2")),
				"PaystubEmployerStreetAddress2 is not mentioned in pdf");
		soft42.assertTrue(pdfdata1.contains(propConnection.getProperty("PaystubCompanyCity")),
				"PaystubCompanyCity is not mentioned in pdf");
		soft42.assertTrue(pdfdata1.contains(propConnection.getProperty("PaystubCompanyState")),
				"PaystubCompanyState is not mentioned in pdf");
		soft42.assertTrue(pdfdata1.contains(propConnection.getProperty("PaystubCompanyZipCode")),
				"PaystubCompanyZipCode is not mentioned in pdf");
		soft42.assertTrue(pdfdata1.contains(propConnection.getProperty("PaystubEmployerName")),
				"PaystubEmployerName is not mentioned in pdf");
		soft42.assertTrue(pdfdata1.contains(propConnection.getProperty("PaystubEmployeeSocialNumber")),
				"PaystubEmployeeSocialNumber is not mentioned in pdf");
		soft42.assertTrue(pdfdata1.contains(propConnection.getProperty("PaystubEmployeeID")),
				"PaystubEmployeeID is not mentioned in pdf");
		soft42.assertTrue(pdfdata1.contains(propConnection.getProperty("PaystubEmployeeTelephoneNumber")),
				"PaystubEmployeeTelephoneNumber is not mentioned in pdf");
		soft42.assertTrue(pdfdata1.contains(propConnection.getProperty("PaystubEmployeeAddress1")),
				"PaystubEmployeeAddress1 is not mentioned in pdf");
		soft42.assertTrue(pdfdata1.contains(propConnection.getProperty("PaystubEmployeeAddress2")),
				"PaystubEmployeeAddress2 is not mentioned in pdf");
		soft42.assertTrue(pdfdata1.contains(propConnection.getProperty("PaystubEmployeeCity")),
				"PaystubEmployeeCity is not mentioned in pdf");
		soft42.assertTrue(pdfdata1.contains(propConnection.getProperty("PaystubEmployeeState")),
				"PaystubEmployeeState is not mentioned in pdf");
		soft42.assertTrue(pdfdata1.contains(propConnection.getProperty("PaystubEmployeeZipCode")),
				"PaystubEmployeeZipCode is not mentioned in pdf");
		soft42.assertTrue(pdfdata1.contains(propConnection.getProperty("PaystubEmployeeMaritalStatus")),
				"PaystubEmployeeMaritalStatus is not mentioned in pdf");
		soft42.assertTrue(pdfdata1.contains(propConnection.getProperty("PaystubEmployeeExemptions")),
				"PaystubEmployeeExemptions is not mentioned in pdf");
		soft42.assertTrue(pdfdata1.contains(propConnection.getProperty("Bank_Checking_Account")),
				"Bank_Checking_Account is not mentioned in pdf");

		soft42.assertAll();

	}

	@Test(priority = 43, description = "43. Verify gross payTotal and YTDTotal calculations on removing the custom earnings.")
	public void verifyGrossPayTotalAndYTDTotalOnRemovingCustomEarnings() throws InterruptedException, IOException {
		SoftAssert soft43 = new SoftAssert();
		
		PaystubWebFormPage.select_NoOfPaystubsNeeded(2);
		PaystubWebFormPage.enterRegularRates(1, "900");
		PaystubWebFormPage.enterRegularHours(1, "9");
		PaystubWebFormPage.enterOverTimeRate(1, "12");
		PaystubWebFormPage.enterOverTimeHours(1, "8");
		PaystubWebFormPage.enterHolidayRate(1, "250");
		PaystubWebFormPage.enterHolidayHours(1, "24");
		PaystubWebFormPage.enterVacationRate(1, "600");
		PaystubWebFormPage.enterVacationHours(1, "24");
		PaystubWebFormPage.enterBonusRate(1, "15000");
		PaystubWebFormPage.enterBonusHours(1, "24");
		PaystubWebFormPage.enterFloatRate(1, "900.33");
		PaystubWebFormPage.enterFloatHours(1, "9");
		PaystubWebFormPage.enterTipsRate(1, "50");
		PaystubWebFormPage.pressAddEarnings();
		PaystubWebFormPage.entercustom_earning_Name(1, 1, "test name");
		PaystubWebFormPage.enterCustom_earningRate(1, 1, "12");
		PaystubWebFormPage.enterCustom_earningHours(1, 1, "24");
		PaystubWebFormPage.pressAddEarnings();
		PaystubWebFormPage.entercustom_earning_Name(1, 2, "Custom earnings");
		PaystubWebFormPage.enterCustom_earningRate(1, 2, "223");
		PaystubWebFormPage.enterCustom_earningHours(1, 2, "40");
		soft43.assertEquals(getTextValueOfWebElementID("custome_earnings_total_1"), "288.00",
				"Custom earning total 1 is wrong");
		soft43.assertEquals(getTextValueOfWebElementID("custome_earnings_ytd1"), "864.00",
				"Custom earning total 1 is wrong");
		soft43.assertEquals(getTextValueOfWebElementID("custome_earnings_total_2"), "8,920.00",
				"Custom earning total 1 is wrong");
		soft43.assertEquals(getTextValueOfWebElementID("custome_earnings_ytd2"), "26,760.00",
				"Custom earning total 1 is wrong");
		soft43.assertEquals(getTextValueOfWebElementID("tcurrent"), "405,956.97", "Gross Pay Total value is wrong.");
		soft43.assertEquals(getTextValueOfWebElementID("tytd"), "425,172.97", "Gross Pay YTD Total value is wrong.");
		soft43.assertEquals(PaystubWebFormPage.pressRemoveCustomEarning(1), true, "The Custom earning did not removed");
		soft43.assertEquals(getTextValueOfWebElementID("tcurrent"), "405,668.97", "Gross Pay Total value is wrong.");
		soft43.assertEquals(getTextValueOfWebElementID("tytd"), "424,308.97", "Gross Pay YTD Total value is wrong.");
		soft43.assertEquals(PaystubWebFormPage.pressRemoveCustomEarning(2), true,
				"The Custom earning did not removed second time");
		soft43.assertEquals(getTextValueOfWebElementID("tcurrent"), "405,668.97", "Gross Pay Total value is wrong.");
		soft43.assertEquals(getTextValueOfWebElementID("tytd"), "424,308.97", "Gross Pay YTD Total value is wrong.");
		soft43.assertAll();
	}

	@Test(priority = 44, description = "44. Verify gross DEDUCTION TOTAL and Deduction YTDTotal calculations on removing the custom deductions")
	public void verifyDeductionTotalAndDeductionYTDTotalOnRemovingCustomEarnings()
			throws InterruptedException, IOException {
		SoftAssert soft44 = new SoftAssert();

		PaystubWebFormPage.pressAddDeductions();
		PaystubWebFormPage.enterCustomDeductionName(1, 1, "Deduction1");
		PaystubWebFormPage.enterCistomDeductions(1, "123.33");
		PaystubWebFormPage.pressAddDeductions();
		PaystubWebFormPage.enterCustomDeductionName(1, 2, "Deduction2");
		PaystubWebFormPage.enterCistomDeductions(2, "23.33");
		soft44.assertEquals(getTextValueOfWebElementID("deductions"), "184.09", "Deductions total value is wrong.");
		soft44.assertEquals(PaystubWebFormPage.pressRemoveCustomDeductions(1), true,
				"The custom deduction 1 did not removed");
		soft44.assertEquals(getTextValueOfWebElementID("deductions"), "60.76", "Deductions total value is wrong.");
		soft44.assertEquals(PaystubWebFormPage.pressRemoveCustomDeductions(2), true,
				"The custom deduction 2 did not removed");
		soft44.assertEquals(getTextValueOfWebElementID("deductions"), "37.43", "Deductions total value is wrong.");
		soft44.assertAll();
	}

	@Test(priority = 45, dataProvider = "testLogindata", description = "45 Verify validation of the login module on providing invalid inputs for the login")
	public void verifyLoginFunctionalityWithInvalidCred(String uname, String password)
			throws InterruptedException, IOException {
		SoftAssert soft45 = new SoftAssert();
	
		PaystubWebFormPage.Login();
		PaystubWebFormPage.enterEmailID(uname);
		PaystubWebFormPage.enterPassword(password);
		PaystubWebFormPage.pressloginButton();
		// Thread.sleep(3000l);
		soft45.assertEquals(PaystubWebFormPage.isUserLoggedIn(), false, "Login successfull with invalid cred.");
		if (PaystubWebFormPage.isUserLoggedIn()) {
			// PaystubWebFormPage.pressLogout();
			restartWebSession();
			
		} else if (!PaystubWebFormPage.isUserLoggedIn()) {
			PaystubWebFormPage.closeLoginWindow();
		}
		soft45.assertAll();
	}

	@DataProvider(name = "testLogindata")
	public Object[][] invalidlogindata() {
		Object[][] logindata = new Object[10][2];
		logindata[0][0] = "";
		logindata[0][1] = "";
		logindata[1][0] = "username2gmail.com";
		logindata[1][1] = "12345";
		logindata[2][0] = "username1@gmailcom";
		logindata[2][1] = "123";
		logindata[3][0] = "username1@@gmailcom";
		logindata[3][1] = "123";
		logindata[4][0] = "@test.com";
		logindata[4][1] = "1234";
		logindata[5][0] = "tester.marqueetest@gmail.com";
		logindata[5][1] = propConnection.getProperty("pass");
		logindata[6][0] = "test@com.";
		logindata[6][1] = "123";
		logindata[7][0] = propConnection.getProperty("username"); // valid Username with invalid password
		logindata[7][1] = "123";
		logindata[8][0] = "tes t@t.com";
		logindata[8][1] = "12345 6";
		logindata[9][0] = " ";
		logindata[9][1] = " ";
		return logindata;
	}

	String progressno;

	@Test(priority = 46, description = "46 Verify the template created retrives all the data saved when user is allready logged in.")
	public void verifyPaystubTemplateWithLogin() throws TimeoutException, InterruptedException, IOException {
		SoftAssert soft46 = new SoftAssert();
	
		PaystubWebFormPage.Login();
		PaystubWebFormPage.enterEmailID(propConnection.getProperty("username"));
		PaystubWebFormPage.enterEmailID(propConnection.getProperty("pass"));
		PaystubWebFormPage.pressloginButton();
		PaystubWebFormPage.enterEmployer_name(propConnection.getProperty("PaystubEmployerName"));
		PaystubWebFormPage.enterEmployerNumber(propConnection.getProperty("PaystubEmployerTelephoneNumber"));
		PaystubWebFormPage.enterEmployerAddress(propConnection.getProperty("PaystubEmployerStreetAddress1"));
		PaystubWebFormPage.enterEmployerAddress2(propConnection.getProperty("PaystubEmployerStreetAddress2"));
		PaystubWebFormPage.enterEmployerCity(propConnection.getProperty("PaystubCompanyCity"));
		PaystubWebFormPage.selectEmployerState(propConnection.getProperty("PaystubCompanyState"));
		PaystubWebFormPage.enterEmployerZipCode(propConnection.getProperty("PaystubCompanyZipCode"));
		// PaystubWebFormPage.enterEmployerLogoUpload();

		// Enter Employee details
		PaystubWebFormPage.enterEmployee_Name(propConnection.getProperty("PaystubEmployerName"));
		PaystubWebFormPage.enterEmployee_Social(propConnection.getProperty("PaystubEmployeeSocialNumber"));
		PaystubWebFormPage.enterEmployee_Id(propConnection.getProperty("PaystubEmployeeID"));
		PaystubWebFormPage.enterEmployee_Telephone_Number(propConnection.getProperty("PaystubEmployeeTelephoneNumber"));
		PaystubWebFormPage.enterEmployee_Address(propConnection.getProperty("PaystubEmployeeAddress1"));
		PaystubWebFormPage.enterEmployee_Address_2(propConnection.getProperty("PaystubEmployeeAddress2"));
		PaystubWebFormPage.enterEmployee_City(propConnection.getProperty("PaystubEmployeeCity"));
		PaystubWebFormPage.selectEmployee_State(propConnection.getProperty("PaystubEmployeeState"));
		PaystubWebFormPage.enterEmployee_Zip_Code(propConnection.getProperty("PaystubEmployeeZipCode"));
		PaystubWebFormPage.selectEmployee_Marital_Status(propConnection.getProperty("PaystubEmployeeMaritalStatus"));
		PaystubWebFormPage.selectExemptions(propConnection.getProperty("PaystubEmployeeExemptions"));
		PaystubWebFormPage.markIs_direct_deposit();
		PaystubWebFormPage.enterBank_Checking_Account(propConnection.getProperty("Bank_Checking_Account"));

		// PaystubWebFormPage.markIs_direct_deposit_no();
		PaystubWebFormPage.selectPaymentType("Salary");
		PaystubWebFormPage.select_how_often_you_paid("Bi-Weekly (ex: every other Wednesday)");
		PaystubWebFormPage.selectWere_you_hired_in_the_past_52_weeks("Yes");
		PaystubWebFormPage.How_many_pay_periods_have_you_worked("2");
		PaystubWebFormPage.select_NoOfPaystubsNeeded(2);
		// Enter earnings of first paystub

		PaystubWebFormPage.enterPay_period_start(1, "2022", "Feb", "15");
		PaystubWebFormPage.enterSalaryRate(1, "20000");
		PaystubWebFormPage.enterOverTimeRate(1, "12");
		PaystubWebFormPage.enterOverTimeHours(1, "8");
		PaystubWebFormPage.enterHolidayRate(1, "250");
		PaystubWebFormPage.enterHolidayHours(1, "24");
		PaystubWebFormPage.enterVacationRate(1, "600");
		PaystubWebFormPage.enterVacationHours(1, "24");
		PaystubWebFormPage.enterBonusRate(1, "15000");
		PaystubWebFormPage.enterBonusHours(1, "24");
		PaystubWebFormPage.enterFloatRate(1, "900.33");
		PaystubWebFormPage.enterFloatHours(1, "9");
		PaystubWebFormPage.enterTipsRate(1, "50");
		PaystubWebFormPage.pressAddEarnings();
		PaystubWebFormPage.entercustom_earning_Name(1, 1, "test name");
		PaystubWebFormPage.enterCustom_earningRate(1, 1, "12");
		PaystubWebFormPage.enterCustom_earningHours(1, 1, "24");
		// Enter Custom deductions
		PaystubWebFormPage.pressAddDeductions();
		PaystubWebFormPage.enterCustomDeductionName(1, 1, "Custom deduction");
		PaystubWebFormPage.enterCistomDeductions(1, "200.00");
		// Enter earnings of second paystub
		PaystubWebFormPage.enterOverTimeRate(2, "12");
		PaystubWebFormPage.enterOverTimeHours(2, "8");
		PaystubWebFormPage.enterHolidayRate(2, "250");
		PaystubWebFormPage.enterHolidayHours(2, "24");
		PaystubWebFormPage.enterVacationRate(2, "600");
		PaystubWebFormPage.enterVacationHours(2, "24");
		PaystubWebFormPage.enterBonusRate(2, "15000");
		PaystubWebFormPage.enterBonusHours(2, "24");
		PaystubWebFormPage.enterFloatRate(2, "900.33");
		PaystubWebFormPage.enterFloatHours(2, "9");
		PaystubWebFormPage.enterTipsRate(2, "50");
		PaystubWebFormPage.entercustom_earning_Name(2, 1, "test name");
		PaystubWebFormPage.enterCustom_earningRate(2, 1, "22");
		PaystubWebFormPage.enterCustom_earningHours(2, 1, "33");
		PaystubWebFormPage.pressAddDeductions();
		PaystubWebFormPage.enterCustomDeductionName(1, 2, "test deduction");
//		PaystubWebFormPage.enterCistomDeductions(1, "222.0");
//		PaystubWebFormPage.enterPay_period_start(3, "202sadfa2", "Feb32", "15sdsdfs");
		// Save the template
		// Create instance of the Screenshot interface

		PaystubWebFormPage.saveTemplate();
		browserdriver.navigate().refresh();
		PaystubWebFormPage.loadTemplate();
		progressno = PaystubWebFormPage.selectFirstprogress_number_option();
		System.out.println(progressno);
		PaystubWebFormPage.pressLoadTemplateButton();
		// js.executeScript("window.scrollBy(0, 100);");

		soft46.assertEquals(PaystubWebFormPage.getSelectedOption("auto_calc"), "On",
				"Auto calculator selected is not as per the template saved.");
		soft46.assertEquals(PaystubWebFormPage.getSelectedOption("employment_type"), "Employee",
				"Employeement Type selected is not as per the template saved.");
		soft46.assertEquals(PaystubWebFormPage.getSelectedOption("payment_type"), "Salary",
				"payment_type selected is not as per the template saved.");
		soft46.assertEquals(PaystubWebFormPage.getSelectedOption("payment_cycle"),
				"Bi-Weekly (ex: every other Wednesday)", "payment_cycle selected is not as per the template saved.");
		soft46.assertEquals(PaystubWebFormPage.getSelectedOption("hired_in"), "Yes",
				"'Were you hired in the past 52 weeks?' selected is not as per the template saved.");
		soft46.assertEquals(PaystubWebFormPage.getSelectedOption("paystub_need"), "2",
				"'Number of paystubs needed' selected is not as per the template saved.");
		soft46.assertEquals(PaystubWebFormPage.isHow_many_pay_periodsDisplayed(), true,
				"How many pay periods have you worked? is not displayed.");
		soft46.assertEquals(getTextValueOfWebElementID("employer_name"),
				propConnection.getProperty("PaystubEmployerName"),
				"Employer(Company) name is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("employer_number"), "1-234-567-8901",
				"employer_number is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("employer_address"),
				propConnection.getProperty("PaystubEmployerStreetAddress1"),
				"employer_address is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("employer_address_2"),
				propConnection.getProperty("PaystubEmployerStreetAddress2"),
				"employer_address2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("employer_city"),
				propConnection.getProperty("PaystubCompanyCity"), "employer_city is not as per the template saved.");
		soft46.assertEquals(PaystubWebFormPage.getSelectedOption("employer_state"),
				propConnection.getProperty("PaystubCompanyState"), "employer_state is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("employer_zip_code"),
				propConnection.getProperty("PaystubCompanyZipCode"),
				"employer_zip_code is not as per the template saved.");
		// Logo code is skiping for now.
		// Verifying employee details
		soft46.assertEquals(getTextValueOfWebElementID("employee_name"),
				propConnection.getProperty("PaystubEmployerName"), "employee_name is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("employee_social"), "XXX-XX-1234",
				"employee_social is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("employee_id"), propConnection.getProperty("PaystubEmployeeID"),
				"employee_id is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("employee_telephone_number"), "3-214-569-7871",
				"employee_telephone_number is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("employee_address"),
				propConnection.getProperty("PaystubEmployeeAddress1"),
				"employee_address1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("employee_address_2"),
				propConnection.getProperty("PaystubEmployeeAddress2"),
				"employee_address_2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("employee_city"),
				propConnection.getProperty("PaystubEmployeeCity"), "employee_city is not as per the template saved.");
		soft46.assertEquals(PaystubWebFormPage.getSelectedOption("employee_state"),
				propConnection.getProperty("PaystubEmployeeState"), "employee_state is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("employee_zip_code"),
				propConnection.getProperty("PaystubEmployeeZipCode"),
				"employee_zip_code is not as per the template saved.");
		soft46.assertEquals(PaystubWebFormPage.getSelectedOption("employee_marital_status"),
				propConnection.getProperty("PaystubEmployeeMaritalStatus"),
				"employee_marital_status is not as per the template saved.");
		soft46.assertEquals(PaystubWebFormPage.getSelectedOption("exemptions"),
				propConnection.getProperty("PaystubEmployeeExemptions"),
				"exemptions is not as per the template saved.");
		soft46.assertEquals(PaystubWebFormPage.markIs_direct_deposit(), true,
				"exemptions is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("bank_checking_account"),
				propConnection.getProperty("Bank_Checking_Account"),
				"bank_checking_account is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("pay_period_start", 1), "02/15/2022",
				"pay_period_start is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("pay_period_end", 1), "02/28/2022",
				"pay_period_end is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("pay_date", 1), "02/28/2022",
				"pay_date is not as per the template saved.");

		soft46.assertEquals(getTextValueOfWebElementID("rate1", 1), "20,000.00",
				"Salary rate in paystub1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("rate2", 1), "12.00",
				"Overtime rate in paystub1 is   not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("rate3", 1), "250.00",
				"Holiday rate in paystub1 is   not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("rate4", 1), "600.00",
				"Vacation rate in paystub1 is   not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("rate5", 1), "15,000.00",
				"Bonus rate in paystub1 is   not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("rate6", 1), "900.33",
				"Float rate in paystub1 is   not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("rate7", 1), "50.00",
				"Tips rate in paystub1 is   not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("custome_earnings_rate_1", 1), "22.00",
				"test name is not as per the template saved.");

		soft46.assertEquals(getTextValueOfWebElementID("hours1", 1), "0.00",
				"Salary hours in paystub1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("hours2", 1), "8.00",
				"Overtime hours in paystub1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("hours3", 1), "24.00",
				"Holiday hours in paystub1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("hours4", 1), "24.00",
				"Vacation hours in paystub1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("hours5", 1), "24.00",
				"Bonus hours in paystub1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("hours6", 1), "9.00",
				"Float hours in paystub1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("tips_total", 1), "0.00",
				"Tips hours in paystub1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("custome_earnings_hours_1", 1), "24.00",
				"test name is not as per the template saved.");

		soft46.assertEquals(getTextValueOfWebElementID("total1", 1), "769.23",
				"Salary total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("total2", 1), "96.00",
				"Overtime total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("total3", 1), "6,000.00",
				"Holiday total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("total4", 1), "14,400.00",
				"Vacation total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("total5", 1), "360,000.00",
				"Bonus total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("total6", 1), "8,102.97",
				"Float total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("total7", 1), "50.00",
				"Tips total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("custome_earnings_total_1", 1), "528.00",
				"test name is not as per the template saved.");

		soft46.assertEquals(getTextValueOfWebElementID("ytd1", 1), "1,538.46",
				"Salary ytd total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("ytd2", 1), "192.00",
				"Overtime YTD total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("ytd3", 1), "12,000.00",
				"Holiday ytd total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("ytd4", 1), "28,800.00",
				"Vacation ytd total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("ytd5", 1), "720,000.00",
				"Bonus ytd total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("ytd6", 1), "16,205.94",
				"Float ytd total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("ytd7", 1), "100.00",
				"Tips ytd total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("custome_earnings_ytd1", 1), "1,254.00",
				"test name in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("tcurrent", 1), "389,946.20",
				"Gross Pay total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("tytd", 1), "780,090.40",
				"Gross Pay YTD total in paystub 1 is not as per the template saved.");

		soft46.assertEquals(getTextValueOfWebElementID("fica_medicare_total", 1), "9,094.50",
				"FICA - Medicare total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("fica_social_security_total", 1), "0.00",
				"FICA - Social Security total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("federal_tax_total", 1), "141,278.90",
				"Federal Tax total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("state_tax_total", 1), "40,579.12",
				"State Tax total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("sdi_total", 1), "0.00",
				"SDI total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("sui_total", 1), "0.00",
				"SUI total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("wc_total", 1), "0.00",
				"WC total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("fli_total", 1), "0.00",
				"FLI total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("wf_total", 1), "0.00",
				"Workforce Development total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("custome_deduction_total_1", 1), "200.00",
				"Custom deduction total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("custome_deduction_total_2", 1), "0.00",
				"Test deduction total in paystub 1 is not as per the template saved.");

		soft46.assertEquals(getTextValueOfWebElementID("fica_medicare_ytd_total", 1), "9,094.50",
				"FICA - Medicare ytd total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("fica_social_security_ytd_total", 1), "9,114.00",
				"FICA - Social Security ytd total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("federal_tax_ytd_total", 1), "282,631.06",
				"Federal Tax ytd total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("state_tax_ytd_total", 1), "81,179.53",
				"State Tax ytd total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("sdi_ytd_total", 1), "157.45",
				"SDI ytd total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("sui_ytd_total", 1), "128.14",
				"SUI ytd total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("wc_ytd_total", 1), "0.00",
				"WC ytd total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("fli_ytd_total", 1), "98.80",
				"FLI ytd total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("wf_ytd_total", 1), "14.24",
				"Workforce Development ytd total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("custome_deduction_ytd_total1", 1), "400.00",
				"Custom deduction ytd total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("custome_deduction_ytd_total2", 1), "0.00",
				"Test deduction ytd total in paystub 1 is not as per the template saved.");

		soft46.assertEquals(getTextValueOfWebElementID("deductions", 1), "191,152.52",
				"deductions total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("ytd_deductions", 1), "382,817.72",
				"ytd_deductions total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("net_pay", 1), "198,793.68",
				"net_pay total in paystub 1 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("ytd_net_pay", 1), "397,272.68",
				"net_pay ytd total in paystub 1 is not as per the template saved.");

		// paystub 2
		soft46.assertEquals(getTextValueOfWebElementID("pay_period_start", 2), "02/01/2022",
				"pay_period_start in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("pay_period_end", 2), "02/14/2022",
				"pay_period_end paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("pay_date", 2), "02/14/2022",
				"pay_date paystub 2 is not as per the template saved.");

		soft46.assertEquals(getTextValueOfWebElementID("rate1", 2), "20,000.00",
				"Salary rate in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("rate2", 2), "12.00",
				"Overtime rate in paystub 2 is   not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("rate3", 2), "250.00",
				"Holiday rate in paystub 2 is   not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("rate4", 2), "600.00",
				"Vacation rate in paystub 2 is   not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("rate5", 2), "15,000.00",
				"Bonus rate in paystub 2 is   not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("rate6", 2), "900.33",
				"Float rate in paystub 2 is   not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("rate7", 2), "50.00",
				"Tips rate in paystub 2 is   not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("custome_earnings_rate_1", 2), "22.00",
				"test name rate in paystub 2 is not as per the template saved.");

		soft46.assertEquals(getTextValueOfWebElementID("hours1", 2), "0.00",
				"Salary hours in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("hours2", 2), "8.00",
				"Overtime hours in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("hours3", 2), "24.00",
				"Holiday hours in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("hours4", 2), "24.00",
				"Vacation hours in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("hours5", 2), "24.00",
				"Bonus hours in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("hours6", 2), "9.00",
				"Float hours in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("tips_total", 2), "0.00",
				"Tips hours in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("custome_earnings_hours_1", 2), "24.00",
				"test name hours in paystub 2 is not as per the template saved.");

		soft46.assertEquals(getTextValueOfWebElementID("total1", 2), "769.23",
				"Salary total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("total2", 2), "96.00",
				"Overtime total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("total3", 2), "6,000.00",
				"Holiday total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("total4", 2), "14,400.00",
				"Vacation total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("total5", 2), "360,000.00",
				"Bonus total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("total6", 2), "8,102.97",
				"Float total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("total7", 2), "50.00",
				"Tips total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("custome_earnings_total_1", 2), "528.00",
				"test name total in paystub 2 is not as per the template saved.");

		soft46.assertEquals(getTextValueOfWebElementID("ytd1", 2), "769.23",
				"Salary ytd total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("ytd2", 2), "96.00",
				"Overtime YTD total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("ytd3", 2), "6,000.00",
				"Holiday ytd total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("ytd4", 2), "14,400.00",
				"Vacation ytd total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("ytd5", 2), "360,000.00",
				"Bonus ytd total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("ytd6", 2), "8,102.97",
				"Float ytd total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("ytd7", 2), "50.00",
				"Tips ytd total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("custome_earnings_ytd1", 2), "528.00",
				"test name ytd total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("tcurrent", 2), "389,946.20",
				"Gross Pay total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("tytd", 2), "389,946.20",
				"Gross Pay YTD total in paystub 2 is not as per the template saved.");

		soft46.assertEquals(getTextValueOfWebElementID("fica_medicare_total", 2), "9,094.50",
				"FICA - Medicare total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("fica_social_security_total", 2), "9,114.00",
				"FICA - Social Security total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("federal_tax_total", 2), "141,278.90",
				"Federal Tax total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("state_tax_total", 2), "40,579.12",
				"State Tax total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("sdi_total", 2), "157.45",
				"SDI total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("sui_total", 2), "128.14",
				"SUI total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("wc_total", 2), "0.00",
				"WC total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("fli_total", 2), "98.80",
				"FLI total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("wf_total", 2), "14.24",
				"Workforce Development total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("custome_deduction_total_1", 2), "200.00",
				"Custom deduction total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("custome_deduction_total_2", 2), "0.00",
				"Test deduction total in paystub 2 is not as per the template saved.");

		soft46.assertEquals(getTextValueOfWebElementID("fica_medicare_ytd_total", 2), "9,094.50",
				"FICA - Medicare ytd total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("fica_social_security_ytd_total", 2), "9,114.00",
				"FICA - Social Security ytd total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("federal_tax_ytd_total", 2), "141,278.90",
				"Federal Tax ytd total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("state_tax_ytd_total", 2), "40,579.12",
				"State Tax ytd total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("sdi_ytd_total", 2), "157.45",
				"SDI ytd total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("sui_ytd_total", 2), "128.14",
				"SUI ytd total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("wc_ytd_total", 2), "0.00",
				"WC ytd total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("fli_ytd_total", 2), "98.80",
				"FLI ytd total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("wf_ytd_total", 2), "14.24",
				"Workforce Development ytd total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("custome_deduction_ytd_total1", 2), "200.00",
				"Custom deduction ytd total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("custome_deduction_ytd_total2", 2), "0.00",
				"Test deduction ytd total in paystub 2 is not as per the template saved.");

		soft46.assertEquals(getTextValueOfWebElementID("deductions", 2), "200,665.15",
				"deductions total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("ytd_deductions", 2), "200,665.15",
				"ytd_deductions total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("net_pay", 2), "189,281.05",
				"net_pay total in paystub 2 is not as per the template saved.");
		soft46.assertEquals(getTextValueOfWebElementID("ytd_net_pay", 2), "189,281.05",
				"net_pay ytd total in paystub 2 is not as per the template saved.");

		soft46.assertAll();
	}

	@Test(dependsOnMethods = "verifyPaystubTemplateWithLogin", description = "47 Verify data of the saved template when logged out")
	public void verifyDataOfTemplateAfterLogout() throws InterruptedException {
		SoftAssert savedDataAfterLoggedOut = new SoftAssert();
		PaystubWebFormPage.Logout();
		PaystubWebFormPage.loadTemplate();
		PaystubWebFormPage.enterProgressNumber(progressno);
		PaystubWebFormPage.pressLoadTemplateButton_without_login();
		System.out.println("After loging out and loading the same template: \n\n");

		// js.executeScript("window.scrollBy(0, 100);");

		savedDataAfterLoggedOut.assertEquals(PaystubWebFormPage.getSelectedOption("auto_calc"), "On",
				"Auto calculator selected is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(PaystubWebFormPage.getSelectedOption("employment_type"), "Employee",
				"Employeement Type selected is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(PaystubWebFormPage.getSelectedOption("payment_type"), "Salary",
				"payment_type selected is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(PaystubWebFormPage.getSelectedOption("payment_cycle"),
				"Bi-Weekly (ex: every other Wednesday)", "payment_cycle selected is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(PaystubWebFormPage.getSelectedOption("hired_in"), "Yes",
				"'Were you hired in the past 52 weeks?' selected is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(PaystubWebFormPage.getSelectedOption("paystub_need"), "2",
				"'Number of paystubs needed' selected is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(PaystubWebFormPage.isHow_many_pay_periodsDisplayed(), true,
				"How many pay periods have you worked? is not displayed.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("employer_name"),
				propConnection.getProperty("PaystubEmployerName"),
				"Employer(Company) name is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("employer_number"), "1-234-567-8901",
				"employer_number is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("employer_address"),
				propConnection.getProperty("PaystubEmployerStreetAddress1"),
				"employer_address is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("employer_address_2"),
				propConnection.getProperty("PaystubEmployerStreetAddress2"),
				"employer_address2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("employer_city"),
				propConnection.getProperty("PaystubCompanyCity"), "employer_city is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(PaystubWebFormPage.getSelectedOption("employer_state"),
				propConnection.getProperty("PaystubCompanyState"), "employer_state is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("employer_zip_code"),
				propConnection.getProperty("PaystubCompanyZipCode"),
				"employer_zip_code is not as per the template saved.");
		// Logo code is skiping for now.
		// Verifying employee details
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("employee_name"),
				propConnection.getProperty("PaystubEmployerName"), "employee_name is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("employee_social"), "XXX-XX-1234",
				"employee_social is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("employee_id"),
				propConnection.getProperty("PaystubEmployeeID"), "employee_id is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("employee_telephone_number"), "3-214-569-7871",
				"employee_telephone_number is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("employee_address"),
				propConnection.getProperty("PaystubEmployeeAddress1"),
				"employee_address1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("employee_address_2"),
				propConnection.getProperty("PaystubEmployeeAddress2"),
				"employee_address_2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("employee_city"),
				propConnection.getProperty("PaystubEmployeeCity"), "employee_city is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(PaystubWebFormPage.getSelectedOption("employee_state"),
				propConnection.getProperty("PaystubEmployeeState"), "employee_state is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("employee_zip_code"),
				propConnection.getProperty("PaystubEmployeeZipCode"),
				"employee_zip_code is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(PaystubWebFormPage.getSelectedOption("employee_marital_status"),
				propConnection.getProperty("PaystubEmployeeMaritalStatus"),
				"employee_marital_status is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(PaystubWebFormPage.getSelectedOption("exemptions"),
				propConnection.getProperty("PaystubEmployeeExemptions"),
				"exemptions is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(PaystubWebFormPage.markIs_direct_deposit(), true,
				"exemptions is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("bank_checking_account"),
				propConnection.getProperty("Bank_Checking_Account"),
				"bank_checking_account is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("pay_period_start", 1), "02/15/2022",
				"pay_period_start is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("pay_period_end", 1), "02/28/2022",
				"pay_period_end is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("pay_date", 1), "02/28/2022",
				"pay_date is not as per the template saved.");

		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("rate1", 1), "20,000.00",
				"Salary rate in paystub1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("rate2", 1), "12.00",
				"Overtime rate in paystub1 is   not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("rate3", 1), "250.00",
				"Holiday rate in paystub1 is   not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("rate4", 1), "600.00",
				"Vacation rate in paystub1 is   not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("rate5", 1), "15,000.00",
				"Bonus rate in paystub1 is   not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("rate6", 1), "900.33",
				"Float rate in paystub1 is   not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("rate7", 1), "50.00",
				"Tips rate in paystub1 is   not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("custome_earnings_rate_1", 1), "22.00",
				"test name is not as per the template saved.");

		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("hours1", 1), "0.00",
				"Salary hours in paystub1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("hours2", 1), "8.00",
				"Overtime hours in paystub1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("hours3", 1), "24.00",
				"Holiday hours in paystub1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("hours4", 1), "24.00",
				"Vacation hours in paystub1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("hours5", 1), "24.00",
				"Bonus hours in paystub1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("hours6", 1), "9.00",
				"Float hours in paystub1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("tips_total", 1), "0.00",
				"Tips hours in paystub1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("custome_earnings_hours_1", 1), "24.00",
				"test name is not as per the template saved.");

		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("total1", 1), "769.23",
				"Salary total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("total2", 1), "96.00",
				"Overtime total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("total3", 1), "6,000.00",
				"Holiday total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("total4", 1), "14,400.00",
				"Vacation total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("total5", 1), "360,000.00",
				"Bonus total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("total6", 1), "8,102.97",
				"Float total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("total7", 1), "50.00",
				"Tips total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("custome_earnings_total_1", 1), "528.00",
				"test name is not as per the template saved.");

		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("ytd1", 1), "1,538.46",
				"Salary ytd total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("ytd2", 1), "192.00",
				"Overtime YTD total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("ytd3", 1), "12,000.00",
				"Holiday ytd total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("ytd4", 1), "28,800.00",
				"Vacation ytd total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("ytd5", 1), "720,000.00",
				"Bonus ytd total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("ytd6", 1), "16,205.94",
				"Float ytd total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("ytd7", 1), "100.00",
				"Tips ytd total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("custome_earnings_ytd1", 1), "1,254.00",
				"test name in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("tcurrent", 1), "389,946.20",
				"Gross Pay total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("tytd", 1), "780,090.40",
				"Gross Pay YTD total in paystub 1 is not as per the template saved.");

		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("fica_medicare_total", 1), "9,094.50",
				"FICA - Medicare total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("fica_social_security_total", 1), "0.00",
				"FICA - Social Security total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("federal_tax_total", 1), "141,278.90",
				"Federal Tax total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("state_tax_total", 1), "40,579.12",
				"State Tax total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("sdi_total", 1), "0.00",
				"SDI total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("sui_total", 1), "0.00",
				"SUI total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("wc_total", 1), "0.00",
				"WC total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("fli_total", 1), "0.00",
				"FLI total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("wf_total", 1), "0.00",
				"Workforce Development total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("custome_deduction_total_1", 1), "200.00",
				"Custom deduction total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("custome_deduction_total_2", 1), "0.00",
				"Test deduction total in paystub 1 is not as per the template saved.");

		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("fica_medicare_ytd_total", 1), "9,094.50",
				"FICA - Medicare ytd total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("fica_social_security_ytd_total", 1),
				"9,114.00", "FICA - Social Security ytd total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("federal_tax_ytd_total", 1), "282,631.06",
				"Federal Tax ytd total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("state_tax_ytd_total", 1), "81,179.53",
				"State Tax ytd total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("sdi_ytd_total", 1), "157.45",
				"SDI ytd total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("sui_ytd_total", 1), "128.14",
				"SUI ytd total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("wc_ytd_total", 1), "0.00",
				"WC ytd total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("fli_ytd_total", 1), "98.80",
				"FLI ytd total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("wf_ytd_total", 1), "14.24",
				"Workforce Development ytd total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("custome_deduction_ytd_total1", 1), "400.00",
				"Custom deduction ytd total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("custome_deduction_ytd_total2", 1), "0.00",
				"Test deduction ytd total in paystub 1 is not as per the template saved.");

		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("deductions", 1), "191,152.52",
				"deductions total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("ytd_deductions", 1), "382,817.72",
				"ytd_deductions total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("net_pay", 1), "198,793.68",
				"net_pay total in paystub 1 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("ytd_net_pay", 1), "397,272.68",
				"net_pay ytd total in paystub 1 is not as per the template saved.");

		// paystub 2
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("pay_period_start", 2), "02/01/2022",
				"pay_period_start in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("pay_period_end", 2), "02/14/2022",
				"pay_period_end paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("pay_date", 2), "02/14/2022",
				"pay_date paystub 2 is not as per the template saved.");

		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("rate1", 2), "20,000.00",
				"Salary rate in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("rate2", 2), "12.00",
				"Overtime rate in paystub 2 is   not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("rate3", 2), "250.00",
				"Holiday rate in paystub 2 is   not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("rate4", 2), "600.00",
				"Vacation rate in paystub 2 is   not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("rate5", 2), "15,000.00",
				"Bonus rate in paystub 2 is   not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("rate6", 2), "900.33",
				"Float rate in paystub 2 is   not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("rate7", 2), "50.00",
				"Tips rate in paystub 2 is   not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("custome_earnings_rate_1", 2), "22.00",
				"test name rate in paystub 2 is not as per the template saved.");

		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("hours1", 2), "0.00",
				"Salary hours in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("hours2", 2), "8.00",
				"Overtime hours in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("hours3", 2), "24.00",
				"Holiday hours in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("hours4", 2), "24.00",
				"Vacation hours in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("hours5", 2), "24.00",
				"Bonus hours in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("hours6", 2), "9.00",
				"Float hours in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("tips_total", 2), "0.00",
				"Tips hours in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("custome_earnings_hours_1", 2), "24.00",
				"test name hours in paystub 2 is not as per the template saved.");

		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("total1", 2), "769.23",
				"Salary total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("total2", 2), "96.00",
				"Overtime total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("total3", 2), "6,000.00",
				"Holiday total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("total4", 2), "14,400.00",
				"Vacation total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("total5", 2), "360,000.00",
				"Bonus total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("total6", 2), "8,102.97",
				"Float total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("total7", 2), "50.00",
				"Tips total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("custome_earnings_total_1", 2), "528.00",
				"test name total in paystub 2 is not as per the template saved.");

		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("ytd1", 2), "769.23",
				"Salary ytd total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("ytd2", 2), "96.00",
				"Overtime YTD total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("ytd3", 2), "6,000.00",
				"Holiday ytd total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("ytd4", 2), "14,400.00",
				"Vacation ytd total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("ytd5", 2), "360,000.00",
				"Bonus ytd total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("ytd6", 2), "8,102.97",
				"Float ytd total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("ytd7", 2), "50.00",
				"Tips ytd total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("custome_earnings_ytd1", 2), "528.00",
				"test name ytd total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("tcurrent", 2), "389,946.20",
				"Gross Pay total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("tytd", 2), "389,946.20",
				"Gross Pay YTD total in paystub 2 is not as per the template saved.");

		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("fica_medicare_total", 2), "9,094.50",
				"FICA - Medicare total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("fica_social_security_total", 2), "9,114.00",
				"FICA - Social Security total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("federal_tax_total", 2), "141,278.90",
				"Federal Tax total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("state_tax_total", 2), "40,579.12",
				"State Tax total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("sdi_total", 2), "157.45",
				"SDI total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("sui_total", 2), "128.14",
				"SUI total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("wc_total", 2), "0.00",
				"WC total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("fli_total", 2), "98.80",
				"FLI total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("wf_total", 2), "14.24",
				"Workforce Development total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("custome_deduction_total_1", 2), "200.00",
				"Custom deduction total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("custome_deduction_total_2", 2), "0.00",
				"Test deduction total in paystub 2 is not as per the template saved.");

		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("fica_medicare_ytd_total", 2), "9,094.50",
				"FICA - Medicare ytd total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("fica_social_security_ytd_total", 2),
				"9,114.00", "FICA - Social Security ytd total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("federal_tax_ytd_total", 2), "141,278.90",
				"Federal Tax ytd total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("state_tax_ytd_total", 2), "40,579.12",
				"State Tax ytd total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("sdi_ytd_total", 2), "157.45",
				"SDI ytd total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("sui_ytd_total", 2), "128.14",
				"SUI ytd total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("wc_ytd_total", 2), "0.00",
				"WC ytd total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("fli_ytd_total", 2), "98.80",
				"FLI ytd total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("wf_ytd_total", 2), "14.24",
				"Workforce Development ytd total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("custome_deduction_ytd_total1", 2), "200.00",
				"Custom deduction ytd total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("custome_deduction_ytd_total2", 2), "0.00",
				"Test deduction ytd total in paystub 2 is not as per the template saved.");

		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("deductions", 2), "200,665.15",
				"deductions total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("ytd_deductions", 2), "200,665.15",
				"ytd_deductions total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("net_pay", 2), "189,281.05",
				"net_pay total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertEquals(getTextValueOfWebElementID("ytd_net_pay", 2), "189,281.05",
				"net_pay ytd total in paystub 2 is not as per the template saved.");
		savedDataAfterLoggedOut.assertAll();
	}

	@Test(priority = 48, description = "48 Verify the saved template data from acceccing the gmail link")
	public void verifyGmail() throws UnirestException, IOException, GeneralSecurityException, InterruptedException {
		// locate the email field
		// Gmail = new GMail(browserdriver);
		PaystubWebFormPage.enterEmployer_name(propConnection.getProperty("PaystubEmployerName"));
		PaystubWebFormPage.enterEmployerNumber(propConnection.getProperty("PaystubEmployerTelephoneNumber"));
		PaystubWebFormPage.enterEmployerAddress(propConnection.getProperty("PaystubEmployerStreetAddress1"));
		PaystubWebFormPage.enterEmployerAddress2(propConnection.getProperty("PaystubEmployerStreetAddress2"));
		PaystubWebFormPage.enterEmployerCity(propConnection.getProperty("PaystubCompanyCity"));
		PaystubWebFormPage.selectEmployerState(propConnection.getProperty("PaystubCompanyState"));
		PaystubWebFormPage.enterEmployerZipCode(propConnection.getProperty("PaystubCompanyZipCode"));
		// PaystubWebFormPage.enterEmployerLogoUpload();

		// Enter Employee details
		PaystubWebFormPage.enterEmployee_Name(propConnection.getProperty("PaystubEmployerName"));
		PaystubWebFormPage.enterEmployee_Social(propConnection.getProperty("PaystubEmployeeSocialNumber"));
		PaystubWebFormPage.enterEmployee_Id(propConnection.getProperty("PaystubEmployeeID"));
		PaystubWebFormPage.enterEmployee_Telephone_Number(propConnection.getProperty("PaystubEmployeeTelephoneNumber"));
		PaystubWebFormPage.enterEmployee_Address(propConnection.getProperty("PaystubEmployeeAddress1"));
		PaystubWebFormPage.enterEmployee_Address_2(propConnection.getProperty("PaystubEmployeeAddress2"));
		PaystubWebFormPage.enterEmployee_City(propConnection.getProperty("PaystubEmployeeCity"));
		PaystubWebFormPage.selectEmployee_State(propConnection.getProperty("PaystubEmployeeState"));
		PaystubWebFormPage.enterEmployee_Zip_Code(propConnection.getProperty("PaystubEmployeeZipCode"));
		PaystubWebFormPage.selectEmployee_Marital_Status(propConnection.getProperty("PaystubEmployeeMaritalStatus"));
		PaystubWebFormPage.selectExemptions(propConnection.getProperty("PaystubEmployeeExemptions"));
		PaystubWebFormPage.markIs_direct_deposit();
		PaystubWebFormPage.enterBank_Checking_Account(propConnection.getProperty("Bank_Checking_Account"));

		// PaystubWebFormPage.markIs_direct_deposit_no();
		PaystubWebFormPage.selectPaymentType("Salary");
		PaystubWebFormPage.select_how_often_you_paid("Bi-Weekly (ex: every other Wednesday)");
		PaystubWebFormPage.selectWere_you_hired_in_the_past_52_weeks("Yes");
		PaystubWebFormPage.How_many_pay_periods_have_you_worked("2");
		PaystubWebFormPage.select_NoOfPaystubsNeeded(2);
		// Enter earnings of first paystub

		PaystubWebFormPage.enterPay_period_start(1, "2022", "Feb", "15");
		PaystubWebFormPage.enterSalaryRate(1, "20000");
		PaystubWebFormPage.enterOverTimeRate(1, "12");
		PaystubWebFormPage.enterOverTimeHours(1, "8");
		PaystubWebFormPage.enterHolidayRate(1, "250");
		PaystubWebFormPage.enterHolidayHours(1, "24");
		PaystubWebFormPage.enterVacationRate(1, "600");
		PaystubWebFormPage.enterVacationHours(1, "24");
		PaystubWebFormPage.enterBonusRate(1, "15000");
		PaystubWebFormPage.enterBonusHours(1, "24");
		PaystubWebFormPage.enterFloatRate(1, "900.33");
		PaystubWebFormPage.enterFloatHours(1, "9");
		PaystubWebFormPage.enterTipsRate(1, "50");
		PaystubWebFormPage.pressAddEarnings();
		PaystubWebFormPage.entercustom_earning_Name(1, 1, "test name");
		PaystubWebFormPage.enterCustom_earningRate(1, 1, "12");
		PaystubWebFormPage.enterCustom_earningHours(1, 1, "24");
		// Enter Custom deductions
		PaystubWebFormPage.pressAddDeductions();
		PaystubWebFormPage.enterCustomDeductionName(1, 1, "Custom deduction");
		PaystubWebFormPage.enterCistomDeductions(1, "200.00");
		// Enter earnings of second paystub
		PaystubWebFormPage.enterOverTimeRate(2, "12");
		PaystubWebFormPage.enterOverTimeHours(2, "8");
		PaystubWebFormPage.enterHolidayRate(2, "250");
		PaystubWebFormPage.enterHolidayHours(2, "24");
		PaystubWebFormPage.enterVacationRate(2, "600");
		PaystubWebFormPage.enterVacationHours(2, "24");
		PaystubWebFormPage.enterBonusRate(2, "15000");
		PaystubWebFormPage.enterBonusHours(2, "24");
		PaystubWebFormPage.enterFloatRate(2, "900.33");
		PaystubWebFormPage.enterFloatHours(2, "9");
		PaystubWebFormPage.enterTipsRate(2, "50");
		PaystubWebFormPage.entercustom_earning_Name(2, 1, "test name");
		PaystubWebFormPage.enterCustom_earningRate(2, 1, "22");
		PaystubWebFormPage.enterCustom_earningHours(2, 1, "33");
		PaystubWebFormPage.pressAddDeductions();
		PaystubWebFormPage.enterCustomDeductionName(1, 2, "test deduction");
//		PaystubWebFormPage.enterCistomDeductions(1, "222.0");
//		PaystubWebFormPage.enterPay_period_start(3, "202sadfa2", "Feb32", "15sdsdfs");
		// Save the template
		// Create instance of the Screenshot interface
		Gmail = new GMail(browserdriver);
		PaystubWebFormPage.saveTemplate();
		PaystubWebFormPage.pressSAVE_WITHOUT_LOGIN();
		PaystubWebFormPage.enterguest_email(propConnection.getProperty("username"));
		PaystubWebFormPage.pressSave_darft_without_login();
		// browserdriver.navigate().refresh();

		String TemplateMail[] = Gmail.getMailData("HERE'S YOUR DATA DARFT TEMPLATE!");
//		String OrderMail[] = Gmail.getMailData("HERE'S YOUR BILL-GENERATE ORDER! THANK YOU!");
//		String ResetPasswordMail[] = Gmail.getMailData("PASSOWRD RESET COFIRMATION CODE.");

		System.out.println("Subject: " + TemplateMail[0]);
		System.out.println("Message: " + TemplateMail[1]);
		System.out.println("Time: " + TemplateMail[4]);
//		System.out.println("\nSubject: " + data2[0]);
//		System.out.println("Message: " + data2[1]);
//		System.out.println("Time: " + data2[4]);
//		System.out.println("\nSubject: " + PasswordMail[0]);
//		System.out.println("Message: " + PasswordMail[1]);
//		System.out.println("Time: " + PasswordMail[4]);
		String MailLink = TemplateMail[1].split("Use ")[1].split(" to")[0];
		System.out.println(MailLink);
		browserdriver.get(MailLink);
		SoftAssert soft47 = new SoftAssert();
		soft47.assertEquals(PaystubWebFormPage.getSelectedOption("auto_calc"), "On",
				"Auto calculator selected is not as per the template saved.");
		soft47.assertEquals(PaystubWebFormPage.getSelectedOption("employment_type"), "Employee",
				"Employeement Type selected is not as per the template saved.");
		soft47.assertEquals(PaystubWebFormPage.getSelectedOption("payment_type"), "Salary",
				"payment_type selected is not as per the template saved.");
		soft47.assertEquals(PaystubWebFormPage.getSelectedOption("payment_cycle"),
				"Bi-Weekly (ex: every other Wednesday)", "payment_cycle selected is not as per the template saved.");
		soft47.assertEquals(PaystubWebFormPage.getSelectedOption("hired_in"), "Yes",
				"'Were you hired in the past 52 weeks?' selected is not as per the template saved.");
		soft47.assertEquals(PaystubWebFormPage.getSelectedOption("paystub_need"), "2",
				"'Number of paystubs needed' selected is not as per the template saved.");
		soft47.assertEquals(PaystubWebFormPage.isHow_many_pay_periodsDisplayed(), true,
				"How many pay periods have you worked? is not displayed.");
		soft47.assertEquals(getTextValueOfWebElementID("employer_name"),
				propConnection.getProperty("PaystubEmployerName"),
				"Employer(Company) name is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("employer_number"), "1-234-567-8901",
				"employer_number is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("employer_address"),
				propConnection.getProperty("PaystubEmployerStreetAddress1"),
				"employer_address is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("employer_address_2"),
				propConnection.getProperty("PaystubEmployerStreetAddress2"),
				"employer_address2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("employer_city"),
				propConnection.getProperty("PaystubCompanyCity"), "employer_city is not as per the template saved.");
		soft47.assertEquals(PaystubWebFormPage.getSelectedOption("employer_state"),
				propConnection.getProperty("PaystubCompanyState"), "employer_state is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("employer_zip_code"),
				propConnection.getProperty("PaystubCompanyZipCode"),
				"employer_zip_code is not as per the template saved.");
		// Logo code is skiping for now.
		// Verifying employee details
		soft47.assertEquals(getTextValueOfWebElementID("employee_name"),
				propConnection.getProperty("PaystubEmployerName"), "employee_name is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("employee_social"), "XXX-XX-1234",
				"employee_social is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("employee_id"), propConnection.getProperty("PaystubEmployeeID"),
				"employee_id is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("employee_telephone_number"), "3-214-569-7871",
				"employee_telephone_number is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("employee_address"),
				propConnection.getProperty("PaystubEmployeeAddress1"),
				"employee_address1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("employee_address_2"),
				propConnection.getProperty("PaystubEmployeeAddress2"),
				"employee_address_2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("employee_city"),
				propConnection.getProperty("PaystubEmployeeCity"), "employee_city is not as per the template saved.");
		soft47.assertEquals(PaystubWebFormPage.getSelectedOption("employee_state"),
				propConnection.getProperty("PaystubEmployeeState"), "employee_state is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("employee_zip_code"),
				propConnection.getProperty("PaystubEmployeeZipCode"),
				"employee_zip_code is not as per the template saved.");
		soft47.assertEquals(PaystubWebFormPage.getSelectedOption("employee_marital_status"),
				propConnection.getProperty("PaystubEmployeeMaritalStatus"),
				"employee_marital_status is not as per the template saved.");
		soft47.assertEquals(PaystubWebFormPage.getSelectedOption("exemptions"),
				propConnection.getProperty("PaystubEmployeeExemptions"),
				"exemptions is not as per the template saved.");
		soft47.assertEquals(PaystubWebFormPage.markIs_direct_deposit(), true,
				"exemptions is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("bank_checking_account"),
				propConnection.getProperty("Bank_Checking_Account"),
				"bank_checking_account is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("pay_period_start", 1), "02/15/2022",
				"pay_period_start is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("pay_period_end", 1), "02/28/2022",
				"pay_period_end is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("pay_date", 1), "02/28/2022",
				"pay_date is not as per the template saved.");

		soft47.assertEquals(getTextValueOfWebElementID("rate1", 1), "20,000.00",
				"Salary rate in paystub1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("rate2", 1), "12.00",
				"Overtime rate in paystub1 is   not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("rate3", 1), "250.00",
				"Holiday rate in paystub1 is   not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("rate4", 1), "600.00",
				"Vacation rate in paystub1 is   not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("rate5", 1), "15,000.00",
				"Bonus rate in paystub1 is   not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("rate6", 1), "900.33",
				"Float rate in paystub1 is   not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("rate7", 1), "50.00",
				"Tips rate in paystub1 is   not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("custome_earnings_rate_1", 1), "22.00",
				"test name is not as per the template saved.");

		soft47.assertEquals(getTextValueOfWebElementID("hours1", 1), "0.00",
				"Salary hours in paystub1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("hours2", 1), "8.00",
				"Overtime hours in paystub1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("hours3", 1), "24.00",
				"Holiday hours in paystub1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("hours4", 1), "24.00",
				"Vacation hours in paystub1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("hours5", 1), "24.00",
				"Bonus hours in paystub1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("hours6", 1), "9.00",
				"Float hours in paystub1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("tips_total", 1), "0.00",
				"Tips hours in paystub1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("custome_earnings_hours_1", 1), "24.00",
				"test name is not as per the template saved.");

		soft47.assertEquals(getTextValueOfWebElementID("total1", 1), "769.23",
				"Salary total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("total2", 1), "96.00",
				"Overtime total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("total3", 1), "6,000.00",
				"Holiday total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("total4", 1), "14,400.00",
				"Vacation total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("total5", 1), "360,000.00",
				"Bonus total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("total6", 1), "8,102.97",
				"Float total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("total7", 1), "50.00",
				"Tips total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("custome_earnings_total_1", 1), "528.00",
				"test name is not as per the template saved.");

		soft47.assertEquals(getTextValueOfWebElementID("ytd1", 1), "1,538.46",
				"Salary ytd total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("ytd2", 1), "192.00",
				"Overtime YTD total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("ytd3", 1), "12,000.00",
				"Holiday ytd total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("ytd4", 1), "28,800.00",
				"Vacation ytd total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("ytd5", 1), "720,000.00",
				"Bonus ytd total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("ytd6", 1), "16,205.94",
				"Float ytd total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("ytd7", 1), "100.00",
				"Tips ytd total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("custome_earnings_ytd1", 1), "1,254.00",
				"test name in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("tcurrent", 1), "389,946.20",
				"Gross Pay total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("tytd", 1), "780,090.40",
				"Gross Pay YTD total in paystub 1 is not as per the template saved.");

		soft47.assertEquals(getTextValueOfWebElementID("fica_medicare_total", 1), "9,094.50",
				"FICA - Medicare total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("fica_social_security_total", 1), "0.00",
				"FICA - Social Security total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("federal_tax_total", 1), "141,278.90",
				"Federal Tax total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("state_tax_total", 1), "40,579.12",
				"State Tax total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("sdi_total", 1), "0.00",
				"SDI total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("sui_total", 1), "0.00",
				"SUI total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("wc_total", 1), "0.00",
				"WC total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("fli_total", 1), "0.00",
				"FLI total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("wf_total", 1), "0.00",
				"Workforce Development total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("custome_deduction_total_1", 1), "200.00",
				"Custom deduction total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("custome_deduction_total_2", 1), "0.00",
				"Test deduction total in paystub 1 is not as per the template saved.");

		soft47.assertEquals(getTextValueOfWebElementID("fica_medicare_ytd_total", 1), "9,094.50",
				"FICA - Medicare ytd total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("fica_social_security_ytd_total", 1), "9,114.00",
				"FICA - Social Security ytd total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("federal_tax_ytd_total", 1), "282,631.06",
				"Federal Tax ytd total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("state_tax_ytd_total", 1), "81,179.53",
				"State Tax ytd total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("sdi_ytd_total", 1), "157.45",
				"SDI ytd total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("sui_ytd_total", 1), "128.14",
				"SUI ytd total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("wc_ytd_total", 1), "0.00",
				"WC ytd total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("fli_ytd_total", 1), "98.80",
				"FLI ytd total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("wf_ytd_total", 1), "14.24",
				"Workforce Development ytd total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("custome_deduction_ytd_total1", 1), "400.00",
				"Custom deduction ytd total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("custome_deduction_ytd_total2", 1), "0.00",
				"Test deduction ytd total in paystub 1 is not as per the template saved.");

		soft47.assertEquals(getTextValueOfWebElementID("deductions", 1), "191,152.52",
				"deductions total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("ytd_deductions", 1), "382,817.72",
				"ytd_deductions total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("net_pay", 1), "198,793.68",
				"net_pay total in paystub 1 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("ytd_net_pay", 1), "397,272.68",
				"net_pay ytd total in paystub 1 is not as per the template saved.");

		// paystub 2
		soft47.assertEquals(getTextValueOfWebElementID("pay_period_start", 2), "02/01/2022",
				"pay_period_start in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("pay_period_end", 2), "02/14/2022",
				"pay_period_end paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("pay_date", 2), "02/14/2022",
				"pay_date paystub 2 is not as per the template saved.");

		soft47.assertEquals(getTextValueOfWebElementID("rate1", 2), "20,000.00",
				"Salary rate in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("rate2", 2), "12.00",
				"Overtime rate in paystub 2 is   not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("rate3", 2), "250.00",
				"Holiday rate in paystub 2 is   not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("rate4", 2), "600.00",
				"Vacation rate in paystub 2 is   not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("rate5", 2), "15,000.00",
				"Bonus rate in paystub 2 is   not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("rate6", 2), "900.33",
				"Float rate in paystub 2 is   not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("rate7", 2), "50.00",
				"Tips rate in paystub 2 is   not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("custome_earnings_rate_1", 2), "22.00",
				"test name rate in paystub 2 is not as per the template saved.");

		soft47.assertEquals(getTextValueOfWebElementID("hours1", 2), "0.00",
				"Salary hours in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("hours2", 2), "8.00",
				"Overtime hours in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("hours3", 2), "24.00",
				"Holiday hours in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("hours4", 2), "24.00",
				"Vacation hours in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("hours5", 2), "24.00",
				"Bonus hours in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("hours6", 2), "9.00",
				"Float hours in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("tips_total", 2), "0.00",
				"Tips hours in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("custome_earnings_hours_1", 2), "24.00",
				"test name hours in paystub 2 is not as per the template saved.");

		soft47.assertEquals(getTextValueOfWebElementID("total1", 2), "769.23",
				"Salary total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("total2", 2), "96.00",
				"Overtime total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("total3", 2), "6,000.00",
				"Holiday total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("total4", 2), "14,400.00",
				"Vacation total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("total5", 2), "360,000.00",
				"Bonus total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("total6", 2), "8,102.97",
				"Float total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("total7", 2), "50.00",
				"Tips total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("custome_earnings_total_1", 2), "528.00",
				"test name total in paystub 2 is not as per the template saved.");

		soft47.assertEquals(getTextValueOfWebElementID("ytd1", 2), "769.23",
				"Salary ytd total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("ytd2", 2), "96.00",
				"Overtime YTD total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("ytd3", 2), "6,000.00",
				"Holiday ytd total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("ytd4", 2), "14,400.00",
				"Vacation ytd total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("ytd5", 2), "360,000.00",
				"Bonus ytd total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("ytd6", 2), "8,102.97",
				"Float ytd total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("ytd7", 2), "50.00",
				"Tips ytd total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("custome_earnings_ytd1", 2), "528.00",
				"test name ytd total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("tcurrent", 2), "389,946.20",
				"Gross Pay total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("tytd", 2), "389,946.20",
				"Gross Pay YTD total in paystub 2 is not as per the template saved.");

		soft47.assertEquals(getTextValueOfWebElementID("fica_medicare_total", 2), "9,094.50",
				"FICA - Medicare total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("fica_social_security_total", 2), "9,114.00",
				"FICA - Social Security total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("federal_tax_total", 2), "141,278.90",
				"Federal Tax total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("state_tax_total", 2), "40,579.12",
				"State Tax total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("sdi_total", 2), "157.45",
				"SDI total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("sui_total", 2), "128.14",
				"SUI total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("wc_total", 2), "0.00",
				"WC total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("fli_total", 2), "98.80",
				"FLI total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("wf_total", 2), "14.24",
				"Workforce Development total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("custome_deduction_total_1", 2), "200.00",
				"Custom deduction total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("custome_deduction_total_2", 2), "0.00",
				"Test deduction total in paystub 2 is not as per the template saved.");

		soft47.assertEquals(getTextValueOfWebElementID("fica_medicare_ytd_total", 2), "9,094.50",
				"FICA - Medicare ytd total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("fica_social_security_ytd_total", 2), "9,114.00",
				"FICA - Social Security ytd total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("federal_tax_ytd_total", 2), "141,278.90",
				"Federal Tax ytd total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("state_tax_ytd_total", 2), "40,579.12",
				"State Tax ytd total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("sdi_ytd_total", 2), "157.45",
				"SDI ytd total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("sui_ytd_total", 2), "128.14",
				"SUI ytd total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("wc_ytd_total", 2), "0.00",
				"WC ytd total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("fli_ytd_total", 2), "98.80",
				"FLI ytd total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("wf_ytd_total", 2), "14.24",
				"Workforce Development ytd total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("custome_deduction_ytd_total1", 2), "200.00",
				"Custom deduction ytd total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("custome_deduction_ytd_total2", 2), "0.00",
				"Test deduction ytd total in paystub 2 is not as per the template saved.");

		soft47.assertEquals(getTextValueOfWebElementID("deductions", 2), "200,665.15",
				"deductions total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("ytd_deductions", 2), "200,665.15",
				"ytd_deductions total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("net_pay", 2), "189,281.05",
				"net_pay total in paystub 2 is not as per the template saved.");
		soft47.assertEquals(getTextValueOfWebElementID("ytd_net_pay", 2), "189,281.05",
				"net_pay ytd total in paystub 2 is not as per the template saved.");
		soft47.assertAll();

	}

	@Test(priority = 49, description = "49 Verify the forgot password functionality with valid input")
	public void verifyForgotPasswordFunctionality()
			throws TimeoutException, InterruptedException, IOException, GeneralSecurityException {
		SoftAssert soft48 = new SoftAssert();

		PaystubWebFormPage.Login();
		PaystubWebFormPage.pressForgot_PasswordLink();
		PaystubWebFormPage.enterEmailInForgotPass(propConnection.getProperty("username"));
		Gmail = PaystubWebFormPage.pressSEND_OTPButton();
		String TemplateMail[] = Gmail.getMailData("PASSOWRD RESET COFIRMATION CODE.");
		String otp = TemplateMail[1].replaceAll("[^0-9]", "").substring(0, 6);
		// System.out.println(otp);
		PaystubWebFormPage.enterValidOTP(otp);
		PaystubWebFormPage.enterNewPass(propConnection.getProperty("newPassword"));
		PaystubWebFormPage.enterNewConfirmPass(propConnection.getProperty("newPassword"));
		PaystubWebFormPage.pressChangePassButton();
		browserdriver.navigate().refresh();
		PaystubWebFormPage.Login();
		PaystubWebFormPage.enterEmailID(propConnection.getProperty("username"));
		PaystubWebFormPage.enterPassword(propConnection.getProperty("newPassword"));
		// PaystubWebFormPage.pass().sendKeys("123456");
		PaystubWebFormPage.pressloginButton();
		// Thread.sleep(3000l);
		soft48.assertEquals(PaystubWebFormPage.isUserLoggedIn(), true, "User not logged in with changed password");
		soft48.assertAll();
	}

//	@Test(description = "testing scroll feature")
//	public void testscroll() {
//		Assert.assertFalse(true);
//	}
}