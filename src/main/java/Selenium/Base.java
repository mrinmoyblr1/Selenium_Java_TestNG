package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class Base {
    public static void main(String[] args) throws InterruptedException {

        //String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot","Beans"};
        String[] itemsNeeded = {"Beans"};
        List itemNeededList = Arrays.asList(itemsNeeded);


        for (int i = 0; i < itemNeededList.size(); i++) {
            System.out.println(itemNeededList.get(i));
        }

        System.setProperty("webdriver.chrome.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        int flag = 0;
        System.out.println(itemNeededList.size());
        System.out.println(products.size());


        for (int i = 0; i < products.size(); i++) {
            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();
            System.out.println("=====" + i);


            if (itemNeededList.contains(formattedName)) {
                driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
                flag = flag + 1;
                if (flag == itemNeededList.size() - 1) {
                    break;
                }
            }
        }


//        for (WebElement product : allProducts) {//
//            for (int i = 0; i < itemsNeeded.length; i++) {//
//                if (product.getText().contains(itemsNeeded[i])) {
//                    driver.findElement(By.xpath("//button[text()=\"ADD TO CART\"]")).click();
//                    System.out.println(product.getText());
//                    break;
//                }
//            }
//        }


        // XPath to click on "ADD TO CART"
        //*[contains(text(), 'Cucumber')]/following-sibling::div[2]/button

        Thread.sleep(2000);
        driver.quit();
    }
}
