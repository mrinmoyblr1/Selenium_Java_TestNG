package biswasacademy.EntentReportsD;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReportsTest {
    ExtentReports extent;

    @BeforeTest
    public void config() {
        //ExtentReports, ExtentSparkReporter
        String path = System.getProperty("user.dir") + "/reports/index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Reports");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Biswas Academy");


    }


    @Test
    public void initialDemo() throws InterruptedException {

        ExtentTest test = extent.createTest("Initial Demo").info("Login to RahulShetty Academy");


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/client/#/auth/login");
        System.out.println(driver.getTitle());

        test.fail("Result does not match:  Login Failed");
//        test.addScreenCaptureFromPath(System.getProperty("user.dir") + "/reports/biswas.png");
        //test.addScreenCaptureFromBase64String(System.getProperty("user.dir") + "/reports/biswas.png");

        extent.flush();
        Thread.sleep(3000);
        driver.quit();
    }
}
