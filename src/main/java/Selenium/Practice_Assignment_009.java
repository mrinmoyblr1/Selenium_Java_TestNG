package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Practice_Assignment_009 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.name("radioButton")).click();
        // Example in Java with Selenium
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Locate the element first
        WebElement element = driver.findElement(By.name("radioButton"));
        // Execute script to return the 'value' attribute
        String text = (String) js.executeScript("return arguments[0].value;", element);
        System.out.println("Field value: " + text);

//        Extracting Static Text (innerText or textContent)
//        If we are trying to get the text from a <div>, <span>, or <label>, we should use innerText.
        WebElement tableValues = driver.findElement(By.className("table-display"));
        String divText = (String) js.executeScript("return arguments[0].innerText;", tableValues);
        System.out.println(divText);
        String divText1 = (String) js.executeScript("return arguments[0].textContent", tableValues);
        System.out.println(divText1);


        Thread.sleep(2000);
        driver.quit();
    }
}
