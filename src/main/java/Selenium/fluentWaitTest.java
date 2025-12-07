package Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;
import java.util.function.Function;
public class fluentWaitTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("button")).click();
        FluentWait<WebDriver> wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
        WebElement ss = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                if (driver.findElement(By.cssSelector("#finish")).isDisplayed()) {
                    return driver.findElement(By.cssSelector("#finish"));
                } else {
                    return null;
                }
            }
        });
        System.out.println(driver.findElement(By.cssSelector("#finish")).isDisplayed());
        Thread.sleep(5000);
        System.out.println(driver.findElement(By.cssSelector("#finish")).getText());
        Thread.sleep(5000);
        driver.quit();
    }
}
