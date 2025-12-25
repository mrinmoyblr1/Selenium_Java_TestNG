package Selenium;


import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SSLCheck {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();

        // Handle SSL Certification
        options.setAcceptInsecureCerts(true);
//        options.setHeadless(true);
//        We can include any browser extension also using ChromeOptions object
//        options.addExtensions(""):

//        Like below we can configure the proxy
        // 1. Define the proxy server string (IP:Port)
        String proxyAddress = "123.456.7.89:8080";

        // 2. Create the Selenium Proxy object
        Proxy proxy = new Proxy();
        proxy.setHttpProxy(proxyAddress);
        proxy.setSslProxy(proxyAddress); // For HTTPS sites

        // 3. Pass the proxy into Browser Options
        options.setProxy(proxy);


        // To set download folder path
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", System.getProperty("user.dir"));
        options.setExperimentalOption("prefs", prefs);

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
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        driver.quit();
    }
}