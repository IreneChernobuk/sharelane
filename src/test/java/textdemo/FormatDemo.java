package textdemo;

public class FormatDemo {
    public static void main(String[] args) {
        String stringFoeDemo = "Text";
        System.out.println(stringFoeDemo + " for Demo");
        String stringFoeDemo2 = "Text %s";
        System.out.println(String.format(stringFoeDemo2, "for Demo 2"));
    }
}
