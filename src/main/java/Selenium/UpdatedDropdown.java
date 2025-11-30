package Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class UpdatedDropdown {
    public static void main(String[] args) throws InterruptedException {
        String name = "Mrinmoy";
        System.setProperty("webdriver.chrome.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/chromedriver");
        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        System.out.println(driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).isSelected());
        Assert.assertFalse(driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).isSelected());
        driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).click();
        System.out.println(driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).isSelected());

//        System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
        System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
        System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style").contains("opacity: 0.5"));
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
        if (driver.findElement(By.id("Div1")).getDomAttribute("style").contains("opacity: 1")) {
            System.out.println("It's  enabled");
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }


        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();

        // Check the total count check boxes in any webpage
//        List<WebElement> options = driver.findElements(By.id("discount-checkbox"));
//        System.out.println(options.size());
//        for (WebElement option : options) {
//            option.click();
//            System.out.println(option.getText());
//        }

        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
        Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox']")).size(), 6);


        // Updated Dropdown handling
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(3000);
//        for (int i = 0; i < 5; i++) {
//            driver.findElement(By.id("hrefIncAdt")).click();
//        }
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        int i = 0;
        while (i < 5) {
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "6 Adult");
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
        driver.findElement(By.xpath("//a[@value='MAA']")).click();
        Thread.sleep(9000);
        driver.quit();
    }
}
