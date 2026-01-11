package biswasacademy;

import biswasacademy.pageObjects.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class SubmitOrderTest {
    public static void main(String[] args) throws InterruptedException {
        String productName = "ZARA COAT 3";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        LandingPage landingPage = new LandingPage(driver);
        landingPage.goTo();
        ProductCatalogue productCatalogue = landingPage.loginApplication("mrinmoy.blr@gmail.com", "Anjali@12");

        List<WebElement> products = productCatalogue.getProductList();

        productCatalogue.addProductToCart(productName);

        Thread.sleep(4000);
        CartPage cartPage = productCatalogue.goToCartPage();


        boolean match = cartPage.verifyProductDisplaying(productName);
        Assert.assertTrue(match);

        CheckoutPage checkoutPage = cartPage.goToCheckOut();


        checkoutPage.selectCountry("India");
        ConfirmationPage confirmationPage = checkoutPage.submitOrder();


        String confirmation = confirmationPage.getConfirmationMessage();
        System.out.println(confirmation);
        Assert.assertTrue(confirmation.equalsIgnoreCase("Thankyou for the order."));
        Thread.sleep(2000);
        driver.quit();
    }
}
