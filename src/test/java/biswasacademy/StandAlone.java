package biswasacademy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

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

        Thread.sleep(2000);


        List<WebElement> products = driver.findElements(By.className("card-body"));

        WebElement prod = products.stream().filter(product -> product.findElement(By.cssSelector("b"))
                .getText().equalsIgnoreCase("ADIDAS ORIGINAL")).findFirst().orElse(null);

        //prod.findElement(By.cssSelector(".card-body button:first-of-type")).click(); // Here :first-of-type is used to select the first button (Add to Wishlist)
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click(); // Here :last-of-type is used to select the last button (Add to Cart)




        Thread.sleep(6000);
        driver.quit();
    }


}
