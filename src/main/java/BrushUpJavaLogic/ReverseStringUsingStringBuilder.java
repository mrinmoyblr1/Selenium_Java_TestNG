package BrushUpJavaLogic;

import java.util.Scanner;

public class ReverseStringUsingStringBuilder {
    public static void main(String[] args) {
        String input;

        // Taking input from command line argument or user input
        if (args.length > 0) {
            input = args[0];
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter string: ");
            input = sc.hasNextLine() ? sc.nextLine() : "";
            sc.close();
        }

        // Printing the reversed string
        System.out.println(reverse(input));
    }

    private static String reverse(String s) {
        if (s == null) return null;
        return new StringBuilder(s).reverse().toString();
    }
}
