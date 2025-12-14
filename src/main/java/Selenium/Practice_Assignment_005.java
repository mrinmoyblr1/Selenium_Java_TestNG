package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Practice_Assignment_005 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/chromedriver");
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com");
        driver.findElement(By.cssSelector("a[href*='nested']")).click();
        driver.switchTo().frame(driver.findElement(By.cssSelector("[src*='top']")));
        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-middle']")));
        System.out.println(driver.findElement(By.cssSelector("#content")).getText());
        Thread.sleep(2000);
        driver.quit();
    }
}
