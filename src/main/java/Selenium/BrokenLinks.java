package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrokenLinks {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Broken URLs
        // Step 1: Get all the URLs using selenium
        // Java method which will call URLs and get the status codes.
        // If the status code is >400 then URL is not working -> URL is broken associated to the link

        List<WebElement> links = driver.findElements(By.cssSelector("a[href*='https']"));
        SoftAssert a = new SoftAssert();

        for (WebElement link : links) {
            String url = link.getDomAttribute("href");
            System.out.println(url);

            // To get status code  from any END POINT/URL:
            HttpsURLConnection conn = (HttpsURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int responseCode = conn.getResponseCode();
            System.out.println(responseCode);

            a.assertTrue(responseCode < 400, "The link with Text " + link.getText() + " is broken with code " + responseCode);
        }
        a.assertAll();


        Thread.sleep(2000);
        driver.quit();
    }
}
