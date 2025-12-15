package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class CalendarTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        String monthNumber = "6";
        String date = "15";
        String year = "2027";
        String[] expectedList = {monthNumber, date, year};

        driver.findElement(By.cssSelector(".react-date-picker__inputGroup__input.react-date-picker__inputGroup__year")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText.react-calendar__navigation__label__labelText--from")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText.react-calendar__navigation__label__labelText--from")).click();
        driver.findElement(By.xpath("//button[text()='" + year + "']")).click();
        Thread.sleep(6000);
//        driver.findElements(By.xpath(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumber) - 1).click();
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumber) - 1).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//abbr[text()='" + date + "']")).click();
        List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
        for (int i = 0; i < actualList.size(); i++) {
            System.out.println(actualList.get(i).getAttribute("value"));
            // This is very important
            // Here we are dynamically comparing values between two Lists
            Assert.assertEquals(actualList.get(i).getAttribute("value"), expectedList[i]);
        }
        Thread.sleep(3000);
        driver.quit();
    }
}
