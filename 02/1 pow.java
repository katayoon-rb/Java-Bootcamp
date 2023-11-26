import java.util.Scanner;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int b;
        int p;
        BigInteger resault = new BigInteger("1");

        do { b = scanner.nextInt(); } while (b > 10 || b < 1);
        do { p = scanner.nextInt(); } while (p > 18 || p < 1);

        for (int i = 1; i <= p; i++) {
            resault = resault.multiply(BigInteger.valueOf(b));
        }
        System.out.println(resault);
    }
}