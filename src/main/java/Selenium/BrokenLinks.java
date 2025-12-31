package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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


        String url = driver.findElement(By.cssSelector("a[href*='broken']")).getDomAttribute("href");
        System.out.println(url);

        // To get status code  from any END POINT/URL:
        HttpsURLConnection conn = (HttpsURLConnection) new URL(url).openConnection();
        conn.setRequestMethod("HEAD");
        conn.connect();
        int responseCode = conn.getResponseCode();

        System.out.println(responseCode);

        List<WebElement> element = driver.findElements(By.cssSelector("a[href*='http']"));
        for (WebElement link : element) {
            System.out.println(link.getDomAttribute("href"));
        }


        Thread.sleep(2000);
        driver.quit();
    }
}
