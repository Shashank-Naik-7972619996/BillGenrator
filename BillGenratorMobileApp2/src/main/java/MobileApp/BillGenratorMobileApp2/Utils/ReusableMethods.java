package MobileApp.BillGenratorMobileApp2.Utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotInteractableException;
//
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.remote.http.HttpMethod;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import MobileApp.BillGenratorMobileApp2.PageObject.Android.FlashScreen;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class ReusableMethods {

	AndroidDriver driver;
	public WebDriver browserdriver;
	public WebDriverWait Expwait;
	public Wait fwait;

	public ReusableMethods(AndroidDriver driver1) {

		this.driver = driver1;
	}

	public ReusableMethods(WebDriver browserdriver2) {
		// TODO Auto-generated constructor stub
		this.browserdriver = browserdriver2;
	}

	public FlashScreen relounchapp() {
		driver.closeApp();
		driver.launchApp();
		FlashScreen flashscreen = new FlashScreen(driver);
		return flashscreen;
	}

	public WebElement Scrolluntil(String ScrolluptoText) {
		return driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + ScrolluptoText + "\"));"));
	}

	public void ScrolltillEndofPage() {
		boolean canSctollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
				ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent",
						3.0));
	}

	public void LongPress(WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()));
	}

	public void drag(WebElement element, int endX, int endY) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "endX", endX, "endY", endY));

	}

	public void swipeDownNotification() {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("left", 100, "top", 0,
				"width", 200, "height", 200, "direction", "down", "percent", 0.75));

	}

	public void LongPress2(WebElement element) {
		// driver.findElement(AppiumBy.accessibilityId("longpress"))
		RemoteWebElement longPress = (RemoteWebElement) element;

		driver.addCommand(HttpMethod.POST, String.format("/session/%s/plugin/actions/longPress", driver.getSessionId()),
				"longPress");

		driver.execute("longPress", Map.of("elementId", longPress.getId(), "pressure", 0.5, "duration", 800));
	}

	public void turnOnwaitForAndroid() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Expwait = new WebDriverWait(driver, Duration.ofSeconds(30));

	}

	public void turnOnWaitOnBrowser() {
		browserdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Expwait = new WebDriverWait(browserdriver, Duration.ofSeconds(100));

	}

	public void turnOffWaitOnBrowser() {
		browserdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		// Expwait = new WebDriverWait(browserdriver, Duration.ofSeconds(30));

	}

	public void turnOffwaitonthisclass() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

	}

	public void trunonFluentwait() {
		fwait = new FluentWait(driver).withTimeout(Duration.ofSeconds(30L)).pollingEvery(Duration.ofSeconds(5L))
				.ignoring(NoSuchElementException.class).ignoring(TimeoutException.class);
	}

	protected void scrollDown() {
		// if pressX was zero it didn't work for me
		int pressX = driver.manage().window().getSize().width / 2;
		// 4/5 of the screen as the bottom finger-press point
		int bottomY = driver.manage().window().getSize().height * 4 / 5;
		// just non zero point, as it didn't scroll to zero normally
		int topY = driver.manage().window().getSize().height / 8;
		// scroll with TouchAction by itself
		scroll(pressX, bottomY, pressX, topY);
	}

	public void scrollUp() throws Exception {
		// Get the size of screen.
		Dimension size = driver.manage().window().getSize();

		int starty = (int) (size.height * 0.30);

		int endy = (int) (size.height * 0.80);

		int startx = size.width / 2;

		// Swipe from Bottom to Top.
		scroll(startx, starty, startx, endy);
		Thread.sleep(2000);
	}

	private void scroll(int fromX, int fromY, int toX, int toY) {

		TouchAction touchAction = new TouchAction(driver);
		touchAction.longPress(PointOption.point(fromX, fromY)).moveTo(PointOption.point(toX, toY)).release().perform();
	}

	public List<WebElement> getItemfromList(String locator) {
		return driver.findElements(By.xpath(locator));
	}

	public void scrollDownTillElement(String locator1) throws Exception {
		turnOffwaitonthisclass();
		while (getItemfromList(locator1).size() == 0) {

			scrollDown();
		}
		if (getItemfromList(locator1).size() > 0) {
			getItemfromList(locator1).get(0).click();
			turnOnwaitForAndroid();

		}
	}

	public void scrollDownTillElementWithoutClick(String locator1) throws Exception {
		turnOffwaitonthisclass();
		while (getItemfromList(locator1).size() == 0) {

			scrollDown();
		}
		if (getItemfromList(locator1).size() > 0) {
			getItemfromList(locator1).get(0);
			turnOnwaitForAndroid();

		}
	}

	public WebElement scrollDownTillWebElement(WebElement locator) throws Exception {
		turnOffwaitonthisclass();
		String locator1 = locator.toString().replace("Located by By.chained({By.xpath: ", "").replace("})", "");
		System.out.println("webelement to string presentation: " + locator1);
		while (getItemfromList(locator1).size() == 0) {

			scrollDown();
		}
		if (getItemfromList(locator1).size() > 0) {
			return getItemfromList(locator1).get(0);
		}
		turnOnwaitForAndroid();
		return locator;
	}

	public WebElement scrollUpTillWebElement(WebElement locator) throws Exception {
		turnOffwaitonthisclass();
		String locator1 = locator.toString().replace("Located by By.chained({By.xpath: ", "").replace("})", "");
		System.out.println("webelement to string presentation: " + locator1);
		while (getItemfromList(locator1).size() == 0) {

			scrollUp();
		}
		if (getItemfromList(locator1).size() > 0) {
			return getItemfromList(locator1).get(0);
		}
		turnOnwaitForAndroid();
		return locator;
	}

	public void scrollUpTillElement(String locator1) throws Exception {
		turnOffwaitonthisclass();
		while (getItemfromList(locator1).size() == 0) {

			scrollUp();
		}
		if (getItemfromList(locator1).size() > 0) {
			getItemfromList(locator1).get(0).click();
			turnOnwaitForAndroid();

		}
	}

	public String getTextValueOfWebElementID(String id, int index) {
		index = index - 1;
		WebElement loader = browserdriver.findElement(By.id("show_loader"));
		if (loader.getAttribute("style").contains("opacity")) {
			turnOnWaitOnBrowser();
			Expwait.until(ExpectedConditions.attributeToBe(loader, "style", "display: none;"));
		}
		JavascriptExecutor js = (JavascriptExecutor) browserdriver;
		String value = (String) js.executeScript("return $('input[id=" + id + "]').eq(" + index + ").val()");
		// System.out.println("Value= " + value);
		return value;
	}

	protected String getTextValueOfWebElementID(String id) {

		WebElement loader = browserdriver.findElement(By.id("show_loader"));
		if (loader.getAttribute("style").contains("opacity")) {
			turnOnWaitOnBrowser();
			Expwait.until(ExpectedConditions.attributeToBe(loader, "style", "display: none;"));
		}
		JavascriptExecutor js = (JavascriptExecutor) browserdriver;
		String value = (String) js.executeScript("return $('input[id=" + id + "]').val()");
		// System.out.println("Value= " + value);
		return value;

	}

	public String getShortState(String selectedState) {
		if (selectedState.equalsIgnoreCase("Alabama")) {
			return "AL";
		}
		if (selectedState.equalsIgnoreCase("Alaska")) {
			return "AK";
		}
		if (selectedState.equalsIgnoreCase("Arizona")) {
			return "AZ";
		}
		if (selectedState.equalsIgnoreCase("Arkansas")) {
			return "AR";
		}
		if (selectedState.equalsIgnoreCase("California")) {
			return "CA";
		}
		if (selectedState.equalsIgnoreCase("Colorado")) {
			return "CO";
		}
		if (selectedState.equalsIgnoreCase("Connecticut")) {
			return "CT";
		}
		if (selectedState.equalsIgnoreCase("Delaware")) {
			return "DE";
		}
		if (selectedState.equalsIgnoreCase("District Of Columbia")) {
			return "DC";
		}
		if (selectedState.equalsIgnoreCase("Florida")) {
			return "FL";
		}
		if (selectedState.equalsIgnoreCase("Georgia")) {
			return "GA";
		}
		if (selectedState.equalsIgnoreCase("Hawaii")) {
			return "HI";
		}
		if (selectedState.equalsIgnoreCase("Idaho")) {
			return "ID";
		}
		if (selectedState.equalsIgnoreCase("Illinois")) {
			return "IL";
		}
		if (selectedState.equalsIgnoreCase("Indiana")) {
			return "IN";
		}
		if (selectedState.equalsIgnoreCase("Iowa")) {
			return "IA";
		}
		if (selectedState.equalsIgnoreCase("Kansas")) {
			return "KS";
		}
		if (selectedState.equalsIgnoreCase("Kentucky")) {
			return "KY";
		}
		if (selectedState.equalsIgnoreCase("Louisiana")) {
			return "LA";
		}
		if (selectedState.equalsIgnoreCase("Maine")) {
			return "ME";
		}
		if (selectedState.equalsIgnoreCase("Maryland")) {
			return "MD";
		}
		if (selectedState.equalsIgnoreCase("Massachusetts")) {
			return "MA";
		}
		if (selectedState.equalsIgnoreCase("Michigan")) {
			return "MI";
		}
		if (selectedState.equalsIgnoreCase("Minnesota")) {
			return "MN";
		}
		if (selectedState.equalsIgnoreCase("Mississippi")) {
			return "MS";
		}
		if (selectedState.equalsIgnoreCase("Missouri")) {
			return "MO";
		}
		if (selectedState.equalsIgnoreCase("Montana")) {
			return "MT";
		}
		if (selectedState.equalsIgnoreCase("Nebraska")) {
			return "NE";
		}
		if (selectedState.equalsIgnoreCase("Nevada")) {
			return "NV";
		}
		if (selectedState.equalsIgnoreCase("New Hampshire")) {
			return "NH";
		}
		if (selectedState.equalsIgnoreCase("New Jersey")) {
			return "NJ";
		}
		if (selectedState.equalsIgnoreCase("New Mexico")) {
			return "NM";
		}
		if (selectedState.equalsIgnoreCase("New York")) {
			return "NY";
		}
		if (selectedState.equalsIgnoreCase("North Carolina")) {
			return "NC";
		}
		if (selectedState.equalsIgnoreCase("North Dakota")) {
			return "ND";
		}
		if (selectedState.equalsIgnoreCase("Ohio")) {
			return "OH";
		}
		if (selectedState.equalsIgnoreCase("Oklahoma")) {
			return "OK";
		}
		if (selectedState.equalsIgnoreCase("Oregon")) {
			return "OR";
		}
		if (selectedState.equalsIgnoreCase("Pennsylvania")) {
			return "PA";
		}
		if (selectedState.equalsIgnoreCase("Rhode Island")) {
			return "RI";
		}
		if (selectedState.equalsIgnoreCase("South Carolina")) {
			return "SC";
		}
		if (selectedState.equalsIgnoreCase("South Dakota")) {
			return "SD";
		}
		if (selectedState.equalsIgnoreCase("Tennessee")) {
			return "TN";
		}
		if (selectedState.equalsIgnoreCase("Texas")) {
			return "TX";
		}
		if (selectedState.equalsIgnoreCase("Utah")) {
			return "UT";
		}
		if (selectedState.equalsIgnoreCase("Vermont")) {
			return "VT";
		}
		if (selectedState.equalsIgnoreCase("Virginia")) {
			return "VA";
		}
		if (selectedState.equalsIgnoreCase("Washington")) {
			return "WA";
		}
		if (selectedState.equalsIgnoreCase("West Virginia")) {
			return "WV";
		}
		if (selectedState.equalsIgnoreCase("Wisconsin")) {
			return "WI";
		}
		if (selectedState.equalsIgnoreCase("Wyoming")) {
			return "WY";
		}
		return "Required state not available";
	}

	public void sendKeysWithCharKeyboard(String keytoenter) {
		turnOffwaitonthisclass();
		TouchAction touchAction = new TouchAction(driver);
		for (int i = 0; i < keytoenter.length(); i++) {
			char c = keytoenter.charAt(i);
			String charector = String.valueOf(c);
			if (charector.equalsIgnoreCase("a")) {
				touchAction.tap(PointOption.point(117, 1405)).perform();
			} else if (charector.equalsIgnoreCase("b")) {
				touchAction.tap(PointOption.point(647, 1549)).perform();
			} else if (charector.equalsIgnoreCase("c")) {
				touchAction.tap(PointOption.point(436, 1556)).perform();
			} else if (charector.equalsIgnoreCase("d")) {
				touchAction.tap(PointOption.point(328, 1399)).perform();
			} else if (charector.equalsIgnoreCase("e")) {
				touchAction.tap(PointOption.point(273, 1243)).perform();
			} else if (charector.equalsIgnoreCase("f")) {
				touchAction.tap(PointOption.point(426, 1387)).perform();
			} else if (charector.equalsIgnoreCase("g")) {
				touchAction.tap(PointOption.point(540, 1402)).perform();
			} else if (charector.equalsIgnoreCase("h")) {
				touchAction.tap(PointOption.point(641, 1399)).perform();
			} else if (charector.equalsIgnoreCase("i")) {
				touchAction.tap(PointOption.point(807, 1246)).perform();
			} else if (charector.equalsIgnoreCase("j")) {
				touchAction.tap(PointOption.point(752, 1402)).perform();
			} else if (charector.equalsIgnoreCase("k")) {
				touchAction.tap(PointOption.point(856, 1396)).perform();
			} else if (charector.equalsIgnoreCase("l")) {
				touchAction.tap(PointOption.point(963, 1393)).perform();
			} else if (charector.equalsIgnoreCase("m")) {
				touchAction.tap(PointOption.point(859, 1553)).perform();
			} else if (charector.equalsIgnoreCase("n")) {
				touchAction.tap(PointOption.point(752, 1546)).perform();
			} else if (charector.equalsIgnoreCase("o")) {
				touchAction.tap(PointOption.point(902, 1243)).perform();
			} else if (charector.equalsIgnoreCase("p")) {
				touchAction.tap(PointOption.point(1022, 1246)).perform();
			} else if (charector.equalsIgnoreCase("q")) {
				touchAction.tap(PointOption.point(61, 1246)).perform();
			} else if (charector.equalsIgnoreCase("r")) {
				touchAction.tap(PointOption.point(380, 1246)).perform();
			} else if (charector.equalsIgnoreCase("s")) {
				touchAction.tap(PointOption.point(221, 1396)).perform();
			} else if (charector.equalsIgnoreCase("t")) {
				touchAction.tap(PointOption.point(488, 1246)).perform();
			} else if (charector.equalsIgnoreCase("u")) {
				touchAction.tap(PointOption.point(703, 1246)).perform();
			} else if (charector.equalsIgnoreCase("v")) {
				touchAction.tap(PointOption.point(540, 1549)).perform();
			} else if (charector.equalsIgnoreCase("w")) {
				touchAction.tap(PointOption.point(166, 1246)).perform();
			} else if (charector.equalsIgnoreCase("x")) {
				touchAction.tap(PointOption.point(328, 1549)).perform();
			} else if (charector.equalsIgnoreCase("y")) {
				touchAction.tap(PointOption.point(592, 1246)).perform();
			} else if (charector.equalsIgnoreCase("z")) {
				touchAction.tap(PointOption.point(221, 1556)).perform();
			} else if (charector.equalsIgnoreCase(" ")) {
				touchAction.tap(PointOption.point(608, 1709)).perform();
			} else if (charector.equalsIgnoreCase(",")) {
				touchAction.tap(PointOption.point(215, 1700)).perform();
			} else if (charector.equalsIgnoreCase("@")) {
				touchAction.tap(PointOption.point(215, 1700)).perform();
			} else if (charector.equalsIgnoreCase(".")) {
				touchAction.tap(PointOption.point(859, 1709)).perform();
			} else if (charector.equalsIgnoreCase("1")) {
				touchAction.longPress(PointOption.point(61, 1246)).release().perform();
			} else if (charector.equalsIgnoreCase("2")) {
				touchAction.longPress(PointOption.point(166, 1246)).release().perform();
			} else if (charector.equalsIgnoreCase("3")) {
				touchAction.longPress(PointOption.point(273, 1243)).release().perform();
			} else if (charector.equalsIgnoreCase("4")) {
				touchAction.longPress(PointOption.point(380, 1246)).release().perform();
			} else if (charector.equalsIgnoreCase("5")) {
				touchAction.longPress(PointOption.point(488, 1246)).release().perform();
			} else if (charector.equalsIgnoreCase("6")) {
				touchAction.longPress(PointOption.point(592, 1246)).release().perform();
			} else if (charector.equalsIgnoreCase("7")) {
				touchAction.longPress(PointOption.point(703, 1246)).release().perform();
			} else if (charector.equalsIgnoreCase("8")) {
				touchAction.longPress(PointOption.point(807, 1246)).release().perform();
			} else if (charector.equalsIgnoreCase("9")) {
				touchAction.longPress(PointOption.point(902, 1243)).release().perform();
			} else if (charector.equalsIgnoreCase("0")) {
				touchAction.longPress(PointOption.point(1022, 1246)).release().perform();
			}
		}
		turnOnwaitForAndroid();

	}

	public void sendKeysWithNumKeyboard(String number) {
		turnOffwaitonthisclass();
		TouchAction touchAction = new TouchAction(driver);
		for (int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);
			String Number = String.valueOf(c);
			if (Number.equals("0")) {
				touchAction.tap(PointOption.point(408, 1706)).perform();
			} else if (Number.equals("1")) {
				touchAction.tap(PointOption.point(144, 1240)).perform();
			} else if (Number.equals("2")) {
				touchAction.tap(PointOption.point(408, 1261)).perform();
			} else if (Number.equals("3")) {
				touchAction.tap(PointOption.point(672, 1252)).perform();
			} else if (Number.equals("4")) {
				touchAction.tap(PointOption.point(141, 1402)).perform();
			} else if (Number.equals("5")) {
				touchAction.tap(PointOption.point(408, 1402)).perform();
			} else if (Number.equals("6")) {
				touchAction.tap(PointOption.point(684, 1402)).perform();
			} else if (Number.equals("7")) {
				touchAction.tap(PointOption.point(138, 1549)).perform();
			} else if (Number.equals("8")) {
				touchAction.tap(PointOption.point(405, 1549)).perform();
			} else if (Number.equals("9")) {
				touchAction.tap(PointOption.point(678, 1549)).perform();
			} else if (Number.equals(",")) {
				touchAction.tap(PointOption.point(141, 1697)).perform();
			} else if (Number.equals("/")) {
				touchAction.tap(PointOption.point(141, 1697)).perform();
			} else if (Number.equals(".")) {
				touchAction.tap(PointOption.point(672, 1697)).perform();
			}
		}
		turnOnwaitForAndroid();
	}

	public void clearData(WebElement elementToClear) {

		for (int i = 0; i < 35; i++) {
			elementToClear.sendKeys(Keys.BACK_SPACE);
		}
	}

	public void clearDataWithIndex(List<WebElement> elementToClear, int index) {
		// element = null;
		try {
			turnOnWaitOnBrowser();
			// Expwait.until(ExpectedConditions.presenceOfElementLocated((By)
			// elementToClear));
			WebElement element = elementToClear.get(index);
			Expwait.until(ExpectedConditions.visibilityOf(element));
			Expwait.until(ExpectedConditions.elementToBeClickable(element));

			for (int i = 0; i < 35; i++) {
				element.sendKeys(Keys.BACK_SPACE);
			}

		} catch (StaleElementReferenceException e) {

		} catch (IndexOutOfBoundsException e) {
			// e1.printStackTrace();
			WebElement element = elementToClear.get(index - 1);
			for (int i = 0; i < 35; i++) {
				element.sendKeys(Keys.BACK_SPACE);
			}

		} catch (ElementNotInteractableException e) {
//			WebElement element = elementToClear.get(index);

//			for (int i = 0; i < 35; i++) {
//				element.sendKeys(Keys.BACK_SPACE);
			// e2.printStackTrace();
		}
	}

	protected void clickonblank() {
		// TODO Auto-generated method stub
		// turnOnWaitOnBrowser();
		turnOnWaitOnBrowser();
		WebElement show_loader = browserdriver.findElement(By.id("show_loader"));
		Expwait.until(ExpectedConditions.attributeToBe(show_loader, "style", "display: none;"));
		browserdriver.findElement(By.xpath("//*[@id='tips_total']")).click();
	}

}