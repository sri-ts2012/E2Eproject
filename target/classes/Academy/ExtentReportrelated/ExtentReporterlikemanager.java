package Academy.ExtentReportrelated;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterlikemanager {

static ExtentReports extent;
	
	public static ExtentReports getReportObject()
	{
		//Date d = new Date();
		//String	addDateandext = d.toString().replace(":", "_").replace(" ", "_") ;
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		//extent = new ExtentReports (userDir +"\\test-output\\" + timeStamp + ".html"
		
		String path =System.getProperty("user.dir")+"\\reports\\ExtentReports\\ExtentReports"+timeStamp+".html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("QA ClickAcad Results");
		reporter.config().setDocumentTitle("Test Results");
		
		 extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA", "Hima");
		return extent;
		
	}
}
