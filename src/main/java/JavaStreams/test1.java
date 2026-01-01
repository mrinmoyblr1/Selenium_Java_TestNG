package JavaStreams;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class test1 {
    // Count the number of Names starts with A
    //@Test
    public void regular() {
        List<String> names = new ArrayList<>();
        names.add("Abhijeet");
        names.add("Don");
        names.add("Ananda");
        names.add("Adam");
        names.add("Rama");
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
        names.add("Ananda");
        names.add("Adam");
        names.add("Rama");
        Long c = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(c);
        // There are no life of intermediate operation if there are no terminal operation
        //Terminal operation will execute only if intermediate operation(filter) will return true
        // We can create a Stream
        // How to use filter in Stream API
        Stream.of("Abhijeet", "Don", "Ananda", "Adam", "Rama").filter(s -> s.startsWith("A")).forEach(System.out::println);
        long d = Stream.of("Abhijeet", "Don", "Ananda", "Adam", "Rama").filter(s ->
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


    @Test
    public void streamMap() {


        List<String> names = new ArrayList<>();
        names.add("man");
        names.add("Don");
        names.add("women");


        // Print the names which has last letter as 'a' with UpperCase
        // We use Map to manipulate any data
        Stream.of("Abhijeet", "Don", "Ananda", "Adam", "Rama").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase()).forEach(System.out::println);
        Stream.of("Abhijeet", "Don", "Ananda", "Adam", "Rama").filter(s -> s.endsWith("a")).map(String::toUpperCase).forEach(System.out::println);


        List<String> names1 = Arrays.asList("Azbhijeet", "Don", "Ananda", "Adam", "Rama");
        // Print names starts with ''a' with UpperCase and in Sorted order
        names1.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase()).forEach(System.out::println);
        names1.stream().filter(s -> s.startsWith("A")).sorted().map(String::toUpperCase).forEach(System.out::println);

        System.out.println("Merging two ArrayList to one ArrayList");
        //Merging two ArrayList to one ArrayList
        Stream<String> newStream = Stream.concat(names1.stream(), names.stream());
        newStream.sorted().forEach(System.out::println);

        System.out.println("Second Approach: Merging two ArrayList to one ArrayList");
        Stream<String> newStream1 = Stream.concat(names1.stream(), names.stream());
        newStream1.sorted().forEach(s -> System.out.println(s));


        Stream<String> newStream2 = Stream.concat(names1.stream(), names.stream());
        boolean flag = newStream2.anyMatch(s -> s.equalsIgnoreCase("Don"));
        Assert.assertTrue(flag);
    }
}
