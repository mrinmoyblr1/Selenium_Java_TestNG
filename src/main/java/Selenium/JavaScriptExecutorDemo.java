package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class JavaScriptExecutorDemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

        List<WebElement> ss = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        int a = 0;
        for (WebElement e : ss) {
            a = a + Integer.parseInt(e.getText());
        }

        System.out.println(a);
        String bb = driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim();
        System.out.println(bb);

        Assert.assertEquals(Integer.parseInt(bb), a);


        Thread.sleep(3000);
        driver.quit();
    }
}
