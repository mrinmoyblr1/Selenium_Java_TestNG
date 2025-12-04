package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;
import java.util.List;

public class Base {
    public static void main(String[] args) throws InterruptedException {

        int j = 0;
        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot", "Beans"};
//        String[] itemsNeeded = {"Beans"};
        List itemNeededList = Arrays.asList(itemsNeeded);
        for (int i = 0; i < itemNeededList.size(); i++) {
            System.out.println(itemNeededList.get(i));
        }


//        System.setProperty("webdriver.chrome.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/chromedriver");
//        WebDriver driver = new ChromeDriver();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        System.out.println(itemNeededList.size());
        System.out.println(products.size());


        for (int i = 0; i < products.size(); i++) {
            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();
            System.out.println(formattedName);


            if (itemNeededList.contains(formattedName)) {
                j++;
//                driver.findElement(By.xpath("//*[contains(text(),\"" + formattedName + "\")]/following-sibling::div[2]/button")).click();
//                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if (j == itemNeededList.size()) {
                    break;
                }
            }
        }


//        for (WebElement product : products) {//
//            for (int i = 0; i < itemsNeeded.length; i++) {//
//                if (product.getText().contains(itemsNeeded[i])) {
//                    driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
//                    System.out.println(product.getText());
//                    break;
//                }
//            }
//        }


        // XPath to click on "ADD TO CART"
        //*[contains(text(), 'Cucumber')]/following-sibling::div[2]/button

        Thread.sleep(10000);
        driver.quit();
    }
}
