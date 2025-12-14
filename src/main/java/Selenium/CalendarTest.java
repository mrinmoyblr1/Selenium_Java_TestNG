package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class CalendarTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        String monthNumber = "6";
        String date = "15";
        String year = "2027";

        driver.findElement(By.cssSelector(".react-date-picker__inputGroup__input.react-date-picker__inputGroup__year")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText.react-calendar__navigation__label__labelText--from")).click();

        driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText.react-calendar__navigation__label__labelText--from")).click();

        WebElement yearClick = driver.findElement(By.cssSelector(".react-calendar__decade-view"));
        System.out.println(yearClick.findElements(By.cssSelector("button")).size());
        Thread.sleep(2000);

        for (int i = 0; i < yearClick.findElements(By.cssSelector("button")).size(); i++) {
            System.out.println("=========");
            String ss = yearClick.findElements(By.cssSelector("button")).get(i).getText();
            System.out.println(ss);
            Thread.sleep(2000);
            if (yearClick.findElements(By.cssSelector("button")).get(i).getText().equals(year)) {
                System.out.println("Year:" + year);
                Thread.sleep(2000);
                yearClick.findElements(By.cssSelector("button")).get(i).click();
                Thread.sleep(6000);
            }
        }


        Thread.sleep(3000);
        driver.quit();
    }
}
