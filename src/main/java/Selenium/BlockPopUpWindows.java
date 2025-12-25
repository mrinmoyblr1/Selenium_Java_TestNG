package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class BlockPopUpWindows {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/chromedriver");
        ChromeOptions options = new ChromeOptions();

        // 1. Create a map to store preferred settings
        Map<String, Object> prefs = new HashMap<String, Object>();

        // 0 = Default, 1 = Allow, 2 = Block
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs.put("profile.default_content_settings.popups", 0);

        // 2. Add the preferences to ChromeOptions
        options.setExperimentalOption("prefs", prefs);

        // 3. Optional: Disable info bars and extensions
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://example.com");
        Thread.sleep(2000);
        driver.quit();
    }
}
