package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class LiveDemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        // Click on columns button
        driver.findElement(By.xpath("//*[contains(text(),'Veg/fruit name')]")).click();

        // Capture all the WebElements into a list
        List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));

        // Capture the Text of each WebElement into another list
        // Below mentioned two lines do the same job
        List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());
        List<String> originalList1 = elementsList.stream().map(WebElement::getText).toList();

        // Sort in the list -> Sorted List
        List<String> sortedList = originalList1.stream().sorted().toList();

        // Compare original list vs sorted list
        Assert.assertEquals(sortedList, originalList);



        


        Thread.sleep(2000);
        driver.quit();
    }
}
