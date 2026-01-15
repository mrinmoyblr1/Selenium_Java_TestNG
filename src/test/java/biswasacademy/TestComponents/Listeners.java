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

    ExtentReports extent = ExtentReporterNG.getReportObject();
    ExtentTest test;
    BaseTest baseTest = new BaseTest();
    WebDriver driver = null;


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


        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e1) {
            e1.printStackTrace();
        }


        // Taking Screenshot here and attached with Reports
        String filePath;
        try {
            filePath = baseTest.getScreenShot(result.getMethod().getMethodName(), driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
    }


    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        extent.flush();
    }


}
