package TestNGTutorial;

import org.testng.annotations.*;

public class Day2 {
    @Test(groups = {"Smoke"})
    public void ploan() {
        System.out.println("good");
    }


    @BeforeSuite
    public void beforeSuite() {
        System.out.println("beforeSuite.....I am no 1. I will execute before everything in the suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("afterSuite....I am no 1. I will execute after everything in the suite");
    }


    @BeforeTest
    public void beforeTest() {
        System.out.println("beforeTest....I will execute before all tests within .....<test name=\"Personal Loan\">.....");
        // We can write code here to set up preconditions for the tests
        // such as initializing variables, opening database connections, etc.
        // This method will run once before any test methods in this class are executed
        // similar to @BeforeClass but at the test level
        // useful for setting up configurations needed for the tests
        // in this class
        // Note: If there are multiple classes in the same test suite,
        // this method will run only once before all of them
    }

    @AfterTest
    public void afterTest() {
        System.out.println("afterTest....I will execute after all tests within .....<test name=\"Personal Loan\">.....");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("afterMethod.....I will execute after every method in Day2 class");
    }


    @BeforeMethod
    public void beforeMethod() {
        System.out.println("beforeMethod...I will execute before every method in Day2 class");
    }


    @BeforeClass
    public void beforeClass() {
        System.out.println("beforeClass.....I will execute before all methods in Day2 class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("afterClass.....I will execute after all methods in Day2 class");
    }


    @BeforeGroups
    public void beforeGroups() {
        System.out.println("beforeGroups.....I will execute before all methods in Day2 class");
    }

    @AfterGroups
    public void afterGroups() {
        System.out.println("afterGroups.....I will execute after all methods in Day2 class");
    }


}
