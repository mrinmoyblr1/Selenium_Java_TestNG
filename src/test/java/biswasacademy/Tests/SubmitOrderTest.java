package biswasacademy.Tests;

import biswasacademy.TestComponents.BaseTest;
import biswasacademy.pageObjects.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class SubmitOrderTest extends BaseTest {
    String productName = "ZARA COAT 3";

    @Test(dataProvider = "getData", groups = {"Purchase"})
    public void submitOrder(String email, String password, String productNameFromDataProvider) throws IOException, InterruptedException {
        System.out.println("submitOrder Test");

        ProductCatalogue productCatalogue = landingPage.loginApplication(email, password);
        productCatalogue.addProductToCart(productNameFromDataProvider);

        CartPage cartPage = productCatalogue.goToCartPage();
        boolean match = cartPage.verifyProductDisplaying(productNameFromDataProvider);
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
        System.out.println("Order History Test");
        ProductCatalogue productCatalogue = landingPage.loginApplication("mrinmoy.blr@gmail.com", "Anjali@12");
        OrderPage orderPage = productCatalogue.goToOrdersPage();
        Assert.assertTrue(orderPage.verifyOrderDisplaying(productName));
        Thread.sleep(3000);
    }

    @DataProvider(name = "getData")
    public Object[][] getData() {
        return new Object[][]{
                {"mrinmoy.blr@gmail.com", "Anjali@12", "ZARA COAT 3"},
                {"mrinmoy.blr@gmail.com", "Anjali@12", "ADIDAS ORIGINAL"},
                {"mrinmoy.blr@gmail.com", "Anjali@12", "iphone 13 pro"}
                };
    }

    }
