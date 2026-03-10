package biswasacademy.TestComponents;

import biswasacademy.pageObjects.LandingPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    public LandingPage landingPage;
    Properties prop;


    public WebDriver initializeDriver() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/biswasacademy/resources/GlobalData.properties");
        prop.load(fis);

        // Below is Java Ternary operator
        String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
        if (browserName.toLowerCase().contains("chrome")) {

            ChromeOptions options = new ChromeOptions();

            WebDriverManager.chromedriver().setup();


            if (browserName.toLowerCase().contains("headless")) {
                options.addArguments("headless");
            }

            driver = new ChromeDriver(options);
            //driver.manage().window().setSize(new Dimension(2440, 2100)); // We can set the custom window size
            driver.manage().window().maximize();

        }


        else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }


        else if (browserName.equalsIgnoreCase("edge")) {
            System.out.println("Edge is not supported yet");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //driver.manage().window().maximize();
        return driver;
    }


    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
        // Read JSON to String
        String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

        // Convert String to HashMap using Jackson Library
        // Jackson databind
        // ObjectMapper class of a Jackson library is responsible to convert JSON content to Java objects and vice versa
        ObjectMapper mapper = new ObjectMapper();
        // Here we are converting JSON content to List of HashMap
        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;
    }


    @BeforeMethod(alwaysRun = true)
    // Here alwaysRun = true will make sure the @BeforeMethod and @AfterMethod will run for all the tests
    public LandingPage launchApplication() throws IOException {
        driver = initializeDriver();
        landingPage = new LandingPage(driver);
        landingPage.goTo(prop.getProperty("baseUrl"));
        return landingPage;
    }


    @AfterMethod(alwaysRun = true)
    // Here alwaysRun = true will make sure the @BeforeMethod and @AfterMethod will run for all the tests
    public void tearDown() {
        driver.close();
    }


    //Code to take Screenshot
    public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "screenshots/" + testCaseName + ".png");
        FileUtils.copyFile(source, file);
        return file.getAbsolutePath();
    }


}
