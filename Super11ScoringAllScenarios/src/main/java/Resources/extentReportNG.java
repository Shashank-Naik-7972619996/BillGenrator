package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReportNG {
	static ExtentReports ER;
	
	public static ExtentReports getEReport()
	{
	String path = System.getProperty("user.dir")+"\\report\\index.html";
	ExtentSparkReporter ESR = new ExtentSparkReporter(path);
	ESR.config().setReportName("Web automation");
	ESR.config().setDocumentTitle("Test detail report");
	ER = new ExtentReports();
	ER.attachReporter(ESR);
	ER.setSystemInfo("Tester", "Shashank Naik");
	return ER;
	}
}
