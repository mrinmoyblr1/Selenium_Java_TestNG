package Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Locators3 {
    public static void main(String[] args) throws InterruptedException {
        String name = "Mrinmoy";
        System.setProperty("webdriver.chrome.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Sibling to Sibling
        // Child to Parent
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
        Thread.sleep(3000);
        driver.quit();
    }
}
