package biswasacademy.TestComponents;

import biswasacademy.resources.ExtentReporterNG;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    ExtentReports extent = ExtentReporterNG.getReportObject();
    ExtentTest test;


    @Override
    public void onTestStart(ITestResult result) {
        //ExtentTest test = extent.createTest(result.getName()).info("Login to RahulShetty Academy");
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed");
        test.pass("Test Passed");
    }


    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed:.......... " + result.getName());
        test.fail("Test Failed");
        test.fail(result.getThrowable()); // It will print error details in Report
        // Taking Screenshot here
        // Take Screenshot
        // Assached with the Report
        getScreenShot(result.getMethod().getMethodName())
        test.addScreenCaptureFromPath()


    }


    @Override
    public void onTestSkipped(ITestResult result) {
    }


    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }


    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }


    @Override
    public void onStart(ITestContext context) {
    }


    @Override
    public void onFinish(ITestContext context) {
    }


}
