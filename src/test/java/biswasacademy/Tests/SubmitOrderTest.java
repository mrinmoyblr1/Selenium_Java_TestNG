package biswasacademy.Tests;

import biswasacademy.TestComponents.BaseTest;
import biswasacademy.pageObjects.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public class SubmitOrderTest extends BaseTest {
    String productName = "ZARA COAT 3";

    @Test(dataProvider = "getData", groups = {"Purchase"})
    public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {
        System.out.println("submitOrder Test");

        ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
        productCatalogue.addProductToCart(input.get("product"));

        CartPage cartPage = productCatalogue.goToCartPage();
        boolean match = cartPage.verifyProductDisplaying(input.get("product"));
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
        HashMap<String, String> map = new HashMap<>();
        map.put("email", "mrinmoy.blr@gmail.com");
        map.put("password", "Anjali@12");
        map.put("product", "ZARA COAT 3");


        return new Object[][]{
                {map},
                {"mrinmoy.blr@gmail.com", "Anjali@12", "ADIDAS ORIGINAL"},
                {"mrinmoy.blr@gmail.com", "Anjali@12", "iphone 13 pro"}
        };
    }

}
