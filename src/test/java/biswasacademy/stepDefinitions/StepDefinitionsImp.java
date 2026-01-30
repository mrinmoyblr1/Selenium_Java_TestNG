package biswasacademy.stepDefinitions;

import biswasacademy.TestComponents.BaseTest;
import biswasacademy.pageObjects.CartPage;
import biswasacademy.pageObjects.LandingPage;
import biswasacademy.pageObjects.ProductCatalogue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.io.IOException;

public class StepDefinitionsImp extends BaseTest {
    public LandingPage landingPage;
    ProductCatalogue productCatalogue;


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
        CartPage cartPage = productCatalogue.goToCartPage();



    }


}
