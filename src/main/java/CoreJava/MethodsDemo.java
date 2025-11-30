package CoreJava;

public class MethodsDemo {
    public static void main(String[] args) {
        MethodsDemo md = new MethodsDemo();
        System.out.println(md.getData());

        MethodsDemo2 md2 = new MethodsDemo2();
        md2.getUserData();
        getData2();
    }


    public String getData() {
        System.out.println("Hello World");
        return "Mrinmoy Biswas";
    }


    public static String getData2() {
        System.out.println("Hello World");
        return "Mrinmoy Biswas";
    }


}
