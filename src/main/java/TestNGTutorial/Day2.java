package TestNGTutorial;

import org.testng.annotations.*;

public class Day2 {
    @Test
    public void ploan() {
        System.out.println("good");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("I am no 1. I will execute before everything in the suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("I am no 1. I will execute after everything in the suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("I will execute before all tests within .....<test name=\"Personal Loan\">.....");
        // We can write code here to set up preconditions for the tests
        // such as initializing variables, opening database connections, etc.
        // This method will run once before any test methods in this class are executed
        // similar to @BeforeClass but at the test level
        // useful for setting up configurations needed for the tests
        // in this class
        // Note: If there are multiple classes in the same test suite,
        // this method will run only once before all of them
        // ensuring a clean setup for the tests
        // This is particularly useful for integration tests
        // where you might need to set up a test environment
        // before running the tests
        // It helps in maintaining test isolation and consistency
        // across different test runs
        // making the tests more reliable and easier to debug
        // overall improving the quality of the test suite
        // and the software being tested
    }

    @AfterTest
    public void afterTest() {
        System.out.println("I will execute after all tests within .....<test name=\"Personal Loan\">.....");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("I will execute after every method in Day2 class");
    }

}
