package Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
public class frameTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/chromedriver");
        WebDriver driver = new ChromeDriver();
//        WebDriver driver = new FirefoxDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
        // We can switch to Frame using index also
//        driver.switchTo().frame(0);
        driver.findElement(By.cssSelector("#draggable")).click();
        System.out.println(driver.findElement(By.cssSelector("#draggable")).getText());
        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.cssSelector("#draggable"));
        WebElement target = driver.findElement(By.cssSelector("#droppable"));
        actions.dragAndDrop(source, target).build().perform();
// To come back from iframe we need to use defaultContent()
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.cssSelector(".entry-title")).getText());
//
        Thread.sleep(2000);
        driver.quit();
    }
}
