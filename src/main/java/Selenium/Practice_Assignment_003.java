package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Practice_Assignment_003 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise//");
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        driver.findElement(By.cssSelector("#username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("#password")).sendKeys("learning");
        driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#okayBtn")));
        driver.findElement(By.cssSelector("#okayBtn")).click();

        Select dropdown = new Select(driver.findElement(By.cssSelector("select.form-control")));
        Thread.sleep(2000);
        dropdown.selectByVisibleText("Consultant");
        driver.findElement(By.cssSelector("#terms")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#signInBtn")));
        driver.findElement(By.cssSelector("#signInBtn")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card.h-100")));
        List<WebElement> alllProducts = driver.findElements(By.cssSelector(".card.h-100"));
        for (WebElement product : alllProducts) {
            product.findElement(By.cssSelector("button[class='btn btn-info']")).click();
        }

        driver.findElement(By.cssSelector("a[class*='nav-link btn btn-primary']")).click();
        driver.quit();
    }
}
