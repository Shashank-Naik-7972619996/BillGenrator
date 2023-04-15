package mobileApp.BillGenrator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MISC_1099 extends BaseClass {

	@BeforeClass
	@org.testng.annotations.Parameters({"deviceName", "platformVersion", "udid"})
	public void beforeeverymethodinsameclass(String deviceName, String platformVersion, String udid) throws IOException {
		ConfigurAndroid(deviceName, platformVersion, udid);
	}
	
	@Test(priority=1)
	public void MISC_1099_addAllValuesInMiscForm() throws Exception {
		SoftAssert softAssertion = new SoftAssert();
		try {
			dashboard = flashscreen.pressGetStarted();
			LoginWithValidCred();
			SideNevigationMenu = dashboard.pressRigtSideNevigationMenu();
			MiscFormStep1 = SideNevigationMenu.ClickMisc1099();
			MiscFormStep1.checkCorrected();
			MiscFormStep1.selectWhatYear(propConnection.getProperty("MISCWhatYear"));
			MiscFormStep2 = MiscFormStep1.pressNEXT();
			MiscFormStep2.enterPayerCompanyName(propConnection.getProperty("MISCCompanyName"));
			MiscFormStep2.enterPayerAddress(propConnection.getProperty("MISCPayerAddress"));
			MiscFormStep2.enterPayerCity(propConnection.getProperty("MISCPayersCity"));
			MiscFormStep2.selectState(propConnection.getProperty("MISCPayersState"));
			MiscFormStep2.enterPayerZipCode(propConnection.getProperty("MISCPayersZipCode"));
			MiscFormStep3 = MiscFormStep2.pressNEXT();
			MiscFormStep3.enterPayersTin(propConnection.getProperty("MISCPayersTin"));
			MiscFormStep3.enterRecipientsTin(propConnection.getProperty("MISCRecipientsTin"));
			MiscFormStep4 = MiscFormStep3.pressNEXT();
			MiscFormStep4.enterRecipientsName(propConnection.getProperty("MISCRecName"));
			MiscFormStep4.enterRecAddress(propConnection.getProperty("MISCRecAddress"));
			MiscFormStep4.enterRecCity(propConnection.getProperty("MISCRecCity"));
			MiscFormStep4.selectState(propConnection.getProperty("MISCRecState"));
			MiscFormStep4.enterRecZipCode(propConnection.getProperty("MISCRecZipCode"));
			MiscFormStep5 = MiscFormStep4.pressNEXT();
			MiscFormStep5.enterAccountNumber(propConnection.getProperty("MISCAccountNumber"));
			MiscFormStep5.markFATCAFillingRequirementCheckbox();
			MiscFormStep5.enterRents(propConnection.getProperty("MISCRents"));
			MiscFormStep5.enterRoyalties(propConnection.getProperty("MISCRoyalties"));
			MiscFormStep5.enterOtherIncome(propConnection.getProperty("MISCOtherIncome"));
			MiscFormStep5.enterFederalIncomeTaxWithheld(propConnection.getProperty("MISCFederalIncomeTaxWithheld"));
			MiscFormStep5.enterFishingBoatProceeds(propConnection.getProperty("MISCFishingBoatProceeds"));
			MiscFormStep5
					.enterMedicalAndHealthCarePayments(propConnection.getProperty("MISCMedicalAndHealthCarePayments"));
			MiscFormStep5.markPayerMadeDirectCheckbox();
			MiscFormStep5.enterSubsitutePayments(
					propConnection.getProperty("MISCSubsitutePaymentsInLieuOfDividendsOrInterest"));
			MiscFormStep5.enterCropInsuranceProceeds(propConnection.getProperty("MISCCropInsuranceProceeds"));
			MiscFormStep5.enterGrossProceedsPaidToAnAttorney(
					propConnection.getProperty("MISCGrossProceedsPaidToAnAttorney"));
			MiscFormStep5.enterExtra(propConnection.getProperty("MISCExtra"));
			MiscFormStep6 = MiscFormStep5.pressNEXT();
			MiscFormStep6.enterSection409ADeferrals(propConnection.getProperty("MISCSection409ADeferrals"));
			MiscFormStep6.enterExcessGoldenParachutePayments(
					propConnection.getProperty("MISCExcessGoldenParachutePayments"));
			MiscFormStep6.enterNonqualifiedDeferredCompensation(
					propConnection.getProperty("MISCNonqualifiedDeferredCompensation"));
			MiscFormStep6.enterStateTaxWithheld(propConnection.getProperty("MISCStateTaxWithheld"));
			MiscFormStep6.enterStateTaxWithHeld2(propConnection.getProperty("MISCStateTaxWithheld2"));
			MiscFormStep6.enterStatePayerStateNo(propConnection.getProperty("MISCStatePayersStateNo"));
			MiscFormStep6.enterStatePayerStateNo2(propConnection.getProperty("MISCStatePayersStateNo2"));
			MiscFormStep6.enterStateIncome(propConnection.getProperty("MISCStateIncome"));
			MiscFormStep6.enterStateIncome2(propConnection.getProperty("MISCStateIncome2"));
			MiscFormStep6.pressTemplateOptions();
			MiscFormStep6.pressSaveTemplate();
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			softAssertion.assertTrue(false, "Element not found");
		}
	}

	@Test(priority=2)
	public void MISC_1099_VerifyPreviewPage() throws Exception {
		SoftAssert softAssertion1 = new SoftAssert();
		Misc1099Preview = MiscFormStep6.pressPreview();
		// Verify Corrected checkbox
		softAssertion1.assertTrue(Misc1099Preview.getStatusOfCorrectedCheckbox(),
				"Corrected checkbox is not marked in preview page.");

		// Verify Company Name
		softAssertion1.assertTrue(
				Misc1099Preview.getPayersCompanyName().equalsIgnoreCase(propConnection.getProperty("MISCCompanyName")),
				"Company Name is not correct");
		// Verify Company Address
		softAssertion1.assertTrue(Misc1099Preview.getPayersCompanyAddress()
				.equalsIgnoreCase(propConnection.getProperty("MISCPayerAddress")), "Company address is not correct");
		// Verify Company City
		softAssertion1.assertTrue(
				Misc1099Preview.getPayersCompanyCity().equalsIgnoreCase(propConnection.getProperty("MISCPayersCity")),
				"Company City is not correct");
		// Verify company state
		softAssertion1.assertEquals(Misc1099Preview.getPayersCompanyShortState(),
				Misc1099Preview.getShortCutOfState(propConnection.getProperty("MISCPayersState")),
				"Company State is not correct");
		// Verify company Zip
		softAssertion1.assertEquals(Misc1099Preview.getPayersCompanyZip(),
				propConnection.getProperty("MISCPayersZipCode"), "Company Zip is not correct");

		// Verify Payers Tin
		softAssertion1.assertEquals(Misc1099Preview.getPayersTin(), propConnection.getProperty("MISCPayersTin"),
				"Payers Tin is not correct");
		// Verify Recipients Tin
		softAssertion1.assertEquals(Misc1099Preview.getRecipientsTin(), propConnection.getProperty("MISCRecipientsTin"),
				"Recipients Tin is not correct");

		// Verify Recipients Name
		softAssertion1.assertTrue(
				Misc1099Preview.getRecipientsName().equalsIgnoreCase(propConnection.getProperty("MISCRecName")),
				"Recipients Name is not correct");
		// Verify Recipients Address
		softAssertion1.assertTrue(
				Misc1099Preview.getRecipientsAddress().equalsIgnoreCase(propConnection.getProperty("MISCRecAddress")),
				"Recipients Address is not correct");
		// Verify Recipients City
		softAssertion1.assertTrue(
				Misc1099Preview.getRecipientsCity().equalsIgnoreCase(propConnection.getProperty("MISCRecCity")),
				"Recipients City is not correct");
		// Verify Recipients State
		softAssertion1.assertEquals(Misc1099Preview.getRecipientsShortState(),
				Misc1099Preview.getShortCutOfState(propConnection.getProperty("MISCRecState")),
				"Recipients State is not correct");
		// Verify Recipients Zip
		softAssertion1.assertEquals(Misc1099Preview.getRecipientsZip(), propConnection.getProperty("MISCRecZipCode"),
				"Rec Zip Code is not correct");

		// Verify Account Number
		softAssertion1.assertEquals(Misc1099Preview.getAccountNo(), propConnection.getProperty("MISCAccountNumber"),
				"Account number is not correct");
		// Verify Fitca filling req is checked
		softAssertion1.assertEquals(Misc1099Preview.getFATCAFillingRequirementStatus(), true,
				"Fitca filling req is not checked.");

		// Verify Rent
		softAssertion1.assertEquals(Misc1099Preview.getRents(), propConnection.getProperty("MISCRents"),
				"Rents value is not correct.");
		// Verify Royalties
		softAssertion1.assertEquals(Misc1099Preview.getRoyalties(), propConnection.getProperty("MISCRoyalties"),
				"Royalties value is not correct.");
		// Verify Other Income
		softAssertion1.assertEquals(Misc1099Preview.getOtherIncome(), propConnection.getProperty("MISCOtherIncome"),
				"OtherIncome value is not correct.");
		// Verify FederalIncomeTaxWithheld
		softAssertion1.assertEquals(Misc1099Preview.getFederalIncomeTaxWithheld(),
				propConnection.getProperty("MISCFederalIncomeTaxWithheld"),
				"FederalIncomeTaxWithheld value is not correct.");
		// Verify FishingBoatProceeds
		softAssertion1.assertEquals(Misc1099Preview.getFishingBoatProceeds(),
				propConnection.getProperty("MISCFishingBoatProceeds"), "FishingBoatProceeds value is not correct.");
		// Verify MedicalAndHealthCarePayments
		softAssertion1.assertEquals(Misc1099Preview.getMedicalAndHealthCarePayments(),
				propConnection.getProperty("MISCMedicalAndHealthCarePayments"),
				"FishingBoatProceeds value is not correct.");
		// Verify FishingBoatProceeds
		softAssertion1.assertEquals(Misc1099Preview.verifyPayerMadeStatus(), true,
				"PayerMadeDirectCheckbox is not checked.");
		// Verify SubsitutePaymentsInLieuOfDividendsOrInterest value
		softAssertion1.assertEquals(Misc1099Preview.getSubsitutePayments(),
				propConnection.getProperty("MISCSubsitutePaymentsInLieuOfDividendsOrInterest"),
				"SubsitutePaymentsInLieuOfDividendsOrInterest value is not correct.");
		// Verify MISCCropInsuranceProceeds value
		softAssertion1.assertEquals(Misc1099Preview.getCropInsuranceProceeds(),
				propConnection.getProperty("MISCCropInsuranceProceeds"), "CropInsuranceProceeds value is not correct.");
		// Verify GrossProceedsPaidToAnAttorney value
		softAssertion1.assertEquals(Misc1099Preview.getGrossProceeds(),
				propConnection.getProperty("MISCGrossProceedsPaidToAnAttorney"),
				"GrossProceedsPaidToAnAttorney value is not correct.");
		// Verify Extra value
		softAssertion1.assertEquals(Misc1099Preview.getValueOf11(), propConnection.getProperty("MISCExtra"),
				"Extra value is not correct.");
		// Verify Section409ADeferrals value
		softAssertion1.assertEquals(Misc1099Preview.getSection409ADeferrals(),
				propConnection.getProperty("MISCSection409ADeferrals"), "Section409ADeferrals value is not correct.");
		// Verify ExcessGoldenParachutePayments value
		softAssertion1.assertEquals(Misc1099Preview.getValueOfExcessGolden(),
				propConnection.getProperty("MISCExcessGoldenParachutePayments"),
				"ExcessGoldenParachutePayments value is not correct.");
		// Verify MISCNonqualifiedDeferredCompensation value
		softAssertion1.assertEquals(Misc1099Preview.getNonqualifiedDeferredCompensation(),
				propConnection.getProperty("MISCNonqualifiedDeferredCompensation"),
				"NonqualifiedDeferredCompensation value is not correct.");
		// Verify MISCStateTaxWithheld value
		softAssertion1.assertEquals(Misc1099Preview.getValueOfStateTaxWithheld1(),
				propConnection.getProperty("MISCStateTaxWithheld"), "StateTaxWithheld1 value is not correct.");
		// Verify MISCStateTaxWithheld2 value
		softAssertion1.assertEquals(Misc1099Preview.getValueOfStateTaxWithheld2(),
				propConnection.getProperty("MISCStateTaxWithheld2"), "StateTaxWithheld2 value is not correct.");
		// Verify MISCStatePayersStateNo value
		softAssertion1.assertEquals(Misc1099Preview.getValueOfStateNo1(),
				propConnection.getProperty("MISCStatePayersStateNo"), "StatePayersStateNo1 value is not correct.");
		// Verify MISCStatePayersStateNo2 value
		softAssertion1.assertEquals(Misc1099Preview.getValueOfStateNo2(),
				propConnection.getProperty("MISCStatePayersStateNo2"), "StatePayersStateNo2 value is not correct.");
		// Verify MISCStateIncome value
		softAssertion1.assertEquals(Misc1099Preview.getValueOfStateIncome1(),
				propConnection.getProperty("MISCStateIncome"), "StateIncome1 value is not correct.");
		// Verify MISCStateIncome2 value
		softAssertion1.assertEquals(Misc1099Preview.getValueOfStateIncome2(),
				propConnection.getProperty("MISCStateIncome2"), "StateIncome2 value is not correct.");
		// Verify year of misc
		softAssertion1.assertEquals(Misc1099Preview.getYearOfMiscSelected(), propConnection.getProperty("MISCWhatYear"),
				"Year value is not correct.");
		softAssertion1.assertAll();
		
		//MiscFormStep6 = Misc1099Preview.pressBackOnPreviewPage();
	}

	@Test(priority=4)
	public void MISC_1099_verifyMISCOrderPage() {
		//driver.pressKey(new KeyEvent(AndroidKey.BACK));
		orderp = MiscFormStep6.pressCheckout();
		SoftAssert softAssertion3 = new SoftAssert();

		// Verify order placed date
		softAssertion3.assertEquals(orderp.getDateOfOrderPlaced(), orderp.gettodaysdate(),
				"Date is not correct in order page");

		softAssertion3.assertEquals(orderp.getBillType(), "MISC 1099", "Bill Type is not correct");

		softAssertion3.assertEquals(orderp.getShippingAmount(), "$ 0.00",
				"Shipping Amount before applying coupon is not correct");

		softAssertion3.assertEquals(orderp.getAmountValue(), "$ 15.99", "Amount not correct");

		softAssertion3.assertEquals(orderp.getTotalAmount(), "$ 15.99",
				"Total Amount before applying coupon is not correct");

		softAssertion3.assertAll();
	}

	@Test(priority=5)
	public void MISC_1099_verifyCouponCodeFunctionalityWithValidCode() {
		SoftAssert softAssertion4 = new SoftAssert();

		orderp.enterCoupenCode(propConnection.getProperty("CouponCode"));
		nos_calls = orderp.pressApplyCouponButton();
		softAssertion4.assertEquals(orderp.getTotalAmount(), " $ 0.0", "Coupon not applied");

		softAssertion4.assertEquals(orderp.getTextOnCheckoutPayButton(), "Complete Checkout",
				"Text on checkout button does not change after applying free coupen");
		nos_calls += 1;
		softAssertion4.assertAll();
	}

	@Test(priority=6)
	public void MISC_1099_verifyThankYouPage() {
		{
			SoftAssert softAssertion5 = new SoftAssert();
			thankyoupage = orderp.pressPressCompleteCheckout();

			// softAssertion3.assertNotEquals(thankyoupage.getThankYouPage(), null, "Thank
			// you page does not appear");
			if (thankyoupage.getThankYouPage().equals(null)) {
				softAssertion5.assertTrue(false, "Thank you page does not appear");
			}
			softAssertion5.assertTrue(true);
			softAssertion5.assertAll();
		}
	}

	@Test(priority=3)
	public void MISC_1099_verifyAllValuesAfterLoadedFromTemplate() throws Exception {
		SoftAssert softAssertion2 = new SoftAssert();
		restartapp();
		dashboard = flashscreen.pressGetStarted();
		LoginWithValidCred();
		SideNevigationMenu = dashboard.pressRigtSideNevigationMenu();
		MiscFormStep1 = SideNevigationMenu.ClickMisc1099();

		MiscFormStep1.pressTemplateOptions();
		commonformElements = MiscFormStep1.pressLoadTemplate();
		commonformElements.selectLetestBillNumber();
		// Verify Corrected checkbox
		softAssertion2.assertTrue(MiscFormStep1.verifyCorrectedIsChecked(),
				"Corrected checkbox is not marked after loading template.");
		// Verify what year
		softAssertion2.assertEquals(MiscFormStep1.getWhatYear(), propConnection.getProperty("MISCWhatYear"),
				"Year selected is not same after loading template.");
		MiscFormStep2 = MiscFormStep1.pressNEXT();
		// Verify Company Name
		softAssertion2.assertEquals(MiscFormStep2.getPayerCompanyName(), propConnection.getProperty("MISCCompanyName"),
				"Company name is not added or same after loading template.");
		// Verify company address
		softAssertion2.assertEquals(MiscFormStep2.getPayerAddress(), propConnection.getProperty("MISCPayerAddress"),
				"Company address is not added or same after loading template.");
		// Verify Company City
		softAssertion2.assertEquals(MiscFormStep2.getPayerCity(), propConnection.getProperty("MISCPayersCity"),
				"Company City is not added or same after loading template.");
		// Verify Company state
		softAssertion2.assertEquals(MiscFormStep2.getPayerState(), propConnection.getProperty("MISCPayersState"),
				"Company State is not added or same after loading template.");
		// Verify company zip code
		softAssertion2.assertEquals(MiscFormStep2.getPayerZipCode(), propConnection.getProperty("MISCPayersZipCode"),
				"Company Zip is not added or same after loading template.");
		MiscFormStep3 = MiscFormStep2.pressNEXT();
		// Verify payers Tin
		softAssertion2.assertEquals(MiscFormStep3.getPayersTin(), propConnection.getProperty("MISCPayersTin"),
				"payers Tin is not added or same after loading template.");
		// Verify RECIPIENT'S TIN
		softAssertion2.assertEquals(MiscFormStep3.getRecipientsTin(), propConnection.getProperty("MISCRecipientsTin"),
				"RECIPIENT'S TIN is not added or same after loading template.");
		MiscFormStep4 = MiscFormStep3.pressNEXT();

		// Verify recipents your name
		softAssertion2.assertEquals(MiscFormStep4.getRecipientsName(), propConnection.getProperty("MISCRecName"),
				"RECIPIENT'S name is not added or same after loading template.");
		// Verify recipents Address
		softAssertion2.assertEquals(MiscFormStep4.getRecipientsAddress(), propConnection.getProperty("MISCRecAddress"),
				"RECIPIENT'S address is not added or same after loading template.");
		// Verify recipents City
		softAssertion2.assertEquals(MiscFormStep4.getRecipientsCity(), propConnection.getProperty("MISCRecCity"),
				"RECIPIENT'S City is not added or same after loading template.");
		// Verify recipents State
		softAssertion2.assertEquals(MiscFormStep4.getRecState(), propConnection.getProperty("MISCRecState"),
				"RECIPIENT'S state is not added or same after loading template.");
		// Verify recipents Zip
		softAssertion2.assertEquals(MiscFormStep4.getRecZipCode(), propConnection.getProperty("MISCRecZipCode"),
				"RECIPIENT'S Zip is not added or same after loading template.");
		MiscFormStep5 = MiscFormStep4.pressNEXT();

		// Verify Account number
		softAssertion2.assertEquals(MiscFormStep5.getAccountNumber(), propConnection.getProperty("MISCAccountNumber"),
				"RECIPIENT'S Zip is not added or same after loading template.");
		// Verify FATCA filling requirement status
		softAssertion2.assertEquals(MiscFormStep5.verifyFATCAfillingrequirementStatus(), true,
				"FATCA filling requirement status is invalid after loading template.");
		// Verify Rents status
		softAssertion2.assertEquals(MiscFormStep5.getRents(), propConnection.getProperty("MISCRents"),
				"Rents is not added or same after loading template.");
		// Verify Royalties
		softAssertion2.assertEquals(MiscFormStep5.getRoyalties(), propConnection.getProperty("MISCRoyalties"),
				"Royalties is not added or same after loading template.");
		// Verify Other Income
		softAssertion2.assertEquals(MiscFormStep5.getOtherIncome(), propConnection.getProperty("MISCOtherIncome"),
				"Other Income is not added or same after loading template.");
		// Verify Federal Income tax withheld
		softAssertion2.assertEquals(MiscFormStep5.getFederalIncomeTaxWithheld(),
				propConnection.getProperty("MISCFederalIncomeTaxWithheld"),
				"Federal Income tax withheld is not added or same after loading template.");
		// Verify Fishing boat proceeds
		softAssertion2.assertEquals(MiscFormStep5.getFishingBoatProceeds(),
				propConnection.getProperty("MISCFishingBoatProceeds"),
				"Fishing boat proceeds is not added or same after loading template.");
		// Verify Medical and health care payments
		softAssertion2.assertEquals(MiscFormStep5.getMedicalAndHealthCarePayments(),
				propConnection.getProperty("MISCMedicalAndHealthCarePayments"),
				"Medical and health care payments is not added or same after loading template.");
		// Verify Payer made direct sales
		softAssertion2.assertEquals(MiscFormStep5.getPayerMadeDirectCheckboxStatus(), true,
				"Payer made direct sales is not added or same after loading template.");
		// Verify Subsitute payments in lieu of dividends or interest
		softAssertion2.assertEquals(MiscFormStep5.getSubsitutePayments(),
				propConnection.getProperty("MISCSubsitutePaymentsInLieuOfDividendsOrInterest"),
				"Subsitute payments in lieu of dividends or interest is not added or same after loading template.");
		// Verify Crop insurance proceeds
		softAssertion2.assertEquals(MiscFormStep5.getCropInsuranceProceeds(),
				propConnection.getProperty("MISCCropInsuranceProceeds"),
				"Crop insurance proceeds is not added or same after loading template.");
		// Verify Gross proceeds paid to an attorney
		softAssertion2.assertEquals(MiscFormStep5.getGrossProceedsPaidToAnAttorney(),
				propConnection.getProperty("MISCGrossProceedsPaidToAnAttorney"),
				"Gross proceeds paid to an attorney is not added or same after loading template.");
		// Verify Extra
		softAssertion2.assertEquals(MiscFormStep5.getExtra(), propConnection.getProperty("MISCExtra"),
				"Extra is not added or same after loading template.");
		MiscFormStep6 = MiscFormStep5.pressNEXT();

		// Verify Section 409A deferrals
		softAssertion2.assertEquals(MiscFormStep6.getSection409ADeferrals(),
				propConnection.getProperty("MISCSection409ADeferrals"),
				"Section409ADeferrals is not added or same after loading template.");
		// Verify Excess golden parachute payments
		softAssertion2.assertEquals(MiscFormStep6.getExcessGoldenParachutePayments(),
				propConnection.getProperty("MISCExcessGoldenParachutePayments"),
				"Excess golden parachute payments is not added or same after loading template.");
		// Verify Nonqualified deferred compensation
		softAssertion2.assertEquals(MiscFormStep6.getNonqualifiedDeferredCompensation(),
				propConnection.getProperty("MISCNonqualifiedDeferredCompensation"),
				"Nonqualified deferred compensation is not added or same after loading template.");
		// Verify State tax withheld
		softAssertion2.assertEquals(MiscFormStep6.getStateTaxWithheld(),
				propConnection.getProperty("MISCStateTaxWithheld"),
				"State tax withheld deferred compensation is not added or same after loading template.");
		// Verify State tax withheld-2
		softAssertion2.assertEquals(MiscFormStep6.getStateTaxWithHeld2(),
				propConnection.getProperty("MISCStateTaxWithheld2"),
				"State tax withheld deferred compensation is not added or same after loading template.");
		// Verify State/Payer’s state no.
		softAssertion2.assertEquals(MiscFormStep6.getStatePayerStateNo(),
				propConnection.getProperty("MISCStatePayersStateNo"),
				"State/Payer’s state no. is not added or same after loading template.");
		// Verify State/Payer’s state no. -2
		softAssertion2.assertEquals(MiscFormStep6.getStatePayerStateNo2(),
				propConnection.getProperty("MISCStatePayersStateNo2"),
				"State/Payer’s state no. -2 is not added or same after loading template.");

		// Verify State income
		softAssertion2.assertEquals(MiscFormStep6.getStateIncome(), propConnection.getProperty("MISCStateIncome"),
				"State income 1 is not added or same after loading template.");

		// Verify State income 2
		softAssertion2.assertEquals(MiscFormStep6.getStateIncome2(), propConnection.getProperty("MISCStateIncome2"),
				"State income 2 is not added or same after loading template.");

		softAssertion2.assertAll();
	}

	@Test(priority=7)
	public void MISC_1099_verifyContentInDownloadedPDf() throws IOException, ParseException, InterruptedException {
		configureBrowser(/*"Chrome"*/);
		SoftAssert soft = new SoftAssert();
		String GateDate = null;
		boolean filefound = false;
		thankyoupage.pressDownloadButton();

		while (filefound == false) {
			if (filefound == false && getCountOfFilePulled() == 0) {
				GateDate = getcurrentMM_dd_yyyy_HH_mm_ss();
				
				System.out.println("The File name that needs to pull without plus minus seconds: MISC 1099_" + GateDate);
				Thread.sleep(3000l);
				filefound = pullFileFromDevice("MISC 1099", "MISC 1099_" + GateDate);
			}
			if (filefound == false && getCountOfFilePulled() == 1) {
				GateDate = getcurrentMM_dd_yyyy_HH_mm_ssMinusOneSec();
				
				System.out.println("The File name that needs to pull with minus seconds: MISC 1099_" + GateDate);
				Thread.sleep(3000l);
				filefound = pullFileFromDevice("MISC 1099", "MISC 1099_" + GateDate);
			}
			if (filefound == false && getCountOfFilePulled() == 2) {
				GateDate = getcurrentMM_dd_yyyy_HH_mm_ssPlusOneSec();
		
				System.out.println("The File name that needs to pull with plus seconds: MISC 1099_" + GateDate);
				Thread.sleep(3000l);
				pullFileFromDevice("MISC 1099", "MISC 1099_" + GateDate);
			}
			browserdriver.get(url);
			filefound = true;
			try {
				String pdfContent = readPdfContent(url);
				System.out.println("pdf data:\n" + pdfContent);
				soft.assertTrue(pdfContent.contentEquals(" CORRECTED (if checked)\r\n"
						+ "PAYER\\'S name, street address, city or town, state or province,\r\n"
						+ "country, ZIP or foreign postal code, and telephone no.\r\nTEST COMPANY NAME\r\n"
						+ "TEST PAYERS ADDRESS FOR TESTING PURPOSE ONLY\r\n20333, PUNE\r\n"
						+ "TEST PAYERSCITY, HI 65423\r\n1 Rents\r\n$ 30002.2 \r\n2 Royalties\r\n"
						+ "$ 99000.1 \r\n3 Other income\r\n$ 21456.22 \r\nOMB No. 1545-0115\r\n2017\r\n"
						+ "Form 1099-MISC\r\nMiscellaneous\r\nIncome\r\n4 Federal Income tax\r\n"
						+ "withheld\r\n$ 98745.55 \r\nCopy B\r\nFor Recipient\r\nPAYER\\'S TIN\r\n"
						+ "Payers Tin\r\nRECIPIENT\\'S TIN\r\nRecipientsTin\r\n5 Fishing boat proceeds\r\n"
						+ "$ 89663.55 \r\n6 Medical and health\r\ncare payments\r\n$ 56654.58 \r\n"
						+ "RECIPIENT\\'S name, street address (including apt. no.), city or\r\n"
						+ "town, state or province, country, ZIP or foreign postal code, and\r\ntelephone no.\r\n"
						+ "TEST RECIPIENTS NAME\r\nTEST REC ADDRESS FOR TESING PURPOSE ONLY\r\n"
						+ "REC CITY, ID 12354\r\nAccount number (see instructions)\r\n3214523 \r\n"
						+ "FATCA filling\r\nrequirement  \r\n7 Payer made direct sales\r\n"
						+ "of $5.000 or more of\r\nconsumer products to a\r\nbuyer (recipient) for resale\r\n"
						+ "9 Crop insurance proceeds\r\n$ 84563.22 \r\n11  \r\n 12345.55 \r\n"
						+ "13 Excess golden parachute\r\npayments\r\n$ 64983.99 \r\n"
						+ "8 Subsitute payments in\r\nlieu of dividends or\r\ninterest\r\n$ 98798.45 \r\n"
						+ "10 Gross proceeds paid\r\nto an attorney\r\n$ 56478.44 \r\n"
						+ "12 Section 409A deferrals\r\n$ 32142.23 \r\n14 Nonqualified deferred\r\n"
						+ "compensation\r\n$ 78966.33 \r\nThis is important tax\r\n"
						+ "information and is being\r\nfurnished to the IRS. If\r\nyou are required to file\r\n"
						+ "a return, a negligence\r\npenalty or other\r\nsanction may be\r\n"
						+ "imposed on you if this\r\nincome is taxable and\r\nthe IRS determines that\r\n"
						+ "it has not been\r\nreported.\r\n15 State tax withheld\r\n$ 12333.33 \r\n"
						+ "$ 123.33 \r\n16 State/Payer\\'s state\r\nno.\r\n 98789.33 \r\n 98796.23 \r\n"
						+ "17 State income\r\n$ 2155.33 \r\n$ 9876.33 \r\nForm 1099-MISC\r\n"
						+ "(keep for your records)\r\nwww.irs.gov/Form1099MISC\r\n"
						+ "Department of the Treasury - Internal Revenue Service"),
						"The data is not correct in the pdf");
			} catch (MalformedURLException e) {
				filefound = false;
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				filefound = false;
				e.printStackTrace();
			} catch (WebDriverException e1) {
				// TODO Auto-generated catch block
				filefound = false;
				soft.fail("The file name provided does not exist in the device");
				e1.printStackTrace();
			}
			
		}

		System.out.println("The File name pulled: MISC 1099_" + GateDate);
		soft.assertAll();
	}

}
