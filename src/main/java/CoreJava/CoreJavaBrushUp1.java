package CoreJava;

public class CoreJavaBrushUp1 {
    public static void main(String[] args) {
        int myNum = 5;
        String webSite = "Mrinmoy";
        char letter = 'r';
        double dev = 5.99;
        boolean myCard = true;

        System.out.println("Brush Up 1");
        System.out.println(myNum + " is the values in myNum");
        System.out.println(webSite);
        System.out.println(letter);
        System.out.println(dev);
        System.out.println(myCard);

        // Arrays
        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;

        System.out.println("==================");

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("==================");
        int[] arr2 = {11, 22, 33, 44, 55};
        for (int aa : arr2) {
            System.out.println(aa);
        }
        System.out.println("==================");
        String[] ss = new String[5];
        String[] name = {"Mrinmoy", "Kumar", "Biswas"};

        System.out.println(name[0]);
        System.out.println(name[1]);
        System.out.println(name[2]);

        for (String sss : name) {
            System.out.println(sss);
        }
        System.out.println("==================");


    }
}
