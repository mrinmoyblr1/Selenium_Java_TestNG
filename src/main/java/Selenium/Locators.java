package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Locators {
    public static void main(String[] args) throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/chromedriver");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        System.setProperty("webdriver.gecko.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("Mrinmoy");
        driver.findElement(By.name("inputPassword")).sendKeys("Biswas");
        driver.findElement(By.className("signInBtn")).click();
//        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(3000);
        String validationText = driver.findElement(By.cssSelector("p.error")).getText();
        //        String ss = driver.findElement(By.cssSelector("p[class='error']")).getText();
        System.out.println(validationText);
        driver.findElement(By.linkText("Forgot your password?")).click();
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Mrinmoy Biswas");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("mrinmoy.blr@gmail.com,");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("mrinmoy.blr@gmail.com,");
//        driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("9998887777");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("9998887777");
        //Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".reset-pwd-btn")));
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());
//        driver.findElement(By.cssSelector(".go-to-login-btn")).click();
        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#chkboxTwo")).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
        System.out.println("Done");
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.xpath("//h1")).getText());
        Thread.sleep(3000);
        driver.quit();
    }
}
