package Selenium;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Miscellaneous {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/chromedriver");

        // Opening Chrome browser in incognito
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        // 3. Delete all cookies for the current domain
        driver.manage().deleteAllCookies();
        // 3. Delete any specific cookie for the current domain
        driver.manage().deleteCookieNamed("JSESSIONID");
        // 4. Refresh the page to ensure a clean session
        driver.navigate().refresh();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Need to cast driver to TakesScreenshot
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // 3. Move image file to a destination folder
        File destFile = new File("./screenshots/test_screenshot.png");
        FileUtils.copyFile(src, destFile);


        Thread.sleep(2000);
        driver.quit();
    }
}
