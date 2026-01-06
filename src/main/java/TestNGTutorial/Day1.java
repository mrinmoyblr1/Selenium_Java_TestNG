package TestNGTutorial;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Day1 {

    @AfterTest
    public void afterTest() {
        System.out.println("I will execute after all tests within .....<test name=\"Personal Loan\">.....");
    }

    @Test
    public void Demo() {
        System.out.println("Hello");
    }


    @Test
    public void SecondTest() {
        System.out.println("Bye");
    }


}

