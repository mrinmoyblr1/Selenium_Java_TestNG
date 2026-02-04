package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/cucumber",
        glue = "biswasacademy.stepDefinitions",
        plugin = {"html:target/cucumber.html"},
        monochrome = true,
        tags = "@ErrorValidation or @Regression"
//        tags = "@ErrorValidation"
)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
