package mobileApp.BillGenrator;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import MobileApp.BillGenratorMobileApp2.PageObject.Android.CommonFormElements;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.OrderPage;
import base.BaseClass;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class W2Form extends BaseClass {
	
	@BeforeClass
	@org.testng.annotations.Parameters({"deviceName", "platformVersion", "udid"})
	public void beforeeverymethodinsameclass(String deviceName, String platformVersion, String udid) throws IOException {
		ConfigurAndroid(deviceName, platformVersion, udid);
	}

	@Test(priority=1)
	public void W2Form_EnterAllDataManually() throws Exception {
		SoftAssert softAssertion1 = new SoftAssert();
		dashboard = flashscreen.pressGetStarted();
		LoginWithValidCred();
		SideNevigationMenu = dashboard.pressRigtSideNevigationMenu();
		W2FormStep1 = SideNevigationMenu.ClickW2Form();
		W2FormStep1.selectAutoCalculatorOff();
		W2FormStep1.selectWhatYear(propConnection.getProperty("W2WhatYear"));
		W2FormStep1.selectMarital_StatusMarried();
		W2FormStep1.selectExemption(propConnection.getProperty("W2ExemptW2"));
		W2FormStep1.enterHow_Much_Did_You_Make_before_Taxes_Last_Year(
				propConnection.getProperty("W2How_Much_Did_You_Make"));
		W2FormStep1.selectState(propConnection.getProperty("W2YourState"));
		W2FormStep2 = W2FormStep1.pressNEXT();
		W2FormStep2.enterSocial_Security_Number(propConnection.getProperty("W2SSN"));
		W2FormStep2.enterIdentification_Number(propConnection.getProperty("W2EIN"));
		W2FormStep3 = W2FormStep2.pressNEXT();
		W2FormStep3.enterCompanyName(propConnection.getProperty("W2CompanyName"));
		W2FormStep3.enterCompanyAdd(propConnection.getProperty("W2CompanyAdd"));
		W2FormStep3.enterCompanyCity(propConnection.getProperty("W2CompanyCity"));
		W2FormStep3.selectState(propConnection.getProperty("W2State"));
		W2FormStep3.enterCompanyZip(propConnection.getProperty("W2CompanyZip"));
		W2FormStep3.enterControlNumber(propConnection.getProperty("W2ControlNumber"));
		W2FormStep4 = W2FormStep3.pressNEXT();
		W2FormStep4.enterEmpName(propConnection.getProperty("W2EmpName"));
		W2FormStep4.enterEmpAdd(propConnection.getProperty("W2EmpAdd"));
		W2FormStep4.enterEmpCity(propConnection.getProperty("W2EmpCity"));
		W2FormStep4.selectState(propConnection.getProperty("W2EmpState"));
		W2FormStep4.enterEmpZip(propConnection.getProperty("W2EmpZip"));
		W2FormStep5 = W2FormStep4.pressNEXT();

		W2FormStep5.enterWagesTipsOtherCompensation(propConnection.getProperty("W2WagesTipsOtherCompensation"));
		W2FormStep5.enterFederalIncomeTax(propConnection.getProperty("W2FederalIncomeTaxWithheld"));
		W2FormStep5.enterSocialSecurityWages(propConnection.getProperty("W2SocialSecurityWages"));
		W2FormStep5.enterSocialSecurityTaxWithheld(propConnection.getProperty("W2SocialSecurityTaxWithheld"));
		W2FormStep5.enterMedicareWagesAndTips(propConnection.getProperty("W2MedicareWagesAndTips"));
		W2FormStep5.enterMedicareTaxWithheld(propConnection.getProperty("W2MedicareTaxWithheld"));
		W2FormStep5.enterSocialSecurityTips(propConnection.getProperty("W2SocialSecurityTips"));
		W2FormStep5.enterAllocatedTips(propConnection.getProperty("W2AllocatedTips"));
		W2FormStep5.enterDependentCareBenefits(propConnection.getProperty("W2DependentCareBenefits"));
		W2FormStep5.enterNonqualifiedPlans(propConnection.getProperty("W2NonqualifiedPlans"));
		W2FormStep5.enter12a(propConnection.getProperty("W212a"));
		W2FormStep5.enter12b(propConnection.getProperty("W212b"));
		W2FormStep5.enter12c(propConnection.getProperty("W212c"));
		W2FormStep5.enter12d(propConnection.getProperty("W212d"));
		W2FormStep5.enter14Others(propConnection.getProperty("W2Others"));
		W2FormStep5.tickCheckBoxStatutoryEmployee();
		W2FormStep5.tickCheckBoxRetirementPlan();
		W2FormStep5.tickCheckBoxThirdPartySickPay();
		W2FormStep6 = W2FormStep5.pressNEXT();
		W2FormStep6.enterEmpStateID(propConnection.getProperty("W2EmpStateID"));
		W2FormStep6.enterStateWagesTips(propConnection.getProperty("W2StateWagesTips"));
		W2FormStep6.enterStateincomeTax(propConnection.getProperty("W2StateincomeTax"));
		W2FormStep6.enterLocalWagesTips(propConnection.getProperty("W2LocalWagesTips"));
		W2FormStep6.enterLocalIncomeTax(propConnection.getProperty("W2LocalIncomeTax"));
		W2FormStep6.enterLocalityName(propConnection.getProperty("W2LocalityName"));
		softAssertion1.assertAll();
	}

	@Test(priority=3)
	public void W2Form_verifyOrderPage() {
		SoftAssert softAssertion3 = new SoftAssert();
		// orderp = W2FormStep6.pressCheckoutButton();
		//commonformElements = new CommonFormElements(driver);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		orderp = W2FormStep6.pressCheckoutButton();
		
		softAssertion3.assertEquals(orderp.getDateOfOrderPlaced(),orderp.gettodaysdate(),"Date is not correct in order page");

		softAssertion3.assertEquals(orderp.getBillType(), "W2 Form","Bill Type is not correct");

		softAssertion3.assertEquals(orderp.getAmountValue(), "$ 15.99","Amount not correct");

		softAssertion3.assertEquals(orderp.getTotalAmount(), "$ 15.99","Total Amount before applying coupon is not correct");
		
		softAssertion3.assertAll();
	}
	
	@Test(priority=4)
	public void W2Form_verifyCouponCodeFunctionalityWithValidCode() {
		SoftAssert softAssertion4 = new SoftAssert();
		
		orderp.enterCoupenCode(propConnection.getProperty("CouponCode"));
		nos_calls = orderp.pressApplyCouponButton();
		
		softAssertion4.assertEquals(orderp.getTotalAmount(), " $ 0.0", "Coupon not applied");

		nos_calls += 1;
		softAssertion4.assertEquals(orderp.getTextOnCheckoutPayButton(),"Complete Checkout","Text on checkout button does not change after applying free coupen");
		softAssertion4.assertAll();
	}
	
	@Test(priority=5)
	public void W2Form_verifyThankyouPageAfterFreeCoupen()
	{
		SoftAssert softAssertion5 = new SoftAssert();
		thankyoupage = orderp.pressPressCompleteCheckout();
		
		//softAssertion3.assertNotEquals(thankyoupage.getThankYouPage(), null, "Thank you page does not appear");
		if(thankyoupage.getThankYouPage().equals(null))
		{
			softAssertion5.assertTrue(false, "Thank you page does not appear");
		}
		softAssertion5.assertTrue(true);
		softAssertion5.assertAll();
	}

	@Test(priority=2)
	public void W2Form_verifyPreviewData() {
		SoftAssert softAssertion2 = new SoftAssert();
		W2PreviewPage = W2FormStep6.pressPREVIEW();
		WebWait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//android.widget.Image[@text='draft-watermark']")));

		// Verify Employee Social Security number
		String EmpSocialSecurityNumber = W2PreviewPage.getEmpSocialSecurityNumber();
		softAssertion2.assertEquals(EmpSocialSecurityNumber, propConnection.getProperty("W2SSN"),
				"Wrong employee Social Security number");

		// Verify employee Identification number
		String EmpIdentificationNumber = W2PreviewPage.getEmpIdentificationNumber();
		softAssertion2.assertEquals(EmpIdentificationNumber, propConnection.getProperty("W2EIN"),
				"Wrong employee Identification number");

		// Verify Wages,tips, other compensation
		String WagesTipsOtherCompensation = W2PreviewPage.getvalueof("Wages,tips, other compensation");
		System.out.println(WagesTipsOtherCompensation);
		softAssertion2.assertEquals(WagesTipsOtherCompensation,
				propConnection.getProperty("W2WagesTipsOtherCompensation"), "Wrong Wages Tips Other Compensation");

		// Verify Social Security Wages
		String SocialSecurityWages = W2PreviewPage.getvalueof("Social Security Wages");
		System.out.println(SocialSecurityWages);
		softAssertion2.assertEquals(SocialSecurityWages, propConnection.getProperty("W2SocialSecurityWages"),
				"Wrong Value of Social Security Wages");

		// Verify Medicare Wages and tips
		String MedicareWagesTips = W2PreviewPage.getvalueof("Medicare Wages and tips");
		System.out.println(MedicareWagesTips);
		softAssertion2.assertEquals(MedicareWagesTips, propConnection.getProperty("W2MedicareWagesAndTips"),
				"Wrong Value of Medicare Wages and tips");

		// Verify Social Security tips
		String SocialSecurityTips = W2PreviewPage.getvalueof("Social Security tips");
		System.out.println(SocialSecurityTips);
		softAssertion2.assertEquals(SocialSecurityTips, propConnection.getProperty("W2SocialSecurityTips"),
				"Wrong Value of Social Security tips");

		// Verify Nonqualified Plans
		String NonqualifiedPlans = W2PreviewPage.getvalueof("Nonqualified Plans");
		System.out.println(NonqualifiedPlans);
		softAssertion2.assertEquals(NonqualifiedPlans, propConnection.getProperty("W2NonqualifiedPlans"),
				"Wrong Value of Nonqualified Plans");

		// Verify Others
		String Others = W2PreviewPage.getvalueof("Others");
		System.out.println(Others);
		softAssertion2.assertEquals(Others, propConnection.getProperty("W2Others"), "Wrong Value of Others");

		// Verify Statutory employee checkbox
		String Statuatoryemp = W2PreviewPage.getCheckboxStatusfor("Statutory employee");
		System.out.println(Statuatoryemp);
		softAssertion2.assertEquals(Statuatoryemp, "checked", "Statutory employee checkbox issue ");

		// Verify Retirement plan checkbox
		String RetirementPlan = W2PreviewPage.getCheckboxStatusfor("Retirement plan");
		System.out.println(RetirementPlan);
		softAssertion2.assertEquals(RetirementPlan, "checked", "Retirement plan checkbox issue ");

		// Verify Third-party sick pay checkbox
		String ThirdPartySickPay = W2PreviewPage.getCheckboxStatusfor("Third-party sick pay");
		System.out.println(ThirdPartySickPay);
		softAssertion2.assertEquals(ThirdPartySickPay, "checked", "Third-party sick pay checkbox issue ");

		// Verify Company Name
		String EmployerCompanyName = W2PreviewPage.getEmployerCompanyName();
		System.out.println(EmployerCompanyName);
		if (EmployerCompanyName.equalsIgnoreCase(propConnection.getProperty("W2CompanyName"))) {
			softAssertion2.assertTrue(true);
		} else {
			softAssertion2.assertTrue(false, "Company name is not correct");
		}

		// Verify Company address
		String EmployerCompanyAddress = W2PreviewPage.getEmployerCompanyAddress();
		System.out.println(EmployerCompanyAddress);
		if (EmployerCompanyAddress.equalsIgnoreCase(propConnection.getProperty("W2CompanyAdd"))) {
			softAssertion2.assertTrue(true);
		} else {
			softAssertion2.assertTrue(false, "Company Address is not correct");
		}

		// Verify Company city state and zip
		String EmployerCompanyZipAndCityAndState = W2PreviewPage.getEmployerCompanyZipAndCityAndState();
		System.out.println(EmployerCompanyZipAndCityAndState);
		String shortstate = W2PreviewPage.getShortCutOfState(propConnection.getProperty("W2State"));
		System.out.println(shortstate);
		String CompanyCityStateZip = propConnection.getProperty("W2CompanyCity") + ", " + shortstate + " "
				+ propConnection.getProperty("W2CompanyZip");
		System.out.println("Companycity,Shortstate and zip:" + CompanyCityStateZip);
		if (EmployerCompanyZipAndCityAndState.equalsIgnoreCase(CompanyCityStateZip)) {
			softAssertion2.assertTrue(true);
		} else {
			softAssertion2.assertTrue(false, "Company City,State,Zip is not correct");
		}

		// Verify control Number
		softAssertion2.assertEquals(W2PreviewPage.getControlNumber(), propConnection.getProperty("W2ControlNumber"),
				"Control number is not correct");

		// Verify state at bottom left
		softAssertion2.assertEquals(W2PreviewPage.getState(),
				W2PreviewPage.getShortCutOfState(propConnection.getProperty("W2YourState")),
				"State at corner is not correct");

		// Verify Employee name
		softAssertion2.assertEquals(W2PreviewPage.getEmployeeName(), propConnection.getProperty("W2EmpName"),
				"Employee name is not mentioned or correct.");
		// Verify Employee address
		softAssertion2.assertEquals(W2PreviewPage.getEmployeeAddress(), propConnection.getProperty("W2EmpAdd"),
				"Employee Address is not mentioned or correct.");
		// Verify Employee city state and zip
		String EmployeeZipAndCityAndState = W2PreviewPage.getEmployeeZipAndCityAndState();
		System.out.println(EmployeeZipAndCityAndState);
		String shortempstate = W2PreviewPage.getShortCutOfState(propConnection.getProperty("W2EmpState"));
		System.out.println(shortempstate);
		String EmployeeCityStateZip = propConnection.getProperty("W2EmpCity") + ", " + shortempstate + " "
				+ propConnection.getProperty("W2EmpZip");
		System.out.println("Employee city,Shortstate and zip:" + EmployeeCityStateZip);
		if (EmployeeZipAndCityAndState.equalsIgnoreCase(EmployeeCityStateZip)) {
			softAssertion2.assertTrue(true);
		} else {
			softAssertion2.assertTrue(false, "Employee City, State, Zip is not correct");
		}

		// Verify Federal income tax withheld
		softAssertion2.assertEquals(W2PreviewPage.getFederalIncomeTaxWithheld(),
				propConnection.getProperty("W2FederalIncomeTaxWithheld"),
				"Federal income tax withheld mentioned not correct.");

		// Verify Social security tax withheld
		softAssertion2.assertEquals(W2PreviewPage.getSocialSecurityTaxWithheld(),
				propConnection.getProperty("W2SocialSecurityTaxWithheld"),
				"Social security tax withheld mentioned not correct.");

		// Verify Medicare tax withheld
		softAssertion2.assertEquals(W2PreviewPage.getMedicareTaxWithheld(),
				propConnection.getProperty("W2MedicareTaxWithheld"), "Medicare tax withheld mentioned not correct.");

		// Verify Allocated tips
		softAssertion2.assertEquals(W2PreviewPage.getAllocatedTips(), propConnection.getProperty("W2AllocatedTips"),
				"Allocated tips mentioned not correct.");

		// Verify Dependent care benifits
		softAssertion2.assertEquals(W2PreviewPage.getDependentCareBenefits(),
				propConnection.getProperty("W2DependentCareBenefits"),
				"Dependent care benifits mentioned not correct.");

		// Verify 12a value
		softAssertion2.assertEquals(W2PreviewPage.get12a(), propConnection.getProperty("W212a"),
				"12a value mentioned not correct.");
		// Verify 12b value
		softAssertion2.assertEquals(W2PreviewPage.get12b(), propConnection.getProperty("W212b"),
				"12a value mentioned not correct.");
		// Verify 12c value
		softAssertion2.assertEquals(W2PreviewPage.get12c(), propConnection.getProperty("W212c"),
				"12a value mentioned not correct.");
		// Verify 12d value
		softAssertion2.assertEquals(W2PreviewPage.get12d(), propConnection.getProperty("W212d"),
				"12a value mentioned not correct.");

		// Verify Employee state ID number
		softAssertion2.assertEquals(W2PreviewPage.getEmployerStateIDNumber(),
				propConnection.getProperty("W2EmpStateID"), "Employee state ID number value mentioned not correct.");
		// Verify 16 State,Wages,Tips etc
		softAssertion2.assertEquals(W2PreviewPage.getStateWagesTipsEtc(),
				propConnection.getProperty("W2StateWagesTips"),
				"16 State,Wages,Tips etc number value mentioned not correct.");
		// Verify 17 State Income Tax
		softAssertion2.assertEquals(W2PreviewPage.getStateIncomeTax(), propConnection.getProperty("W2StateincomeTax"),
				"17 State Income Tax value mentioned not correct.");

		// Verify 18 Local wages tips etc
		softAssertion2.assertEquals(W2PreviewPage.getLocalWagesTipsEtc(),
				propConnection.getProperty("W2LocalWagesTips"), "18 Local wages tips etc value mentioned not correct.");

		// Verify Local Income Tax
		softAssertion2.assertEquals(W2PreviewPage.getLocalIncomeTax(), propConnection.getProperty("W2LocalIncomeTax"),
				"Local Income Tax value mentioned not correct.");

		// Verify Locality Name
		softAssertion2.assertEquals(W2PreviewPage.getLocalityName(), propConnection.getProperty("W2LocalityName"),
				"20 Locality Name value mentioned not correct.");

		// Verify Year
		softAssertion2.assertEquals(W2PreviewPage.getYearAtbottom(), propConnection.getProperty("W2WhatYear"),
				"Year mentioned on preview page is not correct.");
		
		softAssertion2.assertAll();
		
		
	}

}
