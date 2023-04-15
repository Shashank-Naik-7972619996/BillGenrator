package mobileApp.BillGenrator;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import MobileApp.BillGenratorMobileApp2.PageObject.Android.CommonFormElements;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.Dashboard;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.FlashScreen;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.OrderPage;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.UtilityForm.UtilityPreviewPage;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.UtilityForm.UtiltiyFormStep4;
import base.BaseClass;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

// Importing the required classes of Apache POI  

public class UtilityBill extends BaseClass {
	
	@BeforeClass
	@org.testng.annotations.Parameters({"deviceName", "platformVersion", "udid"})
	public void beforeeverymethodinsameclass(String deviceName, String platformVersion, String udid) throws IOException {
		ConfigurAndroid(deviceName, platformVersion, udid);
	}

	@Test(priority = 1)
	public void UtilityForm_VerifyUtilityPreviewWithAllFields() throws InterruptedException, IOException {

		SoftAssert softAssertion1 = new SoftAssert();

		dashboard = flashscreen.pressGetStarted();
		Thread.sleep(4000l);
		loginScreen = dashboard.pressLogin();
		loginScreen.EnterUserEmail(propConnection.getProperty("username"));
		loginScreen.EnterPassword(propConnection.getProperty("pass"));
		loginScreen.pressSignIn();

		if (!dashboard.returnwebelement().isDisplayed()) {
			System.out.println("No Interet access hence skiping the test case");
			throw new SkipException("Skipping this exception");
		}
		SideNevigationMenu = dashboard.pressRigtSideNevigationMenu();

		utilityFormsStep1 = SideNevigationMenu.ClickUtilityBill();
		Thread.sleep(4000l);
		utilityFormsStep1.ClickUtilityLogo();// //Click Utility Logo
		utilityFormsStep1.ClickGallery(); // Click gallery
		utilityFormsStep1.ClickonImage();
		utilityFormsStep1.enterYourName(propConnection.getProperty("YourName"));
		utilityFormsStep1.enterYourStreetAddress(propConnection.getProperty("YourStreetAdd"));
		driver.hideKeyboard();
		utilityFormsStep1.EnterCity(propConnection.getProperty("YourCity"));
		driver.hideKeyboard();
		utilityFormsStep1.EnterZip(propConnection.getProperty("YourZip"));
		utilityFormsStep1.SelectState();// default california is selected
		utilityFormsStep2 = utilityFormsStep1.pressNextButton();
		utilityFormsStep2.enterCompanyName(propConnection.getProperty("CompanyName"));
		utilityFormsStep2.enterCompanyStreetAddress(propConnection.getProperty("CompanyStreetAddress"));
		utilityFormsStep2.enterCompanyCity(propConnection.getProperty("CompanyCity"));
		utilityFormsStep2.selectState();
		utilityFormsStep2.enterCompanyZip(propConnection.getProperty("CompanyZip"));
		utilityFormsStep3 = utilityFormsStep2.pressNextButton();
		utilityFormsStep3.enterStatementDate(propConnection.getProperty("StatementDate"));
		utilityFormsStep3.enterPaymentDueAmount(propConnection.getProperty("PaymentDueAmountString"));
		utilityFormsStep3.enterPreviousStatementAmount(propConnection.getProperty("PreviousStateAmount"));
		UtiltiyFormStep4 = utilityFormsStep3.pressNextButton();
		UtiltiyFormStep4.enterWebsiteURL(propConnection.getProperty("WebsiteURL"));
		CustomerServiceNo = UtiltiyFormStep4.getCustomerServiceNo();

		Utilitypreview = UtiltiyFormStep4.pressPreviewButton(); // Pressing preview button.

		String companynameP = Utilitypreview.getCompanyName();
		System.out.println("Company name: " + companynameP + "\n");
		String URL1P = Utilitypreview.getURL1();
		System.out.println("First URL: " + URL1P + "\n");
		String StatmentDateP = Utilitypreview.getStatementDate();
		System.out.println("Statement Date: " + StatmentDateP + "\n");
		String DueDateP = Utilitypreview.getDueDate();
		System.out.println("Due Date: " + DueDateP + "\n");
		String YourdetailsP = Utilitypreview.getYourAddDetails();
		System.out.println("Your details: " + YourdetailsP + "\n");
		String PreviousState1P = Utilitypreview.getPreviousState1();
		System.out.println("Previous Statement1: " + PreviousState1P + "\n");
		String PreviousState2P = Utilitypreview.getPreviousState2();
		System.out.println("Previous Statement2: " + PreviousState2P + "\n");
		Double DeliverychargammountP = Utilitypreview.getDeliverycharg();
		System.out.println("DeliveryCharge Amount: " + DeliverychargammountP + "\n");
		Double ElectricchargammountP = Utilitypreview.getElectricCharge();
		System.out.println("Electric charge amount: " + ElectricchargammountP + "\n");
		String TotalAmountDueDateP = Utilitypreview.getTotalAmountDueDate();
		System.out.println("Total amount due date: " + TotalAmountDueDateP + "\n");
		Double TotalAmountP = Utilitypreview.getTotalAmount();
		System.out.println("Total amount: " + TotalAmountP + "\n");
		String QuestionAboutBillURL2P = Utilitypreview.getQuestionAboutBillURL2P();
		System.out.println("Question URL2: " + QuestionAboutBillURL2P + "\n");
		String WayToPayURL3P = Utilitypreview.getWayToPayURL3P();
		System.out.println("WaytoPayURL3: " + WayToPayURL3P + "\n");
		String ImpMsg1P = Utilitypreview.getImpMsg1P();
		System.out.println("IMPMSG1: " + ImpMsg1P + "\n");
		String ImpMsg2P = Utilitypreview.getImpMsg2P();
		System.out.println("ImpMsg2: " + ImpMsg2P + "\n");
		String DueDateBottomP = Utilitypreview.getDueDateBottom();
		System.out.println("DueDateBottom: " + DueDateBottomP + "\n");
		Double TotalDueAmoutBottomP = Utilitypreview.getTotalDueAmoutBottomPString();
		System.out.println("TotalDueAmoutBottom: " + TotalDueAmoutBottomP + "\n");
		String CompanyAddBottomP = Utilitypreview.getCompanyAddBottomP();
		System.out.println("CompanyAddBottom: " + CompanyAddBottomP + "\n");
		if (companynameP.equalsIgnoreCase(propConnection.getProperty("CompanyName"))) {

			softAssertion1.assertTrue(true, "Company Name is Wrong at top");
		} else if (URL1P.equalsIgnoreCase(propConnection.getProperty("WebsiteURL"))) {
			softAssertion1.assertTrue(true, "WebsiteURL is Wrong at top");
		} else if (StatmentDateP.equalsIgnoreCase(propConnection.getProperty("StatementDate"))) {
			softAssertion1.assertTrue(true, "StatementDate is Wrong at top");
		} else if (PreviousState1P.equalsIgnoreCase(propConnection.getProperty("PreviousStateAmount"))) {
			softAssertion1.assertTrue(true, "PreviousStateAmount is Wrong");
		} else if (PreviousState2P.equalsIgnoreCase(propConnection.getProperty("PreviousStateAmount"))) {
			softAssertion1.assertTrue(true, "Last Statement Amount is Wrong");
		}
		Double PaymentDueAmount = Double.parseDouble(propConnection.getProperty("PaymentDueAmountString"));
		double PaymentDueAmount1 = PaymentDueAmount * 63.15 / 100;
		System.out.println(DeliverychargammountP);
		System.out.println("Delevery charge amount after calculation=" + PaymentDueAmount1);
		if (DeliverychargammountP.equals(PaymentDueAmount1)) {
			softAssertion1.assertTrue(true);
		} else {
			softAssertion1.assertTrue(false, "Delevery charge amount after calculation=");
		}
		double PaymentDueAmount2 = PaymentDueAmount * 36.85 / 100;
		System.out.println("Electric genration charge amount after calculation=" + PaymentDueAmount2);

		if (ElectricchargammountP.equals(PaymentDueAmount2)) {
			softAssertion1.assertTrue(true);
		} else {
			softAssertion1.assertTrue(false, "Electric genration charge amount is not correct");
		}
		if (ImpMsg1P.contains(CustomerServiceNo) && ImpMsg1P.contains(propConnection.getProperty("WebsiteURL"))
				&& ImpMsg2P.contains(CustomerServiceNo)
				&& ImpMsg2P.contains(propConnection.getProperty("WebsiteURL"))) {
			softAssertion1.assertTrue(true);
		} else {
			softAssertion1.assertTrue(false, "The message does not contain the website URL and Customer Service No");
		}
		Double totalAmountDue = PaymentDueAmount1 + PaymentDueAmount2;
		System.out.println("Actual total amount: " + TotalAmountP);
		System.out.println("Expected total amount: " + totalAmountDue);
		if (TotalAmountP.equals(totalAmountDue) && TotalDueAmoutBottomP.equals(totalAmountDue)) {
			softAssertion1.assertTrue(true);
		} else {
			softAssertion1.assertTrue(false, "The total amount is not as expected");
		}
		getScreenshotPath("UtilityPreviewScreen", driver);
		softAssertion1.assertAll();
		
		
	}

