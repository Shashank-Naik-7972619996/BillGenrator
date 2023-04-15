package base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;

public class Listeners extends BaseClass implements ITestListener {

	ExtentReports extent = getExtentReporters.gettreporterObject();
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

		ITestListener.super.onTestStart(result);
		test = extent.createTest(result.getMethod().getDescription());
		try {
			browserdriver.get(propConnection.getProperty("initialurl"));
			// browserdriver.navigate().refresh();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		// test.log(Status.PASS, "Test Pass");
		test.pass(result.getThrowable());
	}

	@Override
	public void onTestFailure(ITestResult result) {

		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		if (test != null) {
			test.fail(result.getThrowable());
		}
		try {
//			driver = (AndroidDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
//			test.addScreenCaptureFromPath(takeScreenshot(driver));

			// if (WebAppOrMobile() == false) {
			try {
				driver = (AndroidDriver) result.getTestClass().getRealClass().getField("driver")
						.get(result.getInstance());
				test.addScreenCaptureFromPath(getScreenshotPath(result.getMethod().getMethodName(), driver),
						result.getMethod().getDescription());
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				browserdriver = (WebDriver) result.getTestClass().getRealClass().getField("browserdriver")
						.get(result.getInstance());
				test.addScreenCaptureFromPath(getScreenshotPathWeb(result.getMethod().getMethodName(), browserdriver),
						result.getMethod().getDescription());
			}
			// } else if(WebAppOrMobile() == true) {

			// }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		test.skip(result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

		ITestListener.super.onFinish(context);
		extent.flush();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

}