import java.util.Scanner;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n;
        BigInteger resault = new BigInteger("1");

        do { n = scanner.nextInt();} while (n > 15 || n < 1);

        for (int i = 1; i <= n; i++) {
            resault = resault.multiply(BigInteger.valueOf(i));
        }

        System.out.println(resault);
    }
}

