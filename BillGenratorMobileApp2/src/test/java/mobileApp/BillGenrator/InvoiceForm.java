package mobileApp.BillGenrator;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import MobileApp.BillGenratorMobileApp2.PageObject.Android.InvoiceForm.InvoicePreviewPage;
import base.BaseClass;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.AndroidKey;

public class InvoiceForm extends BaseClass {
	String NoteEntered;
	String InvoiceDate;
	String taxType;

	@BeforeClass
	@org.testng.annotations.Parameters({"deviceName", "platformVersion", "udid"})
	public void beforeeverymethodinsameclass(String deviceName, String platformVersion, String udid) throws IOException {
		ConfigurAndroid(deviceName, platformVersion, udid);
	}

	@Test(priority = 1)
	public void InvoiceForm_VerifyStep3ShowsDateAsToday() throws Exception {
		SoftAssert softAssertion1 = new SoftAssert();
		dashboard = flashscreen.pressGetStarted();
		LoginWithValidCred();
		SideNevigationMenu = dashboard.pressRigtSideNevigationMenu();
		InvoiceFormStep1 = SideNevigationMenu.ClickInvoiceForm();
		InvoiceFormStep1.enterEnvoiceTitle(propConnection.getProperty("InvoiceFromTitle"));
		InvoiceFormStep1.uploadLogo();
		InvoiceFormStep1.enterFromName(propConnection.getProperty("InvoiceFromName"));
		InvoiceFormStep1.enterFromEmail(propConnection.getProperty("InvoiceFromEmail"));
		InvoiceFormStep1.enterFromAdd1(propConnection.getProperty("InvoiceFromAddress1"));
		InvoiceFormStep1.enterFromAdd2(propConnection.getProperty("InvoiceFromAddress2"));
		InvoiceFormStep1.enterFromCity(propConnection.getProperty("InvoiceFromCity"));
		InvoiceFormStep1.selectFromState(propConnection.getProperty("InvoiceFromState"));
		InvoiceFormStep1.enterFromZip(propConnection.getProperty("InvoiceFromZip"));
		InvoiceFormStep1.enterPhonNumber(propConnection.getProperty("InvoiceFromPhone"));
		InvoiceFormStep1.enterBusinessNumber(propConnection.getProperty("InvoiceFromBusinessNumber"));
		InvoiceFormStep2 = InvoiceFormStep1.pressNEXT();
		InvoiceFormStep2.enterToName(propConnection.getProperty("InvoiceToName"));
		InvoiceFormStep2.enterToEmail(propConnection.getProperty("InvoiceToEmail"));
		InvoiceFormStep2.enterToAdd1(propConnection.getProperty("InvoiceToAddress1"));
		InvoiceFormStep2.enterToAdd2(propConnection.getProperty("InvoiceToAddress2"));
		InvoiceFormStep2.enterToCity(propConnection.getProperty("InvoiceToCity"));
		InvoiceFormStep2.selectState(propConnection.getProperty("InvoiceToState"));
		InvoiceFormStep2.enterToZip(propConnection.getProperty("InvoiceToZip"));
		InvoiceFormStep2.enterToPhone(propConnection.getProperty("InvoiceToPhone"));
		InvoiceFormStep3 = InvoiceFormStep2.pressNEXT();
		InvoiceFormStep3.enterEnvoiceNumber(propConnection.getProperty("InvoiceNumber"));
		Assert.assertEquals(InvoiceFormStep3.getDate(), InvoiceFormStep3.verifyTodaysDate(),
				"Todays date is not mentioned or incorrect in Date field"); // Verify date mentioned is todays date or
																			// not.

		Thread.sleep(2000l);
		softAssertion1.assertAll();
		InvoiceFormStep4 = InvoiceFormStep3.pressNEXT();
	}

