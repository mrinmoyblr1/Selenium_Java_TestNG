package Selenium;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Practice_Assignment_002 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/chromedriver");
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.findElement(By.name("name")).sendKeys("Mrinmoy Biswas");
        driver.findElement(By.name("email")).sendKeys("mrinmoy.blr@gmail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("exampleCheck1")).click();

        Select dropdown = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
        dropdown.selectByVisibleText("Male");
        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.name("bday")).sendKeys("11/30/2025");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//input[@value='Submit']")).click();
        System.out.println(driver.findElement(By.className("alert-success")).getText());
        System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());


        


        driver.quit();
    }
}
