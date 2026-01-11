package biswasacademy.Tests;

import biswasacademy.TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ErrorValidations extends BaseTest {
    @Test
    public void submitOrder() {

        landingPage.loginApplication("mrinmoy.blr@gmail.com", "Anjali@1212");
        Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
        System.out.println("Error message displayed" + ": " + landingPage.getErrorMessage());
    }
}
