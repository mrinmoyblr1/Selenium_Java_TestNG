package BrushUpJavaLogic;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        int year;
        if (args.length > 0) {
            try {
                year = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Invalid year: " + args[0]);
                return;
            }
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter year: ");
            if (!sc.hasNextInt()) {
                System.err.println("Invalid input");
                sc.close();
                return;
            }
            year = sc.nextInt();
            sc.close();
        }

        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        System.out.println(year + (isLeap ? " is a leap year." : " is not a leap year."));
    }
}
