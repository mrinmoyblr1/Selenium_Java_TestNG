package biswasacademy.stepDefinitions;

import biswasacademy.TestComponents.BaseTest;
import biswasacademy.pageObjects.LandingPage;
import io.cucumber.java.en.Given;

import java.io.IOException;

public class StepDefinitionsImp extends BaseTest {
    public LandingPage landingPage;


    @Given("I landed on Ecommerce Page")
    public void I_landed_on_Ecommerce_Page() throws IOException {
        landingPage = launchApplication();

    }
}
