package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Scope {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/chromedriver");
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        System.out.println(driver.findElements(By.cssSelector("a")).size());
        System.out.println(driver.findElements(By.tagName("a")).size());

        // Creating subset of a driver specific ti footer section
        // Limiting WebDriver scope
        WebElement footerDriver = driver.findElement(By.cssSelector(".gf-t"));
        System.out.println(footerDriver.findElements(By.tagName("a")).size());

        WebElement columnDriver = footerDriver.findElement(By.cssSelector("ul"));
        System.out.println(columnDriver.findElements(By.cssSelector("a")).size());
        Thread.sleep(6000);
        

        for (int i = 0; i < columnDriver.findElements(By.cssSelector("a")).size(); i++) {
//            System.out.println(columnDriver.findElements(By.cssSelector("a")).get(i).getText());
            columnDriver.findElements(By.cssSelector("a")).get(i).click();
            System.out.println(driver.getTitle());

            // Like this we can click on Back Button in browser
            driver.navigate().back();

        }


        Thread.sleep(2000);
        driver.quit();
    }
}
