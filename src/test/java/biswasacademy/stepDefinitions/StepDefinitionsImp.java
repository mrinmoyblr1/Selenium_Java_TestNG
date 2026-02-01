package biswasacademy.stepDefinitions;

import biswasacademy.TestComponents.BaseTest;
import biswasacademy.pageObjects.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;

public class StepDefinitionsImp extends BaseTest {
    public LandingPage landingPage;
    ProductCatalogue productCatalogue;
    ConfirmationPage confirmationPage;


    @Given("I landed on Ecommerce Page")
    public void I_landed_on_Ecommerce_Page() throws IOException {
        landingPage = launchApplication();

    }

    @Given("Logged in with username {string} and password {string}")
    public void Logged_in_with_username_and_password(String username, String password) {
        productCatalogue = landingPage.loginApplication(username, password);
    }


    @When("I add product {string} to Cart")
    public void I_add_product_to_Cart(String productName) throws InterruptedException {
        productCatalogue.addProductToCart(productName);
    }


    @When("Checkout {string} and Submit the order")
    public void Checkout_productName_and_Submit_the_order(String string) throws InterruptedException {


        CartPage cartPage = productCatalogue.goToCartPage();

        boolean match = cartPage.verifyProductDisplaying(string);
        Assert.assertTrue(match);

        CheckoutPage checkoutPage = cartPage.goToCheckOut();
        checkoutPage.selectCountry("India");

        confirmationPage = checkoutPage.submitOrder();
    }


}


