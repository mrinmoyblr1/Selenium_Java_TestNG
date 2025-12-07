package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class fluentWaitTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.cssSelector("button")).click();



        FluentWait<WebDriver> wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(30))
                        .pollingEvery(Duration.ofSeconds(3))


        driver.quit();
    }
}