	@Test(priority = 2)
	public void UtilityForm_verifyDataOfUtilityOrderPage() {
		SoftAssert softAssertion2 = new SoftAssert();
		//commonformElements = new CommonFormElements(driver);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		orderp = UtiltiyFormStep4.pressCheckoutButton();

		softAssertion2.assertEquals(orderp.getDateOfOrderPlaced(), orderp.gettodaysdate(),
				"Date is not correct in order page");

		softAssertion2.assertEquals(orderp.getBillType(), "Utility Bill", "Bill Type is not correct");

		softAssertion2.assertEquals(orderp.getShippingAmount(), "$ 0.00",
				"Shipping Amount before applying coupon is not correct");

		softAssertion2.assertEquals(orderp.getAmountValue(), "$ 20.0", "Amount not correct");

		softAssertion2.assertEquals(orderp.getTotalAmount(), "$ 20.0",
				"Total Amount before applying coupon is not correct");

		softAssertion2.assertAll();
	}

	@Test(priority = 3)
	public void UtilityForm_verifyCouponCodeFunctionalityWithValidCode() {
		SoftAssert softAssertion3 = new SoftAssert();

		orderp.enterCoupenCode(propConnection.getProperty("CouponCode"));
		nos_calls = orderp.pressApplyCouponButton();
		softAssertion3.assertEquals(orderp.getTotalAmount(), " $ 0.0", "Coupon not applied");

		softAssertion3.assertEquals(orderp.getTextOnCheckoutPayButton(), "Complete Checkout",
				"Text on checkout button does not change after applying free coupen");
		nos_calls += 1;
		softAssertion3.assertAll();
	}

}
