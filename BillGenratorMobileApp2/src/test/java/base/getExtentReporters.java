package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class getExtentReporters {
	
	
	public static ExtentReports gettreporterObject() {
		
		String path=System.getProperty("user.dir")+"\\reports\\TestExecutions.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		
		//reporter = new ExtentReports(path, false, DisplayOrder.NEWEST_FIRST);
		reporter.config().setReportName("Mobile automation result");
		reporter.config().setDocumentTitle("BillGenrator Result");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		//extent.setSystemInfo("Tester", "Shashank Naik");
		return extent;
	}
}