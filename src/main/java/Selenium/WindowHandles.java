package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandles {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.cssSelector(".blinkingText")).click();


        // Parent Child: Window handles process No: 1
//        String parentWindow = driver.getWindowHandle();
//        Set<String> allWindows = driver.getWindowHandles();
//// 4. Switch to child window
//        for (String windowHandle : allWindows) {
//            if (!windowHandle.equals(parentWindow)) {
//                driver.switchTo().window(windowHandle);
//                break;
//            }
//        }

        // Parent Child: Window handles process No: 2
//        String parentWindow = driver.getWindowHandle();
        Set<String> Windows = driver.getWindowHandles(); //[ParentID, ChildID]
// 4. Switch to child window
        Iterator<String> it = Windows.iterator();
        String parentID = it.next();
        String childID = it.next();
        driver.switchTo().window(childID);


        Thread.sleep(2000);
        System.out.println("Child window title: " + driver.getTitle());
        String Emaill_ID = driver.findElement(By.cssSelector("a[href*='mailto:mentor']")).getText();
        System.out.println(Emaill_ID);
        Thread.sleep(2000);

        driver.switchTo().window(parentID);
        System.out.println("Parent window title: " + driver.getTitle());
        driver.findElement(By.cssSelector("#username")).sendKeys(Emaill_ID);
        Thread.sleep(2000);
        driver.quit();
    }
}
