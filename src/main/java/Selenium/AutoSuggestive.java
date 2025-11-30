package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutoSuggestive {
    public static void main(String[] args) throws InterruptedException {
        String name = "Mrinmoy";
        System.setProperty("webdriver.chrome.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        Thread.sleep(2000);
        driver.findElement(By.id("autosuggest")).sendKeys("Ind");
        Thread.sleep(2000);
        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        // it will hold reference of all the matching items
        //XPath:
        //li[@class='ui-menu-item']/a[text()='India']
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase("India")) {
                System.out.println(option.getText());
                option.click();
                break;
            }
        }
        Thread.sleep(2000);
        driver.quit();
    }
}
