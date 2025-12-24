package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Practice_Assignment_008 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.cssSelector("#autocomplete")).sendKeys("uni");
        List<WebElement> allContry = driver.findElements(By.cssSelector("#ui-id-1 li"));
        Thread.sleep(2000);
        for (WebElement contry : allContry) {
            if (contry.getText().trim().equals("United States (USA)")) {
                System.out.println(contry.getText());
                contry.click();
                break;
            }
        }
        Thread.sleep(2000);
        driver.quit();
    }
}
