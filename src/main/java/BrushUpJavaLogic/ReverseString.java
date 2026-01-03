package BrushUpJavaLogic;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
//        String input = "Hello World";
        String input;

        if (args.length > 0) {
            input = args[0];
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter string: ");
            input = sc.hasNextLine() ? sc.nextLine() : "";
            sc.close();
        }


        System.out.println(reverse(input));
    }

    private static String reverse(String s) {
        if (s == null) return null;
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
        return new String(chars);
    }
}
