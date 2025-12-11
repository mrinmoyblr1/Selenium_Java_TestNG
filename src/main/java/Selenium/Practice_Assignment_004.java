package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Practice_Assignment_004 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("a[href*='windows']")).click();
        driver.findElement(By.cssSelector("a[href*='windows/new']")).click();
        String parentID = driver.getWindowHandle();
        Set<String> allwindows = driver.getWindowHandles();
        for (String windowID : allwindows) {
            if (!windowID.equals(parentID)) {
                driver.switchTo().window(windowID);
                break;
            }
        }
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.cssSelector("h3")).getText());
        driver.switchTo().window(parentID);
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.cssSelector("h3")).getText());
        driver.quit();
    }
}
