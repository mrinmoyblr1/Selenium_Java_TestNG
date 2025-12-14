package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Scope {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElements(By.cssSelector("a")).size());
        System.out.println(driver.findElements(By.tagName("a")).size());
        // Creating subset of a driver specific ti footer section
        // Limiting WebDriver scope
        WebElement footerDriver = driver.findElement(By.cssSelector(".gf-t"));
        System.out.println(footerDriver.findElements(By.tagName("a")).size());
        WebElement columnDriver = footerDriver.findElement(By.cssSelector("ul"));
        System.out.println(columnDriver.findElements(By.cssSelector("a")).size());
        Thread.sleep(6000);
        String osName = System.getProperty("os.name").toLowerCase();
        for (int i = 0; i < columnDriver.findElements(By.cssSelector("a")).size(); i++) {
            // Use Command for Mac, Control for everything else (Windows, Linux, etc.)
            if (osName.contains("mac")) {
//                System.out.println("Using Keys.COMMAND for Mac.");
                String clickOnLinkTab = Keys.chord(Keys.COMMAND, Keys.ENTER);
                columnDriver.findElements(By.cssSelector("a")).get(i).sendKeys(clickOnLinkTab);
            } else {
//                System.out.println("Using Keys.CONTROL for Windows/Linux.");
                String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
                columnDriver.findElements(By.cssSelector("a")).get(i).sendKeys(clickOnLinkTab);
            }
        }
        
        Set<String> abc = driver.getWindowHandles();
        Iterator<String> it = abc.iterator();
        while (it.hasNext()) {
            String key = it.next();
            driver.switchTo().window(key);
            System.out.println("Title: " + driver.getTitle());
        }
//            // Like this we can click on Back Button in browser
//            driver.navigate().back();
        Thread.sleep(2000);
        driver.quit();
    }
}
