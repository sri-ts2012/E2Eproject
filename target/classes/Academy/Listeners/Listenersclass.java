package Academy.Listeners;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Academy.BaseTest.BaseTest;
import Academy.ExtentReportrelated.ExtentReporterlikemanager;

public class Listenersclass extends BaseTest implements ITestListener {
	public  WebDriver driver=null;
	ExtentReports extent=ExtentReporterlikemanager.getReportObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> threadextentTest=new ThreadLocal<ExtentTest>();
	//or we can create object of extentreproter class and use the object to access the getobject method
	/*ITestResult result=null;//getting null pointer exception like this
	
	String testMethodName=result.getMethod().getMethodName();
	String testClassName=result.getInstance().getClass().getSimpleName();*/
	String message;
	public String getTestParams(ITestResult tr) {
	    int iLength = tr.getParameters().length;
	   // String message = "";

	    try {
	        if ( tr.getParameters().length > 0 ) {
	            message = tr.getParameters()[0].toString();

	            for ( int iCount = 0; iCount < iLength; iCount++ ) {
	                if ( iCount == 0 ) {
	                    message = tr.getParameters()[0].toString();
	                }
	                else {
	                    message = message + ", " + tr.getParameters()[iCount].toString();
	                }
	            }
	        }
	    }

	    catch(Exception e) {
	        // do nothing...
	    }

	    return message;
	}
	
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	//	String param = (String) result.getParameters()[0];
		//if datadriven test , then can take the paramters but without datadriven are failing
		//there must be some code for this
	//	https://www.programcreek.com/java-api-examples/?class=org.testng.ITestResult&method=getParameters
		test=extent.createTest(result.getTestClass().getName() + "     @TestCase : "
				+ result.getMethod().getMethodName() + " -- "+getTestParams(result));
		threadextentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		threadextentTest.get().log(Status.PASS, "test passed ");
		//or
		threadextentTest.get().pass(result.getMethod().getMethodName());
		//pr
		threadextentTest.get().pass(result.getMethod().getMethodName()+"passed");
		
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "TEST CASE:- " + methodName.toUpperCase() + " PASSED" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		//test.pass(m);
		threadextentTest.get().pass(m);
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//screenshot method
		String testMethodName=result.getMethod().getMethodName();
		String testClassName=result.getInstance().getClass().getSimpleName();
		threadextentTest.get().fail(result.getThrowable());
		
		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		threadextentTest.get().fail(exceptionMessage);

		//String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "TEST CASE:- " + testMethodName.toUpperCase() + " FAILED" + "</b>";
	
		try {
			driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		System.out.println("driver in listgeners is "+driver);
		} catch(Exception e){
			e.printStackTrace();
	}
		try {
			/*test.fail("<b><font color=red>" + "Screenshot of failure" + "</font></b><br>",
			MediaEntityBuilder.createScreenCaptureFromPath(screenshots).build());*/			
			
			/*threadextentTest("<b><font color=red>" + "Screenshot of failure" + "</font></b><br>",
			MediaEntityBuilder.createScreenCaptureFromPath(screenshots).build());*/	
			
	threadextentTest.get().fail("<b><font color=red>" + "Screenshot of failure" + "</font></b><br>",MediaEntityBuilder.createScreenCaptureFromPath(getScreenshotpath(testClassName,testMethodName,driver)).build());	
	
	
	//	threadextentTest.get().addScreenCaptureFromPath(getScreenshotpath(testClassName,testMethodName,driver), testMethodName);
			//getScreenshotpath(testClassName,testMethodName,driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		threadextentTest.get().fail(m);
		//test.log(Status.FAIL, m);
		
		
		//where test report is
	//	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
		/*String excepionMessage=Arrays.toString(result.getThrowable().getStackTrace());
		testReport.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
				+ "</font>" + "</b >" + "</summary>" +excepionMessage.replaceAll(",", "<br>")+"</details>"+" \n");*/
	}
	
	
	
  
   /* public void onTestFailure(ITestResult result) {
    	System.out.println("***** Error "+result.getName()+" test has failed *****");
    	String methodName=result.getName().toString().trim();
        ITestContext context = result.getTestContext();
        System.out.println(context);
        System.out.println((WebDriver)context.getAttribute("driver"));
        driver = (WebDriver)context.getAttribute("driver");
   	System.out.println("webdriver in listener called");
   	System.out.println(driver);
    	takeScreenShot(methodName, driver);
    	System.out.println("screenshot method called");
    }*/



	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}
