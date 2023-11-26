import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n;
        int sum = 0;

        do { n = scanner.nextInt(); } while (n > 200000 || n < 2);

        for (int i = 1; i < n; i++) {
            if (n % i == 0) { sum += i; }
        }

        if (sum == n) { System.out.println("YES"); }
        else { System.out.println("NO"); }
    }
}

