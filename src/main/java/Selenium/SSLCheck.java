package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SSLCheck {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
//        options.setAcceptInsecureCerts(true);
//        options.setHeadless(true);
//        We can include any browser extension also using ChromeOptions object
//        options.addExtensions(""):
//        Like below we can configure the proxy

        Proxy proxy = new Proxy();
        proxy.getHttpProxy("ipaddress:4040");
        options.setCapability("proxy", proxy);

        // To set download folder path
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", System.getProperty("user.dir"));


/*
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        EdgeOptions edgeOptions = new EdgeOptions();
        SafariOptions safariOptions = new SafariOptions();
        options.setHeadless(true);
        firefoxOptions.setAcceptInsecureCerts(true);
        edgeOptions.setAcceptInsecureCerts(true);
        safariOptions.setAcceptInsecureCerts(true);
*/
        System.setProperty("webdriver.chrome.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/chromedriver");
        WebDriver driver = new ChromeDriver(options);
/*
        FirefoxDriver firefoxDriver = new FirefoxDriver(firefoxOptions);
        EdgeDriver edgeDriver = new EdgeDriver(edgeOptions);
        SafariDriver safariDriver = new SafariDriver();
*/
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        driver.quit();
    }
}