package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Practice_Assignment_007 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        int rowCount = driver.findElements(By.cssSelector("[name='courses'] tr")).size();
        int columnCount = driver.findElements(By.cssSelector("[name='courses'] th")).size();
        System.out.println("rows: " + rowCount);
        System.out.println("columns: " + columnCount);
        String secondRowData = driver.findElement(By.cssSelector("[name='courses'] tr:nth-child(3)")).getText();
        System.out.println("Second row data: " + secondRowData);


        driver.quit();
    }
}
