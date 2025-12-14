package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Practice_Assignment_006 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.cssSelector("#checkBoxOption2")).click();
        String checkBoxName = driver.findElement(By.cssSelector("label[for='benz']")).getText();
        System.out.println(checkBoxName);
        Select dropdown = new Select(driver.findElement(By.cssSelector("#dropdown-class-example")));
        dropdown.selectByVisibleText(checkBoxName);
        driver.findElement(By.cssSelector("#name")).sendKeys(checkBoxName);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#alertbtn")).click();
        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        boolean exists = alertText.toLowerCase().contains(checkBoxName.toLowerCase());
        System.out.println(exists); // Output: true
        Thread.sleep(4000);
        System.out.println("Press any key to continue...");
        driver.quit();
    }
}
