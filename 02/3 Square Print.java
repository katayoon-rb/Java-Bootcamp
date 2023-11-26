import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n;
        String resault = "";

        do { n = scanner.nextInt(); } while (n > 10 || n < 3);

        for (int i = 1; i <= n; i++) {
            resault += "*";
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(resault);
        }
    }
}

