package OOPJava;

import org.testng.annotations.Test;

public class PS1 extends PS {

    @Test
    public void testRun() {
        doThis();
        System.out.println("I'm from child class");
    }

}