	@Test(priority = 2)
	public void InvoiceForm_verifyStep5AndStep6Page() throws Exception {
		SoftAssert softAssertion2 = new SoftAssert();
		taxType = InvoiceFormStep4.selectTaxType("deducted"); // Select tax type in step 4 as "Deducted"
		Double taxRate = InvoiceFormStep4.EnterTaxRate("10"); // Enter tax rate in step 4
		InvoiceFormStep5 = InvoiceFormStep4.pressNEXT();
		InvoiceFormStep5.enterItemDesc(1, "Test Item 1");
		InvoiceFormStep5.enterAdditionalDetails(1, "Item 1 test description for testing purpose only.");
		Double Item1rates = InvoiceFormStep5.enterItemRates(1, "23");
		Double Item1quantity = InvoiceFormStep5.enterItemquantity(1, "2");

		// Verify Total amount for first item in step 5 page
		softAssertion2.assertEquals(InvoiceFormStep5.getSingleItemAmount(), 46.00,
				"Total amount is not correct as per rate and quantity");

		InvoiceFormStep6 = InvoiceFormStep5.pressNEXT();

		// Verify all value in step 6 with only 1 item added and tax type as deducted.
		softAssertion2.assertEquals(InvoiceFormStep6.getSubTotal(), 46.00, "Subtotal value is not correct"); // Verify
																												// subtotal
																												// value
		softAssertion2.assertEquals(InvoiceFormStep6.getTax(), 4.6, "Tax applied is not correct");
		softAssertion2.assertEquals(InvoiceFormStep6.getTextOfTax().contains("-"), true,
				"The sign mentioned in tax is wrong.");

		InvoiceFormStep5 = InvoiceFormStep6.pressPrevious(); // Go to step 5 page again

		InvoiceFormStep5.pressPlusButton(); // Press on plus button to add new item.

		Thread.sleep(3000l);
		// Add second Item details.
		InvoiceFormStep5.enterItemDesc(2, "Test Item 2");
		InvoiceFormStep5.enterAdditionalDetails(2, "Item 2 test description for testing purpose only.");
		Double Item2rates = InvoiceFormStep5.enterItemRates(2, "25");
		Double Item2quantity = InvoiceFormStep5.enterItemquantity(2, "3");

		// Verify Total amount for second item.
		softAssertion2.assertEquals(InvoiceFormStep5.getSingleItemAmount(), 75.00,
				"Total amount is not correct as per rate and quantity");

		InvoiceFormStep6 = InvoiceFormStep5.pressNEXT();

		// Verify all values in step 6 page with 2 items added.
		softAssertion2.assertEquals(InvoiceFormStep6.getSubTotal(), 121.00, "Subtotal value is not correct");
		softAssertion2.assertEquals(InvoiceFormStep6.getTextOfTax().contains("-"), true,
				"The sign mentioned in tax is wrong.");
		softAssertion2.assertEquals(InvoiceFormStep6.getTax(), 12.10, "Tax applied is not correct");
		softAssertion2.assertEquals(InvoiceFormStep6.getTotal(), 108.9,
				"Total amount is not correct as per rate and quantity");
		softAssertion2.assertEquals(InvoiceFormStep6.getBalanceDue(), 108.9,
				"Total amount is not correct as per rate and quantity");
		NoteEntered = InvoiceFormStep6.enterNote("Testing note for testing purpose only etc");
		softAssertion2.assertAll();
	}

