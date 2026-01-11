package biswasacademy.Tests;

import biswasacademy.TestComponents.BaseTest;
import biswasacademy.pageObjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class SubmitOrderTest extends BaseTest {
    String productName = "ZARA COAT 3";

    @Test
    public void submitOrder() throws IOException, InterruptedException {


        ProductCatalogue productCatalogue = landingPage.loginApplication("mrinmoy.blr@gmail.com", "Anjali@12");
        productCatalogue.addProductToCart(productName);

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
    }

    // To verify ZARA COAT 3 is displaying in the order summary page

    @Test(dependsOnMethods = {"submitOrder"})
    public void OrderHistoryTest() throws InterruptedException {
        ProductCatalogue productCatalogue = landingPage.loginApplication("mrinmoy.blr@gmail.com", "Anjali@12");
        OrderPage orderPage = productCatalogue.goToOrdersPage();
        Assert.assertTrue(orderPage.verifyOrderDisplaying(productName));
        Thread.sleep(3000);


    }

}
