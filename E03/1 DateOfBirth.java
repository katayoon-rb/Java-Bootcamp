import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.next();

        String saal = num.substring(0, 2);
        String maah = num.substring(2, 4);

        System.out.println("saal:" + saal);
        System.out.println("maah:" + maah);
    }
}