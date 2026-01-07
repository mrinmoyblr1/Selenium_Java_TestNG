package TestNGTutorial;

import org.testng.ITestContext;
import org.testng.ITestListener;

// ITestListener interface which implements TestNG listeners
// ITestListener is a listener interface that is used to listen to the events that occur during the execution of the test cases.
// ITestListener interface implements all the methods in the listener class
// We can override the methods we need
public class Listeners implements ITestListener {
    // We can override the methods we need
    @Override
    public void onTestStart(org.testng.ITestResult result) {
        System.out.println("Test started: " + result.getName());
        System.out.println("I successfully executed onTestStart method in Listeners class");
    }

    public void onTestSuccess(org.testng.ITestResult result) {
        System.out.println("Test passed: " + result.getName());
    }

    public void onTestFailure(org.testng.ITestResult result) {
        System.out.println("Test failed:.......... " + result.getName());
        // We can add code here to take screenshot on failure, log the failure, etc.
        // For example, we can use Selenium WebDriver to take screenshot
        // File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // FileUtils.copyFile(src, new File("path/to/screenshot.png"));
        // In case of API, we can log the response or error message
    }

    public void onTestSkipped(org.testng.ITestResult result) {
        System.out.println("Test skipped: " + result.getName());
    }

    public void onTestFailedButWithinTestResult(org.testng.ITestResult result) {
        System.out.println("Test failed but within success percentage: " + result.getName());
    }

    public void onStart(ITestContext context) {
        System.out.println("Test suite started: " + context.getName());
    }

    public void onFinish(ITestContext context) {
        System.out.println("Test suite finished: " + context.getName());
    }
}
