package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class Filters {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        // Provide filter text in search box
        driver.findElement(By.id("search-field")).sendKeys("Rice");

        List<WebElement> veggies = driver.findElements(By.xpath("//tbody/tr/td[1]"));

        List<WebElement> filteredList = veggies.stream()
                .filter(veggie -> veggie.getText().contains("Rice"))
                .collect(Collectors.toList());

        Assert.assertEquals(filteredList, veggies);


        Thread.sleep(2000);
        driver.quit();
    }


}
