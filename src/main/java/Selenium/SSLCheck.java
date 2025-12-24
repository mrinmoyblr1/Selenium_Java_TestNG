package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.time.Duration;
import java.util.List;

public class SSLCheck {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        EdgeOptions edgeOptions = new EdgeOptions();
        SafariOptions safariOptions = new SafariOptions();
//        options.setHeadless(true);
        options.setAcceptInsecureCerts(true);
        firefoxOptions.setAcceptInsecureCerts(true);
        edgeOptions.setAcceptInsecureCerts(true);
        safariOptions.setAcceptInsecureCerts(true);

        System.setProperty("webdriver.chrome.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/chromedriver");
        WebDriver driver = new ChromeDriver(options);
//        FirefoxDriver firefoxDriver = new FirefoxDriver(firefoxOptions);
//        EdgeDriver edgeDriver = new EdgeDriver(edgeOptions);
//        SafariDriver safariDriver = new SafariDriver();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());

        Thread.sleep(2000);
        driver.quit();
    }
}