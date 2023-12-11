import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long temp = scanner.nextLong();

        if (temp > 100) { System.out.println("Steam"); }
        else if (temp < 0) { System.out.println("Ice"); }
        else { System.out.println("Water"); }
    }
}