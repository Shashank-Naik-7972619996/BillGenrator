package WebApp.BillGenrator;

import java.awt.Toolkit;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;

public class BillGen2023 extends BaseClass {

	@BeforeClass
	public void beforeeverymethodinsameclass() throws IOException {
		configureBrowser();
		browserdriver.get("http://staging.onlinebillgenerator.com/paystub");
	}

	@Test(priority = 1, description = "1. Verify Federal tax With Gross PayYTD Total equal to 40000")
	public void verifyFederalWithGrossPayYTDTotal40000() throws InterruptedException {
		SoftAssert soft2 = new SoftAssert();
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "500");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8");
		soft2.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "323.17");
		soft2.assertEquals(paystubTemplate1.getFederalTaxTotalTemplate1(), "323.17");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		soft2.assertEquals(paystubTemplate2.getFederalTaxTotalTemplate2(), "323.17",
				"Federal tax In template 2 is wrong");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		soft2.assertEquals(paystubTemplate3.getFederalTaxTotalTemplate3(), "323.17",
				"Federal tax In template 3 is wrong");
		soft2.assertAll();
	}

	@Test(priority = 1, description = "1. Verify Fica Medicare total tax With Gross PayYTD Total equal to 40000")
	public void verifyFICAMedicareWithGrossPayYTDTotalLessThan20000() throws InterruptedException {
		SoftAssert soft2 = new SoftAssert();
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "500");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8");
		soft2.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "323.17");
		soft2.assertEquals(paystubTemplate1.getFederalTaxTotalTemplate1(), "323.17");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		soft2.assertEquals(paystubTemplate2.getFederalTaxTotalTemplate2(), "323.17",
				"Federal tax In template 2 is wrong");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		soft2.assertEquals(paystubTemplate3.getFederalTaxTotalTemplate3(), "323.17",
				"Federal tax In template 3 is wrong");
		soft2.assertAll();
	}

	@Test(priority = 2, description = "2. Verify FICA Medicare With Gross PayYTD Total Less Than 200000")
	public void verifyFICAMedicareWithGrossPayYTDTotalLessThan200000() throws InterruptedException {
		SoftAssert soft2 = new SoftAssert();
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Jan", "1");
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
				"Fica Medicare In template 3 is wrong");

		soft2.assertAll();
	}

	@Test(priority = 3, description = "3. Verify FICAMedicare With GrossPay YTDTotal Greater Than 200000")
	public void verifyFICAMedicareWithGrossPayYTDTotalGreaterThan200000() throws InterruptedException {
		SoftAssert soft3 = new SoftAssert();
		browserdriver.navigate().refresh();
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "200000");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "9");
		String FicaMedicare = paystubTemplate1.getFICAMedicareTemplate1();
		soft3.assertEquals(getTextValueOfWebElementID("fica_medicare_total"), "42,150.00");
		soft3.assertEquals(FicaMedicare, "42,150.00");
		soft3.assertAll();
	}

	@Test(priority = 4, description = "4. Verify FICA-Social-Security Calculations when social is less than 9114 for the year 2023")
	public void verifyFICASocialSecurityCalculations() throws InterruptedException {
		SoftAssert soft4 = new SoftAssert();
		browserdriver.navigate().refresh();
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "30");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40");
		String FICASocialSecurity = paystubTemplate1.getFicasocialSecurityTotalTemplate1();
		soft4.assertEquals(getTextValueOfWebElementID("fica_social_security_total"), "74.40");
		soft4.assertEquals(FICASocialSecurity, "74.40");
		soft4.assertAll();
	}

	@Test(priority = 5, description = "5. Verify FICA-Social-Security Calculations when social is greater than 9114 for the year 2023 on all preview page.")
	public void verifyFicaSocialSecurityCalculations() throws InterruptedException {
		SoftAssert soft5 = new SoftAssert();
		browserdriver.navigate().refresh();
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "147000");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "1");

		soft5.assertEquals(getTextValueOfWebElementID("fica_social_security_total"), "9,114.00");
		soft5.assertEquals(paystubTemplate1.getFicasocialSecurityTotalTemplate1(), "9,114.00");
		PaystubWebFormPage.enterRegularRates(1, "247000");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "1");
		soft5.assertEquals(getTextValueOfWebElementID("fica_social_security_total"), "9,114.00");
		soft5.assertEquals(paystubTemplate1.getFicasocialSecurityTotalTemplate1(), "9,114.00");
		soft5.assertAll();
	}

	@Test(priority = 6, description = "6. Verify federal tax calculations with martial status as 'Single'")
	public void VerifyFederalTaxCalculationsonTemplate1() throws InterruptedException {
		SoftAssert soft6 = new SoftAssert();
		browserdriver.navigate().refresh();
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "200.00");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40.00");
		soft6.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "1,115.04");
		soft6.assertEquals(paystubTemplate1.getFederalTaxTotalTemplate1(), "1,115.04");

		// Verify federal tax with lowest value 800 as gross total
		PaystubWebFormPage.enterRegularRates(1, "10.00");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80.00");
		soft6.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "0.00");
		soft6.assertEquals(paystubTemplate1.getFederalTaxTotalTemplate1(), "0.00");

		PaystubWebFormPage.enterRegularRates(1, "80000");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "1");
		soft6.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "25,867.29");
		soft6.assertEquals(paystubTemplate1.getFederalTaxTotalTemplate1(), "25,867.29");

		soft6.assertAll();
	}

	@Test(priority = 7, description = "7.	Verify federal tax calculations with martial status as 'Married'")
	public void VerifyFederalTaxCalculationsWithMarriedOnTemplate1() throws InterruptedException {
		SoftAssert soft7 = new SoftAssert();
		browserdriver.navigate().refresh();
		PaystubWebFormPage.selectEmployee_Marital_Status("Married");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Jan", "1");

		PaystubWebFormPage.enterRegularRates(1, "200.00");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40.00");
		soft7.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "646.33");
		soft7.assertEquals(paystubTemplate1.getFederalTaxTotalTemplate1(), "646.33");

		PaystubWebFormPage.enterRegularRates(1, "10.00");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80.00");
		soft7.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "0.00");
		soft7.assertEquals(paystubTemplate1.getFederalTaxTotalTemplate1(), "0.00");

		PaystubWebFormPage.enterRegularRates(1, "80000");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "1");
		soft7.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "22,905.42");
		soft7.assertEquals(paystubTemplate1.getFederalTaxTotalTemplate1(), "22,905.42");
		soft7.assertAll();
	}

	@Test(priority = 8, description = "8. Verify Federal Tax calculations for all exemptions with maratial status as 'Single'")
	public void verifyFederalTaxWithAllExemptions() throws InterruptedException {
		SoftAssert soft8 = new SoftAssert();
		browserdriver.navigate().refresh();
		PaystubWebFormPage.selectEmployee_Marital_Status("Single");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Jan", "1");

		PaystubWebFormPage.enterRegularRates(1, "200.00");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40.00");
		PaystubWebFormPage.selectExemptions("0");
		String FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "1,115.04");
		soft8.assertEquals(FederalTaxTotal, "1,115.04");

		PaystubWebFormPage.selectExemptions("1");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "1,040.79");
		soft8.assertEquals(FederalTaxTotal, "1,040.79");

		PaystubWebFormPage.selectExemptions("2");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "966.54");
		soft8.assertEquals(FederalTaxTotal, "966.54");

		PaystubWebFormPage.selectExemptions("3");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "892.29");
		soft8.assertEquals(FederalTaxTotal, "892.29");

		PaystubWebFormPage.selectExemptions("4");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "818.04");
		soft8.assertEquals(FederalTaxTotal, "818.04");

		PaystubWebFormPage.selectExemptions("5");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "743.79");
		soft8.assertEquals(FederalTaxTotal, "743.79");

		PaystubWebFormPage.selectExemptions("6");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "669.54");
		soft8.assertEquals(FederalTaxTotal, "669.54");

		PaystubWebFormPage.selectExemptions("7");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "595.29");
		soft8.assertEquals(FederalTaxTotal, "595.29");

		PaystubWebFormPage.selectExemptions("8");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "521.04");
		soft8.assertEquals(FederalTaxTotal, "521.04");

		PaystubWebFormPage.selectExemptions("9");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "446.79");
		soft8.assertEquals(FederalTaxTotal, "446.79");

		browserdriver.navigate().refresh();
		PaystubWebFormPage.selectEmployee_Marital_Status("Married");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Jan", "1");

		PaystubWebFormPage.enterRegularRates(1, "200.00");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40.00");
		PaystubWebFormPage.selectExemptions("0");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "646.33");
		soft8.assertEquals(FederalTaxTotal, "646.33");

		PaystubWebFormPage.selectExemptions("1");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "605.83");
		soft8.assertEquals(FederalTaxTotal, "605.83");

		PaystubWebFormPage.selectExemptions("2");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "565.33");
		soft8.assertEquals(FederalTaxTotal, "565.33");

		PaystubWebFormPage.selectExemptions("3");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "524.83");
		soft8.assertEquals(FederalTaxTotal, "524.83");

		PaystubWebFormPage.selectExemptions("4");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "484.33");
		soft8.assertEquals(FederalTaxTotal, "484.33");

		PaystubWebFormPage.selectExemptions("5");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "443.83");
		soft8.assertEquals(FederalTaxTotal, "443.83");

		PaystubWebFormPage.selectExemptions("6");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "403.33");
		soft8.assertEquals(FederalTaxTotal, "403.33");

		PaystubWebFormPage.selectExemptions("7");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "362.83");
		soft8.assertEquals(FederalTaxTotal, "362.83");

		PaystubWebFormPage.selectExemptions("8");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "322.33");
		soft8.assertEquals(FederalTaxTotal, "322.33");

		PaystubWebFormPage.selectExemptions("9");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft8.assertEquals(getTextValueOfWebElementID("federal_tax_total"), "281.83");
		soft8.assertEquals(FederalTaxTotal, "281.83");

		soft8.assertAll();
	}

	@Test(priority = 9, description = "9. Verify State tax calculations for all states with martial status as 'Married' with ytdtotal as '800' and year is 2022")
	public void VerifyStateTaxCalculationsWithAllStatesOnTemplate1() throws InterruptedException {
		SoftAssert soft9 = new SoftAssert();
		browserdriver.navigate().refresh();
//		browserdriver.manage().window().maximize();
		PaystubWebFormPage.selectEmployee_Marital_Status("Married");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "10");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80");
		// Alabama
		PaystubWebFormPage.selectEmployee_State("Alabama");
		String StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "5.33");
		soft9.assertEquals(StateTaxTotal, "5.33", "Wrong State Tax for state Alabama");

		// For Alaska
		PaystubWebFormPage.selectEmployee_State("Alaska");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Alaska");
		// Arizona
		PaystubWebFormPage.selectEmployee_State("Arizona");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Arizona");

		PaystubWebFormPage.selectEmployee_State("Arkansas");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "10.17");
		soft9.assertEquals(StateTaxTotal, "10.17", "Wrong State Tax for state Arkansas");

		PaystubWebFormPage.selectEmployee_State("California");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state California");

		PaystubWebFormPage.selectEmployee_State("Colorado");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Colorado");

		PaystubWebFormPage.selectEmployee_State("Connecticut");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "24.00");
		soft9.assertEquals(StateTaxTotal, "24.00", "Wrong State Tax for state Connecticut");

		PaystubWebFormPage.selectEmployee_State("Delaware");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "2.02");
		soft9.assertEquals(StateTaxTotal, "2.02", "Wrong State Tax for state Delaware");

		PaystubWebFormPage.selectEmployee_State("District Of Columbia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state District Of Columbia");

		PaystubWebFormPage.selectEmployee_State("Florida");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Florida");

		PaystubWebFormPage.selectEmployee_State("Georgia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "5.67");
		soft9.assertEquals(StateTaxTotal, "5.67", "Wrong State Tax for state Georgia");

		PaystubWebFormPage.selectEmployee_State("Hawaii");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "6.67");
		soft9.assertEquals(StateTaxTotal, "6.67", "Wrong State Tax for state Hawaii");

		PaystubWebFormPage.selectEmployee_State("Idaho");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Idaho");

		PaystubWebFormPage.selectEmployee_State("Illinois");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "39.60");
		soft9.assertEquals(StateTaxTotal, "39.60", "Wrong State Tax for state Illinois");

		PaystubWebFormPage.selectEmployee_State("Indiana");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "25.84");
		soft9.assertEquals(StateTaxTotal, "25.84", "Wrong State Tax for state Indiana");

		PaystubWebFormPage.selectEmployee_State("Iowa");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "2.70");
		soft9.assertEquals(StateTaxTotal, "2.70", "Wrong State Tax for state Iowa");

		PaystubWebFormPage.selectEmployee_State("Kansas");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "4.13");
		soft9.assertEquals(StateTaxTotal, "4.13", "Wrong State Tax for state Kansas");

		PaystubWebFormPage.selectEmployee_State("Kentucky");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "16.92");
		soft9.assertEquals(StateTaxTotal, "16.92", "Wrong State Tax for state Kentucky");

		PaystubWebFormPage.selectEmployee_State("Louisiana");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "16.00");
		soft9.assertEquals(StateTaxTotal, "16.00", "Wrong State Tax for state Louisiana");

		PaystubWebFormPage.selectEmployee_State("Maine");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Maine");

		PaystubWebFormPage.selectEmployee_State("Maryland");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "15.02");
		soft9.assertEquals(StateTaxTotal, "15.02", "Wrong State Tax for state Maryland");

		PaystubWebFormPage.selectEmployee_State("Massachusetts");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "40.00");
		soft9.assertEquals(StateTaxTotal, "40.00", "Wrong State Tax for state Massachusetts");

		PaystubWebFormPage.selectEmployee_State("Michigan");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "34.00");
		soft9.assertEquals(StateTaxTotal, "34.00", "Wrong State Tax for state Michigan");

		PaystubWebFormPage.selectEmployee_State("Minnesota");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Minnesota");

		PaystubWebFormPage.selectEmployee_State("Mississippi");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "2.50");
		soft9.assertEquals(StateTaxTotal, "2.50", "Wrong State Tax for state Mississippi");

		PaystubWebFormPage.selectEmployee_State("Missouri");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Missouri");

		PaystubWebFormPage.selectEmployee_State("Montana");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Montana");

		PaystubWebFormPage.selectEmployee_State("Nebraska");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Nebraska");

		PaystubWebFormPage.selectEmployee_State("Nevada");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Nevada");

		PaystubWebFormPage.selectEmployee_State("New Hampshire");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state New Hampshire");

		PaystubWebFormPage.selectEmployee_State("New Jersey");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "11.20");
		soft9.assertEquals(StateTaxTotal, "11.20", "Wrong State Tax for state New Jersey");

		PaystubWebFormPage.selectEmployee_State("New Mexico");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state New Mexico");

		PaystubWebFormPage.selectEmployee_State("New York");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state New York");

		PaystubWebFormPage.selectEmployee_State("North Carolina");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state North Carolina");

		PaystubWebFormPage.selectEmployee_State("North Dakota");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state North Dakota");

		PaystubWebFormPage.selectEmployee_State("Ohio");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Ohio");

		PaystubWebFormPage.selectEmployee_State("Oklahoma");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Oklahoma");

		PaystubWebFormPage.selectEmployee_State("Oregon");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "18.84");
		soft9.assertEquals(StateTaxTotal, "18.84", "Wrong State Tax for state Oregon");

		PaystubWebFormPage.selectEmployee_State("Pennsylvania");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "24.56");
		soft9.assertEquals(StateTaxTotal, "24.56", "Wrong State Tax for state Pennsylvania");

		PaystubWebFormPage.selectEmployee_State("Rhode Island");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Rhode Island");

		PaystubWebFormPage.selectEmployee_State("South Carolina");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state South Carolina");

		PaystubWebFormPage.selectEmployee_State("South Dakota");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state South Dakota");

		PaystubWebFormPage.selectEmployee_State("Tennessee");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Tennessee");

		PaystubWebFormPage.selectEmployee_State("Texas");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Texas");

		PaystubWebFormPage.selectEmployee_State("Utah");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "39.60");
		soft9.assertEquals(StateTaxTotal, "39.60", "Wrong State Tax for state Utah");

		PaystubWebFormPage.selectEmployee_State("Vermont");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Vermont");

		PaystubWebFormPage.selectEmployee_State("Virginia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "1.00");
		soft9.assertEquals(StateTaxTotal, "1.00", "Wrong State Tax for state Virginia");

		PaystubWebFormPage.selectEmployee_State("Washington");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Washington");

		PaystubWebFormPage.selectEmployee_State("West Virginia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "24.00");
		soft9.assertEquals(StateTaxTotal, "24.00", "Wrong State Tax for state Virginia");

		PaystubWebFormPage.selectEmployee_State("Wisconsin");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Wisconsin");

		PaystubWebFormPage.selectEmployee_State("Wyomin"); // correct state is Wyoming need to fix this.
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft9.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft9.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Wyomin");
		soft9.assertAll();
	}

	@Test(priority = 10, description = "10. Verify State tax calculations for all states with martial status as 'Single' with ytdtotal as '800' and year is 2023")
	public void VerifyStateTaxCalculationsWithAllStatesWithSingleOnTemplate1() throws InterruptedException {
		SoftAssert soft10 = new SoftAssert();
		browserdriver.navigate().refresh();
		// browserdriver.manage().window().maximize();
		// PaystubWebFormPage.selectEmployee_Marital_Status("Married");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "10");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80");
		// Alabama
		PaystubWebFormPage.selectEmployee_State("Alabama");
		String StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "26.25");
		soft10.assertEquals(StateTaxTotal, "26.25", "Wrong State Tax for state Alabama");

		// For Alaska
		PaystubWebFormPage.selectEmployee_State("Alaska");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Alaska");
		// Arizona
		PaystubWebFormPage.selectEmployee_State("Arizona");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Arizona");

		PaystubWebFormPage.selectEmployee_State("Arkansas");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "17.50");
		soft10.assertEquals(StateTaxTotal, "17.50", "Wrong State Tax for state Arkansas");

		PaystubWebFormPage.selectEmployee_State("California");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "4.00");
		soft10.assertEquals(StateTaxTotal, "4.00", "Wrong State Tax for state California");

		PaystubWebFormPage.selectEmployee_State("Colorado");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Colorado");

		PaystubWebFormPage.selectEmployee_State("Connecticut");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "24.00");
		soft10.assertEquals(StateTaxTotal, "24.00", "Wrong State Tax for state Connecticut");

		PaystubWebFormPage.selectEmployee_State("Delaware");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "9.89");
		soft10.assertEquals(StateTaxTotal, "9.89", "Wrong State Tax for state Delaware");

		PaystubWebFormPage.selectEmployee_State("District Of Columbia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state District Of Columbia");

		PaystubWebFormPage.selectEmployee_State("Florida");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Florida");

		PaystubWebFormPage.selectEmployee_State("Georgia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "11.04");
		soft10.assertEquals(StateTaxTotal, "11.04", "Wrong State Tax for state Georgia");

		PaystubWebFormPage.selectEmployee_State("Hawaii");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "21.12");
		soft10.assertEquals(StateTaxTotal, "21.12", "Wrong State Tax for state Hawaii");

		PaystubWebFormPage.selectEmployee_State("Idaho");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Idaho");

		PaystubWebFormPage.selectEmployee_State("Illinois");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "39.60");
		soft10.assertEquals(StateTaxTotal, "39.60", "Wrong State Tax for state Illinois");

		PaystubWebFormPage.selectEmployee_State("Indiana");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "25.84");
		soft10.assertEquals(StateTaxTotal, "25.84", "Wrong State Tax for state Indiana");

		PaystubWebFormPage.selectEmployee_State("Iowa");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "9.43");
		soft10.assertEquals(StateTaxTotal, "9.43", "Wrong State Tax for state Iowa");

		PaystubWebFormPage.selectEmployee_State("Kansas");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "15.76");
		soft10.assertEquals(StateTaxTotal, "15.76", "Wrong State Tax for state Kansas");

		PaystubWebFormPage.selectEmployee_State("Kentucky");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "28.46");
		soft10.assertEquals(StateTaxTotal, "28.46", "Wrong State Tax for state Kentucky");

		PaystubWebFormPage.selectEmployee_State("Louisiana");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "14.80");
		soft10.assertEquals(StateTaxTotal, "14.80", "Wrong State Tax for state Louisiana");

		PaystubWebFormPage.selectEmployee_State("Maine");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Maine");

		PaystubWebFormPage.selectEmployee_State("Maryland");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "24.32");
		soft10.assertEquals(StateTaxTotal, "24.32", "Wrong State Tax for state Maryland");

		PaystubWebFormPage.selectEmployee_State("Massachusetts");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "40.00");
		soft10.assertEquals(StateTaxTotal, "40.00", "Wrong State Tax for state Massachusetts");

		PaystubWebFormPage.selectEmployee_State("Michigan");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "34.00");
		soft10.assertEquals(StateTaxTotal, "34.00", "Wrong State Tax for state Michigan");

		PaystubWebFormPage.selectEmployee_State("Minnesota");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Minnesota");

		PaystubWebFormPage.selectEmployee_State("Mississippi");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "10.17");
		soft10.assertEquals(StateTaxTotal, "10.17", "Wrong State Tax for state Mississippi");

		PaystubWebFormPage.selectEmployee_State("Missouri");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Missouri");

		PaystubWebFormPage.selectEmployee_State("Montana");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "5.37");
		soft10.assertEquals(StateTaxTotal, "5.37", "Wrong State Tax for state Montana");

		PaystubWebFormPage.selectEmployee_State("Nebraska");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "4.61");
		soft10.assertEquals(StateTaxTotal, "4.61", "Wrong State Tax for state Nebraska");

		PaystubWebFormPage.selectEmployee_State("Nevada");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Nevada");

		PaystubWebFormPage.selectEmployee_State("New Hampshire");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state New Hampshire");

		PaystubWebFormPage.selectEmployee_State("New Jersey");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "11.20");
		soft10.assertEquals(StateTaxTotal, "11.20", "Wrong State Tax for state New Jersey");

		PaystubWebFormPage.selectEmployee_State("New Mexico");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state New Mexico");

		PaystubWebFormPage.selectEmployee_State("New York");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "5.33");
		soft10.assertEquals(StateTaxTotal, "5.33", "Wrong State Tax for state New York");

		PaystubWebFormPage.selectEmployee_State("North Carolina");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state North Carolina");

		PaystubWebFormPage.selectEmployee_State("North Dakota");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state North Dakota");

		PaystubWebFormPage.selectEmployee_State("Ohio");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Ohio");

		PaystubWebFormPage.selectEmployee_State("Oklahoma");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "2.24");
		soft10.assertEquals(StateTaxTotal, "2.24", "Wrong State Tax for state Oklahoma");

		PaystubWebFormPage.selectEmployee_State("Oregon");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "34.30");
		soft10.assertEquals(StateTaxTotal, "34.30", "Wrong State Tax for state Oregon");

		PaystubWebFormPage.selectEmployee_State("Pennsylvania");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "24.56");
		soft10.assertEquals(StateTaxTotal, "24.56", "Wrong State Tax for state Pennsylvania");

		PaystubWebFormPage.selectEmployee_State("Rhode Island");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.94");
		soft10.assertEquals(StateTaxTotal, "0.94", "Wrong State Tax for state Rhode Island");

		PaystubWebFormPage.selectEmployee_State("South Carolina");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state South Carolina");

		PaystubWebFormPage.selectEmployee_State("South Dakota");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state South Dakota");

		PaystubWebFormPage.selectEmployee_State("Tennessee");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Tennessee");

		PaystubWebFormPage.selectEmployee_State("Texas");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Texas");

		PaystubWebFormPage.selectEmployee_State("Utah");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "39.60");
		soft10.assertEquals(StateTaxTotal, "39.60", "Wrong State Tax for state Utah");

		PaystubWebFormPage.selectEmployee_State("Vermont");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "9.07");
		soft10.assertEquals(StateTaxTotal, "9.07", "Wrong State Tax for state Vermont");

		PaystubWebFormPage.selectEmployee_State("Virginia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "10.42");
		soft10.assertEquals(StateTaxTotal, "10.42", "Wrong State Tax for state Virginia");

		PaystubWebFormPage.selectEmployee_State("Washington");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Washington");

		PaystubWebFormPage.selectEmployee_State("West Virginia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "24.00");
		soft10.assertEquals(StateTaxTotal, "24.00", "Wrong State Tax for state Virginia");

		PaystubWebFormPage.selectEmployee_State("Wisconsin");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Wisconsin");

		PaystubWebFormPage.selectEmployee_State("Wyomin"); // correct state is Wyoming need to fix this.
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft10.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft10.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Wyomin");
		soft10.assertAll();
	}

	@Test(priority = 11, description = "11. Verify State tax calculations for all states with martial status as 'Single' with ytdtotal as '8000' and year is 2023")
	public void VerifyStateTaxCalculationsWithAllStatesWithSingle2OnTemplate1() throws InterruptedException {
		SoftAssert soft11 = new SoftAssert();
		browserdriver.navigate().refresh();
		browserdriver.manage().window().maximize();
		// PaystubWebFormPage.selectEmployee_Marital_Status("Married");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Jan", "1");
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

	@Test(priority = 12, description = "12. Verify State tax calculations for all states with martial status as 'Married' with ytdtotal as '8000' and year is 2023")
	public void VerifyStateTaxCalculationsWithAllStatesWithMarriedOnTemplate1() throws InterruptedException {
		SoftAssert soft12 = new SoftAssert();
		browserdriver.navigate().refresh();
		browserdriver.manage().window().maximize();
		PaystubWebFormPage.selectEmployee_Marital_Status("Married");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "10");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800");
		// Alabama
		PaystubWebFormPage.selectEmployee_State("Alabama");
		String StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "362.08");
		soft12.assertEquals(StateTaxTotal, "362.08", "Wrong State Tax for state Alabama");

		// For Alaska
		PaystubWebFormPage.selectEmployee_State("Alaska");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft12.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Alaska");
		// Arizona
		PaystubWebFormPage.selectEmployee_State("Arizona");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "160.35");
		soft12.assertEquals(StateTaxTotal, "160.35", "Wrong State Tax for state Arizona");

		PaystubWebFormPage.selectEmployee_State("Arkansas");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "429.74");
		soft12.assertEquals(StateTaxTotal, "429.74", "Wrong State Tax for state Arkansas");

		PaystubWebFormPage.selectEmployee_State("California");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "235.10");
		soft12.assertEquals(StateTaxTotal, "235.10", "Wrong State Tax for state California");

		PaystubWebFormPage.selectEmployee_State("Colorado");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "265.80");
		soft12.assertEquals(StateTaxTotal, "265.80", "Wrong State Tax for state Colorado");

		PaystubWebFormPage.selectEmployee_State("Connecticut");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "366.67");
		soft12.assertEquals(StateTaxTotal, "366.67", "Wrong State Tax for state Connecticut");

		PaystubWebFormPage.selectEmployee_State("Delaware");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "407.54");
		soft12.assertEquals(StateTaxTotal, "407.54", "Wrong State Tax for state Delaware");

		PaystubWebFormPage.selectEmployee_State("District Of Columbia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "363.21");
		soft12.assertEquals(StateTaxTotal, "363.21", "Wrong State Tax for state District Of Columbia");

		PaystubWebFormPage.selectEmployee_State("Florida");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft12.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Florida");

		PaystubWebFormPage.selectEmployee_State("Georgia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "411.67");
		soft12.assertEquals(StateTaxTotal, "411.67", "Wrong State Tax for state Georgia");

		PaystubWebFormPage.selectEmployee_State("Hawaii");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "506.63");
		soft12.assertEquals(StateTaxTotal, "506.63", "Wrong State Tax for state Hawaii");

		PaystubWebFormPage.selectEmployee_State("Idaho");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "313.45");
		soft12.assertEquals(StateTaxTotal, "313.45", "Wrong State Tax for state Idaho");

		PaystubWebFormPage.selectEmployee_State("Illinois");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "396.00");
		soft12.assertEquals(StateTaxTotal, "396.00", "Wrong State Tax for state Illinois");

		PaystubWebFormPage.selectEmployee_State("Indiana");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "258.40");
		soft12.assertEquals(StateTaxTotal, "258.40", "Wrong State Tax for state Indiana");

		PaystubWebFormPage.selectEmployee_State("Iowa");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "469.40");
		soft12.assertEquals(StateTaxTotal, "469.40", "Wrong State Tax for state Iowa");

		PaystubWebFormPage.selectEmployee_State("Kansas");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "341.75");
		soft12.assertEquals(StateTaxTotal, "341.75", "Wrong State Tax for state Kansas");

		PaystubWebFormPage.selectEmployee_State("Kentucky");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "376.92");
		soft12.assertEquals(StateTaxTotal, "376.92", "Wrong State Tax for state Kentucky");

		PaystubWebFormPage.selectEmployee_State("Louisiana");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "278.33");
		soft12.assertEquals(StateTaxTotal, "278.33", "Wrong State Tax for state Louisiana");

		PaystubWebFormPage.selectEmployee_State("Maine");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "357.90");
		soft12.assertEquals(StateTaxTotal, "357.90", "Wrong State Tax for state Maine");

		PaystubWebFormPage.selectEmployee_State("Maryland");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "357.02");
		soft12.assertEquals(StateTaxTotal, "357.02", "Wrong State Tax for state Maryland");

		PaystubWebFormPage.selectEmployee_State("Massachusetts");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "400.00");
		soft12.assertEquals(StateTaxTotal, "400.00", "Wrong State Tax for state Massachusetts");

		PaystubWebFormPage.selectEmployee_State("Michigan");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "340.00");
		soft12.assertEquals(StateTaxTotal, "340.00", "Wrong State Tax for state Michigan");

		PaystubWebFormPage.selectEmployee_State("Minnesota");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "348.20");
		soft12.assertEquals(StateTaxTotal, "348.20", "Wrong State Tax for state Minnesota");

		PaystubWebFormPage.selectEmployee_State("Mississippi");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "358.33");
		soft12.assertEquals(StateTaxTotal, "358.33", "Wrong State Tax for state Mississippi");

		PaystubWebFormPage.selectEmployee_State("Missouri");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "299.72");
		soft12.assertEquals(StateTaxTotal, "299.72", "Wrong State Tax for state Missouri");

		PaystubWebFormPage.selectEmployee_State("Montana");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "446.52");
		soft12.assertEquals(StateTaxTotal, "446.52", "Wrong State Tax for state Montana");

		PaystubWebFormPage.selectEmployee_State("Nebraska");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "304.72");
		soft12.assertEquals(StateTaxTotal, "304.72", "Wrong State Tax for state Nebraska");

		PaystubWebFormPage.selectEmployee_State("Nevada");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft12.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Nevada");

		PaystubWebFormPage.selectEmployee_State("New Hampshire");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft12.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state New Hampshire");

		PaystubWebFormPage.selectEmployee_State("New Jersey");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "210.75");
		soft12.assertEquals(StateTaxTotal, "210.75", "Wrong State Tax for state New Jersey");

		PaystubWebFormPage.selectEmployee_State("New Mexico");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "252.24");
		soft12.assertEquals(StateTaxTotal, "252.24", "Wrong State Tax for state New Mexico");

		PaystubWebFormPage.selectEmployee_State("New York");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "353.91");
		soft12.assertEquals(StateTaxTotal, "353.91", "Wrong State Tax for state New York");

		PaystubWebFormPage.selectEmployee_State("North Carolina");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "293.16");
		soft12.assertEquals(StateTaxTotal, "293.16", "Wrong State Tax for state North Carolina");

		PaystubWebFormPage.selectEmployee_State("North Dakota");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "66.14");
		soft12.assertEquals(StateTaxTotal, "66.14", "Wrong State Tax for state North Dakota");

		PaystubWebFormPage.selectEmployee_State("Ohio");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "186.38");
		soft12.assertEquals(StateTaxTotal, "186.38", "Wrong State Tax for state Ohio");

		PaystubWebFormPage.selectEmployee_State("Oklahoma");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "300.15");
		soft12.assertEquals(StateTaxTotal, "300.15", "Wrong State Tax for state Oklahoma");

		PaystubWebFormPage.selectEmployee_State("Oregon");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "621.88");
		soft12.assertEquals(StateTaxTotal, "621.88", "Wrong State Tax for state Oregon");

		PaystubWebFormPage.selectEmployee_State("Pennsylvania");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "245.60");
		soft12.assertEquals(StateTaxTotal, "245.60", "Wrong State Tax for state Pennsylvania");

		PaystubWebFormPage.selectEmployee_State("Rhode Island");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "249.54");
		soft12.assertEquals(StateTaxTotal, "249.54", "Wrong State Tax for state Rhode Island");

		PaystubWebFormPage.selectEmployee_State("South Carolina");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "363.51");
		soft12.assertEquals(StateTaxTotal, "363.51", "Wrong State Tax for state South Carolina");

		PaystubWebFormPage.selectEmployee_State("South Dakota");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft12.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state South Dakota");

		PaystubWebFormPage.selectEmployee_State("Tennessee");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft12.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Tennessee");

		PaystubWebFormPage.selectEmployee_State("Texas");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft12.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Texas");

		PaystubWebFormPage.selectEmployee_State("Utah");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "396.00");
		soft12.assertEquals(StateTaxTotal, "396.00", "Wrong State Tax for state Utah");

		PaystubWebFormPage.selectEmployee_State("Vermont");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "272.90");
		soft12.assertEquals(StateTaxTotal, "272.90", "Wrong State Tax for state Vermont");

		PaystubWebFormPage.selectEmployee_State("Virginia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "395.42");
		soft12.assertEquals(StateTaxTotal, "395.42", "Wrong State Tax for state Virginia");

		PaystubWebFormPage.selectEmployee_State("Washington");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft12.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Washington");

		PaystubWebFormPage.selectEmployee_State("West Virginia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "426.25");
		soft12.assertEquals(StateTaxTotal, "426.25", "Wrong State Tax for state Virginia");

		PaystubWebFormPage.selectEmployee_State("Wisconsin");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "293.46");
		soft12.assertEquals(StateTaxTotal, "293.46", "Wrong State Tax for state Wisconsin");

		PaystubWebFormPage.selectEmployee_State("Wyomin"); // correct state is Wyoming need to fix this.
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft12.assertEquals(getTextValueOfWebElementID("state_tax_total"), "0.00");
		soft12.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Wyomin");
		soft12.assertAll();
	}

	@Test(priority = 13, dataProvider = "sdiStates", description = "13. Verify SDI tax calculations with martial status as 'Single' for the state with ytdtotal as '400','800','8000','80000'")
	public void VerifySDITaxCalculationsonTemplate1(String states) throws InterruptedException {
		SoftAssert soft13 = new SoftAssert();
		browserdriver.navigate().refresh();
//		browserdriver.manage().window().maximize();
		PaystubWebFormPage.selectEmployee_State(states);
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Jan", "1");
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
		browserdriver.navigate().refresh();
		String state = browserdriver.manage().window().getPosition().getX() == 0
				&& browserdriver.manage().window().getPosition().getY() == 0
				&& browserdriver.manage().window().getSize().getWidth() == Toolkit.getDefaultToolkit().getScreenSize()
						.getWidth()
				&& browserdriver.manage().window().getSize().getHeight() == Toolkit.getDefaultToolkit().getScreenSize()
						.getHeight() ? "maximized" : "normal";
		if (state.equals("normal")) {
			browserdriver.manage().window().maximize();
		}
		PaystubWebFormPage.selectEmployee_State(states);
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Jan", "1");
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
		browserdriver.navigate().refresh();
		browserdriver.manage().window().maximize();

		PaystubWebFormPage.selectEmployee_State("Oregon");
		// PaystubWebFormPage.select_how_often_you_paid("Monthly (ex: 1st of month
		// only)");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Jan", "1");
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

		PaystubWebFormPage.select_how_often_you_paid("Daily");
		PaystubWebFormPage.selectEmployee_State("New Mexico");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Jan", "1");
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

		PaystubWebFormPage.select_how_often_you_paid("Weekly (ex: every Friday)");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Jan", "1");
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

		PaystubWebFormPage.select_how_often_you_paid("Bi-Weekly (ex: every other Wednesday)");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Jan", "1");
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

//		PaystubWebFormPage.select_how_often_you_paid("Semi-Monthly (ex: 1st and 15th)");
//		PaystubWebFormPage.enterPay_period_start(1, "2023", "Jan", "1");
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

		PaystubWebFormPage.select_how_often_you_paid("Monthly (ex: 1st of month only)");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Jan", "1");
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

		PaystubWebFormPage.select_how_often_you_paid("Quarterly");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Jan", "1");
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

		PaystubWebFormPage.select_how_often_you_paid("Semi-Annually");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Jan", "1");
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

		PaystubWebFormPage.select_how_often_you_paid("Annually");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Jan", "1");
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

		soft15.assertAll("The WC Values are wrong");
	}

	@Test(priority = 16, description = "16. Verify FLI-FLV tax calculations with martial status as 'Single' with ytdtotal as '400','800','8000','80000'")
	public void Verify_FLIFLV_Tax_Calculations_on_Template1_with_State() throws InterruptedException {
		SoftAssert soft16 = new SoftAssert();
		browserdriver.navigate().refresh();
		browserdriver.manage().window().maximize();
		PaystubWebFormPage.selectEmployee_State("New Jersey");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Jan", "1");
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
		browserdriver.manage().window().maximize();
		PaystubWebFormPage.selectEmployee_State("New Jersey");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "10");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80");
		soft17.assertEquals(getTextValueOfWebElementID("wf_total"), "0.34");
		soft17.assertEquals(paystubTemplate1.getTemplate1WorkForceDevTaxTotal(), "0.34");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800");
		soft17.assertEquals(getTextValueOfWebElementID("wf_total"), "3.40");
		soft17.assertEquals(paystubTemplate1.getTemplate1WorkForceDevTaxTotal(), "3.40");
		soft17.assertAll();
	}

	@Test(priority = 18, description = "18. Verify Workforce Development tax when Gross Pay YTD total is equal to 33500")
	public void calculateWorkforceDevelopment2() throws InterruptedException {
		// SoftAssert soft10 = new SoftAssert();
		SoftAssert soft18 = new SoftAssert();
		browserdriver.navigate().refresh();
		browserdriver.manage().window().maximize();
		PaystubWebFormPage.selectEmployee_State("New Jersey");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "1");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "33500");
		soft18.assertEquals(getTextValueOfWebElementID("wf_total"), "14.24");
		soft18.assertEquals(paystubTemplate1.getTemplate1WorkForceDevTaxTotal(), "14.24");
		soft18.assertAll();
	}

	@Test(priority = 19, description = "19. Verify Workforce Development tax when Gross Pay YTD total is greater than 33500")
	public void calculateWorkforceDevelopment3() throws InterruptedException {
		SoftAssert soft19 = new SoftAssert();
		browserdriver.navigate().refresh();
		browserdriver.manage().window().maximize();
		PaystubWebFormPage.selectEmployee_State("New Jersey");
		PaystubWebFormPage.enterPay_period_start(1, "2023", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "1");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40000");
		soft19.assertEquals(getTextValueOfWebElementID("wf_total"), "14.24");
		soft19.assertEquals(paystubTemplate1.getTemplate1WorkForceDevTaxTotal(), "14.24");
		soft19.assertAll();
	}
}
