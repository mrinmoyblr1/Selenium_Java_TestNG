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
        driver.findElement(By.id("search-field")).sendKeys("an");
        List<WebElement> veggies = driver.findElements(By.xpath("//tbody//tr/td[1]"));

        // Here collect(Collectors.toList()) and toList() both are doing the same job
        List<WebElement> filteredList = veggies.stream()
                .filter(veggie -> veggie.getText().contains("an")).toList();
//        List<WebElement> filteredList = veggies.stream().filter(veggie -> veggie.getText().contains("an")).collect(Collectors.toList());
        Assert.assertEquals(veggies.size(), filteredList.size());

        Thread.sleep(2000);
        driver.quit();
    }
}
