package JavaStreams;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class test1 {
    // Count the number of Names starts with A
    //@Test
    public void regular() {
        List<String> names = new ArrayList<>();
        names.add("Abhijeet");
        names.add("Don");
        names.add("Ab");
        names.add("Adam");
        names.add("Ram");
        int count = 0;

        for (int i = 0; i < names.size(); i++) {
            String actual = names.get(i);
            if (actual.startsWith("A")) {
                count++;
            }
        }

        System.out.println(count);
    }


    @Test
    public void streamFilter() {
        List<String> names = new ArrayList<>();
        names.add("Abhijeet");
        names.add("Don");
        names.add("Ab");
        names.add("Adam");
        names.add("Ram");

        Long c = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(c);


    }


}


