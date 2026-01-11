package biswasacademy.Tests;

import biswasacademy.TestComponents.BaseTest;
import biswasacademy.pageObjects.CartPage;
import biswasacademy.pageObjects.ProductCatalogue;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ErrorValidationsTest extends BaseTest {
    @Test
    public void loginErrorValidation() {

        landingPage.loginApplication("mrinmoy.blr@gmail.com", "Anjali@1212");
        Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
        System.out.println("Error message displayed" + ": " + landingPage.getErrorMessage());
    }


    @Test
    public void productErrorValidation() throws IOException, InterruptedException {
        String productName = "ZARA COAT 3";

        ProductCatalogue productCatalogue = landingPage.loginApplication("mrinmoy.blr@gmail.com", "Anjali@12");
        productCatalogue.addProductToCart(productName);

        CartPage cartPage = productCatalogue.goToCartPage();
        boolean match = cartPage.verifyProductDisplaying("ZARA COAT 4");
        Assert.assertFalse(match);
    }


}
