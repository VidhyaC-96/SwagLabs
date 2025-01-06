package genericUtilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {
	/*used for screenshot name and report name*/
	/*capture the current date*/
	Date d=new Date();
	SimpleDateFormat f=new SimpleDateFormat("dd-mm-yyyy hh-mm-ss");
	String date = f.format(d);

	/*used for extent report*/
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		//capture the method name of current test annotations
		String methodName = result.getMethod().getMethodName();
		System.out.println("Test Execution Start");
		
		/*intimate extent report about text execution*/
		test=report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//capture the method name of current test annotations
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" -> Test Pass");
		
		/*Log the status as pass in extent reports*/
		test.log(Status.PASS,methodName+" -> Test Pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		//capture the method name of current test annotations
		String methodName = result.getMethod().getMethodName();
		
		//capture the exception and print
		System.out.println(result.getThrowable());
		System.out.println(methodName+" -> Test Fail");
		
		/*Log the status as fail and exception in Extent report*/
		test.log(Status.FAIL, methodName+" -> Test Fail");
		test.log(Status.WARNING, result.getThrowable());
		
		//capture the screenshot		
		String screenshotName = methodName+date;
		SeleniumUtility sUtil= new SeleniumUtility();
		try {
			String path=sUtil.captureScreenshot(BaseClass.sdriver,screenshotName );
			test.addScreenCaptureFromPath(path, screenshotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		//capture the method name of current test annotations
		String methodName = result.getMethod().getMethodName();
		
		//capture the exception and print
		System.out.println(result.getThrowable());
		System.out.println(methodName+" -> Test Skip");
		
		/*Log the status as skip in extent report */
		test.log(Status.WARNING, methodName+" -> Test Skip");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Suite Execution Start");
		
	/*Basic configuration of extent reports*/
		ExtentSparkReporter esp=new ExtentSparkReporter(".\\ExtentReports\\Report -"+date+".html");
		esp.config().setDocumentTitle("Swag Labs Execution Reports");
		esp.config().setTheme(Theme.DARK);
		esp.config().setReportName("Swag Labs Execution Report");
		
	/*Extent Report Generation*/
		report=new ExtentReports();
		report.attachReporter(esp);
		report.setSystemInfo("Base Browser", "");
		report.setSystemInfo("Base Platform", "");
		report.setSystemInfo("Base Environment", "");
		report.setSystemInfo("Reporter Name", "");
	}

	@Override
	public void onFinish(ITestContext context) {
		
		System.out.println("Suite Execution End");
		/*report generation actual*/
		report.flush();
	}

}
