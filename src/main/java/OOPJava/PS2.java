package OOPJava;

import org.testng.annotations.Test;

public class PS2 {
    int a;

    @Test
    public int increment(int a) {
        a=a+1;
        return a;
    }

    @Test
    public int decrement(int a) {
        a=a-1;
        return a;
    }
}
