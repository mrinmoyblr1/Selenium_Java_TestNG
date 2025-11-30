package CoreJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJavaBrushUp2 {
    public static void main(String[] args) {

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 122, 2};
        // Check if array has multiple of 2

        for (int aa : arr2) {
            if (aa % 2 == 0) {
                System.out.println(aa);
                break;
            } else {
                System.out.println(aa + " This is not multiple by 2");
            }
        }


        //========
        System.out.println("=========================");
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int aa : numbers) {
            System.out.println(aa);
        }

        System.out.println(numbers[0]);
        System.out.println(numbers[numbers.length - 1]);

        for (int i = numbers.length; i > 0; i--) {
            System.out.println(i);
        }

        System.out.println("======================Array List======================");
        // ArrayList
        ArrayList<String> list = new ArrayList<>();
        list.add("Mrinmoy");
        list.add("Kumar");
        list.add("Biswas");
        list.add("Mrinmoy11");

        System.out.println(list);

        list.remove("Mrinmoy11");
        System.out.println(list);
        System.out.println(list.get(2));


        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("********************************");
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println(list.isEmpty());
        System.out.println(list.contains("Mrinmoy"));

// To convert Array to ArrayList as below:
        String[] name = {"Mrinmoy", "Kumar", "Biswas"};
        List<String> nameArrayList = Arrays.asList(name);

        System.out.println(nameArrayList.contains("Mrinmoy"));


    }
}