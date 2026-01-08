package OOPJava;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PS {

    @Test
    public void doThis() {
        System.out.println("I'm here from parent class");
    }

    @BeforeMethod
    public void beforeRun() {
        System.out.println("Run me first");
    }


}
