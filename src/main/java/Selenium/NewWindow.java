package Selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class NewWindow {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        // Open a new browser window
        driver.switchTo().newWindow(WindowType.WINDOW);
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        String parentWindowId = it.next();
        String childWindowId = it.next();

        // Navigate to a different URL in the new window
        driver.switchTo().window(childWindowId);
        driver.get("https://courses.rahulshettyacademy.com/l/products?sortKey=recommended&sortDirection=asc&page=1");
        Thread.sleep(3000);
        String courseName = driver.findElements(By.xpath("//h2[@data-sentry-element='CardTitle']")).get(0).getText();
        System.out.println(courseName);
        driver.switchTo().window(parentWindowId);
        WebElement name = driver.findElement(By.cssSelector("[name='name']"));
        name.sendKeys(courseName);

        // Take screenshot only for the specific WebElement and save it to a file
        File file = name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("./screenshots/logo.png"));

        // Take screenshot of the entire page and save it to a file
        File file1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file1, new File("./screenshots/logo1.png"));

        // Get Height and Width of the WebElement
        System.out.println(name.getRect().getDimension().getHeight());
        System.out.println(name.getRect().getDimension().getWidth());
        Thread.sleep(2000);
        driver.quit();
    }
}
