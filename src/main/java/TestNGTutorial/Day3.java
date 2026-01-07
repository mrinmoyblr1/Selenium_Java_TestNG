package TestNGTutorial;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day3 {

    @Parameters({"URL"})
    @Test
    public void WebLoginCarLoan(String urlName) {
        System.out.println("Hello World from WebLoginCarLoan");
        System.out.println(urlName);
    }

    // Here in below @Test is tagged with groups attribute
    // This means that this test belongs to the "Smoke" group
    // We can run this specific group of tests using TestNG XML suite configuration
    // Or using command line using -groups option
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

    // In the below test, timeOut is set to 4000 milliseconds, so if this test takes more than 4 seconds to execute, it will be marked as failed
    @Test(timeOut = 4000)
    public void MobileSignOutCarLoan() {
        System.out.println("Hello World from MobileSignOutCarLoan");

    }

    // Here @Test is dependent on the successful execution of WebLoginCarLoan method
    // If WebLoginCarLoan fails or is skipped, then APICarLoan will be skipped
    @Test(dependsOnMethods = {"WebLoginCarLoan"})
    public void APICarLoan() {
        System.out.println("Hello World from LoginAPICarLoan");
    }

    //Parameterization in TestNG
    // In case of Parameterization, we can pass the values from testng.xml file
    // Username, Password, API keys, etc. all kinds of common values we can pass from testng.xml file


    @DataProvider(name = "data")
    public Object[][] getData() {
        // 1st combination: Username and Password - good credit history
        // 2nd combination: Username and Password - no credit history
        // 3rd combination: Username and Password - fraudulent credit history

        Object[][] data = new Object[3][2];
        // 1st set
        data[0][0] = "username1";
        data[0][1] = "password1";
        // 2nd set
        data[1][0] = "username2";
        data[1][1] = "password2";
        // 3rd set
        data[2][0] = "username3";
        data[2][1] = "password3";
        System.out.println(data.length);
        return data;


//        return new Object[][]{{"https://www.google.com"}};
    }


}
