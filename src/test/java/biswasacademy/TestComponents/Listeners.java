package biswasacademy.TestComponents;

import biswasacademy.resources.ExtentReporterNG;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners implements ITestListener {
    WebDriver driver = null;
    BaseTest baseTest = new BaseTest();

    ExtentReports extent = ExtentReporterNG.getReportObject();
    ExtentTest test;
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);  // Unique thread ID(ErrorValidationTest) -> test will be attached with Reports
    }


    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test Passed");
    }


    @Override
    public void onTestFailure(ITestResult result) {
//        System.out.println("Test failed:.......... " + result.getName());
//        test.fail("Test Failed");
//        extentTest.get().log(Status.FAIL, "Test Failed"); // Unique thread ID(ErrorValidationTest) will be called
//        test.fail(result.getThrowable()); // It will print error details in Report
        extentTest.get().fail(result.getThrowable());


        //The code below will handle the driver from the Test class
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        // Taking a screenshot here and attaching it to Reports
        String filePath;
        try {
            filePath = baseTest.getScreenShot(result.getMethod().getMethodName(), driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
    }



    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        extent.flush();
    }
}
