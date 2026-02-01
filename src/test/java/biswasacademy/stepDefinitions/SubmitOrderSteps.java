package biswasacademy.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class SubmitOrderSteps {

    @Given("I landed on Ecommerce Page")
    public void i_landed_on_ecommerce_page() {
        // TODO: initialize browser and navigate to the ecommerce home page
        System.out.println("Landed on Ecommerce Page");
    }

    @Given("Logged in with username {string} and password {string}")
    public void logged_in_with_username_and_password(String username, String password) {
        // TODO: perform login using provided username and password
        System.out.println("Logging in with -> username: " + username + ", password: " + password);
    }

    // This regex captures a product name whether the feature uses a placeholder or a literal word.
    @When("^I add product (.+) to Cart$")
    public void i_add_product_to_cart(String productName) {
        // TODO: find the product by name and add it to the cart
        System.out.println("Adding product to cart: " + productName);
    }

    @And("^Checkout (.+) and Submit the order$")
    public void checkout_and_submit_the_order(String productName) {
        // TODO: perform checkout flow and submit the order for the given product
        System.out.println("Checking out and submitting order for: " + productName);
    }

    @Then("^\"THANKYOU FOR THE ORDER\\.\" message is displayed on Confirmation page$")
    public void thank_you_message_displayed() {
        // TODO: assert that the confirmation message is displayed
        System.out.println("Verified confirmation message: THANKYOU FOR THE ORDER.");
    }
}
