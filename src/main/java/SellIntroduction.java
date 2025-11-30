import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SellIntroduction {
    public static void main(String[] args) throws InterruptedException {

        // Chrome
//        System.setProperty("webdriver.chrome.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/chromedriver");
//        WebDriver driver = new ChromeDriver();
//         Selenium Manager

        // Firefox
//        System.setProperty("webdriver.gecko.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/geckodriver");
//        WebDriver driver = new FirefoxDriver();

        // Edge
        System.setProperty("webdriver.edge.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/msedgedriver");
        WebDriver driver = new EdgeDriver();


        driver.get("https://rahulshettyacademy.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        Thread.sleep(10000);
        driver.close();
        driver.quit();
        //

    }
}