	@Test(priority = 4)
	public void InvoiceForm_verifyPreviewPage() {
		SoftAssert softAssertion3 = new SoftAssert();
		InvoicePreviewPage = InvoiceFormStep6.pressPreviewButton();

		// verify Invoice Title
		softAssertion3.assertEquals(InvoicePreviewPage.getInvoiceTitle(),
				propConnection.getProperty("InvoiceFromTitle"), "Invoice Title is not correct");
		// Verify From name
		softAssertion3.assertEquals(InvoicePreviewPage.getFromName(), propConnection.getProperty("InvoiceFromName"),
				"From name is not correct");
		// Verify From email
		softAssertion3.assertEquals(InvoicePreviewPage.getFromEmail(), propConnection.getProperty("InvoiceFromEmail"),
				"From name is not correct");
		// Verify From Address1 and 2, City,State,Zip
		if (InvoicePreviewPage.getFromAddressCityStateZip().contains(propConnection.getProperty("InvoiceFromAddress1"))
				&& InvoicePreviewPage.getFromAddressCityStateZip()
						.contains(propConnection.getProperty("InvoiceFromAddress2"))
				&& InvoicePreviewPage.getFromAddressCityStateZip()
						.contains(propConnection.getProperty("InvoiceFromCity"))
				&& InvoicePreviewPage.getFromAddressCityStateZip()
						.contains(InvoicePreviewPage.getShortCutOfState(propConnection.getProperty("InvoiceFromState")))
				&& InvoicePreviewPage.getFromAddressCityStateZip()
						.contains(propConnection.getProperty("InvoiceFromZip"))) {
			softAssertion3.assertTrue(true);
		} else {
			softAssertion3.fail("From address city state is not correct");
		}
		// Verify From Phone number
		softAssertion3.assertEquals(InvoicePreviewPage.getFromPhoneNumber(),
				propConnection.getProperty("InvoiceFromPhone"), "From phone number is not correct");
		// Verify From Business number
		softAssertion3.assertEquals(InvoicePreviewPage.getFromBusinessNumber(),
				propConnection.getProperty("InvoiceFromBusinessNumber"), "From Business number is not correct");

		// Verify To name
		softAssertion3.assertEquals(InvoicePreviewPage.getToName(), propConnection.getProperty("InvoiceToName"),
				"To name is not correct");
		// Verify To Email
		softAssertion3.assertEquals(InvoicePreviewPage.getToEmail(), propConnection.getProperty("InvoiceToEmail"),
				"To Email is not correct");
		// Verify To Address1 and 2, City,State,Zip
		// InvoicePreviewPage.getToAddressCityStateZip().contains(InvoicePreviewPage.getShortCutOfState(propConnection.getProperty("InvoiceToState")))&&

		if (InvoicePreviewPage.getToAddressCityStateZip().contains(propConnection.getProperty("InvoiceToAddress1"))
				&& InvoicePreviewPage.getToAddressCityStateZip()
						.contains(propConnection.getProperty("InvoiceToAddress2"))
				&& InvoicePreviewPage.getToAddressCityStateZip().contains(propConnection.getProperty("InvoiceToCity"))
				&& InvoicePreviewPage.getToAddressCityStateZip()
						.contains(InvoicePreviewPage.getShortCutOfState(propConnection.getProperty("InvoiceToState")))
				&& InvoicePreviewPage.getToAddressCityStateZip().contains(propConnection.getProperty("InvoiceToZip"))) {
			softAssertion3.assertTrue(true);
		} else {
			softAssertion3.fail("To address city state is not correct");
		}
		// Verify To Phone number
		softAssertion3.assertEquals(InvoicePreviewPage.getToPhone(), propConnection.getProperty("InvoiceToPhone"),
				"To Phon is not correct");

		// Verify Invoice Number
		softAssertion3.assertEquals(InvoicePreviewPage.getInvoiceNo(), propConnection.getProperty("InvoiceNumber"),
				"Invoice number is not correct");
		// Verify Invoice Date
		softAssertion3.assertEquals(InvoicePreviewPage.getInvoiceDate(), InvoiceDate, "Invoice date is not correct");

		// Verify Item Data
//		InvoiceFormStep5.getItemCountAdded(); //To get the count of items added

		softAssertion3.assertEquals(InvoicePreviewPage.getItemName(1), "Test Item 1", "First Item name Does not exist");
		softAssertion3.assertEquals(InvoicePreviewPage.getItemDescription(1),
				"Item 1 test description for testing purpose only.", "First Item Description is not correct");
		softAssertion3.assertEquals(InvoicePreviewPage.getItemRates(1), "23", "First item rate is not correct");
		softAssertion3.assertEquals(InvoicePreviewPage.getItemsQuantity(1), "2", "First item quantity is not correct");
		softAssertion3.assertEquals(InvoicePreviewPage.getItemsAmount(1), "46.0",
				"total amount is not correct for first item.");

		softAssertion3.assertEquals(InvoicePreviewPage.getItemName(2), "Test Item 2",
				"Second Item name Does not exist");
		softAssertion3.assertEquals(InvoicePreviewPage.getItemDescription(2),
				"Item 2 test description for testing purpose only.", "Second Item Description is not correct");
		softAssertion3.assertEquals(InvoicePreviewPage.getItemRates(2), "25", "Second Item rate is not correct");
		softAssertion3.assertEquals(InvoicePreviewPage.getItemsQuantity(2), "3", "Second Item quantity is not correct");
		softAssertion3.assertEquals(InvoicePreviewPage.getItemsAmount(2), "75.0",
				"total amount is not correct for Second Item.");

		softAssertion3.assertEquals(InvoicePreviewPage.getSubTotalValue(), "121.00", "Subtotal amount is not correct");
		softAssertion3.assertEquals(InvoicePreviewPage.getTaxValue(), "12.10", "Tax deducted value is not correct");
		softAssertion3.assertEquals(InvoicePreviewPage.getTotalValue(), "108.9", "Total amount shown is not correct");
		softAssertion3.assertEquals(InvoicePreviewPage.getBalanceValue(), "108.90", "Balance due value is not correct");
		softAssertion3.assertEquals(InvoicePreviewPage.getNoteText(), "Testing note for testing purpose only etc",
				"Note text is not correct.");
		// Verify Signs according to tax type selected.
		if (taxType.equalsIgnoreCase("deducted")) {
			softAssertion3.assertTrue(InvoicePreviewPage.getTaxValue().contains("-"),
					"Tax Selected as deducted but does not shows '-'");
		}

		softAssertion3.assertAll();

	}

