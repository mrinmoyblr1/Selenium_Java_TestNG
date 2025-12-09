package Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
public class WindowHandles {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        String parentWindow = driver.getWindowHandle();
        driver.findElement(By.cssSelector(".blinkingText")).click();

        Set<String> allWindows = driver.getWindowHandles();
// 4. Switch to child window
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        System.out.println("Child window title: " + driver.getTitle());
        String Emaill_ID = driver.findElement(By.cssSelector("a[href*='mailto:mentor']")).getText();
        System.out.println(Emaill_ID);
        Thread.sleep(9000);

        driver.switchTo().window(parentWindow);
        driver.findElement(By.cssSelector("#username")).sendKeys(Emaill_ID);
        Thread.sleep(9000);
        driver.quit();
    }
}
