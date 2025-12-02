package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class Base {
    public static void main(String[] args) throws InterruptedException {
        String text = "Mrinmoy";
        String[] itemsNeeded = {"Cucumber", "Brocolli"};
        List itemNeededList = Arrays.asList(itemsNeeded);



        System.setProperty("webdriver.chrome.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");


        List<WebElement> allProducts = driver.findElements(By.cssSelector("h4.product-name"));
        for (WebElement product : allProducts) {

            for (int i = 0; i < itemsNeeded.length; i++) {

                if (product.getText().contains(itemsNeeded[i])) {
                    driver.findElement(By.xpath("//button[text()=\"ADD TO CART\"]")).click();
                    System.out.println(product.getText());
                    break;
                }
            }
        }


        // XPath to click on "ADD TO CART"
        //*[contains(text(), 'Cucumber')]/following-sibling::div[2]/button

        Thread.sleep(5000);
        driver.quit();
    }
}
