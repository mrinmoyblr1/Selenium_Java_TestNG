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

    @Test
    public void MobileSignInCarLoan() {
        System.out.println("Hello World from MobileSignInCarLoan");
    }


    @Test
    public void MobileSignOutCarLoan() {
        System.out.println("Hello World from MobileSignOutCarLoan");
    }


    @Test(dependsOnMethods = {"WebLoginCarLoan", "MobileLoginCarLoan"})
    public void APICarLoan() {
        System.out.println("Hello World from LoginAPICarLoan");
    }


}

