package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.Arrays;

public class Locators2 {
    public static void main(String[] args) throws InterruptedException {
        String name = "Mrinmoy";
//        System.setProperty("webdriver.chrome.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/chromedriver");
//        WebDriver driver = new ChromeDriver();
//        System.setProperty("webdriver.gecko.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/geckodriver");
//        WebDriver driver = new FirefoxDriver();
        System.setProperty("webdriver.edge.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/msedgedriver");
        WebDriver driver = new EdgeDriver();
        Locators2 ss = new Locators2();
        String password = ss.getPassword(driver);
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.tagName("p")).getText());
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
//        String firstString = driver.findElement(By.tagName("h2")).getText();
        String firstString = driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();
        String[] newString = firstString.split(" ");
        System.out.println(newString[1].split(",")[0]);
        Assert.assertEquals(newString[1].split(",")[0], name);
        System.out.println(firstString);
        Assert.assertEquals(firstString, "Hello " + name + ",");
        driver.findElement(By.xpath("//button[text()='Log Out']")).click();
        Thread.sleep(3000);
        driver.quit();
    }

    public String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        Thread.sleep(3000);
        String passwordText = driver.findElement(By.cssSelector("form p")).getText();
        String[] passwordArray = passwordText.split("'");
        System.out.println("The password is: " + passwordArray[1]);
        return passwordArray[1];
    }
}
