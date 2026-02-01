//package biswasacademy.stepDefinitions;
//
//import biswasacademy.TestComponents.BaseTest;
//import biswasacademy.pageObjects.ConfirmationPage;
//import biswasacademy.pageObjects.LandingPage;
//import biswasacademy.pageObjects.ProductCatalogue;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.testng.Assert;
//
//import java.io.IOException;
//
//public class StepDefinitionsImp extends BaseTest {
//    public LandingPage landingPage;
//    ProductCatalogue productCatalogue;
//    ConfirmationPage confirmationPage;
//
//
//    @Given("I landed on Ecommerce Page")
//    public void I_landed_on_Ecommerce_Page() throws IOException {
//        landingPage = launchApplication();
//
//    }
//
//
//    @Given("Logged in with username {string} and password {string}")
//    public void Logged_in_with_username_and_password(String username, String password) {
//        productCatalogue = landingPage.loginApplication(username, password);
//    }
//
//
//    @When("I add product {string} to Cart")
//    public void I_add_product_to_Cart(String productName) throws InterruptedException {
//        productCatalogue.addProductToCart(productName);
//    }
//
//
////    @And("Checkout {string} and Submit the order")
////    public void checkout_and_submit_the_order(String string) throws InterruptedException {
////        CartPage cartPage = productCatalogue.goToCartPage();
////
////        boolean match = cartPage.verifyProductDisplaying(string);
////        Assert.assertTrue(match);
////
////        CheckoutPage checkoutPage = cartPage.goToCheckOut();
////        checkoutPage.selectCountry("India");
////
////        confirmationPage = checkoutPage.submitOrder();
////
////    }
//
//
//
//
//    @When("I add product productName to Cart")
//    public void i_add_product_product_name_to_cart() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @When("Checkout productName and Submit the order")
//    public void checkout_product_name_and_submit_the_order() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//
//
//
//
//
//
//    @Then("{string} message is displayed on Confirmation page")
//    public void message_is_displayed_Confirmation_page(String message) {
//        String confirmation = confirmationPage.getConfirmationMessage();
//        System.out.println(confirmation);
//        Assert.assertTrue(confirmation.equalsIgnoreCase(message));
//
//    }
//
//
//}
//
//
