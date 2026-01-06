package TestNGTutorial;

import org.testng.annotations.Test;

public class Day4 {

    @Test
    public void WebLoginHomeLoan() {
        System.out.println("Hello World from WebLoginHomeLoan");
    }

    @Test(groups = {"Smoke"})
    public void MobileLoginHomeLoan() {
        System.out.println("Hello World from MobileLoginHomeLoan");
    }

    @Test
    public void LoginAPIHomeLoan() {
        System.out.println("Hello World from LoginAPIHomeLoan");
    }


}

