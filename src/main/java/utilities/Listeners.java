package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends Base implements ITestListener {
		
	ExtentReports extentReport = ExtentReporterNG.getExtentReportObj();
	ExtentTest test;
	

	public void onTestStart(ITestResult result) 
	{			
		test = extentReport.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) 
	{
		test.log(Status.PASS, "Test case Passed");		
		
		try 
		{				
			String path = takeScreenshot(driver, "Pass/" + result.getInstanceName() + "/" + result.getMethod().getMethodName());		
			test.addScreenCaptureFromPath(path, result.getMethod().getMethodName());
		}
		catch (Exception e) 
		{
			log.fatal("Exception in onTestSuccess Method of Listeners class");
			log.fatal(e.getMessage() +" : " + e.getStackTrace());
			System.out.println("Exception " + e.getMessage());
			System.out.println("Exception " + e.getStackTrace());
		}
		
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test case Failed");
		test.fail(result.getThrowable());	
		
		try 
		{		
			String path = takeScreenshot(driver, "Fail/" + result.getInstanceName() + "/" + result.getMethod().getMethodName());		
			test.addScreenCaptureFromPath(path, result.getMethod().getMethodName());		
		}
		catch(Exception e)
		{
			log.fatal("Exception in onTestFailure Method of Listeners class");
			log.fatal(e.getMessage() +" : " + e.getStackTrace());
			System.out.println("Exception " + e.getMessage());
			System.out.println("Exception " + e.getStackTrace());
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extentReport.flush();
		
	}
	

}
