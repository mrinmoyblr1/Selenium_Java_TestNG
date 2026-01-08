package biswasacademy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class StandAlone {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://rahulshettyacademy.com/client/#/auth/login");
        System.out.println(driver.getTitle());


        driver.findElement(By.id("userEmail")).sendKeys("mrinmoy.blr@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Anjali@12");
        driver.findElement(By.id("login")).click();


        Thread.sleep(3000);
        driver.quit();
    }


}
