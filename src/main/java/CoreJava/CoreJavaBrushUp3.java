package CoreJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJavaBrushUp3 {
    public static void main(String[] args) {

        // String literal

//        String s1= "b";
        // Using new memory allocator operator
        String s2 = new String("Welcome");
        String s3 = new String("Welcome");

        String s = "Rahul Shetty Academy";

        System.out.println("=======");

        String[] splittedString = s.split(" ");
        System.out.println(splittedString[0]);
        System.out.println(splittedString[1]);
        System.out.println(splittedString[2]);


        String[] splittedString1 = s.split("Shetty");
        System.out.println(splittedString1[0].trim());
        System.out.println(splittedString1[1].trim());


        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            System.out.println(s.charAt(i));
        }


        for (int i = splittedString.length - 1; i >= 0; i--) {
            System.out.println(splittedString[i]);
        }


    }
}