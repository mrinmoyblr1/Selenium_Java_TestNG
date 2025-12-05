package Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
public class UpdatedDropdown_Practice {
    public static void main(String[] args) throws InterruptedException {
        String name = "Mrinmoy";
        System.setProperty("webdriver.chrome.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/chromedriver");
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("checkBoxOption1")).click();
        Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
        Thread.sleep(4000);
        driver.findElement(By.id("checkBoxOption1")).click();
        Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
        Thread.sleep(9000);
        driver.quit();
    }
}
