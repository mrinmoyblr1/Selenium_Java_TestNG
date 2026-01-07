package TestNGTutorial;

import org.testng.annotations.Test;

public class Day3 {

    @Test
    public void WebLoginCarLoan() {
        System.out.println("Hello World from WebLoginCarLoan");
    }

    @Test(groups = {"Smoke"})
    public void MobileLoginCarLoan() {
        System.out.println("Hello World from MobileLoginCarLoan");
    }

    // In the below test, enabled is set to false, so this test will be skipped during execution
    // It is usefull when we have a test that is not ready yet and we want to skip it for now
    // We can enable it later by setting enabled to true or removing the attribute
    @Test(enabled = false)
    public void MobileSignInCarLoan() {
        System.out.println("Hello World from MobileSignInCarLoan");
    }


    @Test
    public void MobileSignOutCarLoan() {
        System.out.println("Hello World from MobileSignOutCarLoan");
    }


    // Here @Test is dependent on the successful execution of WebLoginCarLoan method
    // If WebLoginCarLoan fails or is skipped, then APICarLoan will be skipped
    @Test(dependsOnMethods = {"WebLoginCarLoan"})
    public void APICarLoan() {
        System.out.println("Hello World from LoginAPICarLoan");
    }


}