	@Test(priority = 5)
	public void InvoiceForm_verifyOrderPage() {
		SoftAssert softAssertion4 = new SoftAssert();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		orderp = InvoiceFormStep6.pressCheckout();

		// Verify order placed date
		softAssertion4.assertEquals(orderp.getDateOfOrderPlaced(), orderp.gettodaysdate(),
				"Date is not correct in order page");

		softAssertion4.assertEquals(orderp.getBillType(), "Invoice", "Bill Type is not correct");

		softAssertion4.assertEquals(orderp.getShippingAmount(), "$ 0.00",
				"Shipping Amount before applying coupon is not correct");

		softAssertion4.assertEquals(orderp.getAmountValue(), "$ 0.00", "Amount not correct");

		softAssertion4.assertEquals(orderp.getTotalAmount(), "$ 0.00",
				"Total Amount before applying coupon is not correct");

		softAssertion4.assertAll();
	}

	@Test(priority = 6)
	public void InvoiceForm_verifyThankYouPage() {
		{
			SoftAssert softAssertion5 = new SoftAssert();
			thankyoupage = orderp.pressPressPayWithCryptoButtonInvoice();

			// softAssertion3.assertNotEquals(thankyoupage.getThankYouPage(), null, "Thank
			// you page does not appear");
			if (thankyoupage.getThankYouPage().equals(null)) {
				softAssertion5.assertTrue(false, "Thank you page does not appear");
			}
			softAssertion5.assertTrue(true);
			softAssertion5.assertAll();
		}
	}

	@Test(priority = 3)
	public void InvoiceForm_verifyCalculationsOnRemovingPreviouslyAddedItem() throws Exception {
		InvoiceFormStep5 = InvoiceFormStep6.pressPrevious(); // Go to step 5 page again
		InvoiceFormStep5.pressPlusButton();
		InvoiceFormStep5.enterItemDesc(3, "Test Item 3");
		InvoiceFormStep5.enterAdditionalDetails(3, "Item 3 test description for testing purpose only.");
		Double Item2rates = InvoiceFormStep5.enterItemRates(3, "99");
		Double Item2quantity = InvoiceFormStep5.enterItemquantity(3, "3");

		InvoiceFormStep6 = InvoiceFormStep5.pressNEXT();
		InvoiceFormStep5 = InvoiceFormStep6.pressPrevious();
		InvoiceFormStep5.pressRemoveItem("Test Item 3");
		InvoiceFormStep6 = InvoiceFormStep5.pressNEXT();
	}
}
