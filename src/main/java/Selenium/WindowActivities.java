package Selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class WindowActivities {
    public static void main(String[] args) throws InterruptedException {
        String name = "Mrinmoy";
        System.setProperty("webdriver.chrome.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");
        Thread.sleep(1000);
        driver.navigate().to("https://rahulshettyacademy.com");
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().forward();
//        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
//        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
        Thread.sleep(2000);
        driver.quit();
    }
}
