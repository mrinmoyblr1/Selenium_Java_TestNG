package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class ActionsDemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/chromedriver");
        WebDriver driver = new ChromeDriver();
//        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
        Actions a = new Actions(driver);
        WebElement move = driver.findElement(By.cssSelector("a[data-nav-ref='nav_ya_signin']"));
        //a.moveToElement(driver.findElement(By.cssSelector("#twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("book").build().perform();
        a.moveToElement(driver.findElement(By.cssSelector("#twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("book").doubleClick().build().perform();
        Thread.sleep(5000);
        a.moveToElement(move).build().perform();
        a.moveToElement(move).contextClick().build().perform();  //contextClick for right CLICK
//        a.moveToElement(move)
//
        Thread.sleep(5000);
        driver.quit();
    }
}
