package biswasacademy;

import biswasacademy.pageObjects.LandingPage;
import biswasacademy.pageObjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class SubmitOrderTest {
    public static void main(String[] args) throws InterruptedException {
        String productName = "ZARA COAT 3";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        LandingPage landingPage = new LandingPage(driver);
        landingPage.goTo();
        landingPage.loginApplication("mrinmoy.blr@gmail.com", "Anjali@12");

        //=======================================================
        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        List<WebElement> products = productCatalogue.getProductList();
        //=======================================================

        productCatalogue.addProductToCart(productName);


        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();



        List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
        boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
        System.out.println(match);
        Assert.assertTrue(match);


        driver.findElement(By.cssSelector("li[class='totalRow'] button[type='button']")).click();
        Actions a = new Actions(driver);
        a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
        driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
        // This is a very important cssSelector
        //    .ta-item:nth-of-type(2)
        // Below is a alternative xPath selector
        //    //button[contains(@class,'ta-item')][2]
        driver.findElement(By.cssSelector(".action__submit")).click();
        String confirmation = driver.findElement(By.cssSelector(".hero-primary")).getText();
        System.out.println(confirmation);
        Assert.assertTrue(confirmation.equalsIgnoreCase("Thankyou for the order."));
        Thread.sleep(2000);
        driver.quit();
    }
}
