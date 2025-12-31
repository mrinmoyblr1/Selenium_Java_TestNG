package JavaStreams;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class test1 {
    // Count the number of Names starts with A
    //@Test
    public void regular() {
        List<String> names = new ArrayList<>();
        names.add("Abhijeet");
        names.add("Don");
        names.add("Abnond");
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
        names.add("Abnond");
        names.add("Adam");
        names.add("Ram");
        Long c = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(c);
        // There are no life of intermediate operation if there are no terminal operation
        //Terminal operation will execute only if intermediate operation(filter) will return true
        // We can create a Stream
        // How to use filter in Stream API
        Stream.of("Abhijeet", "Don", "Abnond", "Adam", "Ram").filter(s -> s.startsWith("A")).forEach(System.out::println);
        long d = Stream.of("Abhijeet", "Don", "Abnond", "Adam", "Ram").filter(s ->
        {
            s.startsWith("D");
            return true;
        }).count();
        System.out.println("============");
        System.out.println(d);
        System.out.println("============");
        // Print all the names of ArrayList
        // Printing names with length > 4
        // We can use either of below options. But in case of 1st option, Lambda can be replaced by method reference as 2nd option
        names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
        names.stream().filter(s -> s.length() > 4).forEach(System.out::println);
        // Printing only 1st result using either of two options
        names.stream().filter(s -> s.length() > 4).findFirst().ifPresent(System.out::println);
        names.stream().filter(s -> s.length() > 4).limit(1).forEach(System.out::println);
    }
}
