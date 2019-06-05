package kovair.JenkinsIntegration;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class JenkinsIntegrationExtentReport {
	
	ExtentReports extent;
    ExtentTest test;
    ExtentHtmlReporter htmlReporter;
	
	
	@org.testng.annotations.BeforeTest
	public  void BeforeTest()
	{
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS", "Windows");
        extent.setSystemInfo("Browser", "Chrome");
        
        //configuration items to change the look and feel
        //add content, manage tests etc
        //htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Extent Report Demo");
        htmlReporter.config().setReportName("Test Report");
        //htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        //htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		
	}
	
	@Test
	public void Test1()
	{
		test = extent.createTest("Test Case 1", "Passed test case");
        Assert.assertTrue(true);
	}
	
	@Test
	public void Test2()
	{
		test = extent.createTest("Test Case 2", "Failed test case");
        Assert.assertTrue(false);
	}
	
	
	@AfterMethod
	public void afterMethod(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
            test.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
        }
        else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
	}
	
	@org.testng.annotations.AfterTest
	public void AfterTest()
	{
		extent.flush();
	}

}
