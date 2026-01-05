package TestNGTutorial;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day2 {
    @Test
    public void ploan() {
        System.out.println("good");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("I will execute before all tests in Day2 class");
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
}
